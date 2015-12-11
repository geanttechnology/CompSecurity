// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;

// Referenced classes of package com.fasterxml.jackson.databind.util:
//            LRUMap

public class RootNameLookup
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    protected transient LRUMap _rootNames;

    public RootNameLookup()
    {
    }

    public SerializedString findRootName(JavaType javatype, MapperConfig mapperconfig)
    {
        return findRootName(javatype.getRawClass(), mapperconfig);
    }

    public SerializedString findRootName(Class class1, MapperConfig mapperconfig)
    {
        ClassKey classkey = new ClassKey(class1);
        this;
        JVM INSTR monitorenter ;
        if (_rootNames != null) goto _L2; else goto _L1
_L1:
        _rootNames = new LRUMap(20, 200);
_L4:
        this;
        JVM INSTR monitorexit ;
        Object obj = mapperconfig.introspectClassAnnotations(class1);
        mapperconfig = mapperconfig.getAnnotationIntrospector().findRootName(((BeanDescription) (obj)).getClassInfo());
        if (mapperconfig == null || !mapperconfig.hasSimpleName())
        {
            class1 = class1.getSimpleName();
        } else
        {
            class1 = mapperconfig.getSimpleName();
        }
        class1 = new SerializedString(class1);
        this;
        JVM INSTR monitorenter ;
        _rootNames.put(classkey, class1);
        this;
        JVM INSTR monitorexit ;
        return class1;
_L2:
        obj = (SerializedString)_rootNames.get(classkey);
        if (obj == null) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return ((SerializedString) (obj));
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
    }
}
