// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import myobfuscated.q.b;
import myobfuscated.q.c;

final class ab
    implements b
{

    private static final String a[] = {
        "_data"
    };
    private final Context b;
    private final Uri c;

    ab(Context context, Uri uri)
    {
        b = context;
        c = uri;
    }

    public final void a()
    {
    }

    public final void a(Priority priority, c c1)
    {
        Cursor cursor;
        priority = null;
        Object obj = null;
        cursor = b.getContentResolver().query(c, a, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        priority = obj;
        if (cursor.moveToFirst())
        {
            priority = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        }
        cursor.close();
        if (TextUtils.isEmpty(priority))
        {
            c1.a(new FileNotFoundException((new StringBuilder("Failed to find file path for: ")).append(c).toString()));
            return;
        } else
        {
            c1.a(new File(priority));
            return;
        }
        priority;
        cursor.close();
        throw priority;
    }

    public final void b()
    {
    }

    public final DataSource c()
    {
        return DataSource.LOCAL;
    }

    public final Class d()
    {
        return java/io/File;
    }

}
