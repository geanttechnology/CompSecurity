// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.e.a;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.dto.Category;
import com.offerup.android.dto.FollowProfile;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.MessagingResponse;
import com.offerup.android.dto.Person;
import com.offerup.android.network.MessagingService;
import com.offerup.android.network.o;
import com.offerup.android.utils.am;
import com.offerup.android.utils.av;
import com.offerup.android.utils.c;
import com.offerup.android.utils.n;
import com.offerup.android.utils.v;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.activities:
//            hl, hm, hn, FirstQuestionHelpActivity, 
//            hk

public class SendMessageActivity extends Activity
{

    ProgressDialog a;
    String b;
    Item c;
    private long d;
    private long e;
    private j f;

    public SendMessageActivity()
    {
        f = j.a();
    }

    static void a(SendMessageActivity sendmessageactivity)
    {
        sendmessageactivity.b = ((EditText)sendmessageactivity.findViewById(0x7f1000e9)).getText().toString();
        if (StringUtils.isEmpty(sendmessageactivity.b))
        {
            android.app.AlertDialog.Builder builder = n.c(sendmessageactivity);
            builder.setTitle("Error!");
            builder.setMessage("Please enter a message");
            builder.setPositiveButton("Ok", new hl(sendmessageactivity));
            n.a(builder);
            return;
        }
        if (!android.support.v4.e.a.b(sendmessageactivity))
        {
            android.app.AlertDialog.Builder builder1 = n.b(sendmessageactivity);
            builder1.setPositiveButton("Retry", new hm(sendmessageactivity));
            n.a(builder1);
            return;
        }
        MessagingService messagingservice;
        long l;
        if (sendmessageactivity.c != null)
        {
            l = sendmessageactivity.c.getId();
        } else
        {
            l = 0L;
        }
        sendmessageactivity.e = l;
        sendmessageactivity.a = ProgressDialog.show(sendmessageactivity, "", "Sending your message");
        messagingservice = o.d(o.a(Executors.newCachedThreadPool()));
        if (sendmessageactivity.e == 0L)
        {
            n.a(sendmessageactivity);
            return;
        }
        if (sendmessageactivity.d == 0L)
        {
            messagingservice.sendMessage(sendmessageactivity.e, sendmessageactivity.b, new hn(sendmessageactivity, (byte)0));
            return;
        } else
        {
            messagingservice.sendMessage(sendmessageactivity.e, sendmessageactivity.d, sendmessageactivity.b, new hn(sendmessageactivity, (byte)0));
            return;
        }
    }

    static void b(SendMessageActivity sendmessageactivity)
    {
        int i = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("item_price", sendmessageactivity.c.getPrice());
        if (sendmessageactivity.c.getCategory() != null)
        {
            jsonobject.put("category", sendmessageactivity.c.getCategory().getName());
        }
        jsonobject.put("currency", "USD");
        jsonobject.put("item_id", sendmessageactivity.c.getId());
        if (sendmessageactivity.c.getListingType() != 1)
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        av.a("ou_item_ask", jsonobject);
        com.offerup.android.utils.c.a(sendmessageactivity.getApplicationContext(), "ou_item_ask");
        am.a("ou_item_ask", jsonobject);
        return;
        sendmessageactivity;
        g.a(com/offerup/android/activities/SendMessageActivity.getSimpleName(), "Exception logging Omniata data", sendmessageactivity);
        return;
    }

    public final void a(MessagingResponse messagingresponse)
    {
        if (a != null && a.isShowing())
        {
            a.dismiss();
        }
        if (messagingresponse != null && messagingresponse.getStatus() != null && messagingresponse != null && messagingresponse.isSuccess())
        {
            Toast.makeText(this, "Message Sent!", 0).show();
            android.support.v4.e.a.j();
            if (!f.S())
            {
                startActivity(new Intent(this, com/offerup/android/activities/FirstQuestionHelpActivity));
                f.t(true);
            }
            messagingresponse = new Bundle();
            messagingresponse.putString("fb_currency", "USD");
            if (c != null && c.getCategory() != null)
            {
                messagingresponse.putString("fb_content_type", c.getCategory().getName());
            }
            if (c != null && NumberUtils.isNumber(c.getPrice()))
            {
                v.a(this, "AskedQuestion", Double.parseDouble(c.getPrice()), messagingresponse);
            } else
            {
                v.a(this, "AskedQuestion", messagingresponse);
            }
            finish();
            return;
        } else
        {
            Toast.makeText(this, "Error, Message Not Sent", 0).show();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        TextView textview = null;
        super.onCreate(bundle);
        setContentView(0x7f040027);
        bundle = getIntent();
        c = (Item)bundle.getParcelableExtra("item");
        d = bundle.getLongExtra("discussionId", 0L);
        ImageView imageview = (ImageView)findViewById(0x7f1000e7);
        Object obj;
        if (c != null && c.getOwner() != null)
        {
            obj = c.getOwner();
            bundle = ((Person) (obj)).getFirstName();
            if (((Person) (obj)).getGetProfile() != null)
            {
                obj = ((Person) (obj)).getGetProfile().getAvatarSquare();
            } else
            {
                obj = null;
            }
        } else
        {
            obj = null;
            bundle = textview;
        }
        Picasso.with(this).load(((String) (obj))).placeholder(0x7f02018e).into(imageview);
        obj = (Button)findViewById(0x7f1000ea);
        textview = (TextView)findViewById(0x7f1000e8);
        if (bundle != null)
        {
            textview.setText((new StringBuilder("Send ")).append(bundle).append(" a message: ").toString());
        } else
        {
            textview.setText("Send a message: ");
        }
        ((Button) (obj)).setOnClickListener(new hk(this, (EditText)findViewById(0x7f1000e9)));
        com.offerup.android.tracker.a.a("ask");
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onPause()
    {
        super.onPause();
        if (a != null)
        {
            a.dismiss();
        }
    }

    protected void onResume()
    {
        super.onResume();
    }
}
