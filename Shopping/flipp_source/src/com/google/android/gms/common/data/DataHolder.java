// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ha;

// Referenced classes of package com.google.android.gms.common.data:
//            c, a, b

public class DataHolder
    implements SafeParcelable
{

    public static final c CREATOR = new c();
    private static final b l = new a(new String[0]);
    final int a;
    final String b[];
    public Bundle c;
    final CursorWindow d[];
    final int e;
    final Bundle f;
    int g[];
    int h;
    boolean i;
    private Object j;
    private boolean k;

    DataHolder(int i1, String as[], CursorWindow acursorwindow[], int j1, Bundle bundle)
    {
        i = false;
        k = true;
        a = i1;
        b = as;
        d = acursorwindow;
        e = j1;
        f = bundle;
    }

    private boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = i;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (i) goto _L2; else goto _L1
_L1:
        i = true;
        int i1 = 0;
_L3:
        if (i1 >= d.length)
        {
            break; /* Loop/switch isn't completed */
        }
        d[i1].close();
        i1++;
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

    public final int a(int i1)
    {
        int k1 = 0;
        boolean flag;
        if (i1 >= 0 && i1 < h)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ha.a(flag);
        do
        {
label0:
            {
                int j1 = k1;
                if (k1 < g.length)
                {
                    if (i1 >= g[k1])
                    {
                        break label0;
                    }
                    j1 = k1 - 1;
                }
                i1 = j1;
                if (j1 == g.length)
                {
                    i1 = j1 - 1;
                }
                return i1;
            }
            k1++;
        } while (true);
    }

    public final String a(String s, int i1, int j1)
    {
        a(s, i1);
        return d[j1].getString(i1, c.getInt(s));
    }

    public final void a()
    {
        int k1 = 0;
        c = new Bundle();
        for (int i1 = 0; i1 < b.length; i1++)
        {
            c.putInt(b[i1], i1);
        }

        g = new int[d.length];
        boolean flag = false;
        int j1 = k1;
        k1 = ((flag) ? 1 : 0);
        for (; j1 < d.length; j1++)
        {
            g[j1] = k1;
            int l1 = d[j1].getStartPosition();
            k1 += d[j1].getNumRows() - (k1 - l1);
        }

        h = k1;
    }

    final void a(String s, int i1)
    {
        if (c == null || !c.containsKey(s))
        {
            throw new IllegalArgumentException((new StringBuilder("No such column: ")).append(s).toString());
        }
        if (b())
        {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i1 < 0 || i1 >= h)
        {
            throw new CursorIndexOutOfBoundsException(i1, h);
        } else
        {
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    protected void finalize()
    {
        if (!k || d.length <= 0 || b()) goto _L2; else goto _L1
_L1:
        String s;
        if (j != null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        s = (new StringBuilder("internal object: ")).append(toString()).toString();
_L3:
        Log.e("DataBuffer", (new StringBuilder("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (")).append(s).append(")").toString());
        c();
_L2:
        super.finalize();
        return;
        s = j.toString();
          goto _L3
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.common.data.c.a(this, parcel, i1);
    }

}
