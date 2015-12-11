// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack;


// Referenced classes of package org.msgpack:
//            MessagePackObject

public class UnpackResult
{

    protected MessagePackObject data;
    protected boolean finished;

    public UnpackResult()
    {
        finished = false;
        data = null;
    }

    void done(MessagePackObject messagepackobject)
    {
        finished = true;
        data = messagepackobject;
    }
}
