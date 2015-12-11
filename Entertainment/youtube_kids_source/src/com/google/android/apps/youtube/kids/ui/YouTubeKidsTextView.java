// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.ui;

import agi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import bmo;
import vp;

public class YouTubeKidsTextView extends TextView
{

    public YouTubeKidsTextView(Context context)
    {
        super(context);
        a(context, 0, 0, false);
    }

    public YouTubeKidsTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, vp.d);
        a(context, attributeset, typedarray);
        typedarray.recycle();
    }

    public YouTubeKidsTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, vp.d, i, 0);
        a(context, attributeset, typedarray);
        typedarray.recycle();
    }

    private void a(Context context, int i, int j, boolean flag)
    {
        i;
        JVM INSTR tableswitch -1 3: default 36
    //                   -1 70
    //                   0 70
    //                   1 41
    //                   2 78
    //                   3 86;
           goto _L1 _L2 _L2 _L3 _L4 _L5
_L1:
        bmo.c("Missing or invalid font preference on a RobotoTextView.");
_L3:
        agi agi1 = agi.b;
_L7:
        context = agi1.a(context);
        if (context != null)
        {
            setTypeface(context, j);
        }
        setAllCaps(flag);
        return;
_L2:
        agi1 = agi.a;
        continue; /* Loop/switch isn't completed */
_L4:
        agi1 = agi.c;
        continue; /* Loop/switch isn't completed */
_L5:
        agi1 = agi.d;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void a(Context context, AttributeSet attributeset, TypedArray typedarray)
    {
        a(context, typedarray.getInt(1, -1), attributeset.getAttributeIntValue("android", "textStyle", 0), typedarray.getBoolean(0, false));
    }
}
