// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt;

import android.content.Context;
import android.content.res.Resources;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.alt:
//            PlayerDefaultTalkListHelper

public class PlayerEpisodeListTalkListHelper extends PlayerDefaultTalkListHelper
{

    private TvSeriesFacade tvSeriesFacade;

    public PlayerEpisodeListTalkListHelper(TvSeriesFacade tvseriesfacade, Context context)
    {
        int i;
        byte byte0;
        super(context);
        tvSeriesFacade = tvseriesfacade;
        lastListItemIndex = 0;
        moreOrLess = true;
        i = 0;
        byte0 = -2;
        if (tvseriesfacade != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Iterator iterator = tvseriesfacade.getSeasonNumberToEpisodeMap().entrySet().iterator();
        do
        {
            {
                if (!iterator.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                tvseriesfacade = (java.util.Map.Entry)iterator.next();
                StringBuilder stringbuilder = new StringBuilder();
                String s;
                Iterator iterator1;
                SeriesWatchable serieswatchable;
                StringBuilder stringbuilder1;
                int j;
                int k;
                if (((Integer)tvseriesfacade.getKey()).intValue() > 0)
                {
                    stringbuilder.append(context.getString(com.xfinity.playerlib.R.string.speech_list_season_x, new Object[] {
                        tvseriesfacade.getKey()
                    }));
                } else
                if (((Integer)tvseriesfacade.getKey()).intValue() == -1)
                {
                    stringbuilder.append(context.getString(com.xfinity.playerlib.R.string.speech_list_other_videos));
                }
                iterator1 = ((List)tvseriesfacade.getValue()).iterator();
                k = i;
                j = byte0;
            }
            byte0 = j;
            i = k;
            if (iterator1.hasNext())
            {
                serieswatchable = (SeriesWatchable)iterator1.next();
                stringbuilder1 = new StringBuilder();
                k++;
                if ((k - 1) % 5 == 0 || j != serieswatchable.getSeasonNumber().intValue())
                {
                    stringbuilder1.append(stringbuilder.toString());
                    stringbuilder1.append(" ");
                }
                j = serieswatchable.getSeasonNumber().intValue();
                tvseriesfacade = "";
                s = "";
                if (serieswatchable.getEpisodeNumber().intValue() >= 1)
                {
                    tvseriesfacade = getItemTypeQuantity(1);
                    s = serieswatchable.getEpisodeNumber().toString();
                }
                i = com.xfinity.playerlib.R.string.speech_list_episode_list_row;
                String s1;
                if (serieswatchable.isNew())
                {
                    s1 = context.getString(com.xfinity.playerlib.R.string.speech_list_is_new);
                } else
                {
                    s1 = "";
                }
                stringbuilder1.append(context.getString(i, new Object[] {
                    Integer.valueOf(k), tvseriesfacade, s, s1, serieswatchable.getDisplayTitle()
                }));
                results.add(new Tuple(stringbuilder1.toString(), serieswatchable));
                break MISSING_BLOCK_LABEL_143;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected String getItemTypeQuantity(int i)
    {
        return context.getResources().getQuantityString(com.xfinity.playerlib.R.plurals.speech_episode, i);
    }

    protected void getResultRowDescriptions(StringBuilder stringbuilder)
    {
        int i = lastListItemIndex * 5;
        do
        {
label0:
            {
                if (i < results.size())
                {
                    stringbuilder.append((String)((Tuple)CommonUtils.uncheckedCast(results.get(i))).e1);
                    stringbuilder.append(". ");
                    if (i != lastListItemIndex * 5 + 4)
                    {
                        break label0;
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    public String speakResults()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(tvSeriesFacade.getTitle());
        stringbuilder.append(". ");
        buildSpeechResponse(stringbuilder);
        return stringbuilder.toString();
    }
}
