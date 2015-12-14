// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;

// Referenced classes of package myobfuscated.q:
//            o

public final class j extends o
{

    public j(Context context, Uri uri)
    {
        super(context, uri);
    }

    protected final Object a(Uri uri, ContentResolver contentresolver)
    {
        contentresolver = contentresolver.openAssetFileDescriptor(uri, "r");
        if (contentresolver == null)
        {
            throw new FileNotFoundException((new StringBuilder("FileDescriptor is null for: ")).append(uri).toString());
        } else
        {
            return contentresolver.getParcelFileDescriptor();
        }
    }

    protected final void a(Object obj)
    {
        ((ParcelFileDescriptor)obj).close();
    }

    public final Class d()
    {
        return android/os/ParcelFileDescriptor;
    }
}
