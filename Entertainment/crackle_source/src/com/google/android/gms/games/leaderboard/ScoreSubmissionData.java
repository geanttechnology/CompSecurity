// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.ge;
import java.util.HashMap;

public final class ScoreSubmissionData
{
    public static final class Result
    {

        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public String toString()
        {
            return ee.e(this).a("RawScore", Long.valueOf(rawScore)).a("FormattedScore", formattedScore).a("ScoreTag", scoreTag).a("NewBest", Boolean.valueOf(newBest)).toString();
        }

        public Result(long l, String s, String s1, boolean flag)
        {
            rawScore = l;
            formattedScore = s;
            scoreTag = s1;
            newBest = flag;
        }
    }


    private static final String wh[] = {
        "leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"
    };
    private int mC;
    private String tC;
    private String vD;
    private HashMap wi;

    public ScoreSubmissionData(DataHolder dataholder)
    {
        mC = dataholder.getStatusCode();
        wi = new HashMap();
        int j = dataholder.getCount();
        boolean flag;
        if (j == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.r(flag);
        for (int i = 0; i < j; i++)
        {
            int k = dataholder.C(i);
            if (i == 0)
            {
                vD = dataholder.getString("leaderboardId", i, k);
                tC = dataholder.getString("playerId", i, k);
            }
            if (dataholder.getBoolean("hasResult", i, k))
            {
                a(new Result(dataholder.getLong("rawScore", i, k), dataholder.getString("formattedScore", i, k), dataholder.getString("scoreTag", i, k), dataholder.getBoolean("newBest", i, k)), dataholder.getInteger("timeSpan", i, k));
            }
        }

    }

    private void a(Result result, int i)
    {
        wi.put(Integer.valueOf(i), result);
    }

    private ContentValues aH(int i)
    {
        Result result = getScoreResult(i);
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("leaderboardId", vD);
        contentvalues.put("playerId", tC);
        contentvalues.put("timeSpan", Integer.valueOf(i));
        if (result != null)
        {
            contentvalues.put("rawScore", Long.valueOf(result.rawScore));
            contentvalues.put("formattedScore", result.formattedScore);
            contentvalues.put("scoreTag", result.scoreTag);
            contentvalues.put("newBest", Boolean.valueOf(result.newBest));
            contentvalues.put("hasResult", Boolean.valueOf(true));
            return contentvalues;
        } else
        {
            contentvalues.put("hasResult", Boolean.valueOf(false));
            return contentvalues;
        }
    }

    public DataHolder dx()
    {
        com.google.android.gms.common.data.DataHolder.Builder builder = DataHolder.builder(wh);
        for (int i = 0; i < 3; i++)
        {
            builder.withRow(aH(i));
        }

        return builder.build(mC);
    }

    public String getLeaderboardId()
    {
        return vD;
    }

    public String getPlayerId()
    {
        return tC;
    }

    public Result getScoreResult(int i)
    {
        return (Result)wi.get(Integer.valueOf(i));
    }

    public String toString()
    {
        com.google.android.gms.internal.ee.a a1 = ee.e(this).a("PlayerId", tC).a("StatusCode", Integer.valueOf(mC));
        int i = 0;
        while (i < 3) 
        {
            Object obj = (Result)wi.get(Integer.valueOf(i));
            a1.a("TimesSpan", ge.aG(i));
            if (obj == null)
            {
                obj = "null";
            } else
            {
                obj = ((Result) (obj)).toString();
            }
            a1.a("Result", obj);
            i++;
        }
        return a1.toString();
    }

}
