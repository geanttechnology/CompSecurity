// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.receivers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.abtnprojects.ambatana.receivers:
//            a

public class OnUpgradeReceiverPreApi12 extends a
{

    public OnUpgradeReceiverPreApi12()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null && intent.getData() != null && context.getPackageName().equals(intent.getData().getSchemeSpecificPart()))
        {
            a(context);
        }
    }
}
