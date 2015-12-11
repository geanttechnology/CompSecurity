// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;

import android.graphics.Point;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.digimarc.dms.camerasettings:
//            Actions, Parameters, Rules

public class DMSActionsApplied
{

    protected final String CAMERA_CORRECTIONS_ACTION = "cameraCorrections";
    protected final String CAMERA_FOCUS_ACTION = "focus";
    protected final String CAMERA_PARAMETERS_ACTION = "cameraParameters";
    protected final String DEVICE_RESOLUTION_ACTION = "deviceResolution";
    public boolean cameraCorrection;
    public String cameraParameters[];
    public boolean isLimitedFocus;
    public Point resolution;
    private Rules rule;

    DMSActionsApplied(Rules rules)
    {
        boolean flag1 = true;
        super();
        resolution = null;
        rule = rules;
        rules = findAction("deviceResolution");
        boolean flag;
        if (rules != null)
        {
            try
            {
                int i = rules.getParameters().getHeightInt();
                resolution = new Point(rules.getParameters().getWidthInt(), i);
            }
            // Misplaced declaration of an exception variable
            catch (Rules rules)
            {
                resolution = new Point(1280, 720);
            }
        }
        rules = findAction("focus");
        if (rules != null)
        {
            if (rules.getParameters().getLimited().compareTo("yes") == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isLimitedFocus = flag;
        }
        rules = findAction("cameraCorrections");
        if (rules != null)
        {
            if (rules.getParameters().getPostProcessing().compareTo("yes") == 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            cameraCorrection = flag;
        }
        rules = findAction("cameraParameters");
        if (rules != null)
        {
            cameraParameters = getCameraParams(rules);
        }
    }

    private Actions findAction(String s)
    {
label0:
        {
            Object obj = rule.getActions();
            if (obj == null)
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            Actions actions;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                actions = (Actions)((Iterator) (obj)).next();
            } while (actions == null || actions.getAction().compareTo(s) != 0);
            return actions;
        }
        return null;
    }

    public String[] getCameraParameters()
    {
        return cameraParameters;
    }

    public String[] getCameraParams(Actions actions)
    {
        actions = actions.getParameters();
        if (actions != null)
        {
            actions = actions.getCameraSettings();
            if (actions != null)
            {
                return actions.split(" ");
            }
        }
        return null;
    }

    public Point getResolution()
    {
        return resolution;
    }

    public boolean isCameraCorrection()
    {
        return cameraCorrection;
    }

    public boolean isLimitedFocus()
    {
        return isLimitedFocus;
    }
}
