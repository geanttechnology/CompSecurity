// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.ObjectArrayDeserializer;
import com.flurry.org.codehaus.jackson.map.type.ArrayType;

public class ArrayDeserializer extends ObjectArrayDeserializer
{

    public ArrayDeserializer(ArrayType arraytype, JsonDeserializer jsondeserializer)
    {
        this(arraytype, jsondeserializer, null);
    }

    public ArrayDeserializer(ArrayType arraytype, JsonDeserializer jsondeserializer, TypeDeserializer typedeserializer)
    {
        super(arraytype, jsondeserializer, typedeserializer);
    }
}
