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
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.adobe.mobile.Analytics;
import com.bestbuy.android.activities.askexpert.CustomGroupExpandableListView;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.activities.browseproduct.pdp.StickyGroupExpandableListView;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.HashMap;

public class bp extends BaseExpandableListAdapter
{

    private StickyGroupExpandableListView a;
    private Context b;
    private ArrayList c;
    private int d;
    private bq e;
    private LayoutInflater f;
    private ArrayList g;
    private bn h;
    private CustomGroupExpandableListView i;
    private boolean j;
    private boolean k;
    private LinearLayout l;
    private boolean m;

    public bp(StickyGroupExpandableListView stickygroupexpandablelistview, Context context, ArrayList arraylist, ArrayList arraylist1, boolean flag, boolean flag1)
    {
        d = -1;
        g = new ArrayList();
        j = false;
        k = false;
        m = true;
        a = stickygroupexpandablelistview;
        b = context;
        c = arraylist;
        g = arraylist1;
        j = flag;
        k = flag1;
        f = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    static LinearLayout a(bp bp1)
    {
        return bp1.l;
    }

    static ArrayList b(bp bp1)
    {
        return bp1.g;
    }

    public void a()
    {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder()).append("tel:").append(b.getString(0x7f0800cc)).toString()));
        b.startActivity(intent);
        ((Activity)b).finish();
    }

    public void b()
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            b.getString(0x7f0800cb)
        });
        intent.putExtra("android.intent.extra.SUBJECT", b.getString(0x7f080183));
        intent.putExtra("android.intent.extra.TEXT", b.getString(0x7f080181));
        intent.setType("message/rfc822");
        b.startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        ((Activity)b).finish();
    }

    public boolean c()
    {
        return ((TelephonyManager)b.getSystemService("phone")).getLine1Number() != null;
    }

    public Object getChild(int i1, int j1)
    {
        return null;
    }

    public long getChildId(int i1, int j1)
    {
        return (long)j1;
    }

    public View getChildView(int i1, int j1, boolean flag, View view, ViewGroup viewgroup)
    {
        if (((String)c.get(i1)).equals(b.getResources().getString(0x7f0802c8)))
        {
            if (!m)
            {
                lu.a(lu.aV);
            }
            m = false;
            view = f.inflate(0x7f03004c, null, false);
            viewgroup = (LinearLayout)view.findViewById(0x7f0c011a);
            if (!j)
            {
                viewgroup.setVisibility(8);
            } else
            {
                viewgroup.setOnClickListener(((HelpMenuActivity)b).a());
            }
            viewgroup = (LinearLayout)view.findViewById(0x7f0c0116);
            if (!k)
            {
                viewgroup.setVisibility(8);
            } else
            {
                viewgroup.setOnClickListener(((HelpMenuActivity)b).a("PurchasingProduct"));
            }
            l = (LinearLayout)view.findViewById(0x7f0c0114);
            l.setOnClickListener(new android.view.View.OnClickListener() {

                final bp a;

                public void onClick(View view1)
                {
                    view1 = new HashMap();
                    view1.put("bb.prevPageLink", lu.aV);
                    view1.put("bb.callBB", "1");
                    lu.b(lu.aW, view1);
                    if (a.c())
                    {
                        a.a();
                        return;
                    } else
                    {
                        bp.a(a).setEnabled(false);
                        return;
                    }
                }

            
            {
                a = bp.this;
                super();
            }
            });
        } else
        {
            if (((String)c.get(i1)).equals(b.getResources().getString(0x7f080197)))
            {
                lu.a(lu.aZ);
                view = f.inflate(0x7f030048, null, false);
                i = (CustomGroupExpandableListView)view.findViewById(0x7f0c0115);
                h = new bn(i, b, g, j, k);
                viewgroup = new fd(h);
                i.setAdapter(viewgroup);
                i.setGroupIndicator(null);
                i.setOnGroupClickListener(new android.widget.ExpandableListView.OnGroupClickListener() {

                    final bp a;

                    public boolean onGroupClick(ExpandableListView expandablelistview, View view1, int k1, long l1)
                    {
                        if (!expandablelistview.isGroupExpanded(k1))
                        {
                            lu.b((new StringBuilder()).append(lu.bb).append((String)bp.b(a).get(k1)).toString(), null);
                        }
                        return false;
                    }

            
            {
                a = bp.this;
                super();
            }
                });
                return view;
            }
            if (((String)c.get(i1)).equals(b.getResources().getString(0x7f080329)))
            {
                lu.a(lu.aI);
                view = f.inflate(0x7f03004d, viewgroup, false);
                ((LinearLayout)view.findViewById(0x7f0c0117)).setOnClickListener(new android.view.View.OnClickListener() {

                    final bp a;

                    public void onClick(View view1)
                    {
                        view1 = new HashMap();
                        view1.put("bb.prevPageLink", lu.aI);
                        view1.put("bb.callBB", "1");
                        Analytics.trackState(lu.aK, view1);
                        a.b();
                    }

            
            {
                a = bp.this;
                super();
            }
                });
                viewgroup = (LinearLayout)view.findViewById(0x7f0c0114);
                viewgroup.setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

                    final LinearLayout a;
                    final bp b;

                    public void onClick(View view1)
                    {
                        if (b.c())
                        {
                            b.a();
                            view1 = new HashMap();
                            view1.put("bb.prevPageLink", lu.aI);
                            view1.put("bb.callBB", "1");
                            Analytics.trackState(lu.aJ, view1);
                            return;
                        } else
                        {
                            a.setEnabled(false);
                            return;
                        }
                    }

            
            {
                b = bp.this;
                a = linearlayout;
                super();
            }
                });
                return view;
            }
        }
        return view;
    }

    public int getChildrenCount(int i1)
    {
        String s = (String)c.get(i1);
        if (s.equals(b.getResources().getString(0x7f0802c8)) || s.equals(b.getResources().getString(0x7f080329)))
        {
            return 1;
        }
        return !s.equals(b.getResources().getString(0x7f080197)) ? 0 : 1;
    }

    public Object getGroup(int i1)
    {
        return c.get(i1);
    }

    public int getGroupCount()
    {
        return c.size();
    }

    public long getGroupId(int i1)
    {
        return 0L;
    }

    public View getGroupView(int i1, boolean flag, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            e = new bq();
            view = f.inflate(0x7f03004b, viewgroup, false);
            e.a = (BBYTextView)view.findViewById(0x7f0c0118);
            e.b = (ImageView)view.findViewById(0x7f0c0119);
            view.setTag(e);
        } else
        {
            e = (bq)view.getTag();
        }
        e.a.setText((String)getGroup(i1));
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

    public boolean isChildSelectable(int i1, int j1)
    {
        return true;
    }

    public void onGroupCollapsed(int i1)
    {
        if (d == i1)
        {
            d = -1;
        }
    }

    public void onGroupExpanded(int i1)
    {
        if (d == -1)
        {
            d = i1;
            return;
        } else
        {
            a.collapseGroup(d);
            d = i1;
            return;
        }
    }
}
