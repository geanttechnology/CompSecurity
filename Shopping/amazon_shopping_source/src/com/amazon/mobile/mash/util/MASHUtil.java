// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.mobile.mash.util:
//            Util

public final class MASHUtil
{

    private MASHUtil()
    {
    }

    public static String canonicalizeIfRelativeUrl(String s, WebView webview)
    {
        webview = webview.getUrl();
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(webview))
        {
            return s;
        }
        s = Uri.parse(s);
        webview = Uri.parse(webview);
        if (s.getHost() == null && s.getScheme() == null)
        {
            s = s.buildUpon();
            s.authority(webview.getAuthority());
            s.scheme(webview.getScheme());
            return s.build().toString();
        } else
        {
            return s.toString();
        }
    }

    public static Uri canonicalizeUri(Uri uri, Uri uri1, String s)
    {
        android.net.Uri.Builder builder = uri.buildUpon();
        builder.path(uri1.getPath());
        builder.scheme("https");
        if (!Util.isEmpty(s) && !uriHasRefmarkerInQuery(uri))
        {
            builder.appendPath((new StringBuilder()).append("ref=").append(s).toString());
        }
        return builder.build();
    }

    public static int getTargetForAppNavTypeNone(WebBackForwardList webbackforwardlist)
    {
        return getTargetSkipPattern(webbackforwardlist, Pattern.compile(".+app-nav-type=none.*", 2)) - 1;
    }

    public static int getTargetSkipPattern(WebBackForwardList webbackforwardlist, Pattern pattern)
    {
        for (int i = webbackforwardlist.getCurrentIndex() - 1; i >= 0; i--)
        {
            if (!pattern.matcher(webbackforwardlist.getItemAtIndex(i).getUrl()).matches())
            {
                return i;
            }
        }

        return -1;
    }

    public static boolean isAndroidPermissionGranted(Context context, String s)
    {
        return context.getPackageManager().checkPermission(s, context.getPackageName()) == 0;
    }

    public static boolean isFragmentUrl(String s)
    {
        return !Util.isEmpty(s) && !Util.isEmpty(Uri.parse(s).getFragment());
    }

    public static String removeEverythingAfterRefMarker(String s)
    {
        String s1;
        if (Util.isEmpty(s))
        {
            s1 = "";
        } else
        {
            int i = s.indexOf("ref=");
            s1 = s;
            if (i > 0)
            {
                return s.substring(0, i);
            }
        }
        return s1;
    }

    private static boolean uriHasRefmarkerInQuery(Uri uri)
    {
        return uri.getQueryParameter("ref_") != null;
    }
}
