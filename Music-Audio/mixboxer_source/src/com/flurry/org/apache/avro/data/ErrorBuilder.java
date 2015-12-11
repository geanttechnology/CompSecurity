// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.data;


// Referenced classes of package com.flurry.org.apache.avro.data:
//            RecordBuilder

public interface ErrorBuilder
    extends RecordBuilder
{

    public abstract ErrorBuilder clearCause();

    public abstract ErrorBuilder clearValue();

    public abstract Throwable getCause();

    public abstract Object getValue();

    public abstract boolean hasCause();

    public abstract boolean hasValue();

    public abstract ErrorBuilder setCause(Throwable throwable);

    public abstract ErrorBuilder setValue(Object obj);
}
