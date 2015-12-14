// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.pf.common.utility.m;
import java.util.Collection;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LibraryPickerActivity

class a extends AsyncTask
{

    final LibraryPickerActivity a;

    protected transient Void a(Void avoid[])
    {
        m.b("activity.LibraryPickerActivity", "prepareSku() start");
        if (LibraryPickerActivity.b(a) == null)
        {
            m.b("activity.LibraryPickerActivity", "prepareSku() mSkuUrlContent is null");
            LibraryPickerActivity.a(a, true);
        } else
        {
            avoid = h.b();
            if (avoid.f().size() == 0 || avoid.b(LibraryPickerActivity.b(a).type, LibraryPickerActivity.b(a).skuGuid) == null)
            {
                LibraryPickerActivity.b(a, false);
                LibraryPickerActivity.a(a, LibraryPickerActivity.b(a).type, LibraryPickerActivity.b(a).skuGuid);
            } else
            if (!avoid.a(LibraryPickerActivity.b(a).type, LibraryPickerActivity.b(a).skuGuid))
            {
                m.b("activity.LibraryPickerActivity", "prepareSku() wait sku ready");
                LibraryPickerActivity.b(a, false);
                avoid.b(LibraryPickerActivity.b(a).type, LibraryPickerActivity.b(a).skuGuid, LibraryPickerActivity.g(a));
            } else
            {
                m.b("activity.LibraryPickerActivity", "prepareSku() sku is ready");
                LibraryPickerActivity.b(a, true);
            }
        }
        m.b("activity.LibraryPickerActivity", "prepareSku() end");
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    Url(LibraryPickerActivity librarypickeractivity)
    {
        a = librarypickeractivity;
        super();
    }
}
