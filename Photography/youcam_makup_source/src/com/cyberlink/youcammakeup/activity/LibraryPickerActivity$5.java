// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;


// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LibraryPickerActivity

class b
    implements Runnable
{

    final String a;
    final String b;
    final LibraryPickerActivity c;

    public void run()
    {
        if (LibraryPickerActivity.b(c, a, b))
        {
            LibraryPickerActivity.a(c, a);
            LibraryPickerActivity.b(c, b);
        }
        LibraryPickerActivity.c(c, true);
        LibraryPickerActivity.a(c, LibraryPickerActivity.f(c));
    }

    A(LibraryPickerActivity librarypickeractivity, String s, String s1)
    {
        c = librarypickeractivity;
        a = s;
        b = s1;
        super();
    }
}
