// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;


// Referenced classes of package android.support.v4.app:
//            cq, au

final class ci
    implements cq
{

    private String a;
    private int b;
    private String c;
    private boolean d;

    public ci(String s, int i, String s1)
    {
        a = s;
        b = i;
        c = s1;
        d = false;
    }

    public final void a(au au1)
    {
        au1.a(a, b, c);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("CancelTask[");
        stringbuilder.append("packageName:").append(a);
        stringbuilder.append(", id:").append(b);
        stringbuilder.append(", tag:").append(c);
        stringbuilder.append(", all:false");
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
