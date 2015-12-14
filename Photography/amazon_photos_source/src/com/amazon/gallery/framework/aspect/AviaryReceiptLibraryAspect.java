// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.aspect;

import com.amazon.gallery.foundation.utils.log.GLogger;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;

public class AviaryReceiptLibraryAspect
{

    private static final String TAG = com/amazon/gallery/framework/aspect/AviaryReceiptLibraryAspect.getName();
    private static Throwable ajc$initFailureCause;
    public static final AviaryReceiptLibraryAspect ajc$perSingletonInstance;

    public AviaryReceiptLibraryAspect()
    {
    }

    public static String ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryReceiptLibraryAspect$com_amazon_gallery_framework_aspect_AviaryReceiptLibraryAspect$TAG()
    {
        return TAG;
    }

    private static void ajc$postClinit()
    {
        ajc$perSingletonInstance = new AviaryReceiptLibraryAspect();
    }

    public static AviaryReceiptLibraryAspect aspectOf()
    {
        if (ajc$perSingletonInstance == null)
        {
            throw new NoAspectBoundException("com.amazon.gallery.framework.aspect.AviaryReceiptLibraryAspect", ajc$initFailureCause);
        } else
        {
            return ajc$perSingletonInstance;
        }
    }

    public Object invokeMethod(ProceedingJoinPoint proceedingjoinpoint)
        throws Throwable
    {
        GLogger.i(ajc$inlineAccessFieldGet$com_amazon_gallery_framework_aspect_AviaryReceiptLibraryAspect$com_amazon_gallery_framework_aspect_AviaryReceiptLibraryAspect$TAG(), "Intercepting upload method successful", new Object[0]);
        return null;
    }

    static 
    {
        try
        {
            ajc$postClinit();
        }
        catch (Throwable throwable)
        {
            ajc$initFailureCause = throwable;
        }
    }
}
