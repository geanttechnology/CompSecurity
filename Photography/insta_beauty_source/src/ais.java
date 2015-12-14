// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

public class ais
    implements Runnable
{

    final ProEditSlimBodyActivity a;

    public ais(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
        super();
    }

    public void run()
    {
        ProEditSlimBodyActivity.b(a, ProEditSlimBodyActivity.b(a).copy(android.graphics.Bitmap.Config.ARGB_8888, true));
        ProEditSlimBodyActivity.E(a);
        if (ProEditSlimBodyActivity.B(a) == null)
        {
            ProEditSlimBodyActivity.a(a, new ig());
            ProEditSlimBodyActivity.B(a).a(a.getAssets(), ProEditSlimBodyActivity.d(a));
        }
        if (ProEditSlimBodyActivity.B(a).a() > 0)
        {
            ProEditSlimBodyActivity.B(a).a(0);
        }
        boolean flag = a.getSharedPreferences("setting", 0).getBoolean("isfastphone", false);
        ProEditSlimBodyActivity.B(a).a(flag);
        ProEditSlimBodyActivity.F(a);
        a.runOnUiThread(new ait(this));
    }
}
