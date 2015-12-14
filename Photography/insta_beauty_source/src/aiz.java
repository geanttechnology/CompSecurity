// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.FrameLayout;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

public class aiz
    implements Runnable
{

    final ProEditSlimBodyActivity a;

    public aiz(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
        super();
    }

    public void run()
    {
        if (ProEditSlimBodyActivity.h(a) != null)
        {
            ProEditSlimBodyActivity.h(a).setVisibility(4);
            ProEditSlimBodyActivity.h(a).removeView(ProEditSlimBodyActivity.i(a));
            ProEditSlimBodyActivity.a(a, null);
        }
    }
}
