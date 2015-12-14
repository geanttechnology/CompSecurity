// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.nativecode;

import com.facebook.common.soloader.SoLoaderShim;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImagePipelineNativeLoader
{

    public static final List DEPENDENCIES;
    public static final String DSO_NAME = "imagepipeline";

    public ImagePipelineNativeLoader()
    {
    }

    public static void load()
    {
        for (int i = 0; i < DEPENDENCIES.size(); i++)
        {
            SoLoaderShim.loadLibrary((String)DEPENDENCIES.get(i));
        }

        SoLoaderShim.loadLibrary("imagepipeline");
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("webp");
        DEPENDENCIES = Collections.unmodifiableList(arraylist);
    }
}
