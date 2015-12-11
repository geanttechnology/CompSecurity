// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import com.smule.android.network.managers.ak;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.smule.pianoandroid.data.model:
//            AchievementState

public class AchievementGoalState
{

    public static final String COLUMN_ACHIEVEMENT_STATE = "achievement";
    public static final String COLUMN_COMPLETED = "completed";
    public static final String COLUMN_GOAL_ID = "goalId";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PROGRESS = "progress";
    public static final String COLUMN_UNIQUES = "uniques";
    public int _id;
    public AchievementState achievement;
    public boolean completed;
    public String goalId;
    public int progress;
    public HashSet uniques;

    public AchievementGoalState()
    {
    }

    public void migrateV1Uniques()
    {
        HashSet hashset = new HashSet();
        if (uniques == null)
        {
            return;
        }
        Iterator iterator = uniques.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!s.startsWith("_"))
            {
                String s1 = ak.a().k(s);
                if (!s1.equals(s))
                {
                    iterator.remove();
                    hashset.add(s1);
                }
            }
        } while (true);
        uniques.addAll(hashset);
    }
}
