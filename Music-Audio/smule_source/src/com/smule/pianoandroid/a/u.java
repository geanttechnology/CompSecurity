// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.AchievementGoal;
import com.smule.pianoandroid.data.model.AchievementGoalState;
import com.smule.pianoandroid.data.model.AchievementState;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.data.model.LevelConfig;
import com.smule.pianoandroid.e.c;
import java.sql.SQLException;

public class u
{

    public static OrmLiteSqliteOpenHelper a()
    {
        return com.smule.pianoandroid.e.c.a().b();
    }

    private static Dao a(Class class1)
    {
        try
        {
            class1 = a().getDao(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RuntimeException("Failed to get DB DAO", class1);
        }
        return class1;
    }

    public static Dao b()
    {
        return a(com/smule/pianoandroid/data/model/GameReward);
    }

    public static Dao c()
    {
        return a(com/smule/pianoandroid/data/model/AchievementGoal);
    }

    public static Dao d()
    {
        return a(com/smule/pianoandroid/data/model/AchievementDefinition);
    }

    public static Dao e()
    {
        return a(com/smule/pianoandroid/data/model/LevelConfig);
    }

    public static Dao f()
    {
        return a(com/smule/pianoandroid/data/model/AchievementGoalState);
    }

    public static Dao g()
    {
        return a(com/smule/pianoandroid/data/model/AchievementState);
    }
}
