// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.remotecontrol;

import android.graphics.Bitmap;
import java.lang.reflect.Method;

// Referenced classes of package com.google.sample.castcompanionlibrary.remotecontrol:
//            RemoteControlClientCompat

public class <init>
{

    public static final int METADATA_KEY_ARTWORK = 100;
    private final Object mActualMetadataEditor;
    private Method mApplyMethod;
    private Method mClearMethod;
    private Method mPutBitmapMethod;
    private Method mPutLongMethod;
    private Method mPutStringMethod;
    final RemoteControlClientCompat this$0;

    public void apply()
    {
        if (!RemoteControlClientCompat.access$000())
        {
            break MISSING_BLOCK_LABEL_22;
        }
        mApplyMethod.invoke(mActualMetadataEditor, (Object[])null);
        return;
        Exception exception;
        exception;
        throw new RuntimeException(exception.getMessage(), exception);
    }

    public void clear()
    {
        if (!RemoteControlClientCompat.access$000())
        {
            break MISSING_BLOCK_LABEL_22;
        }
        mClearMethod.invoke(mActualMetadataEditor, (Object[])null);
        return;
        Exception exception;
        exception;
        throw new RuntimeException(exception.getMessage(), exception);
    }

    public mActualMetadataEditor putBitmap(int i, Bitmap bitmap)
    {
        if (RemoteControlClientCompat.access$000())
        {
            try
            {
                mPutBitmapMethod.invoke(mActualMetadataEditor, new Object[] {
                    Integer.valueOf(i), bitmap
                });
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                throw new RuntimeException(bitmap.getMessage(), bitmap);
            }
        }
        return this;
    }

    public mActualMetadataEditor putLong(int i, long l)
    {
        if (RemoteControlClientCompat.access$000())
        {
            try
            {
                mPutLongMethod.invoke(mActualMetadataEditor, new Object[] {
                    Integer.valueOf(i), Long.valueOf(l)
                });
            }
            catch (Exception exception)
            {
                throw new RuntimeException(exception.getMessage(), exception);
            }
        }
        return this;
    }

    public mActualMetadataEditor putString(int i, String s)
    {
        if (RemoteControlClientCompat.access$000())
        {
            try
            {
                mPutStringMethod.invoke(mActualMetadataEditor, new Object[] {
                    Integer.valueOf(i), s
                });
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException(s.getMessage(), s);
            }
        }
        return this;
    }

    private i(Object obj)
    {
        this$0 = RemoteControlClientCompat.this;
        super();
        if (RemoteControlClientCompat.access$000() && obj == null)
        {
            throw new IllegalArgumentException("Remote Control API's exist, should not be given a null MetadataEditor");
        }
        if (RemoteControlClientCompat.access$000())
        {
            remotecontrolclientcompat = obj.getClass();
            try
            {
                mPutStringMethod = getMethod("putString", new Class[] {
                    Integer.TYPE, java/lang/String
                });
                mPutBitmapMethod = getMethod("putBitmap", new Class[] {
                    Integer.TYPE, android/graphics/Bitmap
                });
                mPutLongMethod = getMethod("putLong", new Class[] {
                    Integer.TYPE, Long.TYPE
                });
                mClearMethod = getMethod("clear", new Class[0]);
                mApplyMethod = getMethod("apply", new Class[0]);
            }
            // Misplaced declaration of an exception variable
            catch (RemoteControlClientCompat remotecontrolclientcompat)
            {
                throw new RuntimeException(getMessage(), RemoteControlClientCompat.this);
            }
        }
        mActualMetadataEditor = obj;
    }

    mActualMetadataEditor(Object obj, mActualMetadataEditor mactualmetadataeditor)
    {
        this(obj);
    }
}
