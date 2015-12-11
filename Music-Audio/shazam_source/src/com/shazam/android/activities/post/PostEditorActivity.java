// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.post;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.i;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shazam.android.activities.share.ShareTagDialogActivity;
import com.shazam.android.ad.e;
import com.shazam.android.analytics.event.BeaconErrorCode;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.woodstock.PostEventFactory;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.k.e.ab;
import com.shazam.android.util.r;
import com.shazam.android.util.s;
import com.shazam.android.widget.AnimatorViewFlipper;
import com.shazam.android.widget.c.f;
import com.shazam.android.widget.image.UrlCachingImageView;
import com.shazam.i.b.au.d;
import com.shazam.i.b.c;
import com.shazam.i.b.n.b;
import com.shazam.model.analytics.woodstock.PostAnalyticsInfo;
import com.shazam.model.configuration.ShareTagConfiguration;
import com.shazam.model.details.TrackPublishInfo;
import com.shazam.model.post.Post;
import com.shazam.p.n.a;

public class PostEditorActivity extends AutoToolbarBaseAppCompatActivity
    implements com.shazam.p.n.a
{
    private final class a extends e
    {

        final PostEditorActivity a;

        public final void onTextChanged(CharSequence charsequence, int l, int i1, int j1)
        {
            com.shazam.android.activities.post.PostEditorActivity.a(a).g = charsequence.toString();
        }

        private a()
        {
            a = PostEditorActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    private final s a = com.shazam.i.b.au.d.a();
    private final EventAnalyticsFromView b = com.shazam.i.b.g.b.a.b();
    private final InputMethodManager c = (InputMethodManager)com.shazam.i.b.c.a().getSystemService("input_method");
    private final ShareTagConfiguration d = com.shazam.i.b.n.b.S();
    private final f e = com.shazam.i.b.ay.a.a.b();
    private com.shazam.l.n.a f;
    private AnimatorViewFlipper g;
    private EditText h;
    private ViewGroup i;
    private TextView j;
    private UrlCachingImageView k;

    public PostEditorActivity()
    {
    }

    static com.shazam.l.n.a a(PostEditorActivity posteditoractivity)
    {
        return posteditoractivity.f;
    }

    private void e()
    {
        b.logEvent(g, PostEventFactory.createPublishPostEventFor(com.shazam.android.analytics.event.factory.woodstock.PostEventFactory.PublishAction.SUCCESS, g()));
        finish();
    }

    private String f()
    {
        return getIntent().getData().getQueryParameter("key");
    }

    private PostAnalyticsInfo g()
    {
        com.shazam.model.analytics.woodstock.PostAnalyticsInfo.Builder builder = com.shazam.model.analytics.woodstock.PostAnalyticsInfo.Builder.a();
        builder.trackKey = f();
        return builder.b();
    }

    public final void a()
    {
        b.logEvent(g, PostEventFactory.createPublishPostEventFor(com.shazam.android.analytics.event.factory.woodstock.PostEventFactory.PublishAction.POST, g()));
        g.setDisplayedChild(1);
    }

    public final void a(TrackPublishInfo trackpublishinfo)
    {
        UrlCachingImageView urlcachingimageview = (UrlCachingImageView)findViewById(0x7f1100fc);
        TextView textview = (TextView)findViewById(0x7f1100fd);
        ((TextView)findViewById(0x7f1100fe)).setText(trackpublishinfo.artist);
        textview.setText(trackpublishinfo.title);
        trackpublishinfo = urlcachingimageview.a(trackpublishinfo.coverArt);
        trackpublishinfo.f = com.shazam.android.widget.image.d.a;
        trackpublishinfo.j = true;
        trackpublishinfo.c();
    }

    public final void a(Post post)
    {
        e.a(this, com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.q, new Object[0]), ShareTagDialogActivity.a(post.shareData));
        e();
    }

    public final void a(com.shazam.p.n.b b1)
    {
        i.setVisibility(0);
        j.setText(getString(0x7f090119, new Object[] {
            b1.a
        }));
        b1 = k.a(b1.b);
        b1.e = 0x7f020196;
        b1.f = com.shazam.android.widget.image.d.a;
        b1.c();
    }

    public final void b()
    {
        s s1 = a;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f09014e;
        a1.h = 0x7f0300b7;
        a1.c = 0;
        s1.a(a1.a());
        e();
    }

    public final void c()
    {
        b.logEvent(g, PostEventFactory.createPublishPostErrorEventFor(g(), BeaconErrorCode.FAILED));
        g.setDisplayedChild(0);
        a.a(r.a());
    }

    public final void d()
    {
        b.logEvent(g, PostEventFactory.createPublishPostErrorEventFor(g(), BeaconErrorCode.UNAUTHORIZED));
        com.shazam.android.activities.b.b.b(this);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002a);
        Object obj = getIntent().getData();
        bundle = f();
        String s1 = ((Uri) (obj)).getQueryParameter("title");
        String s2 = ((Uri) (obj)).getQueryParameter("artist");
        String s3 = ((Uri) (obj)).getQueryParameter("cover");
        obj = ((Uri) (obj)).getQueryParameter("tagId");
        com.shazam.model.details.TrackPublishInfo.Builder builder = com.shazam.model.details.TrackPublishInfo.Builder.a();
        builder.tagId = ((String) (obj));
        builder.trackKey = bundle;
        builder.artist = s2;
        builder.title = s1;
        builder.coverArt = s3;
        f = new com.shazam.l.n.a(this, builder.b(), new com.shazam.android.v.e.a(getSupportLoaderManager(), this), d, new com.shazam.android.k.b.a(getSupportLoaderManager(), 10022, this, com.shazam.android.k.c.a(new ab(com.shazam.i.c.a.a()), com.shazam.i.d.d.E()), com.shazam.android.k.b.i.b));
        g = (AnimatorViewFlipper)findViewById(0x7f1100b4);
        h = (EditText)findViewById(0x7f1100fb);
        h.addTextChangedListener(new a((byte)0));
        i = (LinearLayout)findViewById(0x7f1100f7);
        j = (TextView)findViewById(0x7f1100f9);
        k = (UrlCachingImageView)findViewById(0x7f1100f8);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f130002, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int l = menuitem.getItemId();
        if (l == 0x7f11028c)
        {
            menuitem = f;
            ((com.shazam.l.n.a) (menuitem)).a.a();
            Object obj = com.shazam.server.request.post.PublishPostRequest.Builder.publishPostRequest().withType("track").withPostContent(com.shazam.server.request.post.PostContent.Builder.postContent().withTrackKey(((com.shazam.l.n.a) (menuitem)).b.trackKey).withCaption(((com.shazam.l.n.a) (menuitem)).g).build()).build();
            obj = ((com.shazam.l.n.a) (menuitem)).c.a(((com.shazam.server.request.post.PublishPostRequest) (obj)), ((com.shazam.l.n.a) (menuitem)).b.tagId);
            ((com.shazam.g.a) (obj)).a(new com.shazam.l.n.a.a(menuitem, (byte)0));
            ((com.shazam.g.a) (obj)).a();
            c.hideSoftInputFromWindow(h.getWindowToken(), 1);
            return true;
        }
        if (l == 0x102002c)
        {
            onBackPressed();
            return true;
        } else
        {
            return false;
        }
    }

    public void onStart()
    {
        super.onStart();
        com.shazam.l.n.a a1 = f;
        a1.a.a(a1.b);
        a1.e.a(a1.f);
        a1.e.a();
    }
}
