// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.boldchat.sdk.utils.OnPreChatFormSubmitListener;
import com.boldchat.sdk.utils.PersistedChat;
import com.boldchat.sdk.utils.RichTextUtils;
import com.boldchat.visitor.api.Account;
import com.boldchat.visitor.api.Chat;
import com.boldchat.visitor.api.ChatAvailabilityListener;
import com.boldchat.visitor.api.ChatFinishedListener;
import com.boldchat.visitor.api.ChatListener;
import com.boldchat.visitor.api.ChatMessageListener;
import com.boldchat.visitor.api.ChatQueueListener;
import com.boldchat.visitor.api.ChatStartListener;
import com.boldchat.visitor.api.ChatTyperListener;
import com.boldchat.visitor.api.ChatUnavailableListener;
import com.boldchat.visitor.api.CreateChatListener;
import com.boldchat.visitor.api.EndedReason;
import com.boldchat.visitor.api.Form;
import com.boldchat.visitor.api.FormField;
import com.boldchat.visitor.api.Message;
import com.boldchat.visitor.api.PersonType;
import com.boldchat.visitor.api.PostChat;
import com.boldchat.visitor.api.PostChatSubmitListener;
import com.boldchat.visitor.api.PreChat;
import com.boldchat.visitor.api.Typer;
import com.boldchat.visitor.api.UnavailableForm;
import com.boldchat.visitor.api.UnavailableReason;
import com.boldchat.visitor.api.internal.RequestUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatState, BoldChatHistory, BoldChatViewManager, BoldChatView, 
//            BoldChatWebHistory, BoldChatFormView

public class BoldChatSession
{
    public static interface BoldChatSessionListener
    {

        public abstract void chatSessionClosed();

        public abstract void chatSessionCreated();

        public abstract void chatSessionEnded();

        public abstract void chatSessionStarted();

        public abstract void messageArrived(String s, String s1, Date date);

        public abstract void operatorTyping();
    }

    public static class Builder
    {

        private long mAccountID;
        private ViewGroup mBusyView;
        private Map mExtraData;
        private ChatFormListener mFormListener;
        private ViewGroup mFormView;
        private String mLanguage;
        private BoldChatSessionListener mListener;
        private ViewGroup mMainView;
        private String mServerSet;
        private BoldChatSession mSession;
        private boolean mSkipPreChat;

        public BoldChatSession build()
        {
            Object obj;
            int i;
            if (mSession.mApiKey == null)
            {
                throw new RuntimeException("No API Key configured");
            }
            obj = null;
            i = 0;
            Object obj1;
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            obj1 = ((WindowManager)mSession.mContext.getSystemService("window")).getDefaultDisplay();
            obj = new Point();
            ((Display) (obj1)).getSize(((Point) (obj)));
            i = Math.round(mSession.mContext.getResources().getDisplayMetrics().density * 160F);
            obj1 = (new StringBuilder()).append(mSession.mContext.getPackageName()).append("/").append(mSession.getVersion());
            if (obj == null) goto _L2; else goto _L1
_L1:
            obj = (new StringBuilder()).append(" (").append(((Point) (obj)).x).append("x").append(((Point) (obj)).y).append("-").append(i).append("dpi)").toString();
_L3:
            RequestUtil.setAdditionalInfo(((StringBuilder) (obj1)).append(((String) (obj))).toString());
_L4:
            Exception exception;
            mSession.setListener(mListener);
            mSession.setChatFormListener(mFormListener);
            obj = mSession;
            BoldChatSession.sAccount = new Account(mAccountID, mSession.mApiKey);
            obj = mSession;
            BoldChatSession.sAccount.setServerSet(mServerSet);
            obj = mSession;
            BoldChatSession.sAccount.setExtraData(mExtraData);
            obj = mSession;
            BoldChatSession.sAccount.setSkipPreChat(mSkipPreChat);
            if (mLanguage != null)
            {
                obj = mSession;
                BoldChatSession.sAccount.setLanguage(mLanguage);
            }
            if (mMainView != null)
            {
                obj = null;
                if (BoldChatSession.sCurrentState == BoldChatState.ChatActive)
                {
                    obj = BoldChatSession.sPersistedMessageText;
                }
                BoldChatSession.sPersistedMessageText = null;
                mSession.mViewManager = new BoldChatViewManager(mSession.mContext, mBusyView, mFormView, mMainView, ((String) (obj)));
                mSession.mViewManager.setMainViewClickListener(R.id.bc_send_button, mSession.mCallBackListener);
                mSession.mViewManager.setMainViewClickListener(R.id.bc_close_button, mSession.mCallBackListener);
                mSession.mViewManager.setMainViewClickListener(R.id.bc_end_chat, mSession.mCallBackListener);
                mSession.mViewManager.setState(BoldChatSession.sCurrentState);
                obj = mSession.mViewManager.getMessageInputField();
                if (obj != null)
                {
                    Object obj2 = mSession;
                    obj2.getClass();
                    obj2 = ((TypingListener) (obj2)). new TypingListener();
                    ((TextView) (obj)).addTextChangedListener(((TextWatcher) (obj2)));
                    ((TextView) (obj)).setOnKeyListener(((android.view.View.OnKeyListener) (obj2)));
                    obj2 = mSession;
                    obj2.getClass();
                    ((TextView) (obj)).setOnFocusChangeListener(((MessageInputFocusListener) (obj2)). new MessageInputFocusListener());
                }
                if (BoldChatSession.sChat != null)
                {
                    mSession.mViewManager.setBrandings(BoldChatSession.sChat.getBrandings());
                }
            }
            if (mSession.mSharedPrefs == null)
            {
                mSession.mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(mSession.mContext);
            }
            mSession.mVisitorID = mSession.mSharedPrefs.getLong(mSession.getVisitorKey(), -1L);
            obj = mSession;
            BoldChatSession.sAccount.setVisitorID(mSession.mVisitorID);
            if (mSession.mHistoryView != null && (mSession.mHistoryView instanceof BoldChatWebHistory))
            {
                ((BoldChatWebHistory)mSession.mHistoryView).setHistoryPageLoadedListener(mSession.mCallBackListener);
            } else
            {
                mSession.mCallBackListener.historyPageLoaded();
            }
            if (BoldChatSession.sChat != null && (BoldChatSession.sCurrentState == BoldChatState.ChatActive || BoldChatSession.sCurrentState == BoldChatState.ChatInactive))
            {
                if (mSession.mViewManager != null)
                {
                    BoldChatSession boldchatsession2;
                    if (BoldChatSession.sCurrentState == BoldChatState.ChatActive && BoldChatSession.sChat.isEnded())
                    {
                        mSession.mViewManager.setState(BoldChatState.ChatInactive);
                    } else
                    {
                        mSession.mViewManager.setState(BoldChatSession.sCurrentState);
                    }
                    if (BoldChatSession.sCurrentState == BoldChatState.ChatActive && !BoldChatSession.sChat.isEnded())
                    {
                        obj = mSession;
                        BoldChatSession boldchatsession1 = mSession;
                        boldchatsession1.getClass();
                        obj.mChatPinger = boldchatsession1. new ChatPinger(BoldChatSession.sChat);
                        (new Thread(mSession.mChatPinger)).start();
                    }
                }
                obj = mSession.mCallBackListener;
                boldchatsession2 = mSession;
                ((CallBackListeners) (obj)).onChatUpdated(BoldChatSession.sChat);
                mSession.setTypingText(new SpannableString(""));
            } else
            {
                BoldChatSession boldchatsession = mSession;
                BoldChatSession.sChat = null;
            }
            return mSession;
_L2:
            obj = "";
              goto _L3
            exception;
_L5:
            Log.i("BOLD", "Failed to add some extra info to user agent string (non critical)", exception);
              goto _L4
            boldchatsession;
              goto _L5
        }

        public Builder setChatFormListener(ChatFormListener chatformlistener)
        {
            mFormListener = chatformlistener;
            return this;
        }

        public Builder setHideKeyboardOnSend(boolean flag)
        {
            mSession.mHideKeyboardOnSend = flag;
            return this;
        }

        public Builder setViewContainers(ViewGroup viewgroup, ViewGroup viewgroup1, ViewGroup viewgroup2)
        {
            mBusyView = viewgroup;
            mFormView = viewgroup1;
            mMainView = viewgroup2;
            mSession.mHistoryView = (BoldChatHistory)mMainView.findViewById(R.id.bc_chat_history);
            return this;
        }

        public Builder(Context context, long l, String s)
        {
            mSkipPreChat = false;
            mSession = new BoldChatSession();
            mSession.mContext = context;
            mAccountID = l;
            mSession.mApiKey = s;
        }

        public Builder(Context context, String s)
        {
            long l;
            if (s != null)
            {
                l = Long.valueOf(s.substring(0, s.indexOf(':'))).longValue();
            } else
            {
                l = 0L;
            }
            if (s != null)
            {
                s = s.substring(s.indexOf(':') + 1);
            } else
            {
                s = null;
            }
            this(context, l, s);
        }

        public Builder(BoldChatView boldchatview, String s)
        {
            this(boldchatview.getContext(), s);
            setViewContainers(boldchatview.getBusyView(), boldchatview.getFormView(), boldchatview.getMainChatView());
        }
    }

    private class CallBackListeners
        implements android.view.View.OnClickListener, BoldChatWebHistory.HistoryPageLoadedListener, ChatFinishedListener, ChatListener, ChatMessageListener, ChatQueueListener, ChatStartListener, ChatTyperListener, ChatUnavailableListener, CreateChatListener, PostChatSubmitListener
    {

        final BoldChatSession this$0;

        public void historyPageLoaded()
        {
            mPageIsLoaded = true;
            if (BoldChatSession.sChat == null || BoldChatSession.sCurrentState != BoldChatState.ChatActive && BoldChatSession.sCurrentState != BoldChatState.ChatInactive) goto _L2; else goto _L1
_L1:
            List list = BoldChatSession.sChat.getChatHistory();
            list;
            JVM INSTR monitorenter ;
            Message message;
            for (Iterator iterator = list.iterator(); iterator.hasNext(); addMessage(message, false))
            {
                message = (Message)iterator.next();
            }

            break MISSING_BLOCK_LABEL_85;
            Exception exception;
            exception;
            list;
            JVM INSTR monitorexit ;
            throw exception;
            list;
            JVM INSTR monitorexit ;
_L2:
            setStatus(BoldChatSession.sStatus);
            return;
        }

        public void onAutoMessage(String s)
        {
            if (BoldChatSession.sChat != null && BoldChatSession.sChat.getAnswered() == null && BoldChatSession.sChat.getEnded() == null)
            {
                setStatus(s);
            }
        }

        public void onChatCreateFailed(int i, String s)
        {
            BoldChatSession boldchatsession = BoldChatSession.this;
            if (i == -100)
            {
                s = getBranding("api#generic#network_failed");
            }
            boldchatsession.fatalError(s);
        }

        public void onChatCreated(PreChat prechat, Chat chat)
        {
            BoldChatSession.sChat = chat;
            mViewManager.setBrandings(BoldChatSession.sChat.getBrandings());
            setListener(mBoldChatSessionListener);
            if (mBoldChatSessionListener != null)
            {
                runMain(new Runnable() {

                    final CallBackListeners this$1;

                    public void run()
                    {
                        mBoldChatSessionListener.chatSessionCreated();
                    }

            
            {
                this$1 = CallBackListeners.this;
                super();
            }
                });
            }
            if (prechat == null)
            {
                mViewManager.setState(BoldChatState.ChatActive);
                setStatus(getBranding("api#chat#waiting_for_operator"));
                chat.startChat(this);
            } else
            {
                showForm(com.boldchat.sdk.BoldChatState.PreChat, getBranding("api#prechat#intro"), "api#prechat#intro", getBranding("api#prechat#start"), "api#prechat#start", prechat, chat. new BoldChatFormView.SubmitListener() {

                    final CallBackListeners this$1;
                    final Chat val$chat;

                    public void onFormSubmit(Form form)
                    {
                        setStatus(getBranding("api#chat#waiting_for_operator"));
                        mViewManager.setState(BoldChatState.PreChatSending);
                        chat.submitPreChat(form, mCallBackListener);
                        if (onPreChatFormSubmitListener != null)
                        {
                            onPreChatFormSubmitListener.onPreChatFormSubmit();
                        }
                    }

            
            {
                this$1 = final_callbacklisteners;
                chat = Chat.this;
                super();
            }
                });
            }
            if (mChatPinger == null)
            {
                mChatPinger = new ChatPinger(chat);
                (new Thread(mChatPinger)).start();
            }
        }

        public void onChatFatalError(int i, String s)
        {
            if (i == -100)
            {
                setStatus(getBranding("api#generic#network_failed"));
            } else
            {
                setStatus(s);
            }
            endChat(false);
        }

        public void onChatFinished(PostChat postchat)
        {
            if (postchat == null)
            {
                mViewManager.setState(BoldChatState.Finished);
                closeChat();
                return;
            }
            String s1 = getBranding("api#postchat#intro");
            FormField formfield = postchat.getFormField("email");
            String s = s1;
            if (formfield != null)
            {
                formfield.setAdditionalHeading(getBranding("api#email#transcript"));
                formfield.setFloatToTop(true);
                s = s1;
                if (postchat.getFormFields().size() == 1)
                {
                    s = null;
                }
            }
            showForm(com.boldchat.sdk.BoldChatState.PostChat, s, getBranding("api#chat#close"), postchat, new BoldChatFormView.SubmitListener() {

                final CallBackListeners this$1;

                public void onFormSubmit(Form form)
                {
                    mViewManager.setState(BoldChatState.PostChatSending);
                    BoldChatSession.sChat.submitPostChat(form, CallBackListeners.this);
                }

            
            {
                this$1 = CallBackListeners.this;
                super();
            }
            });
        }

        public void onChatStartFailed(int i, String s)
        {
            if (mViewManager.getTypingTextView() != null)
            {
                mViewManager.getTypingTextView().setVisibility(8);
            }
            mViewManager.setState(BoldChatState.ChatInactive);
            setStatus(s);
            endChat(false);
        }

        public void onChatStarted()
        {
            mViewManager.setState(BoldChatState.ChatActive);
            mViewManager.setBrandings(BoldChatSession.sChat.getBrandings());
            runMain(new Runnable() {

                final CallBackListeners this$1;

                public void run()
                {
                    if (mBoldChatSessionListener != null)
                    {
                        mBoldChatSessionListener.chatSessionStarted();
                    }
                    if (mViewManager.getMessageInputField() != null)
                    {
                        mViewManager.getMessageInputField().setHint(getBranding("api#chat#send_message"));
                    }
                    if (mViewManager.getEndChatMenuItem() != null)
                    {
                        mViewManager.getEndChatMenuItem().setTitle(getBranding("api#chat#end"));
                    }
                    if (mViewManager.getEndButton() != null)
                    {
                        mViewManager.getEndButton().setText(getBranding("api#chat#end"));
                    }
                }

            
            {
                this$1 = CallBackListeners.this;
                super();
            }
            });
        }

        public void onChatUnavailable(Chat chat, UnavailableReason unavailablereason, UnavailableForm unavailableform, Map map)
        {
            BoldChatSession.sChat = chat;
            onChatUnavailable(unavailablereason, unavailableform);
        }

        public void onChatUnavailable(UnavailableForm unavailableform)
        {
            String s;
            if (unavailableform.getFormFields() == null || unavailableform.getFormFields().size() == 0)
            {
                s = "api#unavailable#no_operators";
            } else
            {
                s = "api#unavailable#intro";
            }
            showForm(BoldChatState.UnavailableChat, getBranding(s), getBranding("api#chat#send"), unavailableform, unavailableform. new BoldChatFormView.SubmitListener() {

                final CallBackListeners this$1;
                final UnavailableForm val$unavailableForm;

                public void onFormSubmit(Form form)
                {
                    BoldChatSession.sChat.submitUnavailableEmail(unavailableForm);
                    showForm(BoldChatState.Finished, getBranding("api#unavailable#emailed"), getBranding("api#chat#close"), null, new BoldChatFormView.SubmitListener() {

                        final CallBackListeners._cls11 this$2;

                        public void onFormSubmit(Form form)
                        {
                            closeChat();
                        }

            
            {
                this$2 = CallBackListeners._cls11.this;
                super();
            }
                    });
                }

            
            {
                this$1 = final_callbacklisteners;
                unavailableForm = UnavailableForm.this;
                super();
            }
            });
        }

        public void onChatUnavailable(UnavailableReason unavailablereason, UnavailableForm unavailableform)
        {
            String s;
label0:
            {
                String s1 = "api#unavailable#intro";
                s = s1;
                if (unavailablereason == null)
                {
                    break label0;
                }
                if (unavailableform != null && unavailableform.getFormFields() != null)
                {
                    s = s1;
                    if (unavailableform.getFormFields().size() != 0)
                    {
                        break label0;
                    }
                }
                static class _cls8
                {

                    static final int $SwitchMap$com$boldchat$visitor$api$UnavailableReason[];

                    static 
                    {
                        $SwitchMap$com$boldchat$visitor$api$UnavailableReason = new int[UnavailableReason.values().length];
                        try
                        {
                            $SwitchMap$com$boldchat$visitor$api$UnavailableReason[UnavailableReason.Unsecure.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror) { }
                    }
                }

                switch (_cls8..SwitchMap.com.boldchat.visitor.api.UnavailableReason[unavailablereason.ordinal()])
                {
                default:
                    s = "api#unavailable#no_operators";
                    break;

                case 1: // '\001'
                    break MISSING_BLOCK_LABEL_138;
                }
            }
_L1:
            if (unavailableform != null && unavailableform.getFormFields() != null && unavailableform.getFormFields().size() > 0)
            {
                showForm(BoldChatState.UnavailableChat, getBranding(s), getBranding("api#chat#send"), unavailableform, unavailableform. new BoldChatFormView.SubmitListener() {

                    final CallBackListeners this$1;
                    final UnavailableForm val$unavailableForm;

                    public void onFormSubmit(Form form)
                    {
                        mViewManager.setState(BoldChatState.UnavailableChatSending);
                        BoldChatSession.sChat.submitUnavailableEmail(unavailableForm);
                        showForm(BoldChatState.Finished, getBranding("api#unavailable#emailed"), getBranding("api#chat#close"), null, new BoldChatFormView.SubmitListener() {

                            final CallBackListeners._cls4 this$2;

                            public void onFormSubmit(Form form)
                            {
                                closeChat();
                            }

            
            {
                this$2 = CallBackListeners._cls4.this;
                super();
            }
                        });
                    }

            
            {
                this$1 = final_callbacklisteners;
                unavailableForm = UnavailableForm.this;
                super();
            }
                });
            } else
            {
                showForm(BoldChatState.Finished, getBranding(s), getBranding("api#chat#close"), unavailableform, new BoldChatFormView.SubmitListener() {

                    final CallBackListeners this$1;

                    public void onFormSubmit(Form form)
                    {
                        closeChat();
                    }

            
            {
                this$1 = CallBackListeners.this;
                super();
            }
                });
            }
            endChat(false);
            return;
            s = "api#unsecure#message";
              goto _L1
        }

        public void onChatUnavailableFailed(int i, String s)
        {
            BoldChatSession boldchatsession = BoldChatSession.this;
            if (i == -100)
            {
                s = getBranding("api#generic#network_failed");
            }
            boldchatsession.fatalError(s);
        }

        public void onChatUpdated(Chat chat)
        {
            if (mVisitorID <= 0L && chat.getVisitorID() > 0L)
            {
                mVisitorID = chat.getVisitorID();
                android.content.SharedPreferences.Editor editor = mSharedPrefs.edit();
                editor.putLong(getVisitorKey(), mVisitorID);
                editor.apply();
            }
            if (chat.isEnded())
            {
                if (chat.getEndedReason() == EndedReason.Operator)
                {
                    setStatus(getBranding("api#chat#operator_ended"));
                } else
                {
                    setStatus(getBranding("api#chat#ended"));
                }
                if (BoldChatSession.sCurrentState == BoldChatState.ChatActive)
                {
                    endChat(false);
                }
            } else
            if (BoldChatSession.sCurrentState == BoldChatState.ChatActive && chat.getAnswered() != null)
            {
                updateTypingLabel();
                setStatus(null);
                return;
            }
        }

        public void onClick(View view)
        {
            if (view.getId() != R.id.bc_send_button) goto _L2; else goto _L1
_L1:
            send();
            if (mHideKeyboardOnSend)
            {
                runMain(new Runnable() {

                    final CallBackListeners this$1;

                    public void run()
                    {
                        EditText edittext = mViewManager.getMessageInputField();
                        edittext.clearFocus();
                        ((InputMethodManager)mContext.getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
                    }

            
            {
                this$1 = CallBackListeners.this;
                super();
            }
                });
            }
_L4:
            return;
_L2:
            if (view.getId() != R.id.bc_end_chat)
            {
                continue; /* Loop/switch isn't completed */
            }
            endChat(true);
            if (mChatPinger == null) goto _L4; else goto _L3
_L3:
            mChatPinger.stopRunning();
            return;
            if (view.getId() != R.id.bc_close_button) goto _L4; else goto _L5
_L5:
            if (BoldChatSession.sChat != null && BoldChatSession.sChat.getStarted() != null)
            {
                endChat(true);
                return;
            }
            if (BoldChatSession.sCurrentState == BoldChatState.ChatInactive)
            {
                BoldChatSession.sCurrentState = BoldChatState.Finished;
            }
            closeChat();
            return;
        }

        public void onMessageAdded(Message message)
        {
            if (message.getPersonType() == PersonType.Operator && mBoldChatSessionListener != null)
            {
                runMain(message. new Runnable() {

                    final CallBackListeners this$1;
                    final Message val$message;

                    public void run()
                    {
                        mBoldChatSessionListener.messageArrived(message.getText(), message.getName(), message.getCreated());
                    }

            
            {
                this$1 = final_callbacklisteners;
                message = Message.this;
                super();
            }
                });
            }
            addMessage(message, false);
        }

        public void onPostChatSubmitFailed(Form form, String s)
        {
            showForm(BoldChatState.Finished, s, getBranding("api#chat#close"), null, new BoldChatFormView.SubmitListener() {

                final CallBackListeners this$1;

                public void onFormSubmit(Form form)
                {
                    closeChat();
                }

            
            {
                this$1 = CallBackListeners.this;
                super();
            }
            });
        }

        public void onPostChatSubmitted(Form form)
        {
            boolean flag;
            boolean flag1;
label0:
            {
                FormField formfield = form.getFormField("email");
                Object obj;
                boolean flag2;
                if (formfield != null && !TextUtils.isEmpty(formfield.getValue()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag2 = false;
                flag1 = flag2;
                if (form.getFormFields() == null)
                {
                    break label0;
                }
                form = form.getFormFields().iterator();
                do
                {
                    flag1 = flag2;
                    if (!form.hasNext())
                    {
                        break label0;
                    }
                    obj = (FormField)form.next();
                } while (TextUtils.isEmpty(((FormField) (obj)).getValue()) || obj == formfield);
                flag1 = true;
            }
            form = "api#chat#ended";
            if (!flag || flag1) goto _L2; else goto _L1
_L1:
            form = "api#postchat#emailed";
_L4:
            obj = getBranding(form);
            form = ((Form) (obj));
            if (flag)
            {
                form = (new StringBuilder()).append(((String) (obj))).append(" ").append(formfield.getValue()).toString();
            }
            showForm(BoldChatState.Finished, form, getBranding("api#chat#close"), null, new BoldChatFormView.SubmitListener() {

                final CallBackListeners this$1;

                public void onFormSubmit(Form form)
                {
                    closeChat();
                }

            
            {
                this$1 = CallBackListeners.this;
                super();
            }
            });
            return;
_L2:
            if (flag && flag1)
            {
                form = "api#postchat#submitted_and_emailed";
            } else
            if (flag1)
            {
                form = "api#postchat#submitted";
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void onPreliminaryMessageAdded(Message message)
        {
            addMessage(message, true);
        }

        public void onTyperUpdated(Typer typer)
        {
            updateTypingLabel();
        }

        public void onUpdateQueue(int i, boolean flag)
        {
            if (mViewManager.getTypingTextView() == null || i <= 0) goto _L2; else goto _L1
_L1:
            String s = (new StringBuilder()).append(getBranding("api#chat#queue_position")).append(" ").append(i).toString();
            if (!flag) goto _L4; else goto _L3
_L3:
            setTypingText(RichTextUtils.replaceAll(Html.fromHtml((new StringBuilder()).append(s).append(" (<a href=\"#cancel_queue\">").append(getBranding("api#chat#unavailable_email")).append("</a>)").toString()), android/text/style/URLSpan, new URLSpanConverter()));
_L6:
            return;
_L4:
            setTypingText(Html.fromHtml((new StringBuilder()).append(getBranding("api#chat#queue_position")).append(" ").append(i).toString()));
            return;
_L2:
            if (i == 0)
            {
                setTypingText(null);
                return;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        private CallBackListeners()
        {
            this$0 = BoldChatSession.this;
            super();
        }

    }

    private class ChatAvailabilityWrapper
        implements ChatAvailabilityListener
    {

        ChatAvailabilityListener mAvailabilityListener;
        final BoldChatSession this$0;

        public void onChatAvailabilityFailed(final int failType, String s)
        {
            if (mAvailabilityListener != null)
            {
                runMain(s. new Runnable() {

                    final ChatAvailabilityWrapper this$1;
                    final int val$failType;
                    final String val$message;

                    public void run()
                    {
                        mAvailabilityListener.onChatAvailabilityFailed(failType, message);
                    }

            
            {
                this$1 = final_chatavailabilitywrapper;
                failType = i;
                message = String.this;
                super();
            }
                });
            }
        }

        public void onChatAvailable()
        {
            if (mAvailabilityListener != null)
            {
                runMain(new Runnable() {

                    final ChatAvailabilityWrapper this$1;

                    public void run()
                    {
                        mAvailabilityListener.onChatAvailable();
                    }

            
            {
                this$1 = ChatAvailabilityWrapper.this;
                super();
            }
                });
            }
        }

        public void onChatUnavailable(UnavailableReason unavailablereason)
        {
            if (mAvailabilityListener != null)
            {
                runMain(unavailablereason. new Runnable() {

                    final ChatAvailabilityWrapper this$1;
                    final UnavailableReason val$unavailableReason;

                    public void run()
                    {
                        mAvailabilityListener.onChatUnavailable(unavailableReason);
                    }

            
            {
                this$1 = final_chatavailabilitywrapper;
                unavailableReason = UnavailableReason.this;
                super();
            }
                });
            }
        }

        public ChatAvailabilityWrapper(ChatAvailabilityListener chatavailabilitylistener)
        {
            this$0 = BoldChatSession.this;
            super();
            mAvailabilityListener = chatavailabilitylistener;
        }
    }

    public static interface ChatFormListener
    {

        public abstract boolean onFormShow(Form form);
    }

    private class ChatPinger
        implements Runnable
    {

        private Chat mChat;
        private long mLastPing;
        private boolean mRunning;
        final BoldChatSession this$0;

        public void run()
        {
_L3:
            long l;
            if (!mRunning || mChat == null || mChatPinger != this || BoldChatSession.sCurrentState.ordinal() > BoldChatState.ChatActive.ordinal())
            {
                break MISSING_BLOCK_LABEL_311;
            }
            l = 5000L;
            if (mChat != null && mLastPing + 30000L > System.currentTimeMillis())
            {
                Log.d("BOLD", "Pinging Chat");
                mLastPing = System.currentTimeMillis();
                mChat.pingChat(false, null);
            }
            if (BoldChatSession.sCurrentState == BoldChatState.ChatActive && mChat != null && mChat.getAnswerTimeout() > 0 && mChat.getStarted() != null && mChat.getAnswered() == null && System.currentTimeMillis() > mChat.getStarted().getTime() + (long)(mChat.getAnswerTimeout() * 1000))
            {
                stopRunning();
                mViewManager.setState(BoldChatState.ChatInactive);
                mChat.getUnavailableForm(mCallBackListener);
            }
            if (mChat != null && mChat.getStarted() != null && mChat.getAnswered() != null && mChat.getEnded() == null && mChat.isTimedOut())
            {
                endChat(false);
                setStatus(getBranding("api#chat#disconnected"));
                stopRunning();
            }
            if (mChat.getAnswered() != null)
            {
                l = 30000L;
            }
            this;
            JVM INSTR monitorenter ;
            wait(l);
_L1:
            this;
            JVM INSTR monitorexit ;
            continue; /* Loop/switch isn't completed */
            Object obj;
            obj;
            this;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            ((InterruptedException) (obj)).printStackTrace();
              goto _L1
            Log.d("BOLD", "Chat pinger stopped");
            return;
            if (true) goto _L3; else goto _L2
_L2:
        }

        public void stopRunning()
        {
            mRunning = false;
            this;
            JVM INSTR monitorenter ;
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public ChatPinger(Chat chat)
        {
            this$0 = BoldChatSession.this;
            super();
            mRunning = true;
            mLastPing = 0L;
            mChat = chat;
        }
    }

    private class LinkActionSpan extends ClickableSpan
    {

        private String mUrl;
        final BoldChatSession this$0;

        public void onClick(View view)
        {
            if ("#cancel_queue".equals(mUrl))
            {
                mChatPinger.stopRunning();
                mViewManager.setState(BoldChatState.ChatEnding);
                if (BoldChatSession.sChat != null)
                {
                    BoldChatSession.sChat.getUnavailableForm(mCallBackListener);
                }
            }
        }

        public LinkActionSpan(String s)
        {
            this$0 = BoldChatSession.this;
            super();
            mUrl = s;
        }
    }

    private class MessageInputFocusListener
        implements android.view.View.OnFocusChangeListener
    {

        final BoldChatSession this$0;

        public void onFocusChange(View view, boolean flag)
        {
            if (flag)
            {
                mHistoryView.scrollToBottom();
            }
        }

        private MessageInputFocusListener()
        {
            this$0 = BoldChatSession.this;
            super();
        }

    }

    private class TypingListener
        implements TextWatcher, android.view.View.OnKeyListener
    {

        final BoldChatSession this$0;

        public void afterTextChanged(Editable editable)
        {
            if (BoldChatSession.sChat != null)
            {
                Chat chat = BoldChatSession.sChat;
                boolean flag;
                if (!TextUtils.isEmpty(editable.toString()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                chat.setVisitorTyping(flag);
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            if (i == 66 && !keyevent.isShiftPressed())
            {
                send();
                return true;
            } else
            {
                return false;
            }
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private TypingListener()
        {
            this$0 = BoldChatSession.this;
            super();
        }

    }

    private class URLSpanConverter
        implements com.boldchat.sdk.utils.RichTextUtils.SpanConverter
    {

        final BoldChatSession this$0;

        public volatile CharacterStyle convert(CharacterStyle characterstyle)
        {
            return convert((URLSpan)characterstyle);
        }

        public LinkActionSpan convert(URLSpan urlspan)
        {
            return new LinkActionSpan(urlspan.getURL());
        }

        private URLSpanConverter()
        {
            this$0 = BoldChatSession.this;
            super();
        }

    }


    private static Account sAccount;
    private static Chat sChat;
    private static BoldChatState sCurrentState;
    private static PersistedChat sPersistedChat = null;
    private static String sPersistedMessageText = null;
    private static String sStatus = null;
    private String mApiKey;
    private BoldChatSessionListener mBoldChatSessionListener;
    private CallBackListeners mCallBackListener;
    private ChatFormListener mChatFormListener;
    private ChatPinger mChatPinger;
    private Context mContext;
    private boolean mHideKeyboardOnSend;
    private BoldChatHistory mHistoryView;
    private boolean mPageIsLoaded;
    private SharedPreferences mSharedPrefs;
    private DateFormat mTimeFormat;
    private BoldChatViewManager mViewManager;
    private long mVisitorID;
    private OnPreChatFormSubmitListener onPreChatFormSubmitListener;

    private BoldChatSession()
    {
        mVisitorID = -1L;
        mChatPinger = null;
        mHideKeyboardOnSend = false;
        mTimeFormat = new SimpleDateFormat("h:mm a");
        mSharedPrefs = null;
        mPageIsLoaded = false;
        mCallBackListener = new CallBackListeners();
    }


    private void addMessage(Message message, boolean flag)
    {
        if (mHistoryView != null)
        {
            String s = message.getText();
            Object obj1 = mTimeFormat;
            Object obj;
            String s1;
            String s2;
            Typer typer;
            if (message.getCreated() == null)
            {
                obj = new Date();
            } else
            {
                obj = message.getCreated();
            }
            s1 = ((DateFormat) (obj1)).format(((Date) (obj)));
            s2 = TextUtils.htmlEncode(message.getName());
            obj1 = null;
            typer = (Typer)sChat.getTypers().get(Long.valueOf(message.getPersonID()));
            obj = obj1;
            if (typer != null)
            {
                obj = obj1;
                if (typer.getImageURL() != null)
                {
                    obj = TextUtils.htmlEncode(typer.getImageURL());
                }
            }
            obj1 = s;
            if (flag)
            {
                obj1 = TextUtils.htmlEncode(s).replace("\n", "\n<br />");
            }
            mHistoryView.addMessage(((String) (obj1)), message.getPersonType(), message.getMessageID(), s1, s2, ((String) (obj)));
        }
    }

    private void fatalError(final String error)
    {
        runMain(new Runnable() {

            final BoldChatSession this$0;
            final String val$error;

            public void run()
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mContext);
                builder.setMessage(error);
                builder.setPositiveButton(R.string.api_generic_ok, new android.content.DialogInterface.OnClickListener() {

                    final _cls7 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        endChat(false);
                        closeChat();
                    }

            
            {
                this$1 = _cls7.this;
                super();
            }
                });
                try
                {
                    builder.show();
                    return;
                }
                catch (Exception exception)
                {
                    Log.e("BOlD", (new StringBuilder()).append("Failed to show error: ").append(error).toString(), exception);
                    try
                    {
                        closeChat();
                        return;
                    }
                    catch (Exception exception1)
                    {
                        Log.e("BOlD", (new StringBuilder()).append("Failed to close the chat after error: ").append(error).toString(), exception);
                    }
                    return;
                }
            }

            
            {
                this$0 = BoldChatSession.this;
                error = s;
                super();
            }
        });
    }

    private String getBranding(String s)
    {
        Map map;
        if (sChat != null)
        {
            map = sChat.getBrandings();
        } else
        {
            map = null;
        }
        return getBranding(s, map, mContext);
    }

    protected static String getBranding(String s, Map map, Context context)
    {
        String s1 = null;
        if (map != null)
        {
            s1 = (String)map.get(s);
        }
        if (s1 == null)
        {
            map = s.replace('#', '_');
            try
            {
                context = context.getString(context.getResources().getIdentifier(map, "string", context.getPackageName()));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.w("BOLD", (new StringBuilder()).append("Missing string resource for ").append(map).toString());
                return s;
            }
            return context;
        } else
        {
            return s1;
        }
    }

    private String getVersion()
    {
        String s;
        try
        {
            s = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 128).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.e("BOLD", "Name not found", namenotfoundexception);
            return "0";
        }
        return s;
    }

    private String getVisitorKey()
    {
        return (new StringBuilder()).append("bc_VisitorID_").append(String.valueOf(mApiKey.hashCode())).toString();
    }

    private boolean isInternetPermissionAvailable()
    {
        return mContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    private void runMain(Runnable runnable)
    {
        runMain(runnable, mContext);
    }

    protected static void runMain(Runnable runnable, Context context)
    {
        (new Handler(context.getMainLooper())).post(runnable);
    }

    private void send()
    {
        EditText edittext = mViewManager.getMessageInputField();
        String s = edittext.getText().toString();
        if (edittext != null && !TextUtils.isEmpty(s))
        {
            edittext.setText("");
            if (sChat != null && !TextUtils.isEmpty(s.trim()))
            {
                sChat.sendMessage(s);
            }
        }
    }

    protected static void setCurrentState(BoldChatState boldchatstate)
    {
        sCurrentState = boldchatstate;
    }

    private void setStatus(String s)
    {
        sStatus = s;
        if (mHistoryView != null && mPageIsLoaded)
        {
            mHistoryView.setStatus(s);
        }
    }

    private void setTypingText(final Spanned text)
    {
        if (mViewManager != null)
        {
            final TextView typingView = mViewManager.getTypingTextView();
            if (typingView != null)
            {
                runMain(new Runnable() {

                    final BoldChatSession this$0;
                    final Spanned val$text;
                    final TextView val$typingView;

                    public void run()
                    {
                        if (!TextUtils.isEmpty(text))
                        {
                            typingView.setText(text);
                            typingView.setVisibility(0);
                            return;
                        } else
                        {
                            typingView.setText("");
                            typingView.setVisibility(4);
                            return;
                        }
                    }

            
            {
                this$0 = BoldChatSession.this;
                text = spanned;
                typingView = textview;
                super();
            }
                });
            }
        }
    }

    private void showForm(BoldChatState boldchatstate, String s, String s1, Form form, BoldChatFormView.SubmitListener submitlistener)
    {
        showForm(boldchatstate, s, null, s1, null, form, submitlistener);
    }

    private void showForm(final BoldChatState state, final String title, final String titleKey, final String submit, final String submitKey, final Form form, final BoldChatFormView.SubmitListener submitListener)
    {
        runMain(new Runnable() {

            final BoldChatSession this$0;
            final Form val$form;
            final BoldChatState val$state;
            final String val$submit;
            final String val$submitKey;
            final BoldChatFormView.SubmitListener val$submitListener;
            final String val$title;
            final String val$titleKey;

            public void run()
            {
                boolean flag = true;
                if (mChatFormListener != null)
                {
                    if (mChatFormListener.onFormShow(form) && true)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
                if (flag)
                {
                    BoldChatFormView boldchatformview = new BoldChatFormView(title, titleKey, submit, submitKey, form, submitListener, mContext, BoldChatSession.sChat);
                    mViewManager.setState(state, boldchatformview);
                } else
                if (submitListener != null)
                {
                    mViewManager.setState(state);
                    submitListener.onFormSubmit(form);
                    return;
                }
            }

            
            {
                this$0 = BoldChatSession.this;
                form = form1;
                title = s;
                titleKey = s1;
                submit = s2;
                submitKey = s3;
                submitListener = submitlistener;
                state = boldchatstate;
                super();
            }
        });
    }

    private void updateTypingLabel()
    {
        if (sChat == null || sChat.getAnswered() == null) goto _L2; else goto _L1
_L1:
        Object obj;
        StringBuilder stringbuilder;
        int i;
        i = 0;
        stringbuilder = new StringBuilder();
        obj = null;
        Object obj2 = sChat.getTypers();
        obj2;
        JVM INSTR monitorenter ;
        Iterator iterator = ((Map) (obj2)).values().iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        Typer typer = (Typer)iterator.next();
        if (typer.getPersonType() != PersonType.Operator || !typer.isTyping()) goto _L6; else goto _L5
_L5:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        Object obj1;
        if (i > 1)
        {
            obj1 = ", ";
        } else
        {
            obj1 = "";
        }
        stringbuilder.append(((String) (obj1))).append(((String) (obj)));
        if (!TextUtils.isEmpty(typer.getName()))
        {
            obj = typer.getName();
            break MISSING_BLOCK_LABEL_291;
        }
        obj = getBranding("api#chat#operator");
        break MISSING_BLOCK_LABEL_291;
_L4:
        obj2;
        JVM INSTR monitorexit ;
        if (obj != null)
        {
            obj2 = stringbuilder.append(' ');
            if (i > 1)
            {
                obj1 = getBranding("api#chat#and_conjuction");
            } else
            {
                obj1 = "";
            }
            ((StringBuilder) (obj2)).append(((String) (obj1))).append(' ').append(((String) (obj)));
        }
        if (i > 0)
        {
            stringbuilder.insert(0, "<b>");
            obj1 = stringbuilder.append("</b> ");
            if (i > 1)
            {
                obj = getBranding("api#chat#are_typing");
            } else
            {
                obj = getBranding("api#chat#is_typing");
            }
            ((StringBuilder) (obj1)).append(((String) (obj)));
            if (mBoldChatSessionListener != null)
            {
                runMain(new Runnable() {

                    final BoldChatSession this$0;

                    public void run()
                    {
                        mBoldChatSessionListener.operatorTyping();
                    }

            
            {
                this$0 = BoldChatSession.this;
                super();
            }
                });
            }
        }
        setTypingText(Html.fromHtml(stringbuilder.toString()));
_L2:
        return;
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
        i++;
          goto _L6
    }

    public void addMenuItems(MenuInflater menuinflater, Menu menu)
    {
        mViewManager.addMenuItems(menuinflater, menu);
    }

    public void closeChat()
    {
        if (mChatPinger != null)
        {
            mChatPinger.stopRunning();
        }
        sChat = null;
        if (mBoldChatSessionListener != null)
        {
            runMain(new Runnable() {

                final BoldChatSession this$0;

                public void run()
                {
                    mBoldChatSessionListener.chatSessionClosed();
                }

            
            {
                this$0 = BoldChatSession.this;
                super();
            }
            });
        }
    }

    public void endChat(boolean flag)
    {
        if (mChatPinger != null)
        {
            mChatPinger.stopRunning();
        }
        if (mViewManager == null || !flag || sCurrentState != BoldChatState.ChatActive && sCurrentState != BoldChatState.ChatInactive) goto _L2; else goto _L1
_L1:
        mViewManager.setState(BoldChatState.ChatEnding);
        sChat.finishChat(mCallBackListener);
_L4:
        runMain(new Runnable() {

            final BoldChatSession this$0;

            public void run()
            {
                if (mBoldChatSessionListener != null)
                {
                    mBoldChatSessionListener.chatSessionEnded();
                }
            }

            
            {
                this$0 = BoldChatSession.this;
                super();
            }
        });
        return;
_L2:
        if (!flag && sCurrentState == BoldChatState.ChatActive)
        {
            if (mViewManager != null)
            {
                mViewManager.setState(BoldChatState.ChatInactive);
            } else
            {
                sCurrentState = BoldChatState.ChatInactive;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void getChatAvailability(ChatAvailabilityListener chatavailabilitylistener)
    {
        sAccount.getChatAvailability(new ChatAvailabilityWrapper(chatavailabilitylistener));
    }

    public boolean isChatActive()
    {
        return sCurrentState == BoldChatState.ChatActive || sCurrentState == BoldChatState.ChatInactive;
    }

    public boolean menuItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == R.id.bc_end_chat)
        {
            endChat(true);
            return true;
        } else
        {
            return false;
        }
    }

    public void removeListener()
    {
        mChatFormListener = null;
        if (sChat != null)
        {
            sChat.removeChatListener(mCallBackListener);
            sChat.removeTyperListener(mCallBackListener);
            sChat.removeMessageListener(mCallBackListener);
            sChat.removeQueueListener(mCallBackListener);
        }
        if (mViewManager != null && mViewManager.getMessageInputField() != null)
        {
            sPersistedMessageText = mViewManager.getMessageInputField().getText().toString();
        }
    }

    public void setChatFormListener(ChatFormListener chatformlistener)
    {
        mChatFormListener = chatformlistener;
    }

    public void setListener(BoldChatSessionListener boldchatsessionlistener)
    {
        mBoldChatSessionListener = boldchatsessionlistener;
        if (sChat != null)
        {
            sChat.addChatListener(mCallBackListener);
            sChat.addTyperListener(mCallBackListener);
            sChat.addMessageListener(mCallBackListener);
            sChat.addQueueListener(mCallBackListener);
        }
    }

    public BoldChatSession setOnPreChatFormSubmitListener(OnPreChatFormSubmitListener onprechatformsubmitlistener)
    {
        onPreChatFormSubmitListener = onprechatformsubmitlistener;
        return this;
    }

    public void start()
    {
        if (!isInternetPermissionAvailable())
        {
            Toast.makeText(mContext, mContext.getString(R.string.bc_no_internet_permission), 1).show();
            closeChat();
        } else
        if (mViewManager == null || sChat == null || sCurrentState != com.boldchat.sdk.BoldChatState.PreChat && sCurrentState != com.boldchat.sdk.BoldChatState.PostChat && sCurrentState != BoldChatState.UnavailableChat)
        {
            if (mViewManager != null && sCurrentState != BoldChatState.ChatActive && sCurrentState != BoldChatState.ChatInactive)
            {
                mViewManager.setState(BoldChatState.InitialLoading);
                sChat = null;
                if (mPageIsLoaded)
                {
                    mHistoryView.clearChatHistory();
                }
                sAccount.createChat(mCallBackListener, true);
                return;
            }
            if (sChat != null && sCurrentState == BoldChatState.ChatActive && sChat.isEnded() && mViewManager != null)
            {
                setStatus(getBranding("api#chat#ended"));
                endChat(false);
                return;
            }
        }
    }

    static 
    {
        sCurrentState = BoldChatState.Idle;
    }




/*
    static SharedPreferences access$1102(BoldChatSession boldchatsession, SharedPreferences sharedpreferences)
    {
        boldchatsession.mSharedPrefs = sharedpreferences;
        return sharedpreferences;
    }

*/



/*
    static BoldChatHistory access$1202(BoldChatSession boldchatsession, BoldChatHistory boldchathistory)
    {
        boldchatsession.mHistoryView = boldchathistory;
        return boldchathistory;
    }

*/




/*
    static Account access$1402(Account account)
    {
        sAccount = account;
        return account;
    }

*/



/*
    static BoldChatState access$1502(BoldChatState boldchatstate)
    {
        sCurrentState = boldchatstate;
        return boldchatstate;
    }

*/



/*
    static String access$1602(String s)
    {
        sPersistedMessageText = s;
        return s;
    }

*/





/*
    static long access$2002(BoldChatSession boldchatsession, long l)
    {
        boldchatsession.mVisitorID = l;
        return l;
    }

*/




/*
    static ChatPinger access$2202(BoldChatSession boldchatsession, ChatPinger chatpinger)
    {
        boldchatsession.mChatPinger = chatpinger;
        return chatpinger;
    }

*/











/*
    static Context access$302(BoldChatSession boldchatsession, Context context)
    {
        boldchatsession.mContext = context;
        return context;
    }

*/




/*
    static boolean access$3402(BoldChatSession boldchatsession, boolean flag)
    {
        boldchatsession.mPageIsLoaded = flag;
        return flag;
    }

*/




/*
    static Chat access$402(Chat chat)
    {
        sChat = chat;
        return chat;
    }

*/



/*
    static BoldChatViewManager access$502(BoldChatSession boldchatsession, BoldChatViewManager boldchatviewmanager)
    {
        boldchatsession.mViewManager = boldchatviewmanager;
        return boldchatviewmanager;
    }

*/




/*
    static String access$802(BoldChatSession boldchatsession, String s)
    {
        boldchatsession.mApiKey = s;
        return s;
    }

*/



/*
    static boolean access$902(BoldChatSession boldchatsession, boolean flag)
    {
        boldchatsession.mHideKeyboardOnSend = flag;
        return flag;
    }

*/
}
