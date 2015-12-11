// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.panorama;

import android.content.Intent;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.panorama:
//            Panorama

private static abstract class  extends com.google.android.gms.common.api.vb
{

    public noramaResult J(Status status)
    {
        return new Panorama.PanoramaResult(status) {

            final Panorama.b QA;
            final Status vb;

            public Status getStatus()
            {
                return vb;
            }

            public Intent getViewerIntent()
            {
                return null;
            }

            
            {
                QA = Panorama.b.this;
                vb = status;
                super();
            }
        };
    }

    public Result d(Status status)
    {
        return J(status);
    }

    public _cls1.vb()
    {
        super(Panorama.va);
    }
}
