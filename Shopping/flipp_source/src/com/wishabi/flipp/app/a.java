// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

// Referenced classes of package com.wishabi.flipp.app:
//            b

public final class a extends DialogFragment
{

    public a()
    {
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        if (getActivity() == null)
        {
            return null;
        } else
        {
            bundle = new b(this, getActivity().getSharedPreferences("com.wishabi.flipp.preferences", 0));
            return (new android.app.AlertDialog.Builder(getActivity())).setTitle((new StringBuilder()).append(getString(0x7f0e0009)).append("?").toString()).setMessage(getString(0x7f0e0008)).setPositiveButton(0x7f0e0160, bundle).setNegativeButton(0x7f0e00e5, bundle).create();
        }
    }
}
