// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.controllers.GetContestsController;
import com.socialin.android.apiv3.model.Contest2;
import com.socialin.android.apiv3.model.ContestResponseItem;
import com.socialin.android.apiv3.request.ContestParams;
import com.socialin.android.picsart.profile.activity.ContestItemsActivity;
import com.socialin.android.util.Utils;
import java.util.ArrayList;
import myobfuscated.cr.f;
import myobfuscated.cr.h;

public final class n extends f
    implements a
{

    private GetContestsController c;
    private ContestParams d;
    private com.socialin.android.picsart.profile.adapter.n m;

    public n()
    {
        c = new GetContestsController();
        d = new ContestParams();
    }

    public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
    {
        if (itemcontrol.equals(ItemControl.OPEN_CONTEST) && getActivity() != null && !getActivity().isFinishing())
        {
            if ((itemcontrol = (Contest2)((ContestResponseItem)m.getItem(0)).contestItems.get(i)) != null)
            {
                aobj = new Intent();
                ((Intent) (aobj)).setClass(getActivity(), com/socialin/android/picsart/profile/activity/ContestItemsActivity);
                ((Intent) (aobj)).setFlags(0x10000000);
                ((Intent) (aobj)).putExtra("contestName", ((Contest2) (itemcontrol)).name);
                ((Intent) (aobj)).putExtra("contestDesc", ((Contest2) (itemcontrol)).description);
                ((Intent) (aobj)).putExtra("contestType", ((Contest2) (itemcontrol)).type);
                ((Intent) (aobj)).putExtra("contest.name.prefix", ((ContestResponseItem)m.getItem(0)).type);
                boolean flag;
                if (((Contest2) (itemcontrol)).type != 0 || ((Contest2) (itemcontrol)).tillSubmit == 0)
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                ((Intent) (aobj)).putExtra("isSubmitAvailable", flag);
                startActivity(((Intent) (aobj)));
                return;
            }
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int j = (int)Utils.a(4F, getActivity());
        bundle = "";
        if (getArguments() != null)
        {
            if (getArguments().containsKey("contestPrefix"))
            {
                bundle = getArguments().getString("contestPrefix");
            }
            d.type = bundle.toLowerCase();
        }
        c.setRequestParams(d);
        int i = getResources().getConfiguration().orientation;
        bundle = getActivity();
        if (i == 1)
        {
            i = 2;
        } else
        {
            i = 4;
        }
        m = new com.socialin.android.picsart.profile.adapter.n(bundle, i, j);
        m.setOnItemClickListener(this);
        bundle = (new h(getResources())).a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.GRID
        });
        bundle.j = j;
        bundle.h = true;
        bundle = bundle.a(4, 2);
        bundle.e = getResources().getColor(0x7f0f009b);
        a(bundle.b());
        b(m, myobfuscated.cr.a.a(c, m));
    }

    public final void onResume()
    {
        super.onResume();
        if (m != null && m.isEmpty())
        {
            a(false, true, true);
        }
    }
}
