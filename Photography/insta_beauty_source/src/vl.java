// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.FragmentActivity;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.newui.MNewSofterFragment;

public class vl
    implements Runnable
{

    final MNewSofterFragment a;

    public vl(MNewSofterFragment mnewsofterfragment)
    {
        a = mnewsofterfragment;
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
            MNewSofterFragment.n(a).b(a.getActivity().getAssets(), MNewSofterFragment.d(a));
            MNewSofterFragment.o(a);
            if (a.getActivity() != null)
            {
                a.getActivity().runOnUiThread(new vm(this));
                return;
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
