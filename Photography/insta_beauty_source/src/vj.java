// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.FragmentActivity;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.newui.MNewSofterFragment;

public class vj
    implements Runnable
{

    final MNewSofterFragment a;

    public vj(MNewSofterFragment mnewsofterfragment)
    {
        a = mnewsofterfragment;
        super();
    }

    public void run()
    {
        try
        {
            MNewSofterFragment.l(a);
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
        a.getActivity().runOnUiThread(new vk(this));
        return;
    }
}
