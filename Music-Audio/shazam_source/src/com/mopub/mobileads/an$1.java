// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.c.p;
import com.mopub.common.m;
import com.mopub.common.n;
import com.mopub.common.o;

// Referenced classes of package com.mopub.mobileads:
//            an, ah, am

final class a
    implements android.view.OnTouchListener
{

    final Activity a;
    final an b;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 && b.r)
        {
            b.x = true;
            b.a("com.mopub.action.interstitial.click");
            view = b.d;
            motionevent = a;
            int i;
            if (b.s)
            {
                i = b.w;
            } else
            {
                i = b.e.getCurrentPosition();
            }
            m.a(motionevent, "activity cannot be null");
            p.a(((ah) (view)).g, null, Integer.valueOf(i), ((ah) (view)).j, motionevent);
            if (!TextUtils.isEmpty(((ah) (view)).i))
            {
                com.mopub.common.  = (new com.mopub.common.init>()).(n.b, new n[] {
                    n.e, n.d, n.f, n.g, n.h, n.i
                });
                . = new <init>(view, motionevent);
                . = true;
                .().a(motionevent, ((ah) (view)).i);
            }
        }
        return true;
    }

    Listener(an an1, Activity activity)
    {
        b = an1;
        a = activity;
        super();
    }
}
