// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.captions.listrows.CaptionColorRow;
import com.gotv.crackle.captions.listrows.CaptionColorRowItem;
import com.gotv.crackle.captions.listrows.CaptionSizeRow;
import com.gotv.crackle.captions.listrows.CaptionTextRow;
import com.gotv.crackle.captions.listrows.CaptionTransparencyRow;
import com.gotv.crackle.captions.model.CaptionColor;
import com.gotv.crackle.captions.model.CaptionFont;
import com.gotv.crackle.captions.model.CaptionSettings;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.gotv.crackle.captions:
//            CaptionSettingsFragment, CaptionsActivity

public class CaptionMainSettingsFragment extends CaptionSettingsFragment
    implements com.gotv.crackle.captions.listrows.CaptionColorRow.CaptionColorRowSelectionChangeListener, android.widget.SeekBar.OnSeekBarChangeListener
{

    private CaptionTextRow _backgroundSettingsRow;
    private CaptionColorRow _colorRow;
    private CaptionTextRow _effectsRow;
    private CaptionSizeRow _sizeRow;
    private CaptionTextRow _styleSettingsRow;
    private CaptionTransparencyRow _transparencyRow;
    private CaptionTextRow _windowSettingsRow;

    public CaptionMainSettingsFragment()
    {
    }

    private void setValuesFromSettings()
    {
        double d = (double)(_captionSettings.getFontSize() - 10F) / 20D;
        _sizeRow.getSeekBar().setProgress((int)Math.round(d * 100D));
        d = (double)(_captionSettings.getTextTransparency() + 0) / 255D;
        _transparencyRow.getSeekBar().setProgress((int)Math.round(d * 100D));
        Object obj = null;
        Iterator iterator = CaptionSettings.getTextColors().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            CaptionColor captioncolor = (CaptionColor)iterator.next();
            CaptionColorRowItem captioncolorrowitem = new CaptionColorRowItem(getActivity(), captioncolor);
            if (captioncolor.getColor() == _captionSettings.getTextColor().getColor())
            {
                obj = captioncolorrowitem;
            }
        } while (true);
        if (obj != null)
        {
            _colorRow.setSelectedItem(((CaptionColorRowItem) (obj)));
        }
        obj = _captionSettings.getCaptionEffects();
        _effectsRow.getSubtitleView().setText(CaptionSettings.getStringForCaptionEffect(((com.gotv.crackle.captions.model.CaptionSettings.CaptionEffects) (obj))));
        _styleSettingsRow.getSubtitleView().setText(_captionSettings.getCaptionFont().getDisplayName());
    }

    public void OnColorChanged(CaptionColorRow captioncolorrow, CaptionColorRowItem captioncolorrowitem)
    {
        _captionSettings.setTextColor(captioncolorrowitem.getCaptionColor());
        updatePreview();
    }

    public String getFragmentTitle()
    {
        return Application.getInstance().getString(0x7f0b014c);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (view == _windowSettingsRow)
        {
            adapterview = new Intent(getActivity(), com/gotv/crackle/captions/CaptionsActivity);
            adapterview.putExtra("CAPTION_SETTINGS_MODE", (new StringBuilder()).append("").append(getIntForCaptionSettingsMode(CaptionSettingsFragment.CaptionSettingsMode.WindowSettings)).toString());
            startActivity(adapterview);
        } else
        {
            if (view == _backgroundSettingsRow)
            {
                adapterview = new Intent(getActivity(), com/gotv/crackle/captions/CaptionsActivity);
                adapterview.putExtra("CAPTION_SETTINGS_MODE", (new StringBuilder()).append("").append(getIntForCaptionSettingsMode(CaptionSettingsFragment.CaptionSettingsMode.CharacterBackground)).toString());
                startActivity(adapterview);
                return;
            }
            if (view == _styleSettingsRow)
            {
                adapterview = new Intent(getActivity(), com/gotv/crackle/captions/CaptionsActivity);
                adapterview.putExtra("CAPTION_SETTINGS_MODE", (new StringBuilder()).append("").append(getIntForCaptionSettingsMode(CaptionSettingsFragment.CaptionSettingsMode.FontStyle)).toString());
                startActivity(adapterview);
                return;
            }
            if (view == _effectsRow)
            {
                adapterview = new Intent(getActivity(), com/gotv/crackle/captions/CaptionsActivity);
                adapterview.putExtra("CAPTION_SETTINGS_MODE", (new StringBuilder()).append("").append(getIntForCaptionSettingsMode(CaptionSettingsFragment.CaptionSettingsMode.CaptionEffects)).toString());
                startActivity(adapterview);
                return;
            }
        }
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (!flag)
        {
            return;
        }
        if (seekbar != _transparencyRow.getSeekBar()) goto _L2; else goto _L1
_L1:
        double d = (double)i / 100D;
        _captionSettings.setTextTransparency((int)Math.round(0.0D + d * 255D));
_L4:
        updatePreview();
        return;
_L2:
        if (seekbar == _sizeRow.getSeekBar())
        {
            float f = (float)i / 100F;
            _captionSettings.setFontSize(10F + f * 20F);
            updatePreview();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onResume()
    {
        super.onResume();
        setValuesFromSettings();
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    public void reset()
    {
        super.reset();
        setValuesFromSettings();
    }

    protected void setAdapterRows()
    {
        _windowSettingsRow = new CaptionTextRow(getActivity());
        _windowSettingsRow.getTitleView().setText(0x7f0b014d);
        _windowSettingsRow.getSubtitleView().setText("");
        _listAdapter.add(_windowSettingsRow);
        _backgroundSettingsRow = new CaptionTextRow(getActivity());
        _backgroundSettingsRow.getTitleView().setText(0x7f0b014e);
        _backgroundSettingsRow.getSubtitleView().setText("");
        _listAdapter.add(_backgroundSettingsRow);
        _styleSettingsRow = new CaptionTextRow(getActivity());
        _styleSettingsRow.getTitleView().setText(0x7f0b014f);
        _styleSettingsRow.getSubtitleView().setText("");
        _listAdapter.add(_styleSettingsRow);
        _effectsRow = new CaptionTextRow(getActivity());
        _effectsRow.getTitleView().setText(0x7f0b0150);
        _effectsRow.getSubtitleView().setText("");
        _listAdapter.add(_effectsRow);
        _sizeRow = new CaptionSizeRow(getActivity(), false);
        _sizeRow.getTitleView().setText(0x7f0b0151);
        _sizeRow.getSeekBar().setOnSeekBarChangeListener(this);
        _sizeRow.getSmallTextView().setTextSize(10F);
        _sizeRow.getLargeTextView().setTextSize(30F);
        _listAdapter.add(_sizeRow);
        _colorRow = new CaptionColorRow(getActivity());
        _colorRow.getTitleView().setText(getString(0x7f0b0154));
        CaptionColor captioncolor;
        for (Iterator iterator = CaptionSettings.getTextColors().iterator(); iterator.hasNext(); _colorRow.addColorItem(new CaptionColorRowItem(getActivity(), captioncolor)))
        {
            captioncolor = (CaptionColor)iterator.next();
        }

        _listAdapter.add(_colorRow);
        _colorRow.setSelectionChangeListener(this);
        _transparencyRow = new CaptionTransparencyRow(getActivity(), false);
        _transparencyRow.getTitleView().setText(getString(0x7f0b0155));
        _listAdapter.add(_transparencyRow);
        _transparencyRow.getSeekBar().setOnSeekBarChangeListener(this);
        setValuesFromSettings();
    }
}
