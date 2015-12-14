// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.TimeSpan;
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
            return zzw.zzu(this).zzg("RawScore", Long.valueOf(rawScore)).zzg("FormattedScore", formattedScore).zzg("ScoreTag", scoreTag).zzg("NewBest", Boolean.valueOf(newBest)).toString();
        }

        public Result(long l, String s, String s1, boolean flag)
        {
            rawScore = l;
            formattedScore = s;
            scoreTag = s1;
            newBest = flag;
        }
    }


    private static final String zzaxr[] = {
        "leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"
    };
    private String zzWn;
    private int zzWu;
    private HashMap zzaxX;
    private String zzaxt;

    public ScoreSubmissionData(DataHolder dataholder)
    {
        zzWu = dataholder.getStatusCode();
        zzaxX = new HashMap();
        int j = dataholder.getCount();
        boolean flag;
        if (j == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        for (int i = 0; i < j; i++)
        {
            int k = dataholder.zzbo(i);
            if (i == 0)
            {
                zzaxt = dataholder.zzd("leaderboardId", i, k);
                zzWn = dataholder.zzd("playerId", i, k);
            }
            if (dataholder.zze("hasResult", i, k))
            {
                zza(new Result(dataholder.zzb("rawScore", i, k), dataholder.zzd("formattedScore", i, k), dataholder.zzd("scoreTag", i, k), dataholder.zze("newBest", i, k)), dataholder.zzc("timeSpan", i, k));
            }
        }

    }

    private void zza(Result result, int i)
    {
        zzaxX.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId()
    {
        return zzaxt;
    }

    public String getPlayerId()
    {
        return zzWn;
    }

    public Result getScoreResult(int i)
    {
        return (Result)zzaxX.get(Integer.valueOf(i));
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzu(this).zzg("PlayerId", zzWn).zzg("StatusCode", Integer.valueOf(zzWu));
        int i = 0;
        while (i < 3) 
        {
            Object obj = (Result)zzaxX.get(Integer.valueOf(i));
            zza1.zzg("TimesSpan", TimeSpan.zzfQ(i));
            if (obj == null)
            {
                obj = "null";
            } else
            {
                obj = ((Result) (obj)).toString();
            }
            zza1.zzg("Result", obj);
            i++;
        }
        return zza1.toString();
    }

}
