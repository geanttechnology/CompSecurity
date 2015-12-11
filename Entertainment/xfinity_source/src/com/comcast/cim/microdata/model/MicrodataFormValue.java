// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.http.HttpMethod;
import java.util.List;

public interface MicrodataFormValue
{

    public abstract String getAction();

    public abstract List getFields();

    public abstract HttpMethod getMethod();

    public abstract String getTitle();
}
