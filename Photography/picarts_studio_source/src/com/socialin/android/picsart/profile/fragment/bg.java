// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.Tag;
import com.socialin.android.apiv3.request.GetTagsParams;
import com.socialin.android.picsart.profile.activity.SearchActivity;
import com.socialin.android.picsart.profile.activity.TopTagsActivity;
import com.socialin.android.picsart.profile.activity.l;
import com.socialin.android.picsart.profile.adapter.an;
import com.socialin.android.picsart.profile.util.aa;
import myobfuscated.cr.a;
import myobfuscated.cr.f;
import myobfuscated.cr.h;
import myobfuscated.cv.c;
import myobfuscated.f.m;

public final class bg extends f
    implements l
{

    private GetTagsParams c;
    private an d;
    private a m;
    private boolean n;

    public bg()
    {
        n = false;
    }

    static an a(bg bg1)
    {
        return bg1.d;
    }

    static void a(bg bg1, Tag tag)
    {
        aa.a(bg1.getActivity(), tag);
        Intent intent = new Intent(bg1.getActivity(), com/socialin/android/picsart/profile/activity/TopTagsActivity);
        if (bg1.getActivity().getIntent().getExtras() != null)
        {
            myobfuscated.cv.c.a(intent, bg1.getActivity());
        }
        intent.putExtra("key.tag", tag.name);
        bg1.getActivity().startActivity(intent);
    }

    public final void a()
    {
        super.a();
        if (isVisible() && d.isEmpty())
        {
            a(myobfuscated.f.m.a(getActivity(), 0x7f08024a));
        }
    }

    public final void a(boolean flag)
    {
        n = flag;
    }

    public final boolean d()
    {
        return n;
    }

    public final void j_()
    {
        Activity activity = getActivity();
        if (activity != null && ((SearchActivity)activity).a != null)
        {
            c();
            c.tag = ((SearchActivity)getActivity()).a;
            a(false, true, true);
        }
    }

    public final void k_()
    {
        if (m != null)
        {
            m.a(aa.a(getActivity()));
            l_();
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Object obj = RequestControllerFactory.createSearchTagsController();
        c = (GetTagsParams)((BaseSocialinApiRequestController) (obj)).getRequestParams();
        d = new an(getActivity());
        d.setOnItemClickListener(new _cls1());
        bundle = d;
        obj = myobfuscated.cr.a.a(((BaseSocialinApiRequestController) (obj)), d);
        m = ((a) (obj));
        b(bundle, ((a) (obj)));
        if (d.getItemCount() == 0)
        {
            k_();
        }
        bundle = (new h(getResources())).a();
        bundle.k = false;
        a(bundle.b());
    }

    public final void onResume()
    {
        super.onResume();
        String s = ((SearchActivity)getActivity()).a;
        if (d != null && d.isEmpty() || c != null && !TextUtils.isEmpty(s) && !s.equals(c.tag))
        {
            j_();
        }
    }

    /* member class not found */
    class _cls1 {}

}
