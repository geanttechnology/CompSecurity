// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.content.DialogInterface;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkCollectionsFragment

class this._cls0
    implements android.content.ner
{

    final NetworkCollectionsFragment this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        getLoadingViewDelegate().onLoadingFinished();
    }

    ()
    {
        this$0 = NetworkCollectionsFragment.this;
        super();
    }
}
