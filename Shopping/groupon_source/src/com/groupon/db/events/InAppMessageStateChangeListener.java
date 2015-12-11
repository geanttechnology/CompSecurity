// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.events;

import com.groupon.db.models.InAppMessage;

public interface InAppMessageStateChangeListener
{

    public abstract void onStateChanged(InAppMessage inappmessage, com.groupon.service.InAppMessageService.EventName eventname);
}
