// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.network.d;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            u

public class SelectCategoryActivity extends BaseActivity
{

    private AbsListView e;
    private ArrayAdapter f;
    private Long g;
    private CircleType h;

    public SelectCategoryActivity()
    {
        g = Long.valueOf(-1L);
        h = null;
    }

    static ArrayAdapter a(SelectCategoryActivity selectcategoryactivity)
    {
        return selectcategoryactivity.f;
    }

    static CircleType a(SelectCategoryActivity selectcategoryactivity, CircleType circletype)
    {
        selectcategoryactivity.h = circletype;
        return circletype;
    }

    static Long a(SelectCategoryActivity selectcategoryactivity, Long long1)
    {
        selectcategoryactivity.g = long1;
        return long1;
    }

    static void b(SelectCategoryActivity selectcategoryactivity)
    {
        selectcategoryactivity.p();
    }

    static Long c(SelectCategoryActivity selectcategoryactivity)
    {
        return selectcategoryactivity.g;
    }

    static AbsListView d(SelectCategoryActivity selectcategoryactivity)
    {
        return selectcategoryactivity.e;
    }

    private void o()
    {
        f = new u(this, k.bc_view_item_category_list, j.sharein_category_text, j.sharein_category_icon);
        e = (AbsListView)findViewById(j.bc_category_list_view);
        e.setChoiceMode(1);
        e.setAdapter(f);
        e.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SelectCategoryActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (CircleType)SelectCategoryActivity.a(a).getItem(i);
                if (adapterview != null)
                {
                    SelectCategoryActivity.a(a, adapterview);
                    SelectCategoryActivity.a(a, ((CircleType) (adapterview)).id);
                    SelectCategoryActivity.b(a);
                }
            }

            
            {
                a = SelectCategoryActivity.this;
                super();
            }
        });
        CircleType.b().a(new com.perfectcorp.utility.m() {

            final SelectCategoryActivity a;

            protected void a(d d1)
            {
                if (d1 != null && d1.b != null && !d1.b.isEmpty())
                {
                    SelectCategoryActivity.a(a).addAll(d1.b);
                    int l = SelectCategoryActivity.a(a).getCount();
                    d1 = null;
                    for (int i = 0; i < l; i++)
                    {
                        CircleType circletype = (CircleType)SelectCategoryActivity.a(a).getItem(i);
                        if (circletype != null && SelectCategoryActivity.c(a) != null && SelectCategoryActivity.c(a).longValue() > 0L && SelectCategoryActivity.c(a).equals(circletype.id))
                        {
                            SelectCategoryActivity.a(a, circletype);
                            com.cyberlink.beautycircle.controller.activity.SelectCategoryActivity.d(a).setItemChecked(i, true);
                        }
                        if (circletype != null && circletype.defaultType.equals("HOW-TO"))
                        {
                            d1 = circletype;
                        }
                    }

                    if (d1 != null)
                    {
                        SelectCategoryActivity.a(a).remove(d1);
                        return;
                    }
                }
            }

            protected void b(Object obj)
            {
                a((d)obj);
            }

            
            {
                a = SelectCategoryActivity.this;
                super();
            }
        });
    }

    private void p()
    {
        Intent intent = new Intent();
        if (h != null)
        {
            intent.putExtra("Category", h.toString());
        }
        setResult(-1, intent);
        super.e();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_select_category);
        bundle = getIntent();
        if (bundle != null)
        {
            g = Long.valueOf(bundle.getLongExtra("CategoryId", -1L));
        }
        b(m.bc_edit_circle_category_title);
        b().a();
        o();
    }

    public void onRightBtnClick(View view)
    {
        p();
    }
}
