// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.interfaces;


public interface ICreativeRenditionAsset
{

    public abstract int getBytes();

    public abstract String getContent();

    public abstract String getContentType();

    public abstract String getMimeType();

    public abstract String getURL();

    public abstract void setBytes(int i);

    public abstract void setContent(String s);

    public abstract void setContentType(String s);

    public abstract void setMimeType(String s);

    public abstract void setURL(String s);
}
