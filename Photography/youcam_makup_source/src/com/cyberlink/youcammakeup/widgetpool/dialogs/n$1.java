// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            n

class a
    implements android.view..OnClickListener
{

    final n a;

    public void onClick(View view)
    {
        a.dismiss();
        StatusManager.j().a(false, n.a(a));
    }

    sManager(n n1)
    {
        a = n1;
        super();
    }
}
