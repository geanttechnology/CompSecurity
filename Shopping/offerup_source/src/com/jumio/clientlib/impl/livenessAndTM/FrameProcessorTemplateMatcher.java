// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            FrameProcessor, jniLivenessAndTMJNI, FrameProcessingSettingsTemplateMatcher, FrameProcessingCallbackTemplateMatcher, 
//            LibImage, TemplateInfo

public class FrameProcessorTemplateMatcher extends FrameProcessor
{

    private long a;
    private boolean b;

    protected FrameProcessorTemplateMatcher(long l, boolean flag)
    {
        super(jniLivenessAndTMJNI.FrameProcessorTemplateMatcher_SWIGSmartPtrUpcast(l), true);
        b = flag;
        a = l;
    }

    public FrameProcessorTemplateMatcher(FrameProcessingSettingsTemplateMatcher frameprocessingsettingstemplatematcher, FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher)
    {
        this(jniLivenessAndTMJNI.new_FrameProcessorTemplateMatcher(FrameProcessingSettingsTemplateMatcher.getCPtr(frameprocessingsettingstemplatematcher), frameprocessingsettingstemplatematcher, FrameProcessingCallbackTemplateMatcher.getCPtr(frameprocessingcallbacktemplatematcher), frameprocessingcallbacktemplatematcher), true);
    }

    protected static long getCPtr(FrameProcessorTemplateMatcher frameprocessortemplatematcher)
    {
        if (frameprocessortemplatematcher == null)
        {
            return 0L;
        } else
        {
            return frameprocessortemplatematcher.a;
        }
    }

    public boolean addTemplatesFromBinaryFile(String s)
    {
        return jniLivenessAndTMJNI.FrameProcessorTemplateMatcher_addTemplatesFromBinaryFile(a, this, s);
    }

    public void clearAllTemplates()
    {
        jniLivenessAndTMJNI.FrameProcessorTemplateMatcher_clearAllTemplates(a, this);
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (b)
            {
                b = false;
                jniLivenessAndTMJNI.delete_FrameProcessorTemplateMatcher(a);
            }
            a = 0L;
        }
        super.delete();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean detectSingleFrame(LibImage libimage, TemplateInfo templateinfo)
    {
        return jniLivenessAndTMJNI.FrameProcessorTemplateMatcher_detectSingleFrame(a, this, LibImage.getCPtr(libimage), libimage, TemplateInfo.getCPtr(templateinfo), templateinfo);
    }

    public void discardFrameByID(int i)
    {
        jniLivenessAndTMJNI.FrameProcessorTemplateMatcher_discardFrameByID(a, this, i);
    }

    protected void finalize()
    {
        delete();
    }
}
