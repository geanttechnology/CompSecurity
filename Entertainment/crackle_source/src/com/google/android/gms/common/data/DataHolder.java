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
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eg;
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

public class DataHolder
    implements SafeParcelable
{
    public static class Builder
    {

        private final String nK[];
        private final ArrayList nT;
        private final String nU;
        private final HashMap nV;
        private boolean nW;
        private String nX;

        private void a(HashMap hashmap)
        {
            hashmap = ((HashMap) (hashmap.get(nU)));
            if (hashmap == null)
            {
                return;
            }
            Integer integer = (Integer)nV.remove(hashmap);
            if (integer != null)
            {
                nT.remove(integer.intValue());
            }
            nV.put(hashmap, Integer.valueOf(nT.size()));
        }

        static String[] a(Builder builder1)
        {
            return builder1.nK;
        }

        static ArrayList b(Builder builder1)
        {
            return builder1.nT;
        }

        private void bx()
        {
            if (nU != null)
            {
                nV.clear();
                int j = nT.size();
                for (int i = 0; i < j; i++)
                {
                    Object obj = ((HashMap)nT.get(i)).get(nU);
                    if (obj != null)
                    {
                        nV.put(obj, Integer.valueOf(i));
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
            return nT.size();
        }

        public Builder removeRowsWithValue(String s, Object obj)
        {
            for (int i = nT.size() - 1; i >= 0; i--)
            {
                if (ee.equal(((HashMap)nT.get(i)).get(s), obj))
                {
                    nT.remove(i);
                }
            }

            return this;
        }

        public Builder sort(String s)
        {
            ds.d(s);
            if (nW && s.equals(nX))
            {
                return this;
            } else
            {
                Collections.sort(nT, new a(s));
                bx();
                nW = true;
                nX = s;
                return this;
            }
        }

        public Builder withRow(ContentValues contentvalues)
        {
            ds.d(contentvalues);
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
            ds.d(hashmap);
            if (nU != null)
            {
                a(hashmap);
            }
            nT.add(hashmap);
            nW = false;
            return this;
        }

        private Builder(String as[], String s)
        {
            nK = (String[])eg.f(as);
            nT = new ArrayList();
            nU = s;
            nV = new HashMap();
            nW = false;
            nX = null;
        }

    }

    private static final class a
        implements Comparator
    {

        private final String nY;

        public int a(HashMap hashmap, HashMap hashmap1)
        {
            hashmap = ((HashMap) (eg.f(hashmap.get(nY))));
            hashmap1 = ((HashMap) (eg.f(hashmap1.get(nY))));
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
            nY = (String)eg.f(s);
        }
    }


    public static final DataHolderCreator CREATOR = new DataHolderCreator();
    private static final Builder nS = new Builder(new String[0], null) {

        public Builder withRow(ContentValues contentvalues)
        {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        public Builder withRow(HashMap hashmap)
        {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

    };
    private final int kg;
    private final int mC;
    boolean mClosed;
    private final String nK[];
    Bundle nL;
    private final CursorWindow nM[];
    private final Bundle nN;
    int nO[];
    int nP;
    private Object nQ;
    private boolean nR;

    DataHolder(int i, String as[], CursorWindow acursorwindow[], int j, Bundle bundle)
    {
        mClosed = false;
        nR = true;
        kg = i;
        nK = as;
        nM = acursorwindow;
        mC = j;
        nN = bundle;
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
        nR = true;
        kg = 1;
        nK = (String[])eg.f(as);
        nM = (CursorWindow[])eg.f(acursorwindow);
        mC = i;
        nN = bundle;
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

    private void b(String s, int i)
    {
        if (nL == null || !nL.containsKey(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No such column: ").append(s).toString());
        }
        if (isClosed())
        {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= nP)
        {
            throw new CursorIndexOutOfBoundsException(i, nP);
        } else
        {
            return;
        }
    }

    public static Builder builder(String as[])
    {
        return new Builder(as, null);
    }

    public static Builder builder(String as[], String s)
    {
        eg.f(s);
        return new Builder(as, s);
    }

    public static DataHolder empty(int i)
    {
        return empty(i, null);
    }

    public static DataHolder empty(int i, Bundle bundle)
    {
        return new DataHolder(nS, i, bundle);
    }

    public int C(int i)
    {
        int k = 0;
        boolean flag;
        if (i >= 0 && i < nP)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.p(flag);
        do
        {
label0:
            {
                int j = k;
                if (k < nO.length)
                {
                    if (i >= nO[k])
                    {
                        break label0;
                    }
                    j = k - 1;
                }
                i = j;
                if (j == nO.length)
                {
                    i = j - 1;
                }
                return i;
            }
            k++;
        } while (true);
    }

    String[] bv()
    {
        return nK;
    }

    CursorWindow[] bw()
    {
        return nM;
    }

    public void c(Object obj)
    {
        nQ = obj;
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
        if (i >= nM.length)
        {
            break; /* Loop/switch isn't completed */
        }
        nM[i].close();
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
        b(s, i);
        nM[j].copyStringToBuffer(i, nL.getInt(s), chararraybuffer);
    }

    public int describeContents()
    {
        return 0;
    }

    protected void finalize()
        throws Throwable
    {
        if (!nR || nM.length <= 0 || isClosed()) goto _L2; else goto _L1
_L1:
        String s;
        if (nQ != null)
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
        s = nQ.toString();
          goto _L3
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public boolean getBoolean(String s, int i, int j)
    {
        b(s, i);
        return Long.valueOf(nM[j].getLong(i, nL.getInt(s))).longValue() == 1L;
    }

    public byte[] getByteArray(String s, int i, int j)
    {
        b(s, i);
        return nM[j].getBlob(i, nL.getInt(s));
    }

    public int getCount()
    {
        return nP;
    }

    public int getInteger(String s, int i, int j)
    {
        b(s, i);
        return nM[j].getInt(i, nL.getInt(s));
    }

    public long getLong(String s, int i, int j)
    {
        b(s, i);
        return nM[j].getLong(i, nL.getInt(s));
    }

    public Bundle getMetadata()
    {
        return nN;
    }

    public int getStatusCode()
    {
        return mC;
    }

    public String getString(String s, int i, int j)
    {
        b(s, i);
        return nM[j].getString(i, nL.getInt(s));
    }

    int getVersionCode()
    {
        return kg;
    }

    public boolean hasColumn(String s)
    {
        return nL.containsKey(s);
    }

    public boolean hasNull(String s, int i, int j)
    {
        b(s, i);
        return nM[j].isNull(i, nL.getInt(s));
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
        nL = new Bundle();
        for (int i = 0; i < nK.length; i++)
        {
            nL.putInt(nK[i], i);
        }

        nO = new int[nM.length];
        boolean flag = false;
        int j = k;
        k = ((flag) ? 1 : 0);
        for (; j < nM.length; j++)
        {
            nO[j] = k;
            int l = nM[j].getStartPosition();
            k += nM[j].getNumRows() - (k - l);
        }

        nP = k;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        DataHolderCreator.a(this, parcel, i);
    }

}
