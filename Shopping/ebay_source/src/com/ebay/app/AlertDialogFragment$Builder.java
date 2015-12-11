// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.app.Fragment;
import android.os.Bundle;

// Referenced classes of package com.ebay.app:
//            AlertDialogFragment

public static class negativeButtonTextId
{

    private final fields fields = new init>(null);
    private int messageId;
    private int negativeButtonTextId;
    private int positiveButtonTextId;
    private int titleId;

    public AlertDialogFragment createFromActivity(int i)
    {
        return createFromFragment(i, null);
    }

    public AlertDialogFragment createFromFragment(int i, Fragment fragment)
    {
        return createFromFragment(i, fragment, null);
    }

    public AlertDialogFragment createFromFragment(int i, Fragment fragment, Bundle bundle)
    {
        AlertDialogFragment alertdialogfragment = new AlertDialogFragment();
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putCharSequence("title", ccess._mth100(fields));
        bundle1.putCharSequence("message", ccess._mth200(fields));
        bundle1.putCharSequence("positiveButtonText", ccess._mth300(fields));
        bundle1.putCharSequence("negativeButtonText", ccess._mth400(fields));
        bundle1.putInt("titleId", titleId);
        bundle1.putInt("messageId", messageId);
        bundle1.putInt("positiveButtonTextId", positiveButtonTextId);
        bundle1.putInt("negativeButtonTextId", negativeButtonTextId);
        bundle1.putCharSequenceArray("items", ccess._mth600(fields));
        bundle1.putBooleanArray("checkedItems", ccess._mth700(fields));
        bundle1.putBoolean("messageAsWebview", ccess._mth500(fields));
        bundle1.putBoolean("retainInstance", fields.etainInstance);
        bundle1.putBoolean("linksClickable", fields.inksClickable);
        alertdialogfragment.setArguments(bundle1);
        alertdialogfragment.setTargetFragment(fragment, i);
        return alertdialogfragment;
    }

    public tFragment setItems(String as[])
    {
        ccess._mth602(fields, as);
        return this;
    }

    public fields setLinksClickable(boolean flag)
    {
        fields.inksClickable = flag;
        return this;
    }

    public inksClickable setMessage(int i)
    {
        messageId = i;
        ccess._mth202(fields, null);
        return this;
    }

    public fields setMessage(CharSequence charsequence)
    {
        ccess._mth202(fields, charsequence);
        return this;
    }

    public fields setMessageAsWebview(boolean flag)
    {
        ccess._mth502(fields, flag);
        return this;
    }

    public fields setMultiChoiceItems(String as[], boolean aflag[])
    {
        ccess._mth602(fields, as);
        ccess._mth702(fields, aflag);
        return this;
    }

    public fields setNegativeButton(int i)
    {
        negativeButtonTextId = i;
        ccess._mth402(fields, null);
        return this;
    }

    public fields setNegativeButton(CharSequence charsequence)
    {
        ccess._mth402(fields, charsequence);
        return this;
    }

    public fields setPositiveButton(int i)
    {
        positiveButtonTextId = i;
        ccess._mth302(fields, null);
        return this;
    }

    public fields setPositiveButton(CharSequence charsequence)
    {
        ccess._mth302(fields, charsequence);
        return this;
    }

    public fields setRetainInstance(boolean flag)
    {
        fields.etainInstance = flag;
        return this;
    }

    public etainInstance setTitle(int i)
    {
        titleId = i;
        ccess._mth102(fields, null);
        return this;
    }

    public fields setTitle(CharSequence charsequence)
    {
        ccess._mth102(fields, charsequence);
        return this;
    }

    public ()
    {
        titleId = -1;
        messageId = -1;
        positiveButtonTextId = -1;
        negativeButtonTextId = -1;
    }
}
