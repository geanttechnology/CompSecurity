// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.type.ResolvedType;
import java.io.Serializable;
import java.lang.reflect.Modifier;

public abstract class JavaType extends ResolvedType
    implements Serializable
{

    private static final long serialVersionUID = 0xb624d2a6a39cb5eaL;
    protected final Class _class;
    protected final int _hashCode;
    protected final Object _typeHandler;
    protected final Object _valueHandler;

    protected JavaType(Class class1, int i, Object obj, Object obj1)
    {
        _class = class1;
        _hashCode = class1.getName().hashCode() + i;
        _valueHandler = obj;
        _typeHandler = obj1;
    }

    protected void _assertSubclass(Class class1, Class class2)
    {
        if (!_class.isAssignableFrom(class1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Class ").append(class1.getName()).append(" is not assignable to ").append(_class.getName()).toString());
        } else
        {
            return;
        }
    }

    protected abstract JavaType _narrow(Class class1);

    protected JavaType _widen(Class class1)
    {
        return _narrow(class1);
    }

    public volatile ResolvedType containedType(int i)
    {
        return containedType(i);
    }

    public JavaType containedType(int i)
    {
        return null;
    }

    public int containedTypeCount()
    {
        return 0;
    }

    public String containedTypeName(int i)
    {
        return null;
    }

    public abstract boolean equals(Object obj);

    public JavaType forcedNarrowBy(Class class1)
    {
        if (class1 == _class)
        {
            return this;
        }
        Object obj = _narrow(class1);
        class1 = ((Class) (obj));
        if (_valueHandler != ((JavaType) (obj)).getValueHandler())
        {
            class1 = ((JavaType) (obj)).withValueHandler(_valueHandler);
        }
        obj = class1;
        if (_typeHandler != class1.getTypeHandler())
        {
            obj = class1.withTypeHandler(_typeHandler);
        }
        return ((JavaType) (obj));
    }

    public volatile ResolvedType getContentType()
    {
        return getContentType();
    }

    public JavaType getContentType()
    {
        return null;
    }

    public String getErasedSignature()
    {
        StringBuilder stringbuilder = new StringBuilder(40);
        getErasedSignature(stringbuilder);
        return stringbuilder.toString();
    }

    public abstract StringBuilder getErasedSignature(StringBuilder stringbuilder);

    public String getGenericSignature()
    {
        StringBuilder stringbuilder = new StringBuilder(40);
        getGenericSignature(stringbuilder);
        return stringbuilder.toString();
    }

    public abstract StringBuilder getGenericSignature(StringBuilder stringbuilder);

    public volatile ResolvedType getKeyType()
    {
        return getKeyType();
    }

    public JavaType getKeyType()
    {
        return null;
    }

    public final Class getRawClass()
    {
        return _class;
    }

    public Object getTypeHandler()
    {
        return _typeHandler;
    }

    public Object getValueHandler()
    {
        return _valueHandler;
    }

    public boolean hasGenericTypes()
    {
        return containedTypeCount() > 0;
    }

    public final boolean hasRawClass(Class class1)
    {
        return _class == class1;
    }

    public final int hashCode()
    {
        return _hashCode;
    }

    public boolean isAbstract()
    {
        return Modifier.isAbstract(_class.getModifiers());
    }

    public boolean isArrayType()
    {
        return false;
    }

    public boolean isCollectionLikeType()
    {
        return false;
    }

    public boolean isConcrete()
    {
        while ((_class.getModifiers() & 0x600) == 0 || _class.isPrimitive()) 
        {
            return true;
        }
        return false;
    }

    public abstract boolean isContainerType();

    public final boolean isEnumType()
    {
        return _class.isEnum();
    }

    public final boolean isFinal()
    {
        return Modifier.isFinal(_class.getModifiers());
    }

    public final boolean isInterface()
    {
        return _class.isInterface();
    }

    public boolean isMapLikeType()
    {
        return false;
    }

    public final boolean isPrimitive()
    {
        return _class.isPrimitive();
    }

    public boolean isThrowable()
    {
        return java/lang/Throwable.isAssignableFrom(_class);
    }

    public JavaType narrowBy(Class class1)
    {
        if (class1 == _class)
        {
            return this;
        }
        _assertSubclass(class1, _class);
        Object obj = _narrow(class1);
        class1 = ((Class) (obj));
        if (_valueHandler != ((JavaType) (obj)).getValueHandler())
        {
            class1 = ((JavaType) (obj)).withValueHandler(_valueHandler);
        }
        obj = class1;
        if (_typeHandler != class1.getTypeHandler())
        {
            obj = class1.withTypeHandler(_typeHandler);
        }
        return ((JavaType) (obj));
    }

    public abstract JavaType narrowContentsBy(Class class1);

    public abstract String toString();

    public JavaType widenBy(Class class1)
    {
        if (class1 == _class)
        {
            return this;
        } else
        {
            _assertSubclass(_class, class1);
            return _widen(class1);
        }
    }

    public abstract JavaType widenContentsBy(Class class1);

    public abstract JavaType withContentTypeHandler(Object obj);

    public abstract JavaType withContentValueHandler(Object obj);

    public abstract JavaType withTypeHandler(Object obj);

    public abstract JavaType withValueHandler(Object obj);
}
