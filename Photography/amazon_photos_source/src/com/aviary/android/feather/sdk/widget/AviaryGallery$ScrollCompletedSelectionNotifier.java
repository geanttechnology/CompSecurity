// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryGallery

private class <init>
    implements Runnable
{

    final AviaryGallery this$0;

    public void run()
    {
        if (mDataChanged)
        {
            if (getAdapter() != null)
            {
                post(this);
            }
            return;
        } else
        {
            AviaryGallery.access$200(AviaryGallery.this);
            return;
        }
    }

    private ()
    {
        this$0 = AviaryGallery.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
