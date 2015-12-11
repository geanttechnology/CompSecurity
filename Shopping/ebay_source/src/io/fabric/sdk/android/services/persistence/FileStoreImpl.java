// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.persistence;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import java.io.File;

public class FileStoreImpl
{

    private final String contentPath;
    private final Context context;
    private final String legacySupport;

    public FileStoreImpl(Kit kit)
    {
        if (kit.getContext() == null)
        {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        } else
        {
            context = kit.getContext();
            contentPath = kit.getPath();
            legacySupport = (new StringBuilder()).append("Android/").append(context.getPackageName()).toString();
            return;
        }
    }

    public File getFilesDir()
    {
        return prepare(context.getFilesDir());
    }

    File prepare(File file)
    {
        if (file != null)
        {
            if (file.exists() || file.mkdirs())
            {
                return file;
            }
            Fabric.getLogger().w("Fabric", "Couldn't create file");
        } else
        {
            Fabric.getLogger().d("Fabric", "Null File");
        }
        return null;
    }
}
