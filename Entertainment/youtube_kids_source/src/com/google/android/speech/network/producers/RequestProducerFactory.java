// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.producers;

import com.google.android.speech.params.SessionParams;
import dah;
import java.io.InputStream;

public interface RequestProducerFactory
{

    public abstract void init(SessionParams sessionparams);

    public abstract dah newRequestProducer(InputStream inputstream);

    public abstract void refresh();
}
