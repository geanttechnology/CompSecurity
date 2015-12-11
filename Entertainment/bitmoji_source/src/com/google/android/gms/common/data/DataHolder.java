// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.AbstractWindowedCursor;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.er;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolderCreator

public final class DataHolder
    implements SafeParcelable
{
    public static class Builder
    {

        private final String Aa[];
        private final ArrayList Aj;
        private final String Ak;
        private final HashMap Al;
        private boolean Am;
        private String An;

        private void a(HashMap hashmap)
        {
            hashmap = ((HashMap) (hashmap.get(Ak)));
            if (hashmap == null)
            {
                return;
            }
            Integer integer = (Integer)Al.remove(hashmap);
            if (integer != null)
            {
                Aj.remove(integer.intValue());
            }
            Al.put(hashmap, Integer.valueOf(Aj.size()));
        }

        static String[] a(Builder builder1)
        {
            return builder1.Aa;
        }

        static ArrayList b(Builder builder1)
        {
            return builder1.Aj;
        }

        private void dJ()
        {
            if (Ak != null)
            {
                Al.clear();
                int j = Aj.size();
                for (int i = 0; i < j; i++)
                {
                    Object obj = ((HashMap)Aj.get(i)).get(Ak);
                    if (obj != null)
                    {
                        Al.put(obj, Integer.valueOf(i));
                    }
                }

            }
        }

        public DataHolder build(int i)
        {
            return new DataHolder(this, i, null);
        }

        public DataHolder build(int i, Bundle bundle)
        {
            return new DataHolder(this, i, bundle, -1);
        }

        public DataHolder build(int i, Bundle bundle, int j)
        {
            return new DataHolder(this, i, bundle, j);
        }

        public int getCount()
        {
            return Aj.size();
        }

        public Builder removeRowsWithValue(String s, Object obj)
        {
            for (int i = Aj.size() - 1; i >= 0; i--)
            {
                if (ep.equal(((HashMap)Aj.get(i)).get(s), obj))
                {
                    Aj.remove(i);
                }
            }

            return this;
        }

        public Builder sort(String s)
        {
            ed.d(s);
            if (Am && s.equals(An))
            {
                return this;
            } else
            {
                Collections.sort(Aj, new a(s));
                dJ();
                Am = true;
                An = s;
                return this;
            }
        }

        public Builder withRow(ContentValues contentvalues)
        {
            ed.d(contentvalues);
            HashMap hashmap = new HashMap(contentvalues.size());
            java.util.Map.Entry entry;
            for (contentvalues = contentvalues.valueSet().iterator(); contentvalues.hasNext(); hashmap.put(entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)contentvalues.next();
            }

            return withRow(hashmap);
        }

        public Builder withRow(HashMap hashmap)
        {
            ed.d(hashmap);
            if (Ak != null)
            {
                a(hashmap);
            }
            Aj.add(hashmap);
            Am = false;
            return this;
        }

        private Builder(String as[], String s)
        {
            Aa = (String[])er.f(as);
            Aj = new ArrayList();
            Ak = s;
            Al = new HashMap();
            Am = false;
            An = null;
        }

    }

    private static final class a
        implements Comparator
    {

        private final String Ao;

        public int a(HashMap hashmap, HashMap hashmap1)
        {
            hashmap = ((HashMap) (er.f(hashmap.get(Ao))));
            hashmap1 = ((HashMap) (er.f(hashmap1.get(Ao))));
            if (hashmap.equals(hashmap1))
            {
                return 0;
            }
            if (hashmap instanceof Boolean)
            {
                return ((Boolean)hashmap).compareTo((Boolean)hashmap1);
            }
            if (hashmap instanceof Long)
            {
                return ((Long)hashmap).compareTo((Long)hashmap1);
            }
            if (hashmap instanceof Integer)
            {
                return ((Integer)hashmap).compareTo((Integer)hashmap1);
            }
            if (hashmap instanceof String)
            {
                return ((String)hashmap).compareTo((String)hashmap1);
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unknown type for lValue ").append(hashmap).toString());
            }
        }

        public int compare(Object obj, Object obj1)
        {
            return a((HashMap)obj, (HashMap)obj1);
        }

        a(String s)
        {
            Ao = (String)er.f(s);
        }
    }


    private static final Builder Ai = new Builder(new String[0], null) {

        public Builder withRow(ContentValues contentvalues)
        {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        public Builder withRow(HashMap hashmap)
        {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

    };
    public static final DataHolderCreator CREATOR = new DataHolderCreator();
    private final String Aa[];
    Bundle Ab;
    private final CursorWindow Ac[];
    private final Bundle Ad;
    int Ae[];
    int Af;
    private Object Ag;
    private boolean Ah;
    boolean mClosed;
    private final int wj;
    private final int yJ;

    DataHolder(int i, String as[], CursorWindow acursorwindow[], int j, Bundle bundle)
    {
        mClosed = false;
        Ah = true;
        wj = i;
        Aa = as;
        Ac = acursorwindow;
        yJ = j;
        Ad = bundle;
    }

    public DataHolder(AbstractWindowedCursor abstractwindowedcursor, int i, Bundle bundle)
    {
        this(abstractwindowedcursor.getColumnNames(), a(abstractwindowedcursor), i, bundle);
    }

    private DataHolder(Builder builder1, int i, Bundle bundle)
    {
        this(Builder.a(builder1), a(builder1, -1), i, bundle);
    }

    private DataHolder(Builder builder1, int i, Bundle bundle, int j)
    {
        this(Builder.a(builder1), a(builder1, j), i, bundle);
    }



    public DataHolder(String as[], CursorWindow acursorwindow[], int i, Bundle bundle)
    {
        mClosed = false;
        Ah = true;
        wj = 1;
        Aa = (String[])er.f(as);
        Ac = (CursorWindow[])er.f(acursorwindow);
        yJ = i;
        Ad = bundle;
        validateContents();
    }

    private static CursorWindow[] a(AbstractWindowedCursor abstractwindowedcursor)
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        int j;
        j = abstractwindowedcursor.getCount();
        obj = abstractwindowedcursor.getWindow();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((CursorWindow) (obj)).getStartPosition() != 0) goto _L2; else goto _L3
_L3:
        int i;
        ((CursorWindow) (obj)).acquireReference();
        abstractwindowedcursor.setWindow(null);
        arraylist.add(obj);
        i = ((CursorWindow) (obj)).getNumRows();
_L9:
        if (i >= j) goto _L5; else goto _L4
_L4:
        if (!abstractwindowedcursor.moveToPosition(i)) goto _L5; else goto _L6
_L6:
        obj = abstractwindowedcursor.getWindow();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        ((CursorWindow) (obj)).acquireReference();
        abstractwindowedcursor.setWindow(null);
_L7:
        i = ((CursorWindow) (obj)).getNumRows();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_140;
        }
_L5:
        abstractwindowedcursor.close();
        return (CursorWindow[])arraylist.toArray(new CursorWindow[arraylist.size()]);
        obj = new CursorWindow(false);
        ((CursorWindow) (obj)).setStartPosition(i);
        abstractwindowedcursor.fillWindow(i, ((CursorWindow) (obj)));
          goto _L7
        obj;
        abstractwindowedcursor.close();
        throw obj;
        int k;
        arraylist.add(obj);
        i = ((CursorWindow) (obj)).getStartPosition();
        k = ((CursorWindow) (obj)).getNumRows();
        i = k + i;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 0;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static CursorWindow[] a(Builder builder1, int i)
    {
        CursorWindow cursorwindow;
        Object obj;
        ArrayList arraylist;
        int j;
        boolean flag;
        flag = false;
        if (Builder.a(builder1).length == 0)
        {
            return new CursorWindow[0];
        }
        int l;
        if (i < 0 || i >= Builder.b(builder1).size())
        {
            obj = Builder.b(builder1);
        } else
        {
            obj = Builder.b(builder1).subList(0, i);
        }
        l = ((List) (obj)).size();
        cursorwindow = new CursorWindow(false);
        arraylist = new ArrayList();
        arraylist.add(cursorwindow);
        cursorwindow.setNumColumns(Builder.a(builder1).length);
        i = 0;
        j = 0;
_L4:
        if (i >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        if (cursorwindow.allocRow())
        {
            break MISSING_BLOCK_LABEL_215;
        }
        Log.d("DataHolder", (new StringBuilder()).append("Allocating additional cursor window for large data set (row ").append(i).append(")").toString());
        cursorwindow = new CursorWindow(false);
        cursorwindow.setStartPosition(i);
        cursorwindow.setNumColumns(Builder.a(builder1).length);
        arraylist.add(cursorwindow);
        if (cursorwindow.allocRow())
        {
            break MISSING_BLOCK_LABEL_212;
        }
        Log.e("DataHolder", "Unable to allocate row to hold data.");
        arraylist.remove(cursorwindow);
        builder1 = (CursorWindow[])arraylist.toArray(new CursorWindow[arraylist.size()]);
        return builder1;
        j = 0;
        Map map = (Map)((List) (obj)).get(i);
        boolean flag1;
        flag1 = true;
        String s;
        Object obj1;
        long l1;
        for (int k = 0; k >= Builder.a(builder1).length || !flag1; k++)
        {
            break MISSING_BLOCK_LABEL_513;
        }

        s = Builder.a(builder1)[k];
        obj1 = map.get(s);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        flag1 = cursorwindow.putNull(j, k);
        break MISSING_BLOCK_LABEL_639;
        if (obj1 instanceof String)
        {
            flag1 = cursorwindow.putString((String)obj1, j, k);
            break MISSING_BLOCK_LABEL_639;
        }
        if (obj1 instanceof Long)
        {
            flag1 = cursorwindow.putLong(((Long)obj1).longValue(), j, k);
            break MISSING_BLOCK_LABEL_639;
        }
        if (obj1 instanceof Integer)
        {
            flag1 = cursorwindow.putLong(((Integer)obj1).intValue(), j, k);
            break MISSING_BLOCK_LABEL_639;
        }
        if (!(obj1 instanceof Boolean))
        {
            break MISSING_BLOCK_LABEL_408;
        }
        if (((Boolean)obj1).booleanValue())
        {
            l1 = 1L;
        } else
        {
            l1 = 0L;
        }
        flag1 = cursorwindow.putLong(l1, j, k);
        break MISSING_BLOCK_LABEL_639;
        if (obj1 instanceof byte[])
        {
            flag1 = cursorwindow.putBlob((byte[])(byte[])obj1, j, k);
            break MISSING_BLOCK_LABEL_639;
        }
        try
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported object for column ").append(s).append(": ").append(obj1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Builder builder1)
        {
            j = arraylist.size();
        }
        for (i = ((flag) ? 1 : 0); i < j; i++)
        {
            ((CursorWindow)arraylist.get(i)).close();
        }

        break MISSING_BLOCK_LABEL_617;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_602;
        }
        Log.d("DataHolder", (new StringBuilder()).append("Couldn't populate window data for row ").append(i).append(" - allocating new window.").toString());
        cursorwindow.freeLastRow();
        cursorwindow = new CursorWindow(false);
        cursorwindow.setNumColumns(Builder.a(builder1).length);
        arraylist.add(cursorwindow);
        j = i - 1;
        i = 0;
_L2:
        k = j + 1;
        j = i;
        i = k;
        continue; /* Loop/switch isn't completed */
        k = j + 1;
        j = i;
        i = k;
        if (true) goto _L2; else goto _L1
_L1:
        throw builder1;
        if (true) goto _L4; else goto _L3
_L3:
        return (CursorWindow[])arraylist.toArray(new CursorWindow[arraylist.size()]);
    }

    public static Builder builder(String as[])
    {
        return new Builder(as, null);
    }

    public static Builder builder(String as[], String s)
    {
        er.f(s);
        return new Builder(as, s);
    }

    private void e(String s, int i)
    {
        if (Ab == null || !Ab.containsKey(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No such column: ").append(s).toString());
        }
        if (isClosed())
        {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= Af)
        {
            throw new CursorIndexOutOfBoundsException(i, Af);
        } else
        {
            return;
        }
    }

    public static DataHolder empty(int i)
    {
        return empty(i, null);
    }

    public static DataHolder empty(int i, Bundle bundle)
    {
        return new DataHolder(Ai, i, bundle);
    }

    public int I(int i)
    {
        int k = 0;
        boolean flag;
        if (i >= 0 && i < Af)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.v(flag);
        do
        {
label0:
            {
                int j = k;
                if (k < Ae.length)
                {
                    if (i >= Ae[k])
                    {
                        break label0;
                    }
                    j = k - 1;
                }
                i = j;
                if (j == Ae.length)
                {
                    i = j - 1;
                }
                return i;
            }
            k++;
        } while (true);
    }

    public void c(Object obj)
    {
        Ag = obj;
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
        if (i >= Ac.length)
        {
            break; /* Loop/switch isn't completed */
        }
        Ac[i].close();
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

    public void copyToBuffer(String s, int i, int j, CharArrayBuffer chararraybuffer)
    {
        e(s, i);
        Ac[j].copyStringToBuffer(i, Ab.getInt(s), chararraybuffer);
    }

    String[] dH()
    {
        return Aa;
    }

    CursorWindow[] dI()
    {
        return Ac;
    }

    public int describeContents()
    {
        return 0;
    }

    protected void finalize()
        throws Throwable
    {
        if (!Ah || Ac.length <= 0 || isClosed()) goto _L2; else goto _L1
_L1:
        String s;
        if (Ag != null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        s = (new StringBuilder()).append("internal object: ").append(toString()).toString();
_L3:
        Log.e("DataBuffer", (new StringBuilder()).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (").append(s).append(")").toString());
        close();
_L2:
        super.finalize();
        return;
        s = Ag.toString();
          goto _L3
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public boolean getBoolean(String s, int i, int j)
    {
        e(s, i);
        return Long.valueOf(Ac[j].getLong(i, Ab.getInt(s))).longValue() == 1L;
    }

    public byte[] getByteArray(String s, int i, int j)
    {
        e(s, i);
        return Ac[j].getBlob(i, Ab.getInt(s));
    }

    public int getCount()
    {
        return Af;
    }

    public int getInteger(String s, int i, int j)
    {
        e(s, i);
        return Ac[j].getInt(i, Ab.getInt(s));
    }

    public long getLong(String s, int i, int j)
    {
        e(s, i);
        return Ac[j].getLong(i, Ab.getInt(s));
    }

    public Bundle getMetadata()
    {
        return Ad;
    }

    public int getStatusCode()
    {
        return yJ;
    }

    public String getString(String s, int i, int j)
    {
        e(s, i);
        return Ac[j].getString(i, Ab.getInt(s));
    }

    int getVersionCode()
    {
        return wj;
    }

    public boolean hasColumn(String s)
    {
        return Ab.containsKey(s);
    }

    public boolean hasNull(String s, int i, int j)
    {
        e(s, i);
        return Ac[j].isNull(i, Ab.getInt(s));
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

    public Uri parseUri(String s, int i, int j)
    {
        s = getString(s, i, j);
        if (s == null)
        {
            return null;
        } else
        {
            return Uri.parse(s);
        }
    }

    public void validateContents()
    {
        int k = 0;
        Ab = new Bundle();
        for (int i = 0; i < Aa.length; i++)
        {
            Ab.putInt(Aa[i], i);
        }

        Ae = new int[Ac.length];
        boolean flag = false;
        int j = k;
        k = ((flag) ? 1 : 0);
        for (; j < Ac.length; j++)
        {
            Ae[j] = k;
            int l = Ac[j].getStartPosition();
            k += Ac[j].getNumRows() - (k - l);
        }

        Af = k;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        DataHolderCreator.a(this, parcel, i);
    }

}
