// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.multiselect:
//            ItemsActivity

final class a
    implements android.content.OnCancelListener
{

    private ItemsActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        ItemsActivity.a(a, true);
    }

    (ItemsActivity itemsactivity)
    {
        a = itemsactivity;
        super();
    }
}
