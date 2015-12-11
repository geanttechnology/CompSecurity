// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;


// Referenced classes of package com.flurry.org.apache.avro.generic:
//            IndexedRecord

public interface GenericRecord
    extends IndexedRecord
{

    public abstract Object get(String s);

    public abstract void put(String s, Object obj);
}
