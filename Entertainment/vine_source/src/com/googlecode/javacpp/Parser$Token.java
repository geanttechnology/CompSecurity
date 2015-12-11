// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.File;

// Referenced classes of package com.googlecode.javacpp:
//            Parser

static class value
    implements Cloneable
{

    static final type CLASS = new <init>(5, "class");
    static final int COMMENT = 4;
    static final <init> CONST = new <init>(5, "const");
    static final <init> DEFINE = new <init>(5, "define");
    static final <init> ELIF = new <init>(5, "elif");
    static final <init> ELSE = new <init>(5, "else");
    static final <init> ENDIF = new <init>(5, "endif");
    static final <init> ENUM = new <init>(5, "enum");
    static final <init> EOF = new <init>();
    static final <init> EXTERN = new <init>(5, "extern");
    static final int FLOAT = 2;
    static final int IDENTIFIER = 5;
    static final <init> IF = new <init>(5, "if");
    static final <init> IFDEF = new <init>(5, "ifdef");
    static final <init> IFNDEF = new <init>(5, "ifndef");
    static final <init> INLINE = new <init>(5, "inline");
    static final int INTEGER = 1;
    static final <init> STATIC = new <init>(5, "static");
    static final int STRING = 3;
    static final <init> STRUCT = new <init>(5, "struct");
    static final <init> TEMPLATE = new <init>(5, "template");
    static final <init> TYPEDEF = new <init>(5, "typedef");
    static final <init> TYPENAME = new <init>(5, "typename");
    static final <init> UNION = new <init>(5, "union");
    File file;
    int lineNumber;
    String spacing;
    int type;
    String value;

    public value clone()
    {
        value value1 = new <init>();
        value1.file = file;
        value1.lineNumber = lineNumber;
        value1.type = type;
        value1.spacing = spacing;
        value1.value = value;
        return value1;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (obj.getClass() != java/lang/Integer)
        {
            break; /* Loop/switch isn't completed */
        }
        if (type != ((Integer)obj).intValue())
        {
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (obj.getClass() != java/lang/Character)
        {
            break; /* Loop/switch isn't completed */
        }
        if (type != ((Character)obj).charValue())
        {
            return false;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (obj.getClass() == java/lang/String)
        {
            return obj.equals(value);
        }
        if (obj.getClass() == getClass())
        {
            obj = (value)obj;
            if (type != ((type) (obj)).type || (value != null || ((value) (obj)).value != null) && (value == null || !value.equals(((value) (obj)).value)))
            {
                return false;
            }
        } else
        {
            return false;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    transient value expect(Object aobj[])
        throws ion
    {
        if (!match(aobj))
        {
            throw new ion((new StringBuilder()).append(file).append(":").append(lineNumber).append(": Unexpected token '").append(toString()).append("'").toString());
        } else
        {
            return this;
        }
    }

    public int hashCode()
    {
        return type;
    }

    boolean isEmpty()
    {
        return type == -1 && spacing.isEmpty();
    }

    transient boolean match(Object aobj[])
    {
        boolean flag = false;
        int j = aobj.length;
        int i = 0;
        while (i < j) 
        {
            Object obj = aobj[i];
            if (flag || equals(obj))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i++;
        }
        return flag;
    }

    public String toString()
    {
        if (value != null && value.length() > 0)
        {
            return value;
        } else
        {
            return String.valueOf((char)type);
        }
    }


    ion()
    {
        file = null;
        lineNumber = 0;
        type = -1;
        spacing = "";
        value = "";
    }

    value(int i, String s)
    {
        file = null;
        lineNumber = 0;
        type = -1;
        spacing = "";
        value = "";
        type = i;
        value = s;
    }
}
