// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cgf
{

    public final String a;
    public final cgb b;
    private cgh c;
    private String d;
    private String e;
    private String f;

    public cgf(cgh cgh1, String s, String s1, String s2, cgb cgb1, String s3)
    {
        c = (cgh)b.a(cgh1);
        a = (String)b.a(s);
        d = s1;
        e = (String)b.a(s2);
        b = (cgb)b.a(cgb1);
        f = (String)b.a(s3);
    }

    public final boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof cgf))
        {
            return false;
        } else
        {
            obj = (cgf)obj;
            return a.equals(((cgf) (obj)).a);
        }
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final String toString()
    {
        String s = String.valueOf(c);
        String s1 = a;
        String s2 = d;
        String s3 = e;
        String s4 = String.valueOf(b);
        String s5 = f;
        return (new StringBuilder(String.valueOf(s).length() + 60 + String.valueOf(s1).length() + String.valueOf(s2).length() + String.valueOf(s3).length() + String.valueOf(s4).length() + String.valueOf(s5).length())).append("Device [type=").append(s).append(", id=").append(s1).append(", application=").append(s2).append(", name=").append(s3).append(", clientName=").append(s4).append(", user=").append(s5).append("]").toString();
    }
}
