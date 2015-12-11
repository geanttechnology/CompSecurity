// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.data.model.LevelConfig;
import com.smule.pianoandroid.e.c;
import com.smule.pianoandroid.e.e;
import com.smule.pianoandroid.utils.o;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, b, MagicApplication

public class LevelProgressActivity extends ag
{

    public LevelProgressActivity()
    {
    }

    public void onBackPressed()
    {
        o.e(this);
    }

    protected void onCreate(Bundle bundle)
    {
        View view;
        Object obj1;
        super.onCreate(bundle);
        setContentView(0x7f03003b);
        ((TextView)getActionBar().getCustomView().findViewById(0x7f0a0037)).setText(getString(0x7f0c01f5));
        int i = e.a().f();
        ((TextView)findViewById(0x7f0a0130)).setText(String.format(getString(0x7f0c0159), new Object[] {
            Integer.valueOf(i)
        }));
        ((ProgressBar)findViewById(0x7f0a0072)).setProgress(Math.round(1000F * e.a().b()));
        bundle = c.a().a(i);
        Object obj = (TextView)findViewById(0x7f0a0131);
        long l = e.a().e();
        if (bundle != null)
        {
            bundle = Long.valueOf(((LevelConfig) (bundle)).xp);
        } else
        {
            bundle = "?";
        }
        ((TextView) (obj)).setText(String.format("%d / %s XP", new Object[] {
            Long.valueOf(l), bundle
        }));
        obj = c.a().a(i + 1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_414;
        }
        bundle = (LinearLayout)findViewById(0x7f0a0068);
        obj = ((LevelConfig) (obj)).rewards.iterator();
_L6:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_414;
        }
        obj1 = (GameReward)((Iterator) (obj)).next();
        view = getLayoutInflater().inflate(0x7f030064, null);
        if (!((GameReward) (obj1)).getRewardType().equals(com.smule.pianoandroid.data.model.GameReward.Type.COINS))
        {
            break; /* Loop/switch isn't completed */
        }
        ((ImageView)view.findViewById(0x7f0a0040)).setImageResource(0x7f020170);
        ((TextView)view.findViewById(0x7f0a0069)).setText((new StringBuilder()).append("+").append(((GameReward) (obj1)).amount).append(" ").append(getText(0x7f0c025e)).toString());
_L4:
        bundle.addView(view);
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_199;
_L1:
        if (!((GameReward) (obj1)).getRewardType().equals(com.smule.pianoandroid.data.model.GameReward.Type.PRODUCT))
        {
            continue; /* Loop/switch isn't completed */
        }
        ((ImageView)view.findViewById(0x7f0a0040)).setImageResource(0x7f020171);
        obj1 = ak.a().a(((GameReward) (obj1)).value);
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        ((TextView)view.findViewById(0x7f0a0069)).setText(((SongV2) (obj1)).title);
        view.findViewById(0x7f0a006a).setVisibility(0);
        ((TextView)view.findViewById(0x7f0a006a)).setText(((SongV2) (obj1)).artist);
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
        bundle = (b)getSupportFragmentManager().findFragmentById(0x7f0a0133);
        ((b) (bundle)).e.setOnClickListener(new android.view.View.OnClickListener() {

            final LevelProgressActivity a;

            public void onClick(View view1)
            {
                a.finish();
            }

            
            {
                a = LevelProgressActivity.this;
                super();
            }
        });
        ((b) (bundle)).d.setOnClickListener(new android.view.View.OnClickListener() {

            final LevelProgressActivity a;

            public void onClick(View view1)
            {
                a.finish();
            }

            
            {
                a = LevelProgressActivity.this;
                super();
            }
        });
        return;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        o.e(this);
        return true;
    }

    protected void onStart()
    {
        super.onStart();
        MagicApplication.onActivityStart(this);
    }

    protected void onStop()
    {
        super.onStop();
        MagicApplication.onActivityStop(this);
    }
}
