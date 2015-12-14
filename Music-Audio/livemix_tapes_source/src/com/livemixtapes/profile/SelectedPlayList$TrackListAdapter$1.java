// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.view.View;
import java.util.Map;

// Referenced classes of package com.livemixtapes.profile:
//            SelectedPlayList

class val.trackMap
    implements android.view.stAdapter._cls1
{

    final val.trackMap this$1;
    private final Map val$trackMap;

    public void onClick(View view)
    {
        cess._mth0(cess._mth2(this._cls1.this).adapter, val$trackMap);
        cess._mth2(this._cls1.this).adapter.tifyDataSetChanged();
        (new ks(cess._mth2(this._cls1.this), 2)).execute(new String[] {
            val$trackMap.get("track_dbid").toString()
        });
    }

    ks()
    {
        this$1 = final_ks;
        val$trackMap = Map.this;
        super();
    }
}
