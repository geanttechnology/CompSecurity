// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Date;

public class InAppMessage
{

    public String context;
    public Date endAt;
    public String message;
    public Date modificationDate;
    public Long primaryKey;
    public boolean read;
    public String remoteId;
    public Date startAt;
    public String target;
    public long timestamp;
    public String title;
    public boolean viewed;

    public InAppMessage()
    {
        context = "";
        title = "";
        message = "";
        target = "";
        startAt = null;
        endAt = null;
        timestamp = 0L;
        viewed = false;
        read = false;
    }
}
