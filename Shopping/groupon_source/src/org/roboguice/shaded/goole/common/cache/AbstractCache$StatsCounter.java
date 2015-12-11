// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;


// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            AbstractCache

public static interface 
{

    public abstract void recordEviction();

    public abstract void recordHits(int i);

    public abstract void recordLoadException(long l);

    public abstract void recordLoadSuccess(long l);

    public abstract void recordMisses(int i);
}
