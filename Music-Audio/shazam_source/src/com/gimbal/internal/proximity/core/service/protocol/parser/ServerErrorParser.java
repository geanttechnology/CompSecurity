// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.protocol.parser;

import com.gimbal.internal.proximity.core.service.protocol.ServerError;

public interface ServerErrorParser
{

    public abstract ServerError parse(String s);
}
