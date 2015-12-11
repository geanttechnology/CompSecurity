// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.a.e;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import com.g.c.u;
import com.g.c.y;
import com.shazam.android.activities.player.PlayerActivity;
import com.shazam.android.an.b.k;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;
import com.shazam.android.util.q;
import com.shazam.android.util.s;
import com.shazam.i.b.au.d;
import com.shazam.i.b.c;
import com.shazam.i.b.z.a;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.Playlist;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.player.ProviderPlaybackIds;
import com.shazam.model.preview.PlayerState;
import com.shazam.o.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.shazam.android.service.player:
//            e, g, s, p, 
//            k, h, i, a, 
//            y

public class MusicPlayerService extends Service
    implements android.media.AudioManager.OnAudioFocusChangeListener, com.shazam.android.service.player.e, g
{
    public final class a extends Binder
    {

        public final MusicPlayerService a;

        public a()
        {
            a = MusicPlayerService.this;
            super();
        }
    }


    public static PlayerState b;
    private static final q g;
    public com.shazam.android.service.player.p c;
    public Playlist d;
    public int e;
    public final Set f = new CopyOnWriteArraySet();
    private final s h = com.shazam.i.b.au.d.c();
    private final Handler i = com.shazam.i.b.z.a.a();
    private final AudioManager j = (AudioManager)com.shazam.i.b.c.a().getSystemService("audio");
    private final e k = android.support.v4.a.e.a(com.shazam.i.b.c.a());
    private final Handler l = com.shazam.i.b.z.a.a();
    private final k m = com.shazam.i.b.ai.b.c.a();
    private final com.shazam.android.service.player.k n = com.shazam.i.b.an.a.a.a();
    private volatile boolean o;
    private h p;
    private int q;
    private boolean r;
    private com.shazam.android.service.player.s s;
    private boolean t;
    private final BroadcastReceiver u = new BroadcastReceiver() {

        final MusicPlayerService a;

        public final void onReceive(Context context, Intent intent)
        {
            if (MusicPlayerService.j() == PlayerState.PLAYING)
            {
                a.d();
            } else
            if (MusicPlayerService.j() == PlayerState.PREPARING)
            {
                a.c();
                return;
            }
        }

            
            {
                a = MusicPlayerService.this;
                super();
            }
    };

    public MusicPlayerService()
    {
        o = true;
        q = -1;
        r = false;
        t = true;
        e = -1;
    }

    static s a(MusicPlayerService musicplayerservice)
    {
        return musicplayerservice.h;
    }

    public static PlayerState a()
    {
        return b;
    }

    private void a(int i1)
    {
        j.setStreamVolume(3, i1, 4);
    }

    private boolean a(PlaylistItem playlistitem, boolean flag, int i1)
    {
        if (flag)
        {
            e = -1;
            d = com.shazam.model.player.Playlist.Builder.a().b();
        }
        m();
        boolean flag1;
        if (j.requestAudioFocus(this, 3, 1) == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            return false;
        }
        t = false;
        c = s.a(playlistitem);
        playlistitem = c.a(playlistitem, i1);
        b = playlistitem;
        if (playlistitem == PlayerState.PREPARING)
        {
            n();
        } else
        if (b == PlayerState.IDLE)
        {
            c();
            return false;
        }
        n.a(s());
        return true;
    }

    static boolean b(MusicPlayerService musicplayerservice)
    {
        return musicplayerservice.o;
    }

    static void c(MusicPlayerService musicplayerservice)
    {
        musicplayerservice.l.post(musicplayerservice. new Runnable() {

            final MusicPlayerService a;

            public final void run()
            {
                if (com.shazam.android.service.player.MusicPlayerService.b(a))
                {
                    Iterator iterator = com.shazam.android.service.player.MusicPlayerService.d(a).iterator();
                    while (iterator.hasNext()) 
                    {
                        com.shazam.android.service.player.y y1 = (com.shazam.android.service.player.y)((WeakReference)iterator.next()).get();
                        if (y1 != null)
                        {
                            y1.a(a.g(), a.h());
                        }
                    }
                }
            }

            
            {
                a = MusicPlayerService.this;
                super();
            }
        });
    }

    static Set d(MusicPlayerService musicplayerservice)
    {
        return musicplayerservice.f;
    }

    static PlayerState j()
    {
        return b;
    }

    static q k()
    {
        return g;
    }

    private void l()
    {
        h h1;
        Object obj;
        h1 = p;
        obj = b();
        h1.f = ((PlaylistItem) (obj));
        if (obj == null) goto _L2; else goto _L1
_L1:
        h1.c.a(((PlaylistItem) (obj)).title).b(((PlaylistItem) (obj)).artist);
        h1.g = 512L;
        h1.c.u.clear();
        android.support.v7.a.n.a a1;
        Object obj1;
        Context context;
        Intent intent;
        byte byte0;
        int i1;
        int j1;
        if (h1.b.r())
        {
            h1.c.a(0x7f020168, "", com.shazam.android.service.player.i.a("actionPrevious"));
            h1.g = h1.g | 16L;
            byte0 = 2;
            i1 = 1;
        } else
        {
            byte0 = 1;
            i1 = 0;
        }
        a1 = h1.c;
        if (b == PlayerState.PAUSED)
        {
            j1 = 0x7f020157;
        } else
        {
            j1 = 0x7f020156;
        }
        a1.a(j1, "", com.shazam.android.service.player.i.a("actionPlayPause"));
        j1 = byte0;
        if (h1.b.q())
        {
            h1.c.a(0x7f020162, "", com.shazam.android.service.player.i.a("actionNext"));
            h1.g = h1.g | 32L;
            j1 = byte0 + 1;
        }
        h1.c.a(0x7f020155, "", com.shazam.android.service.player.i.a("actionStop"));
        a1 = h1.c;
        obj1 = new android.support.v7.a.n.e();
        obj1.a = (new int[] {
            i1, j1
        });
        obj1.b = h1.e.b();
        a1.a(((android.support.v4.app.u.p) (obj1)));
        h1.d.a("android.media.metadata.ARTIST", ((PlaylistItem) (obj)).artist);
        h1.d.a("android.media.metadata.ALBUM_ARTIST", ((PlaylistItem) (obj)).artist);
        h1.d.a("android.media.metadata.TITLE", ((PlaylistItem) (obj)).title);
        obj1 = ((PlaylistItem) (obj)).key;
        if (!h1.b.f()) goto _L4; else goto _L3
_L3:
        a1 = h1.c;
        obj1 = h1.b.d.playerlistUri;
        context = com.shazam.i.b.c.a();
        intent = new Intent(context, com/shazam/android/activities/player/PlayerActivity);
        intent.setData(((android.net.Uri) (obj1)));
        intent.addFlags(0x10000000);
        a1.d = PendingIntent.getActivity(context, 0, intent, 0x10000000);
_L6:
        obj = ((PlaylistItem) (obj)).coverArtUrl;
        if (obj != null)
        {
            h1.a.a(((String) (obj))).a(new h._cls1(h1));
        }
_L2:
        h1.a();
        startForeground(10101, h1.c.b());
        return;
_L4:
        if (!com.shazam.b.e.a.a(((String) (obj1))))
        {
            a1 = h1.c;
            obj1 = new Intent("android.intent.action.VIEW", (new p()).b(((String) (obj1))));
            ((Intent) (obj1)).addFlags(0x10000000);
            a1.d = PendingIntent.getActivity(com.shazam.i.b.c.a(), 0, ((Intent) (obj1)), 0x8000000);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void m()
    {
        this;
        JVM INSTR monitorenter ;
        o = false;
        if (c != null)
        {
            c.k();
            c = null;
        }
        b = PlayerState.IDLE;
        n();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void n()
    {
        PlayerState playerstate = b;
        Intent intent = new Intent("com.shazam.android.action.PLAYER_STATUS_CHANGED");
        intent.putExtra("extraNewMusicPlayerState", playerstate);
        sendBroadcast(intent);
    }

    private void o()
    {
        if (q())
        {
            a(e + 1, true);
            return;
        } else
        {
            c();
            return;
        }
    }

    private void p()
    {
        if (r())
        {
            a(e - 1, true);
        }
    }

    private boolean q()
    {
        return f() && e < d.items.size() - 1;
    }

    private boolean r()
    {
        return f() && e > 0;
    }

    private String s()
    {
        if (f())
        {
            return d.title;
        } else
        {
            return "";
        }
    }

    public final void a(int i1, boolean flag)
    {
        if (!f()) goto _L2; else goto _L1
_L1:
        boolean flag1;
        if (b != PlayerState.PAUSED && b != PlayerState.PLAYING)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (c.h() == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        String s1 = c.h();
        PlaylistItem playlistitem = (PlaylistItem)d.items.get(i1);
        PlaybackProvider playbackprovider = s.a(playlistitem).f();
        if (!s1.equals(playlistitem.a().a(playbackprovider)))
        {
            break MISSING_BLOCK_LABEL_138;
        }
        flag1 = true;
_L3:
        boolean flag2 = flag1;
        if (flag1)
        {
            flag2 = flag1;
            if (f())
            {
                if (e == i1)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
            }
        }
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_150;
        }
_L2:
        return;
        flag1 = false;
          goto _L3
        b(i1, flag);
        return;
    }

    public final void a(KeyEvent keyevent)
    {
        if (keyevent == null || keyevent.getAction() != 0 || keyevent.getRepeatCount() != 0) goto _L2; else goto _L1
_L1:
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 7: default 88
    //                   79: 89
    //                   85: 89
    //                   86: 145
    //                   87: 155
    //                   88: 150
    //                   126: 117
    //                   127: 131;
           goto _L3 _L4 _L4 _L5 _L6 _L7 _L8 _L9
_L7:
        break MISSING_BLOCK_LABEL_150;
_L3:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_155;
_L2:
        return;
_L4:
        if (b == PlayerState.PAUSED)
        {
            e();
            return;
        }
        if (b == PlayerState.PLAYING)
        {
            d();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (b == PlayerState.PAUSED)
        {
            e();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (b == PlayerState.PLAYING)
        {
            d();
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        m();
        return;
        p();
        return;
        o();
        return;
    }

    public final boolean a(int i1, int j1, String s1)
    {
        i.post(new Runnable() {

            final MusicPlayerService a;

            public final void run()
            {
                com.shazam.android.service.player.MusicPlayerService.a(a).a(com.shazam.android.service.player.MusicPlayerService.k());
            }

            
            {
                a = MusicPlayerService.this;
                super();
            }
        });
        o();
        return false;
    }

    public final boolean a(PlaylistItem playlistitem)
    {
        this;
        JVM INSTR monitorenter ;
        if (c == null) goto _L2; else goto _L1
_L1:
        boolean flag = c.a(playlistitem);
        if (!flag) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        playlistitem;
        throw playlistitem;
    }

    public final PlaylistItem b()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = c;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((PlaylistItem) (obj));
_L2:
        obj = c.g();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void b(int i1, boolean flag)
    {
        e = i1;
        a((PlaylistItem)d.items.get(i1), false, i1);
        if (flag)
        {
            k.a(new Intent("com.shazam.android.action.TRACK_CHANGED"));
        }
    }

    public final void b(com.shazam.android.service.player.a a1)
    {
        o();
    }

    public final boolean b(PlaylistItem playlistitem)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a(playlistitem, true, 0);
        this;
        JVM INSTR monitorexit ;
        return flag;
        playlistitem;
        throw playlistitem;
    }

    public final void c()
    {
        d = com.shazam.model.player.Playlist.Builder.a().b();
        e = -1;
        sendBroadcast(new Intent("com.shazam.android.action.FULLSCREEN_PLAYER_DISMISS"));
        if (b == PlayerState.PLAYING)
        {
            n.a();
        }
        t = true;
        stopForeground(true);
        m();
        p.e.a((new android.support.v4.media.session.PlaybackStateCompat.a()).a(0).a());
        m.b();
        j.abandonAudioFocus(this);
        stopSelf();
    }

    public final void c(com.shazam.android.service.player.a a1)
    {
        b = PlayerState.PLAYING;
        l();
        n();
        o = true;
        com.shazam.i.q.a.a("MusicPlayerServiceUpdateNotifier").newThread(new Runnable() {

            final MusicPlayerService a;

            public final void run()
            {
                while (com.shazam.android.service.player.MusicPlayerService.b(a)) 
                {
                    com.shazam.android.service.player.MusicPlayerService.c(a);
                    try
                    {
                        Thread.sleep(250L);
                    }
                    catch (InterruptedException interruptedexception) { }
                }
            }

            
            {
                a = MusicPlayerService.this;
                super();
            }
        }).start();
    }

    public final void d()
    {
        if (b == PlayerState.PLAYING)
        {
            n.a();
        }
        if (c != null)
        {
            c.b();
            b = PlayerState.PAUSED;
            n();
            l();
        }
    }

    public final void e()
    {
        if (b == PlayerState.PREPARING)
        {
            return;
        }
        if (c != null)
        {
            c.c();
            b = PlayerState.PLAYING;
            n();
            l();
        }
        n.a(s());
    }

    public final boolean f()
    {
        return d != null && com.shazam.o.b.b(d.items);
    }

    public final int g()
    {
        if (c == null)
        {
            return 0;
        } else
        {
            return c.d();
        }
    }

    public final int h()
    {
        if (c == null)
        {
            return -1;
        } else
        {
            return c.e();
        }
    }

    public final PlaybackProvider i()
    {
        return c.f();
    }

    public void onAudioFocusChange(int i1)
    {
        if (i1 != -2) goto _L2; else goto _L1
_L1:
        if (b == PlayerState.PLAYING)
        {
            d();
            r = true;
        }
_L4:
        return;
_L2:
        int j1;
        j1 = j.getStreamVolume(3);
        if (i1 != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (r)
        {
            e();
        }
        if (q != -1 && j1 != q)
        {
            a(q);
            q = j1;
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i1 == -1)
        {
            d();
            return;
        }
        if (i1 == -3)
        {
            q = j1;
            a(1);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public IBinder onBind(Intent intent)
    {
        return new a();
    }

    public void onCreate()
    {
        super.onCreate();
        p = new h(this);
        k.a(u, com.shazam.android.f.b.a());
        s = new com.shazam.android.service.player.s(this);
    }

    public void onDestroy()
    {
        super.onDestroy();
        c();
        k.a(u);
    }

    public int onStartCommand(Intent intent, int i1, int j1)
    {
        boolean flag;
        if (intent != null && com.shazam.b.e.a.c(intent.getAction()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!"actionPlayPause".equals(intent.getAction())) goto _L4; else goto _L3
_L3:
        if (b == PlayerState.PLAYING)
        {
            d();
        } else
        {
            e();
        }
_L2:
        return super.onStartCommand(intent, i1, j1);
_L4:
        if ("actionStop".equals(intent.getAction()))
        {
            c();
        } else
        if ("actionPause".equals(intent.getAction()))
        {
            d();
        } else
        if ("actionNext".equals(intent.getAction()))
        {
            o();
        } else
        if ("actionPrevious".equals(intent.getAction()))
        {
            p();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public boolean onUnbind(Intent intent)
    {
        if (t)
        {
            stopSelf();
        }
        return super.onUnbind(intent);
    }

    static 
    {
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f090128;
        a1.c = 1;
        g = a1.a();
        b = PlayerState.IDLE;
    }
}
