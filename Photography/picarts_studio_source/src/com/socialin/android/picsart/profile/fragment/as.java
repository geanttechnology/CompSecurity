// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.socialin.android.apiv3.controllers.GetContestItemsController;
import com.socialin.android.apiv3.model.ContestItem;
import com.socialin.android.apiv3.request.ContestParams;
import com.socialin.android.picsart.profile.activity.ContestItemsActivity;
import com.socialin.android.picsart.profile.adapter.bf;
import com.socialin.android.picsart.profile.adapter.p;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cr.a;
import myobfuscated.cr.f;
import myobfuscated.cr.h;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            p

public final class as extends f
{

    p c;
    String d;
    int m;
    boolean n;
    private GetContestItemsController o;
    private com.socialin.android.picsart.profile.fragment.p p;

    public as()
    {
        o = new GetContestItemsController();
        m = 1;
        n = true;
    }

    public as(com.socialin.android.picsart.profile.fragment.p p1)
    {
        o = new GetContestItemsController();
        m = 1;
        n = true;
        p = p1;
    }

    public final void a()
    {
        super.a();
        if (p != null || !(getActivity() instanceof ContestItemsActivity)) goto _L2; else goto _L1
_L1:
        com.socialin.android.picsart.profile.fragment.p p1;
        ContestItemsActivity contestitemsactivity;
        int i;
        contestitemsactivity = (ContestItemsActivity)getActivity();
        p1 = new com.socialin.android.picsart.profile.fragment.p();
        i = 0;
_L8:
        if (i >= contestitemsactivity.a.getCount()) goto _L4; else goto _L3
_L3:
        if (!(contestitemsactivity.a.a(i) instanceof com.socialin.android.picsart.profile.fragment.p)) goto _L6; else goto _L5
_L5:
        p1 = (com.socialin.android.picsart.profile.fragment.p)contestitemsactivity.a.a(i);
_L4:
        p = p1;
_L2:
        p.e = 0;
        Iterator iterator = c.getItems().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ContestItem contestitem = (ContestItem)iterator.next();
            if (contestitem.status != null && !contestitem.status.equals("rejected"))
            {
                com.socialin.android.picsart.profile.fragment.p p3 = p;
                p3.e = p3.e + 1;
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        com.socialin.android.picsart.profile.fragment.p p2 = p;
        Activity activity = p2.getActivity();
        if (activity == null || activity.isFinishing() || p2.getView() == null)
        {
            return;
        } else
        {
            p2.b(false);
            return;
        }
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a(true, false);
    }

    public final void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        intent = getActivity();
        break MISSING_BLOCK_LABEL_12;
        if (intent != null && !intent.isFinishing() && j == 4540)
        {
            switch (i)
            {
            default:
                return;

            case 12: // '\f'
                break;
            }
            if (a_ != null && a_.getAdapter() != null)
            {
                a(true, false);
                return;
            }
        }
        return;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getActivity().getIntent();
        if (bundle != null && bundle.hasExtra("contestName"))
        {
            d = bundle.getStringExtra("contestName");
            ((ContestParams)o.getRequestParams()).contestName = d;
        }
        bundle = new h(getResources());
        bundle.c = 2;
        bundle.a = 1;
        bundle.h = false;
        a(bundle.a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.STAGGERED
        }).b());
        ((ContestParams)o.getRequestParams()).order = "submissions";
        if (getActivity().getIntent().hasExtra("contestName"))
        {
            ((ContestParams)o.getRequestParams()).contestName = d;
        }
        c = new p(getActivity());
        c.setOnItemClickListener(new _cls1());
        b(c, myobfuscated.cr.a.a(o, c));
    }

    public final void onResume()
    {
        super.onResume();
    }

    /* member class not found */
    class _cls1 {}

}
