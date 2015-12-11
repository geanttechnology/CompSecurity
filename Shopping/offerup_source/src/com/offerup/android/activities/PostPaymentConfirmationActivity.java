// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.offerup.android.dto.FollowProfile;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Person;
import com.offerup.android.tracker.a;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.offerup.android.activities:
//            ft, fu

public class PostPaymentConfirmationActivity extends Activity
{

    Item a;
    private String b;

    public PostPaymentConfirmationActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040034);
        bundle = (TextView)findViewById(0x7f10011e);
        ImageView imageview = (ImageView)findViewById(0x7f10011c);
        TextView textview = (TextView)findViewById(0x7f10011d);
        Button button = (Button)findViewById(0x7f100112);
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 != null)
        {
            a = (Item)bundle1.getParcelable("item");
            bundle1.getLong("orderId", 0L);
            b = bundle1.getString("price");
            if (b.endsWith(".00"))
            {
                b = b.substring(0, b.length() - 3);
            }
            Picasso.with(getApplicationContext()).load(a.getOwner().getGetProfile().getAvatarNormal()).into(imageview);
            textview.setText(String.format(getResources().getString(0x7f0901b7), new Object[] {
                b, a.getOwner().getFirstName()
            }));
            bundle.setOnClickListener(new ft(this));
            button.setOnClickListener(new fu(this));
        }
    }

    protected void onResume()
    {
        super.onResume();
        com.offerup.android.tracker.a.a("payments_payseller_paymentsent");
    }
}
