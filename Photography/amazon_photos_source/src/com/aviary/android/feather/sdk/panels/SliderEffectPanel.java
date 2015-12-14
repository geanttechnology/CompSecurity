// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.sdk.widget.AviarySeekBar;
import com.aviary.android.feather.sdk.widget.AviaryWheel;
import com.aviary.android.feather.sdk.widget.VibrationWidget;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractOptionPanel

public abstract class SliderEffectPanel extends AbstractOptionPanel
    implements android.view.View.OnClickListener, android.widget.SeekBar.OnSeekBarChangeListener, com.aviary.android.feather.sdk.widget.AviaryWheel.OnWheelChangeListener
{
    static final class SliderStyle extends Enum
    {

        private static final SliderStyle $VALUES[];
        public static final SliderStyle SeekBarStyle;
        public static final SliderStyle WheelStyle;

        public static SliderStyle valueOf(String s)
        {
            return (SliderStyle)Enum.valueOf(com/aviary/android/feather/sdk/panels/SliderEffectPanel$SliderStyle, s);
        }

        public static SliderStyle[] values()
        {
            return (SliderStyle[])$VALUES.clone();
        }

        static 
        {
            SeekBarStyle = new SliderStyle("SeekBarStyle", 0);
            WheelStyle = new SliderStyle("WheelStyle", 1);
            $VALUES = (new SliderStyle[] {
                SeekBarStyle, WheelStyle
            });
        }

        private SliderStyle(String s, int i)
        {
            super(s, i);
        }
    }


    View mButtonMinus;
    View mButtonPlus;
    String mResourceName;
    AviarySeekBar mSeekBar;
    private SliderStyle mStyle;
    AviaryWheel mWheel;

    public SliderEffectPanel(IAviaryController iaviarycontroller, ToolEntry toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools, String s)
    {
        super(iaviarycontroller, toolentry);
        mStyle = SliderStyle.WheelStyle;
        mFilter = ToolLoaderFactory.get(tools);
        mResourceName = s;
    }

    protected void decreaseValue()
    {
        if (mStyle == SliderStyle.SeekBarStyle)
        {
            mSeekBar.setProgress(mSeekBar.getProgress() - 1);
            return;
        } else
        {
            mWheel.setValue(mWheel.getValue() - 1);
            return;
        }
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        if (mStyle == SliderStyle.SeekBarStyle)
        {
            return (ViewGroup)layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_panel_seekbar, viewgroup, false);
        } else
        {
            return (ViewGroup)layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_panel_wheel, viewgroup, false);
        }
    }

    protected void increaseValue()
    {
        if (mStyle == SliderStyle.SeekBarStyle)
        {
            mSeekBar.setProgress(mSeekBar.getProgress() + 1);
            return;
        } else
        {
            mWheel.setValue(mWheel.getValue() + 1);
            return;
        }
    }

    public void onActivate()
    {
        super.onActivate();
        mButtonMinus.setOnClickListener(this);
        mButtonPlus.setOnClickListener(this);
        if (mStyle == SliderStyle.SeekBarStyle)
        {
            mSeekBar.setOnSeekBarChangeListener(this);
            return;
        } else
        {
            mWheel.setOnWheelChangeListener(this);
            disableHapticIsNecessary(new VibrationWidget[] {
                mWheel
            });
            return;
        }
    }

    public void onClick(View view)
    {
        int i = view.getId();
        if (i == mButtonMinus.getId())
        {
            decreaseValue();
        } else
        if (i == mButtonPlus.getId())
        {
            increaseValue();
            return;
        }
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        mButtonMinus = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button_minus);
        mButtonPlus = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button_plus);
        if (mStyle == SliderStyle.SeekBarStyle)
        {
            mSeekBar = (AviarySeekBar)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_seekbar);
            mSeekBar.setProgress(50);
            return;
        } else
        {
            mWheel = (AviaryWheel)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_wheel);
            mWheel.setValue(50);
            return;
        }
    }

    public void onDeactivate()
    {
        super.onDeactivate();
        mButtonMinus.setOnClickListener(null);
        mButtonPlus.setOnClickListener(null);
        if (mStyle == SliderStyle.SeekBarStyle)
        {
            mSeekBar.setOnSeekBarChangeListener(null);
            return;
        } else
        {
            mWheel.setOnWheelChangeListener(this);
            return;
        }
    }

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        onSliderChanged(i, flag);
    }

    protected abstract void onSliderChanged(int i, boolean flag);

    protected abstract void onSliderEnd(int i);

    protected abstract void onSliderStart(int i);

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
        onSliderStart(seekbar.getProgress());
    }

    public final void onStartTrackingTouch(AviaryWheel aviarywheel)
    {
        onSliderStart(aviarywheel.getValue());
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        onSliderEnd(seekbar.getProgress());
    }

    public void onStopTrackingTouch(AviaryWheel aviarywheel)
    {
        onSliderEnd(aviarywheel.getValue());
    }

    public final void onValueChanged(AviaryWheel aviarywheel, int i)
    {
        onSliderChanged(i, true);
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }

    protected void setValue(int i)
    {
        if (mStyle == SliderStyle.SeekBarStyle)
        {
            mSeekBar.setProgress(i);
            return;
        } else
        {
            mWheel.setValue(i);
            return;
        }
    }
}
