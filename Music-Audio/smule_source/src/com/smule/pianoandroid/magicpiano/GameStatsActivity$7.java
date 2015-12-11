// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.AsyncTask;
import com.smule.android.c.aa;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.AchievementState;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameStatsActivity, l

class a extends AsyncTask
{

    final GameStatsActivity a;

    protected transient Void a(Void avoid[])
    {
        aa.c(com.smule.pianoandroid.magicpiano.GameStatsActivity.a, "Loading ...");
        avoid = com.smule.pianoandroid.e.a.a().c();
        com.smule.pianoandroid.magicpiano.GameStatsActivity.a(a, new ArrayList());
        avoid = avoid.iterator();
        do
        {
            if (avoid.hasNext())
            {
                AchievementDefinition achievementdefinition = (AchievementDefinition)avoid.next();
                if (achievementdefinition.state.claimed && !GameStatsActivity.b(a))
                {
                    aa.a(com.smule.pianoandroid.magicpiano.GameStatsActivity.a, (new StringBuilder()).append("Filtering ").append(achievementdefinition).toString());
                    continue;
                }
                if (!achievementdefinition.state.claimed && GameStatsActivity.b(a))
                {
                    continue;
                }
                l l1 = new l();
                l1.d = 0;
                Iterator iterator = achievementdefinition.rewards.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    GameReward gamereward = (GameReward)iterator.next();
                    if (gamereward.getRewardType() != com.smule.pianoandroid.data.model.S)
                    {
                        continue;
                    }
                    l1.d = gamereward.amount;
                    break;
                } while (true);
                l1.a = achievementdefinition;
                l1.b = achievementdefinition.state;
                boolean flag;
                if (l1.b != null && l1.b.getCompletionPercent() >= 100)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                l1.c = flag;
                GameStatsActivity.c(a).add(l1);
                continue;
            }
            aa.c(com.smule.pianoandroid.magicpiano.GameStatsActivity.a, "Loaded!!!");
            Collections.sort(GameStatsActivity.c(a), new Comparator() {

                final GameStatsActivity._cls7 a;

                public int a(l l2, l l3)
                {
                    if (l2.b == null && l3.b == null)
                    {
                        return l2.a.goals.size() - l2.a.goals.size();
                    }
                    if (l2.b == null)
                    {
                        return 1;
                    }
                    if (l3.b == null)
                    {
                        return -1;
                    }
                    if (GameStatsActivity.b(a.a))
                    {
                        return (new Long(l3.b.displayedAt)).compareTo(Long.valueOf(l2.b.displayedAt));
                    } else
                    {
                        return l3.b.getCompletionPercent() - l2.b.getCompletionPercent();
                    }
                }

                public int compare(Object obj, Object obj1)
                {
                    return a((l)obj, (l)obj1);
                }

            
            {
                a = GameStatsActivity._cls7.this;
                super();
            }
            });
            aa.c(com.smule.pianoandroid.magicpiano.GameStatsActivity.a, "Sorted!!!");
            return null;
        } while (true);
    }

    protected void a(Void void1)
    {
        GameStatsActivity.d(a);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    _cls1.a(GameStatsActivity gamestatsactivity)
    {
        a = gamestatsactivity;
        super();
    }
}
