// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.f;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import myobfuscated.s.g;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            ab, e

public final class aa
    implements f
{

    public static final c a = com.bumptech.glide.load.c.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1L), new d() {

        private final ByteBuffer a = ByteBuffer.allocate(8);

        public final void a(byte abyte0[], Object obj, MessageDigest messagedigest)
        {
            obj = (Long)obj;
            messagedigest.update(abyte0);
            synchronized (a)
            {
                a.position(0);
                messagedigest.update(a.putLong(((Long) (obj)).longValue()).array());
            }
            return;
            obj;
            abyte0;
            JVM INSTR monitorexit ;
            throw obj;
        }

    });
    private static c b = com.bumptech.glide.load.c.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", null, new d() {

        private final ByteBuffer a = ByteBuffer.allocate(4);

        public final void a(byte abyte0[], Object obj, MessageDigest messagedigest)
        {
            obj = (Integer)obj;
            if (obj != null)
            {
                messagedigest.update(abyte0);
                synchronized (a)
                {
                    a.position(0);
                    messagedigest.update(a.putInt(((Integer) (obj)).intValue()).array());
                }
                return;
            } else
            {
                return;
            }
            obj;
            abyte0;
            JVM INSTR monitorexit ;
            throw obj;
        }

    });
    private static final ab c = new ab();
    private final g d;

    public aa(g g)
    {
        this(g, c);
    }

    private aa(g g, ab ab1)
    {
        d = g;
    }

    private static boolean a(ParcelFileDescriptor parcelfiledescriptor)
    {
        MediaMetadataRetriever mediametadataretriever = new MediaMetadataRetriever();
        try
        {
            mediametadataretriever.setDataSource(parcelfiledescriptor.getFileDescriptor());
        }
        // Misplaced declaration of an exception variable
        catch (ParcelFileDescriptor parcelfiledescriptor)
        {
            mediametadataretriever.release();
            return false;
        }
        finally
        {
            mediametadataretriever.release();
        }
        mediametadataretriever.release();
        return true;
        throw parcelfiledescriptor;
    }

    public final ad a(Object obj, int i, int j, e e1)
    {
        ParcelFileDescriptor parcelfiledescriptor = (ParcelFileDescriptor)obj;
        long l = ((Long)e1.a(a)).longValue();
        if (l < 0L && l != -1L)
        {
            throw new IllegalArgumentException((new StringBuilder("Requested frame must be non-negative, or DEFAULT_FRAME, given: ")).append(l).toString());
        }
        obj = (Integer)e1.a(b);
        e1 = new MediaMetadataRetriever();
        e1.setDataSource(parcelfiledescriptor.getFileDescriptor());
        if (l == -1L)
        {
            obj = e1.getFrameAtTime();
        } else
        if (obj == null)
        {
            obj = e1.getFrameAtTime(l);
        } else
        {
            obj = e1.getFrameAtTime(l, ((Integer) (obj)).intValue());
        }
        e1.release();
        parcelfiledescriptor.close();
        return e.a(((android.graphics.Bitmap) (obj)), d);
    }

    public final volatile boolean a(Object obj, e e1)
    {
        return a((ParcelFileDescriptor)obj);
    }

}
