// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;


// Referenced classes of package android.support.v7.widget:
//            n

private static final class clerView.u
{

    public clerView.u a;
    public clerView.u b;
    public int c;
    public int d;
    public int e;
    public int f;

    public final String toString()
    {
        return (new StringBuilder("ChangeInfo{oldHolder=")).append(a).append(", newHolder=").append(b).append(", fromX=").append(c).append(", fromY=").append(d).append(", toX=").append(e).append(", toY=").append(f).append('}').toString();
    }

    private clerView.u(clerView.u u, clerView.u u1)
    {
        a = u;
        b = u1;
    }

    private clerView.u(clerView.u u, clerView.u u1, int i, int j, int k, int l)
    {
        this(u, u1);
        c = i;
        d = j;
        e = k;
        f = l;
    }

    clerView.u(clerView.u u, clerView.u u1, int i, int j, int k, int l, byte byte0)
    {
        this(u, u1, i, j, k, l);
    }
}
