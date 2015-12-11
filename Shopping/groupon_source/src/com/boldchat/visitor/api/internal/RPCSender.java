// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import java.util.Map;

// Referenced classes of package com.boldchat.visitor.api.internal:
//            ResultListener

public interface RPCSender
{

    public abstract void sendRPC(String s, Map map, ResultListener resultlistener);
}
