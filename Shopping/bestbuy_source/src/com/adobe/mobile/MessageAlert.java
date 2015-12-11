// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.Looper;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.adobe.mobile:
//            Message, Messages, StaticMethods

final class MessageAlert extends Message
{

    private static final String JSON_CONFIG_CANCEL = "cancel";
    private static final String JSON_CONFIG_CONFIRM = "confirm";
    private static final String JSON_CONFIG_CONTENT = "content";
    private static final String JSON_CONFIG_TITLE = "title";
    private static final String JSON_CONFIG_URL = "url";
    protected AlertDialog alertDialog;
    protected String cancelButtonText;
    protected String confirmButtonText;
    protected String content;
    protected String title;
    protected String url;

    MessageAlert()
    {
    }

    protected static void clearCurrentDialog()
    {
        Message message;
        for (message = Messages.getCurrentMessage(); message == null || !(message instanceof MessageAlert) || message.orientationWhenShown == StaticMethods.getCurrentOrientation();)
        {
            return;
        }

        if (((MessageAlert)message).alertDialog != null && ((MessageAlert)message).alertDialog.isShowing())
        {
            ((MessageAlert)message).alertDialog.dismiss();
        }
        ((MessageAlert)message).alertDialog = null;
    }

    protected boolean initWithPayloadObject(JSONObject jsonobject)
    {
label0:
        {
            while (jsonobject == null || jsonobject.length() <= 0 || !super.initWithPayloadObject(jsonobject)) 
            {
                return false;
            }
            try
            {
                jsonobject = jsonobject.getJSONObject("payload");
                if (jsonobject.length() > 0)
                {
                    break label0;
                }
                StaticMethods.logWarningFormat("Messages - Unable to create alert message \"%s\", payload is empty", new Object[] {
                    messageId
                });
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                StaticMethods.logWarningFormat("Messages - Unable to create alert message \"%s\", payload is required", new Object[] {
                    messageId
                });
                return false;
            }
            return false;
        }
label1:
        {
            try
            {
                title = jsonobject.getString("title");
                if (title.length() > 0)
                {
                    break label1;
                }
                StaticMethods.logWarningFormat("Messages - Unable to create alert message \"%s\", title is empty", new Object[] {
                    messageId
                });
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                StaticMethods.logWarningFormat("Messages - Unable to create alert message \"%s\", title is required", new Object[] {
                    messageId
                });
                return false;
            }
            return false;
        }
label2:
        {
            try
            {
                content = jsonobject.getString("content");
                if (content.length() > 0)
                {
                    break label2;
                }
                StaticMethods.logWarningFormat("Messages - Unable to create alert message \"%s\", content is empty", new Object[] {
                    messageId
                });
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                StaticMethods.logWarningFormat("Messages - Unable to create alert message \"%s\", content is required", new Object[] {
                    messageId
                });
                return false;
            }
            return false;
        }
label3:
        {
            try
            {
                confirmButtonText = jsonobject.getString("confirm");
                if (confirmButtonText.length() > 0)
                {
                    break label3;
                }
                StaticMethods.logWarningFormat("Messages - Unable to create alert message \"%s\", confirm is empty", new Object[] {
                    messageId
                });
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                StaticMethods.logWarningFormat("Messages - Unable to create alert message \"%s\", confirm is required", new Object[] {
                    messageId
                });
                return false;
            }
            return false;
        }
label4:
        {
            try
            {
                cancelButtonText = jsonobject.getString("cancel");
                if (cancelButtonText.length() > 0)
                {
                    break label4;
                }
                StaticMethods.logWarningFormat("Messages - Unable to create alert message \"%s\", cancel is empty", new Object[] {
                    messageId
                });
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                StaticMethods.logWarningFormat("Messages - Unable to create alert message \"%s\", cancel is required", new Object[] {
                    messageId
                });
                return false;
            }
            return false;
        }
        try
        {
            url = jsonobject.getString("url");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            StaticMethods.logDebugFormat("Messages - Tried to read url for alert message but found none.  This is not a required field", new Object[0]);
        }
        return true;
    }

    protected void show()
    {
        if ((cancelButtonText == null || cancelButtonText.length() < 1) && (confirmButtonText == null || confirmButtonText.length() < 1))
        {
            return;
        } else
        {
            super.show();
            (new Handler(Looper.getMainLooper())).post(new MessageShower());
            return;
        }
    }

    private class MessageShower
        implements Runnable
    {

        private final MessageAlert message;

        public void run()
        {
            Object obj;
            try
            {
                obj = StaticMethods.getCurrentActivity();
            }
            catch (StaticMethods.NullActivityException nullactivityexception)
            {
                StaticMethods.logErrorFormat(nullactivityexception.getMessage(), new Object[0]);
                return;
            }
            try
            {
                obj = new android.app.AlertDialog.Builder(((android.content.Context) (obj)));
                ((android.app.AlertDialog.Builder) (obj)).setTitle(message.title);
                ((android.app.AlertDialog.Builder) (obj)).setMessage(message.content);
                class PositiveClickHandler
                    implements android.content.DialogInterface.OnClickListener
                {

                    private final MessageAlert message;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        message.clickedThrough();
                        message.isVisible = false;
                        if (message.url == null || message.url.length() <= 0)
                        {
                            break MISSING_BLOCK_LABEL_159;
                        }
                        Object obj1 = new HashMap();
                        if (StaticMethods.getVisitorID() == null)
                        {
                            dialoginterface = "";
                        } else
                        {
                            dialoginterface = StaticMethods.getVisitorID();
                        }
                        ((HashMap) (obj1)).put("{userId}", dialoginterface);
                        if (StaticMethods.getAID() == null)
                        {
                            dialoginterface = "";
                        } else
                        {
                            dialoginterface = StaticMethods.getAID();
                        }
                        ((HashMap) (obj1)).put("{trackingId}", dialoginterface);
                        ((HashMap) (obj1)).put("{messageId}", message.messageId);
                        ((HashMap) (obj1)).put("{lifetimeValue}", AnalyticsTrackLifetimeValueIncrease.getLifetimeValue().toString());
                        message.url = StaticMethods.expandTokens(message.url, ((java.util.Map) (obj1)));
                        try
                        {
                            dialoginterface = StaticMethods.getCurrentActivity();
                        }
                        // Misplaced declaration of an exception variable
                        catch (DialogInterface dialoginterface)
                        {
                            StaticMethods.logErrorFormat(dialoginterface.getMessage(), new Object[0]);
                            return;
                        }
                        obj1 = new Intent("android.intent.action.VIEW");
                        ((Intent) (obj1)).setData(Uri.parse(message.url));
                        dialoginterface.startActivity(((Intent) (obj1)));
                        return;
                        dialoginterface;
                        StaticMethods.logDebugFormat("Messages - Could not load click-through intent for message (%s)", new Object[] {
                            dialoginterface.toString()
                        });
                        return;
                    }

                public PositiveClickHandler()
                {
                    message = MessageAlert.this;
                }
                }

                ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(message.confirmButtonText, message. new PositiveClickHandler());
                class NegativeClickHandler
                    implements android.content.DialogInterface.OnClickListener
                {

                    private final MessageAlert message;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        message.viewed();
                        message.isVisible = false;
                    }

                public NegativeClickHandler()
                {
                    message = MessageAlert.this;
                }
                }

                ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(message.cancelButtonText, message. new NegativeClickHandler());
                class CancelClickHandler
                    implements android.content.DialogInterface.OnCancelListener
                {

                    private final MessageAlert message;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        message.viewed();
                        message.isVisible = false;
                    }

                public CancelClickHandler()
                {
                    message = MessageAlert.this;
                }
                }

                ((android.app.AlertDialog.Builder) (obj)).setOnCancelListener(message. new CancelClickHandler());
                message.alertDialog = ((android.app.AlertDialog.Builder) (obj)).create();
                message.alertDialog.setCanceledOnTouchOutside(false);
                message.alertDialog.show();
                message.isVisible = true;
                return;
            }
            catch (Exception exception)
            {
                StaticMethods.logDebugFormat("Messages - Could not show alert message (%s)", new Object[] {
                    exception.toString()
                });
            }
        }

        public MessageShower()
        {
            message = MessageAlert.this;
        }
    }

}
