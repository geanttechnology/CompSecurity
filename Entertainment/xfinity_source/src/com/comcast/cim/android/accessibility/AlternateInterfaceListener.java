// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.view.View;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            SpeechListener, SpeechDelegate, TalkDelegate

public interface AlternateInterfaceListener
{

    public abstract void addSpeechListener(SpeechListener speechlistener);

    public abstract SpeechDelegate getSpeechDelegate();

    public abstract TalkDelegate getTalkDelegate();

    public abstract boolean isAccessibilityEnabled();

    public abstract void removeSpeechListener(SpeechListener speechlistener);

    public abstract void setupPassiveGestureDetector(View view, int i);
}
