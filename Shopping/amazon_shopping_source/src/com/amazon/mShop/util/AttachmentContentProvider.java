// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AttachmentContentProvider extends ContentProvider
{

    public AttachmentContentProvider()
    {
    }

    public static String getAttachmentContentProviderAuthority(Context context)
    {
        return (new StringBuilder()).append("content://").append(getPackageName(context)).append(".util.AttachmentContentProvider").append("/").toString();
    }

    private String getMimeType(String s)
    {
        String s1 = null;
        if (s.length() > 0)
        {
            s = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
            s1 = s;
            if (s == null)
            {
                s1 = "*/*";
            }
        }
        return s1;
    }

    private static String getPackageName(Context context)
    {
        Method method;
        Object obj;
        obj = context.getApplicationContext();
        method = null;
        obj = obj.getClass().getMethod("getApplicationInfo", (Class[])null);
        method = ((Method) (obj));
_L2:
        String s = null;
        NoSuchMethodException nosuchmethodexception;
        if (method != null)
        {
            try
            {
                s = ((ApplicationInfo)method.invoke(context, (Object[])null)).packageName;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return null;
            }
        }
        return s;
        nosuchmethodexception;
        nosuchmethodexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getTempFilesPath(Context context)
    {
        return (new StringBuilder()).append("/data/data/").append(getPackageName(context)).append("/tmpFiles/").toString();
    }

    public int delete(Uri uri, String s, String as[])
    {
        return 0;
    }

    public String getType(Uri uri)
    {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        return null;
    }

    public boolean onCreate()
    {
        return false;
    }

    public ParcelFileDescriptor openFile(Uri uri, String s)
        throws FileNotFoundException, RuntimeException
    {
        String s1 = getTempFilesPath(getContext());
        if (!uri.toString().startsWith(getAttachmentContentProviderAuthority(getContext()))) goto _L2; else goto _L1
_L1:
        File file;
        if (!s.equalsIgnoreCase("r"))
        {
            throw new RuntimeException("We only support Read mode file.");
        }
        uri = uri.toString().substring(getAttachmentContentProviderAuthority(getContext()).length());
        file = new File((new StringBuilder()).append(s1).append(uri).toString());
        uri = null;
        s = file.getCanonicalPath();
        uri = s;
_L4:
        s = file.getName();
        if (uri == null || !uri.startsWith(s1) || !s.endsWith(".jpg") || !uri.equals((new StringBuilder()).append(s1).append(s).toString()))
        {
            throw new RuntimeException("You don't have the permission to read this file.");
        } else
        {
            return ParcelFileDescriptor.open(file, 0x10000000);
        }
_L2:
        throw new FileNotFoundException((new StringBuilder()).append("Unsupported uri: ").append(uri.toString()).toString());
        s;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        if (uri.toString().startsWith(getAttachmentContentProviderAuthority(getContext())))
        {
            as = new MatrixCursor(new String[] {
                "_data", "mime_type"
            });
            s = uri.toString().substring(getAttachmentContentProviderAuthority(getContext()).length());
            uri = "";
            int i = s.lastIndexOf(".");
            if (i >= 0)
            {
                uri = s.substring(i);
            }
            as.addRow(new String[] {
                s, getMimeType(uri)
            });
            return as;
        } else
        {
            throw new RuntimeException("We don't support this Uri.");
        }
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        return 0;
    }
}
