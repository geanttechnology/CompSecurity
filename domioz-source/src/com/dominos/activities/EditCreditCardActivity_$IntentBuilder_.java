// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dominos.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import org.androidannotations.api.a.a;

// Referenced classes of package com.dominos.activities:
//            EditCreditCardActivity_

public class fragmentSupport_ extends a
{

    private android.support.v4.app.Fragment fragmentSupport_;
    private Fragment fragment_;

    public void startForResult(int i)
    {
        if (fragmentSupport_ != null)
        {
            fragmentSupport_.startActivityForResult(intent, i);
            return;
        }
        if (fragment_ != null)
        {
            if (android.os.entBuilder_.fragment_ >= 16)
            {
                fragment_.startActivityForResult(intent, i, lastOptions);
                return;
            } else
            {
                fragment_.startActivityForResult(intent, i);
                return;
            }
        }
        if (context instanceof Activity)
        {
            android.support.v4.app.a.a((Activity)context, intent, i, lastOptions);
            return;
        }
        if (android.os.entBuilder_.lastOptions >= 16)
        {
            context.startActivity(intent, lastOptions);
            return;
        } else
        {
            context.startActivity(intent);
            return;
        }
    }

    public (Fragment fragment)
    {
        super(fragment.getActivity(), com/dominos/activities/EditCreditCardActivity_);
        fragment_ = fragment;
    }

    public fragment_(Context context)
    {
        super(context, com/dominos/activities/EditCreditCardActivity_);
    }

    public fragment_(android.support.v4.app.Fragment fragment)
    {
        super(fragment.getActivity(), com/dominos/activities/EditCreditCardActivity_);
        fragmentSupport_ = fragment;
    }
}
