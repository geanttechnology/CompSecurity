// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public class Frame
{
    public static class Builder
    {

        private Frame zzaVf;

        public Frame build()
        {
            if (Frame.zza(zzaVf) == null && Frame.zzb(zzaVf) == null)
            {
                throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
            } else
            {
                return zzaVf;
            }
        }

        public Builder setBitmap(Bitmap bitmap)
        {
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            Frame.zza(zzaVf, bitmap);
            bitmap = zzaVf.getMetadata();
            Metadata.zza(bitmap, i);
            Metadata.zzb(bitmap, j);
            return this;
        }

        public Builder setId(int i)
        {
            Metadata.zzc(zzaVf.getMetadata(), i);
            return this;
        }

        public Builder setImageData(ByteBuffer bytebuffer, int i, int j, int k)
        {
            if (bytebuffer == null)
            {
                throw new IllegalArgumentException("Null image data supplied.");
            }
            if (!bytebuffer.isDirect())
            {
                throw new IllegalArgumentException("Image byte buffer must be allocated as 'direct'. See ByteBuffer.allocateDirect().");
            }
            if (bytebuffer.array() == null || bytebuffer.array().length < i * j)
            {
                throw new IllegalArgumentException("Invalid image data size.");
            }
            switch (k)
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("Unsupported image format: ").append(k).toString());

            case 16: // '\020'
            case 17: // '\021'
            case 842094169: 
                Frame.zza(zzaVf, bytebuffer);
                break;
            }
            bytebuffer = zzaVf.getMetadata();
            Metadata.zza(bytebuffer, i);
            Metadata.zzb(bytebuffer, j);
            return this;
        }

        public Builder setRotation(int i)
        {
            Metadata.zzd(zzaVf.getMetadata(), i);
            return this;
        }

        public Builder setTimestampMillis(long l)
        {
            Metadata.zza(zzaVf.getMetadata(), l);
            return this;
        }

        public Builder()
        {
            zzaVf = new Frame();
        }
    }

    public static class Metadata
    {

        private int mId;
        private long zzaxC;
        private int zznP;
        private int zznQ;
        private int zzzS;

        static int zza(Metadata metadata, int i)
        {
            metadata.zznP = i;
            return i;
        }

        static long zza(Metadata metadata, long l)
        {
            metadata.zzaxC = l;
            return l;
        }

        static int zzb(Metadata metadata, int i)
        {
            metadata.zznQ = i;
            return i;
        }

        static int zzc(Metadata metadata, int i)
        {
            metadata.mId = i;
            return i;
        }

        static int zzd(Metadata metadata, int i)
        {
            metadata.zzzS = i;
            return i;
        }

        public int getHeight()
        {
            return zznQ;
        }

        public int getId()
        {
            return mId;
        }

        public int getRotation()
        {
            return zzzS;
        }

        public long getTimestampMillis()
        {
            return zzaxC;
        }

        public int getWidth()
        {
            return zznP;
        }

        public void zzCd()
        {
            if (zzzS % 2 != 0)
            {
                int i = zznP;
                zznP = zznQ;
                zznQ = i;
            }
            zzzS = 0;
        }

        public Metadata()
        {
        }

        public Metadata(Metadata metadata)
        {
            zznP = metadata.getWidth();
            zznQ = metadata.getHeight();
            mId = metadata.getId();
            zzaxC = metadata.getTimestampMillis();
            zzzS = metadata.getRotation();
        }
    }


    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    private Bitmap mBitmap;
    private Metadata zzaVd;
    private ByteBuffer zzaVe;

    private Frame()
    {
        zzaVd = new Metadata();
        zzaVe = null;
        mBitmap = null;
    }


    private ByteBuffer zzCc()
    {
        int i = mBitmap.getWidth();
        int k = mBitmap.getHeight();
        int ai[] = new int[i * k];
        mBitmap.getPixels(ai, 0, i, 0, 0, i, k);
        byte abyte0[] = new byte[i * k];
        for (int j = 0; j < ai.length; j++)
        {
            abyte0[j] = (byte)(int)((float)Color.red(ai[j]) * 0.299F + (float)Color.green(ai[j]) * 0.587F + (float)Color.blue(ai[j]) * 0.114F);
        }

        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(abyte0.length);
        System.arraycopy(abyte0, 0, bytebuffer.array(), 0, abyte0.length);
        return bytebuffer;
    }

    static Bitmap zza(Frame frame, Bitmap bitmap)
    {
        frame.mBitmap = bitmap;
        return bitmap;
    }

    static ByteBuffer zza(Frame frame)
    {
        return frame.zzaVe;
    }

    static ByteBuffer zza(Frame frame, ByteBuffer bytebuffer)
    {
        frame.zzaVe = bytebuffer;
        return bytebuffer;
    }

    static Bitmap zzb(Frame frame)
    {
        return frame.mBitmap;
    }

    public Bitmap getBitmap()
    {
        return mBitmap;
    }

    public ByteBuffer getGrayscaleImageData()
    {
        if (mBitmap != null)
        {
            return zzCc();
        } else
        {
            return zzaVe;
        }
    }

    public Metadata getMetadata()
    {
        return zzaVd;
    }
}
