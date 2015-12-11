// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;


// Referenced classes of package com.groupon:
//            Channel

static final class it> extends Channel
{

    public String extendedDatabaseChannel(String s)
    {
        return encodePath(new String[] {
            name(), s
        });
    }

    public boolean isNavigableTo()
    {
        return false;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
