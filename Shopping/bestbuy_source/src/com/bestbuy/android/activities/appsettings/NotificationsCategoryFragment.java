// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.appsettings;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.bestbuy.android.api.lib.models.browse.Category;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.exacttarget.etpushsdk.ETException;
import com.exacttarget.etpushsdk.ETPush;
import ef;
import ii;
import java.util.List;
import java.util.TreeSet;
import lq;
import nb;

public class NotificationsCategoryFragment extends BBYBaseFragment
{

    private ListView a;
    private ii b;
    private Activity c;
    private View g;
    private View h;
    private ef i;
    private List j;
    private boolean k;

    public NotificationsCategoryFragment()
    {
        k = true;
    }

    public NotificationsCategoryFragment(boolean flag)
    {
        k = true;
        k = flag;
    }

    public void a(List list)
    {
        j = list;
        a(g).setVisibility(8);
        if (list == null || list.isEmpty())
        {
            break MISSING_BLOCK_LABEL_147;
        }
        TreeSet treeset;
        Category category;
        treeset = ETPush.pushManager().getTags();
        category = (Category)list.get(0);
        if (treeset.contains(category.getCategoryId())) goto _L2; else goto _L1
_L1:
        boolean flag = k;
        if (!flag) goto _L2; else goto _L3
_L3:
        ETPush.pushManager().addTag(category.getCategoryId());
        lq.a(c, category.getCategoryId());
_L4:
        k = false;
_L2:
        i = new ef(c, 0, list);
        a.setChoiceMode(2);
        a.setAdapter(i);
        return;
        ETException etexception;
        etexception;
        etexception.printStackTrace();
          goto _L4
        list;
        list.printStackTrace();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (b.isCancelled())
        {
            b.d();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        c = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (g == null)
        {
            g = layoutinflater.inflate(0x7f030084, viewgroup, false);
            h = g.findViewById(0x7f0c0064);
            a = (ListView)g.findViewById(0x102000a);
            layoutinflater = new View(c);
            layoutinflater.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, 1));
            layoutinflater.setBackgroundResource(0x7f0b0008);
            a.addHeaderView(layoutinflater);
            layoutinflater = new View(c);
            layoutinflater.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, 1));
            layoutinflater.setBackgroundResource(0x7f0b0008);
            a.addFooterView(layoutinflater);
            b = new ii(c, this, h);
            b.executeOnExecutor(nb.h, new Void[0]);
        } else
        {
            ((ViewGroup)g.getParent()).removeView(g);
        }
        a.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final NotificationsCategoryFragment a;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
            }

            
            {
                a = NotificationsCategoryFragment.this;
                super();
            }
        });
        return g;
    }

    public void onPause()
    {
        super.onPause();
        if (h.getVisibility() == 0)
        {
            h.setVisibility(8);
        }
        b.cancel(true);
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)c).updateActionBarTitle("");
        if (l())
        {
            b = new ii(c, this, h);
            b.executeOnExecutor(nb.h, new Void[0]);
        }
    }
}
