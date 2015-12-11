// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.jumio.mrz.impl.smartEngines.swig.MrzField;
import com.jumio.mrz.impl.smartEngines.swig.MrzResult;
import com.jumio.netverify.sdk.enums.NVMRZFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jumiomobile.gc;

public class NetverifyMrzData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new gc();
    private String a;
    private String b;
    private String c;
    private NVMRZFormat d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;

    public NetverifyMrzData(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        d = NVMRZFormat.MRP;
        h = true;
        i = false;
        a = parcel.readString();
        b = parcel.readString();
        c = parcel.readString();
        int j = parcel.readInt();
        boolean flag;
        try
        {
            d = NVMRZFormat.values()[j];
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            d = NVMRZFormat.MRP;
        }
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        h = flag;
    }

    public NetverifyMrzData(MrzResult mrzresult, NVMRZFormat nvmrzformat)
    {
        d = NVMRZFormat.MRP;
        h = true;
        i = false;
        d = nvmrzformat;
        Object obj = mrzresult.getBirthdate();
        boolean flag;
        if (((MrzField) (obj)).hasChecksumOcrChar())
        {
            flag = ((MrzField) (obj)).hasCorrectChecksum();
        } else
        {
            flag = true;
        }
        e = flag;
        obj = mrzresult.getDocNum();
        if (((MrzField) (obj)).hasChecksumOcrChar())
        {
            flag = ((MrzField) (obj)).hasCorrectChecksum();
        } else
        {
            flag = true;
        }
        f = flag;
        if (nvmrzformat != NVMRZFormat.CNIS)
        {
            Object obj1 = mrzresult.getExpidate();
            if (((MrzField) (obj1)).hasChecksumOcrChar())
            {
                flag = ((MrzField) (obj1)).hasCorrectChecksum();
            } else
            {
                flag = true;
            }
            g = flag;
        } else
        {
            g = true;
        }
        if (nvmrzformat == NVMRZFormat.MRP)
        {
            obj1 = mrzresult.getOptData2();
            if (((MrzField) (obj1)).hasChecksumOcrChar())
            {
                flag = ((MrzField) (obj1)).hasCorrectChecksum();
            } else
            {
                flag = true;
            }
            h = flag;
        } else
        {
            h = true;
        }
        if (nvmrzformat == NVMRZFormat.MRV_A || nvmrzformat == NVMRZFormat.MRV_B)
        {
            i = true;
            return;
        } else
        {
            i = mrzresult.hasCorrectCompositeChecksum();
            return;
        }
    }

    private String a(String s, int j, String s1)
    {
label0:
        {
            if (s != null)
            {
                String s2 = s.trim();
                s = s2;
                if (s2.length() > j)
                {
                    s = s2.substring(0, j);
                }
                if (s1 == null || Pattern.compile(s1).matcher(s).matches())
                {
                    break label0;
                }
            }
            return null;
        }
        return s;
    }

    public boolean compositeValid()
    {
        return i;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean dobValid()
    {
        return e;
    }

    public boolean expiryDateValid()
    {
        return g;
    }

    public NVMRZFormat getFormat()
    {
        return d;
    }

    public String getMrzLine1()
    {
        return a;
    }

    public String getMrzLine2()
    {
        return b;
    }

    public String getMrzLine3()
    {
        return c;
    }

    public boolean idNumberValid()
    {
        return f;
    }

    public boolean personalNumberValid()
    {
        return h;
    }

    public void setMrzLine1(String s)
    {
        a = a(s, 50, null);
    }

    public void setMrzLine2(String s)
    {
        b = a(s, 50, null);
    }

    public void setMrzLine3(String s)
    {
        c = s;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        boolean flag = true;
        parcel.writeString(a);
        parcel.writeString(b);
        parcel.writeString(c);
        parcel.writeInt(d.ordinal());
        if (e)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (g)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (i)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (f)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (h)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
    }

}
