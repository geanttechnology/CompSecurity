// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.ui;

import android.app.Dialog;
import com.amazon.shopapp.voice.search.VoiceSearchController;

public interface SpeechPanel
{

    public abstract void dismiss();

    public abstract Dialog getDialog();

    public abstract VoiceSearchController getVoiceSearchController();

    public abstract boolean isActive();
}
