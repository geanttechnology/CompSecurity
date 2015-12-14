// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import com.amazon.gallery.thor.cleanupmanager.DeduplicationHelper;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            CleanupManagerActivity

private static class deduplicationHelper
{

    private final DeduplicationHelper deduplicationHelper;
    private final List selectedItems;

    public DeduplicationHelper getDeduplicationHelper()
    {
        return deduplicationHelper;
    }

    public List getSelectedItems()
    {
        return selectedItems;
    }

    public (List list, DeduplicationHelper deduplicationhelper)
    {
        selectedItems = list;
        deduplicationHelper = deduplicationhelper;
    }
}
