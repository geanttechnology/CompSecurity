// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fullscreenad.FullScreenAdView;

public class aoj
    implements Runnable
{

    final FullScreenAdView a;

    public aoj(FullScreenAdView fullscreenadview)
    {
        a = fullscreenadview;
        super();
    }

    public void run()
    {
        FullScreenAdView.access$500(a);
    }
}
