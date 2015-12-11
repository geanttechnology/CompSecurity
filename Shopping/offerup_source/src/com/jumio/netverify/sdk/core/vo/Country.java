// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.core.vo;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jumiomobile.an;
import jumiomobile.az;
import jumiomobile.hk;
import jumiomobile.hl;
import jumiomobile.ho;
import jumiomobile.hq;
import jumiomobile.ke;

// Referenced classes of package com.jumio.netverify.sdk.core.vo:
//            DocumentType

public class Country
    implements Parcelable, Comparable
{

    public static final android.os.Parcelable.Creator CREATOR = new hl();
    private String a;
    private String b;
    private ho c;
    private List d;

    public Country(Parcel parcel)
    {
        a = "";
        b = "";
        c = ho.c;
        d = new ArrayList();
        a = parcel.readString();
        b = parcel.readString();
        parcel.readList(d, com/jumio/netverify/sdk/core/vo/DocumentType.getClassLoader());
        c = ho.valueOf(parcel.readString());
    }

    private Country(Country country)
    {
        this(country.a, country.b);
    }

    public Country(String s)
    {
        a = "";
        b = "";
        c = ho.c;
        d = new ArrayList();
        String s1;
        if (s.length() == 3)
        {
            s1 = az.a(s);
        } else
        {
            s1 = s;
        }
        a(s, (new Locale("", s1)).getDisplayCountry());
    }

    public Country(String s, String s1)
    {
        a = "";
        b = "";
        c = ho.c;
        d = new ArrayList();
        a(s, s1);
    }

    private void a(String s, String s1)
    {
        a = s;
        if (s1.equals(""))
        {
            b = s;
            return;
        } else
        {
            b = s1;
            return;
        }
    }

    public int a(Country country)
    {
        return Collator.getInstance().getCollationKey(b).compareTo(country.a());
    }

    public Country a(boolean flag, boolean flag1, List list)
    {
        Country country = new Country(this);
        Iterator iterator = d.iterator();
        do
        {
            if (iterator.hasNext())
            {
                DocumentType documenttype = (DocumentType)iterator.next();
                if (!list.contains(documenttype.getId()))
                {
                    continue;
                }
                if (flag)
                {
                    if (documenttype.getParts() > 0)
                    {
                        country.a(documenttype);
                    }
                    continue;
                }
                if (!documenttype.hasExtractionMethod())
                {
                    continue;
                }
                DocumentType documenttype1 = new DocumentType(documenttype);
                if ("DEU".equals(country.b()) && documenttype.getId() == NVDocumentType.IDENTITY_CARD)
                {
                    if (flag1)
                    {
                        documenttype1.setDocumentScanMode(hq.c);
                    }
                    documenttype1.setPaperVariant(true);
                } else
                {
                    documenttype1.setPaperVariant(false);
                }
                if (flag1)
                {
                    if (documenttype1.getDocumentScanMode() == hq.h)
                    {
                        continue;
                    }
                    documenttype1.setFallbackScan(false);
                }
                country.a(documenttype1);
            } else
            {
                country.a(c);
                return country;
            }
        } while (true);
    }

    public CollationKey a()
    {
        return Collator.getInstance().getCollationKey(b);
    }

    public void a(DocumentType documenttype)
    {
        d.add(documenttype);
    }

    public void a(ho ho1)
    {
        c = ho1;
    }

    public boolean a(Context context, DocumentType documenttype)
    {
        context = (ke)hk.d().a(context, "TemplateDatabaseService");
        if (context.a(this, documenttype) && documenttype.getDocumentScanSide().equals(NVScanSide.FRONT) && (documenttype.getDocumentScanMode() == hq.h || documenttype.getDocumentScanMode() == hq.i))
        {
            context.d(this, documenttype);
            if (context.b(this, documenttype))
            {
                return true;
            }
        }
        return false;
    }

    public boolean a(NVDocumentType nvdocumenttype)
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            if (((DocumentType)iterator.next()).getId().equals(nvdocumenttype))
            {
                return true;
            }
        }

        return false;
    }

    public DocumentType b(NVDocumentType nvdocumenttype)
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            DocumentType documenttype = (DocumentType)iterator.next();
            if (documenttype.getId().equals(nvdocumenttype))
            {
                return documenttype;
            }
        }

        return null;
    }

    public String b()
    {
        return a;
    }

    public boolean b(Context context, DocumentType documenttype)
    {
        return ((ke)hk.d().a(context, "TemplateDatabaseService")).b(this, documenttype) && documenttype.getDocumentScanSide().equals(NVScanSide.FRONT) && (documenttype.getDocumentScanMode() == hq.h || documenttype.getDocumentScanMode() == hq.i);
    }

    public String c()
    {
        return b;
    }

    public int compareTo(Object obj)
    {
        return a((Country)obj);
    }

    public ho d()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public List e()
    {
        return d;
    }

    public boolean equals(Object obj)
    {
        int i = -1;
        if (obj instanceof Country)
        {
            i = a((Country)obj);
        }
        return i == 0;
    }

    public boolean f()
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            if (((DocumentType)iterator.next()).getParts() > 0)
            {
                return true;
            }
        }

        return false;
    }

    public boolean g()
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            if (((DocumentType)iterator.next()).getDocumentScanMode() != hq.i)
            {
                return true;
            }
        }

        return false;
    }

    public int hashCode()
    {
        return System.identityHashCode(this);
    }

    public String toString()
    {
        return String.format("%s (%s)", new Object[] {
            b, a
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeString(b);
        parcel.writeList(d);
        parcel.writeString(c.name());
    }

}
