// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface ahs
{

    public abstract File a(String s);

    public abstract boolean a(String s, Bitmap bitmap)
        throws IOException;

    public abstract boolean a(String s, InputStream inputstream, ajs.a a1)
        throws IOException;
}
