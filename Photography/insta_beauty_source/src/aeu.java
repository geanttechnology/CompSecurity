// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditCropActivity;

public class aeu
    implements Runnable
{

    final ProEditCropActivity a;

    public aeu(ProEditCropActivity proeditcropactivity)
    {
        a = proeditcropactivity;
        super();
    }

    public void run()
    {
        ProEditCropActivity.a(a, uv.c().i());
        if (ProEditCropActivity.a(a) == null)
        {
            a.runOnUiThread(new aev(this));
            return;
        } else
        {
            a.runOnUiThread(new aew(this));
            return;
        }
    }
}
