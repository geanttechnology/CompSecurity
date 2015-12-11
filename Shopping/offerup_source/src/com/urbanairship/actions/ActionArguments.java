// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.os.Bundle;

// Referenced classes of package com.urbanairship.actions:
//            Situation, ActionValue

public final class ActionArguments
{

    public static final String PUSH_MESSAGE_METADATA = "com.urbanairship.PUSH_MESSAGE";
    public static final String REGISTRY_ACTION_NAME_METADATA = "com.urbanairship.REGISTRY_ACTION_NAME";
    public static final String RICH_PUSH_ID_METADATA = "com.urbanairship.RICH_PUSH_ID_METADATA";
    private final Bundle metadata;
    private final Situation situation;
    private final ActionValue value;

    public ActionArguments(Situation situation1, ActionValue actionvalue, Bundle bundle)
    {
        Situation situation2 = situation1;
        if (situation1 == null)
        {
            situation2 = Situation.MANUAL_INVOCATION;
        }
        situation = situation2;
        situation1 = actionvalue;
        if (actionvalue == null)
        {
            situation1 = new ActionValue();
        }
        value = situation1;
        if (bundle == null)
        {
            situation1 = new Bundle();
        } else
        {
            situation1 = new Bundle(bundle);
        }
        metadata = situation1;
    }

    public final Bundle getMetadata()
    {
        return metadata;
    }

    public final Situation getSituation()
    {
        return situation;
    }

    public final ActionValue getValue()
    {
        return value;
    }

    public final String toString()
    {
        return (new StringBuilder("ActionArguments { situation: ")).append(situation).append(", value: ").append(value).append(", metadata: ").append(metadata).append(" }").toString();
    }
}
