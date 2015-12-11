// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.mShop.util:
//            UpgradeUtil

static final class ncelListener
    implements android.content.e.OnCancelListener
{

    public void onCancel(DialogInterface dialoginterface)
    {
        dialoginterface.dismiss();
    }

    ncelListener()
    {
    }
}
