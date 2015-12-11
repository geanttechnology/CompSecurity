// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;


public final class mRecognizerEncoding extends Enum
{

    private static final AMRWB $VALUES[];
    public static final AMRWB AMR;
    public static final AMRWB AMRWB;
    private final int mCode;
    private final String mExt;
    private final String mMimeType;
    private final int mRecognizerEncoding;

    public static mRecognizerEncoding fromCode(int i)
    {
        mRecognizerEncoding amrecognizerencoding[] = values();
        int k = amrecognizerencoding.length;
        for (int j = 0; j < k; j++)
        {
            mRecognizerEncoding mrecognizerencoding = amrecognizerencoding[j];
            if (mrecognizerencoding.getCode() == i)
            {
                return mrecognizerencoding;
            }
        }

        throw new IllegalArgumentException((new StringBuilder("invalid code: ")).append(i).toString());
    }

    public static getCode valueOf(String s)
    {
        return (getCode)Enum.valueOf(com/google/android/speech/audio/AudioUtils$Encoding, s);
    }

    public static getCode[] values()
    {
        return (getCode[])$VALUES.clone();
    }

    public final int getCode()
    {
        return mCode;
    }

    public final String getExt()
    {
        return mExt;
    }

    public final String getMimeType()
    {
        return mMimeType;
    }

    public final int getRecognizerEncoding()
    {
        return mRecognizerEncoding;
    }

    static 
    {
        AMR = new <init>("AMR", 0, "audio/AMR", "amr", 1, 3);
        AMRWB = new <init>("AMRWB", 1, "audio/amr-wb", "amr", 2, 9);
        $VALUES = (new .VALUES[] {
            AMR, AMRWB
        });
    }

    private _cls9(String s, int i, String s1, String s2, int j, int k)
    {
        super(s, i);
        mMimeType = s1;
        mExt = s2;
        mCode = j;
        mRecognizerEncoding = k;
    }
}
