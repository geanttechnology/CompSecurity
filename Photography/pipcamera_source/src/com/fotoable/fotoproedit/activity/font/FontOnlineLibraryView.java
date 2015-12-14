// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ListView;

public class FontOnlineLibraryView extends FrameLayout
{

    private FrameLayout mBtnBack;
    private ListView mListView;

    public FontOnlineLibraryView(Context context)
    {
        super(context);
        init();
    }

    public FontOnlineLibraryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d9, this, true);
        mBtnBack = (FrameLayout)findViewById(0x7f0c004a);
    }
}
