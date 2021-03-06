// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.games:
//            Player, PlayerBuffer

public interface Players
{
    public static interface LoadPlayersResult
        extends Releasable, Result
    {

        public abstract PlayerBuffer getPlayers();
    }

    public static interface LoadProfileSettingsResult
        extends Result
    {

        public abstract boolean isProfileVisible();
    }

    public static interface LoadXpForGameCategoriesResult
        extends Result
    {

        public abstract List getGameCategories();

        public abstract long getXpForCategory(String s);
    }

    public static interface LoadXpStreamResult
        extends Result
    {

        public abstract ExperienceEventBuffer getExperienceEvents();
    }


    public abstract Player getCurrentPlayer(GoogleApiClient googleapiclient);

    public abstract String getCurrentPlayerId(GoogleApiClient googleapiclient);

    public abstract Intent getPlayerSearchIntentInternal(GoogleApiClient googleapiclient, String s);

    public abstract Intent getPlusUpgradeIntentFirstParty(GoogleApiClient googleapiclient);

    public abstract PendingResult loadConnectedPlayers(GoogleApiClient googleapiclient, boolean flag);

    public abstract PendingResult loadInvitablePlayers(GoogleApiClient googleapiclient, int i, boolean flag);

    public abstract PendingResult loadMoreInvitablePlayers(GoogleApiClient googleapiclient, int i);

    public abstract PendingResult loadMorePlayersFirstParty(GoogleApiClient googleapiclient, String s, int i);

    public abstract PendingResult loadMorePlayersFirstParty(GoogleApiClient googleapiclient, String s, String s1, int i);

    public abstract PendingResult loadMoreXpStreamFirstParty(GoogleApiClient googleapiclient, String s, int i);

    public abstract PendingResult loadNearbyPlayersInternal(GoogleApiClient googleapiclient, String s, int i);

    public abstract PendingResult loadPlayer(GoogleApiClient googleapiclient, String s);

    public abstract PendingResult loadPlayer$70b7f367(GoogleApiClient googleapiclient, String s);

    public abstract PendingResult loadPlayers(GoogleApiClient googleapiclient, ArrayList arraylist);

    public abstract PendingResult loadPlayersFirstParty(GoogleApiClient googleapiclient, String s, String s1, int i, boolean flag);

    public abstract PendingResult loadPlayersFirstParty$4189436a(GoogleApiClient googleapiclient, String s, int i);

    public abstract PendingResult loadProfileSettingsInternal$4b6585cf(GoogleApiClient googleapiclient);

    public abstract PendingResult loadRecentlyPlayedWithPlayersInternal$4189436a(GoogleApiClient googleapiclient, String s, boolean flag);

    public abstract PendingResult loadXpForGameCategoriesFirstParty(GoogleApiClient googleapiclient, String s);

    public abstract PendingResult loadXpStreamFirstParty(GoogleApiClient googleapiclient, String s, int i);

    public abstract PendingResult searchForMorePlayersInternal(GoogleApiClient googleapiclient, String s, int i);

    public abstract PendingResult searchForPlayersInternal$4189436a(GoogleApiClient googleapiclient, String s, int i);

    public abstract void setNearbyPlayerDetectionEnabledInternal(GoogleApiClient googleapiclient, boolean flag);

    public abstract PendingResult updateProfileSettingsInternal(GoogleApiClient googleapiclient, boolean flag);
}
