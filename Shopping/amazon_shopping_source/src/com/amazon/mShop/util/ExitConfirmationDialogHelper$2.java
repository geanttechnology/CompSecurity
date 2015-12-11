// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.DialogInterface;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.util:
//            ExitConfirmationDialogHelper, AppUtils

static final class val.refMarkerOK
    implements android.content.
{

    final String val$refMarkerOK;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        RefMarkerObserver.logRefMarker(val$refMarkerOK);
        AppUtils.exitApp();
    }

    (String s)
    {
        val$refMarkerOK = s;
        super();
    }
}
