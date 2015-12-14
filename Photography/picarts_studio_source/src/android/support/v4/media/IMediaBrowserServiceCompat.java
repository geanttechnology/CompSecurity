// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.os.ResultReceiver;

// Referenced classes of package android.support.v4.media:
//            IMediaBrowserServiceCompatCallbacks

public interface IMediaBrowserServiceCompat
    extends IInterface
{

    public abstract void addSubscription(String s, IMediaBrowserServiceCompatCallbacks imediabrowserservicecompatcallbacks);

    public abstract void connect(String s, Bundle bundle, IMediaBrowserServiceCompatCallbacks imediabrowserservicecompatcallbacks);

    public abstract void disconnect(IMediaBrowserServiceCompatCallbacks imediabrowserservicecompatcallbacks);

    public abstract void getMediaItem(String s, ResultReceiver resultreceiver);

    public abstract void removeSubscription(String s, IMediaBrowserServiceCompatCallbacks imediabrowserservicecompatcallbacks);
}
