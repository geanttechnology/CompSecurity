// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.urbanairship.Logger;

// Referenced classes of package com.urbanairship.location:
//            PendingLocationResult, FusedLocationAdapter, LocationRequestOptions

class fusedLocationListener extends PendingLocationResult
{

    private final LocationListener fusedLocationListener;
    private final LocationRequest locationRequest;
    final FusedLocationAdapter this$0;

    protected void onCancel()
    {
        Logger.verbose("FusedLocationAdapter - Canceling single location request.");
        LocationServices.FusedLocationApi.removeLocationUpdates(FusedLocationAdapter.access$100(FusedLocationAdapter.this), fusedLocationListener);
    }

    _cls1.val.this._cls0(LocationRequestOptions locationrequestoptions)
    {
        this.this$0 = FusedLocationAdapter.this;
        super();
        locationRequest = FusedLocationAdapter.access$000(FusedLocationAdapter.this, locationrequestoptions);
        locationRequest.setNumUpdates(1);
        class _cls1
            implements LocationListener
        {

            final FusedLocationAdapter.SingleLocationRequest this$1;
            final FusedLocationAdapter val$this$0;

            public void onLocationChanged(Location location)
            {
                setResult(location);
            }

            _cls1()
            {
                this$1 = FusedLocationAdapter.SingleLocationRequest.this;
                this$0 = fusedlocationadapter;
                super();
            }
        }

        fusedLocationListener = new _cls1();
        Logger.verbose("FusedLocationAdapter - Starting single location request.");
        LocationServices.FusedLocationApi.requestLocationUpdates(FusedLocationAdapter.access$100(FusedLocationAdapter.this), locationRequest, fusedLocationListener, Looper.myLooper());
    }
}
