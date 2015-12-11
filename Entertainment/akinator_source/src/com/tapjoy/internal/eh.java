// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJConnectListener;
import java.util.Hashtable;

// Referenced classes of package com.tapjoy.internal:
//            eg, TapjoyConnectAutoRetry

final class eh extends eg
{

    private final TapjoyConnectAutoRetry b = new TapjoyConnectAutoRetry() {

        final eh a;

        protected final boolean a(Context context, String s, Hashtable hashtable, TJConnectListener tjconnectlistener)
        {
            return eh.a(a, context, s, hashtable, tjconnectlistener);
        }

            
            {
                a = eh.this;
                super();
            }
    };

    eh()
    {
    }

    static boolean a(eh eh1, Context context, String s, Hashtable hashtable, TJConnectListener tjconnectlistener)
    {
        return eh1.eg.a(context, s, hashtable, tjconnectlistener);
    }

    public final boolean a(Context context, String s, Hashtable hashtable, TJConnectListener tjconnectlistener)
    {
        return b.connect(context, s, hashtable, tjconnectlistener);
    }
}
