// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;


// Referenced classes of package com.amazon.device.crashmanager:
//            ArtifactUploader

public class mNumArtifactsFailed
{

    private final mNumArtifactsUploaded mCrashUploadStatus;
    private final int mNumArtifactsFailed;
    private final int mNumArtifactsUploaded;
    final ArtifactUploader this$0;

    public mNumArtifactsFailed getCrashUploadStatus()
    {
        return mCrashUploadStatus;
    }

    public int getNumArtifactsFailed()
    {
        return mNumArtifactsFailed;
    }

    public int getNumArtifactsUploaded()
    {
        return mNumArtifactsUploaded;
    }

    public ( )
    {
        this(, 0, 0);
    }

    public <init>(<init> <init>1, int i, int j)
    {
        this$0 = ArtifactUploader.this;
        super();
        mCrashUploadStatus = <init>1;
        mNumArtifactsUploaded = i;
        mNumArtifactsFailed = j;
    }
}
