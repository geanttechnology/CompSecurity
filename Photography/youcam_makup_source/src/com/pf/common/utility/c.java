// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.io.OutputStream;

public interface c
{

    public abstract Bitmap a(InputStream inputstream, android.graphics.BitmapFactory.Options options);

    public abstract String a();

    public abstract void a(Bitmap bitmap, OutputStream outputstream);
}
