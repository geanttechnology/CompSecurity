// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import nativead.WebBrowerActivity;

class cel
    implements Runnable
{

    final cek a;

    cel(cek cek1)
    {
        a = cek1;
        super();
    }

    public void run()
    {
        WebBrowerActivity.e(a.f.b);
    }
}
