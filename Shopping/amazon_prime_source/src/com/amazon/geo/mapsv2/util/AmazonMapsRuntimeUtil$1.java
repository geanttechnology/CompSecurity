// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.content.Context;
import android.util.Log;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapsRuntimeUtil

static final class ry
    implements com.amazon.geo.mapsv2.pvt.ory
{

    public transient Context createInstance(Object aobj[])
    {
        if (aobj.length != 1)
        {
            return null;
        }
        aobj = (Context)android/content/Context.cast(aobj[0]);
        try
        {
            aobj = AmazonMapsRuntimeUtil.access$000(((Context) (aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            Log.v("AmazonMapsV2", "Module threw an exception.", ((Throwable) (aobj)));
            return null;
        }
        return ((Context) (aobj));
    }

    public volatile Object createInstance(Object aobj[])
    {
        return createInstance(aobj);
    }

    ry()
    {
    }
}
