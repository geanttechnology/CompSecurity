// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.interfaces;

import android.net.Uri;

// Referenced classes of package com.facebook.drawee.interfaces:
//            DraweeController

public interface SimpleDraweeControllerBuilder
{

    public abstract DraweeController build();

    public abstract SimpleDraweeControllerBuilder setCallerContext(Object obj);

    public abstract SimpleDraweeControllerBuilder setOldController(DraweeController draweecontroller);

    public abstract SimpleDraweeControllerBuilder setUri(Uri uri);
}
