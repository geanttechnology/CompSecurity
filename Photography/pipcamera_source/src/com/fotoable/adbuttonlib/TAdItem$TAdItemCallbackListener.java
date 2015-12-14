// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;


// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdItem

public interface 
{

    public abstract void onAdItemClicked(TAdItem taditem);

    public abstract void onError(Exception exception);

    public abstract void onLoaded(TAdItem taditem);
}
