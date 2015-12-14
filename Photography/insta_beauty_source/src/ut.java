// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.fotoable.beautyui.newui.MOneKeyFragment;
import java.util.Iterator;
import java.util.List;

class ut
    implements Runnable
{

    final us a;

    ut(us us1)
    {
        a = us1;
        super();
    }

    public void run()
    {
        MNewFotoBeautyActivity.s(a.a);
        Object obj = a.a.getSupportFragmentManager().getFragments();
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Fragment fragment = (Fragment)((Iterator) (obj)).next();
                if (fragment instanceof MOneKeyFragment)
                {
                    ((MOneKeyFragment)fragment).a();
                }
            } while (true);
        }
    }
}
