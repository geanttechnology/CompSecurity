// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop.blending;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.photo.imgop.blending:
//            BlendingActivity, a

final class a
    implements android.widget.angeListener
{

    private BlendingActivity a;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        BlendingActivity.a(a, i + 1);
        ((TextView)a.findViewById(0x7f1001b9)).setText((new StringBuilder()).append(a.getString(0x7f080630)).append(": ").append(BlendingActivity.d(a)).toString());
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        a.b();
        a.a();
        BlendingActivity.a(a).a(false);
    }

    (BlendingActivity blendingactivity)
    {
        a = blendingactivity;
        super();
    }
}
