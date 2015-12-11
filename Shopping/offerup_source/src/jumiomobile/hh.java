// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import java.io.File;
import java.util.ArrayList;

// Referenced classes of package jumiomobile:
//            oa, hi, al

public class hh
{

    public static String a = "standaloneBarcodeScanner";
    private ModelTemplate b;
    private oa c;

    public hh(ModelTemplate modeltemplate)
    {
        b = modeltemplate;
        c = new oa(modeltemplate);
        c.b(false);
        if (!modeltemplate.e)
        {
            c.a();
        }
    }

    private void h()
    {
        File file = new File((new StringBuilder()).append(b.a.getFilesDir()).append(File.separator).append("jumio").toString());
        if (file.isDirectory())
        {
            File afile[] = file.listFiles(new hi(this));
            if (afile != null)
            {
                for (int i = 0; i < afile.length; i++)
                {
                    if (afile[i].isFile())
                    {
                        afile[i].delete();
                    }
                }

            }
        }
    }

    public void a()
    {
        File file = new File((new StringBuilder()).append(b.a.getFilesDir()).append(File.separator).append("jumio").toString());
        if (!file.exists())
        {
            file.mkdirs();
        }
        c.b(true);
        c.a();
        c.f();
    }

    public void a(Country country, NVDocumentType nvdocumenttype, byte abyte0[], int i)
    {
        c.a(country, nvdocumenttype, abyte0, i);
    }

    public void a(ArrayList arraylist, int i)
    {
        c.a(arraylist, i);
    }

    public void a(al al)
    {
        c.a(al);
    }

    public void b()
    {
        c.a();
    }

    public void c()
    {
        c.f();
    }

    public void d()
    {
        h();
        e();
    }

    public void e()
    {
        c.d();
    }

    public void f()
    {
        c.h();
    }

    public void g()
    {
        c.g();
    }

}
