// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets.handler;

import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;
import com.target.mothership.model.coupon_wallets.interfaces.a;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.e.b.b;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.target.mothership.model.coupon_wallets.handler:
//            TGTWalletItem

public class c
    implements aa
{

    private static final SimpleDateFormat TIMESTAMP_FORMAT;
    private static final String TRUE = "true";

    public c()
    {
    }

    private Date a(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return TIMESTAMP_FORMAT.parse(s, new ParsePosition(0));
        }
    }

    public WalletItem a(com.target.mothership.services.apigee.e.b.c c1)
    {
        Object obj = null;
        boolean flag = false;
        String s1 = c1.a();
        Object obj1 = c1.b();
        String s;
        Date date;
        Object obj2;
        int i;
        if (obj1 != null && !((List) (obj1)).isEmpty())
        {
            obj = (b)((List) (obj1)).get(0);
            s = ((b) (obj)).a();
            obj1 = ((b) (obj)).c();
            obj = ((b) (obj)).b();
        } else
        {
            obj1 = null;
            s = null;
        }
        date = a(c1.c());
        obj2 = c1.d();
        i = ((flag) ? 1 : 0);
        if (obj2 != null)
        {
            try
            {
                i = Integer.parseInt(((String) (obj2)));
            }
            catch (NumberFormatException numberformatexception)
            {
                i = ((flag) ? 1 : 0);
            }
        }
        obj2 = c1.e();
        c1 = a.NONE;
        if (obj2 != null)
        {
            c1 = com.target.mothership.model.coupon_wallets.interfaces.a.a(((String) (obj2)));
        }
        obj2 = new TGTWalletItem();
        ((TGTWalletItem) (obj2)).a(s1);
        ((TGTWalletItem) (obj2)).b(s);
        ((TGTWalletItem) (obj2)).c(((String) (obj)));
        ((TGTWalletItem) (obj2)).d(((String) (obj1)));
        ((TGTWalletItem) (obj2)).a(date);
        ((TGTWalletItem) (obj2)).a(i);
        ((TGTWalletItem) (obj2)).a(c1);
        return ((WalletItem) (obj2));
    }

    public volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.apigee.e.b.c)obj);
    }

    static 
    {
        TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
    }
}
