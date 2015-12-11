// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.graphics.Color;
import android.widget.TextView;

public class f
{

    public static void a(TextView textview, float f1)
    {
        int i = textview.getCurrentTextColor();
        textview.setTextColor(Color.argb((int)Math.floor(255F * f1), Color.red(i), Color.green(i), Color.blue(i)));
    }
}
