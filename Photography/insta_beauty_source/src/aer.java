// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotoproedit.activity.ProEditAdjustActivity;

public class aer
    implements Runnable
{

    final Bitmap a;
    final ProEditAdjustActivity b;

    public aer(ProEditAdjustActivity proeditadjustactivity, Bitmap bitmap)
    {
        b = proeditadjustactivity;
        a = bitmap;
        super();
    }

    public void run()
    {
        b.b();
        if (a == null || a.isRecycled() || a == ProEditAdjustActivity.l(b) && !ProEditAdjustActivity.o(b))
        {
            b.finish();
            b.overridePendingTransition(0, 0x7f04001e);
        } else
        if (a != null && !a.isRecycled())
        {
            apq.a("adjust");
            b.a();
            uv.c().a(a, new aes(this));
            return;
        }
    }
}
