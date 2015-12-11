// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.smule.android.c.aa;
import com.smule.pianoandroid.a.u;
import com.smule.pianoandroid.data.db.CascadableEntity;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.smule.pianoandroid.data.model:
//            GameReward, AchievementState

public class LevelConfig
    implements CascadableEntity
{

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_REWARDS = "rewards";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_XP = "xp";
    private static final String TAG = com/smule/pianoandroid/data/model/LevelConfig.getName();
    private static ObjectMapper sObjectMapper;
    public int _id;
    public int level;
    public Collection rewards;
    public AchievementState state;
    String title;
    public long xp;

    public LevelConfig()
    {
    }

    public void copyLocal(LevelConfig levelconfig)
    {
        _id = levelconfig._id;
    }

    public volatile void copyLocal(Object obj)
    {
        copyLocal((LevelConfig)obj);
    }

    public String equatableId()
    {
        return String.valueOf(level);
    }

    public void postCreate()
    {
        Dao dao = u.b();
        GameReward gamereward;
        for (Iterator iterator = rewards.iterator(); iterator.hasNext(); dao.create(gamereward))
        {
            gamereward = (GameReward)iterator.next();
            gamereward.level = this;
        }

    }

    public void postUpdate()
    {
        Dao dao = u.b();
        DeleteBuilder deletebuilder = dao.deleteBuilder();
        deletebuilder.where().eq("level", Integer.valueOf(_id));
        dao.delete(deletebuilder.prepare());
        GameReward gamereward;
        for (Iterator iterator = rewards.iterator(); iterator.hasNext(); dao.create(gamereward))
        {
            gamereward = (GameReward)iterator.next();
            gamereward.level = this;
        }

    }

    public void preDelete()
    {
        u.b().delete(rewards);
    }

    public boolean shouldBeDeleted()
    {
        return true;
    }

    public String toJson()
    {
        String s;
        try
        {
            s = sObjectMapper.writeValueAsString(this);
        }
        catch (JsonProcessingException jsonprocessingexception)
        {
            aa.b(TAG, "Error serializing to JSON", jsonprocessingexception);
            return null;
        }
        return s;
    }

    static 
    {
        sObjectMapper = new ObjectMapper();
        sObjectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }
}
