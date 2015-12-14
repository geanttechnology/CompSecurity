// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

public class aip
    implements Runnable
{

    final ProEditSlimBodyActivity a;

    public aip(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
        super();
    }

    public void run()
    {
        try
        {
            if (ProEditSlimBodyActivity.B(a) != null)
            {
                ProEditSlimBodyActivity.C(a);
            }
            a.runOnUiThread(new aiq(this));
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
    }
}
