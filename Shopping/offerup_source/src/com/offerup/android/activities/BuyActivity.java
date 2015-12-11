// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.OfferResponse;
import com.offerup.android.utils.as;
import com.offerup.android.utils.n;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.offerup.android.activities:
//            k, ai, ah, ae, 
//            af, ag, ac, ad

public class BuyActivity extends k
{

    Item a;
    double b;
    private Button c;

    public BuyActivity()
    {
    }

    static void a(BuyActivity buyactivity)
    {
        ai ai1 = new ai(buyactivity, buyactivity.a, Double.valueOf(buyactivity.b), (byte)0);
        (new ah(buyactivity)).execute(new ai[] {
            ai1
        });
    }

    static void a(BuyActivity buyactivity, OfferResponse offerresponse)
    {
        android.app.AlertDialog.Builder builder = n.c(buyactivity);
        builder.setTitle("Error");
        if (offerresponse != null && offerresponse.getStatus() != null && offerresponse.getStatus().getCode() != null)
        {
            if (offerresponse.getStatus().getCode().contains("409"))
            {
                builder.setMessage("You already made this offer");
            } else
            if (offerresponse.getStatus().getCode().contains("423"))
            {
                builder.setMessage("Item already reserved");
            } else
            if (offerresponse.getStatus().getCode().contains("402"))
            {
                builder.setMessage("Card declined, please use another one.");
            } else
            if (offerresponse.getStatus().getCode().contains("422"))
            {
                builder.setMessage("Card is invalid, please use another one.");
            }
            builder.setNeutralButton("OK", new ae(buyactivity));
        } else
        {
            builder.setMessage("Error making an offer, please contact support.");
            builder.setPositiveButton("Support", new af(buyactivity));
            builder.setNegativeButton("Cancel", new ag(buyactivity));
        }
        n.a(builder);
    }

    final String b()
    {
        return "make_offer";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04001a);
        a = (Item)getIntent().getParcelableExtra("item");
        bundle = (ImageView)findViewById(0x7f100097);
        Picasso.with(this).load(a.getLargestImageAvailable()).placeholder(0x7f0201a7).into(bundle);
        c = (Button)findViewById(0x7f100099);
        if (a.getListingType() == 1)
        {
            findViewById(0x7f10009c).setVisibility(0);
            bundle = (TextView)findViewById(0x7f10009d);
            TextView textview = (TextView)findViewById(0x7f10009e);
            bundle.setText((new StringBuilder("$")).append(a.getPrice()).toString());
            textview.setText(a.getTitle());
            c.setOnClickListener(new ac(this));
            return;
        } else
        {
            findViewById(0x7f100098).setVisibility(0);
            bundle = (EditText)findViewById(0x7f10009a);
            ((TextView)findViewById(0x7f10009b)).setText((new StringBuilder("Enter your offer for ")).append(a.getTitle()).toString());
            bundle.setText((new StringBuilder("$")).append(a.getPrice()).toString());
            as.a(bundle);
            bundle.setSelection(bundle.getText().toString().length());
            c.setOnClickListener(new ad(this, bundle));
            return;
        }
    }
}
