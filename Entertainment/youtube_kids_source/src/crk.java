// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class crk
{

    public final List a;

    public crk(String s, Map map, int i)
    {
        this(Collections.singletonList(s), map, i);
    }

    public crk(List list, Map map, int i)
    {
        a = Collections.unmodifiableList((List)b.b(list, "videoIds can not be null"));
        boolean flag;
        if (!a.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag, "videoIds cannot be empty");
        Collections.unmodifiableMap((Map)b.b(map, "params can not be null"));
    }

    public static int a(Uri uri, Map map)
    {
        String s = (String)map.get("t");
        map = s;
        if (s == null)
        {
            uri = Uri.decode(uri.getEncodedFragment());
            map = s;
            if (!TextUtils.isEmpty(uri))
            {
                String as1[] = uri.split("&");
                int j = as1.length;
                int i = 0;
                uri = s;
                do
                {
                    map = uri;
                    if (i >= j)
                    {
                        break;
                    }
                    String as[] = as1[i].split("=");
                    map = uri;
                    if (as.length == 2)
                    {
                        map = uri;
                        if ("t".equals(as[0]))
                        {
                            map = as[1];
                        }
                    }
                    i++;
                    uri = map;
                } while (true);
            }
        }
        return a(((String) (map)));
    }

    public static int a(String s)
    {
        if (s == null)
        {
            return 0;
        }
        int j = s.indexOf("h");
        String s1;
        int i;
        int k;
        if (j >= 0)
        {
            i = a.b(s.substring(0, j), 0) * 0x36ee80 + 0;
            s1 = s.substring(j + 1);
        } else
        {
            i = 0;
            s1 = s;
        }
        k = s1.indexOf("m");
        j = i;
        s = s1;
        if (k >= 0)
        {
            j = i + a.b(s1.substring(0, k), 0) * 60000;
            s = s1.substring(k + 1);
        }
        s1 = s;
        if (s.endsWith("s"))
        {
            s1 = s.substring(0, s.length() - 1);
        }
        return (int)(a.a(s1, 0.0F) * 1000F) + j;
    }

    public static Map a(Uri uri)
    {
        if (uri.isOpaque())
        {
            return Collections.emptyMap();
        }
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = uri.getQueryParameterNames().iterator(); iterator.hasNext(); hashmap.put(s, uri.getQueryParameter(s)))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }

    public static Map a(Map map)
    {
        map = new HashMap(map);
        map.remove("v");
        map.remove("video_id");
        map.remove("video_ids");
        map.remove("feature");
        return map;
    }

    public static crk b(Uri uri)
    {
        Map map = a(uri);
        String s = (String)map.get("v");
        String s2 = (String)map.get("video_ids");
        Object obj = s;
        if (TextUtils.isEmpty(s))
        {
            obj = s;
            if (TextUtils.isEmpty(s2))
            {
                obj = uri.getPathSegments();
                int i = ((List) (obj)).indexOf("watch");
                if (i < 0)
                {
                    uri = String.valueOf(uri);
                    throw new ParseException((new StringBuilder(String.valueOf(uri).length() + 28)).append("No /watch/ part in the Uri: ").append(uri).toString(), 0);
                }
                if (i + 1 >= ((List) (obj)).size())
                {
                    uri = String.valueOf(uri);
                    throw new ParseException((new StringBuilder(String.valueOf(uri).length() + 24)).append("No id found in the Uri: ").append(uri).toString(), 0);
                }
                String s1 = (String)((List) (obj)).get(i + 1);
                obj = s1;
                if (TextUtils.isEmpty(s1))
                {
                    uri = String.valueOf(uri);
                    throw new ParseException((new StringBuilder(String.valueOf(uri).length() + 24)).append("No video id in the Uri: ").append(uri).toString(), 0);
                }
            }
        }
        if (s2 == null)
        {
            return new crk(((String) (obj)), a(map), a(uri, map));
        } else
        {
            return new crk(Arrays.asList(s2.split(",")), a(map), a(uri, map));
        }
    }

    public static crk c(Uri uri)
    {
        uri = uri.getLastPathSegment().split("&");
        String s = uri[0];
        HashMap hashmap = new HashMap();
        for (int i = 1; i < uri.length; i++)
        {
            String as[] = uri[i].split("=");
            if (as.length == 2)
            {
                hashmap.put(as[0], as[1]);
            }
        }

        return new crk(s, hashmap, a((String)hashmap.get("start")));
    }
}
