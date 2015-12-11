// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.artist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.support.v4.view.w;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.g.c.af;
import com.shazam.android.activities.sheet.ShareDataBottomSheetActivity;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.af.a.a;
import com.shazam.android.analytics.AnalyticsInfoProvider;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AddOnSelectedEventFactory;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.ArtistProfilePage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.fragment.a.b;
import com.shazam.android.k.f.i;
import com.shazam.android.k.f.j;
import com.shazam.android.util.q;
import com.shazam.android.util.r;
import com.shazam.android.util.s;
import com.shazam.android.v.e.e;
import com.shazam.android.widget.button.follow.FollowButton;
import com.shazam.android.widget.c.f;
import com.shazam.android.widget.image.UrlCachingImageView;
import com.shazam.android.widget.image.d.a.c;
import com.shazam.android.widget.image.d.a.g;
import com.shazam.android.widget.n;
import com.shazam.android.widget.text.ArtistNameTextView;
import com.shazam.android.widget.text.ExpandableCustomFontTextView;
import com.shazam.i.b.au.d;
import com.shazam.model.TrackCategory;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.artist.ArtistProfile;
import com.shazam.model.share.ShareData;
import com.shazam.server.response.follow.FollowData;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ArtistProfileActivity extends BaseAppCompatActivity
    implements com.shazam.android.af.a.a, AnalyticsInfoProvider, SessionConfigurable, com.shazam.android.fragment.a.b, com.shazam.p.b.b
{
    private final class a
        implements android.content.DialogInterface.OnClickListener
    {

        final ArtistProfileActivity a;

        public final void onClick(DialogInterface dialoginterface, int i1)
        {
            dialoginterface = com.shazam.android.activities.artist.ArtistProfileActivity.a(a);
            ((com.shazam.l.b.b) (dialoginterface)).a.b();
            ((com.shazam.l.b.b) (dialoginterface)).a.a();
        }

        private a()
        {
            a = ArtistProfileActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements android.content.DialogInterface.OnClickListener
    {

        final ArtistProfileActivity a;

        public final void onClick(DialogInterface dialoginterface, int i1)
        {
            com.shazam.android.activities.artist.ArtistProfileActivity.a(a).a.a();
        }

        private b()
        {
            a = ArtistProfileActivity.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }


    private final EventAnalyticsFromView a = com.shazam.i.b.g.b.a.b();
    private final n b = com.shazam.i.b.ay.a.a();
    private final com.shazam.android.activities.deeplink.a c = new com.shazam.android.activities.deeplink.b();
    private final j d = new j();
    private final f e = com.shazam.i.b.ay.a.a.b();
    private final com.shazam.android.j.w.c f = com.shazam.i.b.n.b.E();
    private final com.shazam.a.g g = com.shazam.i.c.b.a();
    private final q h = com.shazam.android.util.r.b();
    private final s i = com.shazam.i.b.au.d.a();
    private ArtistProfile j;
    private String k;
    private com.shazam.l.b.b l;
    private com.shazam.android.widget.a m;
    private ColorDrawable n;
    private View o;
    private Toolbar p;
    private int q;
    private View r;
    private AlertDialog s;
    private i t;
    private ArtistProfilePage u;

    public ArtistProfileActivity()
    {
    }

    static com.shazam.l.b.b a(ArtistProfileActivity artistprofileactivity)
    {
        return artistprofileactivity.l;
    }

    private void b(float f1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            w.f(p, (float)getResources().getDimensionPixelSize(0x7f0a0098) * f1);
            return;
        }
        if (f1 > 0.0F)
        {
            r.setVisibility(0);
            r.setAlpha(f1);
            return;
        } else
        {
            r.setVisibility(8);
            return;
        }
    }

    private String f()
    {
        Uri uri = getIntent().getData();
        if ("shazam_activity".equals(uri.getScheme()))
        {
            return uri.getLastPathSegment();
        }
        if ("shazam".equals(uri.getScheme()))
        {
            if (g())
            {
                return (String)uri.getPathSegments().get(uri.getPathSegments().size() - 2);
            } else
            {
                return uri.getLastPathSegment();
            }
        } else
        {
            return (String)uri.getPathSegments().get(1);
        }
    }

    private boolean g()
    {
        return "follow".equals(getIntent().getData().getLastPathSegment());
    }

    private String h()
    {
        if (i())
        {
            return ScreenOrigin.NOTIFICATION.value;
        } else
        {
            return t.a().a(DefinedEventParameterKey.SCREEN_ORIGIN);
        }
    }

    private boolean i()
    {
        return getIntent().hasExtra("com.shazam.android.analytic_source");
    }

    private com.shazam.android.fragment.a.a j()
    {
        return (com.shazam.android.fragment.a.a)getSupportFragmentManager().a("artistFeedFragment");
    }

    public final View a(View view)
    {
        View view1 = view.findViewById(0x7f1100ae);
        if (view1 == null)
        {
            return view;
        } else
        {
            return view1;
        }
    }

    public final void a()
    {
        if (s != null)
        {
            Uri uri = getIntent().getData();
            String s1 = uri.getPath();
            s1 = s1.substring(0, s1.indexOf("/follow"));
            setIntent(getIntent().setData(uri.buildUpon().path(s1).build()));
            s.dismiss();
        }
    }

    public final void a(float f1)
    {
        float f2 = Math.min(f1 * 2.0F, 1.0F);
        int i1 = (int)(255F * f2);
        com.shazam.android.widget.a a1 = m;
        int j1 = a1.a;
        a1.a = i1;
        if (j1 != i1)
        {
            a1.invalidateSelf();
        }
        f1 = Math.max(0.0F, f1 - 0.5F) * 2.0F;
        if (f1 > 0.0F)
        {
            p.setBackgroundColor(q);
            b(f1);
        } else
        {
            p.setBackgroundResource(0x7f0f0098);
            b(0.0F);
        }
        if (o != null)
        {
            o.setAlpha(f2);
        }
    }

    public final void a(int i1)
    {
        com.shazam.android.fragment.a.a a1 = j();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(NumberFormat.getInstance().format(i1));
        stringbuilder.append(" ");
        if (i1 == 1)
        {
            i1 = 0x7f090082;
        } else
        {
            i1 = 0x7f090083;
        }
        stringbuilder.append(a1.getString(i1));
        a1.d.setText(stringbuilder.toString());
        ((android.support.v7.widget.RecyclerView.a) (a1.c)).a.a();
    }

    public final void a(ArtistProfile artistprofile)
    {
        j = artistprofile;
        u.setIsVerified(artistprofile.verified);
        com.shazam.android.fragment.a.a a1 = j();
        a1.ak = artistprofile.adParams;
        a1.aj.h();
        Object obj = artistprofile.name;
        Object obj1 = a1.getActivity();
        if (obj1 != null)
        {
            ((android.support.v4.app.i) (obj1)).setTitle(((CharSequence) (obj)));
        }
        a1.e.setText(((CharSequence) (obj)));
        a1.e.setVerified(artistprofile.verified);
        boolean flag;
        if (artistprofile.biography == null)
        {
            obj = "";
        } else
        {
            obj = artistprofile.biography;
        }
        obj1 = artistprofile.footNotes;
        if (com.shazam.b.e.a.c(((String) (obj))) || com.shazam.b.e.a.c(((String) (obj1))))
        {
            a1.f.setVisibility(0);
            a1.f.setText(com.shazam.android.fragment.a.a.a(((String) (obj)), ((String) (obj1))));
        } else
        {
            a1.f.setVisibility(8);
        }
        obj = a1.g.a(artistprofile.defaultAvatar);
        obj.h = 0x7f020196;
        obj.e = 0x7f020196;
        obj.c = new c(new af[] {
            new com.shazam.android.fragment.a.a.d(a1, (byte)0), new g(artistprofile.defaultAvatar, a1)
        });
        ((com.shazam.android.widget.image.UrlCachingImageView.a) (obj)).c();
        a1.f.setOnClickListener(new com.shazam.android.fragment.a.a._cls1(a1, artistprofile));
        obj = a1.h;
        obj1 = com.shazam.model.follow.FollowData.Builder.a();
        obj1.artistId = artistprofile.id;
        obj1.followKey = artistprofile.a().key;
        ((FollowButton) (obj)).a(((com.shazam.model.follow.FollowData.Builder) (obj1)).b(), true);
        a1.h.setExtraAnalyticsParams(com.shazam.android.analytics.event.factory.FollowButtonEventFactory.Origin.ARTIST);
        obj = new ArrayList();
        ((List) (obj)).add(a1.i);
        a1.i.getViewTreeObserver().addOnPreDrawListener(new com.shazam.android.fragment.a.a.b(a1, (byte)0));
        a1.c.b(((List) (obj)));
        a1.b.a();
        a1.b.c();
        obj = getSupportActionBar();
        if (obj != null)
        {
            ((android.support.v7.a.a) (obj)).g();
        }
        obj = getIntent().getData();
        if ("shazam_activity".equals(((Uri) (obj)).getScheme()) && com.shazam.b.e.a.c(((Uri) (obj)).getQueryParameter("shouldDisplayFollowingToast")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            artistprofile = artistprofile.name;
            i.a(com.shazam.android.util.r.a(getString(0x7f090087, new Object[] {
                artistprofile
            })));
            artistprofile = j();
            ((com.shazam.android.fragment.a.a) (artistprofile)).a.a();
            artistprofile = ((com.shazam.android.fragment.a.a) (artistprofile)).h;
            if (((FollowButton) (artistprofile)).b != null)
            {
                artistprofile.a(((FollowButton) (artistprofile)).b, true);
            }
        }
    }

    public final void a(String s1)
    {
        s = (new android.app.AlertDialog.Builder(this)).setMessage(getString(0x7f090166, new Object[] {
            s1
        })).setPositiveButton(0x7f09016a, new a((byte)0)).setNegativeButton(0x7f0900b7, new b((byte)0)).create();
        s.show();
    }

    public final void b()
    {
        j().h.performClick();
    }

    public final void b(int i1)
    {
        q = i1;
        n.setColor(i1);
        m.invalidateSelf();
    }

    public final void c()
    {
        com.shazam.android.activities.b.b.b(this);
        finish();
    }

    public void configureWith(Page page)
    {
        ArtistProfilePage artistprofilepage = (ArtistProfilePage)page;
        u = artistprofilepage;
        artistprofilepage.setArtistId(k);
        artistprofilepage.setScreenOrigin(h());
        if (i())
        {
            page = null;
        } else
        {
            page = t.a().a(DefinedEventParameterKey.EVENT_ID);
        }
        artistprofilepage.setEventId(page);
    }

    public final void d()
    {
        s s1 = i;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f090047;
        s1.a(a1.a());
    }

    public final void e()
    {
        i.a(h);
        finish();
    }

    public AnalyticsInfo getAnalyticsInfo()
    {
        return com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.SCREEN_NAME, "artist").a(DefinedEventParameterKey.ARTIST_ID, k).a(DefinedEventParameterKey.SCREEN_ORIGIN, h()).b();
    }

    protected void onCreate(Bundle bundle)
    {
        if (getIntent().getData() == null)
        {
            finish();
            return;
        }
        super.onCreate(bundle);
        setContentView(0x7f030019);
        bundle = findViewById(0x7f1100af);
        r = findViewById(0x7f1100b2);
        p = (Toolbar)findViewById(0x7f1100b0);
        p.setBackgroundResource(0x7f0f0098);
        b(0.0F);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            p.setOutlineProvider(new ViewOutlineProvider() {

                final ArtistProfileActivity a;

                public final void getOutline(View view, Outline outline)
                {
                    outline.setRect(-50, -500, view.getWidth() + 50, view.getHeight());
                }

            
            {
                a = ArtistProfileActivity.this;
                super();
            }
            });
        }
        Resources resources = getResources();
        n = new ColorDrawable(resources.getColor(0x7f0f0098));
        m = new com.shazam.android.widget.a(resources.getDrawable(0x7f020047), n);
        b.a(bundle, m);
        b(resources.getColor(0x7f0f007b));
        int i1 = 0;
        do
        {
label0:
            {
                if (i1 < p.getChildCount())
                {
                    bundle = p.getChildAt(i1);
                    if (!(bundle instanceof TextView))
                    {
                        break label0;
                    }
                    o = bundle;
                    o.setAlpha(0.0F);
                }
                k = f();
                t = com.shazam.android.k.f.j.a(getIntent());
                bundle = getSupportLoaderManager();
                l = new com.shazam.l.b.b(this, new com.shazam.android.k.b.a(bundle, 10017, this, com.shazam.android.k.c.a(new com.shazam.android.k.e.a(g, f, k), com.shazam.i.d.d.G()), com.shazam.android.k.b.i.a), new e(this, bundle, com.shazam.i.c.b.a(), com.shazam.i.b.n.b.E()), new com.shazam.android.v.e.d(bundle, this, com.shazam.i.c.b.a(), com.shazam.i.b.n.b.E()), g());
                if (j() == null)
                {
                    getSupportFragmentManager().a().b(0x7f1100ae, com.shazam.android.fragment.a.a.a(k), "artistFeedFragment").a();
                }
                bundle = l;
                ((com.shazam.l.b.b) (bundle)).b.a(new com.shazam.l.b.b.c(bundle, (byte)0));
                ((com.shazam.l.b.b) (bundle)).b.a();
                return;
            }
            i1++;
        } while (true);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(0x7f130006, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            menuitem = getIntent();
            if (menuitem != null && c.a(new Uri[] {
    menuitem.getData()
}))
            {
                com.shazam.android.activities.b.a.a(this, false);
                finish();
                return true;
            } else
            {
                onBackPressed();
                return true;
            }

        case 2131821200: 
            menuitem = j.b();
            com.shazam.android.analytics.module.AddOnAnalyticsInfo addonanalyticsinfo = com.shazam.android.analytics.module.AddOnAnalyticsInfo.Builder.addOnAnalyticsInfo().withProviderName("Share").withScreenName("artist").withArtistId(f()).withTrackCategory(TrackCategory.MUSIC.toString()).withTrackId(((ShareData) (menuitem)).trackId).withBeaconKey(((ShareData) (menuitem)).beaconKey).withCampaign(((ShareData) (menuitem)).campaign).withTagResultVersion(((ShareData) (menuitem)).trackStyle).build();
            Object obj = new com.shazam.android.k.f.i.a();
            obj.a = com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.PROVIDER_NAME, "Share").a(DefinedEventParameterKey.SCREEN_NAME, "artist").a(DefinedEventParameterKey.TRACK_CATEGORY, TrackCategory.MUSIC.toString()).a(DefinedEventParameterKey.ARTIST_ID, f()).b();
            obj = ((com.shazam.android.k.f.i.a) (obj)).a();
            e.a(this, com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.r, new Object[0]), ShareDataBottomSheetActivity.a(menuitem), ((i) (obj)));
            a.logEvent(p, AddOnSelectedEventFactory.addOnSelectedEvent(addonanalyticsinfo));
            return true;
        }
    }

    protected void onPause()
    {
        super.onPause();
        j().onUnselected();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        menu = menu.findItem(0x7f110290);
        boolean flag;
        if (j != null && j.b().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        menu.setVisible(flag);
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        j().onSelected();
    }

    protected void onStop()
    {
        super.onStop();
        l.b.c();
    }
}
