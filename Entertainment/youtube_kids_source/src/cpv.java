// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public final class cpv
    implements Serializable, Iterable
{

    public final int a;
    public final Uri b;
    public final List c;
    private int d;
    private int e;
    private Uri f;

    public cpv(int i, int j, int k, Uri uri, Uri uri1, List list)
    {
        a = i;
        d = j;
        e = k;
        f = uri;
        b = uri1;
        c = (List)b.a(list);
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        throw new InvalidObjectException("builder required");
    }

    private Object writeReplace()
    {
        cpw cpw1 = new cpw();
        cpw1.a = a;
        cpw1.b = d;
        cpw1.c = e;
        cpw1.d = f;
        cpw1.e = b;
        return cpw1.a(c);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof cpv)) goto _L4; else goto _L3
_L3:
        obj = (cpv)obj;
        flag = flag1;
        if (a != ((cpv) (obj)).a) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (d != ((cpv) (obj)).d) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (e != ((cpv) (obj)).e) goto _L4; else goto _L7
_L7:
        if (f != null) goto _L9; else goto _L8
_L8:
        flag = flag1;
        if (((cpv) (obj)).f != null) goto _L4; else goto _L10
_L10:
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        flag = flag1;
        if (((cpv) (obj)).b != null) goto _L4; else goto _L11
_L11:
        return c.equals(((cpv) (obj)).c);
_L9:
        if (!f.equals(((cpv) (obj)).f))
        {
            return false;
        }
          goto _L10
        if (!b.equals(((cpv) (obj)).b))
        {
            return false;
        }
          goto _L11
    }

    public final Iterator iterator()
    {
        return c.iterator();
    }

    public final String toString()
    {
        int i = a;
        int j = d;
        int k = e;
        String s = String.valueOf(f);
        String s1 = String.valueOf(b);
        String s2 = String.valueOf(c);
        return (new StringBuilder(String.valueOf(s).length() + 119 + String.valueOf(s1).length() + String.valueOf(s2).length())).append("{totalResults: ").append(i).append(", elementsPerPage: ").append(j).append(", startIndex: ").append(k).append(", previousUri: ").append(s).append(", nextUri: ").append(s1).append(", entries: ").append(s2).append("}").toString();
    }
}
