// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.interfaces;

import android.os.Parcelable;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.common.Geofence;

// Referenced classes of package com.target.mothership.model.store.interfaces:
//            Store

public interface StoreSummary
    extends Parcelable, Store
{

    public abstract Address getAddress();

    public abstract Geofence getGeofence();

    public abstract String getName();

    public abstract boolean hasRequestATeamMember();
}
