// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

class age
    implements Runnable
{

    final agb a;

    age(agb agb1)
    {
        a = agb1;
        super();
    }

    public void run()
    {
        a.a.c();
        a.a.finish();
    }
}
