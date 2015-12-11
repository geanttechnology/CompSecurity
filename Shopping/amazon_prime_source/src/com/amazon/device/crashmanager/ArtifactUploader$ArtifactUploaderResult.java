// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;


// Referenced classes of package com.amazon.device.crashmanager:
//            ArtifactUploader

private class mUploadErrorMessage
{

    private final mUploadErrorTag mArtifactUploadStatus;
    private final String mCrashDescriptor;
    private final String mUploadErrorMessage;
    private final String mUploadErrorTag;
    final ArtifactUploader this$0;

    public mUploadErrorMessage getArtifactUploadStatus()
    {
        return mArtifactUploadStatus;
    }

    public String getCrashDescriptor()
    {
        return mCrashDescriptor;
    }

    public String getUploadErrorMessage()
    {
        return mUploadErrorMessage;
    }

    public String getUploadErrorTag()
    {
        return mUploadErrorTag;
    }


    public ( , String s)
    {
        this(, s, null, null);
    }

    public <init>(<init> <init>1, String s, String s1, String s2)
    {
        this$0 = ArtifactUploader.this;
        super();
        if (<init>1 == null)
        {
            throw new IllegalArgumentException("artifact upload status cannot be null");
        } else
        {
            mArtifactUploadStatus = <init>1;
            mCrashDescriptor = s;
            mUploadErrorTag = s1;
            mUploadErrorMessage = s2;
            return;
        }
    }
}
