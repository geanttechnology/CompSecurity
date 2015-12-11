// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import com.smule.pianoandroid.a.u;
import com.smule.pianoandroid.data.db.CascadableEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.smule.pianoandroid.data.model:
//            AchievementGoal, GameReward, AchievementState

public class AchievementDefinition
    implements CascadableEntity
{

    public static final String COLUMN_AWARD_XP = "xp";
    public static final String COLUMN_BADGE_URL = "badgeUrl";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ORDER = "order";
    public static final String COLUMN_REWARDS = "rewards";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_UID = "achievementId";
    private static final String TAG = com/smule/pianoandroid/data/model/AchievementDefinition.getSimpleName();
    private static ObjectMapper sObjectMapper;
    public int _id;
    public int awardXp;
    public String badgeUrl;
    public HashMap goalDictionary;
    public Collection goals;
    public int order;
    public Collection rewards;
    public AchievementState state;
    public String title;
    public String uid;

    public AchievementDefinition()
    {
    }

    public static AchievementDefinition fromJson(JsonNode jsonnode)
    {
        AchievementDefinition achievementdefinition = (AchievementDefinition)e.a(jsonnode, com/smule/pianoandroid/data/model/AchievementDefinition);
        achievementdefinition.goals = new ArrayList();
        if (jsonnode.has("goals"))
        {
            jsonnode = jsonnode.get("goals").asText();
            Iterator iterator;
            AchievementGoal achievementgoal;
            try
            {
                jsonnode = (Map)sObjectMapper.readValue(jsonnode, java/util/Map);
            }
            // Misplaced declaration of an exception variable
            catch (JsonNode jsonnode)
            {
                aa.d(TAG, "Failed to parse JSON entity ", jsonnode);
                throw new RuntimeException("Failed to parse JSON entity ", jsonnode);
            }
            for (iterator = jsonnode.keySet().iterator(); iterator.hasNext(); achievementdefinition.goals.add(achievementgoal))
            {
                String s = (String)iterator.next();
                Map map = (Map)jsonnode.get(s);
                achievementgoal = (AchievementGoal)sObjectMapper.convertValue(map, com/smule/pianoandroid/data/model/AchievementGoal);
                achievementgoal.setConditionMap((Map)map.get("condition"));
                achievementgoal.id = s;
            }

        }
        return achievementdefinition;
    }

    public static AchievementDefinition fromJson(String s)
    {
        AchievementDefinition achievementdefinition;
        Object obj;
        obj = sObjectMapper.readTree(s);
        achievementdefinition = (AchievementDefinition)sObjectMapper.readValue(s, com/smule/pianoandroid/data/model/AchievementDefinition);
        achievementdefinition.goals = new ArrayList();
        s = achievementdefinition;
        if (!((JsonNode) (obj)).has("goals")) goto _L2; else goto _L1
_L1:
        obj = ((JsonNode) (obj)).get("goals").iterator();
_L3:
        s = achievementdefinition;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (JsonNode)((Iterator) (obj)).next();
        achievementdefinition.goals.add(e.a(s, com/smule/pianoandroid/data/model/AchievementGoal));
        if (true) goto _L3; else goto _L2
        s;
        aa.b(TAG, "Failed to parse achievement ", s);
        s = null;
_L2:
        return s;
    }

    public void copyLocal(AchievementDefinition achievementdefinition)
    {
        _id = achievementdefinition._id;
    }

    public volatile void copyLocal(Object obj)
    {
        copyLocal((AchievementDefinition)obj);
    }

    public String equatableId()
    {
        return uid;
    }

    public String getDescription()
    {
label0:
        {
            if (goals == null)
            {
                break label0;
            }
            Iterator iterator = goals.iterator();
            AchievementGoal achievementgoal;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                achievementgoal = (AchievementGoal)iterator.next();
            } while (achievementgoal.description == null || achievementgoal.description.length() <= 0);
            return achievementgoal.description;
        }
        return title;
    }

    public void postCreate()
    {
        Dao dao = u.b();
        GameReward gamereward;
        for (Iterator iterator = rewards.iterator(); iterator.hasNext(); dao.create(gamereward))
        {
            gamereward = (GameReward)iterator.next();
            gamereward.achievement = this;
        }

        dao = u.c();
        AchievementGoal achievementgoal;
        for (Iterator iterator1 = goals.iterator(); iterator1.hasNext(); dao.create(achievementgoal))
        {
            achievementgoal = (AchievementGoal)iterator1.next();
            achievementgoal.achievement = this;
        }

    }

    public void postUpdate()
    {
        Object obj = u.b();
        Dao dao = u.c();
        DeleteBuilder deletebuilder = ((Dao) (obj)).deleteBuilder();
        deletebuilder.where().eq("achievement", Integer.valueOf(_id));
        ((Dao) (obj)).delete(deletebuilder.prepare());
        GameReward gamereward;
        for (Iterator iterator1 = rewards.iterator(); iterator1.hasNext(); ((Dao) (obj)).create(gamereward))
        {
            gamereward = (GameReward)iterator1.next();
            gamereward.achievement = this;
        }

        obj = dao.deleteBuilder();
        ((DeleteBuilder) (obj)).where().eq("achievement", Integer.valueOf(_id));
        dao.delete(((DeleteBuilder) (obj)).prepare());
        AchievementGoal achievementgoal;
        for (Iterator iterator = goals.iterator(); iterator.hasNext(); dao.create(achievementgoal))
        {
            achievementgoal = (AchievementGoal)iterator.next();
            achievementgoal.achievement = this;
        }

    }

    public void preDelete()
    {
        u.b().delete(rewards);
        u.c().delete(goals);
    }

    public boolean shouldBeDeleted()
    {
        return true;
    }

    public String toJson()
    {
        Object obj;
        try
        {
            obj = new StringBuilder();
            ((StringBuilder) (obj)).append((new StringBuilder()).append("{ \"title\":").append(sObjectMapper.writeValueAsString(title)).append(",").toString());
            ((StringBuilder) (obj)).append((new StringBuilder()).append("  \"badgeUrl\":").append(sObjectMapper.writeValueAsString(badgeUrl)).append(",").toString());
            ((StringBuilder) (obj)).append((new StringBuilder()).append("  \"state\":").append(sObjectMapper.writeValueAsString(state)).append(",").toString());
            ((StringBuilder) (obj)).append((new StringBuilder()).append("  \"achievementId\":").append(sObjectMapper.writeValueAsString(uid)).append(",").toString());
            ((StringBuilder) (obj)).append((new StringBuilder()).append("  \"rewards\":").append(sObjectMapper.writeValueAsString(rewards)).append(",").toString());
            ((StringBuilder) (obj)).append((new StringBuilder()).append("  \"order\":").append(sObjectMapper.writeValueAsString(Integer.valueOf(order))).append(",").toString());
            ((StringBuilder) (obj)).append((new StringBuilder()).append("  \"xp\":").append(sObjectMapper.writeValueAsString(Integer.valueOf(awardXp))).append(",").toString());
            ((StringBuilder) (obj)).append((new StringBuilder()).append("  \"order\":").append(sObjectMapper.writeValueAsString(Integer.valueOf(order))).append(",").toString());
            ((StringBuilder) (obj)).append((new StringBuilder()).append("  \"goals\":").append(sObjectMapper.writeValueAsString(goals)).append(" }").toString());
            obj = ((StringBuilder) (obj)).toString();
        }
        catch (JsonProcessingException jsonprocessingexception)
        {
            aa.b(TAG, "Error serializing to JSON", jsonprocessingexception);
            return null;
        }
        return ((String) (obj));
    }

    static 
    {
        sObjectMapper = new ObjectMapper();
        sObjectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }
}
