// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.adview;

import com.apprupt.sdk.JSONHelper;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk.adview:
//            Orientation

public class OrientationProperties
{

    private boolean allowOrientationChange;
    private Orientation forceOrientation;

    public OrientationProperties()
    {
        allowOrientationChange = true;
        forceOrientation = Orientation.NONE;
    }

    public boolean getAllowOrientationChange()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = allowOrientationChange;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Orientation getForceOrientation()
    {
        this;
        JVM INSTR monitorenter ;
        Orientation orientation = forceOrientation;
        this;
        JVM INSTR monitorexit ;
        return orientation;
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
            jsonobject.put("allowOrientationChange", allowOrientationChange);
            jsonobject.put("forceOrientation", forceOrientation.toString());
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
        allowOrientationChange = jsonhelper.getBoolean("allowOrientationChange", allowOrientationChange);
        jsonhelper = jsonhelper.getString("forceOrientation", forceOrientation.toString());
        if (!jsonhelper.equals(Orientation.PORTRAIT.toString())) goto _L2; else goto _L1
_L1:
        forceOrientation = Orientation.PORTRAIT;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!jsonhelper.equals(Orientation.LANDSCAPE.toString()))
        {
            break MISSING_BLOCK_LABEL_81;
        }
        forceOrientation = Orientation.LANDSCAPE;
          goto _L3
        jsonhelper;
        this;
        JVM INSTR monitorexit ;
        throw jsonhelper;
        forceOrientation = Orientation.NONE;
          goto _L3
    }
}
