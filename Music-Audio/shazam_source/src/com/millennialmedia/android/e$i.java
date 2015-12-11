// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.millennialmedia.android:
//            e

private static final class d
    implements Runnable
{

    int a;
    int b;
    int c;
    int d;
    private final Button e;

    public final void run()
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

    (Button button, int j, int k, int l, int i1)
    {
        e = button;
        a = j;
        b = k;
        c = l;
        d = i1;
    }
}
