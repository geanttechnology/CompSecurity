// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MetricsSetAdapter
{

    public static final String ACTIVE_BACKGROUND = "active_background";
    public static final String ACTIVE_CLOTH = "active_cloth";
    public static final String ACTIVE_HAT = "active_hat";
    public static final String ADDED_CHARACTERS = "added_characters";
    public static final String ADDED_PHOTO = "added_photo";
    public static final String ADDED_QUESTIONS = "added_questions";
    public static final String AGE = "age";
    public static final String BADGES_BLACK = "badges_black";
    public static final String BADGES_BRONZE = "badges_bronze";
    public static final String BADGES_GOLD = "badges_gold";
    public static final String BADGES_PLATINUM = "badges_platinum";
    public static final String BADGES_QUEST = "badges_quest";
    public static final String BADGES_SILVER = "badges_silver";
    public static final String BADGES_STANDARD = "badges_standard";
    public static final String BTN_LAST_ENIGME_PLAYED = "btn_last_enigme_played";
    public static final String CHILD_FILTER_ACTIVATED = "child_filter_activated";
    public static final String CHILD_FILTER_USED = "child_filter_used";
    private static final String COMPTEURS_TABLE = "compteurs";
    private static final String COMPTEURS_TABLE_KEY = "cle";
    private static final String COMPTEURS_TABLE_VALUE = "valeur";
    public static final String DATABASE_NAME = "metrics.db";
    private static final int DATABASE_VERSION = 1;
    public static final String DATE_ACHAT_POTION_SUPERCHARGED = "date_achat_potion_supercharged";
    public static final String DATE_ACHAT_POTION_ULTIME = "date_achat_potion_ultime";
    public static final String DATE_ACHAT_RADIANT_POTION = "date_achat_radiant_potion";
    public static final String DELAI_QUESTION = "delai_question";
    public static final String DELAI_SESSION = "delai_session";
    public static final String DELAI_SESSION_1 = "delai_session_1";
    public static final String ENIGMES_COMPLETES = "enigmes_completes";
    public static final String ENIGMES_HITS = "enigmes_hits";
    public static final String GAMES_15D = "games_15d";
    public static final String GAMES_24H = "games_24h";
    public static final String GAMES_30D = "games_30d";
    public static final String GAMES_48H = "games_48h";
    public static final String GAMES_7D = "games_7d";
    public static final String GAME_REPORTS = "game_reports";
    public static final String GZ_COUNTER = "gz_counter";
    public static final String GZ_GAIN_INAPP = "gz_gain_inapp";
    public static final String GZ_GAIN_OFFER_WALLS = "gz_gain_offer_walls";
    public static final String GZ_GAIN_PLAYING = "gz_gain_playing";
    public static final String GZ_GAIN_VIDEO = "gz_gain_video";
    public static final String HOW_TO_GET_GENIZ = "how_to_get_geniz";
    private static final String KEY_FIRST_TIME_OPENED = "keyFirstTimeOpened";
    private static final String KEY_ID_RECOMMANDATION_DEJA_ENOVOYER = "keyId";
    public static final String LAST_GAME = "last_game";
    public static final String LEADERBOARD = "leaderboard";
    private static final String Lock = "sqliteLock";
    public static final String MUSIC = "music";
    public static final String MW_ADDED = "mw_added";
    public static final String MW_CREDIT = "mw_credit";
    public static final String MW_GUESSED = "mw_guessed";
    public static final String MW_INAPP_PURSCHASED = "mw_inapp_purchased";
    public static final String MW_RESET = "mw_reset";
    public static final String NB_JOURS = "nb_jours";
    public static final String NB_SESSIONS = "nb_sessions";
    public static final String NOM_SHAREDPREFS = "metrics";
    public static final String OFFER_WALL_DISPLAY = "offer_wall_display";
    public static final String PLAYED_CHARACTERS = "played_characters";
    public static final String POPU_BLOCK = "popu_block";
    public static final String POPU_UNLOCKABLE = "popu_unlockable";
    public static final String POPU_UNLOCKED = "popu_unlocked";
    public static final String PUB_CLOSE = "pub_close";
    public static final String RATING_APP = "rating_app";
    public static final String RECOMMANDATION_DEMANDE = "recommandation_demande";
    public static final String RECOMMANDATION_PEOPLE = "recommandation_people";
    public static final String RESEAU = "reseau";
    public static final String SEXE = "sexe";
    public static final String SHARING_BADGE = "sharing_badge";
    public static final String SHARING_BD = "sharing_bd";
    public static final String SHARING_CHARACTER = "sharing_character";
    public static final String SHARING_FB = "sharing_fb";
    public static final String SHARING_TWITTER = "sharing_twitter";
    public static final String SHARING_UNGESSED = "sharing_unguessed";
    public static final String SHOP_CLICK = "shop_click";
    public static final String SOUNDS = "sounds";
    public static final String SUCCES_GAMES = "succes_games";
    public static final String TOTAL_GAMES = "total_games";
    public static final String TYF_ADDS = "tyf_adds";
    public static final String TYF_USED = "tyf_used";
    public static final String UNLOCKED_BACKGROUNDS = "unlocked_backgrounds";
    public static final String UNLOCKED_CLOTHES = "unlocked_clothes";
    public static final String UNLOCKED_HATS = "unlocked_hats";
    private static final String VALEURS_TABLE = "valsues";
    private static final String VALEURS_TABLE_KEY = "cle";
    private static final String VALEURS_TABLE_VALUE = "valeur";
    public static final String VIDEO_VIEWS = "video_views";
    public static final String XP = "xp";
    private static MetricsSetAdapter instance = null;
    private static SQLiteDatabase mDB;
    private static MetricsDBOpenHelper mDBHelper = null;
    private android.content.SharedPreferences.Editor editor;
    private Context mContext;
    private SharedPreferences settings;

    public MetricsSetAdapter()
    {
    }

    public static MetricsSetAdapter sharedInstance()
    {
        if (instance == null)
        {
            instance = new MetricsSetAdapter();
        }
        return instance;
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

    public void createOrUpdateMetricCompteur(String s, int i)
    {
        if (i <= 0)
        {
            return;
        }
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = mDB.query("compteurs", null, "cle = ?;", new String[] {
            s
        }, null, null, null);
        if (cursor2 == null) goto _L2; else goto _L1
_L1:
        cursor = cursor2;
        cursor1 = cursor2;
        if (cursor2.getCount() != 1) goto _L2; else goto _L3
_L3:
        cursor = cursor2;
        cursor1 = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L4
_L4:
        cursor = cursor2;
        cursor1 = cursor2;
        ContentValues contentvalues = new ContentValues();
        cursor = cursor2;
        cursor1 = cursor2;
        contentvalues.put("valeur", Integer.valueOf(cursor2.getInt(1) + i));
        cursor = cursor2;
        cursor1 = cursor2;
        if (mDB.update("compteurs", contentvalues, "cle = ?", new String[] {
    s
}) == 1)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        cursor = cursor2;
        cursor1 = cursor2;
        Log.e("metrics", (new StringBuilder()).append("problem update COMPTEURS_TABLE_KEY").append(s).toString());
_L6:
        if (cursor2 == null)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        cursor2.close();
_L8:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return;
        s;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw s;
_L2:
        cursor = cursor2;
        cursor1 = cursor2;
        contentvalues = new ContentValues();
        cursor = cursor2;
        cursor1 = cursor2;
        contentvalues.put("cle", s);
        cursor = cursor2;
        cursor1 = cursor2;
        contentvalues.put("valeur", Integer.valueOf(i));
        cursor = cursor2;
        cursor1 = cursor2;
        if (mDB.insert("compteurs", null, contentvalues) != -1L) goto _L6; else goto _L5
_L5:
        cursor = cursor2;
        cursor1 = cursor2;
        Log.e("metrics", (new StringBuilder()).append("problem insert COMPTEURS_TABLE_KEY").append(s).toString());
          goto _L6
        s;
        cursor1 = cursor;
        s.printStackTrace();
        if (cursor == null) goto _L8; else goto _L7
_L7:
        cursor.close();
          goto _L8
        s;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_363;
        }
        cursor1.close();
        throw s;
          goto _L6
    }

    public void createOrUpdateMetricValeur(String s, String s1)
    {
        if (s1 == null)
        {
            return;
        }
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = mDB.query("valsues", null, "cle = ?;", new String[] {
            s
        }, null, null, null);
        if (cursor2 == null) goto _L2; else goto _L1
_L1:
        cursor = cursor2;
        cursor1 = cursor2;
        if (cursor2.getCount() != 1) goto _L2; else goto _L3
_L3:
        cursor = cursor2;
        cursor1 = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L4
_L4:
        cursor = cursor2;
        cursor1 = cursor2;
        ContentValues contentvalues = new ContentValues();
        cursor = cursor2;
        cursor1 = cursor2;
        contentvalues.put("valeur", s1);
        cursor = cursor2;
        cursor1 = cursor2;
        if (mDB.update("valsues", contentvalues, "cle = ?", new String[] {
    s
}) == 1)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        cursor = cursor2;
        cursor1 = cursor2;
        Log.e("metrics", (new StringBuilder()).append("problem update VALEURS_TABLE_KEY").append(s).toString());
_L6:
        if (cursor2 == null)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        cursor2.close();
_L8:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return;
        s;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw s;
_L2:
        cursor = cursor2;
        cursor1 = cursor2;
        contentvalues = new ContentValues();
        cursor = cursor2;
        cursor1 = cursor2;
        contentvalues.put("cle", s);
        cursor = cursor2;
        cursor1 = cursor2;
        contentvalues.put("valeur", s1);
        cursor = cursor2;
        cursor1 = cursor2;
        if (mDB.insert("valsues", null, contentvalues) != -1L) goto _L6; else goto _L5
_L5:
        cursor = cursor2;
        cursor1 = cursor2;
        Log.e("metrics", (new StringBuilder()).append("problem insert VALEURS_TABLE_KEY").append(s).toString());
          goto _L6
        s;
        cursor1 = cursor;
        s.printStackTrace();
        if (cursor == null) goto _L8; else goto _L7
_L7:
        cursor.close();
          goto _L8
        s;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        cursor1.close();
        throw s;
          goto _L6
    }

    public List getAllMetrics()
    {
        Object obj;
        obj = new LinkedList();
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Cursor cursor = mDB.query(true, "compteurs", new String[] {
            "cle", "valeur"
        }, null, null, null, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (cursor.getCount() == 0)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            ((List) (obj)).add(new Pair(cursor.getString(0), (new StringBuilder()).append("").append(cursor.getInt(1)).toString()));
        }

        break MISSING_BLOCK_LABEL_144;
        obj;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw obj;
        cursor.close();
        cursor = mDB.query(true, "valsues", new String[] {
            "cle", "valeur"
        }, null, null, null, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        if (cursor.getCount() == 0)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            ((List) (obj)).add(new Pair(cursor.getString(0), cursor.getString(1)));
        }

        cursor.close();
        "sqliteLock";
        JVM INSTR monitorexit ;
        return ((List) (obj));
    }

    public Set getIdsAlreadyInvite()
    {
        return settings.getStringSet("keyId", new HashSet());
    }

    public int getMetricCompteur(String s)
    {
        int j;
        boolean flag;
        flag = false;
        j = 0;
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        String s1;
        String s2;
        s2 = null;
        s1 = null;
        s = mDB.query("compteurs", null, "cle = ?;", new String[] {
            s
        }, null, null, null);
        int i;
        i = j;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        i = j;
        s1 = s;
        s2 = s;
        if (s.getCount() != 1)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        i = j;
        s1 = s;
        s2 = s;
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        s1 = s;
        s2 = s;
        i = s.getInt(1);
        j = i;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        s.close();
        j = i;
_L2:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return j;
        s;
        s2 = s1;
        s.printStackTrace();
        j = ((flag) ? 1 : 0);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1.close();
        j = ((flag) ? 1 : 0);
          goto _L2
        s;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw s;
        s;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        s2.close();
        throw s;
    }

    public String getMetricValeur(String s)
    {
        String s1;
        s1 = "";
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Cursor cursor;
        Object obj;
        obj = null;
        cursor = null;
        Cursor cursor1 = mDB.query("valsues", null, "cle = ?;", new String[] {
            s
        }, null, null, null);
        s = s1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        s = s1;
        cursor = cursor1;
        obj = cursor1;
        if (cursor1.getCount() != 1)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        s = s1;
        cursor = cursor1;
        obj = cursor1;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_111;
        }
        cursor = cursor1;
        obj = cursor1;
        s = cursor1.getString(1);
        obj = s;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        cursor1.close();
        obj = s;
_L2:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return ((String) (obj));
        s;
        obj = cursor;
        s.printStackTrace();
        obj = s1;
        if (cursor == null) goto _L2; else goto _L1
_L1:
        cursor.close();
        obj = s1;
          goto _L2
        s;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw s;
        s;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        ((Cursor) (obj)).close();
        throw s;
    }

    public long getStartDateOpening()
    {
        return settings.getLong("keyFirstTimeOpened", -1L);
    }

    public void incMetricCompteur(String s)
    {
        createOrUpdateMetricCompteur(s, 1);
    }

    public void init(Context context)
    {
        mContext = context;
    /* block-local class not found */
    class MetricsDBOpenHelper {}

        if (mDBHelper == null)
        {
            mDBHelper = new MetricsDBOpenHelper(mContext, "metrics.db", null, 1);
        }
        open();
        if (settings == null)
        {
            settings = mContext.getSharedPreferences("metrics", 0);
            editor = settings.edit();
        }
        if (getStartDateOpening() == -1L)
        {
            setStartDateOpening(Calendar.getInstance().getTimeInMillis());
        }
    }

    public void initCompteurToZeroIfNotExist(String s)
    {
        if (!isOpen())
        {
            open();
        }
        "sqliteLock";
        JVM INSTR monitorenter ;
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = mDB.query("compteurs", null, "cle = ?;", new String[] {
            s
        }, null, null, null);
        if (cursor2 == null) goto _L2; else goto _L1
_L1:
        cursor = cursor2;
        cursor1 = cursor2;
        if (cursor2.getCount() != 1) goto _L2; else goto _L3
_L3:
        cursor = cursor2;
        cursor1 = cursor2;
        boolean flag = cursor2.moveToFirst();
        if (!flag) goto _L2; else goto _L4
_L4:
        if (cursor2 == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        cursor2.close();
_L7:
        "sqliteLock";
        JVM INSTR monitorexit ;
        return;
_L2:
        cursor = cursor2;
        cursor1 = cursor2;
        ContentValues contentvalues = new ContentValues();
        cursor = cursor2;
        cursor1 = cursor2;
        contentvalues.put("cle", s);
        cursor = cursor2;
        cursor1 = cursor2;
        contentvalues.put("valeur", Integer.valueOf(0));
        cursor = cursor2;
        cursor1 = cursor2;
        if (mDB.insert("compteurs", null, contentvalues) != -1L) goto _L4; else goto _L5
_L5:
        cursor = cursor2;
        cursor1 = cursor2;
        Log.e("metrics", (new StringBuilder()).append("problem init COMPTEURS_TABLE_KEY").append(s).toString());
          goto _L4
        s;
        cursor1 = cursor;
        s.printStackTrace();
        if (cursor == null) goto _L7; else goto _L6
_L6:
        cursor.close();
          goto _L7
        s;
        "sqliteLock";
        JVM INSTR monitorexit ;
        throw s;
        s;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        cursor1.close();
        throw s;
          goto _L4
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

    public void setIds(Set set)
    {
        editor.putStringSet("keyId", set);
        editor.commit();
    }

    public void setStartDateOpening(long l)
    {
        editor.putLong("keyFirstTimeOpened", l);
        editor.commit();
    }

}
