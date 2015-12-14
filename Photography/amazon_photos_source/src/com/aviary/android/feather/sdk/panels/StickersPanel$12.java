// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;


// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            StickersPanel, SimpleStatusMachine

class this._cls0
    implements com.aviary.android.feather.sdk.widget.View.OnOpacityChangeListener
{

    final StickersPanel this$0;

    public void onChangeOpacity()
    {
        StickersPanel.access$200(StickersPanel.this).setStatus(3);
    }

    public void onLockOpacity()
    {
        if (StickersPanel.access$200(StickersPanel.this).getCurrentStatus() == 3)
        {
            StickersPanel.access$200(StickersPanel.this).setStatus(StickersPanel.access$200(StickersPanel.this).getPreviousStatus());
        }
    }

    ne()
    {
        this$0 = StickersPanel.this;
        super();
    }
}
