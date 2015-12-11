// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class cqy
{

    public final Uri a;
    public final Map b;
    public final byte c[];
    private volatile int d;

    public cqy(Uri uri, Map map, byte abyte0[])
    {
        a = (Uri)b.a(uri);
        if (map == null)
        {
            uri = Collections.emptyMap();
        } else
        {
            uri = Collections.unmodifiableMap(map);
        }
        b = uri;
        c = abyte0;
    }

    public static byte[] a(cqy cqy1)
    {
        byte abyte0[] = null;
        if (cqy1.c != null)
        {
            int i = cqy1.c.length;
            abyte0 = new byte[i];
            System.arraycopy(cqy1.c, 0, abyte0, 0, i);
        }
        return abyte0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof cqy))
            {
                return false;
            }
            obj = (cqy)obj;
            if (!a.equals(((cqy) (obj)).a) || !b.equals(((cqy) (obj)).b) || !Arrays.equals(c, ((cqy) (obj)).c))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = d;
        int i = j;
        if (j == 0)
        {
            int k = a.hashCode();
            int l = b.hashCode();
            if (c == null)
            {
                i = 0;
            } else
            {
                i = Arrays.hashCode(c);
            }
            i += ((k + 527) * 31 + l) * 31;
            d = i;
        }
        return i;
    }

    public String toString()
    {
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        String s;
        if (c != null)
        {
            s = new String(c);
        } else
        {
            s = "null";
        }
        return (new StringBuilder(String.valueOf(s1).length() + 32 + String.valueOf(s2).length() + String.valueOf(s).length())).append("{uri='").append(s1).append("', headers='").append(s2).append("', content='").append(s).append("'}").toString();
    }
}
