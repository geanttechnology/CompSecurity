// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditAdjustActivity;

class aeo
    implements Runnable
{

    final aem a;

    aeo(aem aem1)
    {
        a = aem1;
        super();
    }

    public void run()
    {
        ProEditAdjustActivity.m(a.a);
        a.a.b();
    }
}
