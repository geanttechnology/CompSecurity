// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.adview;

import com.apprupt.sdk.JSONHelper;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk.adview:
//            CloseButtonPosition

public class ResizeProperties
{

    private boolean allowOffscreen;
    protected CloseButtonPosition customClosePosition;
    private int height;
    private int offsetX;
    private int offsetY;
    private int width;

    public ResizeProperties()
    {
        width = 0;
        height = 0;
        offsetX = 0;
        offsetY = 0;
        customClosePosition = CloseButtonPosition.TOP_RIGHT;
        allowOffscreen = true;
    }

    public boolean getAllowOffscreen()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = allowOffscreen;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public CloseButtonPosition getCustomClosePosition()
    {
        this;
        JVM INSTR monitorenter ;
        CloseButtonPosition closebuttonposition = customClosePosition;
        this;
        JVM INSTR monitorexit ;
        return closebuttonposition;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getHeight()
    {
        this;
        JVM INSTR monitorenter ;
        int i = height;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getOffsetX()
    {
        this;
        JVM INSTR monitorenter ;
        int i = offsetX;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getOffsetY()
    {
        this;
        JVM INSTR monitorenter ;
        int i = offsetY;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getWidth()
    {
        this;
        JVM INSTR monitorenter ;
        int i = width;
        this;
        JVM INSTR monitorexit ;
        return i;
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
            jsonobject.put("offsetX", getOffsetX());
            jsonobject.put("offsetY", getOffsetY());
            jsonobject.put("customClosePosition", getCustomClosePosition().toString());
            jsonobject.put("allowOffscreen", getAllowOffscreen());
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
        width = jsonhelper.getInt("width", width);
        height = jsonhelper.getInt("height", height);
        jsonhelper = jsonhelper.getString("customClosePosition", customClosePosition.toString());
        if (!jsonhelper.equals(CloseButtonPosition.TOP_LEFT.toString())) goto _L2; else goto _L1
_L1:
        customClosePosition = CloseButtonPosition.TOP_LEFT;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!jsonhelper.equals(CloseButtonPosition.TOP_CENTER.toString()))
        {
            break MISSING_BLOCK_LABEL_95;
        }
        customClosePosition = CloseButtonPosition.TOP_CENTER;
          goto _L3
        jsonhelper;
        this;
        JVM INSTR monitorexit ;
        throw jsonhelper;
label0:
        {
            if (!jsonhelper.equals(CloseButtonPosition.BOTTOM_RIGHT.toString()))
            {
                break label0;
            }
            customClosePosition = CloseButtonPosition.BOTTOM_RIGHT;
        }
          goto _L3
label1:
        {
            if (!jsonhelper.equals(CloseButtonPosition.BOTTOM_LEFT.toString()))
            {
                break label1;
            }
            customClosePosition = CloseButtonPosition.BOTTOM_LEFT;
        }
          goto _L3
label2:
        {
            if (!jsonhelper.equals(CloseButtonPosition.BOTTOM_CENTER.toString()))
            {
                break label2;
            }
            customClosePosition = CloseButtonPosition.BOTTOM_CENTER;
        }
          goto _L3
label3:
        {
            if (!jsonhelper.equals(CloseButtonPosition.CENTER.toString()))
            {
                break label3;
            }
            customClosePosition = CloseButtonPosition.CENTER;
        }
          goto _L3
        customClosePosition = CloseButtonPosition.TOP_RIGHT;
          goto _L3
    }
}
