// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            StoreActivity, PopPedagogiqueActivity

public class StoreCommonElementsFragment extends Fragment
{

    android.view.View.OnClickListener accepteCGVClickListener;
    StoreActivity activityMaster;
    protected Typeface tf;
    protected TextView uiTextAccepteCGV;

    public StoreCommonElementsFragment()
    {
        tf = AkApplication.getTypeFace();
        accepteCGVClickListener = new _cls1();
    }

    protected void initCommonShopElements(View view)
    {
        activityMaster = (StoreActivity)getActivity();
        uiTextAccepteCGV = (TextView)view.findViewById(0x7f0d029f);
        if (uiTextAccepteCGV != null)
        {
            uiTextAccepteCGV.setOnClickListener(accepteCGVClickListener);
            uiTextAccepteCGV.setTypeface(tf);
            uiTextAccepteCGV.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CGV"));
            activityMaster.addTextView(uiTextAccepteCGV);
        }
        activityMaster.updateTextViewsSize();
    }

    protected void showPopPedagogiqueActivity()
    {
        activityMaster.disableAdOneTime();
        Intent intent = new Intent(activityMaster, com/digidust/elokence/akinator/activities/PopPedagogiqueActivity);
        intent.putExtra("PostPedagogiqueActivityModeGz", true);
        startActivity(intent);
    }

    /* member class not found */
    class _cls1 {}

}
