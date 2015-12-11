// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import org.apache.http.HttpEntity;

interface XMLParserInterface
{

    public abstract void errorHandler(int i);

    public abstract void parse(HttpEntity httpentity);
}
