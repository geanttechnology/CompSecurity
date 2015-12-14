// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import com.aviary.android.feather.common.utils.IDisposable;
import com.aviary.android.feather.headless.AviaryExecutionException;
import com.aviary.android.feather.headless.filters.NativeFilterProxy;
import com.aviary.android.feather.headless.utils.MegaPixels;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.Serializable;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaActionList

public class MoaHD
    implements IDisposable, Serializable
{

    static final int KILOBYE = 1024;
    static final int MEGABYTE = 0x100000;
    private static final long serialVersionUID = 0x763fe74a7ec80b0fL;
    private boolean disposed;
    private long m_ptr;

    public MoaHD()
    {
        m_ptr = m_nativeCtor();
        disposed = false;
    }

    static native boolean m_getOriginalEnabled(long l);

    private native int m_height(long l);

    private native void m_nativeApplyActions(long l, String s);

    private native long m_nativeCtor();

    private native void m_nativeDispose(long l);

    private native boolean m_nativeIsLoaded(long l);

    private native boolean m_nativeIsValid(long l);

    private native int m_nativeLoad(long l, int i);

    private native int m_nativeLoad(long l, FileDescriptor filedescriptor);

    private native int m_nativeLoad(long l, InputStream inputstream, byte abyte0[]);

    private native int m_nativeLoad(long l, String s);

    private native int m_nativeSave(long l, String s);

    private native int m_nativeSaveWithQualityAndConfig(long l, String s, int i, int j);

    private native int m_nativeUnload(long l);

    static native int m_revert(long l);

    static native void m_setMaxMegaPixels(long l, int i);

    static native void m_setOriginalEnabled(long l, boolean flag);

    private native int m_width(long l);

    static int nativeConfig(android.graphics.Bitmap.Config config)
    {
        static class _cls1
        {

            static final int $SwitchMap$android$graphics$Bitmap$CompressFormat[];
            static final int $SwitchMap$android$graphics$Bitmap$Config[];

            static 
            {
                $SwitchMap$android$graphics$Bitmap$Config = new int[android.graphics.Bitmap.Config.values().length];
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$android$graphics$Bitmap$CompressFormat = new int[android.graphics.Bitmap.CompressFormat.values().length];
                try
                {
                    $SwitchMap$android$graphics$Bitmap$CompressFormat[android.graphics.Bitmap.CompressFormat.JPEG.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$CompressFormat[android.graphics.Bitmap.CompressFormat.PNG.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.android.graphics.Bitmap.Config[config.ordinal()])
        {
        case 1: // '\001'
        default:
            return 6;

        case 2: // '\002'
            return 4;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 5;
        }
    }

    static int nativeFormat(android.graphics.Bitmap.CompressFormat compressformat)
    {
        switch (_cls1..SwitchMap.android.graphics.Bitmap.CompressFormat[compressformat.ordinal()])
        {
        case 1: // '\001'
        default:
            return 0;

        case 2: // '\002'
            return 1;
        }
    }

    public void applyActions(MoaActionList moaactionlist)
        throws JSONException
    {
        applyActions(NativeFilterProxy.encodeActions(moaactionlist));
    }

    public void applyActions(String s)
    {
        m_nativeApplyActions(m_ptr, s);
    }

    public void dispose()
    {
        m_nativeDispose(m_ptr);
        m_ptr = 0L;
        disposed = true;
    }

    public boolean getOriginalEnabled()
    {
        return m_getOriginalEnabled(m_ptr);
    }

    public long getPtr()
    {
        return m_ptr;
    }

    public int height()
    {
        return m_height(m_ptr);
    }

    public boolean isDisposed()
    {
        return disposed;
    }

    public boolean isLoaded()
    {
        return m_nativeIsLoaded(m_ptr);
    }

    public boolean isValid()
    {
        return m_nativeIsValid(m_ptr);
    }

    public void load(int i)
        throws AviaryExecutionException
    {
        i = m_nativeLoad(m_ptr, i);
        if (i > 0)
        {
            throw AviaryExecutionException.fromInt(i);
        } else
        {
            return;
        }
    }

    public void load(FileDescriptor filedescriptor)
        throws AviaryExecutionException
    {
        int i = m_nativeLoad(m_ptr, filedescriptor);
        if (i > 0)
        {
            throw AviaryExecutionException.fromInt(i);
        } else
        {
            return;
        }
    }

    public void load(InputStream inputstream)
        throws AviaryExecutionException
    {
        if (inputstream == null)
        {
            throw AviaryExecutionException.fromInt(1);
        }
        Object obj = inputstream;
        if (!inputstream.markSupported())
        {
            obj = new BufferedInputStream(inputstream, 0x20000);
        }
        ((InputStream) (obj)).mark(0x20000);
        inputstream = new byte[0x10000];
        int i = m_nativeLoad(m_ptr, ((InputStream) (obj)), inputstream);
        if (i > 0)
        {
            throw AviaryExecutionException.fromInt(i);
        } else
        {
            return;
        }
    }

    public void load(String s)
        throws AviaryExecutionException
    {
        int i = m_nativeLoad(m_ptr, s);
        if (i > 0)
        {
            throw AviaryExecutionException.fromInt(i);
        } else
        {
            return;
        }
    }

    public void revert()
        throws AviaryExecutionException
    {
        int i = m_revert(m_ptr);
        if (i > 0)
        {
            throw AviaryExecutionException.fromInt(i);
        } else
        {
            return;
        }
    }

    public void save(String s)
        throws AviaryExecutionException
    {
        int i = m_nativeSave(m_ptr, s);
        if (i > 0)
        {
            throw AviaryExecutionException.fromInt(i);
        } else
        {
            return;
        }
    }

    public void save(String s, int i, android.graphics.Bitmap.CompressFormat compressformat)
        throws AviaryExecutionException
    {
        i = m_nativeSaveWithQualityAndConfig(m_ptr, s, i, nativeFormat(compressformat));
        if (i > 0)
        {
            throw AviaryExecutionException.fromInt(i);
        } else
        {
            return;
        }
    }

    public void setMaxMegaPixels(MegaPixels megapixels)
    {
        m_setMaxMegaPixels(m_ptr, megapixels.ordinal());
    }

    public void setOriginalEnabled(boolean flag)
    {
        m_setOriginalEnabled(m_ptr, flag);
    }

    public void unload()
        throws AviaryExecutionException
    {
        int i = m_nativeUnload(m_ptr);
        if (i > 0)
        {
            throw AviaryExecutionException.fromInt(i);
        } else
        {
            return;
        }
    }

    public int width()
    {
        return m_width(m_ptr);
    }
}
