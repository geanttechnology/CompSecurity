// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;


// Referenced classes of package com.cyberlink.youcammakeup.database.more:
//            DatabaseOpenHelper

class coverType
{

    static final int a[];

    static 
    {
        a = new int[coverType.values().length];
        try
        {
            a[coverType.b.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[coverType.a.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
