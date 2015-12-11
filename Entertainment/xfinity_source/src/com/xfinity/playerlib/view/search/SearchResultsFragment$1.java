// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.view.View;
import android.widget.AdapterView;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.xfinity.playerlib.model.dibic.DibicProgram;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

class this._cls0
    implements android.widget.istener
{

    final SearchResultsFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (Tuple)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
        showProgramDetail((DibicProgram)((Tuple) (adapterview)).e2);
    }

    ()
    {
        this$0 = SearchResultsFragment.this;
        super();
    }
}
