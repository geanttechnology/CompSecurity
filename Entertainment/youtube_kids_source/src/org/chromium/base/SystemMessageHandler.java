// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SystemMessageHandler extends Handler
{

    private long a;
    private long b;
    private Method c;

    private SystemMessageHandler(long l)
    {
        a = 0L;
        b = 0L;
        a = l;
        try
        {
            c = Class.forName("android.os.Message").getMethod("setAsynchronous", new Class[] {
                Boolean.TYPE
            });
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.e("SystemMessageHandler", (new StringBuilder("Failed to find android.os.Message class:")).append(classnotfoundexception).toString());
            return;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            Log.e("SystemMessageHandler", (new StringBuilder("Failed to load Message.setAsynchronous method:")).append(nosuchmethodexception).toString());
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            Log.e("SystemMessageHandler", (new StringBuilder("Exception while loading Message.setAsynchronous method: ")).append(runtimeexception).toString());
        }
    }

    private Message a(int i)
    {
        Message message = Message.obtain();
        message.what = i;
        if (c != null)
        {
            try
            {
                c.invoke(message, new Object[] {
                    Boolean.valueOf(true)
                });
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                Log.e("SystemMessageHandler", "Illegal access to asynchronous message creation, disabling.");
                c = null;
                return message;
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.e("SystemMessageHandler", "Illegal argument for asynchronous message creation, disabling.");
                c = null;
                return message;
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                Log.e("SystemMessageHandler", "Invocation exception during asynchronous message creation, disabling.");
                c = null;
                return message;
            }
            catch (RuntimeException runtimeexception)
            {
                Log.e("SystemMessageHandler", "Runtime exception during asynchronous message creation, disabling.");
                c = null;
                return message;
            }
        }
        return message;
    }

    private static SystemMessageHandler create(long l)
    {
        return new SystemMessageHandler(l);
    }

    private native void nativeDoRunLoopOnce(long l, long l1);

    private void removeAllPendingMessages()
    {
        removeMessages(1);
        removeMessages(2);
    }

    private void scheduleDelayedWork(long l, long l1)
    {
        if (b != 0L)
        {
            removeMessages(2);
        }
        b = l;
        sendMessageDelayed(a(2), l1);
    }

    private void scheduleWork()
    {
        sendMessage(a(1));
    }

    public void handleMessage(Message message)
    {
        if (message.what == 2)
        {
            b = 0L;
        }
        nativeDoRunLoopOnce(a, b);
    }
}
