// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;


// Referenced classes of package org.altbeacon.beacon:
//            Region

public interface MonitorNotifier
{

    public static final int INSIDE = 1;
    public static final int OUTSIDE = 0;

    public abstract void didDetermineStateForRegion(int i, Region region);

    public abstract void didEnterRegion(Region region);

    public abstract void didExitRegion(Region region);
}
