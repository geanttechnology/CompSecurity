// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;


// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            ResponseHandler

public interface FFmpegExecuteResponseHandler
    extends ResponseHandler
{

    public abstract void onFailure(String s);

    public abstract void onProgress(String s);

    public abstract void onSuccess(String s);
}
