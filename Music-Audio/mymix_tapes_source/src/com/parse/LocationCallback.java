// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback, ParseGeoPoint, ParseException

public abstract class LocationCallback extends ParseCallback
{

    public LocationCallback()
    {
    }

    public abstract void done(ParseGeoPoint parsegeopoint, ParseException parseexception);

    final void internalDone(ParseGeoPoint parsegeopoint, ParseException parseexception)
    {
        done(parsegeopoint, parseexception);
    }

    volatile void internalDone(Object obj, ParseException parseexception)
    {
        internalDone((ParseGeoPoint)obj, parseexception);
    }
}
