// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;


// Referenced classes of package netswipe:
//            dt

public abstract class dr
    implements dt
{

    private final String a;
    private final String b;
    private final String c;

    public dr(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        a = s;
        int i = s.indexOf('/');
        if (i != -1)
        {
            b = s.substring(0, i);
            c = s.substring(i + 1);
            return;
        } else
        {
            b = s;
            c = null;
            return;
        }
    }

    public String a()
    {
        return a;
    }
}
