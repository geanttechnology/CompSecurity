// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;

// Referenced classes of package com.wishabi.flipp.widget:
//            db, dj

final class dg extends AnimatorListenerAdapter
{

    final db a;

    dg(db db1)
    {
        a = db1;
        super();
    }

    public final void onAnimationCancel(Animator animator)
    {
        if (db.a(a) != null)
        {
            db.a(a).d(a);
        }
    }

    public final void onAnimationEnd(Animator animator)
    {
        if (db.a(a) != null)
        {
            db.a(a).d(a);
        }
    }

    public final void onAnimationStart(Animator animator)
    {
        db.d(a).setVisibility(0);
        db.d(a).setAlpha(0.0F);
    }
}
