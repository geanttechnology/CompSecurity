// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

// Referenced classes of package com.facebook:
//            GraphRequest

class a
    implements a
{

    final ArrayList a;
    final GraphRequest b;

    public void a(String s, String s1)
        throws IOException
    {
        a.add(String.format(Locale.US, "%s=%s", new Object[] {
            s, URLEncoder.encode(s1, "UTF-8")
        }));
    }

    (GraphRequest graphrequest, ArrayList arraylist)
    {
        b = graphrequest;
        a = arraylist;
        super();
    }
}
