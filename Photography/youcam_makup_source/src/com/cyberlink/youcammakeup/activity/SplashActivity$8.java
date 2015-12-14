// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.DialogInterface;
import android.text.Editable;
import android.widget.EditText;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.z;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SplashActivity, s

class a
    implements android.content.nClickListener
{

    final EditText a;
    final SplashActivity b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Editable editable = a.getText();
        h h1 = h.b();
        if (editable.length() > 0)
        {
            dialoginterface = editable.toString();
        } else
        {
            dialoginterface = "none";
        }
        h1.a(dialoginterface);
        if (editable.length() > 0)
        {
            z.d(b.getApplicationContext(), editable.toString());
        }
        SplashActivity.a(b).f = Boolean.valueOf(true);
        SplashActivity.b(b);
    }

    (SplashActivity splashactivity, EditText edittext)
    {
        b = splashactivity;
        a = edittext;
        super();
    }
}
