// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nbcsports.liveextra.ui.player.premierleague.gameinfo;

import com.nbcsports.liveextra.content.models.overlay.premierleague.LeagueInfo;
import com.nbcsports.liveextra.ui.player.premierleague.standings.StandingsViewModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import rx.functions.Func2;

// Referenced classes of package com.nbcsports.liveextra.ui.player.premierleague.gameinfo:
//            MatchScorePresenter

class val.team
    implements Predicate
{

    final m this$1;
    final com.nbcsports.liveextra.content.models.overlay.premierleague.uate val$team;

    public boolean evaluate(com.nbcsports.liveextra.content.models.overlay.premierleague.team team1)
    {
        return val$team.() == team1.tTeamId();
    }

    public volatile boolean evaluate(Object obj)
    {
        return evaluate((com.nbcsports.liveextra.content.models.overlay.premierleague.uate)obj);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$team = com.nbcsports.liveextra.content.models.overlay.premierleague.team.this;
        super();
    }

    // Unreferenced inner class com/nbcsports/liveextra/ui/player/premierleague/gameinfo/MatchScorePresenter$8

/* anonymous class */
    class MatchScorePresenter._cls8
        implements Func2
    {

        final MatchScorePresenter this$0;

        public volatile Object call(Object obj, Object obj1)
        {
            return call((com.nbcsports.liveextra.content.models.overlay.premierleague.Standings.Week)obj, (LeagueInfo)obj1);
        }

        public List call(com.nbcsports.liveextra.content.models.overlay.premierleague.Standings.Week week, LeagueInfo leagueinfo)
        {
            ArrayList arraylist = new ArrayList();
            week = new ArrayList(week.getTeams());
            leagueinfo = new ArrayList(leagueinfo.getTeams());
            Iterator iterator = week.iterator();
            while (iterator.hasNext()) 
            {
                com.nbcsports.liveextra.content.models.overlay.premierleague.Standings.Team team1 = (com.nbcsports.liveextra.content.models.overlay.premierleague.Standings.Team)iterator.next();
                week = (com.nbcsports.liveextra.content.models.overlay.premierleague.LeagueInfo.LeagueTeam)CollectionUtils.find(leagueinfo, team1. new MatchScorePresenter._cls8._cls1());
                if (week != null)
                {
                    week = week.getName();
                } else
                {
                    week = "---";
                }
                arraylist.add(new StandingsViewModel(team1, week));
            }
            Collections.sort(arraylist);
            return arraylist;
        }

            
            {
                this$0 = MatchScorePresenter.this;
                super();
            }
    }

}
