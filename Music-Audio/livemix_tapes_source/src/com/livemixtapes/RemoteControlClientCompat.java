// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RemoteControlClientCompat
{
    public class MetadataEditorCompat
    {

        public static final int METADATA_KEY_ARTWORK = 100;
        private Object mActualMetadataEditor;
        private Method mApplyMethod;
        private Method mClearMethod;
        private Method mPutBitmapMethod;
        private Method mPutLongMethod;
        private Method mPutStringMethod;
        final RemoteControlClientCompat this$0;

        public void apply()
        {
            if (!RemoteControlClientCompat.sHasRemoteControlAPIs)
            {
                break MISSING_BLOCK_LABEL_19;
            }
            mApplyMethod.invoke(mActualMetadataEditor, null);
            return;
            Exception exception;
            exception;
            throw new RuntimeException(exception.getMessage(), exception);
        }

        public void clear()
        {
            if (!RemoteControlClientCompat.sHasRemoteControlAPIs)
            {
                break MISSING_BLOCK_LABEL_19;
            }
            mClearMethod.invoke(mActualMetadataEditor, null);
            return;
            Exception exception;
            exception;
            throw new RuntimeException(exception.getMessage(), exception);
        }

        public MetadataEditorCompat putBitmap(int i, Bitmap bitmap)
        {
            if (RemoteControlClientCompat.sHasRemoteControlAPIs)
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

        public MetadataEditorCompat putLong(int i, long l)
        {
            if (RemoteControlClientCompat.sHasRemoteControlAPIs)
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

        public MetadataEditorCompat putString(int i, String s)
        {
            if (RemoteControlClientCompat.sHasRemoteControlAPIs)
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

        private MetadataEditorCompat(Object obj)
        {
            this$0 = RemoteControlClientCompat.this;
            super();
            if (RemoteControlClientCompat.sHasRemoteControlAPIs && obj == null)
            {
                throw new IllegalArgumentException("Remote Control API's exist, should not be given a null MetadataEditor");
            }
            if (RemoteControlClientCompat.sHasRemoteControlAPIs)
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

        MetadataEditorCompat(Object obj, MetadataEditorCompat metadataeditorcompat)
        {
            this(obj);
        }
    }


    private static final String TAG = "RemoteControlCompat";
    private static boolean sHasRemoteControlAPIs;
    private static Method sRCCEditMetadataMethod;
    private static Method sRCCSetPlayStateMethod;
    private static Method sRCCSetTransportControlFlags;
    private static Class sRemoteControlClientClass;
    private Object mActualRemoteControlClient;

    public RemoteControlClientCompat(PendingIntent pendingintent)
    {
        if (!sHasRemoteControlAPIs)
        {
            return;
        }
        try
        {
            mActualRemoteControlClient = sRemoteControlClientClass.getConstructor(new Class[] {
                android/app/PendingIntent
            }).newInstance(new Object[] {
                pendingintent
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PendingIntent pendingintent)
        {
            throw new RuntimeException(pendingintent);
        }
    }

    public RemoteControlClientCompat(PendingIntent pendingintent, Looper looper)
    {
        if (!sHasRemoteControlAPIs)
        {
            return;
        }
        try
        {
            mActualRemoteControlClient = sRemoteControlClientClass.getConstructor(new Class[] {
                android/app/PendingIntent, android/os/Looper
            }).newInstance(new Object[] {
                pendingintent, looper
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PendingIntent pendingintent)
        {
            Log.e("RemoteControlCompat", (new StringBuilder("Error creating new instance of ")).append(sRemoteControlClientClass.getName()).toString(), pendingintent);
        }
    }

    public static Class getActualRemoteControlClientClass(ClassLoader classloader)
        throws ClassNotFoundException
    {
        return classloader.loadClass("android.media.RemoteControlClient");
    }

    public MetadataEditorCompat editMetadata(boolean flag)
    {
        Object obj;
        if (sHasRemoteControlAPIs)
        {
            try
            {
                obj = sRCCEditMetadataMethod.invoke(mActualRemoteControlClient, new Object[] {
                    Boolean.valueOf(flag)
                });
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((Throwable) (obj)));
            }
        } else
        {
            obj = null;
        }
        return new MetadataEditorCompat(obj, null);
    }

    public final Object getActualRemoteControlClientObject()
    {
        return mActualRemoteControlClient;
    }

    public void setPlaybackState(int i)
    {
        if (!sHasRemoteControlAPIs)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        sRCCSetPlayStateMethod.invoke(mActualRemoteControlClient, new Object[] {
            Integer.valueOf(i)
        });
        return;
        Exception exception;
        exception;
        throw new RuntimeException(exception);
    }

    public void setTransportControlFlags(int i)
    {
        if (!sHasRemoteControlAPIs)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        sRCCSetTransportControlFlags.invoke(mActualRemoteControlClient, new Object[] {
            Integer.valueOf(i)
        });
        return;
        Exception exception;
        exception;
        throw new RuntimeException(exception);
    }

    static 
    {
        int i;
        i = 0;
        sHasRemoteControlAPIs = false;
        Field afield[];
        int j;
        sRemoteControlClientClass = getActualRemoteControlClientClass(com/livemixtapes/RemoteControlClientCompat.getClassLoader());
        afield = com/livemixtapes/RemoteControlClientCompat.getFields();
        j = afield.length;
_L2:
        if (i >= j)
        {
            Field field;
            Object obj;
            try
            {
                sRCCEditMetadataMethod = sRemoteControlClientClass.getMethod("editMetadata", new Class[] {
                    Boolean.TYPE
                });
                sRCCSetPlayStateMethod = sRemoteControlClientClass.getMethod("setPlaybackState", new Class[] {
                    Integer.TYPE
                });
                sRCCSetTransportControlFlags = sRemoteControlClientClass.getMethod("setTransportControlFlags", new Class[] {
                    Integer.TYPE
                });
                sHasRemoteControlAPIs = true;
            }
            catch (ClassNotFoundException classnotfoundexception) { }
            catch (NoSuchMethodException nosuchmethodexception) { }
            catch (IllegalArgumentException illegalargumentexception) { }
            catch (SecurityException securityexception) { }
            break; /* Loop/switch isn't completed */
        }
        field = afield[i];
        field.set(null, sRemoteControlClientClass.getField(field.getName()).get(null));
_L3:
        i++;
        if (true) goto _L2; else goto _L1
        obj;
        Log.w("RemoteControlCompat", (new StringBuilder("Could not get real field: ")).append(field.getName()).toString());
          goto _L3
        obj;
        Log.w("RemoteControlCompat", (new StringBuilder("Error trying to pull field value for: ")).append(field.getName()).append(" ").append(((IllegalArgumentException) (obj)).getMessage()).toString());
          goto _L3
        obj;
        Log.w("RemoteControlCompat", (new StringBuilder("Error trying to pull field value for: ")).append(field.getName()).append(" ").append(((IllegalAccessException) (obj)).getMessage()).toString());
          goto _L3
_L1:
    }

}
