// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package cn.jpush.android.ui:
//            a, c

final class b
    implements android.view.View.OnTouchListener
{

    final a a;

    b(a a1)
    {
        a = a1;
        super();
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        cn.jpush.android.ui.a.a(a).sendEmptyMessage(0);
        return false;
    }
}
