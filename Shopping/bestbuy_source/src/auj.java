// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;

public class auj
{

    public static final atr a = new awh();
    public static final aub b = new avk();
    public static final auf c = new avm();
    public static final auo d = new awg();
    public static final aur e = new avv();
    public static final qf f;
    public static final px g;
    private static final qe h;

    static 
    {
        f = new qf();
        h = new qe() {

            public int a()
            {
                return 0x7fffffff;
            }

            public awc a(Context context, Looper looper, jg jg, auk auk1, qo qo, qp qp)
            {
                if (auk1 == null)
                {
                    new auk(new aul());
                }
                return new awc(context, looper, qo, qp);
            }

            public volatile qd a(Context context, Looper looper, jg jg, Object obj, qo qo, qp qp)
            {
                return a(context, looper, jg, (auk)obj, qo, qp);
            }

        };
        g = new px(h, f, new Scope[0]);
    }
}
