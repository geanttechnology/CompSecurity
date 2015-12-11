// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.feature;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

// Referenced classes of package com.amazon.now.feature:
//            FeatureController

public class FeatureAdapter extends ArrayAdapter
{

    private Context mContext;

    public FeatureAdapter(Context context)
    {
        super(context, 0);
        mContext = context;
        super.addAll(FeatureController.Feature.values());
    }

    public View getView(int i, final View feature, ViewGroup viewgroup)
    {
        feature = (FeatureController.Feature)super.getItem(i);
        final Switch featureSwitch = feature.name();
        boolean flag = FeatureController.getInstance().isFeatureEnabled(feature);
        viewgroup = LayoutInflater.from(mContext).inflate(0x7f03000b, viewgroup, false);
        ((TextView)viewgroup.findViewById(0x7f0e0057)).setText(featureSwitch);
        featureSwitch = (Switch)viewgroup.findViewById(0x7f0e0059);
        Button button = (Button)viewgroup.findViewById(0x7f0e0058);
        featureSwitch.setChecked(flag);
        featureSwitch.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final FeatureAdapter this$0;
            final FeatureController.Feature val$feature;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag1)
            {
                FeatureController.getInstance().setFeatureOverride(feature, flag1);
            }

            
            {
                this$0 = FeatureAdapter.this;
                feature = feature1;
                super();
            }
        });
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final FeatureAdapter this$0;
            final FeatureController.Feature val$feature;
            final Switch val$featureSwitch;

            public void onClick(View view)
            {
                FeatureController.getInstance().clearFeatureOverride(feature);
                featureSwitch.setChecked(FeatureController.getInstance().isFeatureEnabled(feature));
                FeatureController.getInstance().clearFeatureOverride(feature);
                Toast.makeText(mContext, 0x7f0700b5, 0).show();
            }

            
            {
                this$0 = FeatureAdapter.this;
                feature = feature1;
                featureSwitch = switch1;
                super();
            }
        });
        return viewgroup;
    }

}
