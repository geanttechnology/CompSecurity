// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.m;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            aw, ao, x

public final class ac
    implements m
{
    public static final class a
        implements com.google.android.gms.wearable.m.a
    {

        private final Status a;
        private final List b;

        public final Status a()
        {
            return a;
        }

        public final List b()
        {
            return b;
        }

        public a(Status status, List list)
        {
            a = status;
            b = list;
        }
    }


    public ac()
    {
    }

    public final e a(c c1)
    {
        return c1.a(new aw(c1) {

            final ac c;

            protected final g a(Status status)
            {
                return new a(status, new ArrayList());
            }

            protected final void a(com.google.android.gms.common.api.a.b b)
            {
                ((x)((ao)b).m()).d(new an.b(this));
            }

            
            {
                c = ac.this;
                super(c1);
            }
        });
    }
}
