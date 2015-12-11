// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.f.e;
import java.io.IOException;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.data.model:
//            AchievementDefinition

public class AchievementGoal
{

    public static final String COLUMN_ACHIEVEMENT = "achievement";
    public static final String COLUMN_CONDITION = "condition";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_EVENT_TYPE = "event_type";
    public static final String COLUMN_EVENT_TYPE_JSON = "eventType";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_STR_ID = "id";
    public static final String COLUMN_THRESHOLD = "threshold";
    public static final String COLUMN_UNIQUE_KEY = "unique_key";
    public static final String COLUMN_UNIQUE_KEY_JSON = "uniqueKey";
    public static final String COLUMN_URL = "url";
    public int _id;
    public AchievementDefinition achievement;
    public String conditionJson;
    private Map conditionMap;
    public String description;
    public String eventType;
    public String id;
    public int threshold;
    public String uniqueKey;
    public String url;

    public AchievementGoal()
    {
    }

    public Map getConditionMap()
    {
        if (conditionMap == null)
        {
            ObjectMapper objectmapper = e.a();
            try
            {
                conditionMap = (Map)objectmapper.readValue(conditionJson, java/util/Map);
            }
            catch (IOException ioexception)
            {
                throw new RuntimeException("Failed to parse condition JSON.", ioexception);
            }
        }
        return conditionMap;
    }

    public void setConditionMap(Map map)
    {
        ObjectMapper objectmapper = e.a();
        try
        {
            conditionJson = objectmapper.writeValueAsString(map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException((new StringBuilder()).append("Failed to serialize goal condition. Goal ").append(id).toString(), map);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("AchievementGoal{_id=").append(_id).append(", eventType='").append(eventType).append('\'').append(", id='").append(id).append('\'').append(", description='").append(description).append('\'').append(", threshold=").append(threshold).append(", uniqueKey='").append(uniqueKey).append('\'').append(", url='").append(url).append('\'').append(", conditionJson='").append(conditionJson).append('\'').append(", conditionMap=").append(conditionMap).append(", achievement=").append(achievement).append('}').toString();
    }
}
