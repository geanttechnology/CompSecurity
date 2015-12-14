// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import myobfuscated.bw.d;

// Referenced classes of package myobfuscated.ck:
//            d

final class it>
    implements d
{

    private myobfuscated.ck.d a;

    public final void a()
    {
    }

    public final boolean a(View view, MotionEvent motionevent)
    {
        if (myobfuscated.ck.d.d(a) != view.hashCode())
        {
            d.a(a, 0L);
            d.a(a, false);
            d.a(a, view.hashCode());
        }
        if (motionevent.getAction() != 10) goto _L2; else goto _L1
_L1:
        d.a(a, -1);
        d.a(a, 0L);
        d.a(a, false);
_L4:
        return false;
_L2:
        if (d.e(a) == 0L)
        {
            d.a(a, System.currentTimeMillis());
            return false;
        }
        if (System.currentTimeMillis() - d.e(a) < 300L)
        {
            d.b(a, true);
            return false;
        }
        if (motionevent.getAction() != 9 && !d.f(a)) goto _L4; else goto _L3
_L3:
        d.b(a, false);
        android.widget.tiveLayout.LayoutParams layoutparams = (android.widget.tiveLayout.LayoutParams)d.g(a).getLayoutParams();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        layoutparams.leftMargin = (int)((float)ai[0] + motionevent.getX());
        d.g(a).setLayoutParams(layoutparams);
        if (view.getId() != 0x7f100762) goto _L6; else goto _L5
_L5:
        d.g(a).setText(0x7f080435);
_L8:
        d.a(a, true);
        return false;
_L6:
        if (view.getId() == 0x7f1006f9)
        {
            d.g(a).setText(0x7f080432);
        } else
        if (view.getId() == 0x7f10018b)
        {
            d.g(a).setText(0x7f080362);
        } else
        if (view.getId() == 0x7f100136)
        {
            d.g(a).setText(0x7f080433);
        } else
        if (view.getId() == 0x7f10018c)
        {
            d.g(a).setText(0x7f080434);
        } else
        if (view.getId() == 0x7f100761)
        {
            d.g(a).setText(0x7f0802a4);
        } else
        if (view.getId() == 0x7f100540)
        {
            d.g(a).setText(0x7f0802b8);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    vent(myobfuscated.ck.d d1)
    {
        a = d1;
        super();
    }
}
