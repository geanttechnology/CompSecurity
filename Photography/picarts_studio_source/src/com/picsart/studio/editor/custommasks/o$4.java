// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
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
        if (motionevent.getAction() == 9 || o.j(a))
        {
            o.k(a).removeMessages(0);
            int ai[] = new int[2];
            view.getLocationOnScreen(ai);
            String s;
            int i;
            int j;
            int k;
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
            s = ((TextView)view.findViewById(0x7f100234)).getText().toString();
            if (o.l(a) != null)
            {
                c.a(o.l(a));
                o.b(a, null);
                o.m(a).setImageBitmap(null);
            }
            o.b(a, o.n(a).a(view, false, 0));
            if (o.l(a) == null)
            {
                o.b(a);
                return true;
            }
            o.o(a).setText(s);
            o.a(a, o.l(a));
            o.m(a).setImageBitmap(com.picsart.studio.editor.custommasks.o.c(a));
            o.p(a);
            j = (o.l(a).getWidth() - view.getWidth()) / 2;
            k = ((o.l(a).getHeight() + (int)Utils.a(2.0F, o.q(a).getApplicationContext()) + o.o(a).getMeasuredHeight()) - view.getMeasuredHeight()) / 2;
            if (o.q(a).getResources().getConfiguration().orientation == 2)
            {
                j = (int)Math.min(Math.max(ai[1] - o.r(a) - k, 0), (float)((View)a.a.getParent()).getMeasuredHeight() - Utils.a(2.0F, o.q(a).getApplicationContext()) - (float)o.l(a).getHeight() - (float)o.o(a).getMeasuredHeight());
                a.a.animate().translationY(j).translationX((float)(ai[0] - o.l(a).getWidth()) - Utils.a(7F, o.q(a).getApplicationContext())).setDuration(i).setListener(o.s(a));
            } else
            {
                j = Math.min(Math.max(ai[0] - j, 0), ((View)a.a.getParent()).getMeasuredWidth() - o.l(a).getWidth());
                float f = ai[1] - o.l(a).getHeight() - o.o(a).getMeasuredHeight();
                float f1 = Utils.a(7F, o.q(a).getApplicationContext());
                a.a.animate().translationX(j).translationY(f - f1).setDuration(i).setListener(o.s(a));
            }
            if (o.j(a))
            {
                com.picsart.studio.editor.custommasks.o.c(a, false);
            }
        }
        if (motionevent.getAction() == 10)
        {
            motionevent = o.k(a).obtainMessage();
            motionevent.what = 0;
            motionevent.arg1 = view.hashCode();
            o.k(a).sendMessageDelayed(motionevent, 300L);
            return true;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    (o o1)
    {
        a = o1;
        super();
    }
}
