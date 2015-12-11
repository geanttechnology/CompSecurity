// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netswipe.sdk.enums.CreditCardType;
import com.jumio.ocr.impl.smartEngines.swig.OcrChar;
import com.jumio.ocr.impl.smartEngines.swig.OcrCharStringVector;
import com.jumio.ocr.impl.smartEngines.swig.OcrCharVariants;
import com.jumio.ocr.impl.smartEngines.swig.OcrCharVector;
import com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterface;
import com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings;
import org.json.JSONException;

// Referenced classes of package jumiomobile:
//            cs, fx, fe, fs, 
//            aa, dz, fd, ab, 
//            ff

class fg extends ResultAcceptorInterface
{

    final fe a;
    private int b;
    private int c;

    private fg(fe fe1)
    {
        a = fe1;
        super();
    }

    fg(fe fe1, ff ff)
    {
        this(fe1);
    }

    public void a(int i)
    {
        b = i;
    }

    public void accept(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName fieldname, OcrCharStringVector ocrcharstringvector, int i, int j, ResultAcceptorInterfaceSettings resultacceptorinterfacesettings, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (i = 0; (long)i < ocrcharstringvector.size(); i++)
        {
            OcrCharVariants ocrcharvariants = ocrcharstringvector.get(i);
            stringbuilder.append(ocrcharvariants.get().get(0).getCharacter());
            if (cs.a())
            {
                fx.a(fieldname, ocrcharvariants.getQuadrangle());
            }
        }

        long l = System.currentTimeMillis();
        if (fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NUMBER))
        {
            if (flag)
            {
                fe.a(a, 0);
                resultacceptorinterfacesettings.setOcrEnabledFlag(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.EXPIRY, fe.j(a));
                resultacceptorinterfacesettings.setOcrEnabledFlag(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_SORTCODE, fe.l(a));
                resultacceptorinterfacesettings.setOcrEnabledFlag(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_ACCOUNTNUM, fe.l(a));
                resultacceptorinterfacesettings.setOcrEnabledFlag(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME, fe.k(a));
                resultacceptorinterfacesettings.setOcrEnabledFlag(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME_2NDLINE, false);
                com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName fieldname1 = com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.AMEX_CVV;
                boolean flag1;
                if (fs.b(stringbuilder) == CreditCardType.AMERICAN_EXPRESS)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                resultacceptorinterfacesettings.setOcrEnabledFlag(fieldname1, flag1);
                try
                {
                    if (fe.v(a) != null)
                    {
                        fe.v(a).a();
                    }
                    fe.a(a, a.a(ocrcharstringvector, b, c, 6, (int)ocrcharstringvector.size() - 1 - 4));
                }
                // Misplaced declaration of an exception variable
                catch (OcrCharStringVector ocrcharstringvector)
                {
                    ab.a(ocrcharstringvector);
                }
            }
            fe.b(a, flag);
        } else
        if (fieldname.equals(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.AMEX_CVV) && flag)
        {
            if (fe.w(a) != null)
            {
                fe.w(a).a();
            }
            try
            {
                fe.b(a, a.a(ocrcharstringvector, b, c, 0, (int)ocrcharstringvector.size() - 1));
            }
            // Misplaced declaration of an exception variable
            catch (OcrCharStringVector ocrcharstringvector)
            {
                ab.a(ocrcharstringvector);
            }
        }
        ocrcharstringvector = dz.j;
        if (fe.f(a) != null)
        {
            fieldname = fe.f(a).a(fieldname, stringbuilder, flag, l - fe.x(a));
            if (fieldname == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            fieldname = ocrcharstringvector;
        }
        if (!flag && fe.f(a) != null && fieldname != dz.j)
        {
            fe.f(a).b(fieldname);
        }
        fe.b(a, flag & fe.t(a));
        fe.a(a, l);
        if (!fe.t(a))
        {
            resultacceptorinterfacesettings.setOcrEnabledFlag(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.EXPIRY, false);
            resultacceptorinterfacesettings.setOcrEnabledFlag(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_SORTCODE, false);
            resultacceptorinterfacesettings.setOcrEnabledFlag(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_ACCOUNTNUM, false);
            resultacceptorinterfacesettings.setOcrEnabledFlag(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME, false);
            resultacceptorinterfacesettings.setOcrEnabledFlag(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME_2NDLINE, false);
        }
    }

    public void b(int i)
    {
        c = i;
    }
}
