// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

// Referenced classes of package com.cyberlink.youcammakeup:
//            b

public class a extends DialogFragment
{

    private android.content.DialogInterface.OnDismissListener a;
    private b b;

    public a()
    {
    }

    protected void a()
    {
        setStyle(1, 0x7f0a0209);
    }

    public void a(android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        a = ondismisslistener;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (b != null)
        {
            b.a();
        }
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (a != null)
        {
            a.onDismiss(dialoginterface);
        }
    }
}
