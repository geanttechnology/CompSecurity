// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;

class d
    implements Runnable
{

    private int a;
    private int b;
    private int c;
    private int d;
    private final Button e;

    public void run()
    {
        Object obj = new Rect();
        e.getHitRect(((Rect) (obj)));
        obj.top = ((Rect) (obj)).top + a;
        obj.right = ((Rect) (obj)).right + d;
        obj.bottom = ((Rect) (obj)).bottom + c;
        obj.left = ((Rect) (obj)).left + b;
        obj = new TouchDelegate(((Rect) (obj)), e);
        if (android/view/View.isInstance(e.getParent()))
        {
            ((View)e.getParent()).setTouchDelegate(((TouchDelegate) (obj)));
        }
    }

    (Button button, int i, int j, int k, int l)
    {
        e = button;
        a = i;
        b = j;
        c = k;
        d = l;
    }
}
