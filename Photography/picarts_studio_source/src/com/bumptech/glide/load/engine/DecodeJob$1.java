// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;


// Referenced classes of package com.bumptech.glide.load.engine:
//            DecodeJob

final class nReason
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[age.values().length];
        try
        {
            b[age.RESOURCE_CACHE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            b[age.DATA_CACHE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            b[age.SOURCE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            b[age.FINISHED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            b[age.INITIALIZE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        a = new int[nReason.values().length];
        try
        {
            a[nReason.INITIALIZE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[nReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[nReason.DECODE_DATA.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
