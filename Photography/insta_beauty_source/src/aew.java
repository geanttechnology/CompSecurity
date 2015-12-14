// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditCropActivity;

class aew
    implements Runnable
{

    final aeu a;

    aew(aeu aeu1)
    {
        a = aeu1;
        super();
    }

    public void run()
    {
        a.a.b();
        ProEditCropActivity.b(a.a);
    }
}
