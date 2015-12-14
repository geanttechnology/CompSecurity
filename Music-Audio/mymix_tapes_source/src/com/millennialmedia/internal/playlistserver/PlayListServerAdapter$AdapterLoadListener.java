// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.playlistserver;

import com.millennialmedia.internal.PlayList;

// Referenced classes of package com.millennialmedia.internal.playlistserver:
//            PlayListServerAdapter

public static interface 
{

    public abstract void loadFailed(Throwable throwable);

    public abstract void loadSucceeded(PlayList playlist);
}
