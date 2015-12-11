// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import com.comcast.cim.android.accessibility.SpeechPresentationMode;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            KidsSpeechRecognizer

class tener extends DefaultTaskExecutionListener
{

    final KidsSpeechRecognizer this$0;
    final String val$filterText;
    final SpeechPresentationMode val$presentationMode;
    final String val$terms[];

    public void onError(TaskExecutionException taskexecutionexception)
    {
        KidsSpeechRecognizer.access$101(KidsSpeechRecognizer.this, 0);
    }

    public void onPostExecute(Tuple3 tuple3)
    {
        Object obj = (DibicResource)tuple3.e1;
        tuple3 = (VideoEntitlement)tuple3.e3;
        for (obj = ((DibicResource) (obj)).getPrograms().iterator(); ((Iterator) (obj)).hasNext();)
        {
            DibicProgram dibicprogram = (DibicProgram)((Iterator) (obj)).next();
            if (dibicprogram.isKids() && playOrShowIfVideoMatches(val$filterText, dibicprogram, val$presentationMode, tuple3, com.xfinity.playerlib.view.common..PLAYBACK))
            {
                return;
            }
        }

        KidsSpeechRecognizer.access$001(KidsSpeechRecognizer.this, val$terms, val$presentationMode);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Tuple3)obj);
    }

    n()
    {
        this$0 = final_kidsspeechrecognizer;
        val$filterText = s;
        val$presentationMode = speechpresentationmode;
        val$terms = _5B_Ljava.lang.String_3B_.this;
        super();
    }
}
