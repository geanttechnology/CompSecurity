// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.ViewActivity;
import com.apptentive.android.sdk.model.Configuration;
import com.apptentive.android.sdk.module.messagecenter.view.MessageCenterIntroDialog;
import com.apptentive.android.sdk.module.messagecenter.view.MessageCenterView;
import com.apptentive.android.sdk.module.metric.MetricModule;
import com.apptentive.android.sdk.storage.PersonManager;
import com.apptentive.android.sdk.util.Util;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.messagecenter:
//            MessageManager, MessagePollingWorker

public class ApptentiveMessageCenter
{

    private static Map customData;
    protected static MessageCenterView messageCenterView;
    private static Trigger trigger;

    public ApptentiveMessageCenter()
    {
    }

    public static void clearPendingMessageCenterPushNotification(Activity activity)
    {
        SharedPreferences sharedpreferences = activity.getSharedPreferences("APPTENTIVE", 0);
        String s = sharedpreferences.getString("pendingPushNotification", null);
        if (s != null)
        {
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                com.apptentive.android.sdk.ApptentiveInternal.PushAction pushaction = com.apptentive.android.sdk.ApptentiveInternal.PushAction.unknown;
                if (jsonobject.has("action"))
                {
                    pushaction = com.apptentive.android.sdk.ApptentiveInternal.PushAction.parse(jsonobject.getString("action"));
                }
                switch (_cls5..SwitchMap.com.apptentive.android.sdk.ApptentiveInternal.PushAction[pushaction.ordinal()])
                {
                case 1: // '\001'
                    Log.i("Clearing pending Message Center push notification.", new Object[0]);
                    sharedpreferences.edit().remove("pendingPushNotification").commit();
                    return;
                }
            }
            catch (JSONException jsonexception)
            {
                Log.w("Error parsing JSON from push notification.", jsonexception, new Object[0]);
                MetricModule.sendError(activity.getApplicationContext(), jsonexception, "Parsing Push notification", s);
                return;
            }
        }
    }

    public static void doShow(final Context context)
    {
        if (!(context instanceof Activity))
        {
            Log.e((new StringBuilder()).append(com/apptentive/android/sdk/module/messagecenter/ApptentiveMessageCenter.getSimpleName()).append(" must be initialized with an Activity Context.").toString(), new Object[0]);
            return;
        }
        com.apptentive.android.sdk.model.Event.EventLabel eventlabel = com.apptentive.android.sdk.model.Event.EventLabel.message_center__launch;
        Object obj;
        if (trigger == null)
        {
            obj = null;
        } else
        {
            obj = trigger.name();
        }
        MetricModule.sendMetric(context, eventlabel, ((String) (obj)));
        obj = new _cls1();
        obj = new MessageCenterView((Activity)context, ((com.apptentive.android.sdk.module.messagecenter.view.MessageCenterView.OnSendMessageListener) (obj)));
        messageCenterView = ((MessageCenterView) (obj));
        if (((MessageCenterView) (obj)).getParent() != null)
        {
            ((ViewGroup)messageCenterView.getParent()).removeView(messageCenterView);
        }
        ((Activity)context).setContentView(messageCenterView);
        messageCenterView.setMessages(MessageManager.getMessages(context));
        MessageManager.setInternalOnMessagesUpdatedListener(new _cls2());
        MessagePollingWorker.setMessageCenterInForeground(true);
        MessageManager.setSentMessageListener(messageCenterView);
        scrollToBottom();
    }

    public static boolean onBackPressed(Activity activity)
    {
        clearPendingMessageCenterPushNotification(activity);
        MetricModule.sendMetric(activity, com.apptentive.android.sdk.model.Event.EventLabel.message_center__close);
        return true;
    }

    public static void onStop(Activity activity)
    {
        clearPendingMessageCenterPushNotification(activity);
        MessagePollingWorker.setMessageCenterInForeground(false);
    }

    public static void scrollToBottom()
    {
        messageCenterView.scrollMessageListViewToBottom();
    }

    protected static void show(Activity activity)
    {
        boolean flag = false;
        SharedPreferences sharedpreferences = activity.getSharedPreferences("APPTENTIVE", 0);
        Configuration configuration = Configuration.load(activity);
        boolean flag1 = configuration.isMessageCenterEnabled(activity);
        boolean flag2 = configuration.isMessageCenterEmailRequired(activity);
        if (!flag1 || sharedpreferences.getBoolean("messageCenterShouldShowIntroDialog", true))
        {
            flag = true;
        }
        if (flag)
        {
            showIntroDialog(activity, flag2);
            return;
        } else
        {
            Intent intent = new Intent();
            intent.setClass(activity, com/apptentive/android/sdk/ViewActivity);
            intent.putExtra("activityContent", com.apptentive.android.sdk.module.ActivityContent.Type.MESSAGE_CENTER.toString());
            activity.startActivity(intent);
            activity.overridePendingTransition(com.apptentive.android.sdk.R.anim.slide_up_in, com.apptentive.android.sdk.R.anim.slide_down_out);
            return;
        }
    }

    public static void show(Activity activity, boolean flag, Map map)
    {
        MessageManager.createMessageCenterAutoMessage(activity, flag);
        Trigger trigger1;
        if (flag)
        {
            trigger1 = Trigger.message_center;
        } else
        {
            trigger1 = Trigger.enjoyment_dialog;
        }
        trigger = trigger1;
        customData = map;
        show(activity);
    }

    static void showIntroDialog(Activity activity, Trigger trigger1, boolean flag)
    {
        trigger = trigger1;
        showIntroDialog(activity, flag);
    }

    static void showIntroDialog(final Activity activity, boolean flag)
    {
        final MessageCenterIntroDialog dialog;
        String s;
        dialog = new MessageCenterIntroDialog(activity);
        dialog.setEmailRequired(flag);
        s = PersonManager.loadPersonEmail(activity);
        String s1 = PersonManager.loadInitialPersonEmail(activity);
        if (Util.isEmpty(s))
        {
            if (!Util.isEmpty(s1))
            {
                dialog.setEmailFieldHidden(false);
                dialog.prePopulateEmail(s1);
            }
        } else
        {
            dialog.setEmailFieldHidden(true);
        }
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnCancelListener(new _cls3());
        dialog.setOnSendListener(new _cls4());
        s = Configuration.load(activity).getAppDisplayName();
        _cls5..SwitchMap.com.apptentive.android.sdk.module.messagecenter.ApptentiveMessageCenter.Trigger[trigger.ordinal()];
        JVM INSTR tableswitch 1 2: default 124
    //                   1 133
    //                   2 180;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        dialog.setTitle(com.apptentive.android.sdk.R.string.apptentive_intro_dialog_title_no_love);
        dialog.setBody(activity.getResources().getString(com.apptentive.android.sdk.R.string.apptentive_intro_dialog_body, new Object[] {
            s
        }));
_L5:
        MetricModule.sendMetric(activity, com.apptentive.android.sdk.model.Event.EventLabel.message_center__intro__launch, trigger.name());
        dialog.show();
        return;
_L3:
        dialog.setTitle(com.apptentive.android.sdk.R.string.apptentive_intro_dialog_title_default);
        dialog.setBody(activity.getResources().getString(com.apptentive.android.sdk.R.string.apptentive_intro_dialog_body, new Object[] {
            s
        }));
        if (true) goto _L5; else goto _L4
_L4:
    }



/*
    static Map access$002(Map map)
    {
        customData = map;
        return map;
    }

*/

    private class _cls5
    {

        static final int $SwitchMap$com$apptentive$android$sdk$ApptentiveInternal$PushAction[];
        static final int $SwitchMap$com$apptentive$android$sdk$module$messagecenter$ApptentiveMessageCenter$Trigger[];

        static 
        {
            $SwitchMap$com$apptentive$android$sdk$ApptentiveInternal$PushAction = new int[com.apptentive.android.sdk.ApptentiveInternal.PushAction.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$ApptentiveInternal$PushAction[com.apptentive.android.sdk.ApptentiveInternal.PushAction.pmc.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            $SwitchMap$com$apptentive$android$sdk$module$messagecenter$ApptentiveMessageCenter$Trigger = new int[Trigger.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$messagecenter$ApptentiveMessageCenter$Trigger[Trigger.enjoyment_dialog.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$messagecenter$ApptentiveMessageCenter$Trigger[Trigger.message_center.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls1
        implements com.apptentive.android.sdk.module.messagecenter.view.MessageCenterView.OnSendMessageListener
    {

        final Context val$context;

        public final void onSendFileMessage(Uri uri)
        {
            final FileMessage message = new FileMessage();
            if (message.internalCreateStoredImage(context, uri.toString()))
            {
                message.setRead(true);
                message.setCustomData(ApptentiveMessageCenter.customData);
                ApptentiveMessageCenter.customData = null;
                MessageManager.sendMessage(context, message);
                class _cls2
                    implements Runnable
                {

                    final _cls1 this$0;
                    final FileMessage val$message;

                    public void run()
                    {
                        ApptentiveMessageCenter.messageCenterView.addMessage(message);
                    }

                _cls2()
                {
                    this$0 = _cls1.this;
                    message = filemessage;
                    super();
                }
                }

                ApptentiveMessageCenter.messageCenterView.post(new _cls2());
                ApptentiveMessageCenter.scrollToBottom();
                return;
            } else
            {
                Log.e("Unable to send file.", new Object[0]);
                Toast.makeText(ApptentiveMessageCenter.messageCenterView.getContext(), "Unable to send file.", 0).show();
                return;
            }
        }

        public final void onSendTextMessage(String s)
        {
            final TextMessage message = new TextMessage();
            message.setBody(s);
            message.setRead(true);
            message.setCustomData(ApptentiveMessageCenter.customData);
            ApptentiveMessageCenter.customData = null;
            MessageManager.sendMessage(context, message);
            class _cls1
                implements Runnable
            {

                final _cls1 this$0;
                final TextMessage val$message;

                public void run()
                {
                    ApptentiveMessageCenter.messageCenterView.addMessage(message);
                }

                _cls1()
                {
                    this$0 = _cls1.this;
                    message = textmessage;
                    super();
                }
            }

            ApptentiveMessageCenter.messageCenterView.post(new _cls1());
            ApptentiveMessageCenter.scrollToBottom();
        }

        _cls1()
        {
            context = context1;
            super();
        }
    }


    private class _cls2
        implements MessageManager.OnNewMessagesListener
    {

        final Context val$context;

        public final void onMessagesUpdated()
        {
            class _cls1
                implements Runnable
            {

                final _cls2 this$0;

                public void run()
                {
                    java.util.List list = MessageManager.getMessages(context);
                    ApptentiveMessageCenter.messageCenterView.setMessages(list);
                    ApptentiveMessageCenter.scrollToBottom();
                }

                _cls1()
                {
                    this$0 = _cls2.this;
                    super();
                }
            }

            ApptentiveMessageCenter.messageCenterView.post(new _cls1());
        }

        _cls2()
        {
            context = context1;
            super();
        }
    }


    private class Trigger extends Enum
    {

        private static final Trigger $VALUES[];
        public static final Trigger enjoyment_dialog;
        public static final Trigger message_center;

        public static Trigger valueOf(String s)
        {
            return (Trigger)Enum.valueOf(com/apptentive/android/sdk/module/messagecenter/ApptentiveMessageCenter$Trigger, s);
        }

        public static Trigger[] values()
        {
            return (Trigger[])$VALUES.clone();
        }

        static 
        {
            enjoyment_dialog = new Trigger("enjoyment_dialog", 0);
            message_center = new Trigger("message_center", 1);
            $VALUES = (new Trigger[] {
                enjoyment_dialog, message_center
            });
        }

        private Trigger(String s, int i)
        {
            super(s, i);
        }
    }


    private class _cls3
        implements android.content.DialogInterface.OnCancelListener
    {

        final Activity val$activity;
        final MessageCenterIntroDialog val$dialog;

        public final void onCancel(DialogInterface dialoginterface)
        {
            MetricModule.sendMetric(activity, com.apptentive.android.sdk.model.Event.EventLabel.message_center__intro__cancel);
            dialog.dismiss();
        }

        _cls3()
        {
            activity = activity1;
            dialog = messagecenterintrodialog;
            super();
        }
    }


    private class _cls4
        implements com.apptentive.android.sdk.module.messagecenter.view.MessageCenterIntroDialog.OnSendListener
    {

        final Activity val$activity;
        final MessageCenterIntroDialog val$dialog;

        public final void onSend(String s, String s1)
        {
            boolean flag = true;
            activity.getSharedPreferences("APPTENTIVE", 0).edit().putBoolean("messageCenterShouldShowIntroDialog", false).commit();
            if (dialog.isEmailFieldVisible() && s != null && s.length() != 0)
            {
                PersonManager.storePersonEmail(activity, s);
                Object obj = PersonManager.storePersonAndReturnDiff(activity);
                class _cls1
                    implements com.apptentive.android.sdk.module.messagecenter.view.MessageCenterThankYouDialog.OnChoiceMadeListener
                {

                    final _cls4 this$0;

                    public void onNo()
                    {
                        MetricModule.sendMetric(activity, com.apptentive.android.sdk.model.Event.EventLabel.message_center__thank_you__close);
                    }

                    public void onYes()
                    {
                        MetricModule.sendMetric(activity, com.apptentive.android.sdk.model.Event.EventLabel.message_center__thank_you__messages);
                        ApptentiveMessageCenter.show(activity);
                    }

                _cls1()
                {
                    this$0 = _cls4.this;
                    super();
                }
                }

                if (obj != null)
                {
                    Log.d("Person was updated.", new Object[0]);
                    Log.v(((Person) (obj)).toString(), new Object[0]);
                    ApptentiveDatabase.getInstance(activity).addPayload(new Payload[] {
                        obj
                    });
                } else
                {
                    Log.d("Person was not updated.", new Object[0]);
                }
            }
            obj = new TextMessage();
            ((TextMessage) (obj)).setBody(s1);
            ((TextMessage) (obj)).setRead(true);
            ((TextMessage) (obj)).setCustomData(ApptentiveMessageCenter.customData);
            ApptentiveMessageCenter.customData = null;
            MessageManager.sendMessage(activity, ((com.apptentive.android.sdk.model.Message) (obj)));
            MetricModule.sendMetric(activity, com.apptentive.android.sdk.model.Event.EventLabel.message_center__intro__send);
            dialog.dismiss();
            s1 = new MessageCenterThankYouDialog(activity);
            if (s == null || !Util.isEmailValid(s))
            {
                flag = false;
            }
            s1.setValidEmailProvided(flag);
            s1.setOnChoiceMadeListener(new _cls1());
            MetricModule.sendMetric(activity, com.apptentive.android.sdk.model.Event.EventLabel.message_center__thank_you__launch);
            s1.show();
        }

        _cls4()
        {
            activity = activity1;
            dialog = messagecenterintrodialog;
            super();
        }
    }

}
