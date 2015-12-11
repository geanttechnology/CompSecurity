// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

// Referenced classes of package com.millennialmedia.android:
//            au, MMActivity

static final class ivity
{

    static void a(Context context, Intent intent)
    {
        intent.setClass(context, com/millennialmedia/android/MMActivity);
        intent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
        b(context, intent);
    }

    static void a(Context context, Uri uri)
    {
        Intent intent = new Intent(context, com/millennialmedia/android/MMActivity);
        intent.setData(uri);
        intent.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
        b(context, intent);
    }

    static void b(Context context, Intent intent)
    {
        if (!(context instanceof Activity))
        {
            intent.addFlags(0x10000000);
        }
        Object obj = intent.getData();
        if (obj != null)
        {
            obj = ((Uri) (obj)).getLastPathSegment();
            if (TextUtils.isEmpty(intent.getStringExtra("class")) && !TextUtils.isEmpty(((CharSequence) (obj))) && (((String) (obj)).endsWith(".mp4") || ((String) (obj)).endsWith(".3gp") || ((String) (obj)).endsWith(".mkv") || ((String) (obj)).endsWith("content.once")))
            {
                intent.setDataAndType(intent.getData(), "video/*");
            }
        }
        context.startActivity(intent);
    }
}
