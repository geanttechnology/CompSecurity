// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.CheckBox;
import com.google.android.apps.youtube.kids.activities.DebugOnlineAdActivity;

public final class wl
    implements android.view.View.OnClickListener
{

    private DebugOnlineAdActivity a;

    public wl(DebugOnlineAdActivity debugonlineadactivity)
    {
        a = debugonlineadactivity;
        super();
    }

    public final void onClick(View view)
    {
        DebugOnlineAdActivity.b(a).a("debugAdEnableFreqCap", DebugOnlineAdActivity.e(a).isChecked());
        DebugOnlineAdActivity.c(a);
    }
}
