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
    implements android.view.OnClickListener
{

    final PackageManager a;
    final a b;

    public final void onClick(View view)
    {
        com.socialin.android.share.a.a(b, new Runnable() {

            private a._cls36 a;

            public final void run()
            {
                com.socialin.android.share.a.a(a.b, "wechat");
                a a1 = a.b;
                PackageManager packagemanager = a.a;
                d.a(a1.getActivity(), "wechat", a1.e, new a._cls2(a1, packagemanager));
            }

            
            {
                a = a._cls36.this;
                super();
            }
        });
    }

    r(a a1, PackageManager packagemanager)
    {
        b = a1;
        a = packagemanager;
        super();
    }
}
