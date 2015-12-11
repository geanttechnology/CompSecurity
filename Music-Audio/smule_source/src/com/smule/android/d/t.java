// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.PurchasesManager;
import com.smule.android.network.managers.ap;
import com.smule.android.network.managers.ar;
import com.smule.android.network.models.f;

// Referenced classes of package com.smule.android.d:
//            e

public class t
{

    public static String a = "ServerPurchaseExecutor.purchase.start";
    public static String b = "ServerPurchaseExecutor.purchase.done";
    private static final String c = com/smule/android/d/t.getSimpleName();

    public t()
    {
    }

    public static boolean a(e e1, String s, String s1, long l, String s2, String s3)
    {
        if (e1 != e.a)
        {
            return false;
        } else
        {
            h.a().a(a, new Object[] {
                "productId", s
            });
            boolean flag = b(e1, s, s1, l, s2, s3);
            h.a().a(b, new Object[] {
                "productId", s, "result", Boolean.valueOf(flag)
            });
            return flag;
        }
    }

    private static boolean b(e e1, String s, String s1, long l, String s2, String s3)
    {
        boolean flag3;
        boolean flag4;
label0:
        {
            flag4 = true;
            flag3 = true;
            boolean flag = false;
            if (e1 == e.a)
            {
                aa.a(c, (new StringBuilder()).append("purchase receipt received from GP: ").append(s2).toString());
                e1 = PurchasesManager.a();
                if (!PurchasesManager.a().a(s).booleanValue())
                {
                    break label0;
                }
                aa.a(c, "coin pack found, reporting");
                flag = Boolean.valueOf(e1.a(s, s1, l, s2, s3)).booleanValue();
            }
            return flag;
        }
        e1 = ap.a().b(s);
        if (e1 != null)
        {
            aa.a(c, (new StringBuilder()).append("subscription pack ").append(((f) (e1)).sku).append(" found, reporting").toString());
            flag4 = ap.a().a(s, s1, l, s2);
            boolean flag1;
            if (!flag4)
            {
                flag1 = flag3;
            } else
            {
                flag1 = false;
            }
            ar.a(Boolean.valueOf(flag1), com.smule.android.network.core.b.d().e());
            return flag4;
        }
        aa.a(c, (new StringBuilder()).append("no exisiting sku found for ").append(s).append(", reporting anyways").toString());
        flag3 = ap.a().a(s, s1, l, s2);
        boolean flag2;
        if (!flag3)
        {
            flag2 = flag4;
        } else
        {
            flag2 = false;
        }
        ar.a(Boolean.valueOf(flag2), com.smule.android.network.core.b.d().e());
        return flag3;
    }

}
