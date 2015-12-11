// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.location.Location;

// Referenced classes of package com.parse:
//            ParseGeoPoint

static final class 
    implements i
{

    public ParseGeoPoint then(j j1)
        throws Exception
    {
        j1 = (Location)j1.e();
        return new ParseGeoPoint(j1.getLatitude(), j1.getLongitude());
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
    }
}
