// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.Favorite;
import com.xfinity.playerlib.model.LiveStreamFavorite;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.database.FavoriteDAO;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            FavoriteSpeechRecognizer

private class <init> extends NonCachingBaseTask
{

    final FavoriteSpeechRecognizer this$0;

    public Tuple4 execute()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(FavoriteSpeechRecognizer.access$300(FavoriteSpeechRecognizer.this).getAllFavorite());
        for (Iterator iterator = FavoriteSpeechRecognizer.access$400(FavoriteSpeechRecognizer.this).getFavorites().iterator(); iterator.hasNext(); arraylist.add(new LiveStreamFavorite((LiveStreamBookmark)iterator.next()))) { }
        Collections.sort(arraylist, new Comparator() {

            final FavoriteSpeechRecognizer.FavoriteTask this$1;

            public int compare(Favorite favorite, Favorite favorite1)
            {
                return favorite1.getCreated().compareTo(favorite.getCreated());
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Favorite)obj, (Favorite)obj1);
            }

            
            {
                this$1 = FavoriteSpeechRecognizer.FavoriteTask.this;
                super();
            }
        });
        return new Tuple4(arraylist, (DibicResource)FavoriteSpeechRecognizer.access$500(FavoriteSpeechRecognizer.this).execute(), (VideoEntitlement)FavoriteSpeechRecognizer.access$600(FavoriteSpeechRecognizer.this).execute(), (HalLiveStreamResource)FavoriteSpeechRecognizer.access$700(FavoriteSpeechRecognizer.this).execute());
    }

    public volatile Object execute()
    {
        return execute();
    }

    private _cls1.this._cls1()
    {
        this$0 = FavoriteSpeechRecognizer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
