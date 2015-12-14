// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.widget.Toast;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ae

class a
    implements Runnable
{

    final String a;
    final ae b;

    public void run()
    {
        Toast toast = Toast.makeText(b.getActivity(), a, 1);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    (ae ae1, String s)
    {
        b = ae1;
        a = s;
        super();
    }
}
