// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.common.data:
//            zze

public final class DataHolder
    implements SafeParcelable
{

    public static final zze CREATOR = new zze();
    private static final zza zzadx = new _cls1(new String[0], null);
    boolean mClosed;
    private final int mVersionCode;
    private final int zzYm;
    private final String zzadp[];
    Bundle zzadq;
    private final CursorWindow zzadr[];
    private final Bundle zzads;
    int zzadt[];
    int zzadu;
    private Object zzadv;
    private boolean zzadw;

    DataHolder(int i, String as[], CursorWindow acursorwindow[], int j, Bundle bundle)
    {
        mClosed = false;
        zzadw = true;
        mVersionCode = i;
        zzadp = as;
        zzadr = acursorwindow;
        zzYm = j;
        zzads = bundle;
    }

    private DataHolder(zza zza1, int i, Bundle bundle)
    {
        this(zza.zza(zza1), zza(zza1, -1), i, bundle);
    }

    public DataHolder(String as[], CursorWindow acursorwindow[], int i, Bundle bundle)
    {
        mClosed = false;
        zzadw = true;
        mVersionCode = 1;
        zzadp = (String[])zzx.zzw(as);
        zzadr = (CursorWindow[])zzx.zzw(acursorwindow);
        zzYm = i;
        zzads = bundle;
        zzov();
    }

    public static DataHolder zza(int i, Bundle bundle)
    {
        return new DataHolder(zzadx, i, bundle);
    }

    private static CursorWindow[] zza(zza zza1, int i)
    {
        CursorWindow cursorwindow;
        Object obj;
        Object obj1;
        ArrayList arraylist;
        int j;
        boolean flag;
        flag = false;
        if (zza.zza(zza1).length == 0)
        {
            return new CursorWindow[0];
        }
        int l;
        if (i < 0 || i >= zza.zzb(zza1).size())
        {
            obj1 = zza.zzb(zza1);
        } else
        {
            obj1 = zza.zzb(zza1).subList(0, i);
        }
        l = ((List) (obj1)).size();
        obj = new CursorWindow(false);
        arraylist = new ArrayList();
        arraylist.add(obj);
        ((CursorWindow) (obj)).setNumColumns(zza.zza(zza1).length);
        i = 0;
        j = 0;
_L4:
        if (i >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        cursorwindow = ((CursorWindow) (obj));
        if (((CursorWindow) (obj)).allocRow())
        {
            break MISSING_BLOCK_LABEL_216;
        }
        Log.d("DataHolder", (new StringBuilder("Allocating additional cursor window for large data set (row ")).append(i).append(")").toString());
        obj = new CursorWindow(false);
        ((CursorWindow) (obj)).setStartPosition(i);
        ((CursorWindow) (obj)).setNumColumns(zza.zza(zza1).length);
        arraylist.add(obj);
        cursorwindow = ((CursorWindow) (obj));
        if (((CursorWindow) (obj)).allocRow())
        {
            break MISSING_BLOCK_LABEL_216;
        }
        Log.e("DataHolder", "Unable to allocate row to hold data.");
        arraylist.remove(obj);
        zza1 = (CursorWindow[])arraylist.toArray(new CursorWindow[arraylist.size()]);
        return zza1;
        obj = (Map)((List) (obj1)).get(i);
        int k;
        k = 0;
        String s;
        Object obj2;
        long l1;
        for (boolean flag1 = true; k >= zza.zza(zza1).length || !flag1; k++)
        {
            break MISSING_BLOCK_LABEL_556;
        }

        s = zza.zza(zza1)[k];
        obj2 = ((Map) (obj)).get(s);
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        flag1 = cursorwindow.putNull(i, k);
        break MISSING_BLOCK_LABEL_693;
        if (obj2 instanceof String)
        {
            flag1 = cursorwindow.putString((String)obj2, i, k);
            break MISSING_BLOCK_LABEL_693;
        }
        if (obj2 instanceof Long)
        {
            flag1 = cursorwindow.putLong(((Long)obj2).longValue(), i, k);
            break MISSING_BLOCK_LABEL_693;
        }
        if (obj2 instanceof Integer)
        {
            flag1 = cursorwindow.putLong(((Integer)obj2).intValue(), i, k);
            break MISSING_BLOCK_LABEL_693;
        }
        if (!(obj2 instanceof Boolean))
        {
            break MISSING_BLOCK_LABEL_403;
        }
        if (((Boolean)obj2).booleanValue())
        {
            l1 = 1L;
        } else
        {
            l1 = 0L;
        }
        flag1 = cursorwindow.putLong(l1, i, k);
        break MISSING_BLOCK_LABEL_693;
        if (obj2 instanceof byte[])
        {
            flag1 = cursorwindow.putBlob((byte[])obj2, i, k);
            break MISSING_BLOCK_LABEL_693;
        }
        if (obj2 instanceof Double)
        {
            flag1 = cursorwindow.putDouble(((Double)obj2).doubleValue(), i, k);
            break MISSING_BLOCK_LABEL_693;
        }
        if (obj2 instanceof Float)
        {
            flag1 = cursorwindow.putDouble(((Float)obj2).floatValue(), i, k);
            break MISSING_BLOCK_LABEL_693;
        }
        try
        {
            throw new IllegalArgumentException((new StringBuilder("Unsupported object for column ")).append(s).append(": ").append(obj2).toString());
        }
        // Misplaced declaration of an exception variable
        catch (zza zza1)
        {
            j = arraylist.size();
        }
        for (i = ((flag) ? 1 : 0); i < j; i++)
        {
            ((CursorWindow)arraylist.get(i)).close();
        }

        break MISSING_BLOCK_LABEL_674;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_662;
        }
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_576;
        }
        throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
        Log.d("DataHolder", (new StringBuilder("Couldn't populate window data for row ")).append(i).append(" - allocating new window.").toString());
        cursorwindow.freeLastRow();
        cursorwindow = new CursorWindow(false);
        cursorwindow.setStartPosition(i);
        cursorwindow.setNumColumns(zza.zza(zza1).length);
        arraylist.add(cursorwindow);
        j = i - 1;
        i = 1;
_L2:
        k = i;
        i = j + 1;
        obj = cursorwindow;
        j = k;
        continue; /* Loop/switch isn't completed */
        k = 0;
        j = i;
        i = k;
        if (true) goto _L2; else goto _L1
_L1:
        throw zza1;
        if (true) goto _L4; else goto _L3
_L3:
        return (CursorWindow[])arraylist.toArray(new CursorWindow[arraylist.size()]);
    }

    public static DataHolder zzbu(int i)
    {
        return zza(i, ((Bundle) (null)));
    }

    private void zzh(String s, int i)
    {
        if (zzadq == null || !zzadq.containsKey(s))
        {
            throw new IllegalArgumentException((new StringBuilder("No such column: ")).append(s).toString());
        }
        if (isClosed())
        {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= zzadu)
        {
            throw new CursorIndexOutOfBoundsException(i, zzadu);
        } else
        {
            return;
        }
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (mClosed) goto _L2; else goto _L1
_L1:
        mClosed = true;
        int i = 0;
_L3:
        if (i >= zzadr.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzadr[i].close();
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

    public final int describeContents()
    {
        return 0;
    }

    protected final void finalize()
    {
        if (!zzadw || zzadr.length <= 0 || isClosed()) goto _L2; else goto _L1
_L1:
        String s;
        if (zzadv != null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        s = (new StringBuilder("internal object: ")).append(toString()).toString();
_L3:
        Log.e("DataBuffer", (new StringBuilder("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (")).append(s).append(")").toString());
        close();
_L2:
        super.finalize();
        return;
        s = zzadv.toString();
          goto _L3
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public final int getCount()
    {
        return zzadu;
    }

    public final int getStatusCode()
    {
        return zzYm;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final boolean isClosed()
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

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.common.data.zze.zza(this, parcel, i);
    }

    public final void zza(String s, int i, int j, CharArrayBuffer chararraybuffer)
    {
        zzh(s, i);
        zzadr[j].copyStringToBuffer(i, zzadq.getInt(s), chararraybuffer);
    }

    public final long zzb(String s, int i, int j)
    {
        zzh(s, i);
        return zzadr[j].getLong(i, zzadq.getInt(s));
    }

    public final int zzbt(int i)
    {
        int k = 0;
        boolean flag;
        if (i >= 0 && i < zzadu)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        do
        {
label0:
            {
                int j = k;
                if (k < zzadt.length)
                {
                    if (i >= zzadt[k])
                    {
                        break label0;
                    }
                    j = k - 1;
                }
                i = j;
                if (j == zzadt.length)
                {
                    i = j - 1;
                }
                return i;
            }
            k++;
        } while (true);
    }

    public final int zzc(String s, int i, int j)
    {
        zzh(s, i);
        return zzadr[j].getInt(i, zzadq.getInt(s));
    }

    public final boolean zzce(String s)
    {
        return zzadq.containsKey(s);
    }

    public final String zzd(String s, int i, int j)
    {
        zzh(s, i);
        return zzadr[j].getString(i, zzadq.getInt(s));
    }

    public final boolean zze(String s, int i, int j)
    {
        zzh(s, i);
        return Long.valueOf(zzadr[j].getLong(i, zzadq.getInt(s))).longValue() == 1L;
    }

    public final float zzf(String s, int i, int j)
    {
        zzh(s, i);
        return zzadr[j].getFloat(i, zzadq.getInt(s));
    }

    public final byte[] zzg(String s, int i, int j)
    {
        zzh(s, i);
        return zzadr[j].getBlob(i, zzadq.getInt(s));
    }

    public final Uri zzh(String s, int i, int j)
    {
        s = zzd(s, i, j);
        if (s == null)
        {
            return null;
        } else
        {
            return Uri.parse(s);
        }
    }

    public final boolean zzi(String s, int i, int j)
    {
        zzh(s, i);
        return zzadr[j].isNull(i, zzadq.getInt(s));
    }

    public final Bundle zzor()
    {
        return zzads;
    }

    public final void zzov()
    {
        int k = 0;
        zzadq = new Bundle();
        for (int i = 0; i < zzadp.length; i++)
        {
            zzadq.putInt(zzadp[i], i);
        }

        zzadt = new int[zzadr.length];
        boolean flag = false;
        int j = k;
        k = ((flag) ? 1 : 0);
        for (; j < zzadr.length; j++)
        {
            zzadt[j] = k;
            int l = zzadr[j].getStartPosition();
            k += zzadr[j].getNumRows() - (k - l);
        }

        zzadu = k;
    }

    final String[] zzow()
    {
        return zzadp;
    }

    final CursorWindow[] zzox()
    {
        return zzadr;
    }

    public final void zzr(Object obj)
    {
        zzadv = obj;
    }


    private class zza
    {

        private final HashMap zzadA;
        private boolean zzadB;
        private String zzadC;
        private final String zzadp[];
        private final ArrayList zzady;
        private final String zzadz;

        static String[] zza(zza zza1)
        {
            return zza1.zzadp;
        }

        static ArrayList zzb(zza zza1)
        {
            return zza1.zzady;
        }

        private zza(String as[], String s)
        {
            zzadp = (String[])zzx.zzw(as);
            zzady = new ArrayList();
            zzadz = s;
            zzadA = new HashMap();
            zzadB = false;
            zzadC = null;
        }

        zza(String as[], String s, _cls1 _pcls1)
        {
            this(as, s);
        }
    }


    private class zzb extends RuntimeException
    {

        public zzb(String s)
        {
            super(s);
        }
    }


    private class _cls1 extends zza
    {

        _cls1(String as[], String s)
        {
            super(as, s, null);
        }
    }

}
