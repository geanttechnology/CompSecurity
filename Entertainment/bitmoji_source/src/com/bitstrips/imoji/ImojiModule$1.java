// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji;

import android.app.Application;
import com.bitstrips.imoji.util.WebUtils;
import retrofit.RequestInterceptor;

// Referenced classes of package com.bitstrips.imoji:
//            ImojiModule

class this._cls0
    implements RequestInterceptor
{

    final ImojiModule this$0;

    public void intercept(retrofit.ptor.RequestFacade requestfacade)
    {
        requestfacade.addHeader("User-Agent", System.getProperty("http.agent"));
        requestfacade.addHeader("Bitmoji-User-Agent", WebUtils.getBitmojiUserAgent(ImojiModule.access$000(ImojiModule.this)));
        requestfacade.addHeader(ImojiModule.access$000(ImojiModule.this).getString(0x7f060001), ImojiModule.access$000(ImojiModule.this).getString(0x7f060002));
    }

    tFacade()
    {
        this$0 = ImojiModule.this;
        super();
    }
}
