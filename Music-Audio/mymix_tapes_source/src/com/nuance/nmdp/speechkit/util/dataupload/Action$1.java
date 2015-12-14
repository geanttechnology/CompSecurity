// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.dataupload;


// Referenced classes of package com.nuance.nmdp.speechkit.util.dataupload:
//            Action

static final class tionType
{

    static final int a[];

    static 
    {
        a = new int[tionType.values().length];
        try
        {
            a[tionType.ADD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[tionType.REMOVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[tionType.CLEARALL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
