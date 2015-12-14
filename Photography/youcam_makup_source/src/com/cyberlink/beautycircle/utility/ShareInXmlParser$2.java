// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.cyberlink.beautycircle.model.YouTubeVideoInfo;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ShareInXmlParser, ad, x

class a extends j
{

    final ShareInXmlParser a;

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    protected Void a(String s)
    {
        Object obj;
        String s1 = String.format(Locale.getDefault(), ad.c, new Object[] {
            s, "snippet"
        });
        e.b(new Object[] {
            (new StringBuilder()).append("Youtube videoDataApi = ").append(s1).toString()
        });
        com.cyberlink.beautycircle.model.em.Snippet.Thumbnail thumbnail;
        Iterator iterator;
        int i;
        try
        {
            s = (HttpURLConnection)(new URL(s1)).openConnection();
            s.setRequestMethod("GET");
            s.setRequestProperty("Referer", "http://bc.perfectcorp.com/share_in");
            s.connect();
            i = s.getResponseCode();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            e.e(new Object[] {
                "Youtube MalformedURLException: ", s1
            });
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            e.e(new Object[] {
                "Youtube IOException: cannot open connection: ", s1
            });
            s.printStackTrace();
            return null;
        }
        if (i >= 200 && i < 300)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        e.b(new Object[] {
            "Youtube code < 200 || code >= 300"
        });
        return null;
        s = ShareInXmlParser.a(a, s);
        e.b(new Object[] {
            (new StringBuilder()).append("Youtube json = ").append(s).toString()
        });
        obj = ((com.cyberlink.beautycircle.model.em)((YouTubeVideoInfo)Model.a(com/cyberlink/beautycircle/model/YouTubeVideoInfo, s)).items.get(0)).snippet;
        e.b(new Object[] {
            (new StringBuilder()).append("Youtube title = ").append(((com.cyberlink.beautycircle.model.em.Snippet) (obj)).title).toString()
        });
        s = new x(a);
        s.a = "title";
        s.b = ((com.cyberlink.beautycircle.model.em.Snippet) (obj)).title;
        s.d = "YouTubeDataAPIv3";
        ShareInXmlParser.a(a).addFirst(s);
        e.b(new Object[] {
            (new StringBuilder()).append("Youtube description = ").append(((com.cyberlink.beautycircle.model.em.Snippet) (obj)).description).toString()
        });
        s = new x(a);
        s.a = "description";
        s.b = ((com.cyberlink.beautycircle.model.em.Snippet) (obj)).description;
        s.d = "YouTubeDataAPIv3";
        ShareInXmlParser.c(a).addFirst(s);
        s = (com.cyberlink.beautycircle.model.em.Snippet.Thumbnail)((com.cyberlink.beautycircle.model.em.Snippet) (obj)).thumbnails.thumbnails("maxres");
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_532;
        }
        iterator = ((com.cyberlink.beautycircle.model.em.Snippet) (obj)).thumbnails.s().iterator();
_L2:
        obj = s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_421;
        }
        thumbnail = (com.cyberlink.beautycircle.model.em.Snippet.Thumbnail)iterator.next();
        if (thumbnail == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = thumbnail;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        if (s.b() < thumbnail.b())
        {
            obj = thumbnail;
        } else
        {
            obj = s;
        }
        break MISSING_BLOCK_LABEL_527;
        for (; obj == null; obj = s)
        {
            break MISSING_BLOCK_LABEL_525;
        }

        s = new x(a);
        s.a = "image";
        s.b = ((com.cyberlink.beautycircle.model.em.Snippet.Thumbnail) (obj)).url;
        s.d = "YouTubeDataAPIv3";
        com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).addLast(s);
        return null;
        return null;
        s = ((String) (obj));
        if (true) goto _L2; else goto _L1
_L1:
    }

    .Snippet.Thumbnail(ShareInXmlParser shareinxmlparser)
    {
        a = shareinxmlparser;
        super();
    }
}
