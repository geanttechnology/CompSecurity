// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface InbandImage
{

    public abstract String getBase64EncodedImage();

    public abstract String getContentType();

    public abstract String getUrl();

    public abstract void setBase64EncodedImage(String s);

    public abstract void setContentType(String s);

    public abstract void setUrl(String s);
}
