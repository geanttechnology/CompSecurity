// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.a.b;
import com.cyberlink.youcammakeup.database.more.a.d;
import com.cyberlink.youcammakeup.flurry.PopularityOfAllVideosEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bb;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bc;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bd;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bm;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.i;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.moreview.e;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;

public class VideoPlaybackActivity extends YouTubeBaseActivity
    implements i, com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener, com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
{

    protected boolean a;
    private YouTubePlayerView b;
    private YouTubePlayer c;
    private HorizontalGridView d;
    private e e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private ImageView l;
    private View m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private b s;
    private Handler t;
    private int u;
    private android.view.View.OnClickListener v;

    public VideoPlaybackActivity()
    {
        b = null;
        c = null;
        d = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = new Handler();
        u = 0;
        a = false;
        v = new android.view.View.OnClickListener() {

            final VideoPlaybackActivity a;

            public void onClick(View view)
            {
                view = a.findViewById(0x7f0c01f2);
                if (view != null)
                {
                    view.setVisibility(8);
                }
                af.a(com.cyberlink.youcammakeup.Globals.ActivityType.k);
                VideoPlaybackActivity.f(a);
            }

            
            {
                a = VideoPlaybackActivity.this;
                super();
            }
        };
    }

    static int a(VideoPlaybackActivity videoplaybackactivity, int i1)
    {
        videoplaybackactivity.u = i1;
        return i1;
    }

    static b a(VideoPlaybackActivity videoplaybackactivity)
    {
        return videoplaybackactivity.s;
    }

    static void a(VideoPlaybackActivity videoplaybackactivity, b b1)
    {
        videoplaybackactivity.b(b1);
    }

    static void a(VideoPlaybackActivity videoplaybackactivity, boolean flag)
    {
        videoplaybackactivity.a(flag);
    }

    private void a(boolean flag)
    {
        byte byte0 = 4;
        boolean flag1 = false;
        int i1;
        if (f != null)
        {
            View view = f;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            view.setVisibility(i1);
        }
        if (g != null)
        {
            view = g;
            i1 = byte0;
            if (flag)
            {
                i1 = 0;
            }
            view.setVisibility(i1);
        }
        if (h != null)
        {
            view = h;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
        if (i != null)
        {
            view = i;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
        if (j != null)
        {
            view = j;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
        if (k != null)
        {
            view = k;
            if (flag)
            {
                i1 = ((flag1) ? 1 : 0);
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
    }

    static e b(VideoPlaybackActivity videoplaybackactivity)
    {
        return videoplaybackactivity.e;
    }

    private void b(b b1)
    {
        if (b1 != null)
        {
            if (b1.b() != null && b1.b().equals("Youtube"))
            {
                NetworkManager networkmanager = Globals.d().w();
                if (networkmanager != null)
                {
                    com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfAllVideosEvent(String.valueOf(b1.a())));
                    networkmanager.a(new bm(networkmanager, b1.a()));
                }
            } else
            if (b1.e() != null && b1.e().getPath() != null && this != null)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(b1.e().toString())));
                return;
            }
        }
    }

    static HorizontalGridView c(VideoPlaybackActivity videoplaybackactivity)
    {
        return videoplaybackactivity.d;
    }

    private void c()
    {
        if (s == null || n == null || o == null || p == null || q == null || l == null)
        {
            return;
        }
        n.setText(s.g());
        p.setText(s.c());
        q.setText(s.d());
        if (s.b() != null && s.b().equals("Youtube"))
        {
            o.setText(getString(0x7f070474));
            l.setVisibility(8);
            return;
        } else
        {
            o.setText(getString(0x7f070473));
            l.setVisibility(0);
            l.setImageResource(0x7f0208a2);
            Globals.d().w().a(new k(s.a(), "beauty_tip_film", s.f()), new l(this) {

                final VideoPlaybackActivity a;
                final VideoPlaybackActivity b;

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
                {
                }

                public void a(bn bn1)
                {
                    if (bn1 == null);
                }

                public volatile void a(Object obj)
                {
                    a((String)obj);
                }

                public void a(String s1)
                {
                    if (a != null)
                    {
                        a.runOnUiThread(new Runnable(this, s1) {

                            final String a;
                            final _cls4 b;

                            public void run()
                            {
label0:
                                {
                                    if (com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.d(b.b) != null)
                                    {
                                        android.graphics.Bitmap bitmap = BitmapFactory.decodeFile(a);
                                        if (bitmap == null)
                                        {
                                            break label0;
                                        }
                                        com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.d(b.b).setImageBitmap(bitmap);
                                    }
                                    return;
                                }
                                com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.d(b.b).setImageResource(0x7f0208a2);
                            }

            
            {
                b = _pcls4;
                a = s1;
                super();
            }
                        });
                    }
                }

                public void a(Void void1)
                {
                }

                public void b(Object obj)
                {
                    a((bn)obj);
                }

                public void c(Object obj)
                {
                    a((Void)obj);
                }

                public void d(Object obj)
                {
                    a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj);
                }

            
            {
                b = VideoPlaybackActivity.this;
                a = videoplaybackactivity1;
                super();
            }
            });
            return;
        }
    }

    static ImageView d(VideoPlaybackActivity videoplaybackactivity)
    {
        return videoplaybackactivity.l;
    }

    private void d()
    {
        java.util.List list = null;
        if (e != null)
        {
            e.a();
            e = null;
        }
        if (!a)
        {
            list = StatusManager.j().a();
        }
        e = new e(this, StatusManager.j().b(), list, v, a);
        if (d != null)
        {
            d.setAdapter(e);
            u = e.getPosition(s);
            if (u >= 0)
            {
                d.a(u, true);
                d.post(new Runnable() {

                    final VideoPlaybackActivity a;

                    public void run()
                    {
                        VideoPlaybackActivity.c(a).setSelection(com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.e(a));
                    }

            
            {
                a = VideoPlaybackActivity.this;
                super();
            }
                });
            }
        }
    }

    static int e(VideoPlaybackActivity videoplaybackactivity)
    {
        return videoplaybackactivity.u;
    }

    private void e()
    {
        Collection collection = ((ap)Globals.d().K().second).b();
        if (collection == null)
        {
            return;
        } else
        {
            NetworkManager networkmanager = Globals.d().w();
            networkmanager.a(new bc(networkmanager, 1, collection.size(), true, new bd() {

                final VideoPlaybackActivity a;

                public void a(bb bb1)
                {
                    bb1 = bb1.a().iterator();
                    do
                    {
                        d d1;
                        Activity activity;
label0:
                        {
                            if (bb1.hasNext())
                            {
                                d1 = (d)bb1.next();
                                if (Long.valueOf(d1.a()).longValue() != StatusManager.j().b())
                                {
                                    continue;
                                }
                                activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.k);
                                if (activity != null)
                                {
                                    break label0;
                                }
                            }
                            return;
                        }
                        activity.runOnUiThread(new Runnable(this, d1) {

                            final d a;
                            final _cls8 b;

                            public void run()
                            {
                                VideoPlaybackActivity.g(b.a).setText(a.f());
                                StatusManager.j().a(a.f());
                            }

            
            {
                b = _pcls8;
                a = d1;
                super();
            }
                        });
                    } while (true);
                }

                public void a(bn bn1)
                {
                    if (bn1 == null);
                }

                public volatile void a(Object obj)
                {
                    a((bb)obj);
                }

                public void a(Void void1)
                {
                }

                public void b(Object obj)
                {
                    a((bn)obj);
                }

                public void c(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                a = VideoPlaybackActivity.this;
                super();
            }
            }));
            return;
        }
    }

    static void f(VideoPlaybackActivity videoplaybackactivity)
    {
        videoplaybackactivity.d();
    }

    static TextView g(VideoPlaybackActivity videoplaybackactivity)
    {
        return videoplaybackactivity.r;
    }

    public void a(b b1)
    {
        s = b1;
        if (c != null && s != null && s.b() != null && s.b().equals("Youtube") && s.e() != null && s.e().getQuery() != null && s.e().getQuery().length() > 2)
        {
            c.loadVideo(s.e().getQuery().substring(2));
        }
        c();
    }

    public boolean b()
    {
        if (Globals.d().i().a())
        {
            return false;
        } else
        {
            finish();
            return true;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (configuration.orientation != 2) goto _L2; else goto _L1
_L1:
        getWindow().addFlags(1024);
        getWindow().clearFlags(2048);
        if (s != null && s.b() != null && s.b().equals("Youtube"))
        {
            if (c != null)
            {
                c.setFullscreen(true);
            }
        } else
        {
            a(false);
        }
_L4:
        super.onConfigurationChanged(configuration);
        return;
_L2:
        if (configuration.orientation == 1)
        {
            getWindow().addFlags(2048);
            getWindow().clearFlags(1024);
            if (s != null && s.b() != null && s.b().equals("Youtube"))
            {
                if (c != null)
                {
                    c.setFullscreen(false);
                }
            } else
            {
                a(true);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.k, this);
        setContentView(0x7f030023);
        f = findViewById(0x7f0c01ee);
        g = findViewById(0x7f0c01ef);
        d = (HorizontalGridView)findViewById(0x7f0c01f0);
        h = findViewById(0x7f0c01e0);
        i = findViewById(0x7f0c01ea);
        j = findViewById(0x7f0c01e4);
        k = findViewById(0x7f0c01eb);
        n = (TextView)findViewById(0x7f0c01e5);
        o = (TextView)findViewById(0x7f0c01e6);
        p = (TextView)findViewById(0x7f0c01ec);
        q = (TextView)findViewById(0x7f0c01ed);
        r = (TextView)findViewById(0x7f0c01e3);
        boolean flag;
        if (!z.c("").equals(com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        if (a)
        {
            Globals.d().L();
        }
        if (r != null && StatusManager.j().c() != null && !a)
        {
            r.setText(StatusManager.j().c());
        }
        if (a)
        {
            e();
        }
        l = (ImageView)findViewById(0x7f0c01e9);
        if (l != null)
        {
            l.setOnClickListener(new android.view.View.OnClickListener() {

                final VideoPlaybackActivity a;

                public void onClick(View view)
                {
                    com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.a(a, com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.a(a));
                }

            
            {
                a = VideoPlaybackActivity.this;
                super();
            }
            });
        }
        m = findViewById(0x7f0c01e2);
        if (m != null)
        {
            m.setOnClickListener(new android.view.View.OnClickListener() {

                final VideoPlaybackActivity a;

                public void onClick(View view)
                {
                    a.b();
                }

            
            {
                a = VideoPlaybackActivity.this;
                super();
            }
            });
        }
        b = (YouTubePlayerView)findViewById(0x7f0c01e8);
        if (b != null)
        {
            b.initialize("AIzaSyA18HpyZW3fRF1iQFaVkNu2LwfCGok5YJ4", this);
        }
        s = StatusManager.j().k();
        StatusManager.j().a(this);
        c();
        d();
        if (d != null)
        {
            d.setOnItemClickListener(new p() {

                final VideoPlaybackActivity a;

                public void a(AdapterView adapterview, View view, int i1, long l1)
                {
                    if (com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.b(a) == null)
                    {
                        return;
                    } else
                    {
                        com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.a(a, i1);
                        VideoPlaybackActivity.c(a).a(i1, true);
                        adapterview = (b)com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.b(a).getItem(i1);
                        StatusManager.j().a(adapterview);
                        com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.a(a, adapterview);
                        return;
                    }
                }

            
            {
                a = VideoPlaybackActivity.this;
                super();
            }
            });
        }
    }

    protected void onDestroy()
    {
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.k, null);
        StatusManager.j().b(this);
        StatusManager.j().a(null);
        if (c != null)
        {
            c.release();
        }
        super.onDestroy();
        if (e != null)
        {
            e.a();
            e = null;
        }
    }

    public void onFullscreen(boolean flag)
    {
        if (t == null)
        {
            return;
        } else
        {
            t.post(new Runnable(flag) {

                final boolean a;
                final VideoPlaybackActivity b;

                public void run()
                {
                    VideoPlaybackActivity videoplaybackactivity = b;
                    boolean flag1;
                    if (!a)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    com.cyberlink.youcammakeup.activity.VideoPlaybackActivity.a(videoplaybackactivity, flag1);
                }

            
            {
                b = VideoPlaybackActivity.this;
                a = flag;
                super();
            }
            });
            return;
        }
    }

    public void onInitializationFailure(com.google.android.youtube.player.YouTubePlayer.Provider provider, YouTubeInitializationResult youtubeinitializationresult)
    {
        if (youtubeinitializationresult.isUserRecoverableError())
        {
            youtubeinitializationresult.getErrorDialog(this, 1).show();
        }
    }

    public void onInitializationSuccess(com.google.android.youtube.player.YouTubePlayer.Provider provider, YouTubePlayer youtubeplayer, boolean flag)
    {
        if (youtubeplayer != null)
        {
            c = youtubeplayer;
            youtubeplayer.addFullscreenControlFlag(8);
            youtubeplayer.setShowFullscreenButton(false);
            youtubeplayer.setOnFullscreenListener(this);
            if (!flag && s != null && s.e() != null && s.e().getQuery() != null && s.e().getQuery().length() > 2)
            {
                youtubeplayer.loadVideo(s.e().getQuery().substring(2));
                return;
            }
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            return b();
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        Globals.d().c("videoPlaybackPage");
        StatusManager.j().C();
        super.onPause();
    }

    protected void onResume()
    {
        Globals.d().c(null);
        if (a)
        {
            int i1 = d.getCheckedItemPosition();
            d.a(i1, false);
        }
        super.onResume();
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }
}
