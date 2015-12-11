// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import android.os.Handler;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdView

final class a
    implements Runnable
{

    final String a;
    final a b;

    public final void run()
    {
        b.b.handleClick(a);
    }

    llback(llback llback, String s)
    {
        b = llback;
        a = s;
        super();
    }

    // Unreferenced inner class com/rhythmnewmedia/sdk/display/AdView$1

/* anonymous class */
    final class AdView._cls1
        implements com.rhythmnewmedia.sdk.util.Util.ProcessCallback
    {

        final AdView a;

        public final void process(String s)
        {
            if (a.getHandler() != null)
            {
                a.getHandler().post(new AdView._cls1._cls1(this, s));
                return;
            } else
            {
                a.handleClick(s);
                return;
            }
        }

            
            {
                a = adview;
                super();
            }
    }

}
