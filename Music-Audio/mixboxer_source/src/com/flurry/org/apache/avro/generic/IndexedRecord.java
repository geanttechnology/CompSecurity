// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;


// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericContainer

public interface IndexedRecord
    extends GenericContainer
{

    public abstract Object get(int i);

    public abstract void put(int i, Object obj);
}
