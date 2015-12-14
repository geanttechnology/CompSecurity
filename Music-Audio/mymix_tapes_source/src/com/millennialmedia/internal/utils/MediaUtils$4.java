// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import java.io.File;

// Referenced classes of package com.millennialmedia.internal.utils:
//            MediaUtils

static final class val.photoListener
    implements com.millennialmedia.internal.erActivity.MMIntentWrapperListener
{

    final Context val$context;
    final otoListener val$photoListener;

    public void onData(Intent intent)
    {
        if (intent != null)
        {
            Object obj = intent.getData();
            if (obj != null)
            {
                intent = ((Uri) (obj)).getPath();
                Cursor cursor = val$context.getContentResolver().query(((Uri) (obj)), new String[] {
                    "_data"
                }, null, null, null);
                obj = intent;
                if (cursor != null)
                {
                    int i = cursor.getColumnIndex("_data");
                    if (cursor.moveToFirst())
                    {
                        intent = cursor.getString(i);
                    }
                    cursor.close();
                    obj = intent;
                }
                if (obj != null)
                {
                    intent = new File(((String) (obj)));
                    if (intent != null && intent.exists())
                    {
                        val$photoListener.onPhoto(intent);
                        return;
                    }
                }
            }
        }
        val$photoListener.onError("Unable to get image from gallery");
    }

    public void onError(String s)
    {
        val$photoListener.onError(s);
    }

    otoListener(Context context1, otoListener otolistener)
    {
        val$context = context1;
        val$photoListener = otolistener;
        super();
    }
}
