// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon;


// Referenced classes of package com.radiusnetworks.ibeacon:
//            IBeaconDataNotifier

public interface IBeaconData
{

    public abstract String get(String s);

    public abstract Double getLatitude();

    public abstract Double getLongitude();

    public abstract boolean isDirty();

    public abstract void set(String s, String s1);

    public abstract void setLatitude(Double double1);

    public abstract void setLongitude(Double double1);

    public abstract void sync(IBeaconDataNotifier ibeacondatanotifier);
}
