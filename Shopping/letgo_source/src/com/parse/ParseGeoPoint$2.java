// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.location.Location;
import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseGeoPoint

static final class 
    implements ct
{

    public ParseGeoPoint then(cu cu1)
        throws Exception
    {
        cu1 = (Location)cu1.e();
        return new ParseGeoPoint(cu1.getLatitude(), cu1.getLongitude());
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
    }
}
