// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMap

private static class backDelegate extends PrimitiveBase
    implements com.amazon.geo.mapsv2.internal.ate
{

    private static com.amazon.geo.mapsv2.internal.ate create(backDelegate backdelegate)
    {
        if (backdelegate == null)
        {
            return null;
        } else
        {
            return new <init>(backdelegate);
        }
    }

    public void onCancel()
    {
        ((<init>)get()).();
    }

    public void onFinish()
    {
        (()get()).();
    }


    private backDelegate(backDelegate backdelegate)
    {
        super(backdelegate);
    }
}
