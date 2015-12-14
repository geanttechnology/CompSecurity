// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class fb
    implements Runnable
{

    final ez a;

    private fb(ez ez1)
    {
        a = ez1;
        super();
    }

    fb(ez ez1, ev ev)
    {
        this(ez1);
    }

    public void run()
    {
        ez.b(a);
    }
}
