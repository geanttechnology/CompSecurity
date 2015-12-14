// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import java.io.File;

// Referenced classes of package com.amazon.gallery.thor.app.service:
//            VideoTranscodeService

public static interface 
{

    public abstract void onVideoTranscodeCancelled(String s);

    public abstract void onVideoTranscodeCompleted(String s, File file);

    public abstract void onVideoTranscodeFailed(String s);

    public abstract void onVideoTranscodeStarted(String s);
}
