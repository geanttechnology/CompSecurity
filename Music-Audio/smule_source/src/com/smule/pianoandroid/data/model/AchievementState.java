// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j256.ormlite.dao.Dao;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import com.smule.pianoandroid.a.u;
import com.smule.pianoandroid.data.db.CascadableEntity;
import com.smule.pianoandroid.e.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.data.model:
//            AchievementDefinition, AchievementGoalState, AchievementGoal

public class AchievementState
    implements CascadableEntity
{

    public static final String COLUMN_CLAIMED = "claimed";
    public static final String COLUMN_COMPLETED = "completed";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_STARTED = "started";
    public static final String COLUMN_UID = "definitionId";
    public static final String TAG = com/smule/pianoandroid/data/model/AchievementState.getSimpleName();
    public int _id;
    public boolean claimed;
    public boolean completed;
    public String definitionId;
    public long displayedAt;
    public Collection goals;
    private AchievementDefinition mAchievementDefinition;
    public boolean started;

    public AchievementState()
    {
        started = false;
        completed = false;
        claimed = false;
        mAchievementDefinition = null;
    }

    public static AchievementState build(AchievementDefinition achievementdefinition)
    {
        AchievementState achievementstate = new AchievementState();
        achievementstate.definitionId = achievementdefinition.uid;
        if (achievementdefinition.goals != null)
        {
            achievementstate.goals = new ArrayList(achievementdefinition.goals.size());
        }
        return achievementstate;
    }

    public static AchievementState fromJson(JsonNode jsonnode)
    {
        if (jsonnode.has("progress"))
        {
            AchievementState achievementstate = new AchievementState();
            achievementstate.definitionId = jsonnode.get("achievementId").asText();
            achievementstate.completed = jsonnode.get("complete").asBoolean();
            achievementstate.claimed = jsonnode.get("claim").asBoolean();
            if (!achievementstate.completed && achievementstate.claimed)
            {
                achievementstate.claimed = false;
            }
            jsonnode = jsonnode.get("progress").asText();
            try
            {
                jsonnode = e.a().readTree(jsonnode);
            }
            // Misplaced declaration of an exception variable
            catch (JsonNode jsonnode)
            {
                aa.b(TAG, (new StringBuilder()).append("Failed to parse goal progress from server for achievement ").append(achievementstate.definitionId).toString());
                return null;
            }
            if (jsonnode.has("goals"))
            {
                jsonnode = jsonnode.get("goals");
                achievementstate.goals = new ArrayList();
                for (jsonnode = jsonnode.iterator(); jsonnode.hasNext();)
                {
                    Object obj = (JsonNode)jsonnode.next();
                    try
                    {
                        obj = (AchievementGoalState)e.a().treeToValue(((com.fasterxml.jackson.core.TreeNode) (obj)), com/smule/pianoandroid/data/model/AchievementGoalState);
                        if (((AchievementGoalState) (obj)).uniques != null && ((AchievementGoalState) (obj)).uniques.size() > 0)
                        {
                            ((AchievementGoalState) (obj)).migrateV1Uniques();
                        }
                        achievementstate.goals.add(obj);
                    }
                    catch (IOException ioexception)
                    {
                        aa.b(TAG, (new StringBuilder()).append("Failed to parse goal state from server! Achievement : ").append(achievementstate.definitionId).toString());
                    }
                }

                return achievementstate;
            }
        }
        return null;
    }

    public boolean checkCompletion()
    {
        if (completed)
        {
            return true;
        }
        AchievementDefinition achievementdefinition = a.a().c(definitionId);
        Map map = getGoalStateMap();
        Iterator iterator = achievementdefinition.goals.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AchievementGoal achievementgoal = (AchievementGoal)iterator.next();
            AchievementGoalState achievementgoalstate = (AchievementGoalState)map.get(achievementgoal.id);
            if (achievementgoalstate == null || achievementgoalstate.progress < achievementgoal.threshold)
            {
                return false;
            }
            if (!achievementgoalstate.completed)
            {
                achievementgoalstate.completed = true;
            }
        } while (true);
        completed = true;
        claimed = false;
        a.a().a(achievementdefinition);
        return true;
    }

    public void copyLocal(AchievementState achievementstate)
    {
        _id = achievementstate._id;
    }

    public volatile void copyLocal(Object obj)
    {
        copyLocal((AchievementState)obj);
    }

    public void display()
    {
        displayedAt = System.currentTimeMillis();
    }

    public String equatableId()
    {
        return definitionId;
    }

    public int getCompletionPercent()
    {
        if (completed)
        {
            return 100;
        }
        Iterator iterator = getDefinition().goals.iterator();
        int i = 0;
        int j = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AchievementGoal achievementgoal = (AchievementGoal)iterator.next();
            AchievementGoalState achievementgoalstate = (AchievementGoalState)getGoalStateMap().get(achievementgoal.id);
            j += achievementgoal.threshold;
            if (achievementgoalstate != null)
            {
                i = achievementgoalstate.progress + i;
            }
        } while (true);
        return (i * 100) / j;
    }

    public AchievementDefinition getDefinition()
    {
        if (mAchievementDefinition != null)
        {
            return mAchievementDefinition;
        }
        if (definitionId == null)
        {
            return null;
        } else
        {
            AchievementDefinition achievementdefinition = a.a().c(definitionId);
            mAchievementDefinition = achievementdefinition;
            return achievementdefinition;
        }
    }

    public Map getGoalStateMap()
    {
        HashMap hashmap = new HashMap();
        AchievementGoalState achievementgoalstate;
        for (Iterator iterator = goals.iterator(); iterator.hasNext(); hashmap.put(achievementgoalstate.goalId, achievementgoalstate))
        {
            achievementgoalstate = (AchievementGoalState)iterator.next();
        }

        return hashmap;
    }

    public void postCreate()
    {
        Dao dao = u.f();
        if (goals != null)
        {
            AchievementGoalState achievementgoalstate;
            for (Iterator iterator = goals.iterator(); iterator.hasNext(); dao.create(achievementgoalstate))
            {
                achievementgoalstate = (AchievementGoalState)iterator.next();
                achievementgoalstate.achievement = this;
            }

        }
    }

    public void postUpdate()
    {
    }

    public void preDelete()
    {
        Dao dao = u.f();
        if (goals != null)
        {
            dao.delete(goals);
        }
    }

    public boolean shouldBeDeleted()
    {
        return true;
    }

}
