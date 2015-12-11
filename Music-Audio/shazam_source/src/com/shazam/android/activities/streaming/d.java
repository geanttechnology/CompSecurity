// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shazam.android.activities.b;
import com.shazam.android.activities.c;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.StreamingEventFactory;
import com.shazam.i.b.aq.a;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.availability.AppInstallationVerifier;
import com.shazam.model.configuration.PlayWithConfiguration;
import com.shazam.server.response.config.Option;
import java.util.List;

// Referenced classes of package com.shazam.android.activities.streaming:
//            b

public abstract class com.shazam.android.activities.streaming.d extends com.shazam.android.activities.b
    implements com.shazam.android.activities.c
{
    private final class a
        implements com.shazam.android.activities.b.a
    {

        final com.shazam.android.activities.streaming.d b;

        public final void a()
        {
            b.a();
        }

        private a()
        {
            b = com.shazam.android.activities.streaming.d.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements android.view.View.OnClickListener
    {

        final com.shazam.android.activities.streaming.d a;

        public final void onClick(View view)
        {
            a.a();
        }

        private b()
        {
            a = com.shazam.android.activities.streaming.d.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class c
        implements android.view.View.OnClickListener
    {

        final com.shazam.android.activities.streaming.d a;
        private final com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction b;

        public final void onClick(View view)
        {
            a.a(b);
        }

        public c(com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction streamingeventaction)
        {
            a = com.shazam.android.activities.streaming.d.this;
            super();
            b = streamingeventaction;
        }
    }

    protected static final class d
    {

        final String a;
        final String b;
        final String c;
        final String d;
        final com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction e;

        public d(String s, String s1, String s2, String s3, com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction streamingeventaction)
        {
            a = s;
            b = s1;
            c = s2;
            d = s3;
            e = streamingeventaction;
        }
    }


    private final AppInstallationVerifier g = com.shazam.i.b.aq.a.a();
    private final PlayWithConfiguration h = com.shazam.i.b.n.b.y();
    private final EventAnalytics i = com.shazam.i.b.g.b.a.a();
    private final PackageManager j = com.shazam.i.b.c.a().getPackageManager();
    private com.shazam.android.activities.streaming.b k;
    private boolean l;
    private ScreenOrigin m;
    private TextView n;
    private ImageView o;
    private String p;

    public com.shazam.android.activities.streaming.d()
    {
    }

    protected abstract d a(com.shazam.android.activities.streaming.b b1, boolean flag);

    protected final void a()
    {
        i.logEvent(StreamingEventFactory.createStreamingLoginEvent(k, com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.DONE, m, m, b()));
    }

    protected final void a(com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction streamingeventaction)
    {
        Option option = h.a(k.c);
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.values().length];
                try
                {
                    a[com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.SUBSCRIBE_NO_APP_FOUND.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.DOWNLOAD_APP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.OPEN_APP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.shazam.android.analytics.event.factory.StreamingEventFactory.StreamingEventAction.SUBSCRIBE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.shazam.android.activities.streaming._cls1.a[streamingeventaction.ordinal()];
        JVM INSTR tableswitch 1 4: default 56
    //                   1 86
    //                   2 86
    //                   3 109
    //                   4 127;
           goto _L1 _L2 _L2 _L3 _L4
_L1:
        i.logEvent(StreamingEventFactory.createStreamingLoginEvent(k, streamingeventaction, m, m, b()));
        return;
_L2:
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(option.getStore())));
        continue; /* Loop/switch isn't completed */
_L3:
        startActivity(j.getLaunchIntentForPackage(p));
        continue; /* Loop/switch isn't completed */
_L4:
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(option.getSubscribe())));
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected abstract String b();

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!com.shazam.android.util.f.a.b(getIntent(), 1)) goto _L2; else goto _L1
_L1:
        bundle = com.shazam.android.activities.streaming.b.a((String)getIntent().getData().getPathSegments().get(0));
        if (bundle == null) goto _L2; else goto _L3
_L3:
        boolean flag;
        k = bundle;
        flag = true;
_L5:
        if (!flag)
        {
            finish();
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        if (com.shazam.android.util.f.a.b(getIntent(), 2))
        {
            bundle = (String)getIntent().getData().getPathSegments().get(1);
            if (com.shazam.b.e.a.c(bundle))
            {
                m = ScreenOrigin.a(bundle);
            }
        }
        b(0x7f030030);
        n = (TextView)findViewById(0x7f110118);
        o = (ImageView)findViewById(0x7f110117);
        Object obj;
        int i1;
        if (k == com.shazam.android.activities.streaming.b.a)
        {
            bundle = "com.rdio.android.ui";
        } else
        {
            bundle = "com.spotify.music";
        }
        p = bundle;
        l = g.a(p);
        bundle = a(k, l);
        obj = ((d) (bundle)).a;
        super.d.setText(((CharSequence) (obj)));
        n.setText(((d) (bundle)).b);
        obj = o;
        if (k == com.shazam.android.activities.streaming.b.a)
        {
            i1 = 0x7f020130;
        } else
        {
            i1 = 0x7f020131;
        }
        ((ImageView) (obj)).setImageResource(i1);
        obj = ((d) (bundle)).c;
        super.b.setText(((CharSequence) (obj)));
        a(new c(((d) (bundle)).e));
        bundle = ((d) (bundle)).d;
        super.a.setText(bundle);
        b(new b((byte)0));
        super.f = new a((byte)0);
        return;
    }
}
