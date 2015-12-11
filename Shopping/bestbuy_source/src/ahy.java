// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;

public class ahy
{

    public static final px a;
    public static ahr b = new aeq();
    public static ahu c = new aes();
    private static final qf d;
    private static final qe e;

    static qf a()
    {
        return d;
    }

    static 
    {
        d = new qf();
        e = new qe() {

            public int a()
            {
                return 0x7fffffff;
            }

            public afd a(Context context, Looper looper, jg jg1, qa qa1, qo qo, qp qp)
            {
                return new afd(context, looper, context.getPackageName(), qo, qp, "locationServices", jg1.a());
            }

            public qd a(Context context, Looper looper, jg jg1, Object obj, qo qo, qp qp)
            {
                return a(context, looper, jg1, (qa)obj, qo, qp);
            }

        };
        a = new px(e, d, new Scope[0]);
    }
}
