// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.inappmessage;


// Referenced classes of package com.groupon.models.inappmessage:
//            InAppMessage, ActionState, ViewState

static class me
{

    static final int $SwitchMap$com$groupon$models$inappmessage$ActionState[];
    static final int $SwitchMap$com$groupon$models$inappmessage$ViewState[];
    static final int $SwitchMap$com$groupon$service$InAppMessageService$EventName[];

    static 
    {
        $SwitchMap$com$groupon$service$InAppMessageService$EventName = new int[com.groupon.service.vice.EventName.values().length];
        try
        {
            $SwitchMap$com$groupon$service$InAppMessageService$EventName[com.groupon.service.vice.EventName.VIEWED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$groupon$service$InAppMessageService$EventName[com.groupon.service.vice.EventName.CLICKED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$groupon$service$InAppMessageService$EventName[com.groupon.service.vice.EventName.DISMISSED.ordinal()] = 3;
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
