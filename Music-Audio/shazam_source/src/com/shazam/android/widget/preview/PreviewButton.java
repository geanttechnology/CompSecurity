// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.preview;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.PlayerEventFactory;
import com.shazam.android.k.d.a;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;
import com.shazam.android.service.player.MusicPlayerService;
import com.shazam.android.util.h.b;
import com.shazam.android.util.o;
import com.shazam.android.widget.l;
import com.shazam.android.widget.n;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.playlist.PlaybackProviderSelector;
import com.shazam.model.preview.PlayerState;
import com.shazam.model.preview.PreviewViewData;
import java.util.EnumMap;

// Referenced classes of package com.shazam.android.widget.preview:
//            a, g, c, f

public class PreviewButton extends l
    implements ServiceConnection, android.view.View.OnClickListener, a
{

    private static final int a = com.shazam.android.util.h.b.a(37);
    private static final int b = com.shazam.android.util.h.b.a(12);
    private final EventAnalyticsFromView c;
    private final f d;
    private final n e;
    private final t f;
    private final PlaybackProviderSelector g;
    private final BroadcastReceiver h;
    private int i;
    private PreviewViewData j;
    private MusicPlayerService k;
    private View l;
    private View m;
    private Drawable n;
    private boolean o;
    private int p;
    private Animation q;
    private boolean r;
    private int s;

    public PreviewButton(Context context)
    {
        this(context, null);
    }

    public PreviewButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PreviewButton(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        c = com.shazam.i.b.g.b.a.b();
        d = new com.shazam.android.widget.preview.a(com.shazam.i.b.ay.g.a.a(), com.shazam.i.o.a.a());
        e = com.shazam.i.b.ay.a.a();
        f = new p();
        g = com.shazam.i.b.ai.a.a();
        h = new _cls1();
        i = 1;
        r = true;
        s = 8;
        if (attributeset != null)
        {
            attributeset = context.obtainStyledAttributes(attributeset, com.shazam.android.b.a.PreviewButton);
            setMainColor(attributeset.getInt(0, 1));
            n = attributeset.getDrawable(1);
            attributeset.recycle();
        }
        setBackgroundDrawable(com.shazam.android.util.o.a(context, 0x7f010109));
        setOnClickListener(this);
        setEnabled(true);
        setVisibility(8);
        l = new View(context);
        l.setId(0x7f110026);
        m = new View(context);
        m.setVisibility(4);
        m.setId(0x7f110027);
        a(new View[] {
            l, m
        });
        e.a(l, n);
        q = AnimationUtils.loadAnimation(context, 0x7f04000f);
    }

    private PlaybackProvider a(PreviewViewData previewviewdata)
    {
        return g.a(previewviewdata.playlistItem);
    }

    private void a()
    {
        boolean flag = false;
        if (b())
        {
            PlayerState playerstate = getCurrentState();
            l.setVisibility(0);
            setActionIcon(playerstate);
            if (playerstate != PlayerState.PREPARING)
            {
                flag = true;
            }
            setEnabled(flag);
        }
    }

    static void a(PreviewButton previewbutton)
    {
        previewbutton.a();
    }

    private void a(boolean flag)
    {
        if (flag == o)
        {
            return;
        }
        Context context = getContext();
        if (flag)
        {
            context.registerReceiver(h, com.shazam.android.f.a.a());
            a();
        } else
        {
            context.unregisterReceiver(h);
        }
        o = flag;
    }

    private boolean b()
    {
        return k != null && j != null;
    }

    private PlayerState getCurrentState()
    {
        MusicPlayerService musicplayerservice = k;
        PlaylistItem playlistitem = j.playlistItem;
        PlaybackProvider playbackprovider = a(j);
        if (playlistitem != null && musicplayerservice.c != null && musicplayerservice.c.f() == playbackprovider && musicplayerservice.c.a(playlistitem))
        {
            return MusicPlayerService.b;
        } else
        {
            return PlayerState.IDLE;
        }
    }

    private void setActionIcon(PlayerState playerstate)
    {
        i;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 86
    //                   1 32
    //                   2 103;
           goto _L1 _L2 _L1 _L3
_L1:
        int i1 = ((Integer)com.shazam.android.widget.preview.g.a.get(playerstate)).intValue();
_L5:
        if (p != i1)
        {
            l.setBackgroundResource(i1);
            p = i1;
            if (playerstate != PlayerState.PREPARING)
            {
                break; /* Loop/switch isn't completed */
            }
            l.startAnimation(q);
        }
        return;
_L2:
        i1 = ((Integer)g.c.get(playerstate)).intValue();
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = ((Integer)com.shazam.android.widget.preview.g.b.get(playerstate)).intValue();
        if (true) goto _L5; else goto _L4
_L4:
        l.clearAnimation();
        return;
    }

    public final void a(PreviewViewData previewviewdata, int i1)
    {
        j = null;
        s = i1;
        m.setVisibility(4);
        setVisibility(i1);
        if (previewviewdata != null && a(previewviewdata) != null)
        {
            j = previewviewdata;
            setVisibility(0);
            previewviewdata = a(j);
            Integer integer = (Integer)com.shazam.android.widget.preview.c.a.get(previewviewdata);
            if (integer != null && previewviewdata != PlaybackProvider.PREVIEW)
            {
                m.setVisibility(0);
                m.setBackgroundResource(integer.intValue());
            } else
            {
                m.setVisibility(4);
            }
            a();
        }
    }

    public final void f()
    {
        a(j, s);
    }

    public Uri getUri()
    {
        return f.h();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        a(true);
        Context context = getContext();
        Intent intent = new Intent(context, com/shazam/android/service/player/MusicPlayerService);
        context.startService(intent);
        context.bindService(intent, this, 1);
    }

    public void onClick(View view)
    {
        if (b())
        {
            view = a(j);
            if (getCurrentState() == PlayerState.PAUSED)
            {
                k.e();
                c.logEvent(this, PlayerEventFactory.createPlayerPlay(r, j.playlistItem.key, k.i(), k.g(), k.h()));
            } else
            {
                PlaylistItem playlistitem = j.playlistItem;
                if (k.a(playlistitem))
                {
                    c.logEvent(this, PlayerEventFactory.createPlayerPause(r, j.playlistItem.key, k.i(), k.g(), k.h()));
                    k.d();
                    return;
                }
                if (k.b(playlistitem))
                {
                    if (view == PlaybackProvider.PREVIEW)
                    {
                        d.b();
                    }
                    c.logEvent(this, PlayerEventFactory.createPlayerPlay(r, j.playlistItem.key, k.i()));
                    return;
                }
            }
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        a(false);
        if (k != null)
        {
            getContext().unbindService(this);
            k = null;
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        i1 = l.getMeasuredWidth();
        j1 = l.getMeasuredHeight();
        l.layout(0, 0, i1, j1);
        m.layout(i1 - m.getMeasuredWidth(), j1 - m.getMeasuredHeight(), i1, j1);
    }

    protected void onMeasure(int i1, int j1)
    {
        l.measure(android.view.View.MeasureSpec.makeMeasureSpec(a, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(a, 0x40000000));
        m.measure(android.view.View.MeasureSpec.makeMeasureSpec(b, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(b, 0x40000000));
        setMeasuredDimension(l.getMeasuredWidth(), l.getMeasuredHeight());
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        k = ((com.shazam.android.service.player.MusicPlayerService.a)ibinder).a;
        a();
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        k = null;
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        a(flag);
    }

    public void setMainColor(int i1)
    {
        i = i1;
    }

    public void setMinimised(boolean flag)
    {
        r = flag;
    }

    public void setPreviewViewData(PreviewViewData previewviewdata)
    {
        a(previewviewdata, 8);
    }


    /* member class not found */
    class _cls1 {}

}
