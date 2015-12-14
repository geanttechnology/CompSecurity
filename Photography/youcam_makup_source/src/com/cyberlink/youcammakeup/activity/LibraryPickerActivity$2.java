// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LibraryPickerActivity

class a
    implements Runnable
{

    final LibraryPickerActivity a;

    public void run()
    {
        o o1 = Globals.d().i();
        String s = a.getString(0x7f070533);
        o1.a(new r(o1) {

            final o a;
            final LibraryPickerActivity._cls2 b;

            public void a()
            {
                a.a(null);
            }

            
            {
                b = LibraryPickerActivity._cls2.this;
                a = o1;
                super();
            }
        });
        o1.a(a, null, s, false);
    }

    _cls1.a(LibraryPickerActivity librarypickeractivity)
    {
        a = librarypickeractivity;
        super();
    }
}
