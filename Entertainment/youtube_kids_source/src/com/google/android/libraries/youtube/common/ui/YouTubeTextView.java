// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.youtube.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import bhu;
import bmc;
import bmg;
import bmo;

public class YouTubeTextView extends TextView
{

    private boolean a;
    private boolean b;

    public YouTubeTextView(Context context)
    {
        super(context);
        a(context, bmc.a, 0, false);
    }

    public YouTubeTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, bhu.b);
        a(context, attributeset, typedarray);
        typedarray.recycle();
    }

    public YouTubeTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, bhu.b, i, 0);
        a(context, attributeset, typedarray);
        typedarray.recycle();
    }

    public YouTubeTextView(Context context, bmc bmc1, int i, boolean flag)
    {
        super(context);
        a(context, bmc1, i, flag);
    }

    private void a(Context context, AttributeSet attributeset, TypedArray typedarray)
    {
        int i;
        int j;
        boolean flag;
        i = typedarray.getInt(0, -1);
        j = attributeset.getAttributeIntValue("android", "textStyle", 0);
        flag = typedarray.getBoolean(1, false);
        i;
        JVM INSTR tableswitch 0 2: default 56
    //                   0 61
    //                   1 97
    //                   2 104;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_104;
_L1:
        bmo.c("Missing or invalid font preference on a RobotoTextView.");
_L2:
        attributeset = bmc.a;
_L5:
        a(context, ((bmc) (attributeset)), j, flag);
        if (typedarray.getBoolean(2, false))
        {
            b = true;
            setMovementMethod(bmg.a());
            return;
        } else
        {
            b = false;
            setMovementMethod(getDefaultMovementMethod());
            return;
        }
_L3:
        attributeset = bmc.b;
          goto _L5
        attributeset = bmc.c;
          goto _L5
    }

    private void a(Context context, bmc bmc1, int i, boolean flag)
    {
        context = bmc1.a(context);
        if (context != null)
        {
            setTypeface(context, i);
        }
        setAllCaps(flag);
    }

    public static void a(YouTubeTextView youtubetextview)
    {
        youtubetextview.a = true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (b)
        {
            a = false;
            super.onTouchEvent(motionevent);
            return a;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }
}
