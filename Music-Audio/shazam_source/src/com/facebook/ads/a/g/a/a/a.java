// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g.a.a;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.facebook.ads.a.g.a.a:
//            f, d, g, e, 
//            b

public final class a extends FrameLayout
{

    public e a;
    private f b;
    private View c;
    private Uri d;
    private Context e;

    public a(Context context)
    {
        super(context);
        e = context;
        View view = new View(context);
        view.setBackgroundColor(0xff000000);
        view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        c = view;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b = f.a;
            context = new d(context);
            context.a(c, d);
            addView(context);
        } else
        {
            b = f.b;
            context = new g(context);
            addView(context);
        }
        a = context;
        addView(c);
    }

    public final void a()
    {
        a.start();
    }

    public final int getCurrentPosition()
    {
        return a.getCurrentPosition();
    }

    public final View getPlaceholderView()
    {
        return c;
    }

    public final f getVideoImplType()
    {
        return b;
    }

    public final void setFrameVideoViewListener(b b1)
    {
        a.setFrameVideoViewListener(b1);
    }

    public final void setVideoImpl(f f1)
    {
        f f2;
        removeAllViews();
        f2 = f1;
        if (f1 == f.a)
        {
            f2 = f1;
            if (android.os.Build.VERSION.SDK_INT < 14)
            {
                f2 = f.b;
            }
        }
        b = f2;
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[f.values().length];
                try
                {
                    a[f.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[f.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[f2.ordinal()];
        JVM INSTR tableswitch 1 2: default 64
    //                   1 77
    //                   2 114;
           goto _L1 _L2 _L3
_L1:
        addView(c);
        a();
        return;
_L2:
        f1 = new d(e);
        f1.a(c, d);
        addView(f1);
        a = f1;
        continue; /* Loop/switch isn't completed */
_L3:
        f1 = new g(e);
        f1.a(c, d);
        addView(f1);
        a = f1;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void setup(Uri uri)
    {
        d = uri;
        a.a(c, uri);
    }
}
