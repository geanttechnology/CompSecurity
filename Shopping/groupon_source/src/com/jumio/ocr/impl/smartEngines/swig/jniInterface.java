// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            OcrException, OcrCharStringVector, jniInterfaceJNI

public class jniInterface
{

    public jniInterface()
    {
    }

    public static OcrCharStringVector ApplyLuhnCodeRecovery(OcrCharStringVector ocrcharstringvector)
        throws OcrException
    {
        return new OcrCharStringVector(jniInterfaceJNI.ApplyLuhnCodeRecovery(OcrCharStringVector.getCPtr(ocrcharstringvector), ocrcharstringvector), true);
    }
}
