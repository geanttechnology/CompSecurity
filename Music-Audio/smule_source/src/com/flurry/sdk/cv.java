// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;
import org.apache.http.client.utils.URIUtils;

public class cv
{

    private static final Pattern a = Pattern.compile("/");

    public static String a(String s)
    {
        Object obj;
        if (!TextUtils.isEmpty(s))
        {
            if ((obj = h(s)) != null)
            {
                obj = ((URI) (obj)).getScheme();
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    return (new StringBuilder()).append("http://").append(s).toString();
                }
                String s1 = ((String) (obj)).toLowerCase();
                if (obj != null && !((String) (obj)).equals(s1))
                {
                    int i = s.indexOf(((String) (obj)));
                    if (i >= 0)
                    {
                        return (new StringBuilder()).append(s1).append(s.substring(((String) (obj)).length() + i)).toString();
                    }
                }
            }
        }
        return s;
    }

    public static String a(String s, String s1)
    {
        Object obj;
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            if ((obj = h(s)) != null)
            {
                obj = ((URI) (obj)).normalize();
                s1 = h(s1);
                if (s1 != null)
                {
                    Object obj1 = s1.normalize();
                    if (!((URI) (obj)).isOpaque() && !((URI) (obj1)).isOpaque())
                    {
                        s1 = ((URI) (obj)).getScheme();
                        String s2 = ((URI) (obj1)).getScheme();
                        if ((s2 != null || s1 == null) && (s2 == null || s2.equals(s1)))
                        {
                            s1 = ((URI) (obj)).getAuthority();
                            String s3 = ((URI) (obj1)).getAuthority();
                            if ((s3 != null || s1 == null) && (s3 == null || s3.equals(s1)))
                            {
label0:
                                {
                                    Object obj2 = ((URI) (obj)).getPath();
                                    s1 = ((URI) (obj1)).getPath();
                                    obj2 = a.split(((CharSequence) (obj2)), -1);
                                    s1 = a.split(s1, -1);
                                    int l = obj2.length;
                                    int i1 = s1.length;
                                    StringBuilder stringbuilder;
                                    String s4;
                                    int i;
                                    boolean flag1;
                                    for (i = 0; i < i1 && i < l && obj2[i].equals(s1[i]); i++)
                                    {
                                        break label0;
                                    }

                                    s1 = ((URI) (obj)).getQuery();
                                    obj = ((URI) (obj)).getFragment();
                                    stringbuilder = new StringBuilder();
                                    if (i == i1 && i == l)
                                    {
                                        s4 = ((URI) (obj1)).getQuery();
                                        obj1 = ((URI) (obj1)).getFragment();
                                        boolean flag = TextUtils.equals(s1, s4);
                                        flag1 = TextUtils.equals(((CharSequence) (obj)), ((CharSequence) (obj1)));
                                        if (flag && flag1)
                                        {
                                            obj = null;
                                            s1 = null;
                                        } else
                                        {
                                            int j;
                                            int k;
                                            if (flag && !TextUtils.isEmpty(((CharSequence) (obj))))
                                            {
                                                obj1 = null;
                                            } else
                                            {
                                                obj1 = s1;
                                            }
                                            if (TextUtils.isEmpty(((CharSequence) (obj1))) && TextUtils.isEmpty(((CharSequence) (obj))))
                                            {
                                                stringbuilder.append(obj2[l - 1]);
                                            } else
                                            {
                                                s1 = ((String) (obj1));
                                            }
                                        }
                                        obj1 = obj;
                                        obj2 = s1;
                                    } else
                                    {
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
                                            stringbuilder.append(obj2[k]);
                                            stringbuilder.append("/");
                                        }

                                        if (k < l)
                                        {
                                            stringbuilder.append(obj2[k]);
                                        }
                                        obj2 = s1;
                                        obj1 = obj;
                                        if (stringbuilder.length() == 0)
                                        {
                                            stringbuilder.append(".");
                                            stringbuilder.append("/");
                                            obj2 = s1;
                                            obj1 = obj;
                                        }
                                    }
                                    s1 = a(null, null, stringbuilder.toString(), ((String) (obj2)), ((String) (obj1)));
                                    if (s1 != null)
                                    {
                                        return s1.toString();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return s;
    }

    private static URI a(String s, String s1, String s2, String s3, String s4)
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

    public static String b(String s)
    {
        URI uri;
        if (!TextUtils.isEmpty(s))
        {
            if ((uri = h(s)) != null && !(uri = uri.normalize()).isOpaque() && (uri = a(uri.getScheme(), uri.getAuthority(), "/", null, null)) != null)
            {
                return uri.toString();
            }
        }
        return s;
    }

    public static String b(String s, String s1)
    {
        String s2;
        s2 = s;
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        s2 = s;
        if (!(new URI(s)).isAbsolute())
        {
            s2 = s;
            try
            {
                if (!TextUtils.isEmpty(s1))
                {
                    s1 = new URI(s1);
                    s2 = (new StringBuilder()).append(s1.getScheme()).append("://").append(s1.getHost()).append(s).toString();
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return s;
            }
        }
        return s2;
    }

    public static String c(String s)
    {
        URI uri;
        if (!TextUtils.isEmpty(s))
        {
            if ((uri = h(s)) != null && !(uri = uri.normalize()).isOpaque() && (uri = URIUtils.resolve(uri, "./")) != null)
            {
                return uri.toString();
            }
        }
        return s;
    }

    public static boolean d(String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!TextUtils.isEmpty(s))
        {
            s = Uri.parse(s);
            flag = flag1;
            if (s.getScheme() != null)
            {
                flag = flag1;
                if (s.getScheme().equals("market"))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static boolean e(String s)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (TextUtils.isEmpty(s))
            {
                break label0;
            }
            s = Uri.parse(s);
            flag = flag1;
            if (s.getScheme() == null)
            {
                break label0;
            }
            if (!s.getScheme().equals("http://"))
            {
                flag = flag1;
                if (!s.getScheme().equals("https://"))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static boolean f(String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!TextUtils.isEmpty(s))
        {
            s = Uri.parse(s);
            flag = flag1;
            if (s.getHost() != null)
            {
                flag = flag1;
                if (s.getHost().equals("play.google.com"))
                {
                    flag = flag1;
                    if (s.getScheme() != null)
                    {
                        flag = flag1;
                        if (s.getScheme().startsWith("http"))
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public static boolean g(String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!TextUtils.isEmpty(s))
        {
            s = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(s));
            flag = flag1;
            if (s != null)
            {
                flag = flag1;
                if (s.startsWith("video/"))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private static URI h(String s)
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

}
