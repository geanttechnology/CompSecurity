// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Intent;
import android.widget.RemoteViewsService;
import com.groupon.factory.WidgetRemoteViewsFactory;

public class WidgetRemoteViewsService extends RemoteViewsService
{

    public WidgetRemoteViewsService()
    {
    }

    public android.widget.RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent)
    {
        return new WidgetRemoteViewsFactory(getApplicationContext(), intent);
    }
}
