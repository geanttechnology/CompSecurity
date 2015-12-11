// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;


// Referenced classes of package org.codehaus.jackson.map:
//            SerializerFactory, Serializers

public static abstract class 
{

    public abstract boolean hasKeySerializers();

    public abstract boolean hasSerializerModifiers();

    public abstract Iterable keySerializers();

    public abstract Iterable serializerModifiers();

    public abstract Iterable serializers();

    public abstract  withAdditionalKeySerializers(Serializers serializers1);

    public abstract  withAdditionalSerializers(Serializers serializers1);

    public ()
    {
    }
}
