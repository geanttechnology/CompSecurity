// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditCropActivity;

class afc
    implements Runnable
{

    final aez a;

    afc(aez aez1)
    {
        a = aez1;
        super();
    }

    public void run()
    {
        a.b.b();
        a.b.setResult(-1);
        a.b.finish();
        a.b.overridePendingTransition(0, 0x7f04001e);
    }
}
