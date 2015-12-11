// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class crh
{

    private static Pattern c = Pattern.compile("(?:\\[|%5B)([a-zA-Z_:]+)(?:\\]|%5D)");
    public Map a;
    private Map b;

    public crh(cri cri1)
    {
        a = new HashMap();
        b = new HashMap();
        a(cri1);
    }

    private String a(Uri uri, String s, cri cri1)
    {
        if (cri1 != null)
        {
            cri1 = cri1.a(uri, s);
        } else
        {
            cri1 = null;
        }
        if (cri1 != null)
        {
            uri = cri1;
        } else
        {
            Iterator iterator = a.values().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = ((cri)iterator.next()).a(uri, s);
                cri1 = s1;
                if (s1 == null)
                {
                    continue;
                }
                cri1 = s1;
                break;
            } while (true);
            uri = cri1;
            if (cri1 == null)
            {
                return (String)b.get(s);
            }
        }
        return uri;
    }

    public final Uri a(Uri uri, cri cri1)
    {
        StringBuffer stringbuffer = new StringBuffer();
        Matcher matcher = c.matcher(uri.toString());
        do
        {
            if (!matcher.find())
            {
                break;
            }
            if (matcher.groupCount() == 1)
            {
                String s = a(uri, matcher.group(1), cri1);
                if (s != null)
                {
                    matcher.appendReplacement(stringbuffer, Uri.encode(s));
                }
            }
        } while (true);
        matcher.appendTail(stringbuffer);
        try
        {
            uri = a.q(stringbuffer.toString());
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new bnn("Failed to convert URI", uri);
        }
        return uri;
    }

    public final void a(cri cri1)
    {
        b.a(cri1);
        a.put(cri1.a(), cri1);
    }

    public final void a(Map map)
    {
        b.putAll(map);
    }

}
