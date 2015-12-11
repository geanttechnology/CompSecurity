// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;


// Referenced classes of package com.amazon.device.crashmanager:
//            ArtifactUploader

static class tifactUploadStatus
{

    static final int $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[];
    static final int $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse[];

    static 
    {
        $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse = new int[com.amazon.device.utils..values().length];
        try
        {
            $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse[com.amazon.device.utils..SUCCESS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse[com.amazon.device.utils..CLIENT_ERROR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$device$utils$DetUtil$DetResponse[com.amazon.device.utils..SERVER_ERROR.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus = new int[tifactUploadStatus.values().length];
        try
        {
            $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[tifactUploadStatus.SUCCESS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[tifactUploadStatus.SKIP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[tifactUploadStatus.DE_DUPED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[tifactUploadStatus.FAILED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus[tifactUploadStatus.SERVER_ERROR.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
