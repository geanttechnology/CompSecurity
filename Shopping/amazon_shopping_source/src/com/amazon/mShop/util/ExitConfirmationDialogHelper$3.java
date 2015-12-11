// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.DialogInterface;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.util:
//            ExitConfirmationDialogHelper

static final class val.refMarkerCancel
    implements android.content.
{

    final String val$refMarkerCancel;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        RefMarkerObserver.logRefMarker(val$refMarkerCancel);
    }

    (String s)
    {
        val$refMarkerCancel = s;
        super();
    }
}
