// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.testandtarget;


public final class MissingOnLoadConsumerException extends Exception
{

    private static final String defaultMessage = "Mbox.addOnloadConsumer() must be called before loading Mbox.";
    private static final long serialVersionUID = 0x2fe0061e145ff9a5L;

    public MissingOnLoadConsumerException()
    {
        super("Mbox.addOnloadConsumer() must be called before loading Mbox.");
    }
}
