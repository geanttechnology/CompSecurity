// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.urbanairship.util.DataManager;
import com.urbanairship.util.UAStringUtil;
import java.util.Arrays;

// Referenced classes of package com.urbanairship:
//            PreferencesDataManager, UrbanAirshipProvider, RichPushDataManager, Logger

class notificationColumnId
{

    final Uri contentUri;
    final DataManager dataManager;
    final String notificationColumnId;
    final String table;

    static notificationColumnId createPreferencesModel(Context context)
    {
        return new <init>(new PreferencesDataManager(context), "preferences", UrbanAirshipProvider.getPreferencesContentUri(), "_id");
    }

    static ContentUri createRichPushModel(Context context)
    {
        return new <init>(new RichPushDataManager(context), "richpush", UrbanAirshipProvider.getRichPushContentUri(), "message_id");
    }

    void notifyDatabaseChange(Context context, String as[], String s)
    {
        as = Uri.withAppendedPath(contentUri, (new StringBuilder()).append(UAStringUtil.join(Arrays.asList(as), "|")).append("/").append(s).toString());
        Logger.verbose((new StringBuilder("UrbanAirshipProvider - Notifying of change to ")).append(as).toString());
        context.getContentResolver().notifyChange(as, null);
    }

    private _cls9(DataManager datamanager, String s, Uri uri, String s1)
    {
        dataManager = datamanager;
        table = s;
        contentUri = uri;
        notificationColumnId = s1;
    }
}
