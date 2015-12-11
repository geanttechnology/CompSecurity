// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.internal:
//            fl

abstract class nE extends nE
    implements Releasable, Result
{

    final Status jY;
    final DataHolder nE;
    final fl tZ;

    public Status getStatus()
    {
        return jY;
    }

    public void release()
    {
        if (nE != null)
        {
            nE.close();
        }
    }

    public aHolder(fl fl1, com.google.android.gms.common.api.older older, DataHolder dataholder)
    {
        tZ = fl1;
        super(fl1, older, dataholder);
        jY = new Status(dataholder.getStatusCode());
        nE = dataholder;
    }
}
