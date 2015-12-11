// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.stores.StoreDetailsFragment;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class ec extends PagerAdapter
    implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, lg
{

    private ArrayList a;
    private LayoutInflater b;
    private Context c;
    private BBYTextView d;
    private BBYTextView e;
    private nb f;
    private boolean g;

    public ec(Context context, ArrayList arraylist)
    {
        g = false;
        a = arraylist;
        c = context;
        b = LayoutInflater.from(context);
        f = nb.a();
    }

    private void a(Uri uri, String s)
    {
        (new lf(c, uri, s, this)).show();
    }

    private void a(BBYStore bbystore, String s)
    {
        f.c("Background");
        bbystore = new StoreDetailsFragment(bbystore, s, false);
        s = ((BBYBaseFragmentActivity)c).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (s instanceof HomeTabFragment)
        {
            ((BaseTabContainer)((HomeTabFragment)s).getChildFragmentManager().findFragmentByTag("STORES")).a(bbystore, true);
        }
    }

    public void a(boolean flag)
    {
        g = false;
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        ((ViewPager)viewgroup).removeView((RelativeLayout)obj);
    }

    public int getCount()
    {
        return a.size();
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public float getPageWidth(int i)
    {
        return 0.85F;
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        if (a != null && !a.isEmpty())
        {
            BBYStore bbystore = (BBYStore)a.get(i);
            View view = b.inflate(0x7f03010a, null);
            view.setTag(bbystore);
            BBYTextView bbytextview = (BBYTextView)view.findViewById(0x7f0c0024);
            d = (BBYTextView)view.findViewById(0x7f0c0025);
            d.setTag(bbystore);
            e = (BBYTextView)view.findViewById(0x7f0c0026);
            e.setTag(bbystore);
            BBYTextView bbytextview1 = (BBYTextView)view.findViewById(0x7f0c0027);
            BBYTextView bbytextview2 = (BBYTextView)view.findViewById(0x7f0c0028);
            bbytextview.setText(bbystore.getStoreDetails().getName().replace("Best Buy Mobile - ", "").trim());
            d.setText(bbystore.getStoreDetails().getAddress());
            e.setText((new StringBuilder()).append(bbystore.getStoreDetails().getCity()).append(", ").append(bbystore.getStoreDetails().getState()).append(" ").append(bbystore.getStoreDetails().getZipCode()).toString());
            d.setMovementMethod(LinkMovementMethod.getInstance());
            bbytextview1.setText(nr.a(bbystore));
            bbytextview2.setText((new StringBuilder()).append(bbystore.getDistance()).append("mi").toString());
            if (bbystore.getStoreDetails().getLocationSubType().equals("Mobile Store"))
            {
                view.findViewById(0x7f0c03dd).setVisibility(0);
            } else
            {
                view.findViewById(0x7f0c03dd).setVisibility(8);
            }
            view.setOnClickListener(this);
            d.setOnClickListener(this);
            e.setOnClickListener(this);
            ((ViewPager)viewgroup).addView(view, 0);
            return view;
        } else
        {
            return null;
        }
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (View)obj;
    }

    public void onClick(View view)
    {
        BBYStore bbystore = (BBYStore)view.getTag();
        if ((view.getId() == 0x7f0c03e3 || view.getId() == 0x7f0c0025 || view.getId() == 0x7f0c0026) && !g)
        {
            a(bbystore, bbystore.getStoreId());
        }
    }

    public boolean onLongClick(View view)
    {
        g = true;
        BBYStore bbystore = (BBYStore)view.getTag();
        if (view.getId() == 0x7f0c0025 || view.getId() == 0x7f0c0026)
        {
            view = (new StringBuilder()).append(bbystore.getStoreDetails().getCity()).append(", ").append(bbystore.getStoreDetails().getState()).append(" ").append(bbystore.getStoreDetails().getZipCode()).toString();
            view = (new StringBuilder()).append(bbystore.getStoreDetails().getAddress()).append(", ").append(view).toString();
            a(Uri.parse((new StringBuilder()).append(c.getResources().getString(0x7f0801d0)).append(f.y()).append(",").append(f.z()).append("&daddr=").append(view).append("&hl=en").toString()), view);
        }
        return false;
    }
}
