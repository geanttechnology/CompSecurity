// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;

// Referenced classes of package com.google.android.gms.drive.internal:
//            h

static class qK
    implements com.google.android.gms.drive.eApi.ContentsResult
{

    private final Status jY;
    private final Contents qK;

    public Contents getContents()
    {
        return qK;
    }

    public Status getStatus()
    {
        return jY;
    }

    public entsResult(Status status, Contents contents)
    {
        jY = status;
        qK = contents;
    }
}
