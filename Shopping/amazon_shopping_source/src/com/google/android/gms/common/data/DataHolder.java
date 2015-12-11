// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.common.data:
//            f

public final class DataHolder
    implements SafeParcelable
{
    public static class a
    {

        private final String EG[];
        private final ArrayList EP;
        private final String EQ;
        private final HashMap ER;
        private boolean ES;
        private String ET;

        private a(String as[], String s)
        {
            EG = (String[])hm.f(as);
            EP = new ArrayList();
            EQ = s;
            ER = new HashMap();
            ES = false;
            ET = null;
        }

    }


    public static final f CREATOR = new f();
    private static final a EO = new a(new String[0], null) {

    };
    private final int CT;
    private final String EG[];
    Bundle EH;
    private final CursorWindow EI[];
    private final Bundle EJ;
    int EK[];
    int EL;
    private Object EM;
    private boolean EN;
    boolean mClosed;
    private final int xM;

    DataHolder(int i, String as[], CursorWindow acursorwindow[], int j, Bundle bundle)
    {
        mClosed = false;
        EN = true;
        xM = i;
        EG = as;
        EI = acursorwindow;
        CT = j;
        EJ = bundle;
    }

    private void e(String s, int i)
    {
        if (EH == null || !EH.containsKey(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No such column: ").append(s).toString());
        }
        if (isClosed())
        {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= EL)
        {
            throw new CursorIndexOutOfBoundsException(i, EL);
        } else
        {
            return;
        }
    }

    public long a(String s, int i, int j)
    {
        e(s, i);
        return EI[j].getLong(i, EH.getInt(s));
    }

    public int ae(int i)
    {
        int k = 0;
        boolean flag;
        if (i >= 0 && i < EL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hm.A(flag);
        do
        {
label0:
            {
                int j = k;
                if (k < EK.length)
                {
                    if (i >= EK[k])
                    {
                        break label0;
                    }
                    j = k - 1;
                }
                i = j;
                if (j == EK.length)
                {
                    i = j - 1;
                }
                return i;
            }
            k++;
        } while (true);
    }

    public boolean av(String s)
    {
        return EH.containsKey(s);
    }

    public int b(String s, int i, int j)
    {
        e(s, i);
        return EI[j].getInt(i, EH.getInt(s));
    }

    public void b(Object obj)
    {
        EM = obj;
    }

    public String c(String s, int i, int j)
    {
        e(s, i);
        return EI[j].getString(i, EH.getInt(s));
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (mClosed) goto _L2; else goto _L1
_L1:
        mClosed = true;
        int i = 0;
_L3:
        if (i >= EI.length)
        {
            break; /* Loop/switch isn't completed */
        }
        EI[i].close();
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean d(String s, int i, int j)
    {
        e(s, i);
        return Long.valueOf(EI[j].getLong(i, EH.getInt(s))).longValue() == 1L;
    }

    public int describeContents()
    {
        return 0;
    }

    public float e(String s, int i, int j)
    {
        e(s, i);
        return EI[j].getFloat(i, EH.getInt(s));
    }

    public Bundle eU()
    {
        return EJ;
    }

    public void eW()
    {
        int k = 0;
        EH = new Bundle();
        for (int i = 0; i < EG.length; i++)
        {
            EH.putInt(EG[i], i);
        }

        EK = new int[EI.length];
        boolean flag = false;
        int j = k;
        k = ((flag) ? 1 : 0);
        for (; j < EI.length; j++)
        {
            EK[j] = k;
            int l = EI[j].getStartPosition();
            k += EI[j].getNumRows() - (k - l);
        }

        EL = k;
    }

    String[] eX()
    {
        return EG;
    }

    CursorWindow[] eY()
    {
        return EI;
    }

    public byte[] f(String s, int i, int j)
    {
        e(s, i);
        return EI[j].getBlob(i, EH.getInt(s));
    }

    protected void finalize()
        throws Throwable
    {
        if (!EN || EI.length <= 0 || isClosed()) goto _L2; else goto _L1
_L1:
        String s;
        if (EM != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = (new StringBuilder()).append("internal object: ").append(toString()).toString();
_L3:
        Log.e("DataBuffer", (new StringBuilder()).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (").append(s).append(")").toString());
        close();
_L2:
        super.finalize();
        return;
        s = EM.toString();
          goto _L3
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public Uri g(String s, int i, int j)
    {
        s = c(s, i, j);
        if (s == null)
        {
            return null;
        } else
        {
            return Uri.parse(s);
        }
    }

    public int getCount()
    {
        return EL;
    }

    public int getStatusCode()
    {
        return CT;
    }

    int getVersionCode()
    {
        return xM;
    }

    public boolean h(String s, int i, int j)
    {
        e(s, i);
        return EI[j].isNull(i, EH.getInt(s));
    }

    public boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mClosed;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.common.data.f.a(this, parcel, i);
    }

}
