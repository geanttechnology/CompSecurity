// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.services.LocalDataService;
import com.aviary.android.feather.library.services.PreferenceService;
import com.aviary.android.feather.sdk.widget.VibrationWidget;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractPanel

abstract class AbstractOptionPanel extends AbstractPanel
    implements AbstractPanel.OptionPanel
{

    protected ViewGroup mOptionView;

    public AbstractOptionPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
    }

    protected transient void disableHapticIsNecessary(VibrationWidget avibrationwidget[])
    {
        boolean flag1 = true;
        if (!((LocalDataService)getContext().getService(com/aviary/android/feather/library/services/LocalDataService)).getIntentHasExtra("tools-vibration-disabled")) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        int j = avibrationwidget.length;
        for (int i = 0; i < j; i++)
        {
            avibrationwidget[i].setVibrationEnabled(flag);
        }

        break; /* Loop/switch isn't completed */
_L2:
        flag = flag1;
        if (getContext() != null)
        {
            flag = flag1;
            if (getContext().getBaseContext() != null)
            {
                PreferenceService preferenceservice = (PreferenceService)getContext().getService(com/aviary/android/feather/library/services/PreferenceService);
                flag = flag1;
                if (preferenceservice != null)
                {
                    flag = flag1;
                    if (PackageManagerUtils.isStandalone(getContext().getBaseContext()))
                    {
                        flag = preferenceservice.getStandaloneBoolean("feather_app_vibration", true);
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected abstract ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup);

    public volatile View getOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        return getOptionView(layoutinflater, viewgroup);
    }

    public final ViewGroup getOptionView()
    {
        return mOptionView;
    }

    public final ViewGroup getOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        mOptionView = generateOptionView(layoutinflater, viewgroup);
        return mOptionView;
    }

    protected void onDispose()
    {
        mOptionView = null;
        super.onDispose();
    }

    public void setEnabled(boolean flag)
    {
        getOptionView().setEnabled(flag);
        super.setEnabled(flag);
    }
}
