// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;


// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserFragment, ImagesGridViewsWrapper

class this._cls0
    implements atarChangeListener
{

    final ImojiBrowserFragment this$0;

    public void onChanged()
    {
        imagesGridViewsWrapper.notifyDataSetChanged();
    }

    atarChangeListener()
    {
        this$0 = ImojiBrowserFragment.this;
        super();
    }
}
