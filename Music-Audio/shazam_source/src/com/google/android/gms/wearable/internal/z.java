// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.j;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            aw, ao, x

public final class z
    implements j
{
    public static final class a
        implements com.google.android.gms.wearable.j.b
    {

        private final Status a;
        private final int b;

        public final Status a()
        {
            return a;
        }

        public a(Status status, int i)
        {
            a = status;
            b = i;
        }
    }


    public z()
    {
    }

    public final e a(c c1, String s, String s1, byte abyte0[])
    {
        return c1.a(new aw(c1, s, s1, abyte0) {

            final String c;
            final String d;
            final byte e[];
            final z f;

            protected final g a(Status status)
            {
                return new a(status, -1);
            }

            protected final void a(com.google.android.gms.common.api.a.b b)
            {
                b = (ao)b;
                String s2 = c;
                String s3 = d;
                byte abyte1[] = e;
                ((x)b.m()).a(new an.e(this), s2, s3, abyte1);
            }

            
            {
                f = z.this;
                c = s;
                d = s1;
                e = abyte0;
                super(c1);
            }
        });
    }
}
