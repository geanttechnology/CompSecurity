// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.core.vo;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentVariant;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.util.ArrayList;
import jumiomobile.hm;
import jumiomobile.hq;
import jumiomobile.mk;

public class DocumentType
    implements Parcelable, Comparable
{

    public static final String BARCODE_FORMAT_PDF417 = "PDF417";
    public static final String BARCODE_SIDE_BACK = "BACK";
    public static final String BARCODE_SIDE_FRONT = "FRONT";
    public static final android.os.Parcelable.Creator CREATOR = new hm();
    public static final String MRZ_FORMAT_CNIS = "CNIS";
    public static final String MRZ_FORMAT_MRP = "MRP";
    public static final String MRZ_FORMAT_MRV = "MRV";
    public static final String MRZ_FORMAT_MRV_A = "MRV_A";
    public static final String MRZ_FORMAT_MRV_B = "MRV_B";
    public static final String MRZ_FORMAT_TD1 = "TD1";
    public static final String MRZ_FORMAT_TD2 = "TD2";
    public static final String MRZ_SIDE_BACK = "BACK";
    public static final String MRZ_SIDE_FRONT = "FRONT";
    public static final String PART_BACK = "BACKSIDE";
    public static final String PART_FACE = "FACE";
    public static final String PART_FRONT = "FRONTSIDE";
    public static final String THIRD_PARTY_OCR_FORMAT_CSSN = "CSSN";
    private final boolean a;
    private NVDocumentType b;
    private int c;
    private boolean d;
    private hq e;
    private NVScanSide f;
    private int g;
    private hq h;
    private NVScanSide i;
    private boolean j;
    private boolean k;
    private NVDocumentVariant l;

    public DocumentType(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        c = 1;
        e = null;
        f = null;
        g = 1;
        h = null;
        i = null;
        j = false;
        k = false;
        l = null;
        b = NVDocumentType.valueOf(parcel.readString());
        c = parcel.readInt();
        e = hq.valueOf(parcel.readString());
        f = NVScanSide.valueOf(parcel.readString());
        g = parcel.readInt();
        h = hq.valueOf(parcel.readString());
        i = NVScanSide.valueOf(parcel.readString());
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        a = flag;
        parcel = parcel.readString();
        if (parcel.length() != 0)
        {
            parcel = NVDocumentVariant.valueOf(parcel);
        } else
        {
            parcel = null;
        }
        l = parcel;
    }

    public DocumentType(DocumentType documenttype)
    {
        c = 1;
        e = null;
        f = null;
        g = 1;
        h = null;
        i = null;
        j = false;
        k = false;
        l = null;
        b = documenttype.b;
        c = documenttype.c;
        e = documenttype.e;
        f = documenttype.f;
        g = documenttype.g;
        h = documenttype.h;
        i = documenttype.i;
        j = documenttype.j;
        k = documenttype.k;
        a = documenttype.a;
        l = documenttype.l;
    }

    public DocumentType(String s, int i1, String s1, String s2, String s3, String s4, String s5, 
            boolean flag, int j1)
    {
        c = 1;
        e = null;
        f = null;
        g = 1;
        h = null;
        i = null;
        j = false;
        k = false;
        l = null;
        b = NVDocumentType.fromString(s);
        c = i1;
        if (b == NVDocumentType.PASSPORT)
        {
            e = hq.a;
        } else
        if (b == NVDocumentType.VISA)
        {
            e = hq.b;
        } else
        {
            e = hq.i;
        }
        f = NVScanSide.FRONT;
        if (s1.length() != 0)
        {
            if ("MRP".equals(s1))
            {
                e = hq.a;
            } else
            if ("MRV".equals(s1) || "MRV_A".equals(s1) || "MRV_B".equals(s1))
            {
                e = hq.b;
            } else
            if ("TD1".equals(s1))
            {
                e = hq.c;
            } else
            if ("TD2".equals(s1))
            {
                e = hq.d;
            } else
            if ("CNIS".equals(s1))
            {
                e = hq.e;
            }
            if ("FRONT".equals(s2))
            {
                f = NVScanSide.FRONT;
            } else
            if ("BACK".equals(s2))
            {
                f = NVScanSide.BACK;
            }
            d = true;
        } else
        if (s3.length() != 0)
        {
            if ("PDF417".equals(s3))
            {
                e = hq.f;
            }
            if ("FRONT".equals(s4))
            {
                f = NVScanSide.FRONT;
            } else
            if ("BACK".equals(s4))
            {
                f = NVScanSide.BACK;
            }
            d = true;
        }
        if (s5.length() != 0)
        {
            if ("CSSN".equals(s5))
            {
                if (e == hq.i && f == NVScanSide.FRONT)
                {
                    e = hq.h;
                    f = NVScanSide.FRONT;
                    j = false;
                } else
                {
                    j = true;
                }
                d = true;
            }
            a = true;
        } else
        {
            a = false;
        }
        if (e == hq.b)
        {
            j = true;
        }
        k = flag;
        i = NVScanSide.FRONT;
        h = hq.l;
        g = j1;
    }

    public int compareTo(DocumentType documenttype)
    {
        if (b != NVDocumentType.PASSPORT || documenttype.getId() == NVDocumentType.PASSPORT)
        {
            if (b == NVDocumentType.VISA && documenttype.getId() == NVDocumentType.PASSPORT)
            {
                return 1;
            }
            if (b != NVDocumentType.VISA || documenttype.getId() == NVDocumentType.VISA)
            {
                if (b == NVDocumentType.IDENTITY_CARD && documenttype.getId() == NVDocumentType.PASSPORT)
                {
                    return 1;
                }
                if (b == NVDocumentType.IDENTITY_CARD && documenttype.getId() == NVDocumentType.VISA)
                {
                    return 1;
                }
                if ((b != NVDocumentType.IDENTITY_CARD || documenttype.getId() != NVDocumentType.DRIVER_LICENSE) && b == NVDocumentType.DRIVER_LICENSE && documenttype.getId() != NVDocumentType.DRIVER_LICENSE)
                {
                    return 1;
                }
            }
        }
        return -1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((DocumentType)obj);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        int i1 = -1;
        if (obj instanceof DocumentType)
        {
            i1 = compareTo((DocumentType)obj);
        }
        return i1 == 0;
    }

    public hq getDocumentScanMode()
    {
        if (NVDocumentVariant.PAPER.equals(l))
        {
            return h;
        } else
        {
            return e;
        }
    }

    public NVScanSide getDocumentScanSide()
    {
        if (NVDocumentVariant.PAPER.equals(l))
        {
            return i;
        } else
        {
            return f;
        }
    }

    public NVDocumentVariant getDocumentVariant()
    {
        return l;
    }

    public NVDocumentType getId()
    {
        return b;
    }

    public String getName(Context context)
    {
        String s = "";
        if (!b.equals(NVDocumentType.PASSPORT)) goto _L2; else goto _L1
_L1:
        s = "documenttype_passport";
_L4:
        return mk.a(context, s);
_L2:
        if (b.equals(NVDocumentType.VISA))
        {
            s = "documenttype_visa";
        } else
        if (b.equals(NVDocumentType.IDENTITY_CARD))
        {
            s = "documenttype_idcard";
        } else
        if (b.equals(NVDocumentType.DRIVER_LICENSE))
        {
            s = "documenttype_driverlicense";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int getParts()
    {
        if (NVDocumentVariant.PAPER.equals(l))
        {
            return g;
        } else
        {
            return c;
        }
    }

    public NVScanSide[] getScanParts(boolean flag)
    {
        int j1 = getParts();
        ArrayList arraylist;
        int i1;
        if (getDocumentScanSide().getPartNumber() >= getParts())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        i1 += j1;
        arraylist = new ArrayList();
        if (i1 > 0)
        {
            arraylist.add(NVScanSide.FRONT);
        }
        if (i1 >= 2)
        {
            arraylist.add(NVScanSide.BACK);
        }
        if (flag)
        {
            arraylist.add(NVScanSide.FACE);
        }
        return (NVScanSide[])arraylist.toArray(new NVScanSide[arraylist.size()]);
    }

    public NVScanSide[] getUploadParts(boolean flag)
    {
        int i1 = getParts();
        ArrayList arraylist = new ArrayList();
        if (i1 > 0)
        {
            arraylist.add(NVScanSide.FRONT);
        }
        if (i1 >= 2)
        {
            arraylist.add(NVScanSide.BACK);
        }
        if (flag)
        {
            arraylist.add(NVScanSide.FACE);
        }
        return (NVScanSide[])arraylist.toArray(new NVScanSide[arraylist.size()]);
    }

    public boolean hasExtractionMethod()
    {
        return d;
    }

    public boolean hasFallbackScan()
    {
        return j || e.equals(hq.m);
    }

    public boolean hasPaperVariant()
    {
        return k;
    }

    public int hashCode()
    {
        return System.identityHashCode(this);
    }

    public boolean isDocumentVariantAccepted(NVDocumentVariant nvdocumentvariant)
    {
        return k && nvdocumentvariant == NVDocumentVariant.PAPER || nvdocumentvariant == NVDocumentVariant.PLASTIC || nvdocumentvariant == null;
    }

    public boolean isThirdPartyOcrDefined()
    {
        return a;
    }

    public void setDocumentScanMode(hq hq1)
    {
        e = hq1;
        if (hq1 == hq.m)
        {
            j = true;
        }
    }

    public void setDocumentScanSide(NVScanSide nvscanside)
    {
        f = nvscanside;
    }

    public void setDocumentVariant(NVDocumentVariant nvdocumentvariant)
    {
        if (isDocumentVariantAccepted(nvdocumentvariant))
        {
            l = nvdocumentvariant;
        }
    }

    public void setFallbackScan(boolean flag)
    {
        j = flag;
    }

    public void setId(NVDocumentType nvdocumenttype)
    {
        b = nvdocumenttype;
    }

    public void setPaperParts(int i1)
    {
        g = i1;
    }

    public void setPaperScanMode(hq hq1)
    {
        h = hq1;
    }

    public void setPaperScanSide(NVScanSide nvscanside)
    {
        i = nvscanside;
    }

    public void setPaperVariant(boolean flag)
    {
        k = flag;
    }

    public void setParts(int i1)
    {
        c = i1;
    }

    public String toString()
    {
        return b.toString();
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        parcel.writeString(b.name());
        parcel.writeInt(c);
        parcel.writeString(e.name());
        parcel.writeString(f.name());
        parcel.writeInt(g);
        parcel.writeString(h.name());
        parcel.writeString(i.name());
        String s;
        if (j)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (k)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (a)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (l == null)
        {
            s = "";
        } else
        {
            s = l.name();
        }
        parcel.writeString(s);
    }

}
