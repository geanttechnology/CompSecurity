// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;


// Referenced classes of package org.simpleframework.xml.d:
//            ag, w

final class j
    implements ag
{

    j()
    {
    }

    public final Object a(String s)
    {
        if (s.length() != 1)
        {
            throw new w("Cannot convert '%s' to a character", new Object[] {
                s
            });
        } else
        {
            return Character.valueOf(s.charAt(0));
        }
    }

    public final String a(Object obj)
    {
        return ((Character)obj).toString();
    }
}
