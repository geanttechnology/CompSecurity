// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class ImageVideoWrapper
{

    private final ParcelFileDescriptor fileDescriptor;
    private final InputStream streamData;

    public ImageVideoWrapper(InputStream inputstream, ParcelFileDescriptor parcelfiledescriptor)
    {
        streamData = inputstream;
        fileDescriptor = parcelfiledescriptor;
    }

    public ParcelFileDescriptor getFileDescriptor()
    {
        return fileDescriptor;
    }

    public InputStream getStream()
    {
        return streamData;
    }
}
