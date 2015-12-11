// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.contactdetails;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.base.BBYBaseFragment;

public class ContactBestBuyFragment extends BBYBaseFragment
{

    private Activity a;

    public ContactBestBuyFragment()
    {
    }

    static Activity a(ContactBestBuyFragment contactbestbuyfragment)
    {
        return contactbestbuyfragment.a;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030025, viewgroup, false);
        layoutinflater.findViewById(0x7f0c00a6).setOnClickListener(new android.view.View.OnClickListener() {

            final ContactBestBuyFragment a;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.SEND");
                view.setType("text/html");
                view.putExtra("android.intent.extra.EMAIL", new String[] {
                    "onlinestore@bestbuy.com"
                });
                try
                {
                    view.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append("Best Buy Mobile App Feedback (").append(ContactBestBuyFragment.a(a).getPackageManager().getPackageInfo(ContactBestBuyFragment.a(a).getPackageName(), 0).versionName).append(")").toString());
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                {
                    namenotfoundexception.printStackTrace();
                }
                view.putExtra("android.intent.extra.TEXT", "");
                ContactBestBuyFragment.a(a).startActivity(Intent.createChooser(view, ""));
            }

            
            {
                a = ContactBestBuyFragment.this;
                super();
            }
        });
        return layoutinflater;
    }
}
