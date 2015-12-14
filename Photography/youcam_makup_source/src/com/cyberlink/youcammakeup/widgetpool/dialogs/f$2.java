// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Dialog;
import android.os.Handler;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            f

class a
    implements Runnable
{

    final f a;

    public void run()
    {
        f.c(a).show();
        f.a(a, new Runnable() {

            final f._cls2 a;

            public void run()
            {
                a.a.a();
            }

            
            {
                a = f._cls2.this;
                super();
            }
        });
        f.b(a).postDelayed(f.a(a), f.e(a));
    }

    _cls1.a(f f1)
    {
        a = f1;
        super();
    }
}
