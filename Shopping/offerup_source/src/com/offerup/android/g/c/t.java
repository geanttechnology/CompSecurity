// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.b.a.a.j;
import com.offerup.android.dto.ItemPost;
import com.offerup.android.utils.al;
import com.offerup.android.utils.as;
import com.offerup.android.utils.n;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.offerup.android.g.c:
//            a, v, w, u, 
//            x, y

public final class t extends a
{

    private final NumberFormat b;
    private CheckBox c;
    private EditText d;
    private SeekBar e;
    private RelativeLayout f;
    private TextView g;
    private Integer h;
    private Double i;
    private Integer j;
    private boolean k;

    public t()
    {
        b = DecimalFormat.getCurrencyInstance(Locale.US);
    }

    static EditText a(t t1)
    {
        return t1.d;
    }

    public static t a(Double double1, Integer integer, Integer integer1)
    {
        t t1 = new t();
        Bundle bundle = new Bundle();
        if (double1 != null)
        {
            bundle.putDouble("price", double1.doubleValue());
        }
        if (integer != null)
        {
            bundle.putInt("listing_type", integer.intValue());
        }
        if (integer1 != null)
        {
            bundle.putInt("condition", integer1.intValue());
        }
        t1.setArguments(bundle);
        return t1;
    }

    static CheckBox b(t t1)
    {
        return t1.c;
    }

    static TextView c(t t1)
    {
        return t1.g;
    }

    final void a(Bundle bundle)
    {
        if (h != null)
        {
            bundle.putInt("condition", h.intValue());
        } else
        {
            bundle.remove("condition");
        }
        if (i != null)
        {
            bundle.putDouble("price", i.doubleValue());
        } else
        {
            bundle.remove("price");
        }
        if (j != null)
        {
            bundle.putInt("listing_type", j.intValue());
            return;
        } else
        {
            bundle.remove("listing_type");
            return;
        }
    }

    final void a(View view)
    {
        c = (CheckBox)view.findViewById(0x7f100261);
        f = (RelativeLayout)view.findViewById(0x7f10025f);
        float f1 = getResources().getDisplayMetrics().density;
        CheckBox checkbox = c;
        int l = c.getPaddingLeft();
        checkbox.setPadding((int)(f1 * 20F + 0.5F) + l, c.getPaddingTop(), c.getPaddingRight(), c.getPaddingBottom());
        f.setOnClickListener(new v(this));
        e = (SeekBar)view.findViewById(0x7f100264);
        g = (TextView)view.findViewById(0x7f100263);
        e.setOnSeekBarChangeListener(new w(this));
        d = (EditText)view.findViewById(0x7f10025e);
        d.setOnClickListener(new u(this));
        as.a(d);
    }

    final void a(List list)
    {
        int l = 0;
        while (l < list.size()) 
        {
            String s = (String)list.get(l);
            if ("Please state the condition of your item.".equals(s))
            {
                Toast.makeText(getActivity(), s, 0).show();
            } else
            if ("Please give your item a price.".equals(s))
            {
                d.setError("Please give your item a price.");
                d.requestFocus();
            } else
            if ("Verify Item Condition".equals(s))
            {
                android.app.AlertDialog.Builder builder = n.c(getActivity());
                builder.setTitle("Verify Item Condition");
                builder.setMessage("Please verify item condition. Slide left or right to change.");
                builder.setPositiveButton("Ok", new x(this));
                n.a(builder);
                com.b.a.a.j.a().s(false);
            }
            l++;
        }
    }

    final void b()
    {
        if (!k)
        {
            k = com.b.a.a.j.a().Q();
        }
        h = Integer.valueOf(e.getProgress() * 20);
        Object obj = b.parse(d.getText().toString());
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L3:
        double d1;
        int l;
        try
        {
            i = ((Double) (obj));
        }
        catch (ParseException parseexception)
        {
            i = null;
        }
        if (c.isChecked())
        {
            l = 1;
        } else
        {
            l = 2;
        }
        j = Integer.valueOf(l);
        return;
_L2:
        d1 = ((Number) (obj)).doubleValue();
        obj = Double.valueOf(d1);
          goto _L3
    }

    final void b(Bundle bundle)
    {
        if (bundle.containsKey("condition"))
        {
            h = Integer.valueOf(bundle.getInt("condition"));
        } else
        {
            h = null;
        }
        if (bundle.containsKey("listing_type"))
        {
            j = Integer.valueOf(bundle.getInt("listing_type"));
        } else
        {
            j = null;
        }
        if (bundle.containsKey("price"))
        {
            i = Double.valueOf(bundle.getDouble("price"));
            return;
        } else
        {
            i = null;
            return;
        }
    }

    final void c()
    {
        boolean flag = true;
        if (i != null)
        {
            d.setText(b.format(i));
        }
        if (d.getError() != null)
        {
            d.setError(null);
        }
        CheckBox checkbox = c;
        if (j == null || j.intValue() != 1)
        {
            flag = false;
        }
        checkbox.setChecked(flag);
        if (h != null)
        {
            e.setProgress(h.intValue() / 20);
        } else
        {
            e.setProgress(2);
        }
        d.requestFocus();
    }

    final String d()
    {
        return "item_post_3";
    }

    final int e()
    {
        return 0x7f0901bd;
    }

    final int f()
    {
        return 0x7f09017e;
    }

    final int g()
    {
        return 0x7f040098;
    }

    final int h()
    {
        return 0x7f0201b4;
    }

    final List i()
    {
        new al(new ItemPost());
        ArrayList arraylist = new ArrayList(3);
        if (!al.a(h))
        {
            arraylist.add("Please state the condition of your item.");
        }
        if (!al.a(i))
        {
            arraylist.add("Please give your item a price.");
        }
        if (com.b.a.a.j.a().R() && !k)
        {
            arraylist.add("Verify Item Condition");
        }
        return arraylist;
    }

    final Object j()
    {
        return new y(this, i, j, h, (byte)0);
    }
}
