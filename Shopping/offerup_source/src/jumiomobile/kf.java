// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package jumiomobile:
//            kg, ap, ab

public class kf
    implements kg
{

    private final Context a;

    public kf(Context context)
    {
        a = context;
    }

    private String a(NVDocumentType nvdocumenttype)
    {
        if (nvdocumenttype == NVDocumentType.DRIVER_LICENSE)
        {
            return "DL";
        }
        if (nvdocumenttype == NVDocumentType.IDENTITY_CARD)
        {
            return "ID";
        }
        if (nvdocumenttype == NVDocumentType.PASSPORT)
        {
            return "PP";
        } else
        {
            return nvdocumenttype.toString();
        }
    }

    private void a(byte abyte0[], File file)
    {
        if (abyte0 == null)
        {
            throw new IOException("extract(): data array was null!");
        }
        if (file == null)
        {
            throw new IOException("extract(): destination file was null");
        }
        file = new FileOutputStream(file);
        file.write(abyte0);
        file.flush();
        file.close();
        return;
        abyte0;
        file = null;
_L2:
        if (file != null)
        {
            file.close();
        }
        throw abyte0;
        abyte0;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private byte[] a(String s)
    {
        return (new ap((new StringBuilder()).append(c()).append(s).toString())).a();
    }

    private static final String c()
    {
        return "http://mobile-sdk-resources.jumio.com/android/assets/nv/templatematcher/1.91.3/";
    }

    private File d()
    {
        File file = new File((new StringBuilder()).append(a.getFilesDir()).append(File.separator).append("tm_1.91.3").append(File.separator).toString());
        if (!file.exists())
        {
            file.mkdirs();
        }
        return file;
    }

    private String d(String s, NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s.toUpperCase());
        stringbuilder.append("_");
        stringbuilder.append(a(nvdocumenttype).toLowerCase());
        stringbuilder.append("_");
        stringbuilder.append(nvscanside.toString().toLowerCase());
        stringbuilder.append(".bin");
        return stringbuilder.toString();
    }

    public boolean a()
    {
        return true;
    }

    public boolean a(Country country, DocumentType documenttype)
    {
        return a(country.b(), documenttype.getId(), documenttype.getDocumentScanSide());
    }

    public boolean a(String s, NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        boolean flag = false;
        try
        {
            String s1 = d(s, nvdocumenttype, nvscanside);
            if (!b(s, nvdocumenttype, nvscanside))
            {
                flag = (new ap((new StringBuilder()).append(c()).append(s1).toString())).b();
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ab.b("TemplateMatcher", s);
            return false;
        }
        return flag;
    }

    public void b()
    {
    }

    public boolean b(Country country, DocumentType documenttype)
    {
        return b(country.b(), documenttype.getId(), documenttype.getDocumentScanSide());
    }

    public boolean b(String s, NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        boolean flag = false;
        boolean flag1;
        try
        {
            s = d(s, nvdocumenttype, nvscanside);
            flag1 = (new File(d(), s)).exists();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ab.b("TemplateMatcher", s);
            return false;
        }
        if (flag1)
        {
            flag = true;
        }
        return flag;
    }

    public List c(Country country, DocumentType documenttype)
    {
        return c(country.b(), documenttype.getId(), documenttype.getDocumentScanSide());
    }

    public List c(String s, NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        ArrayList arraylist = new ArrayList();
        s = d(s, nvdocumenttype, nvscanside);
        nvdocumenttype = new File(d(), s);
        if (!nvdocumenttype.exists())
        {
            try
            {
                a(a(s), nvdocumenttype);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ab.a(getClass().getSimpleName(), s);
                return null;
            }
        }
        arraylist.add(nvdocumenttype.getAbsolutePath());
        return arraylist;
    }
}
