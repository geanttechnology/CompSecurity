// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cbb
    implements crb
{

    final crb a;
    private final int b;

    public cbb(crb crb1, int i)
    {
        a = (crb)b.a(crb1);
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag, "pageSize must be greater than zero");
        b = i;
    }

    public final void a(Object obj, bhv bhv)
    {
        obj = (bzi)obj;
        android.net.Uri uri = cba.a(((bzi) (obj)).a, 1, b);
        a.a(((bzi) (obj)).b(uri), new cbc(this, ((bzi) (obj)), bhv));
    }
}
