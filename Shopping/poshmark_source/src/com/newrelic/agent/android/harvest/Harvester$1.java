// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;


// Referenced classes of package com.newrelic.agent.android.harvest:
//            Harvester

static class nse.Code
{

    static final int $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[];
    static final int $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[];

    static 
    {
        $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State = new int[ate.values().length];
        try
        {
            $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[ate.UNINITIALIZED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[ate.DISCONNECTED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[ate.CONNECTED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[ate.DISABLED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code = new int[nse.Code.values().length];
        try
        {
            $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[nse.Code.UNAUTHORIZED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[nse.Code.INVALID_AGENT_ID.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[nse.Code.FORBIDDEN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[nse.Code.UNSUPPORTED_MEDIA_TYPE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[nse.Code.ENTITY_TOO_LARGE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
