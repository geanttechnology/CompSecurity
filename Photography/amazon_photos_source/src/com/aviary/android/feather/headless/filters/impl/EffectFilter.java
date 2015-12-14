// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters.impl;

import com.aviary.android.feather.headless.filters.IntensityNativeFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;
import java.io.UnsupportedEncodingException;

public class EffectFilter extends IntensityNativeFilter
{

    public static final String ORIGINAL = "original";

    public EffectFilter()
    {
        super("effects");
        setSeed(SEED);
    }

    public EffectFilter(CharSequence charsequence)
    {
        this();
        setEffectName(charsequence);
    }

    public void setBorders(boolean flag)
    {
        mActions.get(0).setValue("border", flag);
    }

    public void setEffectName(CharSequence charsequence)
    {
        mActions.get(0).setValue("name", charsequence);
    }

    public void setIntensity(double d)
    {
        mActions.get(0).setValue("intensity", d);
    }

    public final void setMoaLiteEffect(String s)
    {
        mActions.get(0).setValue("filename", s);
    }

    public final void setMoaLiteEffect(String s, String s1)
    {
        mActions.get(0).setValue("zipname", s);
        mActions.get(0).setValue("filename", s1);
    }

    public final void setMoaLiteEffectContent(String s)
    {
        mActions.get(0).setValue("jsonstring", s);
    }

    public final void setMoaLiteEffectContent(byte abyte0[])
    {
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        mActions.get(0).setValue("jsonstring", new String(abyte0, "US-ASCII"));
        return;
        abyte0;
        abyte0.printStackTrace();
        return;
    }
}
