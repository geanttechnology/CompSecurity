// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            MMWebView

public static interface rams
{

    public abstract void close();

    public abstract boolean expand(rams rams);

    public abstract void onAdLeftApplication();

    public abstract void onClicked();

    public abstract void onFailed();

    public abstract void onLoaded();

    public abstract void onReady();

    public abstract boolean resize(rams rams);

    public abstract void setOrientation(int i);

    public abstract void showCloseIndicator(boolean flag);
}
