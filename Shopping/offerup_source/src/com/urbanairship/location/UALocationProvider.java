// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import android.app.PendingIntent;
import android.content.Context;
import com.urbanairship.Logger;
import com.urbanairship.PendingResult;
import com.urbanairship.google.PlayServicesUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.urbanairship.location:
//            FusedLocationAdapter, StandardLocationAdapter, LocationAdapter, LocationRequestOptions

class UALocationProvider
{

    private final List adapters;
    private LocationAdapter connectedAdapter;
    private boolean isConnected;

    public UALocationProvider(Context context)
    {
        adapters = new ArrayList();
        isConnected = false;
        if (PlayServicesUtils.isGooglePlayStoreAvailable() && PlayServicesUtils.isFusedLocationDependencyAvailable())
        {
            adapters.add(new FusedLocationAdapter(context));
        }
        adapters.add(new StandardLocationAdapter(context));
    }

    transient UALocationProvider(LocationAdapter alocationadapter[])
    {
        adapters = new ArrayList();
        isConnected = false;
        adapters.addAll(Arrays.asList(alocationadapter));
    }

    public void cancelRequests(PendingIntent pendingintent)
    {
        Logger.verbose("UALocationProvider - Canceling location requests.");
        Iterator iterator = adapters.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LocationAdapter locationadapter = (LocationAdapter)iterator.next();
            Logger.verbose((new StringBuilder("UALocationProvider - Canceling location requests for adapter: ")).append(locationadapter).toString());
            if (locationadapter == connectedAdapter || locationadapter.connect())
            {
                try
                {
                    locationadapter.cancelLocationUpdates(pendingintent);
                }
                catch (SecurityException securityexception)
                {
                    Logger.verbose((new StringBuilder("Unable to cancel location updates: ")).append(securityexception.getMessage()).toString());
                }
            }
            if (locationadapter != connectedAdapter)
            {
                locationadapter.disconnect();
            }
        } while (true);
    }

    public void connect()
    {
        if (isConnected)
        {
            return;
        }
        Iterator iterator = adapters.iterator();
        do
        {
            LocationAdapter locationadapter;
label0:
            {
                if (iterator.hasNext())
                {
                    locationadapter = (LocationAdapter)iterator.next();
                    Logger.verbose((new StringBuilder("UALocationProvider - Attempting to connect to location adapter: ")).append(locationadapter).toString());
                    if (!locationadapter.connect())
                    {
                        break label0;
                    }
                    Logger.verbose((new StringBuilder("UALocationProvider - Connected to location adapter: ")).append(locationadapter).toString());
                    connectedAdapter = locationadapter;
                }
                isConnected = true;
                return;
            }
            Logger.verbose((new StringBuilder("UALocationProvider - Failed to connect to location adapter: ")).append(locationadapter).toString());
        } while (true);
    }

    public void disconnect()
    {
        if (!isConnected)
        {
            return;
        }
        Logger.verbose("UALocationProvider - Disconnecting from location provider.");
        if (connectedAdapter != null)
        {
            connectedAdapter.disconnect();
            connectedAdapter = null;
        }
        isConnected = false;
    }

    public void requestLocationUpdates(LocationRequestOptions locationrequestoptions, PendingIntent pendingintent)
    {
        if (!isConnected)
        {
            throw new IllegalStateException("Provider must be connected before making requests.");
        }
        if (connectedAdapter == null)
        {
            Logger.debug("UALocationProvider - Ignoring request, connected adapter unavailable.");
            return;
        }
        Logger.verbose((new StringBuilder("UALocationProvider - Requesting location updates: ")).append(locationrequestoptions).toString());
        try
        {
            connectedAdapter.requestLocationUpdates(locationrequestoptions, pendingintent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (LocationRequestOptions locationrequestoptions)
        {
            Logger.error((new StringBuilder("Unable to request location updates: ")).append(locationrequestoptions.getMessage()).toString());
        }
    }

    public PendingResult requestSingleLocation(LocationRequestOptions locationrequestoptions)
    {
        if (!isConnected)
        {
            throw new IllegalStateException("Provider must be connected before making requests.");
        }
        if (connectedAdapter == null)
        {
            Logger.debug("UALocationProvider - Ignoring request, connected adapter unavailable.");
            return null;
        }
        Logger.verbose((new StringBuilder("UALocationProvider - Requesting single location update: ")).append(locationrequestoptions).toString());
        try
        {
            locationrequestoptions = connectedAdapter.requestSingleLocation(locationrequestoptions);
        }
        // Misplaced declaration of an exception variable
        catch (LocationRequestOptions locationrequestoptions)
        {
            Logger.error((new StringBuilder("Unable to request location: ")).append(locationrequestoptions.getMessage()).toString());
            return null;
        }
        return locationrequestoptions;
    }
}
