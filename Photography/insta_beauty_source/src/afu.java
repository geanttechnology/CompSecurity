// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

class afu
    implements Runnable
{

    final afs a;

    afu(afs afs1)
    {
        a = afs1;
        super();
    }

    public void run()
    {
        a.a.a.c();
        ProEditFilterActivity.d(a.a.a);
    }
}
