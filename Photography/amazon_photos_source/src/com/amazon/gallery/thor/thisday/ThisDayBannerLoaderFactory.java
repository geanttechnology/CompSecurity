// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.content.CursorLoader;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.thor.settings.HidePreferenceManager;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDaySharedPrefsManager

public class ThisDayBannerLoaderFactory
{

    private static final Uri MEDIA_ITEM_URI;
    private final Context context;
    private final Uri uri;
    private final String whereArgs[];
    private final String whereClause;

    public ThisDayBannerLoaderFactory(Context context1)
    {
        context = context1;
        Object obj = new HidePreferenceManager(context1);
        ThisDaySharedPrefsManager thisdaysharedprefsmanager = new ThisDaySharedPrefsManager(context1);
        boolean flag = ((HidePreferenceManager) (obj)).getHiddenPreference();
        obj = thisdaysharedprefsmanager.getPrefetchedBannerData();
        int i = context1.getResources().getInteger(0x7f0d0001);
        context1 = MEDIA_ITEM_URI.buildUpon();
        context1.appendQueryParameter("limit", String.valueOf(i - 1));
        uri = context1.build();
        if (flag)
        {
            context1 = "";
        } else
        {
            context1 = "AND hidden=0";
        }
        whereClause = String.format("%s IN (%s) AND %s = ? %s", new Object[] {
            "id", obj, "sync_state", context1
        });
        whereArgs = (new String[] {
            String.valueOf(SyncState.SYNCED.ordinal())
        });
    }

    public CursorLoader createLoader()
    {
        return new CursorLoader(context, uri, null, whereClause, whereArgs, null);
    }

    static 
    {
        MEDIA_ITEM_URI = com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI;
    }
}
