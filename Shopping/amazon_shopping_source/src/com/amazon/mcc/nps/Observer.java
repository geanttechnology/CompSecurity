// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps;


// Referenced classes of package com.amazon.mcc.nps:
//            Topic, Message

public interface Observer
{

    public abstract void onUpdate(Topic topic, Message message);
}
