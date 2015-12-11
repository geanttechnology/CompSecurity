// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.panorama;

import android.content.Intent;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.panorama:
//            Panorama

class jP
    implements ramaResult
{

    final jP Dh;
    final Status jP;

    public Status getStatus()
    {
        return jP;
    }

    public Intent getViewerIntent()
    {
        return null;
    }

    ramaResult(ramaResult ramaresult, Status status)
    {
        Dh = ramaresult;
        jP = status;
        super();
    }
}
