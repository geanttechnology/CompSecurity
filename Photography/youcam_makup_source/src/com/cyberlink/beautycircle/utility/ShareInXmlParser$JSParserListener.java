// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.os.Handler;
import android.os.Looper;
import com.perfectcorp.utility.e;
import java.util.HashSet;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ShareInXmlParser, y, x, z

class c
{

    protected boolean a;
    protected Handler b;
    final ShareInXmlParser c;
    private Runnable d;

    public void a()
    {
        a = false;
        b.removeCallbacks(d);
        b.postDelayed(d, 2000L);
    }

    public void onAddImage(String s)
    {
        if (ShareInXmlParser.d(c) >= ShareInXmlParser.h())
        {
            e.b(new Object[] {
                "Norma cleared; Do nothing."
            });
            return;
        }
        e.b(new Object[] {
            s
        });
        if (ShareInXmlParser.a(c, s, "image"))
        {
            e.b(new Object[] {
                "[", Integer.valueOf(com.cyberlink.beautycircle.utility.ShareInXmlParser.e(c).size() - 1), "]", s
            });
            (new y(c)).a(com.cyberlink.beautycircle.utility.ShareInXmlParser.e(c).size() - 1);
        }
        a();
    }

    public void onParseCompleted(String s, String s1)
    {
        s = new JSONArray(s);
        int i = 0;
_L2:
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        ShareInXmlParser.a(c, s.getString(i), "title");
        i++;
        if (true) goto _L2; else goto _L1
        s;
        s.printStackTrace();
_L1:
        s = new JSONArray(s1);
        i = 0;
_L4:
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        ShareInXmlParser.a(c, s.getString(i), "description");
        i++;
        if (true) goto _L4; else goto _L3
        s;
        s.printStackTrace();
_L3:
        a();
        while (!ShareInXmlParser.a(c).isEmpty() && ShareInXmlParser.b(c).a((x)ShareInXmlParser.a(c).getFirst()) || ShareInXmlParser.c(c).isEmpty() || !ShareInXmlParser.b(c).a((x)ShareInXmlParser.c(c).getFirst())) 
        {
            return;
        }
        return;
    }

    _cls1.a(ShareInXmlParser shareinxmlparser)
    {
        c = shareinxmlparser;
        super();
        a = false;
        b = new Handler(Looper.getMainLooper());
        d = new Runnable() {

            final ShareInXmlParser.JSParserListener a;

            public void run()
            {
                e.b(new Object[] {
                    "OnNoMoreImage"
                });
                a.a = true;
                if (ShareInXmlParser.d(a.c) > ShareInXmlParser.h())
                {
                    e.b(new Object[] {
                        "Norma cleared; Do nothing."
                    });
                    return;
                }
                synchronized (ShareInXmlParser.f(a.c))
                {
                    if (!ShareInXmlParser.f(a.c).isEmpty())
                    {
                        break MISSING_BLOCK_LABEL_149;
                    }
                    e.b(new Object[] {
                        "All tasks done.  onParseCompleted."
                    });
                    if (ShareInXmlParser.b(a.c) != null)
                    {
                        ShareInXmlParser.b(a.c).a(ShareInXmlParser.g(a.c));
                    }
                    a.c.g();
                }
                return;
                exception;
                hashset;
                JVM INSTR monitorexit ;
                throw exception;
                hashset;
                JVM INSTR monitorexit ;
                e.b(new Object[] {
                    "There are remaining tasks."
                });
                return;
            }

            
            {
                a = ShareInXmlParser.JSParserListener.this;
                super();
            }
        };
    }
}
