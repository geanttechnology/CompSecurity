// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering;

import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.rendering:
//            RenderView

class a
    implements Runnable
{

    final String a;
    final RenderView b;

    public void run()
    {
        String s;
label0:
        {
            if (!RenderView.a(b))
            {
                s = (new StringBuilder()).append("javascript:try{").append(a).append("}catch(e){}").toString();
                Logger.a(com.inmobi.commons.core.utilities.alLogLevel.INTERNAL, RenderView.q(), (new StringBuilder()).append("Injecting javascript:").append(s).toString());
                if (android.os..SDK_INT >= 19)
                {
                    break label0;
                }
                RenderView.a(b, s);
            }
            return;
        }
        RenderView.b(b, s);
    }

    Logger(RenderView renderview, String s)
    {
        b = renderview;
        a = s;
        super();
    }
}
