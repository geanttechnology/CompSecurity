// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events;


// Referenced classes of package com.rdio.android.core.events:
//            RequesterEvent

public class ModelLoaderErrorEvent extends RequesterEvent
{

    private String message;
    private Object responsibleEvent;

    public ModelLoaderErrorEvent(String s, Object obj, Object obj1, Object obj2)
    {
        super(obj1, obj2);
        message = s;
        responsibleEvent = obj;
    }

    public String getMessage()
    {
        return message;
    }

    public Object getResponsibleEvent()
    {
        return responsibleEvent;
    }
}
