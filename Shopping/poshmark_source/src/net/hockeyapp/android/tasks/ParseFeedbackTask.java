// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import net.hockeyapp.android.objects.FeedbackResponse;
import net.hockeyapp.android.utils.FeedbackParser;

public class ParseFeedbackTask extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    private Context context;
    private String feedbackResponse;
    private Handler handler;

    public ParseFeedbackTask(Context context1, String s, Handler handler1)
    {
        context = context1;
        feedbackResponse = s;
        handler = handler1;
    }

    public void _nr_setTrace(Trace trace)
    {
        try
        {
            _nr_trace = trace;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            return;
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "ParseFeedbackTask#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ParseFeedbackTask#doInBackground", null);
          goto _L1
    }

    protected transient FeedbackResponse doInBackground(Void avoid[])
    {
        if (context != null && feedbackResponse != null)
        {
            return FeedbackParser.getInstance().parseFeedbackResponse(feedbackResponse);
        } else
        {
            return null;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "ParseFeedbackTask#onPostExecute", null);
_L1:
        onPostExecute((FeedbackResponse)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ParseFeedbackTask#onPostExecute", null);
          goto _L1
    }

    protected void onPostExecute(FeedbackResponse feedbackresponse)
    {
        if (feedbackresponse != null && handler != null)
        {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putSerializable("parse_feedback_response", feedbackresponse);
            message.setData(bundle);
            handler.sendMessage(message);
        }
    }
}
