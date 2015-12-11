// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.inappmessage;

import com.groupon.service.InAppMessageService;
import java.util.ArrayList;

// Referenced classes of package com.groupon.models.inappmessage:
//            ViewState, ActionState, InAppMessageStateChangeListener

public class InAppMessage
{
    public static class List
    {

        public ArrayList inAppMessages;

        public List()
        {
        }
    }


    private String context;
    private String id;
    private String message;
    private InAppMessageStateChangeListener stateChangeListener;
    private ActionState status;
    private String target;
    private String title;
    private ViewState viewed;

    public InAppMessage()
    {
        viewed = ViewState.START;
        status = ActionState.START;
    }

    public static InAppMessage getNoOpModel()
    {
        InAppMessage inappmessage = new InAppMessage();
        inappmessage.status = ActionState.CLOSED;
        inappmessage.viewed = ViewState.CLOSED;
        inappmessage.id = "-1";
        return inappmessage;
    }

    public void dispose()
    {
        if (status == ActionState.START)
        {
            status = ActionState.DISMISSED;
            if (stateChangeListener != null)
            {
                stateChangeListener.onStateChanged(this, com.groupon.service.InAppMessageService.EventName.DISMISSED);
            }
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (InAppMessage)obj;
            if (!id.equals(((InAppMessage) (obj)).id))
            {
                return false;
            }
        }
        return true;
    }

    public String getContext()
    {
        return context;
    }

    public String getId()
    {
        return id;
    }

    public String getMessage()
    {
        return message;
    }

    public String getTarget()
    {
        return target;
    }

    public String getTitle()
    {
        return title;
    }

    public int hashCode()
    {
        return id.hashCode();
    }

    public boolean isEnabled()
    {
        return status == ActionState.START;
    }

    public void onClicked()
    {
        if (status == ActionState.START)
        {
            status = ActionState.CLICKED;
            if (stateChangeListener != null)
            {
                stateChangeListener.onStateChanged(this, com.groupon.service.InAppMessageService.EventName.CLICKED);
            }
        }
    }

    public void onDismissed()
    {
        if (status == ActionState.START)
        {
            status = ActionState.DISMISSED;
            if (stateChangeListener != null)
            {
                stateChangeListener.onStateChanged(this, com.groupon.service.InAppMessageService.EventName.DISMISSED);
            }
        }
    }

    public void onUpdateFailed(com.groupon.service.InAppMessageService.EventName eventname)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$models$inappmessage$ActionState[];
            static final int $SwitchMap$com$groupon$models$inappmessage$ViewState[];
            static final int $SwitchMap$com$groupon$service$InAppMessageService$EventName[];

            static 
            {
                $SwitchMap$com$groupon$service$InAppMessageService$EventName = new int[com.groupon.service.InAppMessageService.EventName.values().length];
                try
                {
                    $SwitchMap$com$groupon$service$InAppMessageService$EventName[com.groupon.service.InAppMessageService.EventName.VIEWED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$groupon$service$InAppMessageService$EventName[com.groupon.service.InAppMessageService.EventName.CLICKED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$groupon$service$InAppMessageService$EventName[com.groupon.service.InAppMessageService.EventName.DISMISSED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$groupon$models$inappmessage$ActionState = new int[ActionState.values().length];
                try
                {
                    $SwitchMap$com$groupon$models$inappmessage$ActionState[ActionState.START.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$models$inappmessage$ActionState[ActionState.CLICKED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$models$inappmessage$ActionState[ActionState.DISMISSED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$groupon$models$inappmessage$ViewState = new int[ViewState.values().length];
                try
                {
                    $SwitchMap$com$groupon$models$inappmessage$ViewState[ViewState.START.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$models$inappmessage$ViewState[ViewState.VIEWED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.service.InAppMessageService.EventName[eventname.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 55
    //                   3 73;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (viewed == ViewState.VIEWED)
        {
            viewed = ViewState.FAILED_VIEWED;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (status == ActionState.CLICKED)
        {
            status = ActionState.FAILED_CLICKED;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (status == ActionState.DISMISSED)
        {
            status = ActionState.FAILED_DISMISSED;
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onUpdateSuccess(com.groupon.service.InAppMessageService.EventName eventname)
    {
        switch (_cls1..SwitchMap.com.groupon.service.InAppMessageService.EventName[eventname.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            switch (_cls1..SwitchMap.com.groupon.models.inappmessage.ViewState[viewed.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
            case 2: // '\002'
                viewed = ViewState.CLOSED;
                break;
            }
            return;

        case 2: // '\002'
        case 3: // '\003'
            switch (_cls1..SwitchMap.com.groupon.models.inappmessage.ActionState[status.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
                status = ActionState.CLOSED;
                break;
            }
            break;
        }
    }

    public void onViewed()
    {
        if (viewed == ViewState.START)
        {
            viewed = ViewState.VIEWED;
            if (stateChangeListener != null)
            {
                stateChangeListener.onStateChanged(this, com.groupon.service.InAppMessageService.EventName.VIEWED);
            }
        }
    }

    public void setContext(String s)
    {
        context = s;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setMessage(String s)
    {
        message = s;
    }

    public void setServices(InAppMessageService inappmessageservice)
    {
        stateChangeListener = inappmessageservice;
    }

    public void setTarget(String s)
    {
        target = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void updateFrom(InAppMessage inappmessage)
    {
        status = inappmessage.status;
        viewed = inappmessage.viewed;
    }

    public void updateTo(InAppMessage inappmessage)
    {
        inappmessage.viewed = viewed;
        inappmessage.status = status;
    }
}
