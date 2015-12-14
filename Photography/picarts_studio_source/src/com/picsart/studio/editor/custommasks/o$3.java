// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import myobfuscated.bw.d;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            o

final class a
    implements d
{

    private o a;

    public final void a()
    {
    }

    public final boolean a(View view, MotionEvent motionevent)
    {
        if (com.picsart.studio.editor.custommasks.o.d(a) != view.hashCode())
        {
            o.a(a, 0L);
            o.a(a, false);
            o.a(a, view.hashCode());
        }
        if (motionevent.getAction() != 10) goto _L2; else goto _L1
_L1:
        o.a(a, -1);
        o.a(a, 0L);
        o.a(a, false);
_L4:
        return false;
_L2:
        if (o.e(a) == 0L)
        {
            o.a(a, System.currentTimeMillis());
            return false;
        }
        if (System.currentTimeMillis() - o.e(a) < 300L)
        {
            o.b(a, true);
            return false;
        }
        if (motionevent.getAction() != 9 && !o.f(a)) goto _L4; else goto _L3
_L3:
        o.b(a, false);
        android.widget.tiveLayout.LayoutParams layoutparams = (android.widget.tiveLayout.LayoutParams)o.g(a).getLayoutParams();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        layoutparams.leftMargin = (int)((float)ai[0] + motionevent.getX() + 5F);
        layoutparams.topMargin = (int)((float)ai[1] + motionevent.getY()) + 10;
        o.g(a).setLayoutParams(layoutparams);
        if (view.getId() != 0x7f100762) goto _L6; else goto _L5
_L5:
        o.g(a).setText(0x7f080435);
_L8:
        o.a(a, true);
        return false;
_L6:
        if (view.getId() == 0x7f1006f9)
        {
            o.g(a).setText(0x7f080432);
        } else
        if (view.getId() == 0x7f10018b)
        {
            o.g(a).setText(0x7f080362);
        } else
        if (view.getId() == 0x7f100136)
        {
            o.g(a).setText(0x7f080433);
        } else
        if (view.getId() == 0x7f10018c)
        {
            o.g(a).setText(0x7f080434);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    (o o1)
    {
        a = o1;
        super();
    }
}
