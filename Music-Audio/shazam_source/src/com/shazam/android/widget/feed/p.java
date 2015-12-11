// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.i;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shazam.android.a.d.a;
import com.shazam.android.analytics.event.AnalyticsInfoFromHierarchy;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.FacebookLogInEventFactory;
import com.shazam.android.k.e.x;
import com.shazam.android.k.f.t;
import com.shazam.android.util.r;
import com.shazam.android.util.s;
import com.shazam.android.widget.k;
import com.shazam.android.widget.text.CustomFontTextView;
import com.shazam.i.b.au.d;
import com.shazam.i.b.u.c;
import com.shazam.i.k.a.b;
import com.shazam.model.account.UserStateDecider;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.facebook.FacebookConnectionState;
import com.shazam.model.facebook.FacebookLoginErrorSource;
import com.shazam.model.news.FeedCard;
import com.shazam.server.request.account.LinkableThirdParty;
import java.util.Locale;

// Referenced classes of package com.shazam.android.widget.feed:
//            j

public final class p extends j
    implements a, com.shazam.android.k.d.a, com.shazam.p.g.a
{

    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private TextView g;
    private CustomFontTextView h;
    private ImageView i;
    private TextView j;
    private CustomFontTextView k;
    private Drawable l;
    private final FacebookConnectionState m = com.shazam.i.b.ap.a.c();
    private final com.shazam.android.v.c.a n = com.shazam.i.b.u.c.a();
    private final com.shazam.a.a o = com.shazam.i.c.a.a();
    private final EventAnalyticsFromView p = com.shazam.i.b.g.b.a.b();
    private final t q = new com.shazam.android.k.f.p();
    private com.shazam.l.g.a r;
    private final UserStateDecider s = com.shazam.i.k.a.b.a();
    private final s t = com.shazam.i.b.au.d.c();

    public p(Context context)
    {
        super(context);
        b = getResources().getDimensionPixelSize(0x7f0a0037);
        c = getResources().getDimensionPixelSize(0x7f0a0038);
        d = com.shazam.android.util.h.b.a(12);
        e = getResources().getDimensionPixelSize(0x7f0a0037);
        f = getResources().getDimensionPixelSize(0x7f0a0038);
        if (getContext() instanceof i)
        {
            i i1 = (i)getContext();
            r = new com.shazam.l.g.a(this, n.a(i1), m, com.shazam.i.b.v.b.a(i1), new com.shazam.android.k.b.a(i1.getSupportLoaderManager(), 10031, i1, new x(o, com.shazam.server.request.account.UnlinkThirdPartyRequest.Builder.unlinkThirdPartyRequest().withType(LinkableThirdParty.FACEBOOK.name().toLowerCase(Locale.US)).build()), com.shazam.android.k.b.i.a), com.shazam.i.k.a.b.a());
        }
        l = getResources().getDrawable(0x7f020080);
        g();
        g = new TextView(context, null, 0x7f01001d);
        g.setId(0x7f11002e);
        Object obj = g;
    /* block-local class not found */
    class a {}

        Resources resources;
        Drawable drawable;
        int j1;
        if (s.g())
        {
            j1 = 0x7f09005c;
        } else
        {
            j1 = 0x7f09009e;
        }
        ((TextView) (obj)).setText(j1);
        h = new CustomFontTextView(context, null);
        h.setId(0x7f11002f);
        h.a(0x7f09020e);
        h.setAllCaps(true);
        h.setTextSize(2, 20F);
        h.setText(0x7f09010b);
        h.setPadding(0, com.shazam.android.util.h.b.a(18), 0, 0);
        a(h);
        i = new ImageView(context, null);
        i.setImageResource(0x7f020143);
        i.setPadding(0, com.shazam.android.util.h.b.a(24), 0, com.shazam.android.util.h.b.a(20));
        k = new CustomFontTextView(context, null, 0x7f01002c);
        k.setId(0x7f11002d);
        obj = k;
        resources = getResources();
        drawable = resources.getDrawable(0x7f020145).mutate();
        drawable.setColorFilter(resources.getColor(0x7f0f0041), android.graphics.PorterDuff.Mode.SRC_IN);
        ((CustomFontTextView) (obj)).setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        k.setOnClickListener(new a((byte)0));
        j();
        j = new TextView(context, null);
        j.setText(0x7f090168);
        context = j;
        a(context);
        context.setTextSize(2, 14F);
        a(new View[] {
            g, h, i, k, j
        });
    }

    static FacebookConnectionState a(p p1)
    {
        return p1.m;
    }

    private void a(TextView textview)
    {
        textview.setMaxLines(2);
        textview.setGravity(17);
        textview.setTextColor(getResources().getColor(0x7f0f009e));
    }

    static com.shazam.l.g.a b(p p1)
    {
        return p1.r;
    }

    static String c(p p1)
    {
        return p1.getScreenNameFromAnalyticsInfo();
    }

    static EventAnalyticsFromView d(p p1)
    {
        return p1.p;
    }

    private String getScreenNameFromAnalyticsInfo()
    {
        return AnalyticsInfoFromHierarchy.addAnalyticsInfoFromViewHierarchy(this).a(DefinedEventParameterKey.SCREEN_NAME);
    }

    private void j()
    {
        CustomFontTextView customfonttextview = k;
        int i1;
        if (m.a())
        {
            i1 = 0x7f090066;
        } else
        {
            i1 = 0x7f09005c;
        }
        customfonttextview.setText(i1);
    }

    public final void a()
    {
        p.logEvent(this, FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.CONNECT_SUCCESS, null, getScreenNameFromAnalyticsInfo()));
        j();
        k.setEnabled(true);
        Object obj = getResources();
        obj = (new StringBuilder()).append(((Resources) (obj)).getString(0x7f09016b)).append(" ").append(((Resources) (obj)).getString(0x7f0901a9)).toString();
        t.a(com.shazam.android.util.r.a(((String) (obj))));
    }

    public final void a(FacebookLoginErrorSource facebookloginerrorsource)
    {
        p.logEvent(this, FacebookLogInEventFactory.createFacebookErrorUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.CONNECT_ERROR, facebookloginerrorsource, null, getScreenNameFromAnalyticsInfo()));
        j();
        k.setEnabled(true);
        t.a(com.shazam.android.util.r.a(0x7f090125));
    }

    protected final boolean a(FeedCard feedcard, int i1)
    {
        return true;
    }

    public final void b()
    {
        j();
        k.setEnabled(true);
        p.logEvent(this, FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.CONNECT_CANCEL, null, getScreenNameFromAnalyticsInfo()));
    }

    public final void b(FacebookLoginErrorSource facebookloginerrorsource)
    {
        j();
        k.setEnabled(true);
        t.a(com.shazam.android.util.r.a(0x7f090124));
        p.logEvent(this, FacebookLogInEventFactory.createFacebookErrorUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.DISCONNECT_ERROR, facebookloginerrorsource, null, getScreenNameFromAnalyticsInfo()));
    }

    public final void c()
    {
        k.setEnabled(false);
    }

    public final void d()
    {
        com.shazam.android.activities.b.b.a(getContext(), getScreenNameFromAnalyticsInfo(), false);
    }

    public final void e()
    {
        if (k.isEnabled())
        {
            k.callOnClick();
        }
    }

    public final void f()
    {
        j();
    }

    public final Uri getUri()
    {
        return q.i();
    }

    public final void l()
    {
        j();
        k.setEnabled(true);
        p.logEvent(this, FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.DISCONNECT_SUCCESS, null, getScreenNameFromAnalyticsInfo()));
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        j();
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (r != null)
        {
            r.c();
        }
    }

    protected final void onDraw(Canvas canvas)
    {
        l.draw(canvas);
        super.onDraw(canvas);
    }

    protected final void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        k.a.a(g).c(0);
        k.a.a(h).a(this).b(g, 0);
        k.a.a(i).a(this).b(h, 0);
        k.a.a(k).a(b).b(i, 0);
        k.a.a(j).a(this).b(k, d);
    }

    protected final void onMeasure(int i1, int j1)
    {
        i1 = android.view.View.MeasureSpec.getSize(i1);
        j1 = i1 - e - f;
        int k1 = b + c;
        g.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(com.shazam.android.util.h.b.a(40), 0x40000000));
        h.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1 - k1, 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        i.measure(android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        k.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1 - k1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(com.shazam.android.util.h.b.a(48), 0x40000000));
        j.measure(android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        j1 = g.getMeasuredHeight() + h.getMeasuredHeight() + i.getMeasuredHeight() + k.getMeasuredHeight() + d + j.getMeasuredHeight() + d;
        Drawable drawable = l;
        float f1 = com.shazam.android.view.a.a.a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), i1, j1);
        l.setBounds(0, g.getMeasuredHeight(), (int)((float)l.getIntrinsicWidth() * f1), (int)(f1 * (float)l.getIntrinsicHeight()));
        setMeasuredDimension(i1, j1);
    }
}
