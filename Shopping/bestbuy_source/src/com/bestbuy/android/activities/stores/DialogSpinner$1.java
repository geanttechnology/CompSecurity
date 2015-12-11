// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.content.DialogInterface;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            DialogSpinner

class a
    implements android.content.OnClickListener
{

    final DialogSpinner a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        a.setSelection(i);
        dialoginterface.dismiss();
    }

    (DialogSpinner dialogspinner)
    {
        a = dialogspinner;
        super();
    }
}
