// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import f;
import java.io.InputStream;

// Referenced classes of package com.google.android.speech.audio:
//            AudioInputStreamFactory, AudioController

class mNumStreamsCreated
    implements AudioInputStreamFactory
{

    private int mNumStreamsCreated;
    final AudioController this$0;
    final Uri val$recordedAudioUri;

    public InputStream createInputStream()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        i = mNumStreamsCreated;
        mNumStreamsCreated = i + 1;
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        this;
        JVM INSTR monitorexit ;
        return new android.os.or.AutoCloseInputStream(AudioController.access$000(AudioController.this).getContentResolver().openFileDescriptor(val$recordedAudioUri, "r"));
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    am()
    {
        this$0 = final_audiocontroller;
        val$recordedAudioUri = Uri.this;
        super();
        mNumStreamsCreated = 0;
    }
}
