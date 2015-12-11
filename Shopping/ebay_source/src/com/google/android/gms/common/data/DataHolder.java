// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.common.data:
//            zze

public final class DataHolder
    implements SafeParcelable
{
    public static class zza
    {

        private final ArrayList zzYF;
        private final String zzYG;
        private final HashMap zzYH;
        private boolean zzYI;
        private String zzYJ;
        private final String zzYw[];

        private zza(String as[], String s)
        {
            zzYw = (String[])zzu.zzu(as);
            zzYF = new ArrayList();
            zzYG = s;
            zzYH = new HashMap();
            zzYI = false;
            zzYJ = null;
        }

    }


    public static final zze CREATOR = new zze();
    private static final zza zzYE = new zza(new String[0], null) {

    };
    boolean mClosed;
    private final int zzCY;
    private final int zzTS;
    int zzYA[];
    int zzYB;
    private Object zzYC;
    private boolean zzYD;
    private final String zzYw[];
    Bundle zzYx;
    private final CursorWindow zzYy[];
    private final Bundle zzYz;

    DataHolder(int i, String as[], CursorWindow acursorwindow[], int j, Bundle bundle)
    {
        mClosed = false;
        zzYD = true;
        zzCY = i;
        zzYw = as;
        zzYy = acursorwindow;
        zzTS = j;
        zzYz = bundle;
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
        if (i >= zzYy.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzYy[i].close();
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

    public int describeContents()
    {
        return 0;
    }

    protected void finalize()
        throws Throwable
    {
        if (!zzYD || zzYy.length <= 0 || isClosed()) goto _L2; else goto _L1
_L1:
        String s;
        if (zzYC != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = (new StringBuilder()).append("internal object: ").append(toString()).toString();
_L3:
        Log.e("DataBuffer", (new StringBuilder()).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (").append(s).append(")").toString());
        close();
_L2:
        super.finalize();
        return;
        s = zzYC.toString();
          goto _L3
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getStatusCode()
    {
        return zzTS;
    }

    int getVersionCode()
    {
        return zzCY;
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
        zze.zza(this, parcel, i);
    }

    public Bundle zznb()
    {
        return zzYz;
    }

    public void zznf()
    {
        int k = 0;
        zzYx = new Bundle();
        for (int i = 0; i < zzYw.length; i++)
        {
            zzYx.putInt(zzYw[i], i);
        }

        zzYA = new int[zzYy.length];
        boolean flag = false;
        int j = k;
        k = ((flag) ? 1 : 0);
        for (; j < zzYy.length; j++)
        {
            zzYA[j] = k;
            int l = zzYy[j].getStartPosition();
            k += zzYy[j].getNumRows() - (k - l);
        }

        zzYB = k;
    }

    String[] zzng()
    {
        return zzYw;
    }

    CursorWindow[] zznh()
    {
        return zzYy;
    }

}
