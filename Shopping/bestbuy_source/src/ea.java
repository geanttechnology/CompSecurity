// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.blueassist.BlueAssistStoreSelectionActivity;
import com.bestbuy.android.activities.browseproduct.ProductAvailabilityFragment;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.plpstoreavailability.PLPStoreSelectionActivity;
import com.bestbuy.android.activities.stores.StoreDetailsFragment;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class ea extends ArrayAdapter
    implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, lg
{

    private LayoutInflater a;
    private ArrayList b;
    private nb c;
    private Activity d;
    private boolean e;
    private boolean f;
    private boolean g;
    private ProductAvailabilityFragment h;
    private boolean i;

    public ea(Activity activity, ArrayList arraylist, boolean flag, boolean flag1, boolean flag2)
    {
        super(activity, 0x7f030107, arraylist);
        e = false;
        g = false;
        b = arraylist;
        d = activity;
        g = flag1;
        f = flag;
        i = flag2;
        a = activity.getLayoutInflater();
        c = nb.a();
    }

    static ProductAvailabilityFragment a(ea ea1)
    {
        return ea1.h;
    }

    private void a(Uri uri, String s)
    {
        (new lf(d, uri, s, this)).show();
    }

    private void a(BBYStore bbystore, String s)
    {
        c.c("Background");
        bbystore = new StoreDetailsFragment(bbystore, s, false);
        s = ((BBYBaseFragmentActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (s instanceof HomeTabFragment)
        {
            ((BaseTabContainer)((HomeTabFragment)s).getChildFragmentManager().findFragmentByTag("STORES")).a(bbystore, true);
        }
    }

    public int a(BBYStore bbystore)
    {
        return b.indexOf(bbystore);
    }

    public void a(boolean flag)
    {
        e = false;
    }

    public int getCount()
    {
        if (g)
        {
            if (b.size() > 10)
            {
                return 10;
            } else
            {
                return b.size();
            }
        } else
        {
            return b.size();
        }
    }

    public int getPosition(Object obj)
    {
        return a((BBYStore)obj);
    }

    public View getView(int j, View view, ViewGroup viewgroup)
    {
        BBYStore bbystore;
        String s;
        if (view == null)
        {
            eb eb1 = new eb();
            view = a.inflate(0x7f030107, viewgroup, false);
            eb1.a = (BBYTextView)view.findViewById(0x7f0c0024);
            eb1.b = (BBYTextView)view.findViewById(0x7f0c0025);
            eb1.c = (BBYTextView)view.findViewById(0x7f0c0026);
            eb1.e = (BBYTextView)view.findViewById(0x7f0c0027);
            eb1.d = (BBYTextView)view.findViewById(0x7f0c0028);
            eb1.f = (ImageView)view.findViewById(0x7f0c03dd);
            eb1.g = (ImageView)view.findViewById(0x7f0c004c);
            eb1.h = (RelativeLayout)view.findViewById(0x7f0c0233);
            eb1.i = (ImageView)view.findViewById(0x7f0c004c);
            view.setTag(0x7f0d0006, eb1);
            viewgroup = eb1;
        } else
        {
            viewgroup = (eb)view.getTag(0x7f0d0006);
        }
        bbystore = (BBYStore)b.get(j);
        view.setTag(bbystore);
        s = bbystore.getStoreDetails().getName().replace("Best Buy Mobile - ", "").trim();
        ((eb) (viewgroup)).a.setText(s);
        ((eb) (viewgroup)).b.setText(bbystore.getStoreDetails().getAddress());
        ((eb) (viewgroup)).c.setText((new StringBuilder()).append(bbystore.getStoreDetails().getCity()).append(", ").append(bbystore.getStoreDetails().getState()).append(" ").append(bbystore.getStoreDetails().getZipCode()).toString());
        ((eb) (viewgroup)).b.setMovementMethod(LinkMovementMethod.getInstance());
        ((eb) (viewgroup)).e.setText(nr.a(bbystore));
        if (bbystore.getDistance() != null)
        {
            ((eb) (viewgroup)).d.setText((new StringBuilder()).append(bbystore.getDistance()).append("mi").toString());
        } else
        {
            ((eb) (viewgroup)).d.setVisibility(8);
        }
        if (bbystore.getStoreDetails().getLocationSubType().equals("Mobile Store"))
        {
            ((eb) (viewgroup)).f.setVisibility(0);
        } else
        {
            ((eb) (viewgroup)).f.setVisibility(8);
        }
        if (f)
        {
            ((eb) (viewgroup)).g.setVisibility(0);
        } else
        {
            ((eb) (viewgroup)).g.setVisibility(8);
        }
        if (g)
        {
            ((eb) (viewgroup)).h.setVisibility(0);
            ((eb) (viewgroup)).h.setOnClickListener(new android.view.View.OnClickListener(bbystore) {

                final BBYStore a;
                final ea b;

                public void onClick(View view1)
                {
                    if (ea.a(b) != null)
                    {
                        ea.a(b).c(a.getStoreId());
                    }
                }

            
            {
                b = ea.this;
                a = bbystore;
                super();
            }
            });
        } else
        {
            ((eb) (viewgroup)).h.setVisibility(8);
        }
        if (d instanceof PLPStoreSelectionActivity)
        {
            ((eb) (viewgroup)).i.setImageResource(0x7f020075);
        }
        view.setOnClickListener(this);
        return view;
    }

    public void onClick(View view)
    {
        BBYStore bbystore;
label0:
        {
            if (f)
            {
                bbystore = (BBYStore)view.getTag();
                if (bbystore != null && view.getId() == 0x7f0c03dc && !e)
                {
                    if (!i)
                    {
                        break label0;
                    }
                    if (d instanceof BlueAssistStoreSelectionActivity)
                    {
                        ((BlueAssistStoreSelectionActivity)d).a(bbystore);
                    }
                }
            }
            return;
        }
        if (d instanceof PLPStoreSelectionActivity)
        {
            ((eb)view.getTag(0x7f0d0006)).i.setImageResource(0x7f020074);
            ((PLPStoreSelectionActivity)d).a(bbystore);
            return;
        } else
        {
            a(bbystore, bbystore.getStoreId());
            return;
        }
    }

    public boolean onLongClick(View view)
    {
        e = true;
        BBYStore bbystore = (BBYStore)view.getTag();
        if (view.getId() == 0x7f0c0025 || view.getId() == 0x7f0c0026)
        {
            view = (new StringBuilder()).append(bbystore.getStoreDetails().getCity()).append(", ").append(bbystore.getStoreDetails().getState()).append(" ").append(bbystore.getStoreDetails().getZipCode()).toString();
            view = (new StringBuilder()).append(bbystore.getStoreDetails().getAddress()).append(", ").append(view).toString();
            a(Uri.parse((new StringBuilder()).append(d.getResources().getString(0x7f0801d0)).append(c.y()).append(",").append(c.z()).append("&daddr=").append(view).append("&hl=en").toString()), view);
        }
        return false;
    }
}
