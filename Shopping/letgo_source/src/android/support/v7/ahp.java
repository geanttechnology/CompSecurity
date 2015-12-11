// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package android.support.v7:
//            aho

public class ahp
{

    protected final String a;
    protected final Object b[];

    public transient ahp(String s, Object aobj[])
    {
        a = s;
        if (aobj == null || aobj.length == 0)
        {
            b = aobj;
            return;
        }
        s = new ArrayList(aobj.length);
        int j = aobj.length;
        int i = 0;
        while (i < j) 
        {
            Object obj = aobj[i];
            if (obj != null && (!(obj instanceof String) || !aho.b((String)obj)))
            {
                s.add(obj);
            }
            i++;
        }
        b = s.toArray();
    }

    public String toString()
    {
        return (new StringBuilder()).append("NanigansEventParameter{name='").append(a).append('\'').append(", value=").append(Arrays.toString(b)).append('}').toString();
    }
}
