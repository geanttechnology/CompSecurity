// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.player;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import at.technikum.mti.fancycoverflow.FancyCoverFlow;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.PlayerEventFactory;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.k.b.q;
import com.shazam.android.service.player.MusicPlayerService;
import com.shazam.android.service.player.y;
import com.shazam.android.widget.player.PlayerBackgroundView;
import com.shazam.android.widget.player.PlayerControlView;
import com.shazam.android.widget.player.PlayerItemCoverArtImageView;
import com.shazam.android.widget.player.PlayerLikeDislikeBar;
import com.shazam.android.widget.player.PlayerNavigationUnderlayView;
import com.shazam.android.widget.player.d;
import com.shazam.android.widget.player.e;
import com.shazam.android.widget.preview.PreviewButton;
import com.shazam.i.b.c;
import com.shazam.j.b;
import com.shazam.model.Tag;
import com.shazam.model.details.TagAdder;
import com.shazam.model.player.PlayerItemStatus;
import com.shazam.model.player.Playlist;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.store.Stores;
import com.shazam.p.m.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;

public class PlayerFragment extends BaseFragment
    implements ServiceConnection, android.widget.AdapterView.OnItemClickListener, y, com.shazam.android.widget.player.PlayerControlView.a, d, e, a
{

    private ProgressBar aA;
    private View aB;
    private Uri aC;
    private TextView aD;
    private TextView aE;
    private SeekBar aF;
    private boolean aG;
    private final EventAnalytics aj = com.shazam.i.b.g.b.a.a();
    private final b ak = com.shazam.i.j.a.b();
    private final com.shazam.android.a.f.a al = new com.shazam.android.a.f.a();
    private int am;
    private int an;
    private com.shazam.l.m.a ao;
    private TextView ap;
    private TextView aq;
    private TextView ar;
    private PlayerControlView as;
    private Playlist at;
    private PlaylistItem au;
    private FancyCoverFlow av;
    private PlayerBackgroundView aw;
    private PlayerLikeDislikeBar ax;
    private boolean ay;
    private MusicPlayerService az;
    private final com.shazam.android.fragment.h.a.b b;
    private final com.shazam.b.a.a d = com.shazam.i.d.d.w();
    private final com.shazam.android.v.g.b e = com.shazam.i.b.v.a.a.a();
    private final com.shazam.k.c f = com.shazam.i.b.ah.f.a.a();
    private final android.support.v4.a.e g = android.support.v4.a.e.a(com.shazam.i.b.c.a());
    private final e h = new e((byte)0);
    private final d i = new d((byte)0);

    public PlayerFragment()
    {
        b = com.shazam.i.b.d.a.a(com.shazam.server.request.tag.RequestTag.Type.PLAYER);
    /* block-local class not found */
    class e {}

    /* block-local class not found */
    class d {}

    }

    static String a(int i1)
    {
        return c(i1);
    }

    private static void a(int i1, PlaylistItem playlistitem, PlayerItemCoverArtImageView playeritemcoverartimageview)
    {
        com.shazam.android.widget.image.g.a a1 = new com.shazam.android.widget.image.g.a();
        a1.a = i1 + 1;
        a1.b = playlistitem.coverArtUrl;
        playeritemcoverartimageview.a(a1.a(), false);
        playeritemcoverartimageview.a(PlayerItemStatus.NEUTRAL, 1.0F);
    }

    private void a(int i1, boolean flag, boolean flag1)
    {
        b(-1, -1);
        Object obj = ax.getPrimaryCover();
        ((PlayerItemCoverArtImageView) (obj)).setVisibility(0);
        if (flag1)
        {
            az.a(i1, false);
        }
        az.f.add(new WeakReference(this));
        au = (PlaylistItem)at.items.get(i1);
        Object obj1 = aw;
        ((PlayerBackgroundView) (obj1)).a(au.coverArtUrl, ((PlayerBackgroundView) (obj1)).b);
        a(i1, au, ((PlayerItemCoverArtImageView) (obj)));
        ap.setText(au.title);
        aq.setText(au.artist);
        obj = as;
        obj1 = au;
        PreviewButton previewbutton = ((PlayerControlView) (obj)).b;
        com.shazam.model.preview.PreviewViewData.Builder builder = com.shazam.model.preview.PreviewViewData.Builder.a();
        builder.playlistItem = ((PlaylistItem) (obj1));
        previewbutton.setPreviewViewData(builder.b());
        ((PlayerControlView) (obj)).b.setMinimised(false);
        obj1 = ((PlaylistItem) (obj1)).storeData;
        if (obj1 != null)
        {
            ((PlayerControlView) (obj)).a.a(((Stores) (obj1)).a(), ((PlayerControlView) (obj)).c, com.shazam.android.widget.image.c.c.a);
        }
        if (flag)
        {
            av.setSelection(i1);
        }
        i1++;
        obj1 = at.items;
        obj = ax.getSecondaryCover();
        if (obj1 == null || ((List) (obj1)).size() <= 1 || i1 >= ((List) (obj1)).size())
        {
            ((PlayerItemCoverArtImageView) (obj)).setVisibility(4);
            return;
        } else
        {
            ((PlayerItemCoverArtImageView) (obj)).setVisibility(0);
            obj1 = (PlaylistItem)((List) (obj1)).get(i1);
            PlayerBackgroundView playerbackgroundview = aw;
            playerbackgroundview.a(((PlaylistItem) (obj1)).coverArtUrl, playerbackgroundview.a);
            a(i1, ((PlaylistItem) (obj1)), ((PlayerItemCoverArtImageView) (obj)));
            return;
        }
    }

    static void a(PlayerFragment playerfragment, int i1)
    {
        playerfragment.a(i1, true, false);
    }

    static void a(PlayerFragment playerfragment, PlayerItemCoverArtImageView playeritemcoverartimageview, int i1)
    {
        playerfragment.a(playeritemcoverartimageview, i1);
    }

    static void a(PlayerFragment playerfragment, String s, PlaylistItem playlistitem)
    {
        playerfragment.a(s, playlistitem);
    }

    private void a(PlayerItemCoverArtImageView playeritemcoverartimageview, int i1)
    {
        ay = true;
    /* block-local class not found */
    class f {}

        f f1 = new f(false);
        playeritemcoverartimageview.a(-(playeritemcoverartimageview.getWidth() * 2), f1, i1);
        b(0);
        ax.getSecondaryCover().a();
    }

    private void a(PlaylistItem playlistitem, PlayerItemStatus playeritemstatus)
    {
        playlistitem.status = playeritemstatus;
        al.notifyDataSetChanged();
    }

    private void a(String s, PlaylistItem playlistitem)
    {
        aj.logEvent(PlayerEventFactory.createLikeDislike(s, playlistitem.key, az.i()));
    }

    static boolean a(PlayerFragment playerfragment)
    {
        return playerfragment.ay;
    }

    static boolean a(PlayerFragment playerfragment, boolean flag)
    {
        playerfragment.aG = flag;
        return flag;
    }

    static PlaylistItem b(PlayerFragment playerfragment)
    {
        return playerfragment.au;
    }

    private void b(int i1)
    {
        ap.animate().alpha(i1);
        aq.animate().alpha(i1);
    }

    private void b(int i1, int j1)
    {
        aE.setText(c(i1));
        aF.setMax(i1);
        aF.setProgress(j1);
        SeekBar seekbar = aF;
        boolean flag;
        if (i1 >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        seekbar.setEnabled(flag);
    }

    static PlayerLikeDislikeBar c(PlayerFragment playerfragment)
    {
        return playerfragment.ax;
    }

    private static String c(int i1)
    {
        if (i1 < 0)
        {
            return "--:--";
        } else
        {
            i1 /= 1000;
            return String.format("%02d:%02d", new Object[] {
                Integer.valueOf(i1 / 60), Integer.valueOf(i1 % 60)
            });
        }
    }

    static int d(PlayerFragment playerfragment)
    {
        return playerfragment.an;
    }

    static void e(PlayerFragment playerfragment)
    {
        if (playerfragment.au.status != PlayerItemStatus.LIKED)
        {
            com.shazam.l.m.a a1 = playerfragment.ao;
            playerfragment = playerfragment.au;
            TagAdder tagadder = a1.c;
            com.shazam.model.details.AddToListActionInfo.Builder builder = com.shazam.model.details.AddToListActionInfo.Builder.a();
            builder.tag = (Tag)a1.d.a(playerfragment);
            builder.providerPlaybackIds = playerfragment.a();
            tagadder.a(builder.b());
            a1.c.a();
            a1.e.b(((PlaylistItem) (playerfragment)).key);
            a1.a.a(playerfragment);
        }
    }

    private Playlist f()
    {
        Object obj;
        obj = getActivity().getIntent().getStringExtra("com.shazam.android.extra.Playlist");
        if (!com.shazam.b.e.a.c(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_40;
        }
        obj = (Playlist)ak.a(((String) (obj)), com/shazam/model/player/Playlist);
        return ((Playlist) (obj));
        com.shazam.j.c c1;
        c1;
        return com.shazam.model.player.Playlist.Builder.a().b();
    }

    static void f(PlayerFragment playerfragment)
    {
        if (playerfragment.au.status != PlayerItemStatus.DISLIKED)
        {
            com.shazam.l.m.a a1 = playerfragment.ao;
            playerfragment = playerfragment.au;
            a1.e.a(((PlaylistItem) (playerfragment)).key);
            a1.a.b(playerfragment);
        }
    }

    private void g()
    {
        List list = at.items;
        int i1 = list.indexOf(au) + 1;
        boolean flag;
        if (i1 < list.size())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a(i1, true, true);
            return;
        } else
        {
            j();
            return;
        }
    }

    static void g(PlayerFragment playerfragment)
    {
        playerfragment.b(1);
    }

    private void h()
    {
        PlayerItemCoverArtImageView playeritemcoverartimageview = ax.getSecondaryCover();
        PlayerItemCoverArtImageView playeritemcoverartimageview1 = ax.getPrimaryCover();
        playeritemcoverartimageview1.setOffsetListener(new com.shazam.android.widget.player.a(new d[] {
            aw, this
        }));
        playeritemcoverartimageview1.setOnSwipedListener(this);
        playeritemcoverartimageview1.setOnTouchListener(playeritemcoverartimageview1.a);
        int i1 = playeritemcoverartimageview.getWidth() / 2;
        if (i1 > 0)
        {
            playeritemcoverartimageview.setPivotX(i1);
        }
        i1 = playeritemcoverartimageview.getHeight() / 2;
        if (i1 > 0)
        {
            playeritemcoverartimageview.setPivotY(i1);
        }
        playeritemcoverartimageview.a(0.92F);
        playeritemcoverartimageview.setRotation(0.0F);
        playeritemcoverartimageview.setTranslationX(0.0F);
        playeritemcoverartimageview.setTranslationY(0.0F);
        playeritemcoverartimageview.setOnTouchListener(null);
        playeritemcoverartimageview.a.b = e.a;
        playeritemcoverartimageview.a.a = d.c;
        aw.setTransitionOffset(0.0F);
    }

    static void h(PlayerFragment playerfragment)
    {
        playerfragment.h();
    }

    private boolean i()
    {
        Playlist playlist = az.d;
        return az.f() && aC.equals(playlist.playerlistUri);
    }

    static boolean i(PlayerFragment playerfragment)
    {
        playerfragment.ay = false;
        return false;
    }

    private void j()
    {
        PlayerLikeDislikeBar playerlikedislikebar = ax;
        playerlikedislikebar.getPrimaryCover().setVisibility(4);
        playerlikedislikebar.getSecondaryCover().setVisibility(4);
        if (az != null)
        {
            az.c();
        }
        k();
    }

    static void j(PlayerFragment playerfragment)
    {
        playerfragment.g();
    }

    static EventAnalytics k(PlayerFragment playerfragment)
    {
        return playerfragment.aj;
    }

    private void k()
    {
        i i1 = getActivity();
        if (i1 != null)
        {
            i1.finish();
        }
    }

    static void l(PlayerFragment playerfragment)
    {
        playerfragment.k();
    }

    static MusicPlayerService m(PlayerFragment playerfragment)
    {
        return playerfragment.az;
    }

    static Playlist n(PlayerFragment playerfragment)
    {
        return playerfragment.at;
    }

    static TextView o(PlayerFragment playerfragment)
    {
        return playerfragment.aD;
    }

    public final void a()
    {
        j();
    }

    public final void a(float f1, float f2)
    {
        f1 = Math.max(0.0F, Math.min(1.0F - Math.abs(f2), 1.0F));
        ap.setAlpha(f1);
        aq.setAlpha(f1);
    }

    public final void a(int i1, int j1)
    {
        if (!aG)
        {
            b(i1, j1);
        }
    }

    public final void a(PlayerItemCoverArtImageView playeritemcoverartimageview)
    {
        a("playerswipedlike", au);
        int i1 = am;
        ay = true;
        f f1 = new f(true);
        playeritemcoverartimageview.a(playeritemcoverartimageview.getWidth() * 2, f1, i1);
        b(0);
        ax.getSecondaryCover().a();
    }

    public final void a(Playlist playlist)
    {
        at = playlist;
        Object obj;
        PlayerControlView playercontrolview;
        View view;
        int i1;
        int j1;
        boolean flag1;
        if (!i())
        {
            MusicPlayerService musicplayerservice = az;
            boolean flag = getUserVisibleHint();
            if (musicplayerservice.d != playlist)
            {
                musicplayerservice.d = playlist;
                if (flag)
                {
                    musicplayerservice.b(0, false);
                }
            }
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        aA.setVisibility(8);
        ar.setText(at.title);
        obj = al;
        playlist = playlist.items;
        ((com.shazam.android.a.f.a) (obj)).a.clear();
        ((com.shazam.android.a.f.a) (obj)).a.addAll(playlist);
        ((com.shazam.android.a.f.a) (obj)).notifyDataSetChanged();
        j1 = az.e;
        if (!i() || j1 == -1)
        {
            j1 = 0;
        }
        if (i1 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        a(j1, true, flag1);
        playlist = av;
        obj = ax;
        playercontrolview = as;
        view = aB;
        for (i1 = 0; i1 < 4; i1++)
        {
            (new View[] {
                playlist, obj, playercontrolview, view
            })[i1].setVisibility(0);
        }

    }

    public final void a(PlaylistItem playlistitem)
    {
        Toast toast = new Toast(getActivity());
        toast.setView(getActivity().getLayoutInflater().inflate(0x7f03007a, null));
        toast.setGravity(81, 0, com.shazam.android.util.h.b.a(190));
        toast.setDuration(0);
        toast.show();
        a(playlistitem, PlayerItemStatus.LIKED);
    }

    public final void b(PlayerItemCoverArtImageView playeritemcoverartimageview)
    {
        a("playerswipeddislike", au);
        a(playeritemcoverartimageview, am);
    }

    public final void b(PlaylistItem playlistitem)
    {
        a(playlistitem, PlayerItemStatus.DISLIKED);
    }

    public final void d()
    {
        g();
        aj.logEvent(PlayerEventFactory.createPlayerNext());
    }

    public final void e()
    {
        int i1 = at.items.indexOf(au) - 1;
        boolean flag;
        if (i1 != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a(i1, true, true);
        }
        aj.logEvent(PlayerEventFactory.createPlayerPrevious());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        aC = getActivity().getIntent().getData();
        if (getActivity().getIntent().hasExtra("com.shazam.android.extra.Playlist"))
        {
            bundle = new q(f());
        } else
        {
            bundle = e.a(getActivity(), aC, getLoaderManager());
        }
        ao = new com.shazam.l.m.a(this, bundle, b, d, f, aC);
        am = getResources().getInteger(0x10e0000);
        an = getResources().getInteger(0x10e0001);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030053, viewgroup, false);
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        adapterview = al.a(i1);
        aj.logEvent(PlayerEventFactory.createPlayerCoverArtClicked(false, ((PlaylistItem) (adapterview)).key, az.i()));
        a(i1, false, true);
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        az = ((com.shazam.android.service.player.MusicPlayerService.a)ibinder).a;
        if (i())
        {
            a(az.d);
            return;
        } else
        {
            componentname = ao;
            ((com.shazam.l.m.a) (componentname)).b.a(new com.shazam.l.m.a.a(componentname, ((com.shazam.l.m.a) (componentname)).f));
            ((com.shazam.l.m.a) (componentname)).b.a();
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        az = null;
    }

    public void onStart()
    {
        super.onStart();
        i i1 = getActivity();
        i1.bindService(new Intent(i1, com/shazam/android/service/player/MusicPlayerService), this, 1);
        g.a(h, new IntentFilter("com.shazam.android.action.TRACK_CHANGED"));
        getActivity().registerReceiver(i, new IntentFilter("com.shazam.android.action.FULLSCREEN_PLAYER_DISMISS"));
    }

    public void onStop()
    {
        super.onStop();
        ao.b.b();
        getActivity().unbindService(this);
        g.a(h);
        getActivity().unregisterReceiver(i);
        az = null;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        aB = view.findViewById(0x7f110186);
        aA = (ProgressBar)view.findViewById(0x7f1100d9);
        aw = (PlayerBackgroundView)view.findViewById(0x7f11017e);
        ax = (PlayerLikeDislikeBar)view.findViewById(0x7f110185);
        aD = (TextView)view.findViewById(0x7f110187);
        aE = (TextView)view.findViewById(0x7f110189);
        aF = (SeekBar)view.findViewById(0x7f110188);
    /* block-local class not found */
    class g {}

        aF.setOnSeekBarChangeListener(new g((byte)0));
        ap = (TextView)view.findViewById(0x7f110181);
        aq = (TextView)view.findViewById(0x7f110182);
        ar = (TextView)view.findViewById(0x7f110184);
        as = (PlayerControlView)view.findViewById(0x7f110183);
        as.setTrackChangeListener(this);
        ((PlayerNavigationUnderlayView)view.findViewById(0x7f11017f)).setBottomMostViewToTrack(as);
        av = (FancyCoverFlow)view.findViewById(0x7f11018a);
        av.setOnItemClickListener(this);
        av.setAdapter(al);
    /* block-local class not found */
    class a {}

        view.findViewById(0x7f11018b).setOnClickListener(new a((byte)0));
    /* block-local class not found */
    class b {}

        view.findViewById(0x7f11018e).setOnClickListener(new b((byte)0));
    /* block-local class not found */
    class c {}

        view.findViewById(0x7f110180).setOnClickListener(new c((byte)0));
        h();
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag && at != null)
        {
            a(at.items.indexOf(au), true, true);
        }
    }
}
