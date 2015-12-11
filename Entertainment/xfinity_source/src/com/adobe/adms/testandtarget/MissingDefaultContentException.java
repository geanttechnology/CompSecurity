// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.testandtarget;


public final class MissingDefaultContentException extends Exception
{

    private static final String defaultMessage = "Mbox.setDefaultContent() must be called before loading Mbox.";
    private static final long serialVersionUID = 0xf20d97a1a33fae50L;

    public MissingDefaultContentException()
    {
        super("Mbox.setDefaultContent() must be called before loading Mbox.");
    }
}
