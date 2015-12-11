// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.shazam.android.activities.c;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.StreamingEventFactory;
import com.shazam.android.l.o;
import com.shazam.android.persistence.n.b;
import com.shazam.i.b.ah.f;
import com.shazam.i.b.ay.a.a;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.player.PlaybackProvider;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// Referenced classes of package com.shazam.android.activities.streaming:
//            b, c

public class StreamingProviderUpsellDialogActivity extends i
    implements c
{
    private final class a
        implements android.view.View.OnClickListener
    {

        final StreamingProviderUpsellDialogActivity a;
        private final com.shazam.android.activities.streaming.b b;

        public final void onClick(View view)
        {
            com.shazam.android.activities.streaming.StreamingProviderUpsellDialogActivity.a(a).logEvent(view, StreamingEventFactory.createStreamingProviderUpsellGoToProviderUserEvent(b));
            a.startActivity(com.shazam.android.activities.streaming.c.a(b, a, ScreenOrigin.PLAY_ALL_UPSELL, com.shazam.android.activities.streaming.StreamingProviderUpsellDialogActivity.c(a)));
            a.finish();
        }

        public a(com.shazam.android.activities.streaming.b b1)
        {
            a = StreamingProviderUpsellDialogActivity.this;
            super();
            b = b1;
        }
    }

    private final class b
        implements android.view.View.OnClickListener
    {

        final StreamingProviderUpsellDialogActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.streaming.StreamingProviderUpsellDialogActivity.a(a).logEvent(view, StreamingEventFactory.createStreamingProviderUpsellCancelUserEvent());
            com.shazam.android.activities.streaming.StreamingProviderUpsellDialogActivity.b(a);
            a.finish();
        }

        private b()
        {
            a = StreamingProviderUpsellDialogActivity.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }


    private final com.shazam.b.a.a a = new o();
    private final Queue b = new PriorityQueue();
    private final com.shazam.android.widget.c.f c = com.shazam.i.b.ay.a.a.b();
    private final com.shazam.android.persistence.n.b d = com.shazam.i.b.ah.f.a();
    private final EventAnalyticsFromView e = com.shazam.i.b.g.b.a.b();
    private Uri f;

    public StreamingProviderUpsellDialogActivity()
    {
    }

    public static Uri a(Set set, Uri uri)
    {
        uri = (new android.net.Uri.Builder()).appendPath(uri.toString());
        for (set = set.iterator(); set.hasNext(); uri.appendQueryParameter("qk_provider", ((PlaybackProvider)set.next()).name())) { }
        set = uri.build();
        return com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.e, new Object[] {
            set.getEncodedPath(), set.getQuery()
        });
    }

    static EventAnalyticsFromView a(StreamingProviderUpsellDialogActivity streamingproviderupselldialogactivity)
    {
        return streamingproviderupselldialogactivity.e;
    }

    private void a()
    {
        c.a(this, f);
    }

    static void b(StreamingProviderUpsellDialogActivity streamingproviderupselldialogactivity)
    {
        streamingproviderupselldialogactivity.a();
    }

    static Uri c(StreamingProviderUpsellDialogActivity streamingproviderupselldialogactivity)
    {
        return streamingproviderupselldialogactivity.f;
    }

    public void onBackPressed()
    {
        a();
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030031);
        bundle = getIntent().getData();
        PlaybackProvider playbackprovider;
        for (Iterator iterator = bundle.getQueryParameters("qk_provider").iterator(); iterator.hasNext(); b.add(a.a(playbackprovider)))
        {
            playbackprovider = PlaybackProvider.valueOf((String)iterator.next());
        }

        if (com.shazam.android.util.f.a.a(getIntent(), 1))
        {
            f = Uri.parse(bundle.getLastPathSegment());
        }
        if (b.size() == 1)
        {
            bundle = (com.shazam.android.activities.streaming.b)b.peek();
            ((ImageView)findViewById(0x7f110119)).setImageResource(((com.shazam.android.activities.streaming.b) (bundle)).g);
        }
        bundle = (ViewGroup)findViewById(0x7f11011a);
        TextView textview;
        for (; !b.isEmpty(); bundle.addView(textview))
        {
            com.shazam.android.activities.streaming.b b1 = (com.shazam.android.activities.streaming.b)b.poll();
            textview = (TextView)getLayoutInflater().inflate(0x7f0300b4, bundle, false);
            textview.setText(String.format(getString(0x7f090130), new Object[] {
                getString(b1.d)
            }));
            textview.setOnClickListener(new a(b1));
        }

        findViewById(0x7f11011b).setOnClickListener(new b((byte)0));
    }

    protected void onResume()
    {
        super.onResume();
        d.b("pk_provider_upsell_shown", true);
    }
}
