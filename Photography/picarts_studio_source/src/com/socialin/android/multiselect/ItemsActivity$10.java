// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.socialin.android.dialog.g;

// Referenced classes of package com.socialin.android.multiselect:
//            ItemsActivity

final class a
    implements android.content.nClickListener
{

    private ItemsActivity a;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = a;
        g g1 = new g(dialoginterface);
        g1.setMessage(dialoginterface.getResources().getString(0x7f080450));
        g1.setCancelable(true);
        g1.setOnCancelListener(new init>(dialoginterface));
        g1.show();
        (new Thread(new init>(dialoginterface, g1))).start();
    }

    (ItemsActivity itemsactivity)
    {
        a = itemsactivity;
        super();
    }
}
