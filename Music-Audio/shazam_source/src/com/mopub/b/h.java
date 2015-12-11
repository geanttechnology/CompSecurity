// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.VideoView;
import com.mopub.common.d.d;
import com.mopub.common.d.e;
import com.mopub.mobileads.i;

public final class h extends i
{

    ImageButton d;
    private final VideoView e;
    private int f;
    private int g;

    public h(Context context, Bundle bundle, com.mopub.mobileads.i.a a1)
    {
        super(context, null, a1);
        e = new VideoView(context);
        e.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final h a;

            public final void onCompletion(MediaPlayer mediaplayer)
            {
                a.d.setVisibility(0);
                a.a(true);
            }

            
            {
                a = h.this;
                super();
            }
        });
        e.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {

            final h a;

            public final boolean onError(MediaPlayer mediaplayer, int j, int k)
            {
                a.d.setVisibility(0);
                a.h();
                return false;
            }

            
            {
                a = h.this;
                super();
            }
        });
        e.setVideoPath(bundle.getString("video_url"));
    }

    protected final void a()
    {
        super.a();
        g = com.mopub.common.d.d.c(50F, super.a);
        f = com.mopub.common.d.d.c(8F, super.a);
        d = new ImageButton(super.a);
        Object obj = new StateListDrawable();
        android.graphics.drawable.Drawable drawable = e.i.a(super.a);
        ((StateListDrawable) (obj)).addState(new int[] {
            0xfefeff59
        }, drawable);
        drawable = e.j.a(super.a);
        ((StateListDrawable) (obj)).addState(new int[] {
            0x10100a7
        }, drawable);
        d.setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
        d.setBackgroundDrawable(null);
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final h a;

            public final void onClick(View view)
            {
                ((i) (a)).c.a();
            }

            
            {
                a = h.this;
                super();
            }
        });
        obj = new android.widget.RelativeLayout.LayoutParams(g, g);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(f, 0, f, 0);
        super.b.addView(d, ((android.view.ViewGroup.LayoutParams) (obj)));
        d.setVisibility(8);
        e.start();
    }

    protected final void a(Bundle bundle)
    {
    }

    protected final VideoView b()
    {
        return e;
    }

    protected final void c()
    {
    }

    protected final void d()
    {
    }

    protected final void e()
    {
    }

    protected final void f()
    {
    }
}
