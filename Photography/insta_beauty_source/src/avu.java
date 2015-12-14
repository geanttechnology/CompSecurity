// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.activity.TTieZhiActivity;

class avu
    implements Runnable
{

    final avt a;

    avu(avt avt1)
    {
        a = avt1;
        super();
    }

    public void run()
    {
        TTieZhiActivity.a(a.a, false, "");
        TTieZhiActivity.e(a.a);
    }
}
