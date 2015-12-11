// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j;

import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMarkerBinder;

// Referenced classes of package org.slf4j:
//            IMarkerFactory, Marker

public class MarkerFactory
{

    private static IMarkerFactory a;

    private MarkerFactory()
    {
    }

    public static Marker getDetachedMarker(String s)
    {
        return a.getDetachedMarker(s);
    }

    public static IMarkerFactory getIMarkerFactory()
    {
        return a;
    }

    public static Marker getMarker(String s)
    {
        return a.getMarker(s);
    }

    static 
    {
        try
        {
            a = StaticMarkerBinder.SINGLETON.getMarkerFactory();
        }
        catch (Exception exception)
        {
            Util.reportFailure((new StringBuilder()).append("Could not instantiate instance of class [").append(StaticMarkerBinder.SINGLETON.getMarkerFactoryClassStr()).append("]").toString(), exception);
        }
    }
}
