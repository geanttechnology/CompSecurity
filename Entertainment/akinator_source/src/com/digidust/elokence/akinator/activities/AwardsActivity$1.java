// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.db.AkDBAdapter;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AwardsActivity

class this._cls0
    implements android.view.ner
{

    final AwardsActivity this$0;

    public void onClick(View view)
    {
        byte byte0 = 0;
        LayoutInflater layoutinflater;
        Object obj;
        TextView textview;
        LinearLayout linearlayout;
        Pair pair;
        Iterator iterator;
        if (view == AwardsActivity.access$000(AwardsActivity.this))
        {
            byte0 = 6;
        } else
        if (view == AwardsActivity.access$100(AwardsActivity.this))
        {
            byte0 = 5;
        } else
        if (view == AwardsActivity.access$200(AwardsActivity.this))
        {
            byte0 = 4;
        } else
        if (view == AwardsActivity.access$300(AwardsActivity.this))
        {
            byte0 = 3;
        } else
        if (view == AwardsActivity.access$400(AwardsActivity.this))
        {
            byte0 = 2;
        } else
        if (view == AwardsActivity.access$500(AwardsActivity.this))
        {
            byte0 = 1;
        }
        AwardsActivity.access$602(AwardsActivity.this, new AkDBAdapter(AwardsActivity.this));
        obj = AwardsActivity.access$600(AwardsActivity.this).getCharactersPlayedForAwardLevel(byte0);
        if (obj == null || ((List) (obj)).size() <= 0) goto _L2; else goto _L1
_L1:
        layoutinflater = (LayoutInflater)getSystemService("layout_inflater");
        AwardsActivity.access$700(AwardsActivity.this).removeAllViews();
        for (iterator = ((List) (obj)).iterator(); iterator.hasNext(); AwardsActivity.access$700(AwardsActivity.this).addView(linearlayout))
        {
            pair = (Pair)iterator.next();
            linearlayout = (LinearLayout)layoutinflater.inflate(0x7f030058, null);
            obj = (TextView)linearlayout.findViewById(0x7f0d025d);
            textview = (TextView)linearlayout.findViewById(0x7f0d025e);
            addTextView(textview);
            addTextView(((TextView) (obj)));
            ((TextView) (obj)).setText((CharSequence)pair.first);
            textview.setText((CharSequence)pair.second);
        }

        updateTextViewsSize();
        if (view != AwardsActivity.access$000(AwardsActivity.this)) goto _L4; else goto _L3
_L3:
        AwardsActivity.access$800(AwardsActivity.this).setImageResource(0x7f020066);
        AwardsActivity.access$800(AwardsActivity.this).setBackgroundResource(0x7f02007a);
_L8:
        AwardsActivity.access$900(AwardsActivity.this).setVisibility(0);
_L2:
        if (AwardsActivity.access$600(AwardsActivity.this) != null)
        {
            AwardsActivity.access$600(AwardsActivity.this).close();
        }
_L6:
        return;
_L4:
        if (view == AwardsActivity.access$100(AwardsActivity.this))
        {
            AwardsActivity.access$800(AwardsActivity.this).setImageResource(0x7f020076);
            AwardsActivity.access$800(AwardsActivity.this).setBackgroundResource(0x7f02007a);
        } else
        if (view == AwardsActivity.access$200(AwardsActivity.this))
        {
            AwardsActivity.access$800(AwardsActivity.this).setImageResource(0x7f020072);
            AwardsActivity.access$800(AwardsActivity.this).setBackgroundResource(0x7f02007a);
        }
        continue; /* Loop/switch isn't completed */
        view;
        view.printStackTrace();
        if (false)
        {
            throw new NullPointerException();
        }
        if (AwardsActivity.access$600(AwardsActivity.this) == null) goto _L6; else goto _L5
_L5:
        AwardsActivity.access$600(AwardsActivity.this).close();
        return;
        view;
        if (false)
        {
            throw new NullPointerException();
        }
        if (AwardsActivity.access$600(AwardsActivity.this) != null)
        {
            AwardsActivity.access$600(AwardsActivity.this).close();
        }
        throw view;
        if (true) goto _L8; else goto _L7
_L7:
    }

    ()
    {
        this$0 = AwardsActivity.this;
        super();
    }
}
