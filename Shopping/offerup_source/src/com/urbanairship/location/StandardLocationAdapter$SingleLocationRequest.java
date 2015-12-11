// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.urbanairship.Logger;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.urbanairship.location:
//            PendingLocationResult, StandardLocationAdapter, LocationRequestOptions

class listenForLocationChanges extends PendingLocationResult
{

    private final Criteria criteria;
    private String currentProvider;
    private final r currentProviderListener;
    private final LocationRequestOptions options;
    private final r providerEnabledListeners;
    final StandardLocationAdapter this$0;

    private void listenForLocationChanges()
    {
        if (currentProvider != null)
        {
            StandardLocationAdapter.access$700(StandardLocationAdapter.this).removeUpdates(currentProviderListener);
        }
        String s = StandardLocationAdapter.access$500(StandardLocationAdapter.this, criteria, options);
        currentProvider = s;
        if (s != null)
        {
            Logger.verbose((new StringBuilder("StandardLocationAdapter - Single request using provider: ")).append(s).toString());
            StandardLocationAdapter.access$700(StandardLocationAdapter.this).requestLocationUpdates(s, 0L, 0.0F, currentProviderListener);
        }
    }

    private void listenForProvidersEnabled()
    {
        Object obj = StandardLocationAdapter.access$700(StandardLocationAdapter.this).getProviders(criteria, false);
        if (obj != null)
        {
            String s;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); StandardLocationAdapter.access$700(StandardLocationAdapter.this).requestLocationUpdates(s, 0x7fffffffffffffffL, 3.402823E+38F, providerEnabledListeners))
            {
                s = (String)((Iterator) (obj)).next();
                Logger.verbose((new StringBuilder("StandardLocationAdapter - Single location request listening provider enable/disabled for: ")).append(s).toString());
            }

        }
    }

    private void stopUpdates()
    {
        StandardLocationAdapter.access$700(StandardLocationAdapter.this).removeUpdates(currentProviderListener);
        StandardLocationAdapter.access$700(StandardLocationAdapter.this).removeUpdates(providerEnabledListeners);
    }

    protected void onCancel()
    {
        Logger.verbose("StandardLocationAdapter - Canceling single request.");
        stopUpdates();
    }





    r(final LocationRequestOptions options)
    {
        this.this$0 = StandardLocationAdapter.this;
        super();
        currentProvider = null;
        this.options = options;
        criteria = StandardLocationAdapter.access$000(StandardLocationAdapter.this, options);
        class _cls1 extends StandardLocationAdapter.AndroidLocationListener
        {

            final StandardLocationAdapter.SingleLocationRequest this$1;
            final StandardLocationAdapter val$this$0;

            public void onLocationChanged(Location location)
            {
                stopUpdates();
                setResult(location);
            }

            public void onProviderDisabled(String s)
            {
                Logger.verbose((new StringBuilder("StandardLocationAdapter - Provider disabled: ")).append(s).toString());
                this;
                JVM INSTR monitorenter ;
                if (!isDone())
                {
                    listenForLocationChanges();
                }
                this;
                JVM INSTR monitorexit ;
                return;
                s;
                this;
                JVM INSTR monitorexit ;
                throw s;
            }

            _cls1()
            {
                this$1 = StandardLocationAdapter.SingleLocationRequest.this;
                this$0 = standardlocationadapter;
                super(null);
            }
        }

        currentProviderListener = new _cls1();
        class _cls2 extends StandardLocationAdapter.AndroidLocationListener
        {

            final StandardLocationAdapter.SingleLocationRequest this$1;
            final LocationRequestOptions val$options;
            final StandardLocationAdapter val$this$0;

            public void onProviderEnabled(String s)
            {
                Logger.verbose((new StringBuilder("StandardLocationAdapter - Provider enabled: ")).append(s).toString());
                this;
                JVM INSTR monitorenter ;
                if (isDone())
                {
                    break MISSING_BLOCK_LABEL_78;
                }
                s = StandardLocationAdapter.access$500(StandardLocationAdapter.SingleLocationRequest.this.this$0, criteria, options);
                if (s == null)
                {
                    break MISSING_BLOCK_LABEL_78;
                }
                if (!s.equals(currentProvider))
                {
                    listenForLocationChanges();
                }
                this;
                JVM INSTR monitorexit ;
                return;
                s;
                this;
                JVM INSTR monitorexit ;
                throw s;
            }

            _cls2()
            {
                this$1 = StandardLocationAdapter.SingleLocationRequest.this;
                this$0 = standardlocationadapter;
                options = locationrequestoptions;
                super(null);
            }
        }

        providerEnabledListeners = new _cls2();
        if (options.getPriority() != 4)
        {
            listenForProvidersEnabled();
        }
        listenForLocationChanges();
    }
}
