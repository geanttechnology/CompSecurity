// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.FragmentActivity;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.newui.MOneKeyFragment;

public class vy
    implements Runnable
{

    final MOneKeyFragment a;

    public vy(MOneKeyFragment monekeyfragment)
    {
        a = monekeyfragment;
        super();
    }

    public void run()
    {
        if (a.getActivity() == null)
        {
            return;
        }
        try
        {
            if (MOneKeyFragment.f(a) == null || MOneKeyFragment.f(a).c())
            {
                MOneKeyFragment.j(a).b(a.getActivity().getAssets(), MOneKeyFragment.d(a));
                MOneKeyFragment.m(a);
                if (a.getActivity() != null)
                {
                    a.getActivity().runOnUiThread(new vz(this));
                    return;
                }
            }
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
        }
        return;
    }
}
