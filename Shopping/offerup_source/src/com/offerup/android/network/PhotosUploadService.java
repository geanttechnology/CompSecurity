// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import e.a;
import retrofit.mime.TypedFile;

public interface PhotosUploadService
{

    public abstract a upload(String s, String s1, String s2, String s3, String s4, String s5, TypedFile typedfile);
}
