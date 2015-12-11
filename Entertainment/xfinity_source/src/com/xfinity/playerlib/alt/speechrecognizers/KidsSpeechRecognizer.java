// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import com.comcast.cim.android.accessibility.SpeechPresentationMode;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            PlayerSpeechRecognizer

public class KidsSpeechRecognizer extends PlayerSpeechRecognizer
{

    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;

    public KidsSpeechRecognizer()
    {
        taskExecutor = PlayerContainer.getInstance().getProgramsAndTagsAndEntitlementTaskExecutor();
    }

    public void attemptSearch(final String terms[], final SpeechPresentationMode presentationMode)
    {
        if (presentationMode.equals(SpeechPresentationMode.SEARCH))
        {
            super.attemptSearch(terms, presentationMode);
            return;
        } else
        {
            final String filterText = StringUtils.join(terms, " ");
            taskExecutionListener = taskExecutor.execute(new DefaultTaskExecutionListener() {

                final KidsSpeechRecognizer this$0;
                final String val$filterText;
                final SpeechPresentationMode val$presentationMode;
                final String val$terms[];

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    PlayerSpeechRecognizer.this.onError(0);
                }

                public void onPostExecute(Tuple3 tuple3)
                {
                    Object obj = (DibicResource)tuple3.e1;
                    tuple3 = (VideoEntitlement)tuple3.e3;
                    for (obj = ((DibicResource) (obj)).getPrograms().iterator(); ((Iterator) (obj)).hasNext();)
                    {
                        DibicProgram dibicprogram = (DibicProgram)((Iterator) (obj)).next();
                        if (dibicprogram.isKids() && playOrShowIfVideoMatches(filterText, dibicprogram, presentationMode, tuple3, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK))
                        {
                            return;
                        }
                    }

                    attemptSearch(terms, presentationMode);
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Tuple3)obj);
                }

            
            {
                this$0 = KidsSpeechRecognizer.this;
                filterText = s;
                presentationMode = speechpresentationmode;
                terms = as;
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
