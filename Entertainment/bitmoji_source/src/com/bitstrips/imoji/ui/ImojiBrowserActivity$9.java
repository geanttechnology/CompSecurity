// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.models.Templates;
import com.bitstrips.imoji.ui.adapters.ImojiPagerAdapter;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserActivity

class this._cls0
    implements com.bitstrips.imoji.manager.sCallback
{

    final ImojiBrowserActivity this$0;

    public void success(Templates templates, Response response)
    {
        imojiPagerAdapter.updateTemplates(templates);
        ImojiBrowserActivity.access$400(ImojiBrowserActivity.this);
    }

    public volatile void success(Object obj, Response response)
    {
        success((Templates)obj, response);
    }

    ter()
    {
        this$0 = ImojiBrowserActivity.this;
        super();
    }
}
