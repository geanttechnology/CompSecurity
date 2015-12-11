// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.safety;

import org.jsoup.helper.Validate;

// Referenced classes of package org.jsoup.safety:
//            Whitelist

static abstract class value
{

    private String value;

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (value)obj;
        if (value != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((value) (obj)).value == null) goto _L1; else goto _L3
_L3:
        return false;
        if (value.equals(((value) (obj)).value)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int i;
        if (value == null)
        {
            i = 0;
        } else
        {
            i = value.hashCode();
        }
        return i + 31;
    }

    public String toString()
    {
        return value;
    }

    (String s)
    {
        Validate.notNull(s);
        value = s;
    }
}
