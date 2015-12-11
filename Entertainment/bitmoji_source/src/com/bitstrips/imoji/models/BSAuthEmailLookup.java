// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;

import android.graphics.Bitmap;

public class BSAuthEmailLookup
{

    private Bitmap bitmap;
    String match;

    public BSAuthEmailLookup(String s)
    {
        bitmap = null;
        match = s;
    }

    public Bitmap getBitmap()
    {
        return bitmap;
    }

    public String getURL()
    {
        return match;
    }

    public Boolean matchFound()
    {
        boolean flag;
        if (match != null && !match.toLowerCase().equals("false"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }
}
