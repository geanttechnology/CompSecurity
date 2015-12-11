// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.chat;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.i;
import android.support.v4.app.m;
import android.support.v7.aky;
import android.support.v7.alc;
import android.support.v7.aqo;
import android.support.v7.cw;
import android.support.v7.dr;
import android.support.v7.fj;
import android.support.v7.gh;
import android.support.v7.gl;
import android.support.v7.gm;
import android.support.v7.ht;
import android.support.v7.ih;
import android.support.v7.is;
import android.support.v7.iu;
import android.support.v7.iv;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.f;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.chat.Conversation;
import com.abtnprojects.ambatana.models.chat.Message;
import com.abtnprojects.ambatana.models.chat.MessageComparator;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.product.Thumb;
import com.abtnprojects.ambatana.models.user.User;
import com.abtnprojects.ambatana.models.user.UserEntity;
import com.abtnprojects.ambatana.receivers.AmbatanaBroadcastPushReceiver;
import com.abtnprojects.ambatana.ui.activities.ProductActivity;
import com.abtnprojects.ambatana.ui.activities.b;
import com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity;
import com.abtnprojects.ambatana.ui.fragments.safetytips.TipContainerDialogFragment;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.chat:
//            UserMessagesListActivity

public class MessagesActivity extends b
    implements com.abtnprojects.ambatana.ui.fragments.safetytips.TipContainerDialogFragment.a
{

    private f A;
    private CountryCurrencyInfo B;
    private IntentFilter C;
    private ProgressDialog D;
    private Product E;
    private Conversation F;
    private String G;
    private ht H;
    private String I;
    private Bundle J;
    private gl K;
    private boolean L;
    private String M;
    private dr N;
    private BroadcastReceiver O;
    EditText etMessageContainer;
    ImageView info_product_header_image;
    TextView info_product_header_name;
    TextView info_product_header_price;
    ImageView info_user_header_image;
    TextView info_user_header_username;
    ListView listView;
    private int n;
    TextView tvSend;

    public MessagesActivity()
    {
        n = -1;
        G = null;
        O = new BroadcastReceiver() {

            final MessagesActivity a;

            public void onReceive(Context context, Intent intent)
            {
                String s;
                Object obj;
                context = null;
                obj = intent.getExtras();
                intent = (Message)((Bundle) (obj)).getParcelable("message_extra");
                s = ParseUser.getCurrentUser().getObjectId();
                obj = ((Bundle) (obj)).getString("product_id");
                break MISSING_BLOCK_LABEL_35;
                if (MessagesActivity.a(a) != null && MessagesActivity.a(a).getOwner() != null)
                {
                    context = MessagesActivity.a(a).getOwner().getId();
                }
                if (MessagesActivity.a(a) != null && obj != null && ((String) (obj)).equals(MessagesActivity.a(a).getId()) && com.abtnprojects.ambatana.ui.activities.chat.MessagesActivity.b(a) != null)
                {
                    User user = com.abtnprojects.ambatana.ui.activities.chat.MessagesActivity.b(a).getUserToDisplay();
                    intent.setUserAvatarUrl(user.getAvatarUrl());
                    intent.setUserName(user.getName());
                    if (context == null || !context.equals(s) || intent.getUserId().equals(user.getId()))
                    {
                        intent.setUserId(user.getId());
                        a.a(intent);
                        return;
                    }
                }
                return;
            }

            
            {
                a = MessagesActivity.this;
                super();
            }
        };
    }

    private void E()
    {
        if (F != null)
        {
            ParseUser parseuser = ParseUser.getCurrentUser();
            String s3 = parseuser.getObjectId();
            String s1 = F.getUserFrom().getId();
            String s2 = F.getUserTo().getId();
            String s;
            if (F == null)
            {
                s = E.getOwner().getId();
            } else
            {
                s = F.getProduct().getOwner().getId();
            }
            if (s != null && s.equals(s1))
            {
                s = s2;
            } else
            if (s != null && s.equals(s2))
            {
                s = s1;
            } else
            {
                s = null;
            }
            a(parseuser, s3, s, E.getId());
        }
    }

    private void F()
    {
        aqo.c("No valid product ... go to conversations list...", new Object[0]);
        H();
        Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/activities/chat/UserMessagesListActivity);
        intent.addFlags(0x4000000);
        startActivity(intent);
        finish();
    }

    private void G()
    {
        D = new ProgressDialog(this);
        D.setTitle(getString(0x7f0900bd));
        D.setMessage(getString(0x7f0900bc));
        D.setIndeterminate(false);
        D.show();
    }

    private void H()
    {
        iv.a(D);
    }

    private void I()
    {
        tvSend.setEnabled(false);
        etMessageContainer.setEnabled(false);
    }

    private void J()
    {
        I();
        G = etMessageContainer.getText().toString().trim();
        if (G.length() > 0)
        {
            a(0, G);
            return;
        } else
        {
            K();
            return;
        }
    }

    private void K()
    {
        tvSend.setEnabled(true);
        etMessageContainer.setEnabled(true);
    }

    private void L()
    {
        if (!z())
        {
            a(y());
        }
    }

    private void M()
    {
        listView.postDelayed(new Runnable() {

            final MessagesActivity a;

            public void run()
            {
                if (a.listView != null && com.abtnprojects.ambatana.ui.activities.chat.MessagesActivity.f(a) != null && com.abtnprojects.ambatana.ui.activities.chat.MessagesActivity.f(a).getCount() > 0)
                {
                    a.listView.smoothScrollToPosition(com.abtnprojects.ambatana.ui.activities.chat.MessagesActivity.f(a).getCount() - 1);
                }
            }

            
            {
                a = MessagesActivity.this;
                super();
            }
        }, 50L);
    }

    private void N()
    {
        if (F != null)
        {
            Object obj = F.getUserToDisplay();
            if (obj != null)
            {
                String s = ((User) (obj)).getAvatarUrl();
                if (!TextUtils.isEmpty(s))
                {
                    aky.a(getApplicationContext()).a(s).a(new ih()).a().c().a(info_user_header_image);
                }
                info_user_header_username.setText(((User) (obj)).getName());
            }
            info_product_header_name.setText(E.getName());
            if (E.getCurrency().equalsIgnoreCase("USD"))
            {
                info_product_header_price.setText((new StringBuilder()).append("$ ").append(String.valueOf(E.getPrice())).toString());
            } else
            {
                info_product_header_price.setText((new StringBuilder()).append(String.valueOf(E.getPrice())).append(" ").append(E.getCurrency()).toString());
            }
            obj = E.getThumb().getUrl();
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                a(((String) (obj)), info_product_header_image);
            }
            if (O())
            {
                info_product_header_image.setAlpha(0.5F);
            }
        }
    }

    private boolean O()
    {
        return E.getStatus() == 6;
    }

    private boolean P()
    {
        return is.l(getApplicationContext()) == -1;
    }

    private boolean Q()
    {
        if (F == null)
        {
            return false;
        }
        Object obj = F.getMessages();
        if (obj == null)
        {
            return false;
        }
        String s = ParseUser.getCurrentUser().getObjectId();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Message message = (Message)((Iterator) (obj)).next();
            if (s != null && !s.equals(message.getUserId()))
            {
                return true;
            }
        }

        return false;
    }

    private void R()
    {
        if (I == null || L) goto _L2; else goto _L1
_L1:
        if (!I.equals("make_offer")) goto _L4; else goto _L3
_L3:
        String s = J.getString("action_defined_value");
        G = (new StringBuilder()).append(getString(0x7f0900f7)).append(" ").append(s).append("").append(E.getCurrency()).toString();
        a(1, G);
_L6:
        I = null;
_L2:
        return;
_L4:
        if (I.equals("user_liked"))
        {
            G = J.getString("message_content");
            a(0, G);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void S()
    {
        if (isFinishing())
        {
            break MISSING_BLOCK_LABEL_40;
        }
        Object obj = f();
        TipContainerDialogFragment tipcontainerdialogfragment = TipContainerDialogFragment.Q();
        tipcontainerdialogfragment.a(this);
        obj = ((i) (obj)).a();
        ((m) (obj)).a(tipcontainerdialogfragment, "TipDialog");
        ((m) (obj)).b();
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        aqo.c("Exception cached on openTipDialog", new Object[0]);
        return;
    }

    private int a(Bundle bundle)
    {
        int j = 1;
        if (bundle == null || !bundle.containsKey("message_type"))
        {
            j = 0;
        } else
        {
            int i1 = bundle.getInt("message_type");
            if (i1 != 1)
            {
                return i1 != 2 ? 0 : 2;
            }
        }
        return j;
    }

    static Product a(MessagesActivity messagesactivity)
    {
        return messagesactivity.E;
    }

    private void a(int j, String s)
    {
        if (F != null && E != null)
        {
            etMessageContainer.setText("");
            User user = F.getUserToDisplay();
            N.a(E.getId(), j, s, user.getId(), new android.support.v7.dr.a(s, j) {

                final String a;
                final int b;
                final MessagesActivity c;

                public void a()
                {
                    MessagesActivity.c(c);
                    c.a(new Message(0, a, b, new Date(), ParseUser.getCurrentUser().getObjectId(), null, null));
                    c.l();
                    MessagesActivity.d(c);
                }

                public void a(cw cw1)
                {
                    if (1 == cw1.a())
                    {
                        MessagesActivity.e(c);
                        return;
                    } else
                    {
                        MessagesActivity.c(c);
                        c.etMessageContainer.setText(a);
                        aqo.d("error sending message", new Object[0]);
                        return;
                    }
                }

            
            {
                c = MessagesActivity.this;
                a = s;
                b = j;
                super();
            }
            });
        }
    }

    private void a(Intent intent, Product product)
    {
        int j = 0;
        if (intent != null)
        {
            j = a(intent.getExtras());
        }
        if (j == 1)
        {
            K.a(this, product, product.getOwner(), M);
        } else
        if (j == 2 && product != null)
        {
            K.a(this, product, product.getOwner());
            return;
        }
    }

    private void a(ParseUser parseuser, String s, String s1, String s2)
    {
        G();
        parseuser = new fj(parseuser.getSessionToken(), B, this, s, s2, s1);
        s = new Void[0];
        if (!(parseuser instanceof AsyncTask))
        {
            parseuser.execute(s);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)parseuser, s);
            return;
        }
    }

    private void a(String s, ImageView imageview)
    {
        aky.a(getApplicationContext()).a(s).a().c().a(imageview);
    }

    static Conversation b(MessagesActivity messagesactivity)
    {
        return messagesactivity.F;
    }

    static void c(MessagesActivity messagesactivity)
    {
        messagesactivity.K();
    }

    static void d(MessagesActivity messagesactivity)
    {
        messagesactivity.L();
    }

    static void e(MessagesActivity messagesactivity)
    {
        messagesactivity.B();
    }

    static ht f(MessagesActivity messagesactivity)
    {
        return messagesactivity.H;
    }

    public void C()
    {
        Object obj;
        StringBuffer stringbuffer;
        if (F == null)
        {
            obj = new ArrayList();
        } else
        {
            obj = F.getMessages();
        }
        aqo.a((new StringBuilder()).append("Messages size : ").append(((List) (obj)).size()).toString(), new Object[0]);
        stringbuffer = new StringBuffer();
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); stringbuffer.append(((Message)iterator.next()).toString())) { }
        aqo.a("Messages before sort : %s", new Object[] {
            stringbuffer.toString()
        });
        Collections.sort(((List) (obj)), new MessageComparator());
        aqo.a("Messages after sort : %s", new Object[] {
            stringbuffer.toString()
        });
        H.clear();
        H.addAll(((java.util.Collection) (obj)));
        M();
        if (P() && Q())
        {
            S();
        }
    }

    public void D()
    {
        d();
    }

    protected void a(Bundle bundle, boolean flag)
    {
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
                        if (!flag)
                        {
                            a(0x7f0200d1);
                            C = new IntentFilter();
                            C.addAction(AmbatanaBroadcastPushReceiver.c);
                            ButterKnife.bind(this);
                            K = (new gm()).a(new gh(), ParseUser.getCurrentUser(), new iu());
                            if (bundle != null)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            L = flag;
                            J = getIntent().getExtras();
                            B = iv.a(this);
                            iv.a(this);
                            if (J == null)
                            {
                                break label0;
                            }
                            aqo.a((new StringBuilder()).append("extras : ").append(J.toString()).toString(), new Object[0]);
                            H = new ht(this, new ArrayList());
                            listView.setAdapter(H);
                            N = new dr(ParseUser.getCurrentUser().getSessionToken());
                            n = J.getInt("origin_activity", -1);
                            switch (n)
                            {
                            default:
                                aqo.d((new StringBuilder()).append("Invalid origin : ").append(n).toString(), new Object[0]);
                                F();
                                break;

                            case 0: // '\0'
                                break label3;

                            case 1: // '\001'
                                break label2;

                            case 2: // '\002'
                                break label1;

                            case 3: // '\003'
                                break;
                            }
                        }
                        return;
                    }
                    F = (Conversation)J.getParcelable("conversation");
                    if (F == null)
                    {
                        F();
                    }
                    if (F == null)
                    {
                        bundle = null;
                    } else
                    {
                        bundle = F.getProduct();
                    }
                    E = bundle;
                    N();
                    E();
                    return;
                }
                E = (Product)J.getParcelable("product");
                if (E == null)
                {
                    F();
                    return;
                } else
                {
                    M = J.getString("action_defined_value");
                    I = J.getString("action_defined");
                    bundle = ParseUser.getCurrentUser();
                    String s = bundle.getObjectId();
                    a(((ParseUser) (bundle)), s, s, E.getId());
                    return;
                }
            }
            bundle = J.getString("product_id");
            String s1 = J.getString("user_id");
            if (s1 != null && bundle != null)
            {
                ParseUser parseuser = ParseUser.getCurrentUser();
                a(parseuser, parseuser.getObjectId(), s1, ((String) (bundle)));
                return;
            } else
            {
                F();
                return;
            }
        }
        F();
    }

    public void a(Conversation conversation)
    {
        aqo.a("onConversationLoaded", new Object[0]);
        H();
        if ((n == 0 || n == 2) && conversation == null)
        {
            F();
            return;
        }
        if (n == 1)
        {
            if (conversation == null)
            {
                Object obj = ParseUser.getCurrentUser();
                conversation = E.getOwner();
                obj = (new UserEntity()).transform(((ParseUser) (obj)));
                F = new Conversation(null, E, 0, null, new ArrayList(), ((User) (obj)), conversation, conversation, ((User) (obj)));
            } else
            {
                F = conversation;
                C();
            }
            N();
            R();
            return;
        } else
        {
            F = conversation;
            E = conversation.getProduct();
            N();
            C();
            return;
        }
    }

    public void a(Message message)
    {
        H.add(message);
        M();
        if (P() && !message.getUserId().equals(ParseUser.getCurrentUser().getObjectId()))
        {
            S();
        }
    }

    protected void k()
    {
        setContentView(0x7f040020);
    }

    protected void l()
    {
        User user;
        User user1;
        String s;
        String s1;
        String s2;
        s = ParseUser.getCurrentUser().getObjectId();
        user = F.getUserFrom();
        s1 = user.getId();
        user1 = F.getUserTo();
        s2 = user1.getId();
        if (!s.equals(s1)) goto _L2; else goto _L1
_L1:
        user = user1;
_L4:
        a(getIntent(), E);
        K.b(this, E, user);
        return;
_L2:
        if (!s.equals(s2))
        {
            user = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean m()
    {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110000, menu);
        return true;
    }

    protected void onDestroy()
    {
        H();
        super.onDestroy();
        if (A != null)
        {
            A.a();
        }
        iv.b(this);
    }

    boolean onEditorAction(int j)
    {
        if (j == 2 || j == 4)
        {
            J();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f10016a)
        {
            S();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        super.onPause();
        unregisterReceiver(O);
        if (A != null)
        {
            A.a();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem = menu.findItem(0x7f10016a);
        if (menuitem != null)
        {
            if (is.l(getApplicationContext()) < 2)
            {
                menuitem.setIcon(0x7f0200ef);
            } else
            {
                menuitem.setIcon(0x7f0200f0);
            }
            return true;
        } else
        {
            return super.onPrepareOptionsMenu(menu);
        }
    }

    void onProductHeaderClicked()
    {
        if (O())
        {
            if (A != null)
            {
                A.a();
            }
            A = new f();
            A.a(this);
            return;
        } else
        {
            Intent intent = new Intent(getApplicationContext(), com/abtnprojects/ambatana/ui/activities/ProductActivity);
            intent.putExtra("product", E);
            startActivity(intent);
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        registerReceiver(O, C);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("offer_sent", true);
    }

    void onSendTapped()
    {
        J();
    }

    protected void onStop()
    {
        super.onStop();
        iv.b(this);
    }

    void onUserHeaderClicked()
    {
        if (F != null)
        {
            Intent intent = new Intent(getApplicationContext(), com/abtnprojects/ambatana/ui/activities/profile/UserProfileActivity);
            intent.putExtra("user_id", F.getUserToDisplay().getId());
            startActivity(intent);
        }
    }
}
