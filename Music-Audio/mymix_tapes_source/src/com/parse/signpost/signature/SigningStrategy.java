// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.signpost.signature;

import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import java.io.Serializable;

public interface SigningStrategy
    extends Serializable
{

    public abstract String writeSignature(String s, HttpRequest httprequest, HttpParameters httpparameters);
}
