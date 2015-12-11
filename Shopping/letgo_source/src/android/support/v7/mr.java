// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

// Referenced classes of package android.support.v7:
//            ms, mq, ua, tp, 
//            mc

public class mr
{

    public mr()
    {
    }

    private mq a(Context context, VersionInfoParcel versioninfoparcel, ua ua1, mc mc)
    {
        context = new ms(context, versioninfoparcel, mc);
        context.a(new mq.a(ua1, context) {

            final ua a;
            final mq b;
            final mr c;

            public void a()
            {
                a.b(b);
            }

            
            {
                c = mr.this;
                a = ua1;
                b = mq1;
                super();
            }
        });
        return context;
    }

    static mq a(mr mr1, Context context, VersionInfoParcel versioninfoparcel, ua ua1, mc mc)
    {
        return mr1.a(context, versioninfoparcel, ua1, mc);
    }

    public Future a(Context context, VersionInfoParcel versioninfoparcel, String s, mc mc)
    {
        ua ua1 = new ua();
        tp.a.post(new Runnable(context, versioninfoparcel, ua1, mc, s) {

            final Context a;
            final VersionInfoParcel b;
            final ua c;
            final mc d;
            final String e;
            final mr f;

            public void run()
            {
                mr.a(f, a, b, c, d).b(e);
            }

            
            {
                f = mr.this;
                a = context;
                b = versioninfoparcel;
                c = ua1;
                d = mc;
                e = s;
                super();
            }
        });
        return ua1;
    }
}
