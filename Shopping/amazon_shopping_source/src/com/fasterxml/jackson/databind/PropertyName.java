// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;


public class PropertyName
{

    public static final PropertyName NO_NAME = new PropertyName(new String("#disabled"), null);
    public static final PropertyName USE_DEFAULT = new PropertyName("", null);
    protected final String _namespace;
    protected final String _simpleName;

    public PropertyName(String s)
    {
        this(s, null);
    }

    public PropertyName(String s, String s1)
    {
        String s2 = s;
        if (s == null)
        {
            s2 = "";
        }
        _simpleName = s2;
        _namespace = s1;
    }

    public boolean equals(Object obj)
    {
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag4 = true;
        flag2 = true;
        flag3 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag3;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag3;
        if (obj.getClass() != com/fasterxml/jackson/databind/PropertyName) goto _L4; else goto _L5
_L5:
        if (USE_DEFAULT == obj)
        {
            if (this == USE_DEFAULT)
            {
                flag = flag2;
            } else
            {
                flag = false;
            }
            return flag;
        }
        if (_simpleName != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        flag = flag3;
        if (_simpleName != null) goto _L4; else goto _L6
_L6:
        if (_namespace == null)
        {
            boolean flag1;
            if (_namespace == null)
            {
                flag1 = flag4;
            } else
            {
                flag1 = false;
            }
            return flag1;
        } else
        {
            return _namespace.equals(_namespace);
        }
        if (!_simpleName.equals(_simpleName))
        {
            return false;
        }
          goto _L6
    }

    public String getSimpleName()
    {
        return _simpleName;
    }

    public boolean hasSimpleName()
    {
        return _simpleName.length() > 0;
    }

    public int hashCode()
    {
        if (_namespace == null)
        {
            return _simpleName.hashCode();
        } else
        {
            return _namespace.hashCode() ^ _simpleName.hashCode();
        }
    }

    public String toString()
    {
        if (_namespace == null)
        {
            return _simpleName;
        } else
        {
            return (new StringBuilder()).append("{").append(_namespace).append("}").append(_simpleName).toString();
        }
    }

}
