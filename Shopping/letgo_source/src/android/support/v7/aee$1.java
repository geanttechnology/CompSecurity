// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.api.Status;

// Referenced classes of package android.support.v7:
//            aee, xg, abo, aed, 
//            aaf, aai

class a
    implements a
{

    final String a;
    final aee b;

    public void a(xg xg1)
    {
        if (xg1.a() != Status.a)
        {
            abo.a((new StringBuilder()).append("Load request failed for the container ").append(aee.a(b)).toString());
            b.a(b.a(Status.c));
            return;
        }
        mmon.api.g g = xg1.b().();
        if (g == null)
        {
            abo.a("Response doesn't have the requested container");
            b.a(b.a(new Status(8, "Response doesn't have the requested container", null)));
            return;
        } else
        {
            long l = xg1.b().();
            aee.a(b, new aed(aee.b(b), aee.c(b), new aaf(aee.d(b), aee.b(b).a(), aee.a(b), l, g), new aed.a() {

                final aee._cls1 a;

            
            {
                a = aee._cls1.this;
                super();
            }
            }));
            b.a(aee.e(b));
            return;
        }
    }

    _cls1.a(aee aee1, String s)
    {
        b = aee1;
        a = s;
        super();
    }
}
