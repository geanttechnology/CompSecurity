// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;


// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            ResponseHandler

public interface FFmpegLoadBinaryResponseHandler
    extends ResponseHandler
{

    public abstract void onFailure();

    public abstract void onSuccess();
}
