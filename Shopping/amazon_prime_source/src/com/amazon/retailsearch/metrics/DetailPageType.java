// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;


public final class DetailPageType extends Enum
{

    private static final DetailPageType $VALUES[];
    public static final DetailPageType FORCED_PRIME;
    public static final DetailPageType MAIN;
    public static final DetailPageType NEWER_EDITION;
    public static final DetailPageType PRIME_OPTION;
    public static final DetailPageType TWISTER;
    public static final DetailPageType VIEW_OPTIONS;

    private DetailPageType(String s, int i)
    {
        super(s, i);
    }

    public static DetailPageType valueOf(String s)
    {
        return (DetailPageType)Enum.valueOf(com/amazon/retailsearch/metrics/DetailPageType, s);
    }

    public static DetailPageType[] values()
    {
        return (DetailPageType[])$VALUES.clone();
    }

    static 
    {
        MAIN = new DetailPageType("MAIN", 0);
        NEWER_EDITION = new DetailPageType("NEWER_EDITION", 1);
        TWISTER = new DetailPageType("TWISTER", 2);
        FORCED_PRIME = new DetailPageType("FORCED_PRIME", 3);
        PRIME_OPTION = new DetailPageType("PRIME_OPTION", 4);
        VIEW_OPTIONS = new DetailPageType("VIEW_OPTIONS", 5);
        $VALUES = (new DetailPageType[] {
            MAIN, NEWER_EDITION, TWISTER, FORCED_PRIME, PRIME_OPTION, VIEW_OPTIONS
        });
    }
}
