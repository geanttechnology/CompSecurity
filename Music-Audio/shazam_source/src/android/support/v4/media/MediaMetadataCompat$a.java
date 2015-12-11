// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.f.a;

// Referenced classes of package android.support.v4.media:
//            MediaMetadataCompat

public static final class 
{

    public final Bundle a = new Bundle();

    public final  a(String s, Bitmap bitmap)
    {
        if (android.support.v4.media.MediaMetadataCompat.a().containsKey(s) && ((Integer)android.support.v4.media.MediaMetadataCompat.a().get(s)).intValue() != 2)
        {
            throw new IllegalArgumentException((new StringBuilder("The ")).append(s).append(" key cannot be used to put a Bitmap").toString());
        } else
        {
            a.putParcelable(s, bitmap);
            return this;
        }
    }

    public final a a(String s, String s1)
    {
        if (android.support.v4.media.MediaMetadataCompat.a().containsKey(s) && ((Integer)android.support.v4.media.MediaMetadataCompat.a().get(s)).intValue() != 1)
        {
            throw new IllegalArgumentException((new StringBuilder("The ")).append(s).append(" key cannot be used to put a String").toString());
        } else
        {
            a.putCharSequence(s, s1);
            return this;
        }
    }

    public ()
    {
    }
}
