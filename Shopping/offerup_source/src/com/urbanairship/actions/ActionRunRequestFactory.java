// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;


// Referenced classes of package com.urbanairship.actions:
//            ActionRunRequest

public class ActionRunRequestFactory
{

    public ActionRunRequestFactory()
    {
    }

    public ActionRunRequest createActionRequest(String s)
    {
        return ActionRunRequest.createRequest(s);
    }
}
