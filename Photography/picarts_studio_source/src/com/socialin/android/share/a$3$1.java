// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.content.pm.PackageManager;
import android.view.View;
import myobfuscated.cy.d;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements Runnable
{

    private  a;

    public final void run()
    {
        com.socialin.android.share.a.a(a.a, "qq");
        a a1 = a.a;
        PackageManager packagemanager = a.a;
        d.a(a1.getActivity(), "qq", a1.e, new nit>(a1, packagemanager));
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/share/a$3

/* anonymous class */
    final class a._cls3
        implements android.view.View.OnClickListener
    {

        final PackageManager a;
        final a b;

        public final void onClick(View view)
        {
            com.socialin.android.share.a.a(b, new a._cls3._cls1(this));
        }

            
            {
                b = a1;
                a = packagemanager;
                super();
            }
    }

}
