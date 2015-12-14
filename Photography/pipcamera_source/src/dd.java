// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class dd
    implements Runnable
{

    final db a;

    private dd(db db1)
    {
        a = db1;
        super();
    }

    dd(db db1, android.support.v7.widget.ListPopupWindow._cls1 _pcls1)
    {
        this(db1);
    }

    public void run()
    {
        db.b(a);
    }
}
