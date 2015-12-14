// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.p;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.utility.e;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class LikeListActivity extends BaseActivity
{

    private String e;
    private long f;
    private int g;
    private LinearLayout h;
    private View i;
    private android.view.View.OnClickListener j;

    public LikeListActivity()
    {
        e = null;
        f = -1L;
        g = 0;
        h = null;
        i = null;
        j = new android.view.View.OnClickListener() {

            final LikeListActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.LikeListActivity.c(a);
            }

            
            {
                a = LikeListActivity.this;
                super();
            }
        };
    }

    static int a(LikeListActivity likelistactivity)
    {
        return likelistactivity.g;
    }

    static int a(LikeListActivity likelistactivity, int l)
    {
        l = likelistactivity.g + l;
        likelistactivity.g = l;
        return l;
    }

    static void a(LikeListActivity likelistactivity, ArrayList arraylist)
    {
        likelistactivity.a(arraylist);
    }

    private void a(Creator creator, View view)
    {
        view.setOnClickListener(new android.view.View.OnClickListener(creator) {

            final Creator a;
            final LikeListActivity b;

            public void onClick(View view1)
            {
                com.cyberlink.beautycircle.c.a(b, a.userId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
            }

            
            {
                b = LikeListActivity.this;
                a = creator;
                super();
            }
        });
        Object obj = (UICImageView)view.findViewById(j.avatar_image);
        if (obj != null)
        {
            ((UICImageView) (obj)).setImageURI(creator.avatar);
        }
        com.cyberlink.beautycircle.a.a((ImageView)view.findViewById(j.avatar_crown), creator.userType);
        obj = (EmojiconTextView)view.findViewById(j.display_name);
        if (obj != null)
        {
            if (e.a)
            {
                ((EmojiconTextView) (obj)).setText(String.format(Locale.getDefault(), "[%d]%s", new Object[] {
                    Long.valueOf(creator.userId), creator.displayName
                }));
            } else
            {
                ((EmojiconTextView) (obj)).setText(creator.displayName);
            }
        }
        creator = creator.b();
        p.a(view.findViewById(j.follow), (TextView)view.findViewById(j.follow_text), creator);
    }

    private void a(ArrayList arraylist)
    {
        LayoutInflater layoutinflater = (LayoutInflater)getSystemService("layout_inflater");
        View view;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); h.addView(view, 0))
        {
            Creator creator = (Creator)arraylist.next();
            view = layoutinflater.inflate(k.bc_view_item_user_list, h, false);
            a(creator, view);
        }

    }

    static View b(LikeListActivity likelistactivity)
    {
        return likelistactivity.i;
    }

    static void c(LikeListActivity likelistactivity)
    {
        likelistactivity.o();
    }

    private void o()
    {
        if (f == -1L)
        {
            return;
        } else
        {
            NetworkPost.b(e, f, AccountManager.c(), g, 20).a(new com.perfectcorp.utility.m() {

                final LikeListActivity a;

                protected void a(d d1)
                {
                    com.cyberlink.beautycircle.controller.activity.LikeListActivity.a(a, d1.b.size());
                    View view = LikeListActivity.b(a);
                    int l;
                    if (com.cyberlink.beautycircle.controller.activity.LikeListActivity.a(a) < d1.a.intValue())
                    {
                        l = 0;
                    } else
                    {
                        l = 8;
                    }
                    view.setVisibility(l);
                    com.cyberlink.beautycircle.controller.activity.LikeListActivity.a(a, d1.b);
                }

                protected void b(Object obj)
                {
                    a((d)obj);
                }

            
            {
                a = LikeListActivity.this;
                super();
            }
            });
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_like_list);
        b(m.bc_likelist_title);
        h = (LinearLayout)findViewById(j.like_list_layout);
        i = findViewById(j.more_like_list_btn);
        if (i != null)
        {
            i.setOnClickListener(j);
        }
        bundle = getIntent();
        if (bundle != null)
        {
            e = bundle.getStringExtra("ListLikeTargetType");
            f = bundle.getLongExtra("ListLikeTargetId", -1L);
            o();
        }
    }
}
