// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.network;


// Referenced classes of package com.inmobi.commons.core.network:
//            NetworkRequest, c, b

public final class com.inmobi.commons.core.network.a
{
    public static interface a
    {

        public abstract void a(c c);

        public abstract void b(c c);
    }


    private NetworkRequest a;
    private a b;

    public com.inmobi.commons.core.network.a(NetworkRequest networkrequest, a a1)
    {
        a = networkrequest;
        b = a1;
    }

    static NetworkRequest a(com.inmobi.commons.core.network.a a1)
    {
        return a1.a;
    }

    static a b(com.inmobi.commons.core.network.a a1)
    {
        return a1.b;
    }

    public void a()
    {
        (new Thread(new Runnable() {

            final com.inmobi.commons.core.network.a a;

            public void run()
            {
                c c1 = (new b(com.inmobi.commons.core.network.a.a(a))).a();
                if (c1.a())
                {
                    com.inmobi.commons.core.network.a.b(a).b(c1);
                    return;
                } else
                {
                    com.inmobi.commons.core.network.a.b(a).a(c1);
                    return;
                }
            }

            
            {
                a = com.inmobi.commons.core.network.a.this;
                super();
            }
        })).start();
    }
}
