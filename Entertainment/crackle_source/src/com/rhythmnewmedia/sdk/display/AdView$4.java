// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import com.rhythmnewmedia.sdk.y;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdView

final class a
    implements Runnable
{

    final AdView a;

    public final void run()
    {
        try
        {
            a.close();
            return;
        }
        catch (Exception exception)
        {
            y.a(exception, (new StringBuilder()).append("While resetting the AdView ").append(exception.getMessage()).toString(), new Object[0]);
        }
    }

    (AdView adview)
    {
        a = adview;
        super();
    }
}
