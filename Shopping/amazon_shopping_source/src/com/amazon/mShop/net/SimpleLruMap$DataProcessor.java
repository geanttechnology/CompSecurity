// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            SimpleLruMap

public static interface 
{

    public abstract int evict(Object obj);

    public abstract int getSize(Object obj);

    public abstract void setAccessTime(Object obj, long l);
}
