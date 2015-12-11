// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import com.groupon.foundations.dialog.BaseDialogFragment;
import com.groupon.models.support.SupportInfo;
import com.groupon.service.core.SupportInfoService;

public class TermsConditionsFragment extends BaseDialogFragment
{
    public static interface TermsConditionsListener
    {

        public abstract void onTermsConditionsAccepted();
    }


    private TermsConditionsListener listener;
    private SupportInfoService supportInfoService;

    public TermsConditionsFragment()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            listener = (TermsConditionsListener)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement OnTermsAcceptedListener").toString());
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.getWindow().requestFeature(1);
        return bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f0300f2, viewgroup, false);
        bundle = (WebView)viewgroup.findViewById(0x7f1002bf);
        layoutinflater = supportInfoService.getSupportInfo().contents;
        String s = ((com.groupon.models.support.SupportInfo.Contents) (layoutinflater)).termsOfService;
        String s1 = ((com.groupon.models.support.SupportInfo.Contents) (layoutinflater)).privacyPolicy;
        if (((com.groupon.models.support.SupportInfo.Contents) (layoutinflater)).legalDisclosure != null)
        {
            layoutinflater = (new StringBuilder()).append("<style type=text/css>body{background-color:#eeeeee; padding:15px;}</style>").append(getString(0x7f08023f)).append(s).append(s1).append(((com.groupon.models.support.SupportInfo.Contents) (layoutinflater)).cookiePolicy).toString();
        } else
        {
            layoutinflater = (new StringBuilder()).append("<style type=text/css>body{background-color:#eeeeee; padding:15px;}</style>").append(getString(0x7f080240)).append(s).append(s1).toString();
        }
        bundle.loadDataWithBaseURL(null, layoutinflater, "text/html", "UTF-8", null);
        viewgroup.findViewById(0x7f1002c2).setOnClickListener(new android.view.View.OnClickListener() {

            final TermsConditionsFragment this$0;

            public void onClick(View view)
            {
                if (listener != null && isResumed())
                {
                    listener.onTermsConditionsAccepted();
                }
                getDialog().dismiss();
            }

            
            {
                this$0 = TermsConditionsFragment.this;
                super();
            }
        });
        return viewgroup;
    }

    public void onDestroy()
    {
        listener = null;
        super.onDestroy();
    }

    public void onDestroyView()
    {
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setOnDismissListener(null);
        }
        super.onDestroyView();
    }

}
