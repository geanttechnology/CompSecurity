// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.download;

import java.io.OutputStream;

public interface Downloader
{

    public abstract boolean downloadToLocalStreamByUrl(String s, OutputStream outputstream);
}
