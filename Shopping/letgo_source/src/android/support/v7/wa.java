// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            wh, wb, wd

public final class wa
    implements wh
{

    private static final Uri a;
    private final LogPrinter b = new LogPrinter(4, "GA/LogCatTransport");

    public wa()
    {
    }

    public Uri a()
    {
        return a;
    }

    public void a(wb wb1)
    {
        Object obj = new ArrayList(wb1.b());
        Collections.sort(((List) (obj)), new Comparator() {

            final wa a;

            public int a(wd wd1, wd wd2)
            {
                return wd1.getClass().getCanonicalName().compareTo(wd2.getClass().getCanonicalName());
            }

            public int compare(Object obj1, Object obj2)
            {
                return a((wd)obj1, (wd)obj2);
            }

            
            {
                a = wa.this;
                super();
            }
        });
        wb1 = new StringBuilder();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = ((wd)((Iterator) (obj)).next()).toString();
            if (!TextUtils.isEmpty(s))
            {
                if (wb1.length() != 0)
                {
                    wb1.append(", ");
                }
                wb1.append(s);
            }
        } while (true);
        b.println(wb1.toString());
    }

    static 
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        a = builder.build();
    }
}
