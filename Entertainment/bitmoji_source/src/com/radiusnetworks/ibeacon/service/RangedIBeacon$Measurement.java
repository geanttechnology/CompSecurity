// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;


// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            RangedIBeacon

private class <init>
    implements Comparable
{

    Integer rssi;
    final RangedIBeacon this$0;
    long timestamp;

    public int compareTo(<init> <init>1)
    {
        return rssi.compareTo(<init>1.rssi);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    private ()
    {
        this$0 = RangedIBeacon.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
