// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.content.CursorLoader;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            BordersPanel

class this._cls0 extends ContentObserver
{

    final BordersPanel this$0;

    public void onChange(boolean flag)
    {
        mLogger.info("mContentObserver::onChange");
        super.onChange(flag);
        if (isActive() && mCursorLoader != null && mCursorLoader.isStarted())
        {
            mCursorLoader.onContentChanged();
        }
    }

    ogger(Handler handler)
    {
        this$0 = BordersPanel.this;
        super(handler);
    }
}
