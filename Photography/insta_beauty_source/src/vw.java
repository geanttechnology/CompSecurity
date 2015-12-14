// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.FragmentActivity;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.newui.MOneKeyFragment;

public class vw
    implements Runnable
{

    final MOneKeyFragment a;

    public vw(MOneKeyFragment monekeyfragment)
    {
        a = monekeyfragment;
        super();
    }

    public void run()
    {
        try
        {
            MOneKeyFragment.i(a);
            if (a.getActivity() == null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
        catch (Error error)
        {
            return;
        }
        a.getActivity().runOnUiThread(new vx(this));
        return;
    }
}
