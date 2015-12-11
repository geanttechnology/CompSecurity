// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.List;

public final class aqv extends aqt
{

    final aqy g;
    final aqy h;
    private final Uri i;

    public aqv(aqo aqo1, long l, long l1, long l2, 
            int j, long l3, List list, aqy aqy1, aqy aqy2, Uri uri)
    {
        super(aqo1, l, l1, l2, j, l3, list);
        g = aqy1;
        h = aqy2;
        i = uri;
    }

    public final aqo a(aqp aqp1)
    {
        if (g != null)
        {
            aqy aqy1 = g;
            String s = aqp1.b.a;
            int k = aqp1.b.e;
            aqp1 = new StringBuilder();
            int j = 0;
            while (j < aqy1.d) 
            {
                aqp1.append(aqy1.a[j]);
                if (aqy1.b[j] == 1)
                {
                    aqp1.append(s);
                } else
                if (aqy1.b[j] == 2)
                {
                    aqp1.append(String.format(aqy1.c[j], new Object[] {
                        Integer.valueOf(0)
                    }));
                } else
                if (aqy1.b[j] == 3)
                {
                    aqp1.append(String.format(aqy1.c[j], new Object[] {
                        Integer.valueOf(k)
                    }));
                } else
                if (aqy1.b[j] == 4)
                {
                    aqp1.append(String.format(aqy1.c[j], new Object[] {
                        Long.valueOf(0L)
                    }));
                }
                j++;
            }
            aqp1.append(aqy1.a[aqy1.d]);
            aqp1 = aqp1.toString();
            return new aqo(i, aqp1, 0L, -1L);
        } else
        {
            return super.a(aqp1);
        }
    }
}
