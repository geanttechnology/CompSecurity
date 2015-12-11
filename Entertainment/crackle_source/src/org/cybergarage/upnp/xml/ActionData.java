// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.xml;

import org.cybergarage.upnp.control.ActionListener;
import org.cybergarage.upnp.control.ControlResponse;

// Referenced classes of package org.cybergarage.upnp.xml:
//            NodeData

public class ActionData extends NodeData
{

    private ActionListener actionListener;
    private ControlResponse ctrlRes;

    public ActionData()
    {
        actionListener = null;
        ctrlRes = null;
    }

    public ActionListener getActionListener()
    {
        return actionListener;
    }

    public ControlResponse getControlResponse()
    {
        return ctrlRes;
    }

    public void setActionListener(ActionListener actionlistener)
    {
        actionListener = actionlistener;
    }

    public void setControlResponse(ControlResponse controlresponse)
    {
        ctrlRes = controlresponse;
    }
}
