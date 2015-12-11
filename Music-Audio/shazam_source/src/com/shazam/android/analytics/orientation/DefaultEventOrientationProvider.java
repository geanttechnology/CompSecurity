// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.orientation;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.shazam.b.b.d;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.orientation:
//            EventOrientationProvider

public class DefaultEventOrientationProvider
    implements EventOrientationProvider
{

    private final Context context;
    private final Map orientationMap = d.a(Integer.valueOf(2), "landscape", Integer.valueOf(1), "portrait");

    public DefaultEventOrientationProvider(Context context1)
    {
        context = context1;
    }

    public String getOrientation()
    {
        Configuration configuration = context.getResources().getConfiguration();
        return (String)orientationMap.get(Integer.valueOf(configuration.orientation));
    }
}
