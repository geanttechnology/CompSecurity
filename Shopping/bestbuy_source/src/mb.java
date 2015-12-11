// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.DialogInterface;

public final class mb
    implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnClickListener, Runnable
{

    private final Activity a;

    public mb(Activity activity)
    {
        a = activity;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        run();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        run();
    }

    public void run()
    {
        a.finish();
    }
}
