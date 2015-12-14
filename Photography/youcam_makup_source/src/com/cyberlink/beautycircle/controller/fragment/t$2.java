// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            t

class a
    implements android.view..OnClickListener
{

    final t a;

    public void onClick(View view)
    {
        AccountManager.a(a.getActivity(), 0, new b() {

            final t._cls2 a;

            public void a()
            {
            }

            public void a(String s)
            {
            }

            public void b()
            {
            }

            
            {
                a = t._cls2.this;
                super();
            }
        });
    }

    _cls1.a(t t1)
    {
        a = t1;
        super();
    }
}
