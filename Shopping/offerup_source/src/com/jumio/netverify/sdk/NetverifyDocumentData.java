// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.jumio.mrz.impl.smartEngines.swig.MrzResult;
import com.jumio.mrz.impl.smartEngines.swig.StringVector;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVGender;
import com.jumio.netverify.sdk.enums.NVMRZFormat;
import java.util.Date;
import jumiomobile.bh;
import jumiomobile.bi;
import jumiomobile.gb;

// Referenced classes of package com.jumio.netverify.sdk:
//            NetverifyMrzData

public class NetverifyDocumentData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new gb();
    private String a;
    private NVDocumentType b;
    private String c;
    private String d;
    private Date e;
    private Date f;
    private String g;
    private String h;
    private String i;
    private String j;
    private Date k;
    private NVGender l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private NetverifyMrzData t;
    private String u;
    private Boolean v;

    public NetverifyDocumentData()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        v = null;
    }

    private NetverifyDocumentData(Parcel parcel)
    {
        Object obj1 = null;
        super();
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        v = null;
        a = a(parcel.readString());
        Object obj = parcel.readString();
        long l1;
        if (((String) (obj)).length() == 0)
        {
            obj = null;
        } else
        {
            obj = NVDocumentType.valueOf(((String) (obj)));
        }
        b = ((NVDocumentType) (obj));
        c = a(parcel.readString());
        d = a(parcel.readString());
        l1 = parcel.readLong();
        if (l1 == 0L)
        {
            obj = null;
        } else
        {
            obj = new Date(l1);
        }
        e = ((Date) (obj));
        l1 = parcel.readLong();
        if (l1 == 0L)
        {
            obj = null;
        } else
        {
            obj = new Date(l1);
        }
        f = ((Date) (obj));
        g = a(parcel.readString());
        h = a(parcel.readString());
        i = a(parcel.readString());
        j = a(parcel.readString());
        l1 = parcel.readLong();
        if (l1 == 0L)
        {
            obj = null;
        } else
        {
            obj = new Date(l1);
        }
        k = ((Date) (obj));
        obj = parcel.readString();
        if (((String) (obj)).length() == 0)
        {
            obj = obj1;
        } else
        {
            obj = NVGender.valueOf(((String) (obj)));
        }
        l = ((NVGender) (obj));
        m = a(parcel.readString());
        n = a(parcel.readString());
        o = a(parcel.readString());
        p = a(parcel.readString());
        q = a(parcel.readString());
        r = a(parcel.readString());
        s = a(parcel.readString());
        t = (NetverifyMrzData)parcel.readParcelable(getClass().getClassLoader());
        u = parcel.readString();
        v = a(parcel.readInt());
    }

    public NetverifyDocumentData(Parcel parcel, gb gb1)
    {
        this(parcel);
    }

    private Boolean a(int i1)
    {
        Boolean boolean1 = null;
        if (i1 == 2)
        {
            boolean1 = Boolean.valueOf(true);
        } else
        if (i1 == 1)
        {
            return Boolean.valueOf(false);
        }
        return boolean1;
    }

    private String a(String s1)
    {
        String s2 = s1;
        if (s1.length() == 0)
        {
            s2 = null;
        }
        return s2;
    }

    private boolean b(String s1)
    {
        while (s1 == null || s1.length() == 0 || (new Country(s1)).c().equalsIgnoreCase(s1)) 
        {
            return false;
        }
        return true;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCity()
    {
        return o;
    }

    public Date getDob()
    {
        return k;
    }

    public Date getExpiryDate()
    {
        return f;
    }

    public String getFirstName()
    {
        return i;
    }

    public NVGender getGender()
    {
        return l;
    }

    public String getIdNumber()
    {
        return c;
    }

    public String getIssuingCountry()
    {
        return g;
    }

    public Date getIssuingDate()
    {
        return e;
    }

    public String getLastName()
    {
        return h;
    }

    public Boolean getLivenessDetected()
    {
        return v;
    }

    public String getMiddleName()
    {
        return j;
    }

    public NetverifyMrzData getMrzData()
    {
        return t;
    }

    public int getNameDistance()
    {
        if (u == null)
        {
            return -1;
        } else
        {
            return (new bh(u, (new StringBuilder()).append(getFirstName()).append(" ").append(getLastName()).toString())).a();
        }
    }

    public String getOptionalData1()
    {
        return r;
    }

    public String getOptionalData2()
    {
        return s;
    }

    public String getOriginatingCountry()
    {
        return m;
    }

    public String getPersonalNumber()
    {
        return d;
    }

    public String getPostalCode()
    {
        return q;
    }

    public String getSelectedCountry()
    {
        return a;
    }

    public NVDocumentType getSelectedDocumentType()
    {
        return b;
    }

    public String getState()
    {
        return p;
    }

    public String getStreet()
    {
        return n;
    }

    public boolean isNameMatch()
    {
        if (u == null)
        {
            return false;
        } else
        {
            return (new bh(u, (new StringBuilder()).append(getFirstName()).append(" ").append(getLastName()).toString())).b();
        }
    }

    public void setCity(String s1)
    {
        o = bi.a(s1, 64);
    }

    public void setDob(Date date)
    {
        k = date;
    }

    public void setExpiryDate(Date date)
    {
        f = date;
    }

    public void setFirstName(String s1)
    {
        i = bi.a(s1, 100);
    }

    public void setGender(NVGender nvgender)
    {
        l = nvgender;
    }

    public void setIdNumber(String s1)
    {
        c = bi.a(s1, 100);
    }

    public void setIssuingCountry(String s1)
    {
        g = bi.a(s1, 3, "[A-Z]{3}");
        if (!b(s1))
        {
            g = null;
        }
    }

    public void setIssuingDate(Date date)
    {
        e = date;
    }

    public void setLastName(String s1)
    {
        h = bi.a(s1, 100);
    }

    public void setLivenessDetected(Boolean boolean1)
    {
        v = boolean1;
    }

    public void setMiddleName(String s1)
    {
        j = bi.a(s1, 100);
    }

    public void setMrzData(MrzResult mrzresult, NVMRZFormat nvmrzformat, StringVector stringvector)
    {
        if (t == null)
        {
            t = new NetverifyMrzData(mrzresult, nvmrzformat);
        }
        if (stringvector.size() >= 1L)
        {
            t.setMrzLine1(stringvector.get(0));
        }
        if (stringvector.size() >= 2L)
        {
            t.setMrzLine2(stringvector.get(1));
        }
        if (stringvector.size() >= 3L)
        {
            t.setMrzLine3(stringvector.get(2));
        }
    }

    public void setName(String s1)
    {
        u = s1;
    }

    public void setOptionalData1(String s1)
    {
        r = bi.a(s1, 50, "^[A-Z0-9]*$");
    }

    public void setOptionalData2(String s1)
    {
        s = bi.a(s1, 50, "^[A-Z0-9]*$");
    }

    public void setOriginatingCountry(String s1)
    {
        m = bi.a(s1, 3, "[A-Z]{3}");
        if (!b(s1))
        {
            m = null;
        }
    }

    public void setPersonalNumber(String s1)
    {
        d = bi.a(s1, 14, "^[A-Z0-9]*$");
    }

    public void setPostalCode(String s1)
    {
        q = bi.a(s1, 15);
    }

    public void setSelectedCountry(String s1)
    {
        a = bi.a(s1, 3);
    }

    public void setSelectedDocumentType(NVDocumentType nvdocumenttype)
    {
        b = nvdocumenttype;
    }

    public void setState(String s1)
    {
        p = bi.a(s1, 3, "[A-Z]{2,3}");
    }

    public void setStreet(String s1)
    {
        n = bi.a(s1, 255);
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        long l2 = 0L;
        String s1;
        long l1;
        if (a == null)
        {
            s1 = "";
        } else
        {
            s1 = a;
        }
        parcel.writeString(s1);
        if (b == null)
        {
            s1 = "";
        } else
        {
            s1 = b.name();
        }
        parcel.writeString(s1);
        if (c == null)
        {
            s1 = "";
        } else
        {
            s1 = c;
        }
        parcel.writeString(s1);
        if (d == null)
        {
            s1 = "";
        } else
        {
            s1 = d;
        }
        parcel.writeString(s1);
        if (e == null)
        {
            l1 = 0L;
        } else
        {
            l1 = e.getTime();
        }
        parcel.writeLong(l1);
        if (f == null)
        {
            l1 = 0L;
        } else
        {
            l1 = f.getTime();
        }
        parcel.writeLong(l1);
        if (g == null)
        {
            s1 = "";
        } else
        {
            s1 = g;
        }
        parcel.writeString(s1);
        if (h == null)
        {
            s1 = "";
        } else
        {
            s1 = h;
        }
        parcel.writeString(s1);
        if (i == null)
        {
            s1 = "";
        } else
        {
            s1 = i;
        }
        parcel.writeString(s1);
        if (j == null)
        {
            s1 = "";
        } else
        {
            s1 = j;
        }
        parcel.writeString(s1);
        if (k == null)
        {
            l1 = l2;
        } else
        {
            l1 = k.getTime();
        }
        parcel.writeLong(l1);
        if (l == null)
        {
            s1 = "";
        } else
        {
            s1 = l.name();
        }
        parcel.writeString(s1);
        if (m == null)
        {
            s1 = "";
        } else
        {
            s1 = m;
        }
        parcel.writeString(s1);
        if (n == null)
        {
            s1 = "";
        } else
        {
            s1 = n;
        }
        parcel.writeString(s1);
        if (o == null)
        {
            s1 = "";
        } else
        {
            s1 = o;
        }
        parcel.writeString(s1);
        if (p == null)
        {
            s1 = "";
        } else
        {
            s1 = p;
        }
        parcel.writeString(s1);
        if (q == null)
        {
            s1 = "";
        } else
        {
            s1 = q;
        }
        parcel.writeString(s1);
        if (r == null)
        {
            s1 = "";
        } else
        {
            s1 = r;
        }
        parcel.writeString(s1);
        if (s == null)
        {
            s1 = "";
        } else
        {
            s1 = s;
        }
        parcel.writeString(s1);
        parcel.writeParcelable(t, 0);
        parcel.writeString(u);
        if (v == null)
        {
            i1 = 0;
        } else
        if (v.booleanValue())
        {
            i1 = 2;
        } else
        {
            i1 = 1;
        }
        parcel.writeInt(i1);
    }

}
