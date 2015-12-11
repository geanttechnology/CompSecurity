// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions.model;

import android.content.Context;
import android.graphics.Typeface;

public class CaptionFont
{

    private String _displayName;
    private Typeface _typeface;
    private String _typefaceFile;

    public CaptionFont(String s, String s1, Context context)
    {
        _displayName = s;
        _typefaceFile = s1;
        _typeface = Typeface.createFromAsset(context.getAssets(), _typefaceFile);
    }

    public String getDisplayName()
    {
        return _displayName;
    }

    public Typeface getTypeface()
    {
        return _typeface;
    }
}
