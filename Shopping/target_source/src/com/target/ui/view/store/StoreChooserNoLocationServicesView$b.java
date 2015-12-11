// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.target.ui.view.store:
//            StoreChooserNoLocationServicesView

private static class enterZipButton
{

    View enterZipButton;
    LinearLayout placeholderContainer;
    View useLocationButton;

    public (View view)
    {
        placeholderContainer = (LinearLayout)view.findViewById(0x7f1005b7);
        useLocationButton = view.findViewById(0x7f1005b9);
        enterZipButton = view.findViewById(0x7f1005ba);
    }
}
