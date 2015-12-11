// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreListActivity, ErrorDialogActivity

public class SampleMessageActivity extends CoreListActivity
    implements com.ebay.mobile.ErrorDialogFragment.OnDismissMessageListener
{
    private static class DlgError extends DlgMessage
    {

        public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
        {
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;
        }

        public DlgError(int i, String s, String s1)
        {
            super(i, s, s1);
        }

        public DlgError(String s, String s1)
        {
            super(s, s1);
        }
    }

    private static class DlgMessage extends Message
    {

        public String getCategory()
        {
            return "dialog";
        }

        public DlgMessage(int i, String s, String s1)
        {
            super(i, s, s1);
        }

        public DlgMessage(String s, String s1)
        {
            super(s, s1);
        }
    }

    private static class Error extends Message
    {

        public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
        {
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;
        }

        public Error(int i, String s, String s1)
        {
            super(i, s, s1);
        }

        public Error(String s, String s1)
        {
            super(s, s1);
        }
    }

    private static interface ListItem
    {

        public abstract void start(int i);
    }

    private static class Message
        implements com.ebay.nautilus.kernel.content.ResultStatus.Message
    {

        private final int id;
        private final String longMessage;
        private final String shortMessage;

        public boolean displayToUser()
        {
            return true;
        }

        public String getCategory()
        {
            return "network";
        }

        public String getDomain()
        {
            return "http";
        }

        public int getId()
        {
            return id;
        }

        public String getLongMessage(EbayContext ebaycontext)
        {
            return longMessage;
        }

        public String getRemediationUrl()
        {
            return null;
        }

        public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
        {
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Warning;
        }

        public String getShortMessage(EbayContext ebaycontext)
        {
            return shortMessage;
        }

        public boolean isLongMessageHtml(EbayContext ebaycontext)
        {
            ebaycontext = getLongMessage(ebaycontext);
            return ebaycontext != null && ebaycontext.contains("</");
        }

        public String toString()
        {
            return shortMessage;
        }

        public Message(int i, String s, String s1)
        {
            id = i;
            shortMessage = s;
            longMessage = s1;
        }

        public Message(String s, String s1)
        {
            this(0, s, s1);
        }
    }

    private final class StatusItem
        implements ListItem
    {

        private com.ebay.common.view.EbayErrorHandler.OverrideHandler override;
        private final ResultStatus resultStatus;
        final SampleMessageActivity this$0;

        public StatusItem setCanRetry(boolean flag)
        {
            resultStatus.setCanRetry(flag);
            return this;
        }

        public StatusItem setOverride(com.ebay.common.view.EbayErrorHandler.OverrideHandler overridehandler)
        {
            override = overridehandler;
            return this;
        }

        public void start(int i)
        {
            EbayErrorHandler.handleResultStatus(SampleMessageActivity.this, i, resultStatus, override);
        }

        public String toString()
        {
            com.ebay.nautilus.kernel.content.ResultStatus.Message message = resultStatus.getFirstMessage();
            if (message != null)
            {
                return message.getShortMessage(getEbayContext());
            } else
            {
                return resultStatus.toString();
            }
        }

        public StatusItem(Message message)
        {
            this$0 = SampleMessageActivity.this;
            super();
            resultStatus = ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                message
            });
        }
    }


    static final com.ebay.common.view.EbayErrorHandler.OverrideHandler dlgActivity = new com.ebay.common.view.EbayErrorHandler.OverrideHandler() {

        public com.ebay.common.view.EbayErrorHandler.OverrideHandler.HandleState handleError(Activity activity, Fragment fragment, int i, ResultStatus resultstatus)
        {
            com.ebay.nautilus.kernel.content.ResultStatus.Message message = resultstatus.getFirstError();
            if (message != null)
            {
                ErrorDialogActivity.StartActivity(activity, String.valueOf(message.getId()), ResultStatus.getSafeLongMessage(((SampleMessageActivity)activity).getEbayContext(), message));
                return com.ebay.common.view.EbayErrorHandler.OverrideHandler.HandleState.Handled;
            } else
            {
                return super.handleError(activity, fragment, i, resultstatus);
            }
        }

        public com.ebay.common.view.EbayErrorHandler.OverrideHandler.HandleState handleWarning(Activity activity, Fragment fragment, int i, ResultStatus resultstatus)
        {
            com.ebay.nautilus.kernel.content.ResultStatus.Message message = resultstatus.getFirstWarning();
            if (message != null)
            {
                i = message.getId();
                fragment = ResultStatus.getSafeLongMessage(((SampleMessageActivity)activity).getEbayContext(), message);
                ErrorDialogActivity.StartActivity(activity, activity.getString(0x7f070130), String.valueOf(i), fragment, false);
                return com.ebay.common.view.EbayErrorHandler.OverrideHandler.HandleState.Handled;
            } else
            {
                return super.handleWarning(activity, fragment, i, resultstatus);
            }
        }

    };
    private final ListItem items[];

    public SampleMessageActivity()
    {
        items = (new ListItem[] {
            new ListItem() {

                final SampleMessageActivity this$0;

                public void start(int i)
                {
                    Intent intent = new Intent(SampleMessageActivity.this, com/ebay/mobile/activities/SampleMessageActivity);
                    if (!getIntent().getBooleanExtra("invert", false))
                    {
                        intent.putExtra("invert", true);
                    }
                    startActivity(intent);
                    finish();
                }

                public String toString()
                {
                    return "Invert theme";
                }

            
            {
                this$0 = SampleMessageActivity.this;
                super();
            }
            }, (new StatusItem(new DlgError(2, "Error dialog activity", "Sample error message"))).setOverride(dlgActivity), (new StatusItem(new DlgError(2, "HTML Error dialog activity", "<p><b>The title</b></p><p>Sample error message</p>"))).setOverride(dlgActivity), new StatusItem(new DlgError(2, "Error dialog fragment", "Sample error message")), new StatusItem(new DlgError("Error dialog fragment (w/o code)", "Sample error message")), (new StatusItem(new DlgError(2, "Error dialog fragment with retry", "Sample error message"))).setCanRetry(true), new StatusItem(new DlgError(2, "HTML Error dialog fragment", "<p><b>The title</b></p><p>Sample error message</p>")), new StatusItem(new Message("Simple warning", "The shipping service has changed for one or more items below.")), new StatusItem(new Error("Simple error", "Your session has expired. Please sign in again.")), (new StatusItem(new Error("Error with retry", "No network connection."))).setCanRetry(true)
        });
    }

    protected void onCreate(Bundle bundle)
    {
        if (getIntent().getBooleanExtra("invert", false))
        {
            setTheme(0x7f0a026a);
        }
        super.onCreate(bundle);
        setListAdapter(new ArrayAdapter(this, 0x1090003, items));
        setShowWarnings(true);
    }

    public void onDismissMessage(int i, boolean flag)
    {
        Log.d("AlertMsg", (new StringBuilder()).append("Activity.onDismissMessage(").append(i).append(", ").append(flag).append(')').toString());
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        super.onListItemClick(listview, view, i, l);
        items[i].start(i);
    }

}
