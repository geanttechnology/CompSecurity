// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.h;
import java.util.HashSet;
import java.util.LinkedList;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ShareInXmlParser, x, aa, z

class y extends AsyncTask
{

    final ShareInXmlParser a;
    private int b;

    protected y(ShareInXmlParser shareinxmlparser)
    {
        a = shareinxmlparser;
        super();
        b = -1;
        synchronized (ShareInXmlParser.f(shareinxmlparser))
        {
            ShareInXmlParser.f(shareinxmlparser).add(this);
        }
        return;
        shareinxmlparser;
        hashset;
        JVM INSTR monitorexit ;
        throw shareinxmlparser;
    }

    protected transient Void a(Void avoid[])
    {
        avoid = (x)com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).get(b);
        if (ShareInXmlParser.d(a) >= com.cyberlink.beautycircle.utility.ShareInXmlParser.h())
        {
            cancel(true);
            e.b(new Object[] {
                "Cancelled: ", Integer.valueOf(b)
            });
            return null;
        }
        e.b(new Object[] {
            "[", Integer.valueOf(b), "] Begin getImageBitmap; ", ShareInXmlParser.g(a).e()
        });
        Uri uri = Uri.parse(((x) (avoid)).b);
        avoid.c = ImageUtils.a(Globals.n(), uri);
        if (((x) (avoid)).c == null)
        {
            avoid.e = 2;
            e.b(new Object[] {
                "Download fail; Unqualified: ", Integer.valueOf(b)
            });
            return null;
        }
        String as[] = h.b(uri.getPath());
        if (as != null && as[1].equalsIgnoreCase("png") && ShareInXmlParser.a(a, ((x) (avoid)).c))
        {
            avoid.e = 2;
            e.b(new Object[] {
                "PNG Transparent; Unqualified: ", Integer.valueOf(b)
            });
            return null;
        }
        e.b(new Object[] {
            "[", Integer.valueOf(b), "] End getImageBitmap: ", Integer.valueOf(((x) (avoid)).c.getWidth()), "x", Integer.valueOf(((x) (avoid)).c.getHeight()), "; ", ShareInXmlParser.g(a).e()
        });
        int i = ((x) (avoid)).c.getWidth();
        int j = ((x) (avoid)).c.getHeight();
        if (!ImageUtils.a(i, j))
        {
            avoid.e = 2;
            e.b(new Object[] {
                "Unqualified: ", Integer.valueOf(b)
            });
            return null;
        }
        if (i * j > ShareInXmlParser.k(a) * ShareInXmlParser.l(a))
        {
            ShareInXmlParser.c(a, i);
            ShareInXmlParser.d(a, j);
        }
        e.b(new Object[] {
            "Qualified: ", Integer.valueOf(b)
        });
        avoid.e = 1;
        return null;
    }

    protected void a(int i)
    {
        if (i < 0 || i >= com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).size())
        {
            e.e(new Object[] {
                "Out of Boundary: ", Integer.valueOf(i), "/", Integer.valueOf(com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).size())
            });
            return;
        } else
        {
            ShareInXmlParser.g(a).a();
            b = i;
            executeOnExecutor(ShareInXmlParser.i(), new Void[0]);
            return;
        }
    }

    protected void a(Void void1)
    {
        e.b(new Object[0]);
        synchronized (ShareInXmlParser.f(a))
        {
            ShareInXmlParser.f(a).remove(this);
        }
        ShareInXmlParser.b(a, b);
        if (ShareInXmlParser.m(a) >= com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).size()) goto _L2; else goto _L1
_L1:
        void1 = (x)com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).get(ShareInXmlParser.m(a));
        if (((x) (void1)).e != 0) goto _L3; else goto _L2
_L2:
        if (ShareInXmlParser.p(a) != null)
        {
            if (ShareInXmlParser.q(a).a && ShareInXmlParser.f(a).isEmpty())
            {
                e.b(new Object[] {
                    Boolean.valueOf(ShareInXmlParser.q(a).a), ", ", Integer.valueOf(ShareInXmlParser.f(a).size())
                });
                ShareInXmlParser.o(a);
                if (ShareInXmlParser.b(a) != null)
                {
                    ShareInXmlParser.b(a).a(ShareInXmlParser.g(a));
                }
                a.g();
            }
            if (ShareInXmlParser.i(a) && ShareInXmlParser.f(a).isEmpty())
            {
                e.b(new Object[] {
                    "Target page content type is image. Fetch image complete."
                });
                if (ShareInXmlParser.b(a) != null)
                {
                    ShareInXmlParser.b(a).a(ShareInXmlParser.g(a));
                }
                a.g();
            }
        }
        e.b(new Object[0]);
        return;
        exception;
        void1;
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        e.b(new Object[] {
            "[", Integer.valueOf(ShareInXmlParser.m(a)), "] Handled; ", ShareInXmlParser.g(a).e()
        });
        if (((x) (void1)).e == 1)
        {
            void1.e = 3;
            ShareInXmlParser.n(a);
            e.b(new Object[] {
                "Callback qualified image(", Integer.valueOf(ShareInXmlParser.m(a)), ", ", ((x) (void1)).b, ")"
            });
            ShareInXmlParser.g(a).b();
            if (ShareInXmlParser.b(a) == null || ShareInXmlParser.b(a).a(void1))
            {
                ShareInXmlParser.o(a);
                a.g();
                e.b(new Object[0]);
                return;
            }
        }
        if (ShareInXmlParser.p(a) == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (ShareInXmlParser.d(a) >= com.cyberlink.beautycircle.utility.ShareInXmlParser.h())
        {
            e.b(new Object[] {
                Integer.valueOf(ShareInXmlParser.d(a))
            });
            ShareInXmlParser.o(a);
            if (ShareInXmlParser.b(a) != null)
            {
                ShareInXmlParser.b(a).a(ShareInXmlParser.g(a));
            }
            a.g();
            return;
        }
        if (ShareInXmlParser.m(a) >= com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).size() - 1)
        {
            ShareInXmlParser.q(a).a();
        }
        if (true || ShareInXmlParser.d(a) < com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).size() && ShareInXmlParser.d(a) < com.cyberlink.beautycircle.utility.ShareInXmlParser.h() && ShareInXmlParser.m(a) < com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).size() - 1) goto _L2; else goto _L4
_L4:
        ShareInXmlParser.o(a);
        if (ShareInXmlParser.b(a) != null)
        {
            ShareInXmlParser.b(a).a(ShareInXmlParser.g(a));
        }
        a.g();
        return;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onCancelled()
    {
        synchronized (ShareInXmlParser.f(a))
        {
            ShareInXmlParser.f(a).remove(this);
        }
        return;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }
}
