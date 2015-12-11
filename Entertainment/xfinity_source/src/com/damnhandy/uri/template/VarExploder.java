// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template;

import java.util.Collection;
import java.util.Map;

public interface VarExploder
{

    public abstract Map getNameValuePairs();

    public abstract Collection getValues();
}
