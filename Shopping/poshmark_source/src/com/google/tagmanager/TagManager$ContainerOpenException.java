// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            TagManager

static class mContainerId extends RuntimeException
{

    private final String mContainerId;

    public String getContainerId()
    {
        return mContainerId;
    }

    private (String s)
    {
        super((new StringBuilder()).append("Container already open: ").append(s).toString());
        mContainerId = s;
    }
}
