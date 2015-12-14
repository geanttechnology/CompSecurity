// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bumptech.glide.b;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.util.Utils;
import com.socialin.android.picsart.profile.adapter.y;
import myobfuscated.cr.a;
import myobfuscated.cr.f;
import myobfuscated.cr.h;

public final class ak extends f
{

    private y c;
    private com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle d[];
    private int m;
    private int n;

    public ak()
    {
    }

    public static ak a(Context context, BaseSocialinApiRequestController basesocialinapirequestcontroller)
    {
        context = new y(context);
        a a1 = myobfuscated.cr.a.a(basesocialinapirequestcontroller, context);
        ak ak1 = new ak();
        ak1.c = context;
        ak1.n = 0;
        ak1.m = basesocialinapirequestcontroller.getCode();
        ak1.b(context, a1);
        ak1.d = (new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.STAGGERED
        });
        context.setOnItemClickListener(new _cls1(ak1, context));
        return ak1;
    }

    public final void a(com.socialin.android.adapter.a a1)
    {
        c.setOnItemClickListener(a1);
    }

    public final void g()
    {
        c.a = true;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            if (bundle.containsKey("viewStylesCount"))
            {
                int k = bundle.getInt("viewStylesCount");
                d = new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[k];
                for (int i = 0; i < k; i++)
                {
                    d[i] = (com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle)bundle.getSerializable((new StringBuilder("viewStyle")).append(i).toString());
                }

            }
            if (bundle.containsKey("topPadding"))
            {
                n = bundle.getInt("topPadding");
            }
            int j = bundle.getInt("request_controller_code", 0);
            bundle = new y(getActivity());
            b(bundle, myobfuscated.cr.a.a(Utils.getImageItemRequestControllerByCode(j), bundle));
        }
        bundle = new h(getResources());
        bundle.f = n;
        bundle.i = n;
        a(bundle.a(d).b());
    }

    public final void onLowMemory()
    {
        super.onLowMemory();
        if (getActivity() != null)
        {
            b.a(getActivity().getApplicationContext()).onLowMemory();
        }
    }

    public final void onResume()
    {
        super.onResume();
        if (c != null && c.isEmpty())
        {
            a(false, true, true);
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("topPadding", n);
        bundle.putInt("viewStylesCount", d.length);
        for (int i = 0; i < d.length; i++)
        {
            bundle.putSerializable((new StringBuilder("viewStyle")).append(i).toString(), d[i]);
        }

        bundle.putInt("request_controller_code", m);
    }

    /* member class not found */
    class _cls1 {}

}
