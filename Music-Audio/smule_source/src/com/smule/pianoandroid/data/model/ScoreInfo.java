// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.smule.pianoandroid.a.u;
import com.smule.pianoandroid.data.db.CascadableEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.smule.pianoandroid.data.model:
//            SongProgress

public class ScoreInfo
    implements CascadableEntity
{

    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_LAST_SCORE = "last_score";
    public static final String COLUMN_NAME_LAST_SCORE_JSON = "lastScore";
    public static final String COLUMN_NAME_MAX_SCORE = "max_score";
    public static final String COLUMN_NAME_MAX_SCORE_JSON = "totalScore";
    public static final String COLUMN_NAME_SONG_ID = "song_id";
    public static final String COLUMN_NAME_SYNCED = "synced";
    public static final String COLUMN_NAME_TOP_SCORE = "top_score";
    public static final String COLUMN_NAME_TOP_SCORE_JSON = "topScore";
    public int _id;
    public int lastScore;
    public int maxScore;
    public Collection progress;
    public String songId;
    public boolean synced;
    public int topScore;

    public ScoreInfo()
    {
    }

    public void addSongProgress(SongProgress songprogress)
    {
        songprogress.scoreInfo = this;
        if (progress == null)
        {
            progress = new ArrayList();
        }
        progress.add(songprogress);
    }

    public void postCreate()
    {
        if (progress != null)
        {
            Dao dao = u.a().getDao(com/smule/pianoandroid/data/model/SongProgress);
            Iterator iterator = progress.iterator();
            while (iterator.hasNext()) 
            {
                SongProgress songprogress = (SongProgress)iterator.next();
                songprogress.scoreInfo = this;
                dao.create(songprogress);
            }
        }
    }

    public void postUpdate()
    {
    }

    public void preDelete()
    {
        if (progress == null)
        {
            return;
        } else
        {
            u.a().getDao(com/smule/pianoandroid/data/model/SongProgress).delete(progress);
            return;
        }
    }

    public SongProgress progressForDifficulty(int i)
    {
        if (progress == null)
        {
            return null;
        }
        for (Iterator iterator = progress.iterator(); iterator.hasNext();)
        {
            SongProgress songprogress = (SongProgress)iterator.next();
            if (songprogress.difficulty == i)
            {
                return songprogress;
            }
        }

        return null;
    }
}
