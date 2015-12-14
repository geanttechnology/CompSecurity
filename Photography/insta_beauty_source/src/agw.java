// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;

class agw
    implements Runnable
{

    final agv a;

    agw(agv agv1)
    {
        a = agv1;
        super();
    }

    public void run()
    {
        if (ProEditFontActivity.b(a.a) == null)
        {
            a.a.finish();
            return;
        } else
        {
            ProEditFontActivity.c(a.a).setImageBitmap(ProEditFontActivity.b(a.a));
            ProEditFontActivity.d(a.a);
            ProEditFontActivity.e(a.a);
            ProEditFontActivity.f(a.a).setVisibility(8);
            return;
        }
    }
}
