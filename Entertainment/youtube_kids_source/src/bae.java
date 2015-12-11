// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.Uri;

public final class bae
{

    String a;
    String b;
    String c[] = {
        ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"
    };
    private String d;
    private azb e;

    public bae(azb azb1)
    {
        a = "googleads.g.doubleclick.net";
        b = "/pagead/ads";
        d = "ad.doubleclick.net";
        e = azb1;
    }

    private boolean c(Uri uri)
    {
        if (uri == null)
        {
            throw new NullPointerException();
        }
        boolean flag;
        try
        {
            flag = uri.getHost().equals(d);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            return false;
        }
        return flag;
    }

    Uri a(Uri uri, Context context, String s, boolean flag)
    {
        try
        {
            flag = c(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new bat("Provided Uri is not in a valid state");
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (uri.toString().contains("dc_ms="))
        {
            throw new bat("Parameter already exists: dc_ms");
        }
        break MISSING_BLOCK_LABEL_64;
        if (uri.getQueryParameter("ms") != null)
        {
            throw new bat("Query parameter already exists: ms");
        }
        context = e.a(context);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        int i;
        s = uri.toString();
        i = s.indexOf(";adurl");
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        return Uri.parse((new StringBuilder(s.substring(0, i + 1))).append("dc_ms").append("=").append(context).append(";").append(s.substring(i + 1)).toString());
        uri = uri.getEncodedPath();
        i = s.indexOf(uri);
        return Uri.parse((new StringBuilder(s.substring(0, uri.length() + i))).append(";").append("dc_ms").append("=").append(context).append(";").append(s.substring(uri.length() + i)).toString());
        int j;
        s = uri.toString();
        j = s.indexOf("&adurl");
        i = j;
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        i = s.indexOf("?adurl");
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        return Uri.parse((new StringBuilder(s.substring(0, i + 1))).append("ms").append("=").append(context).append("&").append(s.substring(i + 1)).toString());
        uri = uri.buildUpon().appendQueryParameter("ms", context).build();
        return uri;
    }

    public final boolean a(Uri uri)
    {
label0:
        {
            boolean flag1 = false;
            if (uri == null)
            {
                throw new NullPointerException();
            }
            boolean flag = flag1;
            boolean flag2;
            try
            {
                if (!uri.getHost().equals(a))
                {
                    break label0;
                }
                flag2 = uri.getPath().equals(b);
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                return false;
            }
            flag = flag1;
            if (flag2)
            {
                flag = true;
            }
        }
        return flag;
    }

    public final boolean b(Uri uri)
    {
        boolean flag1 = false;
        if (uri == null)
        {
            throw new NullPointerException();
        }
        String as[];
        int i;
        int j;
        boolean flag;
        try
        {
            uri = uri.getHost();
            as = c;
            j = as.length;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            return false;
        }
        i = 0;
        flag = flag1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        flag = uri.endsWith(as[i]);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        flag = true;
        return flag;
        for (i++; false;)
        {
        }

        break MISSING_BLOCK_LABEL_31;
    }
}
