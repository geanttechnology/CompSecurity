// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.sku.j;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SponsorAdActivity

class u
    implements j
{

    final SponsorAdActivity a;

    u(SponsorAdActivity sponsoradactivity)
    {
        a = sponsoradactivity;
        super();
    }

    public void a()
    {
        m.b("SponsorAdActivity", " sku donwload complete!!");
        if (h.b().b(SponsorAdActivity.a(a).type, SponsorAdActivity.a(a).skuGuid) == null)
        {
            return;
        } else
        {
            h.b().b(this);
            Globals.d(new Runnable() {

                final u a;

                public void run()
                {
                    SponsorAdActivity.b(a.a);
                }

            
            {
                a = u.this;
                super();
            }
            });
            return;
        }
    }

    public void a(String s)
    {
        if (s.equals(SponsorAdActivity.a(a).skuGuid))
        {
            m.b("SponsorAdActivity", " sku donwload complete!!");
            h.b().b(this);
            Globals.d(new Runnable() {

                final u a;

                public void run()
                {
                    SponsorAdActivity.b(a.a);
                }

            
            {
                a = u.this;
                super();
            }
            });
        }
    }

    public void b(String s)
    {
        if (s.equals(SponsorAdActivity.a(a).skuGuid))
        {
            m.b("SponsorAdActivity", " sku donwload failed!!");
            h.b().b(this);
            SponsorAdActivity.c(a);
        }
    }
}
