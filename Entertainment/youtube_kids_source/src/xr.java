// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.google.android.apps.youtube.kids.activities.ParentalControlActivity;

public final class xr
    implements android.view.View.OnClickListener
{

    private ParentalControlActivity a;

    public xr(ParentalControlActivity parentalcontrolactivity)
    {
        a = parentalcontrolactivity;
        super();
    }

    public final void onClick(View view)
    {
        ParentalControlActivity.a(a, false);
        ParentalControlActivity.a(a, ParentalControlActivity.e(a));
        a.getFragmentManager().beginTransaction().setCustomAnimations(0x7f060000, 0x7f060001).replace(0x7f100164, ParentalControlActivity.b(a)).commit();
        ParentalControlActivity.f(a).setVisibility(8);
        ParentalControlActivity.g(a).setVisibility(0);
        ParentalControlActivity.g(a).setAnimation(AnimationUtils.loadAnimation(a, 0x7f050011));
    }
}
