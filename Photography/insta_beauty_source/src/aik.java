// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;

class aik
    implements Runnable
{

    final aij a;

    aik(aij aij1)
    {
        a = aij1;
        super();
    }

    public void run()
    {
        a.a.setResult(-1);
        a.a.i.dismiss();
        a.a.finish();
        a.a.overridePendingTransition(0, 0x7f04001e);
    }
}
