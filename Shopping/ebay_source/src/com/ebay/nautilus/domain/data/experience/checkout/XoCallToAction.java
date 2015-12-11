// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout;

import com.ebay.nautilus.domain.data.experience.type.base.Action;
import com.ebay.nautilus.domain.data.experience.type.base.ActionType;
import com.ebay.nautilus.domain.data.experience.type.base.Tracking;
import java.util.Map;

public class XoCallToAction
{

    public String accessibilityText;
    public Action action;
    public Map attributes;
    public String description;
    public boolean enabled;
    public String text;

    public XoCallToAction()
    {
    }

    public ActionType getActionType()
    {
        if (action != null && action.type != null)
        {
            return action.type;
        } else
        {
            return ActionType.UNKNOWN;
        }
    }

    public Tracking getTracking()
    {
        if (action != null)
        {
            return action.tracking;
        } else
        {
            return null;
        }
    }

    public String getUrl()
    {
        if (action != null)
        {
            return action.url;
        } else
        {
            return null;
        }
    }
}
