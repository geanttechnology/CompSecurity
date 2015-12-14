// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

class lg
    implements qc
{

    final String a;
    final ld b;

    lg(ld ld1, String s)
    {
        b = ld1;
        a = s;
        super();
    }

    public void a()
    {
        b.a.runOnUiThread(new lh(this));
    }

    public void b()
    {
        b.a.runOnUiThread(new li(this));
    }
}
