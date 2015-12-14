// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.file;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;

public class MimeTypeUtil
{

    public static String getFileExtensionFromPath(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return "";
        }
        int i = s.lastIndexOf('.');
        if (i < 0)
        {
            return "";
        }
        s = s.substring(i + 1);
        if (s == null)
        {
            return null;
        } else
        {
            return s.toLowerCase();
        }
    }

    public static String getFileExtensionFromUrl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return "";
        }
        int i = s.lastIndexOf('#');
        String s1 = s;
        if (i > 0)
        {
            s1 = s.substring(0, i);
        }
        i = s1.lastIndexOf('?');
        s = s1;
        if (i > 0)
        {
            s = s1.substring(0, i);
        }
        if (TextUtils.isEmpty(s))
        {
            return "";
        }
        s1 = s;
        i = s.lastIndexOf('/');
        if (i >= 0)
        {
            s1 = s.substring(i + 1);
        }
        return getFileExtensionFromPath(s1);
    }

    public static String getMimeType(String s)
    {
        return getMimetypeFromExtension(getFileExtensionFromUrl(s));
    }

    public static String getMimeTypeFromPath(String s)
    {
        return getMimetypeFromExtension(getFileExtensionFromPath(s));
    }

    private static String getMimetypeFromExtension(String s)
    {
        if (s.equalsIgnoreCase("webp"))
        {
            return "image/webp";
        }
        if (s.equalsIgnoreCase("webm"))
        {
            return "video/webm";
        }
        if (s.equalsIgnoreCase("mkv"))
        {
            return "video/x-matroska";
        } else
        {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
        }
    }
}
