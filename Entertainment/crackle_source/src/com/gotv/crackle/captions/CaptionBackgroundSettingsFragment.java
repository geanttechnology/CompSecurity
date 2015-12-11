// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions;

import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.captions.listrows.CaptionColorRow;
import com.gotv.crackle.captions.listrows.CaptionColorRowItem;
import com.gotv.crackle.captions.listrows.CaptionTransparencyRow;
import com.gotv.crackle.captions.model.CaptionColor;
import com.gotv.crackle.captions.model.CaptionSettings;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.gotv.crackle.captions:
//            CaptionSettingsFragment

public class CaptionBackgroundSettingsFragment extends CaptionSettingsFragment
    implements com.gotv.crackle.captions.listrows.CaptionColorRow.CaptionColorRowSelectionChangeListener, android.widget.SeekBar.OnSeekBarChangeListener
{

    private CaptionColorRow _colorRow;
    private CaptionTransparencyRow _transparencyRow;

    public CaptionBackgroundSettingsFragment()
    {
    }

    public void OnColorChanged(CaptionColorRow captioncolorrow, CaptionColorRowItem captioncolorrowitem)
    {
        _captionSettings.setCharacterBackgroundColor(captioncolorrowitem.getCaptionColor());
        updatePreview();
    }

    public String getFragmentTitle()
    {
        return Application.getInstance().getString(0x7f0b014e);
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (!flag)
        {
            return;
        } else
        {
            double d = (double)i / 100D;
            _captionSettings.setCharacterBackgroundTransparency((int)Math.round(d * 255D));
            updatePreview();
            return;
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    protected void setAdapterRows()
    {
        _colorRow = new CaptionColorRow(getActivity());
        _colorRow.getTitleView().setText(getString(0x7f0b0152));
        CaptionColorRowItem captioncolorrowitem = null;
        CaptionColorRowItem captioncolorrowitem1;
        for (Iterator iterator = CaptionSettings.getTextColors().iterator(); iterator.hasNext(); _colorRow.addColorItem(captioncolorrowitem1))
        {
            CaptionColor captioncolor = (CaptionColor)iterator.next();
            captioncolorrowitem1 = new CaptionColorRowItem(getActivity(), captioncolor);
            if (captioncolor.getColor() == _captionSettings.getCharacterBackgroundColor().getColor())
            {
                captioncolorrowitem = captioncolorrowitem1;
            }
        }

        if (captioncolorrowitem != null)
        {
            _colorRow.setSelectedItem(captioncolorrowitem);
        }
        _listAdapter.add(_colorRow);
        _colorRow.setSelectionChangeListener(this);
        _transparencyRow = new CaptionTransparencyRow(getActivity(), false);
        _transparencyRow.getTitleView().setText(getString(0x7f0b0153));
        _listAdapter.add(_transparencyRow);
        _transparencyRow.getSeekBar().setOnSeekBarChangeListener(this);
        double d = (double)(_captionSettings.getCharacterBackgroundTransparency() + 0) / 255D;
        _transparencyRow.getSeekBar().setProgress((int)Math.round(d * 100D));
    }
}
