// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.homewall.THomewallView;

public class aqi
    implements axx
{

    final apu a;
    final THomewallView b;

    public aqi(THomewallView thomewallview, apu apu1)
    {
        b = thomewallview;
        a = apu1;
        super();
    }

    public void a()
    {
        a.l = true;
        if (!a.m && b.hasStartedPlay)
        {
            THomewallView.access$200(b);
        }
    }
}
