// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.c.a;

// Referenced classes of package com.mopub.mobileads:
//            o

public abstract class i
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(int j);

        public abstract void onSetContentView(View view);
    }


    public final Context a;
    public final RelativeLayout b;
    public final a c;
    private Long d;

    public i(Context context, Long long1, a a1)
    {
        a = context.getApplicationContext();
        d = long1;
        c = a1;
        b = new RelativeLayout(a);
    }

    public void a()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.addRule(13);
        b.addView(b(), 0, layoutparams);
        c.onSetContentView(b);
    }

    void a(int j, int k)
    {
    }

    public abstract void a(Bundle bundle);

    final void a(String s)
    {
        if (d != null)
        {
            com.mopub.mobileads.o.a(a, d.longValue(), s);
            return;
        } else
        {
            com.mopub.common.c.a.d("Tried to broadcast a video event without a braodcast identifier to send to.");
            return;
        }
    }

    public final void a(boolean flag)
    {
        if (flag)
        {
            c.a();
        }
    }

    public abstract VideoView b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public boolean g()
    {
        return true;
    }

    public final void h()
    {
        com.mopub.common.c.a.e("Video cannot be played.");
        a("com.mopub.action.interstitial.fail");
    }
}
