// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

// Referenced classes of package com.arellomobile.android.push:
//            GeoLocationService

class this._cls0 extends BroadcastReceiver
{

    final GeoLocationService this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = (Location)intent.getExtras().get("location");
        if (context != null)
        {
            Log.d("LocationUpdateService", (new StringBuilder()).append("- singleUpdateReciever").append(context.toString()).toString());
            onPollStationaryLocation(context);
        }
    }

    ()
    {
        this$0 = GeoLocationService.this;
        super();
    }
}
