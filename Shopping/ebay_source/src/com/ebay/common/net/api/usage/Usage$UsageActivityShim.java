// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.usage;

import android.os.Bundle;
import com.ebay.nautilus.shell.app.ActivityShim;

// Referenced classes of package com.ebay.common.net.api.usage:
//            Usage

public static final class  extends ActivityShim
{

    protected void onCreate(Bundle bundle)
    {
        Usage.access$300().startActivity(getActivity().getClass());
    }

    protected void onDestroy()
    {
        Usage.access$300().endActivity(getActivity().getClass());
    }

    public ()
    {
    }
}
