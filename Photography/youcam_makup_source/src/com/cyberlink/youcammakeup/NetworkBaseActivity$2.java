// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.bu;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup:
//            NetworkBaseActivity, Globals

class a
    implements bu
{

    final float a;
    final NetworkBaseActivity b;

    public void a(List list)
    {
        bo.u();
        if (bo.a())
        {
            bo.b(new bu() {

                final NetworkBaseActivity._cls2 a;

                public void a(List list1)
                {
                    z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a.a, Globals.d());
                }

            
            {
                a = NetworkBaseActivity._cls2.this;
                super();
            }
            });
            return;
        } else
        {
            z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, Globals.d());
            return;
        }
    }

    _cls1.a(NetworkBaseActivity networkbaseactivity, float f)
    {
        b = networkbaseactivity;
        a = f;
        super();
    }
}
