// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.content.Context;
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
import com.photo.effect.Effect;
import com.socialin.android.util.c;
import myobfuscated.bw.d;
import myobfuscated.ci.b;

// Referenced classes of package myobfuscated.ck:
//            d, c

final class it>
    implements d
{

    private myobfuscated.ck.d a;

    public final void a()
    {
    }

    public final boolean a(View view, MotionEvent motionevent)
    {
        if (d.h(a) != 0L) goto _L2; else goto _L1
_L1:
        myobfuscated.ck.d.b(a, System.currentTimeMillis());
_L4:
        return true;
_L2:
        if (System.currentTimeMillis() - d.h(a) >= 300L && !d.i(a))
        {
            break; /* Loop/switch isn't completed */
        }
        myobfuscated.ck.d.c(a, true);
        if (motionevent.getAction() == 9 || motionevent.getAction() == 10)
        {
            myobfuscated.ck.d.b(a, 0L);
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (motionevent.getAction() != 9 && !d.j(a))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (d.k(a) == null && d.l(a) != null)
        {
            d.a(a, d.l(a).a(d.m(a)));
        }
        if (d.k(a) == null) goto _L4; else goto _L5
_L5:
        d.n(a).removeMessages(0);
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        Object obj;
        String s;
        int i;
        int j;
        int k;
        if (d.a(a) != -1)
        {
            i = 300;
        } else
        {
            i = 0;
        }
        myobfuscated.ck.d.b(a, view.hashCode());
        if (myobfuscated.ck.d.c(a) != null && !myobfuscated.ck.d.c(a).equals(d.k(a)))
        {
            d.o(a).setImageBitmap(null);
            c.a(myobfuscated.ck.d.c(a));
            myobfuscated.ck.d.b(a, null);
        }
        obj = (String)((ImageView)view.findViewById(0x7f100233)).getTag();
        s = (String)((TextView)view.findViewById(0x7f100234)).getTag();
        d.p(a).setText(s);
        if (d.q(a) == null && d.l(a) != null)
        {
            d.a(a, null);
        }
        if (((String) (obj)).compareTo("None") == 0)
        {
            myobfuscated.ck.d.b(a, d.k(a));
            d.r(a);
        } else
        {
            myobfuscated.ck.d d1 = a;
            if (obj != null && ((String) (obj)).compareTo("None") != 0)
            {
                obj = d1.n.h.a(((String) (obj)));
                if (obj != null && ((b) (obj)).b)
                {
                    d1.b = ((b) (obj)).a(d1.l).a(d1.l, d1.c);
                    if (d1.b != null)
                    {
                        c.a(d1.b, d1.a, false);
                    }
                    d1.a();
                }
            }
        }
        j = (d.k(a).getWidth() - view.getWidth()) / 2;
        k = ((d.k(a).getHeight() + d.p(a).getMeasuredHeight()) - view.getHeight()) / 2;
        if (d.m(a).getResources().getConfiguration().orientation == 2)
        {
            j = Math.min(Math.max(ai[1] - k, 0), ((View)a.f.getParent()).getMeasuredHeight() - (d.k(a).getHeight() + d.p(a).getMeasuredHeight()));
            a.f.animate().translationY(j).setDuration(i).setListener(d.s(a));
        } else
        {
            j = Math.min(Math.max(0, ai[0] - j), ((View)a.f.getParent()).getMeasuredWidth() - d.k(a).getWidth());
            a.f.animate().translationX(j).setDuration(i).setListener(d.s(a));
        }
        if (d.j(a))
        {
            myobfuscated.ck.d.c(a, false);
        }
        if (motionevent.getAction() != 10) goto _L4; else goto _L6
_L6:
        motionevent = d.n(a).obtainMessage();
        motionevent.what = 0;
        motionevent.arg1 = view.hashCode();
        d.n(a).sendMessageDelayed(motionevent, 300L);
        return true;
    }

    vent(myobfuscated.ck.d d1)
    {
        a = d1;
        super();
    }
}
