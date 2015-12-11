// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.g.a.a.a.c;
import com.sun.jna.Structure;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;

class PIBitmap extends Structure
{

    public byte mBitMapBytes[];

    public PIBitmap(Drawable drawable)
    {
        drawable = ((BitmapDrawable)drawable).getBitmap();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        drawable.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        mBitMapBytes = bytearrayoutputstream.toByteArray();
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mBitMapBytes"
        });
    }

    c getNativeSize()
    {
        return new c(mBitMapBytes.length);
    }
}
