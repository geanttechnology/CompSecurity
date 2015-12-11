// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.ocr.impl.smartEngines.swig.OcrCharStringVector;
import com.jumio.ocr.impl.smartEngines.swig.OcrPoint;
import com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterface;
import com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings;
import org.json.JSONException;

// Referenced classes of package netswipe:
//            de, ce, cf

class cg extends ResultAcceptorInterface
{

    final ce a;

    private cg(ce ce1)
    {
        a = ce1;
        super();
    }

    cg(ce ce1, cf cf)
    {
        this(ce1);
    }

    private de a(OcrPoint ocrpoint, int i, int j)
        throws JSONException
    {
        de de1 = new de();
        de1.put("x", (ocrpoint.getX() * 320) / ce.a + i);
        de1.put("y", (ocrpoint.getY() * 240) / ce.b + j);
        return de1;
    }

    public void accept(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName fieldname, OcrCharStringVector ocrcharstringvector, int i, int j, ResultAcceptorInterfaceSettings resultacceptorinterfacesettings, boolean flag)
    {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
}
