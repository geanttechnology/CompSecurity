// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;


// Referenced classes of package it.sephiroth.android.library.tooltip:
//            TooltipManager, TooltipView

class this._cls0
    implements seListener
{

    final TooltipManager this$0;

    public void onClose(TooltipView tooltipview)
    {
        hide(tooltipview.getTooltipId());
    }

    seListener()
    {
        this$0 = TooltipManager.this;
        super();
    }
}
