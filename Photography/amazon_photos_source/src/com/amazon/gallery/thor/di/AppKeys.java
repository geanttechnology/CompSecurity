// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.di;

import com.amazon.gallery.foundation.utils.di.BeanKey;
import com.amazon.gallery.framework.network.http.senna.SennaSyncListener;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.whisperplay.WhisperPlayConnectionManager;

public interface AppKeys
{

    public static final BeanKey FEATURE_CHECKER = new BeanKey("featureChecker", com/amazon/gallery/thor/app/FeatureChecker);
    public static final BeanKey SENNA_SYNC_LISTENER = new BeanKey("sennaSyncListener", com/amazon/gallery/framework/network/http/senna/SennaSyncListener);
    public static final BeanKey THOR_FREE_TIME = new BeanKey("freeTime", com/amazon/gallery/thor/app/FreeTime);
    public static final BeanKey WHISPER_PLAY_CONNECTION_MANAGER = new BeanKey("whisperPlayConnectionManager", com/amazon/gallery/whisperplay/WhisperPlayConnectionManager);

}
