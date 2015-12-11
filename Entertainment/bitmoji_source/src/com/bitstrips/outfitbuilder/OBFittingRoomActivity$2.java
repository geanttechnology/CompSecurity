// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder;


// Referenced classes of package com.bitstrips.outfitbuilder:
//            OBFittingRoomActivity

class this._cls0
    implements android.support.v4.view.stener
{

    final OBFittingRoomActivity this$0;

    public void onPageScrollStateChanged(int i)
    {
        if (i == 1)
        {
            OBFittingRoomActivity.access$400(OBFittingRoomActivity.this);
        } else
        if (i == 0)
        {
            OBFittingRoomActivity.access$300(OBFittingRoomActivity.this, currentlySelectedOutfit);
            return;
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        OBFittingRoomActivity.access$300(OBFittingRoomActivity.this, i);
    }

    er()
    {
        this$0 = OBFittingRoomActivity.this;
        super();
    }
}
