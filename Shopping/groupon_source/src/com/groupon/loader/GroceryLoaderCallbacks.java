// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.events.GroceryUpdateEvent;
import com.groupon.db.models.SnapGroceryDetail;

// Referenced classes of package com.groupon.loader:
//            GroceryLoader

public class GroceryLoaderCallbacks
    implements android.app.LoaderManager.LoaderCallbacks
{

    protected Context context;
    protected String dbChannelId;
    protected String groceryId;

    public GroceryLoaderCallbacks(Context context1, String s, String s1)
    {
        context = context1;
        groceryId = s;
        dbChannelId = s1;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new GroceryLoader(com/groupon/db/models/SnapGroceryDetail, com/groupon/db/events/GroceryUpdateEvent, context, groceryId, dbChannelId);
    }

    public void onLoadFinished(Loader loader, SnapGroceryDetail snapgrocerydetail)
    {
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (SnapGroceryDetail)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }
}
