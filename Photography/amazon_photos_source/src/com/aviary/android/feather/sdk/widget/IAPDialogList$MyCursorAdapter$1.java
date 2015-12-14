// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.widget.ImageView;
import it.sephiroth.android.library.picasso.Callback;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            IAPDialogList

class val.iconPath
    implements Callback
{

    final val.iconPath this$1;
    final ewHolder val$holder;
    final String val$iconPath;

    public void onError()
    {
        val$holder.icon.setTag(null);
    }

    public void onSuccess()
    {
        val$holder.icon.setTag(Integer.valueOf(val$iconPath.hashCode()));
    }

    ewHolder()
    {
        this$1 = final_ewholder;
        val$holder = ewholder1;
        val$iconPath = String.this;
        super();
    }
}
