// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.netswipe.sdk.core.NetswipeCardInformation;
import com.jumio.netswipe.sdk.core.ScanCardActivity;
import java.nio.CharBuffer;

// Referenced classes of package netswipe:
//            o, by

class ae
    implements Runnable
{

    final boolean a;
    final StringBuilder b;
    final o c;

    ae(o o1, boolean flag, StringBuilder stringbuilder)
    {
        c = o1;
        a = flag;
        b = stringbuilder;
        super();
    }

    public void run()
    {
        by by1 = o.c(c).successView;
        Object obj;
        if (a)
        {
            obj = b;
        } else
        {
            obj = "failed";
        }
        by1.setSortCode((CharSequence)obj);
        by1 = o.c(c).successView;
        if (o.f(c).getAccountNumber().length != 0)
        {
            obj = CharBuffer.wrap(o.f(c).getAccountNumber());
        } else
        {
            obj = "failed";
        }
        by1.setAccountNumber((CharSequence)obj);
        o.c(c).successView.setCardholderNamePending(o.d(c));
        o.c(c).successView.setCardHolderNameActive(o.d(c));
    }
}
