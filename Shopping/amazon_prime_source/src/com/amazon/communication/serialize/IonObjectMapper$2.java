// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.serialize;

import com.amazon.org.codehaus.jackson.type.TypeReference;
import java.lang.reflect.Type;

// Referenced classes of package com.amazon.communication.serialize:
//            IonObjectMapper

class nit> extends TypeReference
{

    final IonObjectMapper this$0;
    final amazon.communication.serialize.TypeReference val$valueTypeRef;

    public Type getType()
    {
        return val$valueTypeRef.getType();
    }

    ()
    {
        this$0 = final_ionobjectmapper;
        val$valueTypeRef = amazon.communication.serialize.TypeReference.this;
        super();
    }
}
