// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.jumio.netverify.sdk.extraction.templatematcher.TemplateInfoWrapper;

// Referenced classes of package jumiomobile:
//            py, w

public class qa extends py
{

    private Bitmap b[];
    private TemplateInfoWrapper c;

    public qa(double d1, int i, String s, Bitmap abitmap[], TemplateInfoWrapper templateinfowrapper)
    {
        super(d1, i, s);
        a(abitmap);
        a(templateinfowrapper);
    }

    public void a(TemplateInfoWrapper templateinfowrapper)
    {
        c = templateinfowrapper;
    }

    public void a(Bitmap abitmap[])
    {
        b = abitmap;
    }

    public Bitmap[] d()
    {
        return b;
    }

    public String toString()
    {
        if (c != null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(String.format("TL= %s, TR= %s, BR= %s, BL= %s", new Object[] {
                c.w().toString(), c.x().toString(), c.z().toString(), c.y().toString()
            }));
            stringbuilder.append("\n");
            stringbuilder.append(String.format("Frame: %.0f x %.0f ", new Object[] {
                Float.valueOf(c.r()), Float.valueOf(c.q())
            }));
            stringbuilder.append(String.format("(%s)", new Object[] {
                c.D().toString()
            }));
            stringbuilder.append("\n");
            stringbuilder.append((new StringBuilder()).append(c.k()).append("/").append(c.m()).append("/").append(c.j()).toString());
            stringbuilder.append("\n");
            stringbuilder.append((new StringBuilder("No. Frames for TM: ")).append(c.I()).toString());
            stringbuilder.append("\n");
            StringBuilder stringbuilder1 = new StringBuilder("Blurriness Check: ");
            String s;
            if (c.H())
            {
                s = "activated";
            } else
            {
                s = "deactivated";
            }
            stringbuilder.append(stringbuilder1.append(s).toString());
            stringbuilder.append("\n");
            stringbuilder.append((new StringBuilder("Template min width %: ")).append((int)(TemplateInfoWrapper.b * 100D)).toString());
            stringbuilder.append("\n");
            stringbuilder.append((new StringBuilder("Template min height %: ")).append((int)(TemplateInfoWrapper.a * 100D)).toString());
            return stringbuilder.toString();
        } else
        {
            return "";
        }
    }
}
