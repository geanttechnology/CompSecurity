// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.Serializers;

// Referenced classes of package com.fasterxml.jackson.databind:
//            AbstractTypeResolver

public abstract class Module
{
    public static interface SetupContext
    {

        public abstract void addAbstractTypeResolver(AbstractTypeResolver abstracttyperesolver);

        public abstract void addDeserializers(Deserializers deserializers);

        public abstract void addKeyDeserializers(KeyDeserializers keydeserializers);

        public abstract void addKeySerializers(Serializers serializers);

        public abstract void addSerializers(Serializers serializers);

        public abstract void addValueInstantiators(ValueInstantiators valueinstantiators);

        public transient abstract void registerSubtypes(NamedType anamedtype[]);

        public abstract void setMixInAnnotations(Class class1, Class class2);
    }


    public Module()
    {
    }

    public abstract String getModuleName();

    public abstract void setupModule(SetupContext setupcontext);

    public abstract Version version();
}
