// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io.protocol;

import com.google.userfeedback.android.api.common.util.IntMap;

// Referenced classes of package com.google.userfeedback.android.api.common.io.protocol:
//            ProtoBuf

public class ProtoBufType
{

    public static final int MASK_MODIFIER = 65280;
    public static final int MASK_TYPE = 255;
    public static final int NEXT_TYPE_VALUE = 37;
    private static final TypeInfo NULL_DATA_TYPEINFOS[];
    public static final int OPTIONAL = 512;
    public static final int REPEATED = 1024;
    public static final int REQUIRED = 256;
    public static final int START_TYPE_VALUE = 16;
    public static final int TYPES_BIT_RANGE = 8;
    public static final int TYPES_VALUE_RANGE = 21;
    public static final int TYPE_BOOL = 24;
    public static final int TYPE_BYTES = 35;
    public static final int TYPE_DATA = 25;
    public static final int TYPE_DOUBLE = 17;
    public static final int TYPE_ENUM = 30;
    public static final int TYPE_FIXED32 = 23;
    public static final int TYPE_FIXED64 = 22;
    public static final int TYPE_FLOAT = 18;
    public static final int TYPE_GROUP = 26;
    public static final int TYPE_INT32 = 21;
    public static final int TYPE_INT64 = 19;
    public static final int TYPE_MESSAGE = 27;
    public static final int TYPE_SFIXED32 = 31;
    public static final int TYPE_SFIXED64 = 32;
    public static final int TYPE_SINT32 = 33;
    public static final int TYPE_SINT64 = 34;
    public static final int TYPE_STRING = 36;
    public static final int TYPE_TEXT = 28;
    public static final int TYPE_UINT32 = 29;
    public static final int TYPE_UINT64 = 20;
    public static final int TYPE_UNDEFINED = 16;
    private final String typeName;
    private final IntMap types;

    public ProtoBufType()
    {
        types = new IntMap();
        typeName = null;
    }

    public ProtoBufType(String s)
    {
        types = new IntMap();
        typeName = s;
    }

    private static TypeInfo getCacheTypeInfoForNullData(int i)
    {
        return NULL_DATA_TYPEINFOS[(i >> 8 & 0xff) * 21 + ((i & 0xff) - 16)];
    }

    public ProtoBufType addElement(int i, int j, Object obj)
    {
        IntMap intmap = types;
        if (obj == null)
        {
            obj = getCacheTypeInfoForNullData(i);
        } else
        {
            obj = new TypeInfo(i, obj);
        }
        intmap.put(j, obj);
        return this;
    }

    public boolean equals(Object obj)
    {
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (getClass() == obj.getClass())
            {
                obj = (ProtoBufType)obj;
                return types.equals(((ProtoBufType) (obj)).types);
            }
        }
        return false;
    }

    public Object getData(int i)
    {
        TypeInfo typeinfo = (TypeInfo)types.get(i);
        if (typeinfo == null)
        {
            return typeinfo;
        } else
        {
            return typeinfo.data;
        }
    }

    public int getModifiers(int i)
    {
        TypeInfo typeinfo = (TypeInfo)types.get(i);
        if (typeinfo == null)
        {
            return 1536;
        } else
        {
            return typeinfo.type & 0xff00;
        }
    }

    public int getType(int i)
    {
        TypeInfo typeinfo = (TypeInfo)types.get(i);
        if (typeinfo == null)
        {
            return 16;
        } else
        {
            return typeinfo.type & 0xff;
        }
    }

    public int hashCode()
    {
        if (types != null)
        {
            return types.hashCode();
        } else
        {
            return super.hashCode();
        }
    }

    public boolean isValidProto(ProtoBuf protobuf)
    {
        com.google.userfeedback.android.api.common.util.IntMap.KeyIterator keyiterator = types.keys();
        do
        {
            if (!keyiterator.hasNext())
            {
                break;
            }
            int k = keyiterator.next();
            int i = getModifiers(k);
            if ((i & 0x100) != 0 && !protobuf.has(k))
            {
                return false;
            }
            int l = protobuf.getCount(k);
            if ((i & 0x400) == 0 && l > 1)
            {
                return false;
            }
            if (getType(k) == 27 && (getData(k) instanceof ProtoBufType))
            {
                ProtoBufType protobuftype = (ProtoBufType)getData(k);
                int j = 0;
                while (j < l) 
                {
                    if (!protobuftype.isValidProto(protobuf.getProtoBuf(k, j)))
                    {
                        return false;
                    }
                    j++;
                }
            }
        } while (true);
        return true;
    }

    IntMap newIntMapForProtoBuf()
    {
        return types.newIntMapWithSameBufferSize();
    }

    public String toString()
    {
        String s = String.valueOf(typeName);
        if (s.length() != 0)
        {
            return "ProtoBufType Name: ".concat(s);
        } else
        {
            return new String("ProtoBufType Name: ");
        }
    }

    static 
    {
        NULL_DATA_TYPEINFOS = new TypeInfo[168];
        int i = 0;
        int j = 0;
        for (; i <= 7; i++)
        {
            for (int k = 16; k < 37;)
            {
                NULL_DATA_TYPEINFOS[j] = new TypeInfo((i << 8) + k, null);
                k++;
                j++;
            }

        }

    }

    private class TypeInfo
    {

        private Object data;
        private int type;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || !(obj instanceof TypeInfo))
                {
                    return false;
                }
                obj = (TypeInfo)obj;
                if (type != ((TypeInfo) (obj)).type || data != ((TypeInfo) (obj)).data && (data == null || !data.equals(((TypeInfo) (obj)).data)))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return type;
        }

        public String toString()
        {
            int i = type;
            String s = String.valueOf(data);
            return (new StringBuilder(String.valueOf(s).length() + 33)).append("TypeInfo{type=").append(i).append(", data=").append(s).append("}").toString();
        }



        TypeInfo(int i, Object obj)
        {
            type = i;
            data = obj;
        }
    }

}
