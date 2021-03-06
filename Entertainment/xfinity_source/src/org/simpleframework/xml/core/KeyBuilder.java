// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Arrays;

// Referenced classes of package org.simpleframework.xml.core:
//            Label

class KeyBuilder
{
    private static class Key
    {

        private final KeyType type;
        private final String value;

        public boolean equals(Object obj)
        {
            if (obj instanceof Key)
            {
                return equals((Key)obj);
            } else
            {
                return false;
            }
        }

        public boolean equals(Key key)
        {
            if (type == key.type)
            {
                return key.value.equals(value);
            } else
            {
                return false;
            }
        }

        public int hashCode()
        {
            return value.hashCode();
        }

        public String toString()
        {
            return value;
        }

        public Key(KeyType keytype, String s)
            throws Exception
        {
            value = s;
            type = keytype;
        }
    }

    private static final class KeyType extends Enum
    {

        private static final KeyType $VALUES[];
        public static final KeyType ATTRIBUTE;
        public static final KeyType ELEMENT;
        public static final KeyType TEXT;

        public static KeyType valueOf(String s)
        {
            return (KeyType)Enum.valueOf(org/simpleframework/xml/core/KeyBuilder$KeyType, s);
        }

        public static final KeyType[] values()
        {
            return (KeyType[])$VALUES.clone();
        }

        static 
        {
            TEXT = new KeyType("TEXT", 0);
            ATTRIBUTE = new KeyType("ATTRIBUTE", 1);
            ELEMENT = new KeyType("ELEMENT", 2);
            $VALUES = (new KeyType[] {
                TEXT, ATTRIBUTE, ELEMENT
            });
        }

        private KeyType(String s, int i)
        {
            super(s, i);
        }
    }


    private final Label label;

    public KeyBuilder(Label label1)
    {
        label = label1;
    }

    private Object getKey(KeyType keytype)
        throws Exception
    {
        String s = getKey(label.getPaths());
        if (keytype == null)
        {
            return s;
        } else
        {
            return new Key(keytype, s);
        }
    }

    private String getKey(String as[])
        throws Exception
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (as.length > 0)
        {
            Arrays.sort(as);
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append(as[i]);
                stringbuilder.append('>');
            }

        }
        return stringbuilder.toString();
    }

    public Object getKey()
        throws Exception
    {
        if (label.isAttribute())
        {
            return getKey(KeyType.ATTRIBUTE);
        } else
        {
            return getKey(KeyType.ELEMENT);
        }
    }
}
