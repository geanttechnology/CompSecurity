// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.endpointing;

import ewg;

public interface EndpointerEventProcessor
{

    public abstract void process(ewg ewg);

    public abstract void updateProgress(int i, long l);
}
