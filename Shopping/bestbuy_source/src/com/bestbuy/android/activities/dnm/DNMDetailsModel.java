// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.bestbuy.android.base.BBYBaseFragmentActivity;

public class DNMDetailsModel extends BBYBaseFragmentActivity
{

    public DNMDetailsModel()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030101);
        getActionBar().setBackgroundDrawable(new ColorDrawable(0xff00385f));
        getActionBar().setTitle("");
        getActionBar().setHomeAsUpIndicator(0x7f020002);
        getActionBar().setDisplayShowHomeEnabled(false);
        Bundle bundle1 = getIntent().getExtras();
        bundle = "";
        Object obj = "";
        if (bundle1.containsKey("URL"))
        {
            bundle = bundle1.getString("URL");
        }
        if (bundle1.containsKey("DNM_TYPE"))
        {
            obj = bundle1.getString("DNM_TYPE");
        }
        bundle = new DNMDetailsModelFragment(bundle, ((String) (obj)));
        getActionBar().hide();
        obj = getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction) (obj)).add(0x7f0c0182, bundle, "DNMDetailsModelFragment");
        ((FragmentTransaction) (obj)).commit();
    }

    private class DNMDetailsModelFragment extends BBYBaseFragment
    {

        final DNMDetailsModel a;
        private String b;
        private String c;

        public void onActivityCreated(Bundle bundle)
        {
            super.onActivityCreated(bundle);
        }

        public void onAttach(Activity activity)
        {
            super.onAttach(activity);
            d = activity;
        }

        public void onCreate(Bundle bundle)
        {
            super.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            viewgroup = layoutinflater.inflate(0x7f030111, viewgroup, false);
            layoutinflater = (WebView)viewgroup.findViewById(0x7f0c00a2);
            bundle = System.getProperty("http.agent");
            layoutinflater.getSettings().setUserAgentString((new StringBuilder()).append(bundle).append("Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; google_sdk Build/JB_MR1.1) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30").toString());
            layoutinflater.getSettings().setJavaScriptEnabled(true);
            if (b.startsWith("file:///android_asset/"))
            {
                layoutinflater.loadUrl(b);
            }
            bundle = (BBYTextView)viewgroup.findViewById(0x7f0c0396);
            if (c.equals(getString(0x7f08006c)))
            {
                layoutinflater = getString(0x7f08006d);
            } else
            if (c.equals(getString(0x7f080077)))
            {
                layoutinflater = getString(0x7f080078);
            } else
            if (c.equals(getString(0x7f080075)))
            {
                layoutinflater = getString(0x7f080076);
            } else
            {
                layoutinflater = getString(0x7f080037);
            }
            bundle.setText(layoutinflater);
            ((ImageView)viewgroup.findViewById(0x7f0c00a1)).setOnClickListener(new android.view.View.OnClickListener() {

                final DNMDetailsModelFragment a;

                public void onClick(View view)
                {
                    a.getActivity().finish();
                    a.getActivity().overridePendingTransition(0x7f040005, 0x7f040008);
                }

                
                {
                    a = DNMDetailsModelFragment.this;
                    super();
                }
            });
            return viewgroup;
        }

        public DNMDetailsModelFragment(String s, String s1)
        {
            a = DNMDetailsModel.this;
            super();
            b = s;
            c = s1;
        }
    }

}
