// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class ResultAcceptorInterfaceSettings
{

    private long a;
    protected boolean swigCMemOwn;

    public ResultAcceptorInterfaceSettings()
    {
        this(jniInterfaceJNI.new_ResultAcceptorInterfaceSettings__SWIG_0(), true);
    }

    protected ResultAcceptorInterfaceSettings(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public ResultAcceptorInterfaceSettings(ResultAcceptorInterfaceSettings resultacceptorinterfacesettings)
    {
        this(jniInterfaceJNI.new_ResultAcceptorInterfaceSettings__SWIG_1(getCPtr(resultacceptorinterfacesettings), resultacceptorinterfacesettings), true);
    }

    protected static long getCPtr(ResultAcceptorInterfaceSettings resultacceptorinterfacesettings)
    {
        if (resultacceptorinterfacesettings == null)
        {
            return 0L;
        } else
        {
            return resultacceptorinterfacesettings.a;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                jniInterfaceJNI.delete_ResultAcceptorInterfaceSettings(a);
            }
            a = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    public boolean getOcrEnabledFlag(FieldName fieldname)
    {
        return jniInterfaceJNI.ResultAcceptorInterfaceSettings_getOcrEnabledFlag(a, this, fieldname.swigValue());
    }

    public void setOcrEnabledFlag(FieldName fieldname, boolean flag)
    {
        jniInterfaceJNI.ResultAcceptorInterfaceSettings_setOcrEnabledFlag(a, this, fieldname.swigValue(), flag);
    }

    private class FieldName
    {

        public static final FieldName EXPIRY;
        public static final FieldName NAME;
        public static final FieldName NAME_2NDLINE;
        public static final FieldName NUMBER;
        public static final FieldName NUMPREV;
        public static final FieldName UK_ACCOUNTNUM;
        public static final FieldName UK_SORTCODE;
        private static FieldName a[];
        private static int b = 0;
        private final int c;
        private final String d;

        public static FieldName swigToEnum(int i)
        {
            if (i < a.length && i >= 0 && a[i].c == i)
            {
                return a[i];
            }
            for (int j = 0; j < a.length; j++)
            {
                if (a[j].c == i)
                {
                    return a[j];
                }
            }

            throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/jumio/ocr/impl/smartEngines/swig/ResultAcceptorInterfaceSettings$FieldName).append(" with value ").append(i).toString());
        }

        public final int swigValue()
        {
            return c;
        }

        public String toString()
        {
            return d;
        }

        static 
        {
            NUMPREV = new FieldName("NUMPREV");
            NUMBER = new FieldName("NUMBER");
            EXPIRY = new FieldName("EXPIRY");
            NAME = new FieldName("NAME");
            UK_SORTCODE = new FieldName("UK_SORTCODE");
            UK_ACCOUNTNUM = new FieldName("UK_ACCOUNTNUM");
            NAME_2NDLINE = new FieldName("NAME_2NDLINE");
            a = (new FieldName[] {
                NUMPREV, NUMBER, EXPIRY, NAME, UK_SORTCODE, UK_ACCOUNTNUM, NAME_2NDLINE
            });
        }

        private FieldName(String s)
        {
            d = s;
            int i = b;
            b = i + 1;
            c = i;
        }
    }

}
