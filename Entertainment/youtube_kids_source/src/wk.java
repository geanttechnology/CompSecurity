// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.CheckBox;
import com.google.android.apps.youtube.kids.activities.DebugOnlineAdActivity;

public final class wk
    implements android.view.View.OnClickListener
{

    private DebugOnlineAdActivity a;

    public wk(DebugOnlineAdActivity debugonlineadactivity)
    {
        a = debugonlineadactivity;
        super();
    }

    public final void onClick(View view)
    {
        DebugOnlineAdActivity.b(a).a("debugAdEnable", DebugOnlineAdActivity.a(a).isChecked());
        DebugOnlineAdActivity.c(a);
        if (DebugOnlineAdActivity.a(a).isChecked() && !DebugOnlineAdActivity.d(a))
        {
            bmd.a(a, "Restart Pegasus for changes to take effect", 1);
        }
    }
}
