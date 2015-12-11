// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.boldchat.sdk.utils.OnPreChatFormSubmitListener;
import com.boldchat.sdk.utils.RichTextUtils;
import com.boldchat.visitor.api.Chat;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatState, BoldChatViewManager

private class <init>
    implements android.view.ers, edListener, ChatFinishedListener, ChatListener, ChatMessageListener, ChatQueueListener, ChatStartListener, ChatTyperListener, ChatUnavailableListener, CreateChatListener, PostChatSubmitListener
{

    final BoldChatSession this$0;

    public void historyPageLoaded()
    {
        BoldChatSession.access$3402(BoldChatSession.this, true);
        if (BoldChatSession.access$400() == null || BoldChatSession.access$1500() != BoldChatState.ChatActive && BoldChatSession.access$1500() != BoldChatState.ChatInactive) goto _L2; else goto _L1
_L1:
        List list = BoldChatSession.access$400().getChatHistory();
        list;
        JVM INSTR monitorenter ;
        Message message;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); BoldChatSession.access$3100(BoldChatSession.this, message, false))
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
        BoldChatSession.access$2500(BoldChatSession.this, BoldChatSession.access$3500());
        return;
    }

    public void onAutoMessage(String s)
    {
        if (BoldChatSession.access$400() != null && BoldChatSession.access$400().getAnswered() == null && BoldChatSession.access$400().getEnded() == null)
        {
            BoldChatSession.access$2500(BoldChatSession.this, s);
        }
    }

    public void onChatCreateFailed(int i, String s)
    {
        BoldChatSession boldchatsession = BoldChatSession.this;
        if (i == -100)
        {
            s = BoldChatSession.access$600(BoldChatSession.this, "api#generic#network_failed");
        }
        BoldChatSession.access$2800(boldchatsession, s);
    }

    public void onChatCreated(PreChat prechat, final Chat chat)
    {
        Chat _tmp = BoldChatSession.access$402(chat);
        BoldChatSession.access$500(BoldChatSession.this).setBrandings(BoldChatSession.access$400().getBrandings());
        setListener(BoldChatSession.access$100(BoldChatSession.this));
        if (BoldChatSession.access$100(BoldChatSession.this) != null)
        {
            BoldChatSession.access$2400(BoldChatSession.this, new Runnable() {

                final BoldChatSession.CallBackListeners this$1;

                public void run()
                {
                    BoldChatSession.access$100(this$0).chatSessionCreated();
                }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
                super();
            }
            });
        }
        if (prechat == null)
        {
            BoldChatSession.access$500(BoldChatSession.this).setState(BoldChatState.ChatActive);
            BoldChatSession.access$2500(BoldChatSession.this, BoldChatSession.access$600(BoldChatSession.this, "api#chat#waiting_for_operator"));
            chat.startChat(this);
        } else
        {
            BoldChatSession.access$2700(BoldChatSession.this, com.boldchat.sdk.BoldChatState.PreChat, BoldChatSession.access$600(BoldChatSession.this, "api#prechat#intro"), "api#prechat#intro", BoldChatSession.access$600(BoldChatSession.this, "api#prechat#start"), "api#prechat#start", prechat, new BoldChatFormView.SubmitListener() {

                final BoldChatSession.CallBackListeners this$1;
                final Chat val$chat;

                public void onFormSubmit(Form form)
                {
                    BoldChatSession.access$2500(this$0, BoldChatSession.access$600(this$0, "api#chat#waiting_for_operator"));
                    BoldChatSession.access$500(this$0).setState(BoldChatState.PreChatSending);
                    chat.submitPreChat(form, BoldChatSession.access$1700(this$0));
                    if (BoldChatSession.access$2600(this$0) != null)
                    {
                        BoldChatSession.access$2600(this$0).onPreChatFormSubmit();
                    }
                }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
                chat = chat1;
                super();
            }
            });
        }
        if (BoldChatSession.access$2200(BoldChatSession.this) == null)
        {
            BoldChatSession.access$2202(BoldChatSession.this, new this._cls0(BoldChatSession.this, chat));
            (new Thread(BoldChatSession.access$2200(BoldChatSession.this))).start();
        }
    }

    public void onChatFatalError(int i, String s)
    {
        if (i == -100)
        {
            BoldChatSession.access$2500(BoldChatSession.this, BoldChatSession.access$600(BoldChatSession.this, "api#generic#network_failed"));
        } else
        {
            BoldChatSession.access$2500(BoldChatSession.this, s);
        }
        endChat(false);
    }

    public void onChatFinished(PostChat postchat)
    {
        if (postchat == null)
        {
            BoldChatSession.access$500(BoldChatSession.this).setState(BoldChatState.Finished);
            closeChat();
            return;
        }
        String s1 = BoldChatSession.access$600(BoldChatSession.this, "api#postchat#intro");
        FormField formfield = postchat.getFormField("email");
        String s = s1;
        if (formfield != null)
        {
            formfield.setAdditionalHeading(BoldChatSession.access$600(BoldChatSession.this, "api#email#transcript"));
            formfield.setFloatToTop(true);
            s = s1;
            if (postchat.getFormFields().size() == 1)
            {
                s = null;
            }
        }
        BoldChatSession.access$2900(BoldChatSession.this, com.boldchat.sdk.BoldChatState.PostChat, s, BoldChatSession.access$600(BoldChatSession.this, "api#chat#close"), postchat, new BoldChatFormView.SubmitListener() {

            final BoldChatSession.CallBackListeners this$1;

            public void onFormSubmit(Form form)
            {
                BoldChatSession.access$500(this$0).setState(BoldChatState.PostChatSending);
                BoldChatSession.access$400().submitPostChat(form, BoldChatSession.CallBackListeners.this);
            }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
                super();
            }
        });
    }

    public void onChatStartFailed(int i, String s)
    {
        if (BoldChatSession.access$500(BoldChatSession.this).getTypingTextView() != null)
        {
            BoldChatSession.access$500(BoldChatSession.this).getTypingTextView().setVisibility(8);
        }
        BoldChatSession.access$500(BoldChatSession.this).setState(BoldChatState.ChatInactive);
        BoldChatSession.access$2500(BoldChatSession.this, s);
        endChat(false);
    }

    public void onChatStarted()
    {
        BoldChatSession.access$500(BoldChatSession.this).setState(BoldChatState.ChatActive);
        BoldChatSession.access$500(BoldChatSession.this).setBrandings(BoldChatSession.access$400().getBrandings());
        BoldChatSession.access$2400(BoldChatSession.this, new Runnable() {

            final BoldChatSession.CallBackListeners this$1;

            public void run()
            {
                if (BoldChatSession.access$100(this$0) != null)
                {
                    BoldChatSession.access$100(this$0).chatSessionStarted();
                }
                if (BoldChatSession.access$500(this$0).getMessageInputField() != null)
                {
                    BoldChatSession.access$500(this$0).getMessageInputField().setHint(BoldChatSession.access$600(this$0, "api#chat#send_message"));
                }
                if (BoldChatSession.access$500(this$0).getEndChatMenuItem() != null)
                {
                    BoldChatSession.access$500(this$0).getEndChatMenuItem().setTitle(BoldChatSession.access$600(this$0, "api#chat#end"));
                }
                if (BoldChatSession.access$500(this$0).getEndButton() != null)
                {
                    BoldChatSession.access$500(this$0).getEndButton().setText(BoldChatSession.access$600(this$0, "api#chat#end"));
                }
            }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
                super();
            }
        });
    }

    public void onChatUnavailable(Chat chat, UnavailableReason unavailablereason, UnavailableForm unavailableform, Map map)
    {
        Chat _tmp = BoldChatSession.access$402(chat);
        onChatUnavailable(unavailablereason, unavailableform);
    }

    public void onChatUnavailable(final UnavailableForm unavailableForm)
    {
        String s;
        if (unavailableForm.getFormFields() == null || unavailableForm.getFormFields().size() == 0)
        {
            s = "api#unavailable#no_operators";
        } else
        {
            s = "api#unavailable#intro";
        }
        BoldChatSession.access$2900(BoldChatSession.this, BoldChatState.UnavailableChat, BoldChatSession.access$600(BoldChatSession.this, s), BoldChatSession.access$600(BoldChatSession.this, "api#chat#send"), unavailableForm, new BoldChatFormView.SubmitListener() {

            final BoldChatSession.CallBackListeners this$1;
            final UnavailableForm val$unavailableForm;

            public void onFormSubmit(Form form)
            {
                BoldChatSession.access$400().submitUnavailableEmail(unavailableForm);
                BoldChatSession.access$2900(this$0, BoldChatState.Finished, BoldChatSession.access$600(this$0, "api#unavailable#emailed"), BoldChatSession.access$600(this$0, "api#chat#close"), null, new BoldChatFormView.SubmitListener() {

                    final _cls11 this$2;

                    public void onFormSubmit(Form form)
                    {
                        closeChat();
                    }

            
            {
                this$2 = _cls11.this;
                super();
            }
                });
            }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
                unavailableForm = unavailableform;
                super();
            }
        });
    }

    public void onChatUnavailable(UnavailableReason unavailablereason, final UnavailableForm unavailableForm)
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
            if (unavailableForm != null && unavailableForm.getFormFields() != null)
            {
                s = s1;
                if (unavailableForm.getFormFields().size() != 0)
                {
                    break label0;
                }
            }
            switch (oldchat.visitor.api.UnavailableReason[unavailablereason.ordinal()])
            {
            default:
                s = "api#unavailable#no_operators";
                break;

            case 1: // '\001'
                break MISSING_BLOCK_LABEL_138;
            }
        }
_L1:
        if (unavailableForm != null && unavailableForm.getFormFields() != null && unavailableForm.getFormFields().size() > 0)
        {
            BoldChatSession.access$2900(BoldChatSession.this, BoldChatState.UnavailableChat, BoldChatSession.access$600(BoldChatSession.this, s), BoldChatSession.access$600(BoldChatSession.this, "api#chat#send"), unavailableForm, new BoldChatFormView.SubmitListener() {

                final BoldChatSession.CallBackListeners this$1;
                final UnavailableForm val$unavailableForm;

                public void onFormSubmit(Form form)
                {
                    BoldChatSession.access$500(this$0).setState(BoldChatState.UnavailableChatSending);
                    BoldChatSession.access$400().submitUnavailableEmail(unavailableForm);
                    BoldChatSession.access$2900(this$0, BoldChatState.Finished, BoldChatSession.access$600(this$0, "api#unavailable#emailed"), BoldChatSession.access$600(this$0, "api#chat#close"), null, new BoldChatFormView.SubmitListener() {

                        final _cls4 this$2;

                        public void onFormSubmit(Form form)
                        {
                            closeChat();
                        }

            
            {
                this$2 = _cls4.this;
                super();
            }
                    });
                }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
                unavailableForm = unavailableform;
                super();
            }
            });
        } else
        {
            BoldChatSession.access$2900(BoldChatSession.this, BoldChatState.Finished, BoldChatSession.access$600(BoldChatSession.this, s), BoldChatSession.access$600(BoldChatSession.this, "api#chat#close"), unavailableForm, new BoldChatFormView.SubmitListener() {

                final BoldChatSession.CallBackListeners this$1;

                public void onFormSubmit(Form form)
                {
                    closeChat();
                }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
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
            s = BoldChatSession.access$600(BoldChatSession.this, "api#generic#network_failed");
        }
        BoldChatSession.access$2800(boldchatsession, s);
    }

    public void onChatUpdated(Chat chat)
    {
        if (BoldChatSession.access$2000(BoldChatSession.this) <= 0L && chat.getVisitorID() > 0L)
        {
            BoldChatSession.access$2002(BoldChatSession.this, chat.getVisitorID());
            android.content.  = BoldChatSession.access$1100(BoldChatSession.this).edit();
            ._mth0(BoldChatSession.access$2100(BoldChatSession.this), BoldChatSession.access$2000(BoldChatSession.this));
            ._mth0();
        }
        if (chat.isEnded())
        {
            if (chat.getEndedReason() == EndedReason.Operator)
            {
                BoldChatSession.access$2500(BoldChatSession.this, BoldChatSession.access$600(BoldChatSession.this, "api#chat#operator_ended"));
            } else
            {
                BoldChatSession.access$2500(BoldChatSession.this, BoldChatSession.access$600(BoldChatSession.this, "api#chat#ended"));
            }
            if (BoldChatSession.access$1500() == BoldChatState.ChatActive)
            {
                endChat(false);
            }
        } else
        if (BoldChatSession.access$1500() == BoldChatState.ChatActive && chat.getAnswered() != null)
        {
            BoldChatSession.access$3000(BoldChatSession.this);
            BoldChatSession.access$2500(BoldChatSession.this, null);
            return;
        }
    }

    public void onClick(View view)
    {
        if (view.getId() != this._fld0) goto _L2; else goto _L1
_L1:
        BoldChatSession.access$3200(BoldChatSession.this);
        if (BoldChatSession.access$900(BoldChatSession.this))
        {
            BoldChatSession.access$2400(BoldChatSession.this, new Runnable() {

                final BoldChatSession.CallBackListeners this$1;

                public void run()
                {
                    EditText edittext = BoldChatSession.access$500(this$0).getMessageInputField();
                    edittext.clearFocus();
                    ((InputMethodManager)BoldChatSession.access$300(this$0).getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
                }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
                super();
            }
            });
        }
_L4:
        return;
_L2:
        if (view.getId() != tInputFromWindow)
        {
            continue; /* Loop/switch isn't completed */
        }
        endChat(true);
        if (BoldChatSession.access$2200(BoldChatSession.this) == null) goto _L4; else goto _L3
_L3:
        BoldChatSession.access$2200(BoldChatSession.this).ning();
        return;
        if (view.getId() != ning) goto _L4; else goto _L5
_L5:
        if (BoldChatSession.access$400() != null && BoldChatSession.access$400().getStarted() != null)
        {
            endChat(true);
            return;
        }
        if (BoldChatSession.access$1500() == BoldChatState.ChatInactive)
        {
            BoldChatSession.access$1502(BoldChatState.Finished);
        }
        closeChat();
        return;
    }

    public void onMessageAdded(final Message message)
    {
        if (message.getPersonType() == PersonType.Operator && BoldChatSession.access$100(BoldChatSession.this) != null)
        {
            BoldChatSession.access$2400(BoldChatSession.this, new Runnable() {

                final BoldChatSession.CallBackListeners this$1;
                final Message val$message;

                public void run()
                {
                    BoldChatSession.access$100(this$0).messageArrived(message.getText(), message.getName(), message.getCreated());
                }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
                message = message1;
                super();
            }
            });
        }
        BoldChatSession.access$3100(BoldChatSession.this, message, false);
    }

    public void onPostChatSubmitFailed(Form form, String s)
    {
        BoldChatSession.access$2900(BoldChatSession.this, BoldChatState.Finished, s, BoldChatSession.access$600(BoldChatSession.this, "api#chat#close"), null, new BoldChatFormView.SubmitListener() {

            final BoldChatSession.CallBackListeners this$1;

            public void onFormSubmit(Form form1)
            {
                closeChat();
            }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
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
        obj = BoldChatSession.access$600(BoldChatSession.this, form);
        form = ((Form) (obj));
        if (flag)
        {
            form = (new StringBuilder()).append(((String) (obj))).append(" ").append(formfield.getValue()).toString();
        }
        BoldChatSession.access$2900(BoldChatSession.this, BoldChatState.Finished, form, BoldChatSession.access$600(BoldChatSession.this, "api#chat#close"), null, new BoldChatFormView.SubmitListener() {

            final BoldChatSession.CallBackListeners this$1;

            public void onFormSubmit(Form form1)
            {
                closeChat();
            }

            
            {
                this$1 = BoldChatSession.CallBackListeners.this;
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
        BoldChatSession.access$3100(BoldChatSession.this, message, true);
    }

    public void onTyperUpdated(Typer typer)
    {
        BoldChatSession.access$3000(BoldChatSession.this);
    }

    public void onUpdateQueue(int i, boolean flag)
    {
        if (BoldChatSession.access$500(BoldChatSession.this).getTypingTextView() == null || i <= 0) goto _L2; else goto _L1
_L1:
        String s = (new StringBuilder()).append(BoldChatSession.access$600(BoldChatSession.this, "api#chat#queue_position")).append(" ").append(i).toString();
        if (!flag) goto _L4; else goto _L3
_L3:
        BoldChatSession.access$2300(BoldChatSession.this, RichTextUtils.replaceAll(Html.fromHtml((new StringBuilder()).append(s).append(" (<a href=\"#cancel_queue\">").append(BoldChatSession.access$600(BoldChatSession.this, "api#chat#unavailable_email")).append("</a>)").toString()), android/text/style/URLSpan, new init>(BoldChatSession.this, null)));
_L6:
        return;
_L4:
        BoldChatSession.access$2300(BoldChatSession.this, Html.fromHtml((new StringBuilder()).append(BoldChatSession.access$600(BoldChatSession.this, "api#chat#queue_position")).append(" ").append(i).toString()));
        return;
_L2:
        if (i == 0)
        {
            BoldChatSession.access$2300(BoldChatSession.this, null);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private _cls9.this._cls1()
    {
        this$0 = BoldChatSession.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
