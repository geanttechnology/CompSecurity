// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragment

class a
    implements android.content.e.OnClickListener
{

    final PDPFragment a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://www.bestbuy.com").append(PDPFragment.a(a)).toString()));
        a.startActivity(dialoginterface);
    }

    (PDPFragment pdpfragment)
    {
        a = pdpfragment;
        super();
    }
}
