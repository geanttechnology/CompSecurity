// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseTestUtils

static final class PushResult
    implements stener
{

    public void onPushHandled(JSONObject jsonobject, PushResult pushresult)
    {
        if (pushresult != PushResult.INVOKED_PARSE_PUSH_BROADCAST_RECEIVER && pushresult != PushResult.SHOW_NOTIFICATION && pushresult != PushResult.SHOW_NOTIFICATION_AND_BROADCAST_INTENT)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        ParseTestUtils.access$208();
        com/parse/ParseTestUtils;
        JVM INSTR monitorenter ;
        pushresult = ParseTestUtils.access$300();
        com/parse/ParseTestUtils;
        JVM INSTR monitorexit ;
        if (pushresult != null)
        {
            pushresult.onPushRouted(jsonobject);
        }
        return;
        jsonobject;
        com/parse/ParseTestUtils;
        JVM INSTR monitorexit ;
        throw jsonobject;
    }

    PushResult()
    {
    }
}
