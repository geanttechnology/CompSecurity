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
    implements r
{

    final o a;
    final a b;

    public void a()
    {
        a.a(null);
    }

    ( , o o1)
    {
        b = ;
        a = o1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/LibraryPickerActivity$2

/* anonymous class */
    class LibraryPickerActivity._cls2
        implements Runnable
    {

        final LibraryPickerActivity a;

        public void run()
        {
            o o1 = Globals.d().i();
            String s = a.getString(0x7f070533);
            o1.a(new LibraryPickerActivity._cls2._cls1(this, o1));
            o1.a(a, null, s, false);
        }

            
            {
                a = librarypickeractivity;
                super();
            }
    }

}
