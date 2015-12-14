// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage

private static final class type extends type
{

    private final Method getValueDescriptorMethod;
    private final Method valueOfMethod;

    public void addRepeated(type type, Object obj)
    {
        super.epeated(type, GeneratedMessage.access$1400(valueOfMethod, null, new Object[] {
            obj
        }));
    }

    public Object get(valueOfMethod valueofmethod)
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        for (valueofmethod = ((List)super.valueOfMethod(valueofmethod)).iterator(); valueofmethod.hasNext(); arraylist.add(GeneratedMessage.access$1400(getValueDescriptorMethod, obj, new Object[0])))
        {
            obj = valueofmethod.next();
        }

        return Collections.unmodifiableList(arraylist);
    }

    public Object get(GeneratedMessage generatedmessage)
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        for (generatedmessage = ((List)super.getValueDescriptorMethod(generatedmessage)).iterator(); generatedmessage.hasNext(); arraylist.add(GeneratedMessage.access$1400(getValueDescriptorMethod, obj, new Object[0])))
        {
            obj = generatedmessage.next();
        }

        return Collections.unmodifiableList(arraylist);
    }

    ( , String s, Class class1, Class class2)
    {
        super(, s, class1, class2);
        valueOfMethod = GeneratedMessage.access$1300(type, "valueOf", new Class[] {
            com/google/protobuf/Descriptors$EnumValueDescriptor
        });
        getValueDescriptorMethod = GeneratedMessage.access$1300(type, "getValueDescriptor", new Class[0]);
    }
}
