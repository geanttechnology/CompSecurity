// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.cache;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.cache:
//            Data

public interface ICache
{

    public abstract Data get(Object obj);

    public abstract void put(Object obj, Object obj1, int i);
}
