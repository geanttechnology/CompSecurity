// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.data.model.GameReward;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameRewardsActivity

class k extends BaseAdapter
{

    final GameRewardsActivity a;
    private List b;
    private LayoutInflater c;

    public k(GameRewardsActivity gamerewardsactivity, Context context, List list)
    {
        a = gamerewardsactivity;
        super();
        b = list;
        c = LayoutInflater.from(context);
    }

    static List a(k k1)
    {
        return k1.b;
    }

    public int getCount()
    {
        return b.size();
    }

    public Object getItem(int i)
    {
        return b.get(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        GameReward gamereward = (GameReward)getItem(i);
        viewgroup = view;
        if (view == null)
        {
            viewgroup = c.inflate(0x7f03002d, null);
        }
        view = new android.view.View.OnClickListener(gamereward) {

            final GameReward a;
            final k b;

            public void onClick(View view1)
            {
                if (a != null && a.value != null && k.a(b).size() > 1)
                {
                    b.a.i = a.value;
                } else
                {
                    b.a.i = "";
                }
                GameRewardsActivity.b(b.a, b.a.i);
            }

            
            {
                b = k.this;
                a = gamereward;
                super();
            }
        };
        viewgroup.setOnClickListener(view);
        if (r.a(a) && gamereward != null && gamereward.value != null && b.size() > 1)
        {
            SongV2 songv2 = ak.a().a(gamereward.value);
            if (songv2 != null)
            {
                ((TextView)viewgroup.findViewById(0x7f0a00c0)).setText(songv2.title);
                ((TextView)viewgroup.findViewById(0x7f0a00c1)).setText(songv2.artist);
            } else
            {
                ((TextView)viewgroup.findViewById(0x7f0a00c0)).setText(gamereward.value);
            }
        } else
        {
            TextView textview = (TextView)viewgroup.findViewById(0x7f0a00c0);
            textview.setSingleLine(false);
            textview.setText(a.getString(0x7f0c0130));
            ((TextView)viewgroup.findViewById(0x7f0a00a3)).setText(a.getString(0x7f0c00b3));
        }
        viewgroup.setTag(gamereward);
        viewgroup.findViewById(0x7f0a00a3).setOnClickListener(view);
        return viewgroup;
    }
}
