// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.common;

import android.content.Context;
import android.view.View;

class a
    implements android.widget.TabHost.TabContentFactory
{

    private final Context a;

    public a(Context context)
    {
        a = context;
    }

    public View createTabContent(String s)
    {
        s = new View(a);
        s.setMinimumWidth(0);
        s.setMinimumHeight(0);
        return s;
    }
}
