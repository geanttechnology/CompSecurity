// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;
import roboguice.util.Ln;

public class TimePickerPreference extends DialogPreference
    implements android.widget.TimePicker.OnTimeChangedListener
{

    private static final String VALIDATION_EXPRESSION = "[0-2]*[0-9]:[0-5]*[0-9]";
    private String defaultValue;
    private TimePicker tp;

    public TimePickerPreference(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initialize();
    }

    public TimePickerPreference(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        initialize();
    }

    public String getFormattedTime()
    {
        int i = getHour();
        int j = getMinute();
        String s;
        if (i > 11)
        {
            s = "pm";
        } else
        {
            s = "am";
        }
        return String.format("%d:%02d %s", new Object[] {
            Integer.valueOf((i - 1) % 12 + 1), Integer.valueOf(j), s
        });
    }

    protected int getHour()
    {
        String s = getPersistedString(defaultValue);
        if (!validate(s))
        {
            return -1;
        } else
        {
            return Integer.parseInt(s.split(":")[0]);
        }
    }

    protected int getMinute()
    {
        String s = getPersistedString(defaultValue);
        if (!validate(s))
        {
            return -1;
        } else
        {
            return Integer.parseInt(s.split(":")[1]);
        }
    }

    public String getTime()
    {
        return getPersistedString(defaultValue);
    }

    protected void initialize()
    {
        setPersistent(true);
    }

    protected View onCreateDialogView()
    {
        int i;
        tp = new TimePicker(getContext());
        tp.setOnTimeChangedListener(this);
        i = 0;
_L2:
        if (i >= 2)
        {
            break; /* Loop/switch isn't completed */
        }
        ((EditText)((ViewGroup)((ViewGroup)tp.getChildAt(0)).getChildAt(i)).getChildAt(1)).setTextColor(getContext().getResources().getColor(0x7f0e0031));
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        Ln.e(exception);
_L1:
        int j = getHour();
        int k = getMinute();
        if (j >= 0 && k >= 0)
        {
            tp.setCurrentHour(Integer.valueOf(j));
            tp.setCurrentMinute(Integer.valueOf(k));
        }
        return tp;
    }

    protected void onDialogClosed(boolean flag)
    {
        super.onDialogClosed(flag);
        if (flag)
        {
            persistString(String.format("%02d:%02d", new Object[] {
                tp.getCurrentHour(), tp.getCurrentMinute()
            }));
            callChangeListener(getFormattedTime());
        }
    }

    public void onTimeChanged(TimePicker timepicker, int i, int j)
    {
        j = Math.min(Math.max(6, i), 18);
        if (j != i)
        {
            timepicker.setCurrentHour(Integer.valueOf(j));
        }
    }

    public void setDefaultValue(Object obj)
    {
        super.setDefaultValue(obj);
        if (!(obj instanceof String) || !validate((String)obj))
        {
            return;
        } else
        {
            defaultValue = (String)obj;
            return;
        }
    }

    protected boolean validate(String s)
    {
        return s != null && s.matches("[0-2]*[0-9]:[0-5]*[0-9]");
    }
}
