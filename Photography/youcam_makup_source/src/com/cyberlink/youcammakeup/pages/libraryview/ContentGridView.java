// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.libraryview;

import android.content.Context;
import android.util.AttributeSet;
import com.cyberlink.youcammakeup.database.d;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;

public abstract class ContentGridView extends HorizontalGridView
{

    public static final d a;

    public ContentGridView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void a()
    {
    }

    public abstract long[] getCheckedImageIds();

    static 
    {
        a = d.a;
    }
}
