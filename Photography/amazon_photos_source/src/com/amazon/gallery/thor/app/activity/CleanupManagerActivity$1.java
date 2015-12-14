// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.database.DataSetObserver;
import com.amazon.gallery.thor.cleanupmanager.CleanupManagerUiThreadHandler;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            CleanupManagerActivity

class this._cls0 extends DataSetObserver
{

    final CleanupManagerActivity this$0;

    public void onChanged()
    {
        CleanupManagerActivity.access$000(CleanupManagerActivity.this).sendRefreshViewMessage();
    }

    andler()
    {
        this$0 = CleanupManagerActivity.this;
        super();
    }
}
