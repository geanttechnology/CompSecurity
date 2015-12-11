// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.google.android.apps.youtube.kids.activities.DebugOnlineAdActivity;

public final class wp
    implements android.view.View.OnClickListener
{

    private DebugOnlineAdActivity a;

    public wp(DebugOnlineAdActivity debugonlineadactivity)
    {
        a = debugonlineadactivity;
        super();
    }

    public final void onClick(View view)
    {
        DebugOnlineAdActivity.i(a);
    }
}
