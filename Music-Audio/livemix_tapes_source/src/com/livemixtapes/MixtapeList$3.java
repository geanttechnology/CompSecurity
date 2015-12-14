// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            MixtapeList

class this._cls0
    implements android.widget.ItemClickListener
{

    final MixtapeList this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        showMixtapeFragment(mContext, new HashMap((Map)mixtapeList.get(i)));
    }

    emClickListener()
    {
        this$0 = MixtapeList.this;
        super();
    }
}
