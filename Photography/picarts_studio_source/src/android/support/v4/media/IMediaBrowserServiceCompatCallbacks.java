// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.os.Bundle;
import android.os.IInterface;
import java.util.List;

public interface IMediaBrowserServiceCompatCallbacks
    extends IInterface
{

    public abstract void onConnect(String s, android.support.v4.media.session.MediaSessionCompat.Token token, Bundle bundle);

    public abstract void onConnectFailed();

    public abstract void onLoadChildren(String s, List list);
}
