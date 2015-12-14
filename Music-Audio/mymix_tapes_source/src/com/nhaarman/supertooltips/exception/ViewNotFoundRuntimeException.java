// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.supertooltips.exception;


public class ViewNotFoundRuntimeException extends RuntimeException
{

    public ViewNotFoundRuntimeException()
    {
        super("View not found for this resource id. Are you sure it exists?");
    }
}
