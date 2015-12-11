// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.mediation;

import android.view.View;

// Referenced classes of package com.apprupt.sdk.mediation:
//            AdWrapper, Size

public interface InlineAdWrapper
    extends AdWrapper
{
    public static interface Listener
        extends AdWrapper.Listener
    {

        public abstract void onResize(InlineAdWrapper inlineadwrapper, Size size);
    }


    public abstract Listener getListener();

    public abstract Size getSize();

    public abstract View getView();

    public abstract boolean isBusy();

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void prepare(Runnable runnable);

    public abstract void setListener(Listener listener);
}
