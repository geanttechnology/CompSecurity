// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.internal.gs;
import java.util.concurrent.Future;

public class st
{

    public st()
    {
    }

    public Future a(Context context, gs gs, String s)
    {
        abs abs1 = new abs();
        aca.a.post(new Runnable(context, gs, abs1, s) {

            final Context a;
            final gs b;
            final abs c;
            final String d;
            final st e;

            public void run()
            {
                e.a(a, b, c).a(d);
            }

            
            {
                e = st.this;
                a = context;
                b = gs;
                c = abs1;
                d = s;
                super();
            }
        });
        return abs1;
    }

    protected sr a(Context context, gs gs, abs abs1)
    {
        context = new su(context, gs);
        context.a(new ss(abs1, context) {

            final abs a;
            final sr b;
            final st c;

            public void a()
            {
                a.a(b);
            }

            
            {
                c = st.this;
                a = abs1;
                b = sr1;
                super();
            }
        });
        return context;
    }
}
