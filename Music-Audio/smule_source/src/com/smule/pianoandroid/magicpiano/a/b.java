// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import com.j256.ormlite.dao.Dao;
import com.smule.android.console.n;
import com.smule.android.console.o;
import com.smule.pianoandroid.a.u;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.AchievementGoal;
import com.smule.pianoandroid.data.model.AchievementGoalState;
import com.smule.pianoandroid.data.model.AchievementState;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.e.a;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class b
    implements n
{

    public b()
    {
    }

    private String a(AchievementDefinition achievementdefinition)
    {
        Object obj;
        StringBuilder stringbuilder;
        AchievementGoalState achievementgoalstate;
        Object obj1 = achievementdefinition.state;
        obj = "inactive";
        Iterator iterator;
        if (((AchievementState) (obj1)).claimed)
        {
            obj = "claimed";
        } else
        if (((AchievementState) (obj1)).completed)
        {
            obj = "completed";
        } else
        if (((AchievementState) (obj1)).started)
        {
            obj = "started";
        }
        stringbuilder = new StringBuilder((new StringBuilder()).append("  ").append(((AchievementState) (obj1)).definitionId).append(": ").append(((String) (obj))).append("\n").toString());
        obj1 = ((AchievementState) (obj1)).goals.iterator();
_L2:
        if (!((Iterator) (obj1)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        achievementgoalstate = (AchievementGoalState)((Iterator) (obj1)).next();
        iterator = achievementdefinition.goals.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_280;
            }
            obj = (AchievementGoal)iterator.next();
        } while (!((AchievementGoal) (obj)).id.equals(achievementgoalstate.goalId));
_L3:
        if (obj == null)
        {
            stringbuilder.append((new StringBuilder()).append("    ").append(achievementgoalstate.goalId).append(": not found!\n").toString());
        } else
        {
            stringbuilder.append((new StringBuilder()).append("    ").append(achievementgoalstate.goalId).append(": ").append(achievementgoalstate.progress).append(" of ").append(((AchievementGoal) (obj)).threshold).append("\n").toString());
        }
        if (true) goto _L2; else goto _L1
_L1:
        return stringbuilder.toString();
        obj = null;
          goto _L3
    }

    public String a()
    {
        return "ach";
    }

    public String a(String as[])
    {
        Object obj1;
        if (as == null || as.length <= 1)
        {
            break MISSING_BLOCK_LABEL_620;
        }
        obj1 = as[1];
        Object obj;
        obj = com.smule.pianoandroid.e.a.a();
        if (!((String) (obj1)).equals("unclaim"))
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (as.length != 3)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj1 = ((a) (obj)).c(as[2]);
        ((AchievementDefinition) (obj1)).state.claimed = false;
        ((a) (obj)).a(((AchievementDefinition) (obj1)));
        return "Achievement unclaimed";
        return o.a(this);
        if (!((String) (obj1)).equals("uncomplete"))
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (as.length != 3)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj1 = ((a) (obj)).c(as[2]);
        ((AchievementDefinition) (obj1)).state.claimed = false;
        ((AchievementDefinition) (obj1)).state.completed = false;
        ((a) (obj)).a(((AchievementDefinition) (obj1)));
        return "Achievement uncompleted";
        return o.a(this);
        if (!((String) (obj1)).equals("complete"))
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (as.length != 3)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        obj1 = ((a) (obj)).c(as[2]);
        ((AchievementDefinition) (obj1)).state.completed = true;
        ((AchievementDefinition) (obj1)).state.claimed = false;
        ((a) (obj)).a(((AchievementDefinition) (obj1)));
        return "Achievement completed";
        return o.a(this);
        if (!((String) (obj1)).equals("resetall"))
        {
            break MISSING_BLOCK_LABEL_182;
        }
        ((a) (obj)).f();
        return "All achievements reset";
        if (!((String) (obj1)).equals("reset"))
        {
            break MISSING_BLOCK_LABEL_216;
        }
        if (as.length != 3)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        ((a) (obj)).b(((a) (obj)).c(as[2]));
        return "Achievement reset";
        return o.a(this);
        if (!((String) (obj1)).equals("defs"))
        {
            break MISSING_BLOCK_LABEL_533;
        }
        obj = new StringBuilder("Achievement defs\n");
        obj1 = u.d().queryForAll();
        ((StringBuilder) (obj)).append((new StringBuilder()).append("Total ").append(((List) (obj1)).size()).append("\n").toString());
        obj1 = ((List) (obj1)).iterator();
_L1:
        Object obj2;
        String s;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_528;
        }
        obj2 = (AchievementDefinition)((Iterator) (obj1)).next();
        ((StringBuilder) (obj)).append((new StringBuilder()).append(((AchievementDefinition) (obj2)).uid).append(" - ").append(((AchievementDefinition) (obj2)).title).append("(").append(((AchievementDefinition) (obj2)).awardXp).append(")\n").toString());
        s = ((AchievementDefinition) (obj2)).getDescription();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        ((StringBuilder) (obj)).append(s);
        if (((AchievementDefinition) (obj2)).rewards == null || ((AchievementDefinition) (obj2)).rewards.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_518;
        }
        obj2 = ((AchievementDefinition) (obj2)).rewards.iterator();
        while (((Iterator) (obj2)).hasNext()) 
        {
            GameReward gamereward = (GameReward)((Iterator) (obj2)).next();
            ((StringBuilder) (obj)).append((new StringBuilder()).append("type: ").append(gamereward.type).append(" amount: ").append(gamereward.amount).append(" value:").append(gamereward.value).append("\n").toString());
        }
          goto _L1
        try
        {
            ((StringBuilder) (obj)).append("No rewards.");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return (new StringBuilder()).append("Failed to execute ").append(as[0]).toString();
        }
          goto _L1
        return ((StringBuilder) (obj)).toString();
        if (!((String) (obj1)).equals("dump"))
        {
            break MISSING_BLOCK_LABEL_613;
        }
        if (as.length == 3)
        {
            return a(((a) (obj)).c(as[2]));
        }
        obj1 = new StringBuilder();
        for (obj = ((a) (obj)).c().iterator(); ((Iterator) (obj)).hasNext(); ((StringBuilder) (obj1)).append(a((AchievementDefinition)((Iterator) (obj)).next()))) { }
        return ((StringBuilder) (obj1)).toString();
        obj = o.a(this);
        return ((String) (obj));
        return o.a(this);
    }
}
