// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.location.internal.j;

// Referenced classes of package com.google.android.gms.location:
//            b

public class com.google.android.gms.location.a
{
    public static abstract class a extends com.google.android.gms.common.api.k.a
    {

        public a(c c1)
        {
            super(com.google.android.gms.location.a.a(), c1);
        }
    }


    public static final com.google.android.gms.common.api.a a;
    public static final b b = new com.google.android.gms.location.internal.a();
    private static final com.google.android.gms.common.api.d c;
    private static final com.google.android.gms.common.api.b d;

    static com.google.android.gms.common.api.d a()
    {
        return c;
    }

    static 
    {
        c = new com.google.android.gms.common.api.d();
        d = new com.google.android.gms.common.api.b() {

            public com.google.android.gms.common.api.c a(Context context, Looper looper, h h, Object obj, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1)
            {
                return a(context, looper, h, (com.google.android.gms.common.api.a.b)obj, b1, c1);
            }

            public j a(Context context, Looper looper, h h, com.google.android.gms.common.api.a.b b1, com.google.android.gms.common.api.c.b b2, com.google.android.gms.common.api.c.c c1)
            {
                return new j(context, looper, b2, c1, "activity_recognition");
            }

        };
        a = new com.google.android.gms.common.api.a("ActivityRecognition.API", d, c);
    }
}
