// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.utility.o;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LibraryPickerActivity

class b
    implements e
{

    final String a;
    final String b;
    final LibraryPickerActivity c;

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        if (list.size() != 1)
        {
            ((BaseActivity)c.getApplicationContext()).f();
            return;
        }
        list = (MakeupItemMetadata)list.get(0);
        NetworkManager networkmanager = Globals.d().w();
        try
        {
            networkmanager.a(new d(networkmanager, 0x15ab1cL, list, new j() {

                final LibraryPickerActivity._cls3 a;

                public void a(a a1)
                {
                }

                public void a(bn bn1)
                {
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    com.cyberlink.youcammakeup.activity.LibraryPickerActivity.a(a.c, a.a);
                    LibraryPickerActivity.b(a.c, a.b);
                    Globals.d().i().h(a.c);
                }

                public void b(Object obj)
                {
                    a((bn)obj);
                }

                public void b(Void void1)
                {
                }

                public void c(Object obj)
                {
                    b((Void)obj);
                }

                public void d(Object obj)
                {
                    a((a)obj);
                }

            
            {
                a = LibraryPickerActivity._cls3.this;
                super();
            }
            }));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
        }
    }

    public void b(Object obj)
    {
    }

    public void c(Object obj)
    {
    }

    _cls1.a(LibraryPickerActivity librarypickeractivity, String s, String s1)
    {
        c = librarypickeractivity;
        a = s;
        b = s1;
        super();
    }
}
