// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.adview;

import android.graphics.Color;
import com.apprupt.sdk.CvViewHelper;
import com.apprupt.sdk.JSONHelper;
import com.apprupt.sdk.Logger;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk.adview:
//            ResizeProperties, CloseButtonPosition

public class ExpandProperties extends ResizeProperties
{

    private int backgroundColor;

    public ExpandProperties()
    {
        backgroundColor = Color.argb(179, 0, 0, 0);
    }

    public String getBackgroundColor()
    {
        return String.format("rgba(%d,%d,%d,%f)", new Object[] {
            Integer.valueOf(Color.red(backgroundColor)), Integer.valueOf(Color.green(backgroundColor)), Integer.valueOf(Color.blue(backgroundColor)), Float.valueOf((float)Color.alpha(backgroundColor) / 255F)
        });
    }

    public int getBackgroundColorInt()
    {
        return backgroundColor;
    }

    public boolean getUseCustomClose()
    {
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (customClosePosition == CloseButtonPosition.HIDDEN)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setBackgroundColor(String s)
    {
        if (s == null || s.length() == 0)
        {
            return;
        }
        try
        {
            backgroundColor = CvViewHelper.parseColor(s);
            Logger.get("COLOR").e(new Object[] {
                "expand color set to", s, getBackgroundColor(), Integer.valueOf(backgroundColor)
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void setBackgroundColorInt(int i)
    {
        backgroundColor = i;
        Logger.get("COLOR").e(new Object[] {
            "expand color set to", getBackgroundColor(), Integer.valueOf(backgroundColor)
        });
    }

    public void setUseCustomClose(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        CloseButtonPosition closebuttonposition = CloseButtonPosition.HIDDEN;
_L2:
        customClosePosition = closebuttonposition;
        this;
        JVM INSTR monitorexit ;
        return;
        closebuttonposition = CloseButtonPosition.TOP_RIGHT;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public JSONObject toJSON()
    {
        this;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = new JSONObject();
        Exception exception;
        try
        {
            jsonobject.put("width", getWidth());
            jsonobject.put("height", getHeight());
            jsonobject.put("useCustomClose", getUseCustomClose());
            jsonobject.put("backgroundColor", getBackgroundColor());
            jsonobject.put("isModal", true);
        }
        catch (Exception exception1) { }
        this;
        JVM INSTR monitorexit ;
        return jsonobject;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void update(JSONHelper jsonhelper)
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        boolean flag;
        super.update(jsonhelper);
        flag = jsonhelper.getBoolean("useCustomClose", getUseCustomClose());
        s = jsonhelper.getString("backgroundColor", null);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        jsonhelper = CloseButtonPosition.HIDDEN;
_L2:
        customClosePosition = jsonhelper;
        setBackgroundColor(s);
        this;
        JVM INSTR monitorexit ;
        return;
        jsonhelper = CloseButtonPosition.TOP_RIGHT;
        if (true) goto _L2; else goto _L1
_L1:
        jsonhelper;
        this;
        JVM INSTR monitorexit ;
        throw jsonhelper;
    }
}
