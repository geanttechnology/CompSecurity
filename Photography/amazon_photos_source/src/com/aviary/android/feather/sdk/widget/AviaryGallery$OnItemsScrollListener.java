// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.view.View;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryGallery, AviaryAdapterView

public static interface 
{

    public abstract void onScroll(AviaryAdapterView aviaryadapterview, View view, int i, long l);

    public abstract void onScrollFinished(AviaryAdapterView aviaryadapterview, View view, int i, long l);

    public abstract void onScrollStarted(AviaryAdapterView aviaryadapterview, View view, int i, long l);
}
