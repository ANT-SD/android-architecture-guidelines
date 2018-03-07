package team.ant.architectureguides.domain;

import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Nacho Vazquez on 3/7/2018.
 */

public abstract class BaseEntity<T> {
    @PrimaryKey
    private T id;



}
