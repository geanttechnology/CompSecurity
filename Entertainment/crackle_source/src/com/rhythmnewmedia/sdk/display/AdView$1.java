// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import android.os.Handler;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdView

final class a
    implements com.rhythmnewmedia.sdk.util.essCallback
{

    final AdView a;

    public final void process(String s)
    {
        if (a.getHandler() != null)
        {
            a.getHandler().post(new Runnable(s) {

                final String a;
                final AdView._cls1 b;

                public final void run()
                {
                    b.a.handleClick(a);
                }

            
            {
                b = AdView._cls1.this;
                a = s;
                super();
            }
            });
            return;
        } else
        {
            a.handleClick(s);
            return;
        }
    }

    _cls1.a(AdView adview)
    {
        a = adview;
        super();
    }
}
