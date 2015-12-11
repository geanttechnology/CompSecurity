// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public class AmazonDocumentLoadTimes
{

    private final double commitLoadTime;
    private final double finishDocumentLoadTime;
    private final double finishLoadTime;
    private final double firstPaintAfterLoadTime;
    private final double firstPaintTime;
    private final String navigationType;
    private final String npnNegotiatedProtocol;
    private final double requestTime;
    private final double startLoadTime;
    private final boolean wasAlternateProtocolAvailable;
    private final boolean wasFetchedViaSpdy;
    private final boolean wasNpnNegotiated;

    public AmazonDocumentLoadTimes(double d, double d1, double d2, double d3, double d4, double d5, double d6, 
            String s, boolean flag, boolean flag1, String s1, boolean flag2)
    {
        requestTime = d;
        startLoadTime = d1;
        commitLoadTime = d2;
        finishDocumentLoadTime = d3;
        finishLoadTime = d4;
        firstPaintTime = d5;
        firstPaintAfterLoadTime = d6;
        navigationType = s;
        wasFetchedViaSpdy = flag;
        wasNpnNegotiated = flag1;
        npnNegotiatedProtocol = s1;
        wasAlternateProtocolAvailable = flag2;
    }

    public double getCommitLoadTime()
    {
        return commitLoadTime;
    }

    public double getFinishDocumentLoadTime()
    {
        return finishDocumentLoadTime;
    }

    public double getFinishLoadTime()
    {
        return finishLoadTime;
    }

    public double getFirstPaintAfterLoadTime()
    {
        return firstPaintAfterLoadTime;
    }

    public double getFirstPaintTime()
    {
        return firstPaintTime;
    }

    public String getNavigationType()
    {
        return navigationType;
    }

    public String getNegociationProtocol()
    {
        return npnNegotiatedProtocol;
    }

    public double getRequestTime()
    {
        return requestTime;
    }

    public double getStartLoadTime()
    {
        return startLoadTime;
    }

    public boolean getWasAlternateProtocolAvailable()
    {
        return wasAlternateProtocolAvailable;
    }

    public boolean getWasFetchedViaSpdy()
    {
        return wasFetchedViaSpdy;
    }

    public boolean getWasNpnNegociated()
    {
        return wasNpnNegotiated;
    }
}
