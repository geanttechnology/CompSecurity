// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.data.model:
//            ScoreInfo

public class SongProgress
{

    public static final String COLUMN_DIFFICULTY = "difficulty";
    public static final String COLUMN_LOCKED = "locked";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_PARTIAL_SUCCESS = "partial_success";
    public static final String COLUMN_SCORE_INFO = "score_info";
    public static final String COLUMN_STARS = "stars";
    private static final String SERIALIZATION_VERSION = "1";
    public int _id;
    public double bestPartialSuccess;
    public int difficulty;
    public int locked;
    public ScoreInfo scoreInfo;
    public int stars;

    public SongProgress()
    {
    }

    public static SongProgress fromJsonNode(JsonNode jsonnode)
    {
        SongProgress songprogress = new SongProgress();
        songprogress.difficulty = jsonnode.get("d").asInt();
        songprogress.locked = jsonnode.get("l").asInt();
        songprogress.stars = jsonnode.get("ns").asInt();
        songprogress.bestPartialSuccess = jsonnode.get("bp").asDouble();
        return songprogress;
    }

    public Map toMapForJson()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("l", Integer.valueOf(locked));
        hashmap.put("d", Integer.valueOf(difficulty));
        hashmap.put("ns", Integer.valueOf(stars));
        hashmap.put("bp", Double.valueOf(bestPartialSuccess));
        hashmap.put("v", "1");
        return hashmap;
    }
}
