// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.widgets;

import android.content.Context;
import android.view.View;
import com.google.sample.castcompanionlibrary.cast.exceptions.CastException;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.OnFailedListener;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;

// Referenced classes of package com.google.sample.castcompanionlibrary.widgets:
//            MiniController

public static interface 
    extends OnFailedListener
{

    public abstract void onPlayPauseClicked(View view)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException;

    public abstract void onTargetActivityInvoked(Context context)
        throws TransientNetworkDisconnectionException, NoConnectionException;
}
