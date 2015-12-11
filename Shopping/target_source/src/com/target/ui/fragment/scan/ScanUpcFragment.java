// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.scan;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import b.a.a.b.a;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.helper.j.c;
import com.target.ui.model.scan.ScanResultItem;
import com.target.ui.util.al;
import com.target.ui.view.scan.ScanSummaryView;

// Referenced classes of package com.target.ui.fragment.scan:
//            BaseScanFragment

public class ScanUpcFragment extends BaseScanFragment
    implements b.a.a.b.c.a, com.target.ui.helper.j.c.b, com.target.ui.view.scan.ScanSummaryView.a
{
    public static interface a
    {

        public abstract void a(ProductDetails productdetails);
    }


    private static final String TAG = com/target/ui/fragment/scan/ScanUpcFragment.getSimpleName();
    private View mScanFrame;
    private c mScanHelper;
    private a mScanResultListener;
    private ScanSummaryView mScanSummaryView;

    public ScanUpcFragment()
    {
    }

    private void a(View view)
    {
        view.findViewById(0x7f100203).bringToFront();
    }

    public static ScanUpcFragment b(Fragment fragment)
    {
        ScanUpcFragment scanupcfragment = new ScanUpcFragment();
        scanupcfragment.setTargetFragment(fragment, 0);
        return scanupcfragment;
    }

    protected void a()
    {
        super.a();
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)b().getLayoutParams();
        int i = (int)getResources().getDimension(0x7f0a02a2);
        al.a(b(), marginlayoutparams.leftMargin, i, marginlayoutparams.rightMargin, marginlayoutparams.bottomMargin);
    }

    public void a(ProductDetails productdetails)
    {
        if (mScanResultListener == null)
        {
            return;
        } else
        {
            mScanResultListener.a(productdetails);
            return;
        }
    }

    public void a(ScanResultItem scanresultitem)
    {
        mScanSummaryView.a(scanresultitem);
    }

    public void a(ScanResultItem scanresultitem, String s)
    {
        mScanSummaryView.a(scanresultitem, s);
    }

    protected void a(String s)
    {
        Object obj = RingtoneManager.getDefaultUri(2);
        obj = RingtoneManager.getRingtone(getActivity().getApplicationContext(), ((android.net.Uri) (obj)));
        if (obj != null)
        {
            ((Ringtone) (obj)).play();
        }
        s = mScanSummaryView.a(s);
        mScanHelper.a(s);
        a();
    }

    public void b(ScanResultItem scanresultitem)
    {
        mScanSummaryView.b(scanresultitem);
        scanresultitem = mScanSummaryView.getScanResultItems();
        mScanHelper.a(scanresultitem);
    }

    public void c()
    {
        getActivity().onBackPressed();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mScanResultListener = (a)getTargetFragment();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mScanHelper = new c(this);
    }

    public Animation onCreateAnimation(int i, boolean flag, int j)
    {
        if (j == 0)
        {
            b().setVisibility(0);
            return null;
        } else
        {
            Animation animation = AnimationUtils.loadAnimation(getActivity(), j);
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final ScanUpcFragment this$0;

                public void onAnimationEnd(Animation animation1)
                {
                    b().setVisibility(0);
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

            
            {
                this$0 = ScanUpcFragment.this;
                super();
            }
            });
            return animation;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        j(getActivity().getApplicationContext().getString(0x7f0904dd));
        layoutinflater = layoutinflater.inflate(0x7f03007c, viewgroup, false);
        ((RelativeLayout)layoutinflater.findViewById(0x7f100202)).addView(b());
        mScanFrame = layoutinflater.findViewById(0x7f100202);
        mScanSummaryView = (ScanSummaryView)layoutinflater.findViewById(0x7f100203);
        mScanSummaryView.setScanListener(this);
        a(new b.a.a.b.a[] {
            b.a.a.b.a.f, b.a.a.b.a.g
        });
        a(layoutinflater);
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        mScanResultListener = null;
        mScanHelper.a();
    }

    public void onPause()
    {
        super.onPause();
        al.d(mScanFrame);
    }

    public void onResume()
    {
        super.onResume();
        al.b(mScanFrame);
    }

}
