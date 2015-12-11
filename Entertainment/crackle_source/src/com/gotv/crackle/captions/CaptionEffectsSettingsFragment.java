// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.captions.listrows.CaptionCheckRow;
import com.gotv.crackle.captions.model.CaptionSettings;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.gotv.crackle.captions:
//            CaptionSettingsFragment

public class CaptionEffectsSettingsFragment extends CaptionSettingsFragment
{

    public CaptionEffectsSettingsFragment()
    {
    }

    public String getFragmentTitle()
    {
        return Application.getInstance().getString(0x7f0b0150);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (CaptionCheckRow)view;
        view = (String)adapterview.getTitleView().getText();
        _captionSettings.setCaptionEffects(CaptionSettings.getCaptionEffectForString(view));
        updatePreview();
        i = 0;
        while (i < _listAdapter.getCount()) 
        {
            view = (CaptionCheckRow)_listAdapter.getItem(i);
            if (view == adapterview)
            {
                view.getCheckBox().setChecked(true);
            } else
            {
                view.getCheckBox().setChecked(false);
            }
            i++;
        }
    }

    protected void setAdapterRows()
    {
        Iterator iterator = CaptionSettings.getCaptionEffectList().iterator();
        while (iterator.hasNext()) 
        {
            com.gotv.crackle.captions.model.CaptionSettings.CaptionEffects captioneffects = (com.gotv.crackle.captions.model.CaptionSettings.CaptionEffects)iterator.next();
            CaptionCheckRow captioncheckrow = new CaptionCheckRow(getActivity());
            captioncheckrow.getTitleView().setText(CaptionSettings.getStringForCaptionEffect(captioneffects));
            if (captioneffects == _captionSettings.getCaptionEffects())
            {
                captioncheckrow.getCheckBox().setChecked(true);
            } else
            {
                captioncheckrow.getCheckBox().setChecked(false);
            }
            _listAdapter.add(captioncheckrow);
        }
    }
}
