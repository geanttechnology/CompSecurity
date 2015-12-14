// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.net.Uri;
import android.os.AsyncTask;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.LinkedList;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ShareInXmlParser, x, z, aa, 
//            ad, y

class w extends AsyncTask
{

    final ShareInXmlParser a;

    private w(ShareInXmlParser shareinxmlparser)
    {
        a = shareinxmlparser;
        super();
    }

    w(ShareInXmlParser shareinxmlparser, ShareInXmlParser._cls1 _pcls1)
    {
        this(shareinxmlparser);
    }

    protected transient String a(String as[])
    {
        ShareInXmlParser.a(a, as[0]);
        as = ShareInXmlParser.b(a, ShareInXmlParser.h(a));
        if (isCancelled())
        {
            return "user_break";
        }
        ShareInXmlParser.a(a, ShareInXmlParser.c(a, as.getContentType()));
        if (!ShareInXmlParser.i(a)) goto _L2; else goto _L1
_L1:
        as = ShareInXmlParser.h(a).split("/");
        ShareInXmlParser.a(a, as[2], "title");
        ShareInXmlParser.a(a, ShareInXmlParser.h(a), "image");
        as = null;
_L6:
        if (ShareInXmlParser.b(a) == null) goto _L4; else goto _L3
_L3:
        if (!ShareInXmlParser.a(a).isEmpty() && ShareInXmlParser.b(a).a((x)ShareInXmlParser.a(a).getFirst()))
        {
            return "user_break";
        }
          goto _L5
_L2:
        as = ShareInXmlParser.a(a, as);
        e.b(new Object[] {
            "downloadUrl(", ShareInXmlParser.h(a), ") done; ", ShareInXmlParser.g(a).e()
        });
        e.b(new Object[] {
            as
        });
        int i;
        if (isCancelled())
        {
            return "user_break";
        }
        String s;
        Exception exception;
        boolean flag;
        try
        {
            ShareInXmlParser.d(a, as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            return "connection_error";
        }
          goto _L6
_L5:
        if (!ShareInXmlParser.c(a).isEmpty() && ShareInXmlParser.b(a).a((x)ShareInXmlParser.c(a).getFirst()))
        {
            return "user_break";
        }
        flag = com.cyberlink.beautycircle.utility.ShareInXmlParser.j(a);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        s = ad.a(Uri.parse(ShareInXmlParser.h(a)));
        e.b(new Object[] {
            (new StringBuilder()).append("Youtube vid = ").append(s).toString()
        });
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a, s).d();
_L9:
        ShareInXmlParser.a(a, 0);
        ShareInXmlParser.b(a, 0);
        i = 0;
_L7:
        if (i >= com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).size())
        {
            break; /* Loop/switch isn't completed */
        }
        if (isCancelled())
        {
            return "user_break";
        }
        break MISSING_BLOCK_LABEL_421;
        exception;
        exception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        (new y(a)).a(i);
        i++;
        if (true) goto _L7; else goto _L4
_L4:
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_455;
        }
        ShareInXmlParser.f(a, as);
        return "complete_tasks_successful";
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void a(String s)
    {
        if ("connection_error".equals(s) && ShareInXmlParser.b(a) != null)
        {
            ShareInXmlParser.b(a).a(ShareInXmlParser.g(a));
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }
}
