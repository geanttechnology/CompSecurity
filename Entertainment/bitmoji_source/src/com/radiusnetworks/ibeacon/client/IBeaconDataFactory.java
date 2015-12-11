// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.client;

import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconDataNotifier;

public interface IBeaconDataFactory
{

    public abstract void requestIBeaconData(IBeacon ibeacon, IBeaconDataNotifier ibeacondatanotifier);
}
