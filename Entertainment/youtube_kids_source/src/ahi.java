// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.embedded.Greco3Grammar;
import com.google.android.speech.embedded.Greco3Mode;
import com.google.android.speech.embedded.Greco3ModeSelector;

final class ahi
    implements Greco3ModeSelector
{

    ahi(ahf ahf)
    {
    }

    public final Greco3Mode getFallbackMode(Greco3Mode greco3mode, Greco3Grammar greco3grammar)
    {
        return greco3mode;
    }

    public final Greco3Mode getMode(Greco3Mode greco3mode, Greco3Grammar greco3grammar)
    {
        return greco3mode;
    }
}
