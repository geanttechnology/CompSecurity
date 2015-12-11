// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import com.comcast.cim.android.accessibility.SpeechPresentationMode;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.view.programdetails.SeriesResource;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            SeriesSpeechRecognizer

class ner extends DefaultTaskExecutionListener
{

    final SeriesSpeechRecognizer this$0;
    final SpeechPresentationMode val$presentationMode;
    final String val$terms[];

    public void onError(TaskExecutionException taskexecutionexception)
    {
        SeriesSpeechRecognizer.access$501(SeriesSpeechRecognizer.this, 0);
    }

    public void onPostExecute(SeriesResource seriesresource)
    {
        Object obj = seriesresource.tvSeriesFacade;
        if (seriesresource.dibicResource.getProgramByMerlinId(((TvSeriesFacade) (obj)).getMerlinId()) == null)
        {
            SeriesSpeechRecognizer.access$101(SeriesSpeechRecognizer.this, 0);
        } else
        if (!SeriesSpeechRecognizer.access$200(SeriesSpeechRecognizer.this, ((TvSeriesFacade) (obj)).getAllEpisodeFacades(), val$terms, val$presentationMode))
        {
            seriesresource = StringUtils.join(val$terms, " ");
            for (obj = ((TvSeriesFacade) (obj)).getAllEpisodeFacades().iterator(); ((Iterator) (obj)).hasNext();)
            {
                SeriesWatchable serieswatchable = (SeriesWatchable)((Iterator) (obj)).next();
                if (serieswatchable.getDisplayTitle().toLowerCase().contains(seriesresource) && SeriesSpeechRecognizer.access$300(SeriesSpeechRecognizer.this, serieswatchable, val$presentationMode))
                {
                    return;
                }
            }

            SeriesSpeechRecognizer.access$401(SeriesSpeechRecognizer.this, val$terms, val$presentationMode);
            return;
        }
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((SeriesResource)obj);
    }

    ner()
    {
        this$0 = final_seriesspeechrecognizer;
        val$terms = as;
        val$presentationMode = SpeechPresentationMode.this;
        super();
    }
}
