// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.bu;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivityForIntent

class a
    implements bu
{

    final a a;

    public void a(List list)
    {
        z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a.a, a.a);
        EditViewActivityForIntent.a(a.a);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivityForIntent$2

/* anonymous class */
    class EditViewActivityForIntent._cls2
        implements bu
    {

        final float a;
        final EditViewActivityForIntent b;

        public void a(List list)
        {
            bo.u();
            if (bo.a())
            {
                bo.b(new EditViewActivityForIntent._cls2._cls1(this));
                return;
            } else
            {
                z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, b);
                EditViewActivityForIntent.a(b);
                return;
            }
        }

            
            {
                b = editviewactivityforintent;
                a = f;
                super();
            }
    }

}
