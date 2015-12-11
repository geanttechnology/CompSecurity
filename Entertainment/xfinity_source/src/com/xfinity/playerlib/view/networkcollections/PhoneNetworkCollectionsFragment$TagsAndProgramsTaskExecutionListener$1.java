// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            PhoneNetworkCollectionsFragment

class this._cls1
    implements com.comcast.cim.android.image.utionListener._cls1
{

    final is._cls0 this$1;

    public void onLoad(ImageView imageview, String s, Bitmap bitmap)
    {
    }

    public void onLoadError(ImageView imageview, String s)
    {
        PhoneNetworkCollectionsFragment.access$500(_fld0).setVisibility(8);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
