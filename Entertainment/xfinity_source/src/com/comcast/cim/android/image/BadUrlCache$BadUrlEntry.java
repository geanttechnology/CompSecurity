// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.image;


// Referenced classes of package com.comcast.cim.android.image:
//            BadUrlCache

private class expirationTime
{

    long expirationTime;
    final BadUrlCache this$0;
    final String url;

    (String s, long l)
    {
        this$0 = BadUrlCache.this;
        super();
        url = s;
        expirationTime = l;
    }
}
