// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public class AmazonWebTimings
    implements Cloneable
{

    private final double connectEnd;
    private final double connectStart;
    private final double domComplete;
    private final double domContentLoadedEventEnd;
    private final double domContentLoadedEventStart;
    private final double domInteractive;
    private final double domLoading;
    private final double domainLookupEnd;
    private final double domainLookupStart;
    private final double fetchStart;
    private final double loadEventEnd;
    private final double loadEventStart;
    private final double navigationStart;
    private final int redirectCount;
    private final double redirectEnd;
    private final double redirectStart;
    private final double requestStart;
    private final double responseEnd;
    private final double responseStart;
    private final double unloadEventEnd;

    public AmazonWebTimings(double d, double d1, double d2, double d3, int i, double d4, double d5, double d6, double d7, double d8, double d9, 
            double d10, double d11, double d12, double d13, double d14, double d15, double d16, 
            double d17, double d18)
    {
        navigationStart = d;
        unloadEventEnd = d1;
        redirectStart = d2;
        redirectEnd = d3;
        redirectCount = i;
        fetchStart = d4;
        domainLookupStart = d5;
        domainLookupEnd = d6;
        connectStart = d7;
        connectEnd = d8;
        requestStart = d9;
        responseStart = d10;
        responseEnd = d11;
        domLoading = d12;
        domInteractive = d13;
        domContentLoadedEventStart = d14;
        domContentLoadedEventEnd = d15;
        domComplete = d16;
        loadEventStart = d17;
        loadEventEnd = d18;
    }

    public AmazonWebTimings clone()
        throws CloneNotSupportedException
    {
        return (AmazonWebTimings)super.clone();
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public double getConnectEnd()
    {
        return connectEnd;
    }

    public double getConnectStart()
    {
        return connectStart;
    }

    public double getDomComplete()
    {
        return domComplete;
    }

    public double getDomContentLoadedEventEnd()
    {
        return domContentLoadedEventEnd;
    }

    public double getDomContentLoadedEventStart()
    {
        return domContentLoadedEventStart;
    }

    public double getDomInteractive()
    {
        return domInteractive;
    }

    public double getDomLoading()
    {
        return domLoading;
    }

    public double getDomainLookupEnd()
    {
        return domainLookupEnd;
    }

    public double getDomainLookupStart()
    {
        return domainLookupStart;
    }

    public double getFetchStart()
    {
        return fetchStart;
    }

    public double getLoadEventEnd()
    {
        return loadEventEnd;
    }

    public double getLoadEventStart()
    {
        return loadEventStart;
    }

    public double getNavigationStart()
    {
        return navigationStart;
    }

    public int getRedirectCount()
    {
        return redirectCount;
    }

    public double getRedirectEnd()
    {
        return redirectEnd;
    }

    public double getRedirectStart()
    {
        return redirectStart;
    }

    public double getRequestStart()
    {
        return requestStart;
    }

    public double getResponseEnd()
    {
        return responseEnd;
    }

    public double getResponseStart()
    {
        return responseStart;
    }

    public double getUnloadEventEnd()
    {
        return unloadEventEnd;
    }
}
