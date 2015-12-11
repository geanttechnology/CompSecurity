// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import co.vine.android.util.PlayerUtil;
import java.io.File;
import java.io.FileNotFoundException;

public class VineVideoProvider extends ContentProvider
{

    public static final String AUTHORITY = PlayerUtil.getAuthority(".provider.VineVideoProvider");
    public static final String CONTENT_AUTHORITY = (new StringBuilder()).append("content://").append(AUTHORITY).append("/").toString();
    private static final String VIDEO_MIME_TYPE = "video/mp4";

    public VineVideoProvider()
    {
    }

    public int delete(Uri uri, String s, String as[])
    {
        throw new UnsupportedOperationException();
    }

    public String getType(Uri uri)
    {
        return "video/mp4";
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        throw new UnsupportedOperationException();
    }

    public boolean onCreate()
    {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String s)
        throws FileNotFoundException
    {
        s = new File(uri.getPath());
        if (s.exists())
        {
            return ParcelFileDescriptor.open(s, 0x10000000);
        } else
        {
            throw new FileNotFoundException(uri.getPath());
        }
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        throw new UnsupportedOperationException();
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        throw new UnsupportedOperationException();
    }

}
