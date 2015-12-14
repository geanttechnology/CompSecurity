// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.h;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditAboutActivity

class a
    implements android.view.
{

    final EditAboutActivity a;

    public void onClick(View view)
    {
        EditAboutActivity.b(a, h.a(view.getContext()));
        DialogUtils.a(a, 48133, 48134, EditAboutActivity.g(a));
    }

    (EditAboutActivity editaboutactivity)
    {
        a = editaboutactivity;
        super();
    }
}
