// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;

import eyc;
import java.util.List;

public interface SpeechSettings
{

    public abstract eyc getConfiguration();

    public abstract List getExperimentIds();

    public abstract String getInstallId();

    public abstract int getServerEndpointingActivityTimeoutMs();

    public abstract String getSpokenLocaleBcp47();

    public abstract String getVoiceSearchTokenType();

    public abstract boolean isDebugAudioLoggingEnabled();

    public abstract boolean isEmbeddedEndpointingEnabled();

    public abstract boolean isEmbeddedRecognitionOnlyForDebug();

    public abstract boolean isNetworkRecognitionOnlyForDebug();

    public abstract boolean isPersonalizationEnabled();

    public abstract boolean isProfanityFilterEnabled();

    public abstract boolean isS3DebugLoggingEnabled();

    public abstract boolean isServerEndpointingEnabled();

    public abstract boolean isSoundSearchEnabled();

    public abstract void setSpokenLanguageBcp47(String s, boolean flag);
}
