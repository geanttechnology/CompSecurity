// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.types;

import com.cyberlink.youcammakeup.utility.BeautyMode;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.types:
//            CategoryType

class 
{

    static final int a[];

    static 
    {
        a = new int[BeautyMode.values().length];
        try
        {
            a[BeautyMode.n.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[BeautyMode.l.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[BeautyMode.m.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[BeautyMode.x.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[BeautyMode.z.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[BeautyMode.A.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[BeautyMode.B.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[BeautyMode.C.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
