// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.embedded.Greco3Mode;
import com.google.android.speech.embedded.GrecoEventLogger;

final class aha
    implements com.google.android.speech.embedded.GrecoEventLogger.Factory
{

    aha(agz agz)
    {
    }

    public final GrecoEventLogger getEventLoggerForMode(Greco3Mode greco3mode)
    {
        return new ahb(this);
    }
}
