// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonCacheManager

public static interface I
{

    public abstract void onCompleted(I i, String as[], long l);

    public abstract void onError(String s);

    public abstract void onProgress(String s, int i, int j);
}
