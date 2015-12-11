// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

final class beb
    implements bev
{

    beb()
    {
    }

    public final void a(bmz bmz1, List list)
    {
        bvd bvd1 = (bvd)bmz1.a(bvd);
        if (list.size() > 0)
        {
            bmz1 = (buz)list.get(0);
        } else
        {
            bmz1 = buz.a;
        }
        bvd1.ad = bmz1;
    }
}
