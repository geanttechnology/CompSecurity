// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            jb, ix, iy

public final class iw
    implements jb
{

    private static final Uri a;
    private final LogPrinter b = new LogPrinter(4, "GA/LogCatTransport");

    public iw()
    {
    }

    public final Uri a()
    {
        return a;
    }

    public final void a(ix ix1)
    {
        Object obj = new ArrayList(ix1.h.values());
        Collections.sort(((List) (obj)), new Comparator() {

            final iw a;

            public final int compare(Object obj1, Object obj2)
            {
                obj1 = (iy)obj1;
                obj2 = (iy)obj2;
                return obj1.getClass().getCanonicalName().compareTo(obj2.getClass().getCanonicalName());
            }

            
            {
                a = iw.this;
                super();
            }
        });
        ix1 = new StringBuilder();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = ((iy)((Iterator) (obj)).next()).toString();
            if (!TextUtils.isEmpty(s))
            {
                if (ix1.length() != 0)
                {
                    ix1.append(", ");
                }
                ix1.append(s);
            }
        } while (true);
        b.println(ix1.toString());
    }

    static 
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        a = builder.build();
    }
}
