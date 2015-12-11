// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.smule.android.f.p;
import com.smule.android.network.managers.ak;
import com.smule.pianoandroid.a.u;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.AchievementGoalState;
import com.smule.pianoandroid.data.model.AchievementState;
import com.smule.pianoandroid.data.model.ScoreInfo;
import com.smule.pianoandroid.data.model.SongProgress;
import com.smule.pianoandroid.e.a;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.a.g;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aa
{

    private static final String a = com/smule/pianoandroid/utils/aa.getName();

    public aa()
    {
    }

    public static void a()
    {
        try
        {
            Dao dao = u.a().getDao(com/smule/pianoandroid/data/model/ScoreInfo);
            Iterator iterator = dao.queryForAll().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ScoreInfo scoreinfo = (ScoreInfo)iterator.next();
                com.smule.android.c.aa.a(a, (new StringBuilder()).append("Checking song score ").append(scoreinfo.songId).toString());
                if (!scoreinfo.songId.startsWith("_"))
                {
                    com.smule.android.c.aa.a(a, (new StringBuilder()).append("Migrating song score ").append(scoreinfo.songId).append(" to ").append(ak.a().k(scoreinfo.songId)).toString());
                    scoreinfo.songId = ak.a().k(scoreinfo.songId);
                    dao.update(scoreinfo);
                }
            } while (true);
        }
        catch (SQLException sqlexception)
        {
            com.smule.android.c.aa.b(a, "Failed to upgrade scores", sqlexception);
        }
        g.a().b();
    }

    public static void b()
    {
        Object obj;
        Dao dao;
        Object obj1;
        com.smule.android.c.aa.a(a, "Starting score migration");
        obj = u.a().getDao(com/smule/pianoandroid/data/model/ScoreInfo);
        dao = u.a().getDao(com/smule/pianoandroid/data/model/SongProgress);
        GenericRawResults genericrawresults = ((Dao) (obj)).queryRaw("SELECT _id FROM score_info WHERE song_id NOT LIKE '|_%' ESCAPE '|'", new String[0]);
        obj1 = genericrawresults.getResults();
        genericrawresults.close();
        if (((List) (obj1)).isEmpty())
        {
            com.smule.android.c.aa.a(a, "No songs for migration");
            return;
        }
        Object obj2;
        obj2 = new ArrayList(((List) (obj1)).size());
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj2)).add(Integer.valueOf(Integer.parseInt(((String[])((Iterator) (obj1)).next())[0])))) { }
          goto _L1
        obj;
        com.smule.android.c.aa.b(a, "Failed to upgrade scores", ((Throwable) (obj)));
_L6:
        g.a().b();
        com.smule.android.c.aa.a(a, "End score migration");
        return;
_L1:
        obj1 = ((Dao) (obj)).query(((Dao) (obj)).queryBuilder().where().in("_id", ((Iterable) (obj2))).prepare()).iterator();
_L4:
        String s;
        Object obj3;
        if (!((Iterator) (obj1)).hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = (ScoreInfo)((Iterator) (obj1)).next();
        com.smule.android.c.aa.a(a, (new StringBuilder()).append("Checking song score ").append(((ScoreInfo) (obj2)).songId).toString());
        s = ak.a().k(((ScoreInfo) (obj2)).songId);
        obj3 = ((Dao) (obj)).queryForEq("song_id", s);
        if (((List) (obj3)).size() != 1)
        {
            break MISSING_BLOCK_LABEL_422;
        }
        obj3 = (ScoreInfo)((List) (obj3)).get(0);
        if (((ScoreInfo) (obj3)).topScore >= ((ScoreInfo) (obj2)).topScore) goto _L3; else goto _L2
_L2:
        dao.delete(((ScoreInfo) (obj3)).progress);
        ((Dao) (obj)).delete(obj3);
        com.smule.android.c.aa.a(a, (new StringBuilder()).append("Migrating song score ").append(((ScoreInfo) (obj2)).songId).append(" to ").append(s).toString());
        obj2.songId = s;
        ((Dao) (obj)).update(obj2);
          goto _L4
_L3:
        com.smule.android.c.aa.a(a, (new StringBuilder()).append("Deleting song score ").append(((ScoreInfo) (obj2)).songId).toString());
        dao.delete(((ScoreInfo) (obj2)).progress);
        ((Dao) (obj)).delete(obj2);
          goto _L4
        obj2.songId = s;
        ((Dao) (obj)).update(obj2);
          goto _L4
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static void c()
    {
        SharedPreferences sharedpreferences = MagicApplication.getContext().getSharedPreferences("STORE_SETTINGS", 0);
        Object obj = new ArrayList();
        Iterator iterator = sharedpreferences.getAll().keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (s.startsWith("song_response_"))
            {
                s = s.substring("song_response_".length());
                com.smule.android.c.aa.a(a, (new StringBuilder()).append("Checking song cache ").append(s).toString());
                if (!s.startsWith("_"))
                {
                    ((List) (obj)).add(s);
                }
            }
        } while (true);
        if (((List) (obj)).size() > 0)
        {
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            String s1;
            String s2;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); com.smule.android.c.aa.a(a, (new StringBuilder()).append("Migrating cached response of ").append(s1).append(" to ").append(s2).toString()))
            {
                s1 = (String)((Iterator) (obj)).next();
                s2 = ak.a().k(s1);
                String s3 = sharedpreferences.getString((new StringBuilder()).append("song_response_").append(s1).toString(), null);
                String s4 = sharedpreferences.getString((new StringBuilder()).append("song_signature_").append(s1).toString(), null);
                editor.putString((new StringBuilder()).append("song_response_").append(s2).toString(), s3);
                editor.putString((new StringBuilder()).append("song_signature_").append(s2).toString(), s4);
                editor.remove((new StringBuilder()).append("song_response_").append(s1).toString());
                editor.remove((new StringBuilder()).append("song_signature_").append(s1).toString());
            }

            p.a(editor);
        }
    }

    public static void d()
    {
        AchievementDefinition achievementdefinition;
        for (Iterator iterator = com.smule.pianoandroid.e.a.a().c().iterator(); iterator.hasNext(); com.smule.pianoandroid.e.a.a().a(achievementdefinition))
        {
            achievementdefinition = (AchievementDefinition)iterator.next();
            for (Iterator iterator1 = achievementdefinition.state.goals.iterator(); iterator1.hasNext(); ((AchievementGoalState)iterator1.next()).migrateV1Uniques()) { }
        }

    }

}
