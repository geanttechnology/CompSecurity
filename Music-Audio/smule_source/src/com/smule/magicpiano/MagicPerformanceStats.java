// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.magicpiano;

import android.os.Parcel;
import android.os.Parcelable;
import com.crittercism.app.Crittercism;
import com.smule.pianoandroid.magicpiano.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.magicpiano:
//            a

public class MagicPerformanceStats
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public MagicPerformanceStats a(Parcel parcel)
        {
            return new MagicPerformanceStats(parcel);
        }

        public MagicPerformanceStats[] a(int i)
        {
            return new MagicPerformanceStats[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    public int difficulty;
    private int freeplayChords;
    private int hitChords;
    public int longestStreak;
    private int missChords;
    private float score;
    public float songDuration;
    public List starCounts;
    private int totalChords;
    private float totalPointsPossible;

    public MagicPerformanceStats()
    {
        starCounts = new ArrayList();
    }

    public MagicPerformanceStats(Parcel parcel)
    {
        starCounts = new ArrayList();
        readFromParcel(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public Boolean isPerfect()
    {
        boolean flag;
        if (scoringHitChords() == totalScoringChords())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public float partialProgress()
    {
        if (totalChords <= 0)
        {
            return 0.0F;
        }
        float f = (float)scoringHitChords() / (float)totalScoringChords();
        if (f > 1.0F)
        {
            Crittercism.a(new Exception((new StringBuilder()).append("invalid song partialProgress: scoringHitChords:").append(scoringHitChords()).append(" totalScoringChords: ").append(totalScoringChords()).append(" score: ").append(score).toString()));
            return 1.0F;
        } else
        {
            return f;
        }
    }

    public void readFromParcel(Parcel parcel)
    {
        score = parcel.readFloat();
        totalPointsPossible = parcel.readFloat();
        hitChords = parcel.readInt();
        missChords = parcel.readInt();
        totalChords = parcel.readInt();
        songDuration = parcel.readFloat();
        longestStreak = parcel.readInt();
        difficulty = parcel.readInt();
        freeplayChords = parcel.readInt();
        int j = parcel.readInt();
        for (int i = 0; i < j; i++)
        {
            starCounts.add(new a(parcel.readInt(), parcel.readInt(), k.values()[parcel.readInt()]));
        }

    }

    public int score()
    {
        if (score > 200000F)
        {
            Crittercism.a(new Exception((new StringBuilder()).append("invalid song score:").append(score).append(" totalpointpossible: ").append(totalPointsPossible).append(" hitChords: ").append(hitChords).append(" missedChords: ").append(missChords).toString()));
            return 0;
        } else
        {
            return Math.round(score);
        }
    }

    public int scoringHitChords()
    {
        return hitChords;
    }

    public int streamedChords()
    {
        return hitChords + missChords + freeplayChords;
    }

    public int totalPointsPossible()
    {
        return Math.round(totalPointsPossible);
    }

    public int totalScoringChords()
    {
        return hitChords + missChords;
    }

    public int totalStreamedChords()
    {
        return totalChords;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeFloat(score);
        parcel.writeFloat(totalPointsPossible);
        parcel.writeInt(hitChords);
        parcel.writeInt(missChords);
        parcel.writeInt(totalChords);
        parcel.writeFloat(songDuration);
        parcel.writeInt(longestStreak);
        parcel.writeInt(difficulty);
        parcel.writeInt(freeplayChords);
        parcel.writeInt(starCounts.size());
        a a1;
        for (Iterator iterator = starCounts.iterator(); iterator.hasNext(); parcel.writeInt(a1.c.ordinal()))
        {
            a1 = (a)iterator.next();
            parcel.writeInt(a1.a);
            parcel.writeInt(a1.b);
        }

    }

}
