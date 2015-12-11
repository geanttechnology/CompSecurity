// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.imagereader;

import com.digimarc.dms.DMSCpmBase;

public class CpmImage extends DMSCpmBase
{
    public static final class Genre extends Enum
    {

        private static final Genre $VALUES[];
        public static final Genre Chroma;
        public static final Genre Classic;

        public static Genre valueOf(String s)
        {
            return (Genre)Enum.valueOf(com/digimarc/dms/imagereader/CpmImage$Genre, s);
        }

        public static Genre[] values()
        {
            return (Genre[])$VALUES.clone();
        }

        static 
        {
            Classic = new Genre("Classic", 0);
            Chroma = new Genre("Chroma", 1);
            $VALUES = (new Genre[] {
                Classic, Chroma
            });
        }

        private Genre(String s, int i)
        {
            super(s, i);
        }
    }


    private int mFirstStage;
    private boolean mReadError;
    private int mReadStage;
    private float mRotation;
    private float mScale;
    private int mSecondStage;
    private boolean mSuccessfulDecode;
    private int mTimeSpentInCore;
    private Genre mWatermarkGenre;

    public CpmImage(String s)
    {
        super(s);
        mWatermarkGenre = null;
        mSuccessfulDecode = false;
        mReadError = false;
    }

    private void nativeSetCpm(String s, String s1)
    {
        super.mCpmPath = s;
        super.mReaderInfo = s1;
    }

    private void nativeSetError()
    {
        mReadError = true;
    }

    private void nativeSetReaderStats(int i, int j, boolean flag, boolean flag1)
    {
        mScale = i;
        mRotation = j;
        Genre genre;
        if (flag)
        {
            genre = Genre.Chroma;
        } else
        {
            genre = Genre.Classic;
        }
        mWatermarkGenre = genre;
        mSuccessfulDecode = flag1;
    }

    private void nativeSetTimings(int i, int j, int k)
    {
        mReadStage = i;
        mFirstStage = j;
        mSecondStage = k;
    }

    public int getFirstStage()
    {
        return mFirstStage;
    }

    public float getRotation()
    {
        return mRotation;
    }

    public float getScale()
    {
        return mScale;
    }

    public int getSecondStage()
    {
        return mSecondStage;
    }

    public int getThirdStage()
    {
        return mReadStage;
    }

    public int getTimeSpentInCore()
    {
        return mTimeSpentInCore;
    }

    public Genre getWatermarkCategory()
    {
        return mWatermarkGenre;
    }

    public boolean getWatermarkFound()
    {
        return mSuccessfulDecode;
    }

    public boolean readError()
    {
        return mReadError;
    }
}
