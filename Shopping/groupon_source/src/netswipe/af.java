// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            o, by

class af
    implements Runnable
{

    final o a;

    af(o o1)
    {
        a = o1;
        super();
    }

    public void run()
    {
        o.c(a).successView.setCardholderName("recognized");
    }
}
