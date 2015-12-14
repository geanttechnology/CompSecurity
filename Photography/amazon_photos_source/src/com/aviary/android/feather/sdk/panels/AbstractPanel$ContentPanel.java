// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.view.LayoutInflater;
import android.view.View;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractPanel

public static interface yListener
{

    public abstract View getContentView();

    public abstract View getContentView(LayoutInflater layoutinflater);

    public abstract void setOnReadyListener(yListener ylistener);
}
