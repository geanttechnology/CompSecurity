// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import android.content.Intent;
import android.os.Bundle;
import com.comcast.cim.android.accessibility.SpeechPresentationMode;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.container.PlayerContainer;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.model.comparator.DibicProgramTitleComparator;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            PlayerSpeechRecognizer

public class SearchSpeechRecognizer extends PlayerSpeechRecognizer
{

    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;

    public SearchSpeechRecognizer()
    {
        taskExecutor = PlayerContainer.getInstance().getTagsAndProgramsTaskExecutor();
    }

    public void attemptSearch(final String terms[], final SpeechPresentationMode presentationMode)
    {
        if (presentationMode.equals(SpeechPresentationMode.SEARCH))
        {
            super.attemptSearch(terms, presentationMode);
            return;
        } else
        {
            taskExecutionListener = taskExecutor.execute(new DefaultTaskExecutionListener() {

                final SearchSpeechRecognizer this$0;
                final SpeechPresentationMode val$presentationMode;
                final String val$terms[];

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    PlayerSpeechRecognizer.this.onError(0);
                }

                public void onPostExecute(Tuple tuple)
                {
                    Object obj = (DibicResource)tuple.e2;
                    Object obj1 = getIntent().getExtras().getString("KEY_SEARCH_TERMS");
                    tuple = StringUtils.join(terms, " ");
                    Object obj2 = ((DibicResource) (obj)).getProgramsMatchingTitleFilter(((String) (obj1)));
                    Collections.sort(((List) (obj2)), new DibicProgramTitleComparator(true));
                    obj1 = Lists.newArrayList();
                    obj = Lists.newArrayList();
                    DibicProgram dibicprogram1;
                    for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((List) (obj)).add(dibicprogram1))
                    {
                        dibicprogram1 = (DibicProgram)((Iterator) (obj2)).next();
                        if (dibicprogram1.isNew())
                        {
                            ((List) (obj1)).add(dibicprogram1);
                        }
                    }

                    obj1 = Lists.newArrayList(((Iterable) (obj1)));
                    ((List) (obj1)).addAll(((java.util.Collection) (obj)));
                    if (playOrShowIfValidListNumber(((List) (obj1)), terms, presentationMode, null, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK))
                    {
                        return;
                    }
                    for (Iterator iterator = ((List) (obj1)).iterator(); iterator.hasNext();)
                    {
                        DibicProgram dibicprogram = (DibicProgram)iterator.next();
                        if (playOrShowIfVideoMatches(tuple, dibicprogram, presentationMode, null, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK))
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
                this$0 = SearchSpeechRecognizer.this;
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
