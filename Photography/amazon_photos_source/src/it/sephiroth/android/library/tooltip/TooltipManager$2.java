// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;


// Referenced classes of package it.sephiroth.android.library.tooltip:
//            TooltipManager, TooltipView

class this._cls0
    implements lTipListener
{

    final TooltipManager this$0;

    public void onHideCompleted(TooltipView tooltipview)
    {
        int i = tooltipview.getTooltipId();
        tooltipview.removeFromParent();
        TooltipManager.access$000(TooltipManager.this);
        TooltipManager.access$100(TooltipManager.this, i);
    }

    public void onShowCompleted(TooltipView tooltipview)
    {
    }

    public void onShowFailed(TooltipView tooltipview)
    {
        remove(tooltipview.getTooltipId());
    }

    lTipListener()
    {
        this$0 = TooltipManager.this;
        super();
    }
}
