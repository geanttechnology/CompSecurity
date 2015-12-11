// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.dataobject;

import java.util.List;

public interface ApiMetaData
{

    public abstract void setAckCode(int i);

    public abstract void setBuild(String s);

    public abstract void setErrors(List list);

    public abstract void setHostTime(long l);

    public abstract void setVersion(String s);
}
