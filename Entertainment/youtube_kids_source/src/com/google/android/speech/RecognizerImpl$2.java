// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;

import com.google.android.speech.audio.AudioInputStreamFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package com.google.android.speech:
//            RecognizerImpl

class val.audio
    implements AudioInputStreamFactory
{

    final RecognizerImpl this$0;
    final byte val$audio[];

    public InputStream createInputStream()
    {
        return new ByteArrayInputStream(val$audio);
    }

    treamFactory()
    {
        this$0 = final_recognizerimpl;
        val$audio = _5B_B.this;
        super();
    }
}
