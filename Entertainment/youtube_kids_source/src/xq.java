// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.google.android.apps.youtube.kids.activities.ParentalControlActivity;

public final class xq
    implements android.view.View.OnClickListener
{

    private ParentalControlActivity a;

    public xq(ParentalControlActivity parentalcontrolactivity)
    {
        a = parentalcontrolactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.g.b(0x7f08001b);
        ParentalControlActivity.c(a);
    }
}
