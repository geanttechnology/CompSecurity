// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Activity;
import android.content.Intent;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.adapter.a;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkSearch;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity

public class p extends a
{

    final SearchActivity a;
    private final String f;

    public p(SearchActivity searchactivity, Activity activity, CLMultiColumnListView clmulticolumnlistview, int i, String s, n n)
    {
        a = searchactivity;
        super(activity, clmulticolumnlistview, i, null, n);
        f = s;
    }

    protected d a(int i, int k)
    {
        d d1;
        try
        {
            d1 = (d)NetworkSearch.a(f, Integer.valueOf(i), Integer.valueOf(k), AccountManager.c()).d();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return d1;
    }

    protected void a(Post post)
    {
        if (post == null || h())
        {
            return;
        }
        if (SearchActivity.i(a))
        {
            d = d + 1L;
            Globals.b("ToDo: [BC Messages] Get the Post JSON from onAcrivityResult and implement Share Post");
            Intent intent = new Intent();
            intent.putExtra("Post", post.toString());
            a.setResult(-1, intent);
            a.finish();
            return;
        } else
        {
            super.a(post);
            return;
        }
    }

    protected volatile void a(Model model)
    {
        a((Post)model);
    }
}
