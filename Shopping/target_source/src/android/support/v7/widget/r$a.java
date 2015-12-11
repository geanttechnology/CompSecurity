// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;


// Referenced classes of package android.support.v7.widget:
//            r

private static class clerView.t
{

    public clerView.t a;
    public clerView.t b;
    public int c;
    public int d;
    public int e;
    public int f;

    public String toString()
    {
        return (new StringBuilder()).append("ChangeInfo{oldHolder=").append(a).append(", newHolder=").append(b).append(", fromX=").append(c).append(", fromY=").append(d).append(", toX=").append(e).append(", toY=").append(f).append('}').toString();
    }

    private clerView.t(clerView.t t, clerView.t t1)
    {
        a = t;
        b = t1;
    }

    private clerView.t(clerView.t t, clerView.t t1, int i, int j, int k, int l)
    {
        this(t, t1);
        c = i;
        d = j;
        e = k;
        f = l;
    }

    clerView.t(clerView.t t, clerView.t t1, int i, int j, int k, int l, clerView.t t2)
    {
        this(t, t1, i, j, k, l);
    }
}
