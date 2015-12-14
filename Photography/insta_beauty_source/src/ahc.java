// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;
import com.fotoable.fotoproedit.activity.font.FontLabelCursorView;

public class ahc
    implements Runnable
{

    final ProEditFontActivity a;

    public ahc(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }

    public void run()
    {
        if (ProEditFontActivity.z(a).getVisibility() == 4)
        {
            ProEditFontActivity.z(a).setVisibility(0);
        } else
        {
            ProEditFontActivity.z(a).setVisibility(4);
        }
        if (ProEditFontActivity.A(a))
        {
            a.f.postDelayed(this, 1000L);
            return;
        } else
        {
            ProEditFontActivity.z(a).setVisibility(4);
            return;
        }
    }
}
