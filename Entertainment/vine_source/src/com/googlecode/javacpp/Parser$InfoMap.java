// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

// Referenced classes of package com.googlecode.javacpp:
//            Parser

public static class parent extends HashMap
{

    static final sort defaults = (new <init>(null)).put((new it>(new String[] {
        "void"
    })).mitiveTypes(new String[] {
        "void"
    }).nterTypes(new String[] {
        "Pointer"
    })).put((new it>(new String[] {
        "FILE"
    })).nterTypes(new String[] {
        "Pointer"
    }).t(true)).put((new it>(new String[] {
        "va_list"
    })).nterTypes(new String[] {
        "Pointer"
    }).t(true)).put((new it>(new String[] {
        "int8_t", "jbyte", "signed char"
    })).mitiveTypes(new String[] {
        "byte"
    }).nterTypes(new String[] {
        "BytePointer", "ByteBuffer", "byte[]"
    })).put((new it>(new String[] {
        "uint8_t", "char", "unsigned char"
    })).mitiveTypes(new String[] {
        "byte"
    }).nterTypes(new String[] {
        "BytePointer", "ByteBuffer", "byte[]"
    }).t(true)).put((new it>(new String[] {
        "int16_t", "jshort", "short", "signed short", "short int", "signed short int"
    })).mitiveTypes(new String[] {
        "short"
    }).nterTypes(new String[] {
        "ShortPointer", "ShortBuffer", "short[]"
    })).put((new it>(new String[] {
        "uint16_t", "unsigned short", "unsigned short int"
    })).mitiveTypes(new String[] {
        "short"
    }).nterTypes(new String[] {
        "ShortPointer", "ShortBuffer", "short[]"
    }).t(true)).put((new it>(new String[] {
        "int32_t", "jint", "int", "signed int", "signed"
    })).mitiveTypes(new String[] {
        "int"
    }).nterTypes(new String[] {
        "IntPointer", "IntBuffer", "int[]"
    })).put((new it>(new String[] {
        "uint32_t", "unsigned int", "unsigned"
    })).mitiveTypes(new String[] {
        "int"
    }).nterTypes(new String[] {
        "IntPointer", "IntBuffer", "int[]"
    }).t(true)).put((new it>(new String[] {
        "int64_t", "__int64", "jlong", "long long", "signed long long", "long long int", "signed long long int"
    })).mitiveTypes(new String[] {
        "long"
    }).nterTypes(new String[] {
        "LongPointer", "LongBuffer", "long[]"
    })).put((new it>(new String[] {
        "uint64_t", "__uint64", "unsigned long long", "unsigned long long int"
    })).mitiveTypes(new String[] {
        "long"
    }).nterTypes(new String[] {
        "LongPointer", "LongBuffer", "long[]"
    }).t(true)).put((new it>(new String[] {
        "long", "signed long", "long int", "signed long int"
    })).mitiveTypes(new String[] {
        "long"
    }).nterTypes(new String[] {
        "CLongPointer"
    })).put((new it>(new String[] {
        "unsigned long", "unsigned long int"
    })).mitiveTypes(new String[] {
        "long"
    }).nterTypes(new String[] {
        "CLongPointer"
    }).t(true)).put((new it>(new String[] {
        "size_t"
    })).mitiveTypes(new String[] {
        "long"
    }).nterTypes(new String[] {
        "SizeTPointer"
    })).put((new it>(new String[] {
        "float", "jfloat"
    })).mitiveTypes(new String[] {
        "float"
    }).nterTypes(new String[] {
        "FloatPointer", "FloatBuffer", "float[]"
    })).put((new it>(new String[] {
        "double", "jdouble"
    })).mitiveTypes(new String[] {
        "double"
    }).nterTypes(new String[] {
        "DoublePointer", "DoubleBuffer", "double[]"
    })).put((new it>(new String[] {
        "bool", "jboolean"
    })).mitiveTypes(new String[] {
        "boolean"
    }).nterTypes(new String[] {
        "BoolPointer"
    }).t(true)).put((new it>(new String[] {
        "const char"
    })).mitiveTypes(new String[] {
        "byte"
    }).nterTypes(new String[] {
        "@Cast(\"const char*\") BytePointer", "String"
    })).put((new it>(new String[] {
        "position"
    })).aNames(new String[] {
        "_position"
    })).put((new it>(new String[] {
        "limit"
    })).aNames(new String[] {
        "_limit"
    })).put((new it>(new String[] {
        "capacity"
    })).aNames(new String[] {
        "_capacity"
    }));
    aNames parent;

    static String sort(String s)
    {
        return sort(s, false);
    }

    static String sort(String s, boolean flag)
    {
        if (s == null)
        {
            return null;
        }
        Object obj = new TreeSet();
        try
        {
            s = new r(new StringReader(s));
            do
            {
                sort sort1 = s.nextToken();
                if (sort1.Empty())
                {
                    break;
                }
                ((TreeSet) (obj)).add(sort1.lue);
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        boolean flag1 = false;
        s = "";
        for (obj = ((TreeSet) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            String s1 = (String)((Iterator) (obj)).next();
            if ("const".equals(s1))
            {
                flag1 = true;
            } else
            {
                s = (new StringBuilder()).append(s).append(s1).append(" ").toString();
            }
        }

        if (!flag && flag1)
        {
            return (new StringBuilder()).append("const ").append(s.trim()).toString();
        } else
        {
            return s.trim();
        }
    }

    public LinkedList get(String s)
    {
        LinkedList linkedlist1 = (LinkedList)super.get(sort(s, false));
        LinkedList linkedlist = linkedlist1;
        if (linkedlist1 == null)
        {
            linkedlist = (LinkedList)super.get(sort(s, true));
        }
        linkedlist1 = linkedlist;
        if (linkedlist == null)
        {
            linkedlist1 = linkedlist;
            if (parent != null)
            {
                linkedlist1 = parent.get(s);
            }
        }
        s = linkedlist1;
        if (linkedlist1 == null)
        {
            s = new LinkedList();
        }
        return s;
    }

    public get put(get get1)
    {
        String as[];
        int j;
        if (get1.Names != null)
        {
            as = get1.Names;
        } else
        {
            as = new String[1];
            as[0] = null;
        }
        j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = sort(as[i], false);
            LinkedList linkedlist1 = (LinkedList)super.get(s);
            LinkedList linkedlist = linkedlist1;
            if (linkedlist1 == null)
            {
                linkedlist = new LinkedList();
            }
            if (!linkedlist.contains(get1))
            {
                linkedlist.add(get1);
            }
            super.put(s, linkedlist);
        }

        return this;
    }


    public r()
    {
        parent = null;
        parent = defaults;
    }

    public defaults(defaults defaults1)
    {
        parent = null;
        parent = defaults1;
    }
}
