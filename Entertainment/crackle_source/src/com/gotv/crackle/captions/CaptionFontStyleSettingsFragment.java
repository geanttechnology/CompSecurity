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
import com.gotv.crackle.captions.model.CaptionFont;
import com.gotv.crackle.captions.model.CaptionSettings;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.gotv.crackle.captions:
//            CaptionSettingsFragment

public class CaptionFontStyleSettingsFragment extends CaptionSettingsFragment
{

    public CaptionFontStyleSettingsFragment()
    {
    }

    public String getFragmentTitle()
    {
        return Application.getInstance().getString(0x7f0b014f);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (CaptionCheckRow)view;
        view = (String)adapterview.getTitleView().getText();
        Iterator iterator = CaptionSettings.getCaptionFontList().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            CaptionFont captionfont = (CaptionFont)iterator.next();
            if (captionfont.getDisplayName().equals(view))
            {
                _captionSettings.setCaptionFont(captionfont);
                updatePreview();
            }
        } while (true);
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
        Iterator iterator = CaptionSettings.getCaptionFontList().iterator();
        while (iterator.hasNext()) 
        {
            CaptionFont captionfont = (CaptionFont)iterator.next();
            CaptionCheckRow captioncheckrow = new CaptionCheckRow(getActivity());
            captioncheckrow.getTitleView().setText(captionfont.getDisplayName());
            captioncheckrow.getTitleView().setTypeface(captionfont.getTypeface());
            if (captionfont.getDisplayName().equals(_captionSettings.getCaptionFont().getDisplayName()))
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
