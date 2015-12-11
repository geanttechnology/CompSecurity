// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import java.util.List;

// Referenced classes of package jumiomobile:
//            am, kf, kg, jj, 
//            ab

public class ke
    implements am
{

    private kg a;

    public ke()
    {
    }

    public void a(Context context)
    {
        a = new kf(context);
        a.b();
    }

    public boolean a()
    {
        if (a != null)
        {
            return a.a();
        } else
        {
            return false;
        }
    }

    public boolean a(Country country, DocumentType documenttype)
    {
        if (!documenttype.isThirdPartyOcrDefined())
        {
            return false;
        } else
        {
            return a.a(country, documenttype);
        }
    }

    public boolean b(Country country, DocumentType documenttype)
    {
        if (!documenttype.isThirdPartyOcrDefined())
        {
            return false;
        } else
        {
            return a.b(country, documenttype);
        }
    }

    public List c(Country country, DocumentType documenttype)
    {
        return a.c(country, documenttype);
    }

    public boolean d(Country country, DocumentType documenttype)
    {
        if (!a.a(country, documenttype))
        {
            break MISSING_BLOCK_LABEL_40;
        }
        a.c(country, documenttype);
        return true;
        country;
        ab.a(getClass().getSimpleName(), country);
        return false;
    }
}
