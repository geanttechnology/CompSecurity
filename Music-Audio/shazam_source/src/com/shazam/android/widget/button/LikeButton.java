// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.button;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.app.i;
import android.util.AttributeSet;
import android.view.View;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;
import com.shazam.android.util.q;
import com.shazam.android.util.r;
import com.shazam.android.util.s;
import com.shazam.android.widget.c.f;
import com.shazam.android.widget.text.CustomFontTextView;
import com.shazam.b.b;
import com.shazam.i.l.c;
import com.shazam.i.l.d;
import com.shazam.k.m;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.analytics.like.LikeErrorStatus;
import com.shazam.model.facebook.LikingItemFacebookConnectPromptChecker;
import com.shazam.model.like.Like;
import com.shazam.model.like.LikeData;
import com.shazam.p.k.a;
import java.text.NumberFormat;
import java.util.Collections;

public class LikeButton extends CustomFontTextView
    implements android.view.View.OnClickListener, a
{

    private static final int a[] = {
        0x7f010091
    };
    private final com.shazam.k.i b;
    private final m c;
    private final s d;
    private final q e;
    private final EventAnalyticsFromView f;
    private final t g;
    private final com.shazam.android.k.c.a h;
    private final Handler i;
    private final f j;
    private final ContentObserver k;
    private boolean l;
    private com.shazam.l.i.a m;
    private LikeData n;
    private a o;

    public LikeButton(Context context)
    {
        super(context, null, 0x7f010007);
        b = com.shazam.i.l.c.a();
        c = com.shazam.i.l.d.a();
        d = com.shazam.i.b.au.d.a();
        e = r.a();
        f = com.shazam.i.b.g.b.a.b();
        g = new p();
        h = com.shazam.i.b.o.a.a.a();
        i = com.shazam.i.b.z.a.a();
        j = com.shazam.i.b.ay.a.a.b();
        k = new _cls1(i);
    /* block-local class not found */
    class a {}

        o = (a)com.shazam.b.b.a(com/shazam/android/widget/button/LikeButton$a);
        c();
    }

    public LikeButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0x7f010007);
        b = com.shazam.i.l.c.a();
        c = com.shazam.i.l.d.a();
        d = com.shazam.i.b.au.d.a();
        e = r.a();
        f = com.shazam.i.b.g.b.a.b();
        g = new p();
        h = com.shazam.i.b.o.a.a.a();
        i = com.shazam.i.b.z.a.a();
        j = com.shazam.i.b.ay.a.a.b();
        k = new _cls1(i);
        o = (a)com.shazam.b.b.a(com/shazam/android/widget/button/LikeButton$a);
        c();
    }

    public LikeButton(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        b = com.shazam.i.l.c.a();
        c = com.shazam.i.l.d.a();
        d = com.shazam.i.b.au.d.a();
        e = r.a();
        f = com.shazam.i.b.g.b.a.b();
        g = new p();
        h = com.shazam.i.b.o.a.a.a();
        i = com.shazam.i.b.z.a.a();
        j = com.shazam.i.b.ay.a.a.b();
        k = new _cls1(i);
        o = (a)com.shazam.b.b.a(com/shazam/android/widget/button/LikeButton$a);
        c();
    }

    public LikeButton(Context context, AttributeSet attributeset, int i1, int j1)
    {
        super(context, attributeset, i1, j1);
        b = com.shazam.i.l.c.a();
        c = com.shazam.i.l.d.a();
        d = com.shazam.i.b.au.d.a();
        e = r.a();
        f = com.shazam.i.b.g.b.a.b();
        g = new p();
        h = com.shazam.i.b.o.a.a.a();
        i = com.shazam.i.b.z.a.a();
        j = com.shazam.i.b.ay.a.a.b();
        k = new _cls1(i);
        o = (a)com.shazam.b.b.a(com/shazam/android/widget/button/LikeButton$a);
        c();
    }

    static com.shazam.l.i.a a(LikeButton likebutton)
    {
        return likebutton.m;
    }

    private void a(Context context)
    {
        context.getContentResolver().unregisterContentObserver(k);
    }

    private void a(boolean flag, String s1, String s2)
    {
        EventAnalyticsFromView eventanalyticsfromview = f;
        com.shazam.android.analytics.event.Event.Builder builder = com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT);
        com.shazam.android.analytics.event.EventParameters.Builder builder1 = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters();
        DefinedEventParameterKey definedeventparameterkey = DefinedEventParameterKey.TYPE;
        String s3;
        if (flag)
        {
            s3 = "like";
        } else
        {
            s3 = "unlike";
        }
        s2 = builder1.putNotEmptyOrNullParameter(definedeventparameterkey, s3).putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.EVENT_ID, n.eventId).putNotEmptyOrNullParameter(com.shazam.android.analytics.event.StringEventParameterKey.Builder.stringEventParameterKey().withParameterKey("likekey").build(), n.likeKey).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, n.trackKey).putNotEmptyOrNullParameter(DefinedEventParameterKey.ERROR_CODE, s2);
        s1 = n;
        if (((LikeData) (s1)).beaconData == null)
        {
            s1 = Collections.emptyMap();
        } else
        {
            s1 = ((LikeData) (s1)).beaconData;
        }
        eventanalyticsfromview.logEvent(this, builder.withParameters(s2.putNotEmptyOrNullParametersWithUndefinedKeys(s1).build()).build());
    }

    static EventAnalyticsFromView b(LikeButton likebutton)
    {
        return likebutton.f;
    }

    static f c(LikeButton likebutton)
    {
        return likebutton.j;
    }

    private void c()
    {
        setCompoundDrawablesWithIntrinsicBounds(0x7f02014f, 0, 0, 0);
        super.setOnClickListener(this);
    }

    public final void a()
    {
        setVisibility(8);
    }

    public final void a(Like like)
    {
        Resources resources;
        int i1;
        l = like.isLiked;
        setVisibility(0);
        refreshDrawableState();
        resources = getResources();
        i1 = like.count;
        i1;
        JVM INSTR tableswitch 0 1: default 52
    //                   0 95
    //                   1 106;
           goto _L1 _L2 _L3
_L1:
        like = resources.getString(0x7f0900c1, new Object[] {
            NumberFormat.getInstance().format(i1)
        });
_L5:
        setText(like);
        setVisibility(0);
        o.a();
        return;
_L2:
        like = resources.getString(0x7f090097);
        continue; /* Loop/switch isn't completed */
_L3:
        like = resources.getString(0x7f0900cc);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void a(LikeData likedata)
    {
        n = likedata;
        Context context = getContext();
        android.support.v4.app.o o1 = ((i)context).getSupportLoaderManager();
        likedata = likedata.likeKey;
        m = new com.shazam.l.i.a(this, new com.shazam.android.k.b.a(o1, h.a(g.k(likedata)), context, new com.shazam.android.k.e.c.b(com.shazam.i.c.b.a(), com.shazam.i.b.n.b.E(), likedata), com.shazam.android.k.b.i.b), new com.shazam.android.k.b.a(o1, h.a(g.l(likedata)), context, new com.shazam.android.k.e.c.c(com.shazam.i.c.b.a(), com.shazam.i.b.n.b.E(), likedata), com.shazam.android.k.b.i.b), b, c, com.shazam.i.l.b.a(), new LikingItemFacebookConnectPromptChecker(com.shazam.i.l.b.a(), com.shazam.i.b.ap.a.c()), likedata);
        m.a();
        a(context);
        context.getContentResolver().registerContentObserver(g.k(likedata), false, k);
        context.getContentResolver().registerContentObserver(g.l(likedata), false, k);
    }

    public final void a(boolean flag)
    {
        m.c();
        a(flag, "success", null);
    }

    public final void a(boolean flag, LikeErrorStatus likeerrorstatus)
    {
        m.c();
        d.a(e);
        a(flag, "error", likeerrorstatus.getBeaconValue());
    }

    public final void b()
    {
        postDelayed(new _cls2(), 150L);
    }

    public void onClick(View view)
    {
        if (l)
        {
            view = m;
            Like like = view.b();
            if (!com.shazam.l.i.a.a(like))
            {
                ((com.shazam.l.i.a) (view)).a.a(false, LikeErrorStatus.FAILED);
            } else
            {
                Object obj = com.shazam.model.like.Like.Builder.a(like);
                obj.isLiked = false;
                obj.count = like.count - 1;
                obj = ((com.shazam.model.like.Like.Builder) (obj)).b();
                ((com.shazam.l.i.a) (view)).a.a(((Like) (obj)));
                ((com.shazam.l.i.a) (view)).d.a(obj);
                ((com.shazam.l.i.a) (view)).c.a(new com.shazam.l.i.a.a(view, like, (byte)0));
                ((com.shazam.l.i.a) (view)).c.a();
            }
            a(false, "request", null);
            return;
        }
        view = m;
        Like like1 = view.b();
        if (!com.shazam.l.i.a.a(like1))
        {
            ((com.shazam.l.i.a) (view)).a.a(true, LikeErrorStatus.FAILED);
        } else
        {
            Object obj1 = com.shazam.model.like.Like.Builder.a(like1);
            obj1.isLiked = true;
            obj1.count = like1.count + 1;
            obj1 = ((com.shazam.model.like.Like.Builder) (obj1)).b();
            ((com.shazam.l.i.a) (view)).a.a(((Like) (obj1)));
            ((com.shazam.l.i.a) (view)).d.a(obj1);
            ((com.shazam.l.i.a) (view)).b.a(new com.shazam.l.i.a.a(view, like1, (byte)0));
            ((com.shazam.l.i.a) (view)).b.a();
        }
        a(true, "request", null);
    }

    protected int[] onCreateDrawableState(int i1)
    {
        int ai[] = super.onCreateDrawableState(i1 + 1);
        if (l)
        {
            mergeDrawableStates(ai, a);
        }
        return ai;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        a(getContext());
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        throw new UnsupportedOperationException("LikeButton handles click state itself");
    }

    public void setOnLikeCountChangedListener(a a1)
    {
        o = a1;
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
