// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import cc;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.home.DealsOfTheDay;
import com.bestbuy.android.api.lib.models.home.GroupedDeal;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import com.bestbuy.android.bbyobjects.BBYTextView;
import du;
import gu;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import ll;
import nb;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity

public class DODHomeCard extends BBYBaseFragment
{

    private Activity a;
    private BBYProductViewPager b;
    private BBYTextView c;
    private View g;
    private long h;
    private long i;
    private RelativeLayout j;
    private LinearLayout k;
    private View l;
    private Fragment m;
    private du n;
    private DealsOfTheDay o;

    public DODHomeCard()
    {
    }

    static BBYTextView a(DODHomeCard dodhomecard)
    {
        return dodhomecard.c;
    }

    private String a(long l1)
    {
        long l2 = l1 / 1000L;
        long l3 = l1 / 60000L;
        l1 /= 0x36ee80L;
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[] {
            Long.valueOf(l1 % 24L), Long.valueOf(l3 % 60L), Long.valueOf(l2 % 60L)
        });
    }

    static String a(DODHomeCard dodhomecard, long l1)
    {
        return dodhomecard.a(l1);
    }

    static void a(DODHomeCard dodhomecard, boolean flag)
    {
        dodhomecard.a(flag);
    }

    private void a(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = nb.a().c().edit();
        editor.putBoolean(a.getResources().getString(0x7f080170), flag);
        editor.apply();
    }

    static RelativeLayout b(DODHomeCard dodhomecard)
    {
        return dodhomecard.j;
    }

    private void c()
    {
        Calendar calendar = Calendar.getInstance();
        long l1 = calendar.getTimeInMillis();
        i = h - l1;
        int i1 = calendar.getTime().getHours();
        if (i1 >= 2 && i1 <= 23)
        {
            (new CountDownTimer(i, 1000L) {

                final DODHomeCard a;

                public void onFinish()
                {
                    DODHomeCard.b(a).setVisibility(0);
                    DODHomeCard.b(a).setClickable(true);
                    DODHomeCard.a(a).setText("00:00:00");
                    DODHomeCard.a(a, true);
                }

                public void onTick(long l2)
                {
                    DODHomeCard.a(a).setText(DODHomeCard.a(a, l2));
                }

            
            {
                a = DODHomeCard.this;
                super(l1, l2);
            }
            }).start();
            return;
        } else
        {
            j.setVisibility(0);
            j.setClickable(true);
            c.setText("00:00:00");
            a(true);
            return;
        }
    }

    public void a(DealsOfTheDay dealsoftheday)
    {
        Calendar calendar;
        if (dealsoftheday != null)
        {
            dealsoftheday = dealsoftheday.getDealsOfTheDay();
        } else
        {
            dealsoftheday = null;
        }
        calendar = Calendar.getInstance();
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        h = calendar.getTimeInMillis();
        c();
        if (dealsoftheday != null && !dealsoftheday.isEmpty())
        {
            Collections.sort(dealsoftheday, new cc());
            Object obj = new ArrayList();
            for (int i1 = 0; i1 < dealsoftheday.size(); i1++)
            {
                ((List) (obj)).addAll(((GroupedDeal)dealsoftheday.get(i1)).getOffers());
            }

            obj = new du(a, ((List) (obj)), this, true);
            b.setAdapter(((android.support.v4.view.PagerAdapter) (obj)));
            b.startAnimation(ll.a(a));
            if (dealsoftheday.size() == 1)
            {
                b.setPagingEnabled(false);
            }
            return;
        } else
        {
            b();
            return;
        }
    }

    public void a(gu gu)
    {
        o = (DealsOfTheDay)gu;
    }

    public void a(String s)
    {
        if (!s.startsWith("/si/products/")) goto _L2; else goto _L1
_L1:
        PLPFragmentContainer plpfragmentcontainer = new PLPFragmentContainer();
        s = new PLPFragment(true, "Best-Match", "", s, "", 20);
        ((BaseTabContainer)m.getParentFragment()).a(plpfragmentcontainer, true);
        plpfragmentcontainer.a(s, true);
_L4:
        return;
_L2:
        NameValuePair namevaluepair;
        if (s.contains(".p?") && s.contains("skuId"))
        {
            s = URLEncodedUtils.parse(URI.create(s), "UTF-8").iterator();
            do
            {
                if (!s.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                namevaluepair = (NameValuePair)s.next();
            } while (!namevaluepair.getName().equals("skuId"));
            break; /* Loop/switch isn't completed */
        } else
        {
            MdotWebFragment mdotwebfragment = new MdotWebFragment();
            Bundle bundle = new Bundle();
            bundle.putString("mDotURL", (new StringBuilder()).append("http://www.bestbuy.com").append(s).toString());
            mdotwebfragment.setArguments(bundle);
            ((BaseTabContainer)m.getParentFragment()).a(mdotwebfragment, true);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = namevaluepair.getValue();
        ((HomeActivity)a).openPDP(s, "", true);
        return;
    }

    public void b()
    {
        if (k != null)
        {
            ll.a(k);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
        m = getParentFragment();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (l == null)
        {
            l = layoutinflater.inflate(0x7f030036, viewgroup, false);
            g = l.findViewById(0x7f0c0064);
            b = (BBYProductViewPager)l.findViewById(0x7f0c005e);
            b.setPageMargin(15);
            c = (BBYTextView)l.findViewById(0x7f0c00e2);
            j = (RelativeLayout)l.findViewById(0x7f0c00e3);
            j.setVisibility(8);
            k = (LinearLayout)viewgroup;
            a(o);
            a(false);
        } else
        {
            ((ViewGroup)l.getParent()).removeView(l);
        }
        return l;
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (n != null)
        {
            n.notifyDataSetChanged();
        }
    }
}
