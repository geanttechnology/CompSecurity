// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.r;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

// Referenced classes of package myobfuscated.r:
//            e

public final class d
    implements e
{

    private static final String a[] = {
        "_data"
    };

    public d()
    {
    }

    public final Cursor a(Context context, Uri uri)
    {
        uri = uri.getLastPathSegment();
        return context.getContentResolver().query(android.provider.MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, a, "kind = 1 AND video_id = ?", new String[] {
            uri
        }, null);
    }

}
