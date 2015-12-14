// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookPlacePickerActivity

class a
    implements r
{

    final boolean a;
    final FacebookPlacePickerActivity b;

    public void a()
    {
        Globals.d().i().a(null);
        if (!a)
        {
            FacebookPlacePickerActivity.a(b);
        }
    }

    (FacebookPlacePickerActivity facebookplacepickeractivity, boolean flag)
    {
        b = facebookplacepickeractivity;
        a = flag;
        super();
    }
}
