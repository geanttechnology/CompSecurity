// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateActivity, TemplateView

final class a
    implements android.widget.angeListener
{

    private TemplateActivity a;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (TemplateActivity.a(a) == 0)
        {
            TemplateActivity.b(a).setCornerRadius(i);
            ((TextView)a.findViewById(0x7f1002a6)).setText((new StringBuilder(" ")).append(i).append("%").toString());
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    (TemplateActivity templateactivity)
    {
        a = templateactivity;
        super();
    }
}
