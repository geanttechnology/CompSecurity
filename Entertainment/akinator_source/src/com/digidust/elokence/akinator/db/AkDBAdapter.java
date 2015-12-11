// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import com.digidust.elokence.akinator.backup.AkBackupManager;
import com.digidust.elokence.akinator.factories.AkLog;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

public class AkDBAdapter
{
    private static class AkDBOpenHelper extends SQLiteOpenHelper
    {

        private static final String CHARACTER_ALREADY_PLAYED_TABLE_CREATE = "create table if not exists characters_already_played( language char(3), id integer(11), award integer(2), name varchar(100), desc varchar(255), baselogiqueid integer(10));";
        private static final String CHARACTER_ALREADY_PLAYED_TABLE_DROP = "DROP table if exists characters_already_played";
        private static final String CHARACTER_ALREADY_PLAYED_TABLE_UPDATE_BASE_LOGIQUE = "ALTER TABLE characters_already_played ADD baselogiqueid integer(10);";
        private static final String CHARACTER_TABLE_CREATE = "create table if not exists character ( id_base integer(11) not null, name text not null, originalName text ,url_photo text not null, original_url_photo text, code_lang text not null);";
        private static final String CHARACTER_TABLE_DROP = "DROP TABLE IF EXISTS character";
        private static final String LANGUAGE_TABLE_DROP = "DROP TABLE IF EXISTS language";
        private static final String MB_CHARACTER_TABLE_DROP = "DROP TABLE IF EXISTS mbcharac";
        private static final String TRADUCTION_TABLE_DROP = "DROP TABLE IF EXISTS traduction";

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL("create table if not exists character ( id_base integer(11) not null, name text not null, originalName text ,url_photo text not null, original_url_photo text, code_lang text not null);");
            sqlitedatabase.execSQL("create table if not exists characters_already_played( language char(3), id integer(11), award integer(2), name varchar(100), desc varchar(255), baselogiqueid integer(10));");
        }

        public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS character");
            sqlitedatabase.execSQL("DROP table if exists characters_already_played");
            onCreate(sqlitedatabase);
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            if (i <= 6)
            {
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS traduction");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS language");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS mbcharac");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS character");
            }
            if (i <= 6 && j >= 7)
            {
                sqlitedatabase.execSQL("create table if not exists character ( id_base integer(11) not null, name text not null, originalName text ,url_photo text not null, original_url_photo text, code_lang text not null);");
                sqlitedatabase.execSQL("ALTER TABLE characters_already_played ADD baselogiqueid integer(10);");
            }
        }

        public AkDBOpenHelper(Context context, String s, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, int i)
        {
            super(context, s, cursorfactory, i);
        }
    }


    private static final String CHARACTERS_ALREADY_PLAYED_AWARD = "award";
    private static final String CHARACTERS_ALREADY_PLAYED_BASE_LOGIQUE_ID = "baselogiqueid";
    private static final String CHARACTERS_ALREADY_PLAYED_DESC = "desc";
    private static final String CHARACTERS_ALREADY_PLAYED_ID = "id";
    private static final String CHARACTERS_ALREADY_PLAYED_LANG = "language";
    private static final String CHARACTERS_ALREADY_PLAYED_NAME = "name";
    private static final String CHARACTERS_ALREADY_PLAYED_TABLE = "characters_already_played";
    private static final String CHARACTER_COLUMN_CODE_LANGUE = "code_lang";
    private static final String CHARACTER_COLUMN_ID_BASE = "id_base";
    private static final String CHARACTER_COLUMN_NAME = "name";
    private static final String CHARACTER_COLUMN_ORIGINAL_NAME = "originalName";
    private static final String CHARACTER_COLUMN_ORIGINAL_URL_PHOTO = "original_url_photo";
    private static final String CHARACTER_COLUMN_URL_PHOTO = "url_photo";
    private static final String CHARACTER_TABLE = "character";
    public static final String DATABASE_NAME = "akinator.db";
    private static final int DATABASE_VERSION = 7;
    private static final String LANGUAGE_TABLE = "language";
    public static final String Lock = "sqliteLock";
    private static final String MB_CHARACTER_TABLE = "mbcharac";
    private static final String TRADUCTION_TABLE = "traduction";
    private static Context applicationContext;
    private static SQLiteDatabase mDB;
    private static AkDBOpenHelper mDBHelper;
    private final Context mActivity;

    public AkDBAdapter(Context context)
    {
        mActivity = context;
        if (mDBHelper == null)
        {
            applicationContext = mActivity.getApplicationContext();
            mDBHelper = new AkDBOpenHelper(applicationContext, "akinator.db", null, 7);
        }
        open();
    }

    private static String controle(com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase)
    {
        return md5((new StringBuilder()).append("j85S").append(proposedlimuleobjectminibase.getIdSession()).append("pL-9").append(proposedlimuleobjectminibase.getName()).append("ne9/").toString());
    }

    public static String md5(String s)
    {
        Object obj;
        int i;
        try
        {
            obj = MessageDigest.getInstance("MD5");
            ((MessageDigest) (obj)).update(s.getBytes());
            s = ((MessageDigest) (obj)).digest();
            obj = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        i = 0;
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuffer) (obj)).append(Integer.toHexString(s[i] & 0xff));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_29;
_L1:
        s = ((StringBuffer) (obj)).toString();
        return s;
    }

    public void addCharacter(String s, int i, int j, String s1, String s2)
    {
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        contentvalues.put("language", s);
        contentvalues.put("id", Integer.valueOf(i));
        contentvalues.put("award", Integer.valueOf(j));
        contentvalues.put("name", s1);
        contentvalues.put("desc", s2);
        contentvalues.put("baselogiqueid", Integer.valueOf(SessionFactory.sharedInstance().getBaseLogiqueId()));
        "sqliteLock";
        JVM INSTR monitorenter ;
        AkLog.d("AkinatorBase", (new StringBuilder()).append("Insert character already played : ").append(i).toString());
        mDB.insert("characters_already_played", null, contentvalues);
        AkBackupManager.getInstance().setCanSave(true);
        "sqliteLock";
        JVM INSTR monitorexit ;
        return;
        s;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw s;
    }

    public void close()
    {
        mDB.close();
    }

    public void eraseCharacterFromDB(com.elokence.limuleapi.Session.ProposedLimuleObject proposedlimuleobject)
    {
        "sqliteLock";
        JVM INSTR monitorenter ;
        if (!isOpen())
        {
            open();
        }
        int i = proposedlimuleobject.getIdBase();
        mDB.delete("character", "id_base = ?", new String[] {
            String.valueOf(i)
        });
        AkBackupManager.getInstance().setCanSave(true);
        "sqliteLock";
        JVM INSTR monitorexit ;
        return;
        proposedlimuleobject;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw proposedlimuleobject;
    }

    public String getAllBaseIdAndBaseLogiqueId()
    {
        Cursor cursor;
        Object obj;
        String s1;
        obj = null;
        cursor = null;
        s1 = "";
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        String s = s1;
        Cursor cursor1 = mDB.query("characters_already_played", new String[] {
            "language", "id", "baselogiqueid"
        }, null, null, null, null, null);
        String s2 = s1;
        if (cursor1 == null) goto _L2; else goto _L1
_L1:
        s2 = s1;
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (cursor1.getCount() < 1) goto _L2; else goto _L3
_L3:
        s2 = s1;
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!cursor1.moveToFirst()) goto _L2; else goto _L4
_L4:
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        s2 = cursor1.getString(0);
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        int k = cursor1.getInt(1);
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        int i = cursor1.getInt(2);
        int j = i;
        if (i != 0) goto _L6; else goto _L5
_L5:
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("en")) goto _L8; else goto _L7
_L7:
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!SessionFactory.sharedInstance().getLanguage().equals("en")) goto _L8; else goto _L9
_L9:
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        i = SessionFactory.sharedInstance().getBaseLogiqueId();
_L13:
        j = i;
        if (i == 0) goto _L6; else goto _L10
_L10:
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        ContentValues contentvalues = new ContentValues();
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        contentvalues.put("baselogiqueid", Integer.valueOf(i));
        j = i;
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (mDB.update("characters_already_played", contentvalues, "id =? AND language =?", new String[] {
            String.valueOf(k), s2
        }) > 0) goto _L6; else goto _L11
_L11:
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        AkLog.e("AkinatorBase", (new StringBuilder()).append("problem update ").append(k).append(" ").append(s2).toString());
        j = i;
_L6:
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        s2 = (new StringBuilder()).append(s1).append(k).append("-").append(j).append(",").toString();
        cursor = cursor1;
        s = s2;
        obj = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s2;
        cursor = cursor1;
        s = s2;
        obj = cursor1;
        if (!cursor1.isAfterLast()) goto _L4; else goto _L12
_L12:
        cursor = cursor1;
        s = s2;
        obj = cursor1;
        s2 = s2.substring(0, s2.length() - 1);
_L2:
        obj = s2;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_518;
        }
        cursor1.close();
        obj = s2;
_L15:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L8:
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("cn"))
        {
            break MISSING_BLOCK_LABEL_550;
        }
        i = 11;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("fr"))
        {
            break MISSING_BLOCK_LABEL_576;
        }
        i = 1;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("de"))
        {
            break MISSING_BLOCK_LABEL_602;
        }
        i = 5;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("es"))
        {
            break MISSING_BLOCK_LABEL_628;
        }
        i = 3;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("pt"))
        {
            break MISSING_BLOCK_LABEL_654;
        }
        i = 4;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("pl"))
        {
            break MISSING_BLOCK_LABEL_681;
        }
        i = 26;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("ru"))
        {
            break MISSING_BLOCK_LABEL_708;
        }
        i = 6;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("tr"))
        {
            break MISSING_BLOCK_LABEL_735;
        }
        i = 8;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("nl"))
        {
            break MISSING_BLOCK_LABEL_762;
        }
        i = 9;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("il"))
        {
            break MISSING_BLOCK_LABEL_789;
        }
        i = 13;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("it"))
        {
            break MISSING_BLOCK_LABEL_816;
        }
        i = 7;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("kr"))
        {
            break MISSING_BLOCK_LABEL_843;
        }
        i = 10;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        if (!s2.equals("ar"))
        {
            break MISSING_BLOCK_LABEL_870;
        }
        i = 12;
          goto _L13
        cursor = cursor1;
        s = s1;
        obj = cursor1;
        boolean flag = s2.equals("jp");
        if (flag)
        {
            i = 16;
        }
          goto _L13
        Exception exception1;
        exception1;
        obj = cursor;
        exception1.printStackTrace();
        obj = s;
        if (cursor == null) goto _L15; else goto _L14
_L14:
        cursor.close();
        obj = s;
          goto _L15
        Exception exception;
        exception;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_944;
        }
        ((Cursor) (obj)).close();
        throw exception;
          goto _L13
    }

    public List getCharactersPlayedForAwardLevel(int i)
    {
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        obj3 = null;
        obj4 = null;
        obj2 = null;
        obj1 = null;
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Object obj = mDB.query("characters_already_played", new String[] {
            "name", "desc"
        }, "award = ?;", new String[] {
            String.valueOf(i)
        }, null, null, null);
        LinkedList linkedlist;
        linkedlist = obj4;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        linkedlist = obj4;
        obj1 = obj;
        obj2 = obj;
        if (((Cursor) (obj)).getCount() < 1)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        linkedlist = obj4;
        obj1 = obj;
        obj2 = obj;
        if (!((Cursor) (obj)).moveToLast())
        {
            break MISSING_BLOCK_LABEL_175;
        }
        obj1 = obj;
        obj2 = obj;
        linkedlist = new LinkedList();
        boolean flag;
        do
        {
            linkedlist.add(new Pair(((Cursor) (obj)).getString(0), ((Cursor) (obj)).getString(1)));
            if (!((Cursor) (obj)).moveToPrevious())
            {
                break;
            }
            flag = ((Cursor) (obj)).isBeforeFirst();
        } while (!flag);
        obj1 = linkedlist;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        ((Cursor) (obj)).close();
        obj1 = linkedlist;
_L2:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return ((List) (obj1));
_L5:
        obj1 = obj;
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        ((Cursor) (obj2)).close();
        obj1 = obj;
          goto _L2
        obj;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception2;
        exception2;
        obj = obj1;
        obj1 = exception2;
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        ((Cursor) (obj)).close();
        throw obj1;
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception1;
        exception1;
        exception2 = ((Exception) (obj));
        obj = linkedlist;
          goto _L5
        Exception exception;
        exception;
        exception = obj3;
          goto _L5
    }

    public boolean getCustomNameAndUrlFromDB(com.elokence.limuleapi.Session.ProposedLimuleObject proposedlimuleobject, StringBuffer stringbuffer, StringBuffer stringbuffer1)
    {
        "sqliteLock";
        JVM INSTR monitorenter ;
        if (!isOpen())
        {
            open();
        }
        AkLog.d("Akinator", (new StringBuilder()).append("Recherche du personnage ").append(proposedlimuleobject.getIdBase()).append(" ").append(proposedlimuleobject.getName()).append(" dans la DB").toString());
        Cursor cursor = null;
        Object obj;
        int i;
        i = proposedlimuleobject.getIdBase();
        obj = TraductionFactory.sharedInstance().getApplicationLanguage();
        obj = mDB.query(true, "character", new String[] {
            "id_base", "name", "originalName", "url_photo", "original_url_photo", "code_lang"
        }, "id_base = ? AND code_lang = ?", new String[] {
            String.valueOf(i), obj
        }, "id_base", null, null, "1");
        cursor = ((Cursor) (obj));
        if (((Cursor) (obj)).getCount() != 1)
        {
            break MISSING_BLOCK_LABEL_441;
        }
        cursor = ((Cursor) (obj));
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_441;
        }
        cursor = ((Cursor) (obj));
        AkLog.w("Akinator", (new StringBuilder()).append("Id trouv\uFFFD : ").append(((Cursor) (obj)).getString(0)).toString());
        cursor = ((Cursor) (obj));
        if (((Cursor) (obj)).getString(1) == null)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        cursor = ((Cursor) (obj));
        if (((Cursor) (obj)).getString(1).equals(""))
        {
            break MISSING_BLOCK_LABEL_269;
        }
        cursor = ((Cursor) (obj));
        proposedlimuleobject.setName(((Cursor) (obj)).getString(1));
        cursor = ((Cursor) (obj));
        if (((Cursor) (obj)).getString(2) == null)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        cursor = ((Cursor) (obj));
        if (((Cursor) (obj)).getString(2).equals(""))
        {
            break MISSING_BLOCK_LABEL_321;
        }
        cursor = ((Cursor) (obj));
        stringbuffer.append(((Cursor) (obj)).getString(2));
        cursor = ((Cursor) (obj));
        if (((Cursor) (obj)).getString(3) == null)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        cursor = ((Cursor) (obj));
        if (((Cursor) (obj)).getString(3).equals(""))
        {
            break MISSING_BLOCK_LABEL_372;
        }
        cursor = ((Cursor) (obj));
        proposedlimuleobject.setPicturePath(((Cursor) (obj)).getString(3));
        cursor = ((Cursor) (obj));
        if (((Cursor) (obj)).getString(4) == null)
        {
            break MISSING_BLOCK_LABEL_424;
        }
        cursor = ((Cursor) (obj));
        if (((Cursor) (obj)).getString(4).equals(""))
        {
            break MISSING_BLOCK_LABEL_424;
        }
        cursor = ((Cursor) (obj));
        stringbuffer1.append(((Cursor) (obj)).getString(4));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_436;
        }
        ((Cursor) (obj)).close();
        "sqliteLock";
        JVM INSTR monitorexit ;
        return true;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_453;
        }
        ((Cursor) (obj)).close();
        "sqliteLock";
        JVM INSTR monitorexit ;
        return false;
        proposedlimuleobject;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw proposedlimuleobject;
        proposedlimuleobject;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_477;
        }
        cursor.close();
        throw proposedlimuleobject;
    }

    public int getNbCharactersPlayedForAwardLevel(int i)
    {
        try
        {
            i = getCharactersPlayedForAwardLevel(i).size();
        }
        catch (Exception exception)
        {
            return 0;
        }
        return i;
    }

    public boolean isAwardAlreadyWonForCharacter(String s, int i)
    {
        "sqliteLock";
        JVM INSTR monitorenter ;
        s = mDB.query("characters_already_played", null, "language = ? AND id = ?", new String[] {
            s, String.valueOf(i)
        }, null, null, null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (s.getCount() < 1)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        "sqliteLock";
        JVM INSTR monitorexit ;
        return true;
        "sqliteLock";
        JVM INSTR monitorexit ;
        return false;
        s;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean isOpen()
    {
        return mDB != null && mDB.isOpen();
    }

    public void open()
        throws SQLiteException
    {
        if (mDB == null || !mDB.isOpen())
        {
            mDB = mDBHelper.getWritableDatabase();
        }
    }

    public void updateCharacterToDB(com.elokence.limuleapi.Session.ProposedLimuleObject proposedlimuleobject, String s, String s1)
    {
        "sqliteLock";
        JVM INSTR monitorenter ;
        ContentValues contentvalues;
        if (!isOpen())
        {
            open();
        }
        contentvalues = new ContentValues();
        contentvalues.put("id_base", Integer.valueOf(proposedlimuleobject.getIdBase()));
        contentvalues.put("name", s);
        contentvalues.put("originalName", proposedlimuleobject.getName());
        contentvalues.put("url_photo", s1);
        contentvalues.put("original_url_photo", proposedlimuleobject.getPicturePath());
        contentvalues.put("code_lang", TraductionFactory.sharedInstance().getApplicationLanguage());
        s1 = null;
        s = s1;
        SQLiteDatabase sqlitedatabase = mDB;
        s = s1;
        proposedlimuleobject = (new StringBuilder()).append("id_base=").append(proposedlimuleobject.getIdBase()).toString();
        s = s1;
        proposedlimuleobject = sqlitedatabase.query(true, "character", new String[] {
            "id_base", "name", "originalName", "url_photo", "original_url_photo", "code_lang"
        }, null, null, "id_base", proposedlimuleobject, null, "1");
        s = proposedlimuleobject;
        if (proposedlimuleobject.getCount() != 1) goto _L2; else goto _L1
_L1:
        s = proposedlimuleobject;
        if (!proposedlimuleobject.moveToFirst()) goto _L2; else goto _L3
_L3:
        s = proposedlimuleobject;
        mDB.update("character", contentvalues, null, null);
_L5:
        if (proposedlimuleobject == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        proposedlimuleobject.close();
        AkBackupManager.getInstance().setCanSave(true);
        "sqliteLock";
        JVM INSTR monitorexit ;
        return;
_L2:
        s = proposedlimuleobject;
        mDB.insert("character", null, contentvalues);
        if (true) goto _L5; else goto _L4
_L4:
        proposedlimuleobject;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        s.close();
        AkBackupManager.getInstance().setCanSave(true);
        throw proposedlimuleobject;
        proposedlimuleobject;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw proposedlimuleobject;
    }
}
