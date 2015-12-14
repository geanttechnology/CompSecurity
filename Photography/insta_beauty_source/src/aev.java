// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditCropActivity;

class aev
    implements Runnable
{

    final aeu a;

    aev(aeu aeu1)
    {
        a = aeu1;
        super();
    }

    public void run()
    {
        a.a.b();
        a.a.finish();
    }
}
