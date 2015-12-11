// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import com.google.android.apps.youtube.kids.activities.ParentalControlActivity;

public final class xo
    implements xy
{

    private ParentalControlActivity a;

    public xo(ParentalControlActivity parentalcontrolactivity)
    {
        a = parentalcontrolactivity;
        super();
    }

    public final void a(boolean flag)
    {
        if (flag)
        {
            ParentalControlActivity.a(a).setVisibility(0);
            a.getFragmentManager().beginTransaction().setCustomAnimations(0, 0x7f060002).remove(ParentalControlActivity.b(a)).commit();
            ParentalControlActivity.a(a, null);
            return;
        } else
        {
            ParentalControlActivity.c(a);
            return;
        }
    }
}
