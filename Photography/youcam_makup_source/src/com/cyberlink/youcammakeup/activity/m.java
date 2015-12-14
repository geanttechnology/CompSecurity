// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.sku.j;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LibraryPickerActivity

class m
    implements j
{

    final LibraryPickerActivity a;

    m(LibraryPickerActivity librarypickeractivity)
    {
        a = librarypickeractivity;
        super();
    }

    public void a()
    {
        com.pf.common.utility.m.b("activity.LibraryPickerActivity", "allReady() sku donwload complete!!");
        if (h.b().b(LibraryPickerActivity.b(a).type, LibraryPickerActivity.b(a).skuGuid) == null)
        {
            com.pf.common.utility.m.b("activity.LibraryPickerActivity", "Can't get Sky metadata!!");
            LibraryPickerActivity.a(a, true);
            LibraryPickerActivity.a(a, LibraryPickerActivity.f(a));
            return;
        } else
        {
            h.b().b(this);
            Globals.d(new Runnable() {

                final m a;

                public void run()
                {
                    LibraryPickerActivity.b(a.a, true);
                    LibraryPickerActivity.a(a.a, LibraryPickerActivity.f(a.a));
                }

            
            {
                a = m.this;
                super();
            }
            });
            return;
        }
    }

    public void a(String s)
    {
        if (s.equals(LibraryPickerActivity.b(a).skuGuid))
        {
            com.pf.common.utility.m.b("activity.LibraryPickerActivity", "ready() sku donwload complete!!");
            h.b().b(this);
            Globals.d(new Runnable() {

                final m a;

                public void run()
                {
                    LibraryPickerActivity.b(a.a, true);
                    LibraryPickerActivity.a(a.a, LibraryPickerActivity.f(a.a));
                }

            
            {
                a = m.this;
                super();
            }
            });
        }
    }

    public void b(String s)
    {
        if (s.equals(LibraryPickerActivity.b(a).skuGuid))
        {
            com.pf.common.utility.m.b("activity.LibraryPickerActivity", " sku donwload failed!!");
            h.b().b(this);
            Globals.d(new Runnable() {

                final m a;

                public void run()
                {
                    LibraryPickerActivity.a(a.a, true);
                    LibraryPickerActivity.a(a.a, LibraryPickerActivity.f(a.a));
                }

            
            {
                a = m.this;
                super();
            }
            });
        }
    }
}
