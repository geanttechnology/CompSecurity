// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.youtube.player.YouTubePlayer;
import java.util.List;

// Referenced classes of package com.google.android.youtube.player.internal:
//            ac, b, d, v, 
//            q

public final class s
    implements YouTubePlayer
{

    private b a;
    private d b;

    public s(b b1, d d1)
    {
        a = (b)ac.a(b1, "connectionClient cannot be null");
        b = (d)ac.a(d1, "embeddedPlayer cannot be null");
    }

    public final View a()
    {
        View view;
        try
        {
            view = (View)v.a(b.s());
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
        return view;
    }

    public final void a(Configuration configuration)
    {
        try
        {
            b.a(configuration);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Configuration configuration)
        {
            throw new q(configuration);
        }
    }

    public final void a(boolean flag)
    {
        try
        {
            b.a(flag);
            a.a(flag);
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
        a.d();
    }

    public final boolean a(int i, KeyEvent keyevent)
    {
        boolean flag;
        try
        {
            flag = b.a(i, keyevent);
        }
        // Misplaced declaration of an exception variable
        catch (KeyEvent keyevent)
        {
            throw new q(keyevent);
        }
        return flag;
    }

    public final boolean a(Bundle bundle)
    {
        boolean flag;
        try
        {
            flag = b.a(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new q(bundle);
        }
        return flag;
    }

    public final void addFullscreenControlFlag(int i)
    {
        try
        {
            b.d(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void b()
    {
        try
        {
            b.m();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void b(boolean flag)
    {
        try
        {
            b.e(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final boolean b(int i, KeyEvent keyevent)
    {
        boolean flag;
        try
        {
            flag = b.b(i, keyevent);
        }
        // Misplaced declaration of an exception variable
        catch (KeyEvent keyevent)
        {
            throw new q(keyevent);
        }
        return flag;
    }

    public final void c()
    {
        try
        {
            b.n();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void cuePlaylist(String s1)
    {
        cuePlaylist(s1, 0, 0);
    }

    public final void cuePlaylist(String s1, int i, int j)
    {
        try
        {
            b.a(s1, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new q(s1);
        }
    }

    public final void cueVideo(String s1)
    {
        cueVideo(s1, 0);
    }

    public final void cueVideo(String s1, int i)
    {
        try
        {
            b.a(s1, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new q(s1);
        }
    }

    public final void cueVideos(List list)
    {
        cueVideos(list, 0, 0);
    }

    public final void cueVideos(List list, int i, int j)
    {
        try
        {
            b.a(list, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new q(list);
        }
    }

    public final void d()
    {
        try
        {
            b.o();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void e()
    {
        try
        {
            b.p();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void f()
    {
        try
        {
            b.q();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void g()
    {
        try
        {
            b.l();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final int getCurrentTimeMillis()
    {
        int i;
        try
        {
            i = b.h();
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
        return i;
    }

    public final int getDurationMillis()
    {
        int i;
        try
        {
            i = b.i();
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
        return i;
    }

    public final int getFullscreenControlFlags()
    {
        int i;
        try
        {
            i = b.j();
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
        return i;
    }

    public final Bundle h()
    {
        Bundle bundle;
        try
        {
            bundle = b.r();
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
        return bundle;
    }

    public final boolean hasNext()
    {
        boolean flag;
        try
        {
            flag = b.d();
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
        return flag;
    }

    public final boolean hasPrevious()
    {
        boolean flag;
        try
        {
            flag = b.e();
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
        return flag;
    }

    public final boolean isPlaying()
    {
        boolean flag;
        try
        {
            flag = b.c();
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
        return flag;
    }

    public final void loadPlaylist(String s1)
    {
        loadPlaylist(s1, 0, 0);
    }

    public final void loadPlaylist(String s1, int i, int j)
    {
        try
        {
            b.b(s1, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new q(s1);
        }
    }

    public final void loadVideo(String s1)
    {
        loadVideo(s1, 0);
    }

    public final void loadVideo(String s1, int i)
    {
        try
        {
            b.b(s1, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new q(s1);
        }
    }

    public final void loadVideos(List list)
    {
        loadVideos(list, 0, 0);
    }

    public final void loadVideos(List list, int i, int j)
    {
        try
        {
            b.b(list, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new q(list);
        }
    }

    public final void next()
    {
        try
        {
            b.f();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void pause()
    {
        try
        {
            b.b();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void play()
    {
        try
        {
            b.a();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void previous()
    {
        try
        {
            b.g();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void release()
    {
        a(true);
    }

    public final void seekRelativeMillis(int i)
    {
        try
        {
            b.b(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void seekToMillis(int i)
    {
        try
        {
            b.a(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void setFullscreen(boolean flag)
    {
        try
        {
            b.b(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void setFullscreenControlFlags(int i)
    {
        try
        {
            b.c(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void setManageAudioFocus(boolean flag)
    {
        try
        {
            b.d(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }

    public final void setOnFullscreenListener(com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener onfullscreenlistener)
    {
        try
        {
            b.a(new e.a(onfullscreenlistener) {

                final com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener a;
                final s b;

                public final void a(boolean flag)
                {
                    a.onFullscreen(flag);
                }

            
            {
                b = s.this;
                a = onfullscreenlistener;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener onfullscreenlistener)
        {
            throw new q(onfullscreenlistener);
        }
    }

    public final void setPlaybackEventListener(com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener playbackeventlistener)
    {
        try
        {
            b.a(new f.a(playbackeventlistener) {

                final com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener a;
                final s b;

                public final void a()
                {
                    a.onPlaying();
                }

                public final void a(int i)
                {
                    a.onSeekTo(i);
                }

                public final void a(boolean flag)
                {
                    a.onBuffering(flag);
                }

                public final void b()
                {
                    a.onPaused();
                }

                public final void c()
                {
                    a.onStopped();
                }

            
            {
                b = s.this;
                a = playbackeventlistener;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener playbackeventlistener)
        {
            throw new q(playbackeventlistener);
        }
    }

    public final void setPlayerStateChangeListener(com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener playerstatechangelistener)
    {
        try
        {
            b.a(new g.a(playerstatechangelistener) {

                final com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener a;
                final s b;

                public final void a()
                {
                    a.onLoading();
                }

                public final void a(String s1)
                {
                    a.onLoaded(s1);
                }

                public final void b()
                {
                    a.onAdStarted();
                }

                public final void b(String s1)
                {
                    try
                    {
                        s1 = com.google.android.youtube.player.YouTubePlayer.ErrorReason.valueOf(s1);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s1)
                    {
                        s1 = com.google.android.youtube.player.YouTubePlayer.ErrorReason.UNKNOWN;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s1)
                    {
                        s1 = com.google.android.youtube.player.YouTubePlayer.ErrorReason.UNKNOWN;
                    }
                    a.onError(s1);
                }

                public final void c()
                {
                    a.onVideoStarted();
                }

                public final void d()
                {
                    a.onVideoEnded();
                }

            
            {
                b = s.this;
                a = playerstatechangelistener;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener playerstatechangelistener)
        {
            throw new q(playerstatechangelistener);
        }
    }

    public final void setPlayerStyle(com.google.android.youtube.player.YouTubePlayer.PlayerStyle playerstyle)
    {
        try
        {
            b.a(playerstyle.name());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.youtube.player.YouTubePlayer.PlayerStyle playerstyle)
        {
            throw new q(playerstyle);
        }
    }

    public final void setPlaylistEventListener(com.google.android.youtube.player.YouTubePlayer.PlaylistEventListener playlisteventlistener)
    {
        try
        {
            b.a(new h.a(playlisteventlistener) {

                final com.google.android.youtube.player.YouTubePlayer.PlaylistEventListener a;
                final s b;

                public final void a()
                {
                    a.onPrevious();
                }

                public final void b()
                {
                    a.onNext();
                }

                public final void c()
                {
                    a.onPlaylistEnded();
                }

            
            {
                b = s.this;
                a = playlisteventlistener;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.youtube.player.YouTubePlayer.PlaylistEventListener playlisteventlistener)
        {
            throw new q(playlisteventlistener);
        }
    }

    public final void setShowFullscreenButton(boolean flag)
    {
        try
        {
            b.c(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new q(remoteexception);
        }
    }
}
