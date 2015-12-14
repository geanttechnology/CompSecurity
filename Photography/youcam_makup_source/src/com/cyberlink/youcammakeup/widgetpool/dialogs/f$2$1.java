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

    final a a;

    public void run()
    {
        a.a.a();
    }

    _cls9(_cls9 _pcls9)
    {
        a = _pcls9;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/f$2

/* anonymous class */
    class f._cls2
        implements Runnable
    {

        final f a;

        public void run()
        {
            f.c(a).show();
            f.a(a, new f._cls2._cls1(this));
            f.b(a).postDelayed(f.a(a), f.e(a));
        }

            
            {
                a = f1;
                super();
            }
    }

}
