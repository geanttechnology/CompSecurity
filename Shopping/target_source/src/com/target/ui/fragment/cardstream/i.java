// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import android.content.Context;
import com.google.a.a.e;
import com.target.a.a.a;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.ui.j.b.d;
import com.target.ui.service.k;

public class i
{

    private final com.target.ui.j.b.a mAbTestingExperimentOptions;
    private final Context mContext;
    private final k mRelevantStoreService;

    public i(k k1, com.target.ui.j.b.a a1, a a2)
    {
        mRelevantStoreService = k1;
        mAbTestingExperimentOptions = a1;
        mContext = a2.a();
    }

    private boolean b()
    {
        com.target.ui.util.b b1 = com.target.ui.util.i.d(mContext);
        if (b1 != com.target.ui.util.b.AlwaysShowCardStream)
        {
            e e1 = mRelevantStoreService.c();
            if (!e1.b())
            {
                return false;
            }
            if (!((RelevantStoreSummary)e1.c()).a())
            {
                return false;
            }
            if (b1 != com.target.ui.util.b.AlwaysShowCardStreamInStore)
            {
                boolean flag;
                if (mAbTestingExperimentOptions.h().a() == com.target.ui.j.b.d.a.EXPERIMENT_SHOW_CARD_STREAM)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return flag;
            }
        }
        return true;
    }

    public com.target.ui.fragment.shop.b.e a()
    {
        if (b())
        {
            return new com.target.ui.fragment.shop.b.a();
        } else
        {
            return new com.target.ui.fragment.shop.b.d();
        }
    }
}
