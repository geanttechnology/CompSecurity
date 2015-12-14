// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import myobfuscated.bw.d;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            o, p

final class a
    implements d
{

    private o a;

    public final void a()
    {
    }

    public final boolean a(View view, MotionEvent motionevent)
    {
        if (o.h(a) != 0L) goto _L2; else goto _L1
_L1:
        o.b(a, System.currentTimeMillis());
_L4:
        return true;
_L2:
        if (System.currentTimeMillis() - o.h(a) >= 300L && !o.i(a))
        {
            break; /* Loop/switch isn't completed */
        }
        com.picsart.studio.editor.custommasks.o.c(a, true);
        if (motionevent.getAction() == 9 || motionevent.getAction() == 10)
        {
            o.b(a, 0L);
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (motionevent.getAction() != 9 && !o.j(a))
        {
            continue; /* Loop/switch isn't completed */
        }
        o.k(a).removeMessages(0);
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        int i;
        int j;
        if (o.a(a) != -1)
        {
            i = 300;
        } else
        {
            i = 0;
        }
        o.b(a, view.hashCode());
        if (com.picsart.studio.editor.custommasks.o.c(a) != null && !com.picsart.studio.editor.custommasks.o.c(a).equals(o.l(a)))
        {
            c.a(com.picsart.studio.editor.custommasks.o.c(a));
            o.a(a, null);
        }
        if (o.l(a) != null)
        {
            c.a(o.l(a));
            o.b(a, null);
        }
        o.o(a).setText(((TextView)view).getText());
        o.b(a, o.n(a).a(view, true, ((Integer)view.getTag()).intValue()));
        if (o.l(a) == null) goto _L4; else goto _L5
_L5:
        o.a(a, o.l(a));
        o.p(a);
        j = Math.min(ai[1] - view.getHeight(), ((View)a.a.getParent()).getMeasuredHeight() - o.l(a).getHeight() - o.o(a).getMeasuredHeight() - (int)Utils.a(2.0F, o.q(a).getApplicationContext()));
        a.a.animate().translationX(ai[0] + view.getWidth()).translationY(j).setDuration(i).setListener(o.s(a));
        if (o.j(a))
        {
            com.picsart.studio.editor.custommasks.o.c(a, false);
        }
        if (motionevent.getAction() != 10) goto _L4; else goto _L6
_L6:
        motionevent = o.k(a).obtainMessage();
        motionevent.what = 0;
        motionevent.arg1 = view.hashCode();
        o.k(a).sendMessageDelayed(motionevent, 300L);
        return true;
    }

    (o o1)
    {
        a = o1;
        super();
    }
}
