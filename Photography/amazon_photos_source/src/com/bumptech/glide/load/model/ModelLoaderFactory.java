// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.content.Context;

// Referenced classes of package com.bumptech.glide.load.model:
//            GenericLoaderFactory, ModelLoader

public interface ModelLoaderFactory
{

    public abstract ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory);

    public abstract void teardown();
}
