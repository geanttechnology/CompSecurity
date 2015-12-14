// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.MMLog;

// Referenced classes of package com.millennialmedia.internal:
//            AdPlacementReporter

static final class 
    implements Runnable
{

    public void run()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(AdPlacementReporter.access$100(), "Reporting batch frequency detected -- requesting upload");
        }
        tUploadState(.UPLOADING);
    }

    ()
    {
    }
}
