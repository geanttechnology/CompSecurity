// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.internal:
//            hn, hs

final class Dp extends hn
{

    final hs DM;
    private final com.google.android.gms.common.api.Holder Dp;

    public void a(DataHolder dataholder, String s, String s1)
    {
        Object obj;
        if (dataholder.getMetadata() != null)
        {
            obj = (PendingIntent)dataholder.getMetadata().getParcelable("pendingIntent");
        } else
        {
            obj = null;
        }
        obj = new Status(dataholder.getStatusCode(), null, ((PendingIntent) (obj)));
        if (!((Status) (obj)).isSuccess() && dataholder != null)
        {
            if (!dataholder.isClosed())
            {
                dataholder.close();
            }
            dataholder = null;
        }
        DM.a(new <init>(DM, Dp, ((Status) (obj)), dataholder, s, s1));
    }

    public (hs hs1, com.google.android.gms.common.api.r r)
    {
        DM = hs1;
        super();
        Dp = r;
    }
}
