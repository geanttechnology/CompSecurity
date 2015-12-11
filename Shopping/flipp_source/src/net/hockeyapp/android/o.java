// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.content.DialogInterface;

// Referenced classes of package net.hockeyapp.android:
//            FeedbackActivity

final class o
    implements android.content.DialogInterface.OnClickListener
{

    final FeedbackActivity a;

    o(FeedbackActivity feedbackactivity)
    {
        a = feedbackactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        FeedbackActivity.a(a, null);
        dialoginterface.cancel();
    }
}
