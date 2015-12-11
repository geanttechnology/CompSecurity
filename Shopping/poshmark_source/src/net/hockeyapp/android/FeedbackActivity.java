// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import net.hockeyapp.android.adapters.MessagesAdapter;
import net.hockeyapp.android.objects.ErrorObject;
import net.hockeyapp.android.objects.Feedback;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.objects.FeedbackResponse;
import net.hockeyapp.android.tasks.ParseFeedbackTask;
import net.hockeyapp.android.tasks.SendFeedbackTask;
import net.hockeyapp.android.utils.PrefsUtil;
import net.hockeyapp.android.views.FeedbackView;

// Referenced classes of package net.hockeyapp.android:
//            FeedbackActivityInterface

public class FeedbackActivity extends Activity
    implements FeedbackActivityInterface, android.view.View.OnClickListener, TraceFieldInterface
{

    private final int DIALOG_ERROR_ID = 0;
    private Button addResponseButton;
    private Context context;
    private EditText emailInput;
    private ErrorObject error;
    private Handler feedbackHandler;
    private ArrayList feedbackMessages;
    private ScrollView feedbackScrollView;
    private boolean inSendFeedback;
    private TextView lastUpdatedTextView;
    private MessagesAdapter messagesAdapter;
    private ListView messagesListView;
    private EditText nameInput;
    private Handler parseFeedbackHandler;
    private ParseFeedbackTask parseFeedbackTask;
    private Button refreshButton;
    private Button sendFeedbackButton;
    private SendFeedbackTask sendFeedbackTask;
    private EditText subjectInput;
    private EditText textInput;
    private String token;
    private String url;
    private LinearLayout wrapperLayoutFeedbackAndMessages;

    public FeedbackActivity()
    {
    }

    private void configureAppropriateView()
    {
        token = PrefsUtil.getInstance().getFeedbackTokenFromPrefs(this);
        if (token == null)
        {
            configureFeedbackView(false);
            return;
        } else
        {
            configureFeedbackView(true);
            sendFetchFeedback(url, null, null, null, null, token, feedbackHandler, true);
            return;
        }
    }

    private void createParseFeedbackTask(String s)
    {
        parseFeedbackTask = new ParseFeedbackTask(this, s, parseFeedbackHandler);
    }

    private void initFeedbackHandler()
    {
        feedbackHandler = new Handler() {

            final FeedbackActivity this$0;

            public void handleMessage(Message message)
            {
                boolean flag = false;
                error = new ErrorObject();
                if (message != null && message.getData() != null)
                {
                    Object obj = message.getData();
                    message = ((Bundle) (obj)).getString("feedback_response");
                    String s = ((Bundle) (obj)).getString("feedback_status");
                    obj = ((Bundle) (obj)).getString("request_type");
                    if (((String) (obj)).equals("send") && (message == null || Integer.parseInt(s) != 201))
                    {
                        error.setMessage("Message couldn't be posted. Please check your input values and try again.");
                    } else
                    if (((String) (obj)).equals("fetch") && (Integer.parseInt(s) == 404 || Integer.parseInt(s) == 422))
                    {
                        resetFeedbackView();
                        flag = true;
                    } else
                    {
                        startParseFeedbackTask(message);
                        flag = true;
                    }
                } else
                {
                    error.setMessage("Message couldn't be posted. Please check your input values and try again.");
                }
                if (!flag)
                {
                    runOnUiThread(new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            enableDisableSendFeedbackButton(true);
                            showDialog(0);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = FeedbackActivity.this;
                super();
            }
        };
    }

    private void initParseFeedbackHandler()
    {
        parseFeedbackHandler = new Handler() {

            final FeedbackActivity this$0;

            public void handleMessage(Message message)
            {
                boolean flag1 = false;
                error = new ErrorObject();
                boolean flag = flag1;
                if (message != null)
                {
                    flag = flag1;
                    if (message.getData() != null)
                    {
                        message = (FeedbackResponse)message.getData().getSerializable("parse_feedback_response");
                        flag = flag1;
                        if (message != null)
                        {
                            if (message.getStatus().equalsIgnoreCase("success"))
                            {
                                boolean flag2 = true;
                                flag = flag2;
                                if (message.getToken() != null)
                                {
                                    PrefsUtil.getInstance().saveFeedbackTokenToPrefs(context, message.getToken());
                                    loadFeedbackMessages(message);
                                    inSendFeedback = false;
                                    flag = flag2;
                                }
                            } else
                            {
                                flag = false;
                            }
                        }
                    }
                }
                if (!flag)
                {
                    runOnUiThread(new Runnable() {

                        final _cls3 this$1;

                        public void run()
                        {
                            showDialog(0);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                }
                enableDisableSendFeedbackButton(true);
            }

            
            {
                this$0 = FeedbackActivity.this;
                super();
            }
        };
    }

    private void loadFeedbackMessages(final FeedbackResponse feedbackResponse)
    {
        runOnUiThread(new Runnable() {

            final FeedbackActivity this$0;
            final FeedbackResponse val$feedbackResponse;

            public void run()
            {
                configureFeedbackView(true);
                Object obj = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMM h:mm a");
                if (feedbackResponse != null && feedbackResponse.getFeedback() != null && feedbackResponse.getFeedback().getMessages() != null && feedbackResponse.getFeedback().getMessages().size() > 0)
                {
                    feedbackMessages = feedbackResponse.getFeedback().getMessages();
                    Collections.reverse(feedbackMessages);
                    try
                    {
                        obj = ((SimpleDateFormat) (obj)).parse(((FeedbackMessage)feedbackMessages.get(0)).getCreatedAt());
                        lastUpdatedTextView.setText(String.format("Last Updated: %s", new Object[] {
                            simpledateformat.format(((java.util.Date) (obj)))
                        }));
                    }
                    catch (ParseException parseexception)
                    {
                        parseexception.printStackTrace();
                    }
                    if (messagesAdapter == null)
                    {
                        messagesAdapter = new MessagesAdapter(context, feedbackMessages);
                    } else
                    {
                        messagesAdapter.clear();
                        FeedbackMessage feedbackmessage;
                        for (Iterator iterator = feedbackMessages.iterator(); iterator.hasNext(); messagesAdapter.add(feedbackmessage))
                        {
                            feedbackmessage = (FeedbackMessage)iterator.next();
                        }

                        messagesAdapter.notifyDataSetChanged();
                    }
                    messagesListView.setAdapter(messagesAdapter);
                }
            }

            
            {
                this$0 = FeedbackActivity.this;
                feedbackResponse = feedbackresponse;
                super();
            }
        });
    }

    private void resetFeedbackView()
    {
        runOnUiThread(new Runnable() {

            final FeedbackActivity this$0;

            public void run()
            {
                PrefsUtil.getInstance().saveFeedbackTokenToPrefs(FeedbackActivity.this, null);
                configureFeedbackView(false);
            }

            
            {
                this$0 = FeedbackActivity.this;
                super();
            }
        });
    }

    private void sendFeedback()
    {
        enableDisableSendFeedbackButton(false);
        if (nameInput.getText().toString().trim().length() <= 0 || emailInput.getText().toString().trim().length() <= 0 || subjectInput.getText().toString().trim().length() <= 0 || textInput.getText().toString().trim().length() <= 0)
        {
            error = new ErrorObject();
            error.setMessage("Please provide all details");
            showDialog(0);
            enableDisableSendFeedbackButton(true);
            return;
        } else
        {
            PrefsUtil.getInstance().saveNameEmailSubjectToPrefs(context, nameInput.getText().toString(), emailInput.getText().toString(), subjectInput.getText().toString());
            sendFetchFeedback(url, nameInput.getText().toString(), emailInput.getText().toString(), subjectInput.getText().toString(), textInput.getText().toString(), PrefsUtil.getInstance().getFeedbackTokenFromPrefs(context), feedbackHandler, false);
            return;
        }
    }

    private void sendFetchFeedback(String s, String s1, String s2, String s3, String s4, String s5, Handler handler, 
            boolean flag)
    {
        sendFeedbackTask = new SendFeedbackTask(context, s, s1, s2, s3, s4, s5, handler, flag);
        s = sendFeedbackTask;
        s1 = new Void[0];
        if (!(s instanceof AsyncTask))
        {
            s.execute(s1);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)s, s1);
            return;
        }
    }

    private void startParseFeedbackTask(String s)
    {
        createParseFeedbackTask(s);
        s = parseFeedbackTask;
        Void avoid[] = new Void[0];
        if (!(s instanceof AsyncTask))
        {
            s.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)s, avoid);
            return;
        }
    }

    protected void configureFeedbackView(boolean flag)
    {
        feedbackScrollView = (ScrollView)findViewById(0x20017);
        wrapperLayoutFeedbackAndMessages = (LinearLayout)findViewById(0x20015);
        messagesListView = (ListView)findViewById(0x20016);
        if (flag)
        {
            wrapperLayoutFeedbackAndMessages.setVisibility(0);
            feedbackScrollView.setVisibility(8);
            lastUpdatedTextView = (TextView)findViewById(8192);
            addResponseButton = (Button)findViewById(0x20010);
            addResponseButton.setOnClickListener(this);
            refreshButton = (Button)findViewById(0x20011);
            refreshButton.setOnClickListener(this);
            return;
        }
        wrapperLayoutFeedbackAndMessages.setVisibility(8);
        feedbackScrollView.setVisibility(0);
        nameInput = (EditText)findViewById(8194);
        emailInput = (EditText)findViewById(8196);
        subjectInput = (EditText)findViewById(8198);
        textInput = (EditText)findViewById(8200);
        String s = PrefsUtil.getInstance().getNameEmailFromPrefs(context);
        if (s != null)
        {
            String as[] = s.split("\\|");
            if (as != null && as.length == 3)
            {
                nameInput.setText(as[0]);
                emailInput.setText(as[1]);
                subjectInput.setText(as[2]);
            }
        } else
        {
            nameInput.setText("");
            emailInput.setText("");
            subjectInput.setText("");
        }
        textInput.setText("");
        if (PrefsUtil.getInstance().getFeedbackTokenFromPrefs(context) != null)
        {
            subjectInput.setVisibility(8);
        } else
        {
            subjectInput.setVisibility(0);
        }
        sendFeedbackButton = (Button)findViewById(8201);
        sendFeedbackButton.setOnClickListener(this);
    }

    public void enableDisableSendFeedbackButton(boolean flag)
    {
        if (sendFeedbackButton != null)
        {
            sendFeedbackButton.setEnabled(flag);
        }
    }

    public volatile View getLayoutView()
    {
        return getLayoutView();
    }

    public ViewGroup getLayoutView()
    {
        return new FeedbackView(this);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 8201: 
            sendFeedback();
            return;

        case 131088: 
            configureFeedbackView(false);
            inSendFeedback = true;
            return;

        case 131089: 
            sendFetchFeedback(url, null, null, null, null, PrefsUtil.getInstance().getFeedbackTokenFromPrefs(context), feedbackHandler, true);
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("FeedbackActivity");
        TraceMachine.enterMethod(_nr_trace, "FeedbackActivity#onCreate", null);
_L1:
        super.onCreate(bundle);
        setContentView(getLayoutView());
        setTitle("Feedback");
        context = this;
        inSendFeedback = false;
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            url = bundle.getString("url");
        }
        initFeedbackHandler();
        initParseFeedbackHandler();
        configureAppropriateView();
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "FeedbackActivity#onCreate", null);
          goto _L1
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return (new android.app.AlertDialog.Builder(this)).setMessage("An error has occured").setCancelable(false).setTitle("Error").setIcon(0x1080027).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                final FeedbackActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    error = null;
                    dialoginterface.cancel();
                }

            
            {
                this$0 = FeedbackActivity.this;
                super();
            }
            }).create();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (inSendFeedback)
            {
                inSendFeedback = false;
                configureAppropriateView();
            } else
            {
                finish();
            }
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            dialog = (AlertDialog)dialog;
            break;
        }
        if (error != null)
        {
            dialog.setMessage(error.getMessage());
            return;
        } else
        {
            dialog.setMessage("An error has occured");
            return;
        }
    }

    public Object onRetainNonConfigurationInstance()
    {
        if (sendFeedbackTask != null)
        {
            sendFeedbackTask.detach();
        }
        return sendFeedbackTask;
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }



/*
    static ErrorObject access$002(FeedbackActivity feedbackactivity, ErrorObject errorobject)
    {
        feedbackactivity.error = errorobject;
        return errorobject;
    }

*/






/*
    static boolean access$502(FeedbackActivity feedbackactivity, boolean flag)
    {
        feedbackactivity.inSendFeedback = flag;
        return flag;
    }

*/



/*
    static ArrayList access$602(FeedbackActivity feedbackactivity, ArrayList arraylist)
    {
        feedbackactivity.feedbackMessages = arraylist;
        return arraylist;
    }

*/




/*
    static MessagesAdapter access$802(FeedbackActivity feedbackactivity, MessagesAdapter messagesadapter)
    {
        feedbackactivity.messagesAdapter = messagesadapter;
        return messagesadapter;
    }

*/

}
