// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

// Referenced classes of package com.amazon.device.ads:
//            al, cn

class dv
    implements AdActivity.b
{

    private RelativeLayout a;
    private al b;
    private Activity c;

    dv()
    {
    }

    static Activity a(dv dv1)
    {
        return dv1.c;
    }

    public final void a()
    {
        c.requestWindowFeature(1);
    }

    public final void a(Activity activity)
    {
        c = activity;
    }

    public final void b()
    {
        Object obj1 = c.getIntent().getExtras();
        a = new RelativeLayout(c);
        a.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        c.setContentView(a);
        b = new al(c);
        Object obj = b;
        obj1 = ((Bundle) (obj1)).getString("url");
        obj.d = false;
        obj.c = ((String) (obj1));
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        b.g = ((android.view.ViewGroup.LayoutParams) (obj));
        b.h = a;
        b.b = new al.a() {

            final dv a;

            public final void a()
            {
                dv.a(a).finish();
            }

            public final void b()
            {
                dv.a(a).finish();
            }

            
            {
                a = dv.this;
                super();
            }
        };
        obj = b;
        ((al) (obj)).a.c("in playVideo");
        obj1 = new VideoView(((al) (obj)).e);
        ((VideoView) (obj1)).setOnCompletionListener(((android.media.MediaPlayer.OnCompletionListener) (obj)));
        ((VideoView) (obj1)).setOnErrorListener(((android.media.MediaPlayer.OnErrorListener) (obj)));
        ((VideoView) (obj1)).setLayoutParams(((al) (obj)).g);
        obj.f = ((VideoView) (obj1));
        ((al) (obj)).h.addView(((al) (obj)).f);
        obj1 = Uri.parse(((al) (obj)).c);
        ((al) (obj)).f.setVideoURI(((Uri) (obj1)));
        ((al) (obj)).a.c("in startPlaying");
        ((al) (obj)).a.c("in displayPlayerControls");
        obj1 = new MediaController(((al) (obj)).e);
        ((al) (obj)).f.setMediaController(((MediaController) (obj1)));
        ((MediaController) (obj1)).setAnchorView(((al) (obj)).f);
        ((MediaController) (obj1)).requestFocus();
        ((al) (obj)).f.start();
    }

    public final void c()
    {
    }

    public final void d()
    {
    }

    public final void e()
    {
        b.a();
        b = null;
        c.finish();
    }

    public final void f()
    {
    }

    public final boolean g()
    {
        return false;
    }
}
