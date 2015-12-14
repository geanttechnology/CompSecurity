// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


public interface DataUploadResult
{
    public static interface DataResult
    {

        public abstract int getChecksum();

        public abstract int getDataCount();

        public abstract int getForceUpload();

        public abstract String getId();

        public abstract String getStatus();

        public abstract String getType();
    }


    public abstract DataResult getDataResult(int i);

    public abstract int getDataResultCount();

    public abstract boolean isVocRegenerated();
}
