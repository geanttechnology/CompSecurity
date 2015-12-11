// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import com.offerup.android.a.h;
import com.offerup.android.activities.k;
import com.offerup.android.dto.Category;
import com.offerup.android.dto.ItemPost;
import com.offerup.android.h.b;
import com.offerup.android.utils.al;
import com.offerup.android.views.TriggerSpinner;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.g.c:
//            a, d, e, f, 
//            g

public final class c extends a
{

    private Category b;
    private String c;
    private EditText d;
    private Button e;
    private TriggerSpinner f;
    private ArrayAdapter g;

    public c()
    {
    }

    static ArrayAdapter a(c c1)
    {
        return c1.g;
    }

    static Category a(c c1, Category category)
    {
        c1.b = category;
        return category;
    }

    public static c a(Category category, String s)
    {
        c c1 = new c();
        Bundle bundle = new Bundle();
        if (category != null)
        {
            bundle.putParcelable("category", category);
        }
        if (s != null)
        {
            bundle.putString("description", s);
        }
        c1.setArguments(bundle);
        return c1;
    }

    static Category b(c c1)
    {
        return c1.b;
    }

    static Button c(c c1)
    {
        return c1.e;
    }

    static TriggerSpinner d(c c1)
    {
        return c1.f;
    }

    static void e(c c1)
    {
        c1.k();
    }

    private void k()
    {
        int i1 = g.getCount();
        int l = 0;
        do
        {
label0:
            {
                if (l < i1)
                {
                    Category category = (Category)g.getItem(l);
                    if (category == null || b == null || b.getId() != category.getId() || !StringUtils.equals(b.getName(), category.getName()))
                    {
                        break label0;
                    }
                    f.setSelection(l);
                }
                if (b == null)
                {
                    e.setText(getString(0x7f0900eb));
                } else
                {
                    e.setText(b.getName());
                }
                e.requestFocus();
                return;
            }
            l++;
        } while (true);
    }

    final void a(Bundle bundle)
    {
        if (b != null)
        {
            bundle.putParcelable("category", b);
        } else
        {
            bundle.remove("category");
        }
        if (c != null)
        {
            bundle.putString("description", c);
            return;
        } else
        {
            bundle.remove("description");
            return;
        }
    }

    final void a(View view)
    {
        e = (Button)view.findViewById(0x7f100250);
        d = (EditText)view.findViewById(0x7f100252);
        f = (TriggerSpinner)view.findViewById(0x7f10024f);
        g = new h(getActivity(), 0x1090008);
        g.setNotifyOnChange(false);
        f.setAdapter(g);
        f.setOnItemSelectedListener(new d(this));
        e.setOnClickListener(new e(this));
        ((k)getActivity()).a(0x7f0901b1);
        a.a(new f(this));
    }

    final void a(List list)
    {
        for (int l = 0; l < list.size(); l++)
        {
            if ("Please select a category.".equals((String)list.get(l)))
            {
                e.setError("Please select a category.");
            }
        }

    }

    final void b()
    {
        String s;
        if (d.getText() == null)
        {
            s = null;
        } else
        {
            s = d.getText().toString();
        }
        c = s;
    }

    final void b(Bundle bundle)
    {
        b = null;
        c = null;
        if (bundle.containsKey("category"))
        {
            b = (Category)bundle.getParcelable("category");
        }
        if (bundle.containsKey("description"))
        {
            c = bundle.getString("description");
        }
    }

    final void c()
    {
        k();
        d.setText(c);
    }

    final String d()
    {
        return "item_post_2";
    }

    final int e()
    {
        return 0x7f0900df;
    }

    final int f()
    {
        return 0x7f09017e;
    }

    final int g()
    {
        return 0x7f040095;
    }

    final int h()
    {
        return 0x7f0201b3;
    }

    final List i()
    {
        new al(new ItemPost());
        ArrayList arraylist = new ArrayList(1);
        if (!al.a(b))
        {
            arraylist.add("Please select a category.");
        }
        return arraylist;
    }

    final Object j()
    {
        return new g(this, b, c);
    }
}
