// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYButton;
import ip;
import nb;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMListFragment

public class DNMSearchFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private static final String a = com/bestbuy/android/activities/dnm/DNMSearchFragment.getSimpleName();
    private Activity b;
    private View c;
    private ImageView g;
    private String h;
    private EditText i;
    private View j;
    private BBYButton k;
    private LinearLayout l;

    public DNMSearchFragment()
    {
    }

    public DNMSearchFragment(String s)
    {
        h = s;
    }

    static Activity a(DNMSearchFragment dnmsearchfragment)
    {
        return dnmsearchfragment.b;
    }

    static void a(DNMSearchFragment dnmsearchfragment, String s)
    {
        dnmsearchfragment.a(s);
    }

    private void a(String s)
    {
        (new ip(b, this, j, s, l)).executeOnExecutor(nb.h, new Void[0]);
    }

    static EditText b(DNMSearchFragment dnmsearchfragment)
    {
        return dnmsearchfragment.i;
    }

    public void a(String s, Address address)
    {
        s = new DNMListFragment(s, address.getLatitude(), address.getLongitude(), h);
        ((BaseFragmentContainer)getParentFragment()).a(s, true);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = ((BBYBaseFragmentActivity)b).getCurrentActionBarTitle();
        f.i(bundle);
        ((BBYBaseFragmentActivity)b).hideActionBarHomeAndSearchBox(b);
        if (h.equals(getString(0x7f08006c)))
        {
            ((BBYBaseFragmentActivity)b).updateActionBarTitle(getString(0x7f08006e));
            return;
        } else
        {
            ((BBYBaseFragmentActivity)b).updateActionBarTitle(getString(0x7f080038));
            return;
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 == 3333 && ((LocationManager)b.getSystemService("location")).isProviderEnabled("gps"))
        {
            intent = new DNMListFragment("current location", f.y(), f.z(), h);
            ((BaseFragmentContainer)getParentFragment()).a(intent, false);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        b = activity;
    }

    public void onClick(View view)
    {
        if (view == k)
        {
            view = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            b.startActivityForResult(view, 3333);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = layoutinflater.inflate(0x7f030032, viewgroup, false);
        j = c.findViewById(0x7f0c0064);
        i = (EditText)c.findViewById(0x7f0c00c6);
        g = (ImageView)c.findViewById(0x7f0c00da);
        l = (LinearLayout)c.findViewById(0x7f0c00c0);
        k = (BBYButton)c.findViewById(0x7f0c0037);
        k.setOnClickListener(this);
        if (h.equals("OpenBox"))
        {
            g.setImageResource(0x7f020043);
        } else
        {
            g.setImageResource(0x7f020042);
        }
        i.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final DNMSearchFragment a;

            public boolean onEditorAction(TextView textview, int i1, KeyEvent keyevent)
            {
                if (i1 == 3)
                {
                    ((InputMethodManager)DNMSearchFragment.a(a).getSystemService("input_method")).hideSoftInputFromWindow(DNMSearchFragment.b(a).getWindowToken(), 0);
                    textview = DNMSearchFragment.b(a).getText().toString();
                    if (textview != null && !textview.isEmpty())
                    {
                        DNMSearchFragment.a(a, textview);
                    }
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = DNMSearchFragment.this;
                super();
            }
        });
        return c;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
    }

}
