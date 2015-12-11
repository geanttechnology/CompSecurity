// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.helper;

import android.location.Location;

public interface SpeechLocationHelper
{

    public abstract Location getAndroidLocation();

    public abstract String getXGeoLocation();

    public abstract boolean shouldSendLocation();
}
