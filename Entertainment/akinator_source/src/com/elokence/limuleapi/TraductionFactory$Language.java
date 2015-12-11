// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;


// Referenced classes of package com.elokence.limuleapi:
//            TraductionFactory

public static class mSmartphoneFont
{

    private String mCode;
    private String mFlagUrl;
    private String mFontCoeffAndroid;
    private String mLabel;
    private String mLastTokensSync;
    private String mLastWsSync;
    private String mSmartphoneFont;

    public String getCode()
    {
        return mCode;
    }

    public String getFlagUrl()
    {
        return mFlagUrl;
    }

    public String getFontCoeffAndroid()
    {
        return mFontCoeffAndroid;
    }

    public String getLabel()
    {
        return mLabel;
    }

    public String getLastTokensSync()
    {
        return mLastTokensSync;
    }

    public String getLastWsSync()
    {
        return mLastWsSync;
    }

    public String getSmartphoneFont()
    {
        return mSmartphoneFont;
    }

    public String toString()
    {
        return (new StringBuilder()).append("AkLanguageModel [mCode=").append(mCode).append(", mLabel=").append(mLabel).append(", mFlagUrl=").append(mFlagUrl).append(", mLastTokensSync=").append(mLastTokensSync).append(", mLastWsSync=").append(mLastWsSync).append(", mFontCoeffAndroid=").append(mFontCoeffAndroid).append(", mSmartphoneFont=").append(mSmartphoneFont).append("]").toString();
    }


    public (String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        mCode = s;
        mLabel = s1;
        mFlagUrl = s2;
        mLastTokensSync = s3;
        mLastWsSync = s4;
        mFontCoeffAndroid = s5;
        mSmartphoneFont = s6;
    }
}
