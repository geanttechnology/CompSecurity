// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.interfaces;

import my.googlemusic.play.internet.Response;

// Referenced classes of package my.googlemusic.play.interfaces:
//            Server

public static interface 
{

    public abstract void onFailure(Response response);

    public abstract void onProgress(int i);

    public abstract void onSuccess(Object obj);
}
