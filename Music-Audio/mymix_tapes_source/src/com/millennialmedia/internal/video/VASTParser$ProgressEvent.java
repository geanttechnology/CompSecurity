// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            VASTParser

public static class offset extends offset
{

    public String offset;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof offset))
            {
                return false;
            }
            if (!super.equals(obj))
            {
                return false;
            }
            obj = (equals)obj;
            if (!offset.equals(((offset) (obj)).offset))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return super.hashCode() * 31 + offset.hashCode();
    }

    (String s, String s1)
    {
        super(.progress, s);
        offset = s1;
    }
}
