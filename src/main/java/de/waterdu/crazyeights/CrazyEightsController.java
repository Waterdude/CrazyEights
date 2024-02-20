package de.waterdu.crazyeights;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CrazyEightsController {

    @FXML
    public TextField oppo;

    @FXML
    public TextField your;

    @FXML
    public Button calc;

    @FXML
    public Button reset;

    @FXML
    protected void onReset() {
        this.your.setText("");
        this.oppo.setText("");
    }

    @FXML
    protected void onCalculate() {
        List<Integer> yourValues = new ArrayList<>();
        List<Integer> oppoValues = new ArrayList<>();
        Map<Integer, List<Integer>> yourMap = new HashMap<>();
        Map<Integer, List<Integer>> oppoMap = new HashMap<>();

        for(String split : this.your.getText().split(" ")) {
            yourValues.add(Integer.parseInt(split));
        }
        for(String split : this.oppo.getText().split(" ")) {
            oppoValues.add(Integer.parseInt(split));
        }

        this.sum(yourValues, 0, 0, new ArrayList<>(), yourMap);
        this.sum(oppoValues, 0, 0, new ArrayList<>(), oppoMap);

        for(Map.Entry<Integer, List<Integer>> you : yourMap.entrySet()) {
            for(Map.Entry<Integer, List<Integer>> opp : oppoMap.entrySet()) {
                if(Objects.equals(you.getKey(), opp.getKey())) {
                    String oppoText = "";
                    for(int value : opp.getValue()) {
                        oppoText += value + " ";
                    }
                    String yourText = "";
                    for(int value : you.getValue()) {
                        yourText += value + " ";
                    }
                    this.oppo.setText(oppoText);
                    this.your.setText(yourText);
                    return;
                }
            }
        }
    }

    protected void sum(List<Integer> list, int start, int sum, List<Integer> used, Map<Integer, List<Integer>> results) {
        if(list.size() == start) {
            return;
        }
        int add = list.get(start);
        int val = sum + add;
        List<Integer> withAdd = new ArrayList<>(used);
        withAdd.add(add);
        results.put(val, withAdd);
        this.sum(list, start + 1, sum, used, results);
        this.sum(list, start + 1, val, withAdd, results);
    }
}