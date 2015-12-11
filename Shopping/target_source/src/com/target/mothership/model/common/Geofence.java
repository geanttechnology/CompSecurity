// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcelable;

// Referenced classes of package com.target.mothership.model.common:
//            Coordinates

public interface Geofence
    extends Parcelable
{

    public abstract Coordinates getCenter();

    public abstract double getRadius();
}
