// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryGallery

private class this._cls0
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
            fireOnSelected();
            return;
        }
    }

    private ()
    {
        this$0 = AviaryGallery.this;
        super();
    }
}
