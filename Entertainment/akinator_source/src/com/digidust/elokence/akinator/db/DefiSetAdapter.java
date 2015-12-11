// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkLog;
import com.elokence.limuleapi.SessionFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DefiSetAdapter
{
    public static class DefiInfos
    {

        protected int mIdDefi;
        protected List mListePersos;
        protected String mTitre;

        public int getIdDefi()
        {
            return mIdDefi;
        }

        public List getListPerso()
        {
            return mListePersos;
        }

        public String getTitle()
        {
            return mTitre;
        }

        public DefiInfos()
        {
        }
    }

    public static interface Listener
    {

        public abstract void onDefiDuJourModified();
    }

    public static class Perso
    {

        protected int mBaseId;
        protected String mDescription;
        protected String mName;
        protected String mPhotoBase64;
        protected float mPourcentage;
        protected boolean misFound;

        public int getBaseId()
        {
            return mBaseId;
        }

        public String getDescription()
        {
            return mDescription;
        }

        public String getName()
        {
            return mName;
        }

        public String getPhotoBase64()
        {
            return mPhotoBase64;
        }

        public float getPourcentage()
        {
            return mPourcentage;
        }

        public boolean isFound()
        {
            return misFound;
        }

        public Perso(int i, String s, String s1, String s2, float f, boolean flag)
        {
            mBaseId = i;
            mName = s;
            mDescription = s1;
            mPhotoBase64 = s2;
            mPourcentage = f;
            misFound = flag;
        }
    }


    public static final String DATABASE_NAME = "defis.db";
    private static final int DATABASE_VERSION = 4;
    private static final String DEFI_BASE_LOGIQUE_ID = "baselogiqueid";
    private static final String DEFI_COURANT_TABLE = "defiCourantTable";
    private static final String DEFI_ID = "idDefi";
    private static final String DEFI_PRECEDANT_TABLE = "defiPrecedantTable";
    private static final String DEFI_TITRE = "titre";
    private static final String Lock = "sqliteLock";
    private static final String PERSOS_COURANT_TABLE = "persosCourantTable";
    private static final String PERSOS_PRECEDANT_TABLE = "persosPrecedantTable";
    private static final String PERSO_BASE_ID = "baseId";
    private static final String PERSO_BASE_LOGIQUE_ID = "baselogiqueid";
    private static final String PERSO_DEFI_ID = "idDefi";
    private static final String PERSO_DESCRIPTION = "description";
    private static final String PERSO_NOM = "nom";
    private static final String PERSO_PHOTO_BASE64 = "photoBase64";
    private static final String PERSO_POURCENTAGE = "pourcentage";
    private static final String PERSO_TROUVE = "trouve";
    private static final String TAG = "DefiSetAdapter";
    private static DefiSetAdapter instance = null;
    private static SQLiteDatabase mDB;
    private static DefiDBOpenHelper mDBHelper;
    private HashSet listeners;

    public DefiSetAdapter()
    {
        listeners = new HashSet();
    }

    public static DefiSetAdapter sharedInstance()
    {
        if (instance == null)
        {
            instance = new DefiSetAdapter();
    /* block-local class not found */
    class DefiDBOpenHelper {}

            mDBHelper = new DefiDBOpenHelper(AkApplication.getAppContext(), "defis.db", null, 4);
            instance.open();
        }
        return instance;
    }

    private void signalDefiDuJourModified()
    {
        HashSet hashset = listeners;
        hashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((Listener)iterator.next()).onDefiDuJourModified()) { }
        break MISSING_BLOCK_LABEL_46;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
    }

    public void addListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.add(listener);
        }
        return;
        listener;
        hashset;
        JVM INSTR monitorexit ;
        throw listener;
    }

    public void close()
    {
        "sqliteLock";
        JVM INSTR monitorenter ;
        mDB.close();
        "sqliteLock";
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void deleteAll()
    {
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        mDB.delete("defiPrecedantTable", null, null);
        mDB.delete("persosPrecedantTable", null, null);
        mDB.delete("defiCourantTable", null, null);
        mDB.delete("persosCourantTable", null, null);
        "sqliteLock";
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw exception;
    }

    public DefiInfos getDefiDuJourInfos()
    {
        return getDefiInfos(true);
    }

    public DefiInfos getDefiInfos(boolean flag)
    {
        Object obj3;
        obj3 = new DefiInfos();
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        Object obj2;
        List list;
        String s;
        String s1;
        s1 = null;
        obj = null;
        s = null;
        list = null;
        obj2 = obj;
        obj1 = s1;
        String as[] = new String[1];
        obj2 = obj;
        obj1 = s1;
        as[0] = String.valueOf(SessionFactory.sharedInstance().getBaseLogiqueId());
        if (!flag) goto _L2; else goto _L1
_L1:
        obj2 = obj;
        obj1 = s1;
        obj = mDB.query("defiCourantTable", null, "baselogiqueid =?", as, null, null, null);
_L16:
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj2 = obj;
        obj1 = obj;
        if (((Cursor) (obj)).getCount() != 1) goto _L4; else goto _L5
_L5:
        obj2 = obj;
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst()) goto _L4; else goto _L6
_L6:
        obj2 = obj;
        obj1 = obj;
        obj3.mIdDefi = ((Cursor) (obj)).getInt(0);
        obj2 = obj;
        obj1 = obj;
        obj3.mTitre = ((Cursor) (obj)).getString(2);
        obj2 = obj3;
_L17:
        obj1 = obj2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        ((Cursor) (obj)).close();
        obj1 = obj2;
_L19:
        obj3 = obj1;
        if (obj1 == null) goto _L8; else goto _L7
_L7:
        obj2 = list;
        obj3 = s;
        obj1.mListePersos = new ArrayList();
        obj2 = list;
        obj3 = s;
        obj = new String[1];
        obj2 = list;
        obj3 = s;
        obj[0] = String.valueOf(SessionFactory.sharedInstance().getBaseLogiqueId());
        if (!flag) goto _L10; else goto _L9
_L9:
        obj2 = list;
        obj3 = s;
        obj = mDB.query("persosCourantTable", null, "baselogiqueid =?", ((String []) (obj)), null, null, null);
_L20:
        if (obj == null) goto _L12; else goto _L11
_L11:
        obj2 = obj;
        obj3 = obj;
        if (((Cursor) (obj)).getCount() <= 0) goto _L12; else goto _L13
_L13:
        obj2 = obj;
        obj3 = obj;
        if (!((Cursor) (obj)).moveToFirst()) goto _L12; else goto _L14
_L14:
        obj2 = obj;
        obj3 = obj;
        if (((Cursor) (obj)).isAfterLast())
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj;
        obj3 = obj;
        list = ((DefiInfos) (obj1)).mListePersos;
        obj2 = obj;
        obj3 = obj;
        int i = ((Cursor) (obj)).getInt(0);
        obj2 = obj;
        obj3 = obj;
        s = ((Cursor) (obj)).getString(1);
        obj2 = obj;
        obj3 = obj;
        s1 = ((Cursor) (obj)).getString(2);
        obj2 = obj;
        obj3 = obj;
        as = ((Cursor) (obj)).getString(3);
        obj2 = obj;
        obj3 = obj;
        float f = ((Cursor) (obj)).getFloat(4);
        obj2 = obj;
        obj3 = obj;
        if (((Cursor) (obj)).getInt(5) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj2 = obj;
        obj3 = obj;
        list.add(new Perso(i, s, s1, as, f, flag));
        obj2 = obj;
        obj3 = obj;
        ((Cursor) (obj)).moveToNext();
        if (true) goto _L14; else goto _L12
        obj;
        obj3 = obj2;
        ((Exception) (obj)).printStackTrace();
        obj = null;
        obj3 = obj;
        if (obj2 == null) goto _L8; else goto _L15
_L15:
        ((Cursor) (obj2)).close();
        obj3 = obj;
_L8:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return ((DefiInfos) (obj3));
_L2:
        obj2 = obj;
        obj1 = s1;
        obj = mDB.query("defiPrecedantTable", null, "baselogiqueid =?", as, null, null, null);
          goto _L16
_L4:
        obj2 = null;
          goto _L17
        obj;
        obj1 = obj2;
        ((Exception) (obj)).printStackTrace();
        obj = null;
        obj1 = obj;
        if (obj2 == null) goto _L19; else goto _L18
_L18:
        ((Cursor) (obj2)).close();
        obj1 = obj;
          goto _L19
        obj;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_599;
        }
        ((Cursor) (obj1)).close();
        throw obj;
_L10:
        obj2 = list;
        obj3 = s;
        obj = mDB.query("persosPrecedantTable", null, "baselogiqueid =?", ((String []) (obj)), null, null, null);
          goto _L20
_L12:
        obj3 = obj1;
        if (obj == null) goto _L8; else goto _L21
_L21:
        ((Cursor) (obj)).close();
        obj3 = obj1;
          goto _L8
        Exception exception;
        exception;
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_667;
        }
        ((Cursor) (obj3)).close();
        throw exception;
          goto _L16
    }

    public String getPhotobase64(int i)
    {
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Object obj;
        Cursor cursor;
        Cursor cursor1;
        String s;
        s = null;
        cursor1 = null;
        cursor = cursor1;
        obj = s;
        int j = SessionFactory.sharedInstance().getBaseLogiqueId();
        cursor = cursor1;
        obj = s;
        cursor1 = mDB.query("persosCourantTable", null, "baseId =? AND baselogiqueid =?", new String[] {
            String.valueOf(i), String.valueOf(j)
        }, null, null, null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        cursor = cursor1;
        obj = cursor1;
        if (cursor1.getCount() != 1)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        cursor = cursor1;
        obj = cursor1;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_177;
        }
        cursor = cursor1;
        obj = cursor1;
        AkLog.d("DefiSetAdapter", (new StringBuilder()).append("get photo").append(i).toString());
        cursor = cursor1;
        obj = cursor1;
        s = cursor1.getString(3);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        cursor1.close();
        "sqliteLock";
        JVM INSTR monitorexit ;
        return s;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        cursor1.close();
_L2:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return null;
        Exception exception1;
        exception1;
        obj = cursor;
        exception1.printStackTrace();
        if (cursor == null) goto _L2; else goto _L1
_L1:
        cursor.close();
          goto _L2
        obj;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception;
        exception;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        ((Cursor) (obj)).close();
        throw exception;
    }

    public boolean isDefiPersoExist(int i)
    {
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Object obj;
        Cursor cursor;
        Cursor cursor1;
        Object obj1;
        obj1 = null;
        cursor1 = null;
        cursor = cursor1;
        obj = obj1;
        int j = SessionFactory.sharedInstance().getBaseLogiqueId();
        cursor = cursor1;
        obj = obj1;
        cursor1 = mDB.query("persosCourantTable", null, "baseId =? AND baselogiqueid =?", new String[] {
            String.valueOf(i), String.valueOf(j)
        }, null, null, null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        cursor = cursor1;
        obj = cursor1;
        if (cursor1.getCount() != 1)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        cursor = cursor1;
        obj = cursor1;
        AkLog.d("DefiSetAdapter", (new StringBuilder()).append("perso exists in DB : ").append(i).toString());
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        cursor1.close();
        "sqliteLock";
        JVM INSTR monitorexit ;
        return true;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        cursor1.close();
_L2:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return false;
        Exception exception1;
        exception1;
        obj = cursor;
        exception1.printStackTrace();
        if (cursor == null) goto _L2; else goto _L1
_L1:
        cursor.close();
          goto _L2
        obj;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception;
        exception;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        ((Cursor) (obj)).close();
        throw exception;
    }

    public boolean isOpen()
    {
        return mDB != null && mDB.isOpen();
    }

    public boolean isPersoAlreadyFound(int i)
    {
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Object obj;
        Cursor cursor;
        Cursor cursor1;
        Object obj1;
        obj1 = null;
        cursor1 = null;
        cursor = cursor1;
        obj = obj1;
        int j = SessionFactory.sharedInstance().getBaseLogiqueId();
        cursor = cursor1;
        obj = obj1;
        cursor1 = mDB.query("persosCourantTable", null, "baseId =? AND trouve =? AND baselogiqueid =?", new String[] {
            String.valueOf(i), "1", String.valueOf(j)
        }, null, null, null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        cursor = cursor1;
        obj = cursor1;
        if (cursor1.getCount() != 1)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        cursor = cursor1;
        obj = cursor1;
        AkLog.d("DefiSetAdapter", (new StringBuilder()).append("perso  deja trouv\351").append(i).toString());
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        cursor1.close();
        "sqliteLock";
        JVM INSTR monitorexit ;
        return true;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        cursor1.close();
_L2:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return false;
        Exception exception1;
        exception1;
        obj = cursor;
        exception1.printStackTrace();
        if (cursor == null) goto _L2; else goto _L1
_L1:
        cursor.close();
          goto _L2
        obj;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception;
        exception;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        ((Cursor) (obj)).close();
        throw exception;
    }

    public void open()
        throws SQLiteException
    {
        if (mDB == null || !mDB.isOpen())
        {
            mDB = mDBHelper.getWritableDatabase();
        }
    }

    public void removeListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.remove(listener);
        }
        return;
        listener;
        hashset;
        JVM INSTR monitorexit ;
        throw listener;
    }

    public void setPersoAlreadyFound(int i)
    {
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("trouve", "1");
        int j = SessionFactory.sharedInstance().getBaseLogiqueId();
        mDB.update("persosCourantTable", contentvalues, "baseId =? AND baselogiqueid =?", new String[] {
            String.valueOf(i), String.valueOf(j)
        });
        AkLog.d("DefiSetAdapter", (new StringBuilder()).append("update status of perso ").append(i).toString());
        "sqliteLock";
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void updateDefiCourant(String s, int i, List list)
    {
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        updateDefiPrecedant();
        String as[] = new String[1];
        as[0] = String.valueOf(SessionFactory.sharedInstance().getBaseLogiqueId());
        int j = mDB.delete("defiCourantTable", "baselogiqueid =?", as);
        AkLog.d("DefiSetAdapter", (new StringBuilder()).append("delete defi courant :").append(j).toString());
        j = mDB.delete("persosCourantTable", "baselogiqueid =?", as);
        AkLog.d("DefiSetAdapter", (new StringBuilder()).append("delete perso courant : ").append(j).toString());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_411;
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("titre", s);
        contentvalues.put("idDefi", Integer.valueOf(i));
        contentvalues.put("baselogiqueid", Integer.valueOf(SessionFactory.sharedInstance().getBaseLogiqueId()));
        long l = mDB.insert("defiCourantTable", null, contentvalues);
        AkLog.d("DefiSetAdapter", (new StringBuilder()).append("insert row ").append(l).append(" defi : ").append(contentvalues).toString());
        ContentValues contentvalues1;
        long l1;
        for (s = list.iterator(); s.hasNext(); AkLog.d("DefiSetAdapter", (new StringBuilder()).append("insert row ").append(l1).append(" perso : ").append(contentvalues1).toString()))
        {
            list = (Perso)s.next();
            contentvalues1 = new ContentValues();
            contentvalues1.put("baseId", Integer.valueOf(((Perso) (list)).mBaseId));
            contentvalues1.put("nom", ((Perso) (list)).mName);
            contentvalues1.put("description", ((Perso) (list)).mDescription);
            contentvalues1.put("photoBase64", ((Perso) (list)).mPhotoBase64);
            contentvalues1.put("pourcentage", Float.valueOf(((Perso) (list)).mPourcentage));
            contentvalues1.put("trouve", Boolean.valueOf(((Perso) (list)).misFound));
            contentvalues1.put("idDefi", Integer.valueOf(i));
            contentvalues1.put("baselogiqueid", Integer.valueOf(SessionFactory.sharedInstance().getBaseLogiqueId()));
            l1 = mDB.insert("persosCourantTable", null, contentvalues1);
        }

        break MISSING_BLOCK_LABEL_411;
        s;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw s;
        "sqliteLock";
        JVM INSTR monitorexit ;
        signalDefiDuJourModified();
        return;
    }

    public void updateDefiPrecedant()
    {
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Object obj;
        Cursor cursor;
        Cursor cursor1;
        String as[];
        as = null;
        cursor1 = null;
        cursor = cursor1;
        obj = as;
        int i = SessionFactory.sharedInstance().getBaseLogiqueId();
        cursor = cursor1;
        obj = as;
        cursor1 = mDB.query("defiCourantTable", null, "baselogiqueid =?", new String[] {
            String.valueOf(i)
        }, null, null, null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        cursor = cursor1;
        obj = cursor1;
        if (cursor1.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        cursor = cursor1;
        obj = cursor1;
        as = new String[1];
        cursor = cursor1;
        obj = cursor1;
        as[0] = String.valueOf(SessionFactory.sharedInstance().getBaseLogiqueId());
        cursor = cursor1;
        obj = cursor1;
        mDB.delete("defiPrecedantTable", "baselogiqueid =?", as);
        cursor = cursor1;
        obj = cursor1;
        mDB.delete("persosPrecedantTable", "baselogiqueid =?", as);
        cursor = cursor1;
        obj = cursor1;
        mDB.execSQL((new StringBuilder()).append("INSERT INTO defiPrecedantTable SELECT * FROM defiCourantTable WHERE baselogiqueid=").append(SessionFactory.sharedInstance().getBaseLogiqueId()).append(";").toString());
        cursor = cursor1;
        obj = cursor1;
        mDB.execSQL((new StringBuilder()).append("INSERT INTO persosPrecedantTable SELECT * FROM persosCourantTable WHERE baselogiqueid=").append(SessionFactory.sharedInstance().getBaseLogiqueId()).append(";").toString());
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        cursor1.close();
_L2:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        obj = cursor;
        exception1.printStackTrace();
        if (cursor == null) goto _L2; else goto _L1
_L1:
        cursor.close();
          goto _L2
        obj;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception;
        exception;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        ((Cursor) (obj)).close();
        throw exception;
    }

}
