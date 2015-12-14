// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotoproedit.activity.ProEditAdjustActivity;

public class aem
    implements Runnable
{

    final ProEditAdjustActivity a;

    public aem(ProEditAdjustActivity proeditadjustactivity)
    {
        a = proeditadjustactivity;
        super();
    }

    public void run()
    {
        ProEditAdjustActivity.a(a, uv.c().i());
        if (ProEditAdjustActivity.l(a) == null || ProEditAdjustActivity.l(a).isRecycled())
        {
            a.runOnUiThread(new aen(this));
            return;
        } else
        {
            a.runOnUiThread(new aeo(this));
            return;
        }
    }
}
