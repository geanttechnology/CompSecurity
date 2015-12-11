// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.tabs;

import android.content.Context;
import android.view.View;

public class DummyTabFactory
    implements android.widget.TabHost.TabContentFactory
{

    private final Context mContext;

    public DummyTabFactory(Context context)
    {
        mContext = context;
    }

    public View createTabContent(String s)
    {
        s = new View(mContext);
        s.setMinimumWidth(0);
        s.setMinimumHeight(0);
        return s;
    }
}
