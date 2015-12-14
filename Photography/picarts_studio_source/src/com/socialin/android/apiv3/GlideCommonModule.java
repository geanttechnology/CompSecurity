// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.bumptech.glide.c;
import com.socialin.android.apiv3.model.ImageItem;
import java.io.InputStream;
import myobfuscated.ae.a;

public class GlideCommonModule
    implements a
{

    public GlideCommonModule()
    {
    }

    public void applyOptions(Context context, c c)
    {
    }

    public void registerComponents(Context context, Registry registry)
    {
        registry.a(com/socialin/android/apiv3/model/ImageItem, java/io/InputStream, new PicsartModelLoader.Factory());
        registry.a(java/lang/String, java/io/InputStream, new StringModelLoader.Factory());
    }
}
