// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.text.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;
import org.apache.http.client.utils.URIUtils;

public final class UriUtils
{

    private static final Pattern je = Pattern.compile("/");

    public UriUtils()
    {
    }

    private static URI N(String s)
    {
        try
        {
            s = new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private static URI b(String s, String s1, String s2, String s3, String s4)
    {
        try
        {
            s = new URI(s, s1, s2, s3, s4);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static String currentDir(String s)
    {
        URI uri;
        if (!TextUtils.isEmpty(s))
        {
            if ((uri = N(s)) != null && !(uri = uri.normalize()).isOpaque() && (uri = URIUtils.resolve(uri, "./")) != null)
            {
                return uri.toString();
            }
        }
        return s;
    }

    public static String relativize(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        Object obj;
        return s;
_L2:
        if ((obj = N(s)) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj1 = ((URI) (obj)).normalize();
        s1 = N(s1);
        if (s1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = s1.normalize();
        if (((URI) (obj1)).isOpaque() || ((URI) (obj)).isOpaque())
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = ((URI) (obj1)).getScheme();
        String s2 = ((URI) (obj)).getScheme();
        if (s2 == null && s1 != null || s2 != null && !s2.equals(s1))
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = ((URI) (obj1)).getAuthority();
        s2 = ((URI) (obj)).getAuthority();
        if (s2 == null && s1 != null || s2 != null && !s2.equals(s1))
        {
            continue; /* Loop/switch isn't completed */
        }
        s2 = ((URI) (obj1)).getPath();
        s1 = ((URI) (obj)).getPath();
        String as[] = je.split(s2, -1);
        s1 = je.split(s1, -1);
        int l = as.length;
        int i1 = s1.length;
        int i;
        for (i = 0; i < i1 && i < l && as[i].equals(s1[i]); i++) { }
        s1 = ((URI) (obj1)).getQuery();
        obj1 = ((URI) (obj1)).getFragment();
        s2 = ((String) (obj1));
        StringBuilder stringbuilder = new StringBuilder();
        if (i != i1 || i != l)
        {
            break; /* Loop/switch isn't completed */
        }
        String s3 = ((URI) (obj)).getQuery();
        obj = ((URI) (obj)).getFragment();
        boolean flag = TextUtils.equals(s1, s3);
        boolean flag1 = TextUtils.equals(s2, ((CharSequence) (obj)));
        if (flag && flag1)
        {
            obj1 = null;
            obj = null;
        } else
        {
            int j;
            int k;
            if (flag && !TextUtils.isEmpty(s2))
            {
                obj = null;
            } else
            {
                obj = s1;
            }
            if (TextUtils.isEmpty(((CharSequence) (obj))) && TextUtils.isEmpty(s2))
            {
                stringbuilder.append(as[l - 1]);
            } else
            {
                s1 = ((String) (obj));
            }
            obj = s1;
        }
        s1 = b(null, null, stringbuilder.toString(), ((String) (obj)), ((String) (obj1)));
        if (s1 != null)
        {
            return s1.toString();
        }
        if (true) goto _L1; else goto _L3
_L3:
        j = i;
        do
        {
            k = i;
            if (j >= i1 - 1)
            {
                break;
            }
            stringbuilder.append("..");
            stringbuilder.append("/");
            j++;
        } while (true);
        for (; k < l - 1; k++)
        {
            stringbuilder.append(as[k]);
            stringbuilder.append("/");
        }

        if (k < l)
        {
            stringbuilder.append(as[k]);
        }
        obj = s1;
        obj1 = s2;
        if (stringbuilder.length() == 0)
        {
            stringbuilder.append(".");
            stringbuilder.append("/");
            obj = s1;
            obj1 = s2;
        }
        break MISSING_BLOCK_LABEL_284;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static String root(String s)
    {
        URI uri;
        if (!TextUtils.isEmpty(s))
        {
            if ((uri = N(s)) != null && !(uri = uri.normalize()).isOpaque() && (uri = b(uri.getScheme(), uri.getAuthority(), "/", null, null)) != null)
            {
                return uri.toString();
            }
        }
        return s;
    }

}
