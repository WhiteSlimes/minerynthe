package fr.kujaku.minerynthe.mineryntheplugin.utils;

import lombok.Getter;
import java.util.ArrayList;

public class DifficultyInfo {


    @Getter
    public String difficulty;

    @Getter
    public static ArrayList<DifficultyInfo> instanceList = new ArrayList<>();

    public DifficultyInfo(String difficulty){
        this.difficulty = difficulty;

        if (!instanceList.contains(this))
            instanceList.add(this);
    }

    public void setDifficulty(String diff){
        difficulty = diff;
    }
    public String getDifficulty() {
        return difficulty;
    }

    public static DifficultyInfo getDifficultyInfo(String diff){
        return (DifficultyInfo) instanceList.stream();
    }

}
