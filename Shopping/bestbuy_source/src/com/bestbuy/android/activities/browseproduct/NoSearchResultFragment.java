// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;

public class NoSearchResultFragment extends BBYBaseFragment
{

    private View a;
    private String b;
    private String c;

    public NoSearchResultFragment()
    {
        b = "";
        c = "&#8226 \t Try using fewer or less-specific keywords.<br/> &#8226 \t Double-check your spelling.<br/> &#8226 \t Make sure to add spaces between words.";
    }

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
        a = layoutinflater.inflate(0x7f030082, viewgroup, false);
        layoutinflater = getArguments();
        if (layoutinflater != null)
        {
            b = layoutinflater.getString("Query");
        }
        ((BBYTextView)a.findViewById(0x7f0c0131)).setText((new StringBuilder()).append("We couldn't find any matches for: \n \"").append(b).append("\"").toString());
        ((BBYTextView)a.findViewById(0x7f0c0132)).setText(Html.fromHtml(c));
        return a;
    }
}
