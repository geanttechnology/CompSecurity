// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.service.gif.play.GifView;
import java.util.TimerTask;

public class bnz extends TimerTask
{

    final GifView a;

    public bnz(GifView gifview)
    {
        a = gifview;
        super();
    }

    public void run()
    {
        bnw bnw1 = GifView.access$300(a).d();
        GifView.access$102(a, bnw1.a());
        if (GifView.access$400(a) != null)
        {
            GifView.access$500(a);
        }
    }
}
