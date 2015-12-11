// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.List;

public class dz extends ArrayAdapter
{

    private Context a;
    private List b;
    private LayoutInflater c;

    public dz(Context context, List list)
    {
        super(context, 0, list);
        a = context;
        b = list;
        c = ((Activity)context).getLayoutInflater();
    }

    static Context a(dz dz1)
    {
        return dz1.a;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (mv)b.get(i);
        if (view.b())
        {
            view = (mu)view;
            viewgroup = c.inflate(0x7f0300f2, null, false);
            ((BBYTextView)viewgroup.findViewById(0x7f0c03b9)).setText(view.a());
            return viewgroup;
        }
        viewgroup = (mw)view;
        if (viewgroup.i().compareTo("MyBBY") != 0) goto _L2; else goto _L1
_L1:
        LinearLayout linearlayout = new LinearLayout(a);
        if (fr.b() == null || fr.b().isEmpty()) goto _L4; else goto _L3
_L3:
        View view1;
        String s1;
        BBYTextView bbytextview2;
        BBYTextView bbytextview3;
        view1 = c.inflate(0x7f0300f1, null, false);
        s1 = (new StringBuilder()).append(Character.toUpperCase(fr.e().charAt(0))).append(fr.e().substring(1, fr.e().length()).toLowerCase()).append(" ").append(Character.toUpperCase(fr.f().charAt(0))).append(fr.f().substring(1, fr.f().length()).toLowerCase()).toString();
        bbytextview2 = (BBYTextView)view1.findViewById(0x7f0c03b6);
        bbytextview3 = (BBYTextView)view1.findViewById(0x7f0c03b8);
        view = (LinearLayout)view1.findViewById(0x7f0c03b4);
        if (fr.l()) goto _L6; else goto _L5
_L5:
label0:
        {
            view.setVisibility(0);
            viewgroup = fr.h();
            if (viewgroup != null)
            {
                view = viewgroup;
                if (viewgroup == null)
                {
                    break label0;
                }
                view = viewgroup;
                if (!viewgroup.isEmpty())
                {
                    break label0;
                }
            }
            view = "0";
        }
label1:
        {
            String s = fr.i();
            if (s != null)
            {
                viewgroup = s;
                if (s == null)
                {
                    break label1;
                }
                viewgroup = s;
                if (!s.isEmpty())
                {
                    break label1;
                }
            }
            viewgroup = "0";
        }
        bbytextview2.setText(view);
        bbytextview3.setText((new StringBuilder()).append("$").append(viewgroup).toString());
_L9:
        ((BBYTextView)view1.findViewById(0x7f0c03b2)).setText(s1);
        ((BBYTextView)view1.findViewById(0x7f0c03b3)).setOnClickListener(new android.view.View.OnClickListener() {

            final dz a;

            public void onClick(View view4)
            {
                (new kx(dz.a(a))).show();
            }

            
            {
                a = dz.this;
                super();
            }
        });
        view = view1;
_L7:
        linearlayout.addView(view);
        return linearlayout;
_L6:
        view.setVisibility(8);
        bbytextview2.setVisibility(8);
        bbytextview3.setVisibility(8);
        continue; /* Loop/switch isn't completed */
_L4:
        view = c.inflate(0x7f030057, null, false);
        view.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
        ((ImageView)view.findViewById(0x7f0c0139)).setImageResource(a.getResources().getIdentifier(viewgroup.c(), "drawable", a.getPackageName()));
        linearlayout.setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

            final mw a;
            final dz b;

            public void onClick(View view4)
            {
                ((HomeActivity)dz.a(b)).onMenuClick(a);
            }

            
            {
                b = dz.this;
                a = mw1;
                super();
            }
        });
        if (true) goto _L7; else goto _L2
_L2:
        if (viewgroup.i().compareTo("PrivacyTC") == 0)
        {
            view = new LinearLayout(a);
            View view2 = c.inflate(0x7f030055, null, false);
            view2.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
            BBYTextView bbytextview = (BBYTextView)view2.findViewById(0x7f0c0137);
            bbytextview.setText(viewgroup.d());
            if (bbytextview.length() > 20)
            {
                bbytextview.setSingleLine();
                bbytextview.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
            }
            bbytextview.setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

                final mw a;
                final dz b;

                public void onClick(View view4)
                {
                    ((HomeActivity)dz.a(b)).onMenuClick(a);
                }

            
            {
                b = dz.this;
                a = mw1;
                super();
            }
            });
            viewgroup = (BBYTextView)view2.findViewById(0x7f0c0138);
            try
            {
                viewgroup.setText((new StringBuilder()).append("v").append(a.getPackageManager().getPackageInfo(a.getPackageName(), 0).versionName).toString());
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                viewgroup.setText("v9.0.1");
            }
            view.addView(view2);
            return view;
        }
        view = new LinearLayout(a);
        View view3 = c.inflate(0x7f030056, null, false);
        view3.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
        BBYTextView bbytextview1 = (BBYTextView)view3.findViewById(0x7f0c0137);
        ((ImageView)view3.findViewById(0x7f0c0139)).setImageResource(a.getResources().getIdentifier(viewgroup.c(), "drawable", a.getPackageName()));
        bbytextview1.setText(viewgroup.d());
        if (viewgroup.i().equals("AskBlueShirt"))
        {
            ((ImageView)view3.findViewById(0x7f0c0128)).setVisibility(8);
        }
        view.addView(view3);
        view.setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

            final mw a;
            final dz b;

            public void onClick(View view4)
            {
                ((HomeActivity)dz.a(b)).onMenuClick(a);
            }

            
            {
                b = dz.this;
                a = mw1;
                super();
            }
        });
        return view;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
