// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import com.amazon.gallery.framework.gallery.widget.MediaItemListAdapter;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            CleanupManagerActivity

class this._cls0
    implements OnSortingChangedListener
{

    final CleanupManagerActivity this$0;

    public void onSortingChanged(int i)
    {
        CleanupManagerActivity.access$100(CleanupManagerActivity.this).clear();
        CleanupManagerActivity.access$900(CleanupManagerActivity.this, i);
    }

    er()
    {
        this$0 = CleanupManagerActivity.this;
        super();
    }
}
