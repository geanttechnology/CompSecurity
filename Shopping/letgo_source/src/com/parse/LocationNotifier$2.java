// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.location.LocationListener;
import android.location.LocationManager;

// Referenced classes of package com.parse:
//            LocationNotifier, ParseException

static final class val.listener
    implements Runnable
{

    final LocationListener val$listener;
    final LocationManager val$manager;
    final android.support.v7.ner val$tcs;

    public void run()
    {
        val$tcs.ner(new ParseException(124, "Location fetch timed out."));
        val$manager.removeUpdates(val$listener);
    }

    ener(android.support.v7. , LocationManager locationmanager, LocationListener locationlistener)
    {
        val$tcs = ;
        val$manager = locationmanager;
        val$listener = locationlistener;
        super();
    }
}
