// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;


// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Mode, Greco3Grammar

public interface Greco3ModeSelector
{

    public abstract Greco3Mode getFallbackMode(Greco3Mode greco3mode, Greco3Grammar greco3grammar);

    public abstract Greco3Mode getMode(Greco3Mode greco3mode, Greco3Grammar greco3grammar);
}
