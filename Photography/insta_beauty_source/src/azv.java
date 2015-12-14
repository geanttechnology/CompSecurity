// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.compose.MagComposeActivity;

public class azv
    implements Runnable
{

    final int a;
    final View b;
    final MagComposeActivity c;

    public azv(MagComposeActivity magcomposeactivity, int i, View view)
    {
        c = magcomposeactivity;
        a = i;
        b = view;
        super();
    }

    public void run()
    {
        MagComposeActivity.a(c, a);
        MagComposeActivity.a(c, a, b);
    }
}
