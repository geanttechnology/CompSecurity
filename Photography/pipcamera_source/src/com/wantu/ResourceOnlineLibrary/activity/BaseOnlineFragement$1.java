// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.activity;

import android.util.Log;
import android.widget.GridView;
import com.wantu.ResourceOnlineLibrary.Model.OnlineResImageAdapter;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.activity:
//            BaseOnlineFragement

class a
    implements android.view.balLayoutListener
{

    final GridView a;
    final BaseOnlineFragement b;

    public void onGlobalLayout()
    {
        if (b.b.getNumColumns() == 0)
        {
            int i = (int)Math.floor(a.getWidth() / (BaseOnlineFragement.a(b) + BaseOnlineFragement.b(b)));
            if (i > 0)
            {
                int j = a.getWidth() / i;
                int k = BaseOnlineFragement.b(b);
                b.b.setNumColumns(i);
                b.b.setItemHeight((j - k) + BaseOnlineFragement.c(b));
                Log.d(BaseOnlineFragement.d(b), (new StringBuilder()).append("onCreateView - numColumns set to ").append(i).toString());
            }
        }
    }

    (BaseOnlineFragement baseonlinefragement, GridView gridview)
    {
        b = baseonlinefragement;
        a = gridview;
        super();
    }
}
