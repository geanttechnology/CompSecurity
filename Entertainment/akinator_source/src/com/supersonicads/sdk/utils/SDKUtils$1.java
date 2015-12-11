// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.utils;

import android.content.DialogInterface;

// Referenced classes of package com.supersonicads.sdk.utils:
//            SDKUtils

static final class Listener
    implements android.content.face.OnClickListener
{

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    Listener()
    {
    }
}
