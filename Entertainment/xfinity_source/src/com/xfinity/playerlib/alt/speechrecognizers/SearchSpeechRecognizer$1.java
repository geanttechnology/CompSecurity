// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import android.content.Intent;
import android.os.Bundle;
import com.comcast.cim.android.accessibility.SpeechPresentationMode;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.model.comparator.DibicProgramTitleComparator;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            SearchSpeechRecognizer

class ner extends DefaultTaskExecutionListener
{

    final SearchSpeechRecognizer this$0;
    final SpeechPresentationMode val$presentationMode;
    final String val$terms[];

    public void onError(TaskExecutionException taskexecutionexception)
    {
        SearchSpeechRecognizer.access$101(SearchSpeechRecognizer.this, 0);
    }

    public void onPostExecute(Tuple tuple)
    {
        Object obj = (DibicResource)tuple.e2;
        Object obj1 = getIntent().getExtras().getString("KEY_SEARCH_TERMS");
        tuple = StringUtils.join(val$terms, " ");
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
        if (playOrShowIfValidListNumber(((List) (obj1)), val$terms, val$presentationMode, null, com.xfinity.playerlib.view.common.LAYBACK))
        {
            return;
        }
        for (Iterator iterator = ((List) (obj1)).iterator(); iterator.hasNext();)
        {
            DibicProgram dibicprogram = (DibicProgram)iterator.next();
            if (playOrShowIfVideoMatches(tuple, dibicprogram, val$presentationMode, null, com.xfinity.playerlib.view.common.LAYBACK))
            {
                return;
            }
        }

        SearchSpeechRecognizer.access$001(SearchSpeechRecognizer.this, val$terms, val$presentationMode);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Tuple)obj);
    }

    ner()
    {
        this$0 = final_searchspeechrecognizer;
        val$terms = as;
        val$presentationMode = SpeechPresentationMode.this;
        super();
    }
}
