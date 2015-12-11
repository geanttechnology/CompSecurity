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
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            PlayerSpeechRecognizer

public class NetworkProgramsSpeechRecognizer extends PlayerSpeechRecognizer
{

    private OrderedTag category;
    private String categoryId;
    private long companyId;
    private Network network;
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;

    public NetworkProgramsSpeechRecognizer()
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
            taskExecutionListener = taskExecutor.execute(new DefaultTaskExecutionListener() {

                final NetworkProgramsSpeechRecognizer this$0;
                final SpeechPresentationMode val$presentationMode;
                final String val$terms[];

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    PlayerSpeechRecognizer.this.onError(0);
                }

                public void onPostExecute(Tuple3 tuple3)
                {
                    Object obj = (DibicResource)tuple3.e1;
                    TagsRoot tagsroot = (TagsRoot)tuple3.e2;
                    tuple3 = (VideoEntitlement)tuple3.e3;
                    String s = StringUtils.join(terms, " ");
                    network = tagsroot.getNetworkByCompanyId(companyId);
                    category = network.getCategoryById(categoryId);
                    for (obj = ((DibicResource) (obj)).getProgramsMatchingGenreAndNetwork(category, network).iterator(); ((Iterator) (obj)).hasNext();)
                    {
                        DibicProgram dibicprogram = (DibicProgram)((Iterator) (obj)).next();
                        if (playOrShowIfVideoMatches(s, dibicprogram, presentationMode, tuple3, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK))
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
                this$0 = NetworkProgramsSpeechRecognizer.this;
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

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        companyId = getIntent().getLongExtra("companyId", 0L);
        categoryId = getIntent().getStringExtra("categoryId");
    }



/*
    static Network access$002(NetworkProgramsSpeechRecognizer networkprogramsspeechrecognizer, Network network1)
    {
        networkprogramsspeechrecognizer.network = network1;
        return network1;
    }

*/




/*
    static OrderedTag access$202(NetworkProgramsSpeechRecognizer networkprogramsspeechrecognizer, OrderedTag orderedtag)
    {
        networkprogramsspeechrecognizer.category = orderedtag;
        return orderedtag;
    }

*/



}
