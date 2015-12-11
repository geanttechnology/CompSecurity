// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import com.comcast.cim.android.accessibility.SpeechPresentationMode;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            LiveStreamsSpeechRecognizer

class init> extends DefaultTaskExecutionListener
{

    final LiveStreamsSpeechRecognizer this$0;
    final String val$filterText;
    final SpeechPresentationMode val$presentationMode;
    final String val$terms[];

    public void onError(TaskExecutionException taskexecutionexception)
    {
        LiveStreamsSpeechRecognizer.access$401(LiveStreamsSpeechRecognizer.this, 0);
    }

    public void onPostExecute(Tuple3 tuple3)
    {
        LiveStreamsSpeechRecognizer.access$102(LiveStreamsSpeechRecognizer.this, (VideoEntitlement)tuple3.e1);
        LiveStreamsSpeechRecognizer.access$202(LiveStreamsSpeechRecognizer.this, (List)tuple3.e3);
        for (Iterator iterator = LiveStreamsSpeechRecognizer.access$200(LiveStreamsSpeechRecognizer.this).iterator(); iterator.hasNext();)
        {
            LiveStreamBookmark livestreambookmark = (LiveStreamBookmark)iterator.next();
            if (checkTitleMatch(livestreambookmark.getTitle(), val$filterText))
            {
                playLiveStream(livestreambookmark.getStreamId(), (HalLiveStreamResource)tuple3.e2, LiveStreamsSpeechRecognizer.access$100(LiveStreamsSpeechRecognizer.this));
                return;
            }
        }

        LiveStreamsSpeechRecognizer.access$301(LiveStreamsSpeechRecognizer.this, val$terms, val$presentationMode);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Tuple3)obj);
    }

    ()
    {
        this$0 = final_livestreamsspeechrecognizer;
        val$filterText = s;
        val$terms = as;
        val$presentationMode = SpeechPresentationMode.this;
        super();
    }
}
