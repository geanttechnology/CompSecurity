// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

// Referenced classes of package com.wishabi.flipp.app:
//            j, k

public final class i extends DialogFragment
{

    k a;
    private int b;

    public i()
    {
    }

    static k a(i k)
    {
        return k.a;
    }

    static int b(i k)
    {
        return k.b;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b = getArguments().getInt("EDIT_MENU_ITEM_KEY");
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        if (getActivity() == null)
        {
            return null;
        }
        bundle = new android.app.AlertDialog.Builder(getActivity());
        b;
        JVM INSTR tableswitch 2131427666 2131427668: default 52
    //                   2131427666 62
    //                   2131427667 102
    //                   2131427668 119;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalStateException("Item id must be set before use");
_L2:
        bundle.setTitle(0x7f0e008f);
        bundle.setMessage(0x7f0e008e);
_L6:
        j j1 = new j(this);
        return bundle.setPositiveButton(0x7f0e0160, j1).setNegativeButton(0x7f0e00e5, j1).create();
_L3:
        bundle.setTitle(0x7f0e008d);
        bundle.setMessage(0x7f0e008c);
        continue; /* Loop/switch isn't completed */
_L4:
        bundle.setTitle(0x7f0e008b);
        bundle.setMessage(0x7f0e008a);
        if (true) goto _L6; else goto _L5
_L5:
    }
}
