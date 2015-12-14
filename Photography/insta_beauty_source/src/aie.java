// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;

class aie
    implements Runnable
{

    final aic a;

    aie(aic aic1)
    {
        a = aic1;
        super();
    }

    public void run()
    {
        a.a.i.dismiss();
        ProEditNewStretchActivity.b(a.a);
    }
}
