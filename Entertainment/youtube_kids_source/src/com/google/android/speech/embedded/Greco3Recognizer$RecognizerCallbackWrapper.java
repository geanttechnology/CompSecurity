// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import dap;
import ewc;
import ewf;
import ewg;
import ewk;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Callback

class <init>
    implements ewc
{

    private Greco3Callback mDelegate;

    public void handleAudioLevelEvent(ewf ewf)
    {
        if (mDelegate != null)
        {
            mDelegate.handleAudioLevelEvent(ewf);
        }
    }

    public void handleEndpointerEvent(ewg ewg)
    {
        if (mDelegate != null)
        {
            mDelegate.handleEndpointerEvent(ewg);
        }
    }

    public void handleRecognitionEvent(ewk ewk)
    {
        if (mDelegate != null)
        {
            mDelegate.handleRecognitionEvent(ewk);
        }
    }

    public void invalidate()
    {
        mDelegate = null;
    }

    public void notifyError(dap dap)
    {
        if (mDelegate != null)
        {
            mDelegate.handleError(dap);
        }
    }

    public void updateProgress(long l)
    {
        if (mDelegate != null)
        {
            mDelegate.handleProgressUpdate(l);
        }
    }


/*
    static Greco3Callback access$102( , Greco3Callback greco3callback)
    {
        .mDelegate = greco3callback;
        return greco3callback;
    }

*/

    private mDelegate()
    {
    }

    mDelegate(mDelegate mdelegate)
    {
        this();
    }
}
