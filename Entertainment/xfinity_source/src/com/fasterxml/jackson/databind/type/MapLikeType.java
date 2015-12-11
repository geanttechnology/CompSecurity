// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.databind.JavaType;
import java.util.Map;

// Referenced classes of package com.fasterxml.jackson.databind.type:
//            TypeBase

public class MapLikeType extends TypeBase
{

    private static final long serialVersionUID = 0xbe7cec9d27d72c67L;
    protected final JavaType _keyType;
    protected final JavaType _valueType;

    protected MapLikeType(Class class1, JavaType javatype, JavaType javatype1, Object obj, Object obj1)
    {
        super(class1, javatype.hashCode() ^ javatype1.hashCode(), obj, obj1);
        _keyType = javatype;
        _valueType = javatype1;
    }

    public static MapLikeType construct(Class class1, JavaType javatype, JavaType javatype1)
    {
        return new MapLikeType(class1, javatype, javatype1, null, null);
    }

    protected JavaType _narrow(Class class1)
    {
        return new MapLikeType(class1, _keyType, _valueType, _valueHandler, _typeHandler);
    }

    protected String buildCanonicalName()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(_class.getName());
        if (_keyType != null)
        {
            stringbuilder.append('<');
            stringbuilder.append(_keyType.toCanonical());
            stringbuilder.append(',');
            stringbuilder.append(_valueType.toCanonical());
            stringbuilder.append('>');
        }
        return stringbuilder.toString();
    }

    public volatile ResolvedType containedType(int i)
    {
        return containedType(i);
    }

    public JavaType containedType(int i)
    {
        if (i == 0)
        {
            return _keyType;
        }
        if (i == 1)
        {
            return _valueType;
        } else
        {
            return null;
        }
    }

    public int containedTypeCount()
    {
        return 2;
    }

    public String containedTypeName(int i)
    {
        if (i == 0)
        {
            return "K";
        }
        if (i == 1)
        {
            return "V";
        } else
        {
            return null;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null)
            {
                return false;
            }
            if (obj.getClass() != getClass())
            {
                return false;
            }
            obj = (MapLikeType)obj;
            if (_class != ((MapLikeType) (obj))._class || !_keyType.equals(((MapLikeType) (obj))._keyType) || !_valueType.equals(((MapLikeType) (obj))._valueType))
            {
                return false;
            }
        }
        return true;
    }

    public volatile ResolvedType getContentType()
    {
        return getContentType();
    }

    public JavaType getContentType()
    {
        return _valueType;
    }

    public StringBuilder getErasedSignature(StringBuilder stringbuilder)
    {
        return _classSignature(_class, stringbuilder, true);
    }

    public StringBuilder getGenericSignature(StringBuilder stringbuilder)
    {
        _classSignature(_class, stringbuilder, false);
        stringbuilder.append('<');
        _keyType.getGenericSignature(stringbuilder);
        _valueType.getGenericSignature(stringbuilder);
        stringbuilder.append(">;");
        return stringbuilder;
    }

    public volatile ResolvedType getKeyType()
    {
        return getKeyType();
    }

    public JavaType getKeyType()
    {
        return _keyType;
    }

    public boolean isContainerType()
    {
        return true;
    }

    public boolean isMapLikeType()
    {
        return true;
    }

    public boolean isTrueMapType()
    {
        return java/util/Map.isAssignableFrom(_class);
    }

    public JavaType narrowContentsBy(Class class1)
    {
        if (class1 == _valueType.getRawClass())
        {
            return this;
        } else
        {
            return new MapLikeType(_class, _keyType, _valueType.narrowBy(class1), _valueHandler, _typeHandler);
        }
    }

    public JavaType narrowKey(Class class1)
    {
        if (class1 == _keyType.getRawClass())
        {
            return this;
        } else
        {
            return new MapLikeType(_class, _keyType.narrowBy(class1), _valueType, _valueHandler, _typeHandler);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("[map-like type; class ").append(_class.getName()).append(", ").append(_keyType).append(" -> ").append(_valueType).append("]").toString();
    }

    public JavaType widenContentsBy(Class class1)
    {
        if (class1 == _valueType.getRawClass())
        {
            return this;
        } else
        {
            return new MapLikeType(_class, _keyType, _valueType.widenBy(class1), _valueHandler, _typeHandler);
        }
    }

    public JavaType widenKey(Class class1)
    {
        if (class1 == _keyType.getRawClass())
        {
            return this;
        } else
        {
            return new MapLikeType(_class, _keyType.widenBy(class1), _valueType, _valueHandler, _typeHandler);
        }
    }

    public volatile JavaType withContentTypeHandler(Object obj)
    {
        return withContentTypeHandler(obj);
    }

    public MapLikeType withContentTypeHandler(Object obj)
    {
        return new MapLikeType(_class, _keyType, _valueType.withTypeHandler(obj), _valueHandler, _typeHandler);
    }

    public volatile JavaType withContentValueHandler(Object obj)
    {
        return withContentValueHandler(obj);
    }

    public MapLikeType withContentValueHandler(Object obj)
    {
        return new MapLikeType(_class, _keyType, _valueType.withValueHandler(obj), _valueHandler, _typeHandler);
    }

    public MapLikeType withKeyTypeHandler(Object obj)
    {
        return new MapLikeType(_class, _keyType.withTypeHandler(obj), _valueType, _valueHandler, _typeHandler);
    }

    public MapLikeType withKeyValueHandler(Object obj)
    {
        return new MapLikeType(_class, _keyType.withValueHandler(obj), _valueType, _valueHandler, _typeHandler);
    }

    public volatile JavaType withTypeHandler(Object obj)
    {
        return withTypeHandler(obj);
    }

    public MapLikeType withTypeHandler(Object obj)
    {
        return new MapLikeType(_class, _keyType, _valueType, _valueHandler, obj);
    }

    public volatile JavaType withValueHandler(Object obj)
    {
        return withValueHandler(obj);
    }

    public MapLikeType withValueHandler(Object obj)
    {
        return new MapLikeType(_class, _keyType, _valueType, obj, _typeHandler);
    }
}
