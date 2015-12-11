// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.askexpert.CustomGroupExpandableListView;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.HashMap;

public class bn extends BaseExpandableListAdapter
{

    private CustomGroupExpandableListView a;
    private Context b;
    private ArrayList c;
    private int d;
    private bo e;
    private LayoutInflater f;
    private boolean g;
    private boolean h;

    public bn(CustomGroupExpandableListView customgroupexpandablelistview, Context context, ArrayList arraylist, boolean flag, boolean flag1)
    {
        d = -1;
        g = false;
        h = false;
        a = customgroupexpandablelistview;
        b = context;
        c = arraylist;
        g = flag;
        h = flag1;
        f = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public void a(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("bb.prevPageLink", (new StringBuilder()).append(lu.bb).append(s).toString());
        hashmap.put("bb.callBB", "1");
        lu.b((new StringBuilder()).append(lu.bb).append(s).append(": ").append("call").toString(), hashmap);
        s = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder()).append("tel:").append(b.getString(0x7f0800cc)).toString()));
        b.startActivity(s);
        ((Activity)b).finish();
    }

    public boolean a()
    {
        return ((TelephonyManager)b.getSystemService("phone")).getLine1Number() != null;
    }

    public void b(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("bb.prevPageLink", (new StringBuilder()).append(lu.bb).append(s).toString());
        hashmap.put("bb.emailBB", "1");
        lu.b((new StringBuilder()).append(lu.bb).append(s).append(": ").append("Email").toString(), hashmap);
        s = new Intent("android.intent.action.SEND");
        s.putExtra("android.intent.extra.EMAIL", new String[] {
            b.getString(0x7f0800cb)
        });
        s.putExtra("android.intent.extra.SUBJECT", b.getString(0x7f080183));
        s.putExtra("android.intent.extra.TEXT", b.getString(0x7f080181));
        s.setType("message/rfc822");
        b.startActivity(Intent.createChooser(s, "Choose an Email client :"));
        ((Activity)b).finish();
    }

    public Object getChild(int i, int j)
    {
        return Integer.valueOf(j);
    }

    public long getChildId(int i, int j)
    {
        return (long)j;
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        String s = (String)c.get(i);
        if (s.equals(b.getResources().getString(0x7f0800b6)) || s.equals(b.getResources().getString(0x7f0801dc)))
        {
            view = f.inflate(0x7f030047, viewgroup, false);
            viewgroup = (LinearLayout)view.findViewById(0x7f0c0114);
            viewgroup.setOnClickListener(new android.view.View.OnClickListener(s, viewgroup) {

                final String a;
                final LinearLayout b;
                final bn c;

                public void onClick(View view1)
                {
                    if (c.a())
                    {
                        c.a(a);
                        return;
                    } else
                    {
                        b.setEnabled(false);
                        return;
                    }
                }

            
            {
                c = bn.this;
                a = s;
                b = linearlayout;
                super();
            }
            });
        } else
        {
            if (s.equals(b.getResources().getString(0x7f080236)))
            {
                view = f.inflate(0x7f030049, viewgroup, false);
                viewgroup = (LinearLayout)view.findViewById(0x7f0c0114);
                viewgroup.setOnClickListener(new android.view.View.OnClickListener(s, viewgroup) {

                    final String a;
                    final LinearLayout b;
                    final bn c;

                    public void onClick(View view1)
                    {
                        if (c.a())
                        {
                            c.a(a);
                            return;
                        } else
                        {
                            b.setEnabled(false);
                            return;
                        }
                    }

            
            {
                c = bn.this;
                a = s;
                b = linearlayout;
                super();
            }
                });
                viewgroup = (LinearLayout)view.findViewById(0x7f0c0116);
                if (h)
                {
                    viewgroup.setOnClickListener(((HelpMenuActivity)b).a("ExistingOrder"));
                    return view;
                } else
                {
                    viewgroup.setVisibility(8);
                    return view;
                }
            }
            if (s.equals(b.getResources().getString(0x7f080299)))
            {
                view = f.inflate(0x7f03004a, viewgroup, false);
                ((LinearLayout)view.findViewById(0x7f0c0116)).setVisibility(8);
                viewgroup = (LinearLayout)view.findViewById(0x7f0c011a);
                if (g)
                {
                    viewgroup.setOnClickListener(((HelpMenuActivity)b).b());
                } else
                {
                    viewgroup.setVisibility(8);
                }
                viewgroup = (LinearLayout)view.findViewById(0x7f0c0114);
                viewgroup.setOnClickListener(new android.view.View.OnClickListener(s, viewgroup) {

                    final String a;
                    final LinearLayout b;
                    final bn c;

                    public void onClick(View view1)
                    {
                        if (c.a())
                        {
                            c.a(a);
                            return;
                        } else
                        {
                            b.setEnabled(false);
                            return;
                        }
                    }

            
            {
                c = bn.this;
                a = s;
                b = linearlayout;
                super();
            }
                });
                ((LinearLayout)view.findViewById(0x7f0c0117)).setOnClickListener(new android.view.View.OnClickListener(s) {

                    final String a;
                    final bn b;

                    public void onClick(View view1)
                    {
                        b.b(a);
                    }

            
            {
                b = bn.this;
                a = s;
                super();
            }
                });
                return view;
            }
        }
        return view;
    }

    public int getChildrenCount(int i)
    {
        String s = (String)c.get(i);
        return !s.equals(b.getResources().getString(0x7f0800b6)) && !s.equals(b.getResources().getString(0x7f0801dc)) && !s.equals(b.getResources().getString(0x7f080236)) && !s.equals(b.getResources().getString(0x7f080299)) ? 0 : 1;
    }

    public Object getGroup(int i)
    {
        return c.get(i);
    }

    public int getGroupCount()
    {
        return c.size();
    }

    public long getGroupId(int i)
    {
        return 0L;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            e = new bo();
            view = f.inflate(0x7f030046, viewgroup, false);
            e.a = (BBYTextView)view.findViewById(0x7f0c0112);
            e.b = (ImageView)view.findViewById(0x7f0c0113);
            view.setTag(e);
        } else
        {
            e = (bo)view.getTag();
        }
        e.a.setText((String)getGroup(i));
        if (flag)
        {
            e.b.setImageResource(0x7f020012);
            return view;
        } else
        {
            e.b.setImageResource(0x7f020011);
            return view;
        }
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return true;
    }

    public void onGroupCollapsed(int i)
    {
        if (d == i)
        {
            d = -1;
        }
    }

    public void onGroupExpanded(int i)
    {
        if (d == -1)
        {
            d = i;
            return;
        } else
        {
            a.collapseGroup(d);
            d = i;
            return;
        }
    }
}
