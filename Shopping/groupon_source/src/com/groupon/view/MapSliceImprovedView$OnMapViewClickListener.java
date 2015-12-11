// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import com.groupon.callbacks.OnMapSliceClickListener;

// Referenced classes of package com.groupon.view:
//            MapSliceImprovedView

private class <init>
    implements android.view.ner
{

    final MapSliceImprovedView this$0;

    public void onClick(View view)
    {
        if (MapSliceImprovedView.access$200(MapSliceImprovedView.this) == null) goto _L2; else goto _L1
_L1:
        view.getId();
        JVM INSTR lookupswitch 5: default 64
    //                   2131755717: 65
    //                   2131755857: 133
    //                   2131756021: 82
    //                   2131756023: 99
    //                   2131756026: 116;
           goto _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        return;
_L3:
        MapSliceImprovedView.access$200(MapSliceImprovedView.this).onViewClicked(view, this._fld0);
        return;
_L5:
        MapSliceImprovedView.access$200(MapSliceImprovedView.this).onViewClicked(view, S);
        return;
_L6:
        MapSliceImprovedView.access$200(MapSliceImprovedView.this).onViewClicked(view, LE_LOCATIONS);
        return;
_L7:
        MapSliceImprovedView.access$200(MapSliceImprovedView.this).onViewClicked(view, this._fld0);
        return;
_L4:
        MapSliceImprovedView.access$200(MapSliceImprovedView.this).onViewClicked(view, E);
        return;
    }

    private ()
    {
        this$0 = MapSliceImprovedView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
