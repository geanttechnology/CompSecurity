// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.InputStream;

// Referenced classes of package myobfuscated.q:
//            o

public final class q extends o
{

    public q(Context context, Uri uri)
    {
        super(context, uri);
    }

    protected final Object a(Uri uri, ContentResolver contentresolver)
    {
        contentresolver = contentresolver.openInputStream(uri);
        if (contentresolver == null)
        {
            throw new FileNotFoundException((new StringBuilder("InputStream is null for :")).append(uri).toString());
        } else
        {
            return contentresolver;
        }
    }

    protected final void a(Object obj)
    {
        ((InputStream)obj).close();
    }

    public final Class d()
    {
        return java/io/InputStream;
    }
}
