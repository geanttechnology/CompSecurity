// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.button.follow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.i;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.FollowButtonEventFactory;
import com.shazam.android.k.f.t;
import com.shazam.android.util.q;
import com.shazam.android.util.r;
import com.shazam.android.util.s;
import com.shazam.android.widget.text.CustomFontTextView;
import com.shazam.i.b.au.d;
import com.shazam.i.k.a.b;
import com.shazam.k.p;
import com.shazam.model.account.UserStateDecider;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.follow.FollowData;
import com.shazam.p.j.a;

// Referenced classes of package com.shazam.android.widget.button.follow:
//            a

public class FollowButton extends CustomFontTextView
    implements android.content.DialogInterface.OnClickListener, android.view.View.OnClickListener, a
{

    private static final int d[] = {
        0x7f01008f
    };
    public com.shazam.android.widget.button.follow.a a;
    public FollowData b;
    public AnalyticsInfo c;
    private final com.shazam.android.v.i e;
    private final s f;
    private final q g;
    private final UserStateDecider h;
    private final EventAnalyticsFromView i;
    private boolean j;
    private com.shazam.l.h.a k;
    private AlertDialog l;

    public FollowButton(Context context)
    {
        super(context, null, 0x7f01000a);
        e = com.shazam.i.b.v.a.c();
        f = com.shazam.i.b.au.d.a();
        g = r.a();
        h = com.shazam.i.k.a.b.a();
        i = com.shazam.i.b.g.b.a.b();
        a = com.shazam.android.widget.button.follow.a.b;
        g();
    }

    public FollowButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0x7f01000a);
        e = com.shazam.i.b.v.a.c();
        f = com.shazam.i.b.au.d.a();
        g = r.a();
        h = com.shazam.i.k.a.b.a();
        i = com.shazam.i.b.g.b.a.b();
        a = com.shazam.android.widget.button.follow.a.b;
        g();
    }

    public FollowButton(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        e = com.shazam.i.b.v.a.c();
        f = com.shazam.i.b.au.d.a();
        g = r.a();
        h = com.shazam.i.k.a.b.a();
        i = com.shazam.i.b.g.b.a.b();
        a = com.shazam.android.widget.button.follow.a.b;
        g();
    }

    public FollowButton(Context context, AttributeSet attributeset, int i1, int j1)
    {
        super(context, attributeset, i1, j1);
        e = com.shazam.i.b.v.a.c();
        f = com.shazam.i.b.au.d.a();
        g = r.a();
        h = com.shazam.i.k.a.b.a();
        i = com.shazam.i.b.g.b.a.b();
        a = com.shazam.android.widget.button.follow.a.b;
        g();
    }

    private void g()
    {
        a();
        super.setOnClickListener(this);
    }

    protected void a()
    {
        int i1;
        if (j)
        {
            i1 = 0x7f090086;
        } else
        {
            i1 = 0x7f090081;
        }
        setText(i1);
    }

    public final void a(com.shazam.android.analytics.event.factory.FollowButtonEventFactory.Origin origin, String s1)
    {
        origin = com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.ORIGIN, origin.toString());
        if (s1 != null)
        {
            origin.a(DefinedEventParameterKey.TRACK_ID, s1);
        }
        c = origin.b();
    }

    public final void a(FollowData followdata, boolean flag)
    {
label0:
        {
            b = followdata;
            Context context = getContext();
            android.support.v4.app.o o = ((i)context).getSupportLoaderManager();
            if (k != null)
            {
                k.b();
            }
            com.shazam.android.v.i i1 = e;
            String s1 = followdata.followKey;
            String s2 = followdata.artistId;
            k = new com.shazam.l.h.a(this, new com.shazam.android.k.b.a(o, i1.d.a(i1.e.f(s2)), context, new com.shazam.android.k.e.b.b(i1.a, i1.b, s1), com.shazam.android.k.b.i.b), new com.shazam.android.k.b.a(o, i1.d.a(i1.e.g(s2)), context, com.shazam.i.b.o.b.a.a(s1), com.shazam.android.k.b.i.b), new com.shazam.android.k.b.a(o, i1.d.a(i1.e.h(s2)), context, com.shazam.i.b.o.b.a.b(s1), com.shazam.android.k.b.i.b), i1.c, followdata, i1.f, i1.g, i1.e);
            if (flag)
            {
                followdata = k;
                ((com.shazam.l.h.a) (followdata)).a.b();
                followdata.a();
                if (!((com.shazam.l.h.a) (followdata)).g.b(((com.shazam.l.h.a) (followdata)).f))
                {
                    break label0;
                }
                followdata.a(Boolean.valueOf(((com.shazam.l.h.a) (followdata)).g.a(((com.shazam.l.h.a) (followdata)).f)));
            }
            return;
        }
        ((com.shazam.l.h.a) (followdata)).b.a();
    }

    public final void a(boolean flag)
    {
        i.logEvent(this, FollowButtonEventFactory.followErrorEvent(flag, b, c, false));
        setEnabled(true);
        f.a(g);
    }

    public final void b()
    {
        setEnabled(false);
    }

    public final void b(boolean flag)
    {
        j = flag;
        setEnabled(true);
        a();
        refreshDrawableState();
        a.a();
    }

    public final void c()
    {
        setEnabled(false);
    }

    public final void c(boolean flag)
    {
        i.logEvent(this, FollowButtonEventFactory.followSuccessEvent(flag, b, c));
    }

    public final void d()
    {
        ImageView imageview = new ImageView(getContext());
        imageview.setImageResource(0x7f020147);
        imageview.setPadding(com.shazam.android.util.h.b.a(32), com.shazam.android.util.h.b.a(24), com.shazam.android.util.h.b.a(32), com.shazam.android.util.h.b.a(24));
        l = (new android.app.AlertDialog.Builder(getContext())).setTitle(0x7f0900fe).setPositiveButton(0x7f090120, this).setNegativeButton(0x7f09004e, this).setView(imageview).show();
    }

    public final void e()
    {
        if (l != null)
        {
            l.dismiss();
        }
    }

    public final void f()
    {
        com.shazam.android.activities.b.b.b(getContext());
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (k != null)
        {
            k.a();
        }
    }

    public void onClick(DialogInterface dialoginterface, int i1)
    {
        switch (i1)
        {
        default:
            return;

        case -2: 
            dialoginterface = i;
            boolean flag;
            if (!j)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            dialoginterface.logEvent(this, FollowButtonEventFactory.followCancelEvent(flag, b, c));
            k.a.e();
            return;

        case -1: 
            dialoginterface = k;
            boolean flag1 = j;
            Object obj = com.shazam.model.follow.FollowAction.Builder.a();
            obj.followData = ((com.shazam.l.h.a) (dialoginterface)).f;
            obj.following = flag1;
            obj = ((com.shazam.model.follow.FollowAction.Builder) (obj)).b();
            ((com.shazam.l.h.a) (dialoginterface)).e.a(((com.shazam.model.follow.FollowAction) (obj)));
            ((com.shazam.l.h.a) (dialoginterface)).a.e();
            ((com.shazam.l.h.a) (dialoginterface)).a.f();
            return;
        }
    }

    public void onClick(View view)
    {
        view = i;
        boolean flag;
        if (!j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.logEvent(this, FollowButtonEventFactory.followRequestEvent(flag, b, c));
        if (h.f())
        {
            if (j)
            {
                view = k;
                ((com.shazam.l.h.a) (view)).a.b(false);
                ((com.shazam.l.h.a) (view)).g.a(((com.shazam.l.h.a) (view)).f, false);
                view.a();
                ((com.shazam.l.h.a) (view)).d.a();
                return;
            } else
            {
                view = k;
                ((com.shazam.l.h.a) (view)).a.b(true);
                ((com.shazam.l.h.a) (view)).g.a(((com.shazam.l.h.a) (view)).f, true);
                view.a();
                ((com.shazam.l.h.a) (view)).d.a(new com.shazam.l.h.a.a(view, false, (byte)0));
                ((com.shazam.l.h.a) (view)).c.a();
                return;
            }
        } else
        {
            k.a.d();
            return;
        }
    }

    protected int[] onCreateDrawableState(int i1)
    {
        int ai[] = super.onCreateDrawableState(i1 + 1);
        if (j)
        {
            mergeDrawableStates(ai, d);
        }
        return ai;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        setEnabled(true);
        if (k != null)
        {
            k.b();
        }
    }

    public void setExtraAnalyticsParams(com.shazam.android.analytics.event.factory.FollowButtonEventFactory.Origin origin)
    {
        a(origin, ((String) (null)));
    }

    public void setFollowButtonStateListener(com.shazam.android.widget.button.follow.a a1)
    {
        a = a1;
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        throw new UnsupportedOperationException("FollowButton handles click state itself");
    }

}
