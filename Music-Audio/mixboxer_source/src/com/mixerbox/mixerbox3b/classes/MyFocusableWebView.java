// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;

public class MyFocusableWebView extends WebView
{

    public MyFocusableWebView(Context context)
    {
        super(context);
    }

    public boolean onCheckIsTextEditor()
    {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 28
    //                   0 34
    //                   1 34;
           goto _L1 _L2 _L2
_L1:
        return super.onTouchEvent(motionevent);
_L2:
        if (!hasFocus())
        {
            requestFocus();
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
