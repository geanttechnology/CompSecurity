// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import com.comcast.cim.android.accessibility.SpeechPresentationMode;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            PlayerSpeechRecognizer

public class TvSeriesSpeechRecognizer extends PlayerSpeechRecognizer
{

    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;

    public TvSeriesSpeechRecognizer()
    {
        taskExecutor = PlayerContainer.getInstance().getSeriesAndEntitlementTaskExecutor();
    }

    public void attemptSearch(final String terms[], final SpeechPresentationMode presentationMode)
    {
        if (presentationMode.equals(SpeechPresentationMode.SEARCH))
        {
            attemptSearch(terms, presentationMode);
            return;
        } else
        {
            taskExecutionListener = taskExecutor.execute(new DefaultTaskExecutionListener() {

                final TvSeriesSpeechRecognizer this$0;
                final SpeechPresentationMode val$presentationMode;
                final String val$terms[];

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    PlayerSpeechRecognizer.this.onError(0);
                }

                public void onPostExecute(Tuple tuple)
                {
                    VideoEntitlement videoentitlement = (VideoEntitlement)tuple.e2;
                    tuple = (DibicResource)tuple.e1;
                    Object obj = sortList(tuple.getPrograms());
                    tuple = StringUtils.join(terms, " ");
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                    {
                        DibicProgram dibicprogram = (DibicProgram)((Iterator) (obj)).next();
                        if (playOrShowIfVideoMatches(tuple, dibicprogram, presentationMode, videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK))
                        {
                            return;
                        }
                    }

                    attemptSearch(terms, presentationMode);
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Tuple)obj);
                }

            
            {
                this$0 = TvSeriesSpeechRecognizer.this;
                terms = as;
                presentationMode = speechpresentationmode;
                super();
            }
            });
            return;
        }
    }

    protected TaskExecutionListener getTaskExecutionListener()
    {
        return taskExecutionListener;
    }

    protected TaskExecutor getTaskExecutor()
    {
        return taskExecutor;
    }



}
