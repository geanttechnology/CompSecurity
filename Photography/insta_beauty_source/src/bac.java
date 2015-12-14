// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import com.instamag.activity.compose.MagComposeActivity;

public class bac
    implements android.content.DialogInterface.OnCancelListener
{

    final MagComposeActivity a;

    public bac(MagComposeActivity magcomposeactivity)
    {
        a = magcomposeactivity;
        super();
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        MagComposeActivity.e(a);
        a.b();
    }
}
