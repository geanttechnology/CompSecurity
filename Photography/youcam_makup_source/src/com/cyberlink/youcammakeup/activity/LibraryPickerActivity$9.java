// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aj;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ak;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LibraryPickerActivity

class b
    implements aj
{

    final String a;
    final String b;
    final LibraryPickerActivity c;

    public void a(ak ak1)
    {
        Object obj;
        boolean flag1;
        m.b("activity.LibraryPickerActivity", "getSkuByGuid() complete!!");
        obj = ak1.a();
        if (obj == null || ((Collection) (obj)).size() == 0)
        {
            m.b("activity.LibraryPickerActivity", "getSkuByGuid() no sku collection!!");
            LibraryPickerActivity.a(c, true);
            LibraryPickerActivity.a(c, LibraryPickerActivity.f(c));
            return;
        }
        flag1 = h.c();
        obj = ((Collection) (obj)).iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        d d1 = (d)((Iterator) (obj)).next();
        if (d1 == null || flag1) goto _L4; else goto _L3
_L3:
        long l;
        long l1;
        long l2;
        l = System.currentTimeMillis();
        l1 = d1.f();
        l2 = d1.g();
        if (l1 <= l && l2 >= l) goto _L4; else goto _L5
_L5:
        boolean flag = true;
_L7:
        if (flag)
        {
            m.b("activity.LibraryPickerActivity", "getSkuByGuid() Expired!!");
            LibraryPickerActivity.a(c, true);
            LibraryPickerActivity.a(c, LibraryPickerActivity.f(c));
            return;
        } else
        {
            m.b("activity.LibraryPickerActivity", "getSkuByGuid() wait sku ready!!");
            ArrayList arraylist = new ArrayList();
            arraylist.add(a);
            h.b().b(a, b, LibraryPickerActivity.g(c));
            h.b().a(arraylist, ak1);
            return;
        }
_L2:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(bn bn1)
    {
        m.e("activity.LibraryPickerActivity", (new StringBuilder()).append("getSkuByGuid() error = ").append(bn1.toString()).toString());
        com.cyberlink.youcammakeup.activity.LibraryPickerActivity.h(c);
    }

    public volatile void a(Object obj)
    {
        a((ak)obj);
    }

    public void a(Void void1)
    {
        m.b("activity.LibraryPickerActivity", "getSkuByGuid() cancel");
        com.cyberlink.youcammakeup.activity.LibraryPickerActivity.h(c);
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    (LibraryPickerActivity librarypickeractivity, String s, String s1)
    {
        c = librarypickeractivity;
        a = s;
        b = s1;
        super();
    }
}
