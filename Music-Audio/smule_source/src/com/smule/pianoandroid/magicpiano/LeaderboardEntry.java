// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smule.android.f.c;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.models.AccountIcon;
import com.smule.pianoandroid.utils.s;

public class LeaderboardEntry extends RelativeLayout
{

    public LeaderboardEntry(Context context)
    {
        super(context);
    }

    public LeaderboardEntry(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void a(Long long1, AccountIcon accounticon, int i, boolean flag)
    {
        TextView textview = (TextView)findViewById(0x7f0a011c);
        TextView textview1 = (TextView)findViewById(0x7f0a011f);
        TextView textview2 = (TextView)findViewById(0x7f0a0121);
        TextView textview3 = (TextView)findViewById(0x7f0a0120);
        ImageView imageview = (ImageView)findViewById(0x7f0a011d);
        if (flag)
        {
            textview3.setVisibility(0);
            textview.setTextColor(getResources().getColor(0x7f080033));
            textview1.setTextColor(getResources().getColor(0x7f080033));
            textview2.setTextColor(getResources().getColor(0x7f080033));
            if (long1 == null)
            {
                textview.setText("\u2022\u2022\u2022");
            } else
            {
                textview.setText(Long.valueOf(long1.longValue() + 1L).toString());
            }
            if (UserManager.n().e() != null)
            {
                textview1.setVisibility(0);
                textview1.setText(UserManager.n().e());
            } else
            {
                textview1.setVisibility(8);
            }
            textview2.setText((new Integer(i)).toString());
            imageview.setImageBitmap(s.a().b());
        } else
        {
            textview3.setVisibility(8);
            textview.setTextColor(getResources().getColor(0x7f08003b));
            textview1.setTextColor(getResources().getColor(0x7f08003b));
            textview2.setTextColor(getResources().getColor(0x7f08003b));
            textview.setText(Long.valueOf(long1.longValue() + 1L).toString());
            textview1.setText(accounticon.handle);
            textview2.setText((new Integer(i)).toString());
        }
        if (flag)
        {
            c.a(imageview, s.a().b(), 0, true);
            return;
        } else
        {
            c.a(accounticon.picUrl, imageview, 0x7f020152, true, 0, null);
            return;
        }
    }
}
