// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.facebook.drawee.controller:
//            ControllerListener

public class ForwardingControllerListener
    implements ControllerListener
{

    private static final String TAG = "FdingControllerListener";
    private final List mListeners = new ArrayList(2);

    public ForwardingControllerListener()
    {
    }

    public static ForwardingControllerListener create()
    {
        return new ForwardingControllerListener();
    }

    public static ForwardingControllerListener of(ControllerListener controllerlistener)
    {
        ForwardingControllerListener forwardingcontrollerlistener = create();
        forwardingcontrollerlistener.addListener(controllerlistener);
        return forwardingcontrollerlistener;
    }

    public static ForwardingControllerListener of(ControllerListener controllerlistener, ControllerListener controllerlistener1)
    {
        ForwardingControllerListener forwardingcontrollerlistener = create();
        forwardingcontrollerlistener.addListener(controllerlistener);
        forwardingcontrollerlistener.addListener(controllerlistener1);
        return forwardingcontrollerlistener;
    }

    private void onException(String s, Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        Log.e("FdingControllerListener", s, throwable);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void addListener(ControllerListener controllerlistener)
    {
        this;
        JVM INSTR monitorenter ;
        mListeners.add(controllerlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        controllerlistener;
        throw controllerlistener;
    }

    public void clearListeners()
    {
        this;
        JVM INSTR monitorenter ;
        mListeners.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onFailure(String s, Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        int j = mListeners.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ControllerListener controllerlistener = (ControllerListener)mListeners.get(i);
        controllerlistener.onFailure(s, throwable);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        break MISSING_BLOCK_LABEL_72;
        exception;
        onException("InternalListener exception in onFailure", exception);
          goto _L3
        s;
        throw s;
    }

    public void onFinalImageSet(String s, Object obj, Animatable animatable)
    {
        this;
        JVM INSTR monitorenter ;
        int j = mListeners.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ControllerListener controllerlistener = (ControllerListener)mListeners.get(i);
        controllerlistener.onFinalImageSet(s, obj, animatable);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        break MISSING_BLOCK_LABEL_77;
        exception;
        onException("InternalListener exception in onFinalImageSet", exception);
          goto _L3
        s;
        throw s;
    }

    public void onIntermediateImageFailed(String s, Throwable throwable)
    {
        int j = mListeners.size();
        int i = 0;
        while (i < j) 
        {
            ControllerListener controllerlistener = (ControllerListener)mListeners.get(i);
            try
            {
                controllerlistener.onIntermediateImageFailed(s, throwable);
            }
            catch (Exception exception)
            {
                onException("InternalListener exception in onIntermediateImageFailed", exception);
            }
            i++;
        }
    }

    public void onIntermediateImageSet(String s, Object obj)
    {
        int j = mListeners.size();
        int i = 0;
        while (i < j) 
        {
            ControllerListener controllerlistener = (ControllerListener)mListeners.get(i);
            try
            {
                controllerlistener.onIntermediateImageSet(s, obj);
            }
            catch (Exception exception)
            {
                onException("InternalListener exception in onIntermediateImageSet", exception);
            }
            i++;
        }
    }

    public void onRelease(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int j = mListeners.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ControllerListener controllerlistener = (ControllerListener)mListeners.get(i);
        controllerlistener.onRelease(s);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        break MISSING_BLOCK_LABEL_66;
        exception;
        onException("InternalListener exception in onRelease", exception);
          goto _L3
        s;
        throw s;
    }

    public void onSubmit(String s, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        int j = mListeners.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ControllerListener controllerlistener = (ControllerListener)mListeners.get(i);
        controllerlistener.onSubmit(s, obj);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        break MISSING_BLOCK_LABEL_72;
        exception;
        onException("InternalListener exception in onSubmit", exception);
          goto _L3
        s;
        throw s;
    }

    public void removeListener(ControllerListener controllerlistener)
    {
        this;
        JVM INSTR monitorenter ;
        mListeners.remove(controllerlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        controllerlistener;
        throw controllerlistener;
    }
}
