// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.util;

import android.app.Fragment;
import android.content.res.Resources;
import com.ebay.app.AlertDialogFragment;

public class SellUtil
{

    public SellUtil()
    {
    }

    public static void showInvalidDraftDialog(Fragment fragment, int i)
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        builder.setMessage(fragment.getResources().getString(0x7f0709d3));
        builder.setPositiveButton(0x7f070738);
        builder.createFromFragment(i, fragment).show(fragment.getFragmentManager(), fragment.getClass().getName());
    }
}
