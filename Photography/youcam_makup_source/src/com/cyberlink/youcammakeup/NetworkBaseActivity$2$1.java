// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.bu;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup:
//            Globals, NetworkBaseActivity

class a
    implements bu
{

    final a a;

    public void a(List list)
    {
        z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a.a, Globals.d());
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/NetworkBaseActivity$2

/* anonymous class */
    class NetworkBaseActivity._cls2
        implements bu
    {

        final float a;
        final NetworkBaseActivity b;

        public void a(List list)
        {
            bo.u();
            if (bo.a())
            {
                bo.b(new NetworkBaseActivity._cls2._cls1(this));
                return;
            } else
            {
                z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, Globals.d());
                return;
            }
        }

            
            {
                b = networkbaseactivity;
                a = f;
                super();
            }
    }

}
