// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.TextureView;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            h

public abstract class i extends TextureView
{

    public i(Context context)
    {
        super(context);
    }

    public abstract String a();

    public abstract void a(float f1);

    public abstract void a(int j);

    public abstract void a(h h);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setMimeType(String s);

    public abstract void setVideoPath(String s);
}
