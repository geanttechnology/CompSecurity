// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            EventInfoBuilder, DebugDataLayerEventEvaluationInfoBuilder, DebugMacroEvaluationInfoBuilder, DebugInformationHandler, 
//            DataLayerEventEvaluationInfoBuilder, MacroEvaluationInfoBuilder

class DebugEventInfoBuilder
    implements EventInfoBuilder
{

    private DebugDataLayerEventEvaluationInfoBuilder dataLayerEventBuilder;
    com.google.analytics.containertag.proto.MutableDebug.EventInfo eventInfoBuilder;
    private DebugInformationHandler handler;
    private DebugMacroEvaluationInfoBuilder macroBuilder;

    public DebugEventInfoBuilder(com.google.analytics.containertag.proto.MutableDebug.EventInfo.EventType eventtype, String s, String s1, String s2, DebugInformationHandler debuginformationhandler)
    {
        eventInfoBuilder = com.google.analytics.containertag.proto.MutableDebug.EventInfo.newMessage();
        eventInfoBuilder.setEventType(eventtype);
        eventInfoBuilder.setContainerVersion(s);
        eventInfoBuilder.setContainerId(s1);
        eventInfoBuilder.setKey(s2);
        handler = debuginformationhandler;
        if (eventtype.equals(com.google.analytics.containertag.proto.MutableDebug.EventInfo.EventType.DATA_LAYER_EVENT))
        {
            dataLayerEventBuilder = new DebugDataLayerEventEvaluationInfoBuilder(eventInfoBuilder.getMutableDataLayerEventResult());
            return;
        } else
        {
            macroBuilder = new DebugMacroEvaluationInfoBuilder(eventInfoBuilder.getMutableMacroResult());
            return;
        }
    }

    public DataLayerEventEvaluationInfoBuilder createDataLayerEventEvaluationInfoBuilder()
    {
        return dataLayerEventBuilder;
    }

    public MacroEvaluationInfoBuilder createMacroEvaluationInfoBuilder()
    {
        return macroBuilder;
    }

    public void processEventInfo()
    {
        handler.receiveEventInfo(eventInfoBuilder);
    }
}
