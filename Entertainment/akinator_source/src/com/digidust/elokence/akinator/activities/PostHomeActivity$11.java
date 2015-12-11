// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.billing.Base64;
import com.digidust.elokence.akinator.billing.Base64DecoderException;
import com.digidust.elokence.akinator.db.DefiSetAdapter;
import com.digidust.elokence.akinator.factories.AkLog;
import com.elokence.limuleapi.TraductionFactory;
import java.util.List;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PostHomeActivity

class this._cls0
    implements Runnable
{

    final PostHomeActivity this$0;

    public void run()
    {
        Object obj = (RelativeLayout)findViewById(0x7f0d0169);
        com.digidust.elokence.akinator.db.nfos nfos = DefiSetAdapter.sharedInstance().getDefiDuJourInfos();
        if (nfos == null)
        {
            AkLog.d("defi", "on cache la vue car infos == null");
            ((RelativeLayout) (obj)).setVisibility(4);
            return;
        }
        ((RelativeLayout) (obj)).setVisibility(0);
        obj = (TextView)findViewById(0x7f0d00cf);
        ((TextView) (obj)).setTypeface(tf);
        ((TextView) (obj)).setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_TITRE")).append(" ").append(nfos.getTitle()).toString());
    /* block-local class not found */
    class _cls1 {}

        ((ImageView)findViewById(0x7f0d016f)).setOnClickListener(new _cls1(nfos));
        Object obj1 = (LinearLayout)findViewById(0x7f0d016c);
        ((LinearLayout) (obj1)).removeAllViews();
        int j = (int)TypedValue.applyDimension(0, 10F, getResources().getDisplayMetrics());
        int k = (int)TypedValue.applyDimension(0, getResources().getDimension(0x7f09006d), getResources().getDisplayMetrics());
        AkLog.d("defi", (new StringBuilder()).append(nfos.getListPerso().size()).append(" persos a afficher").toString());
        int i = 0;
        while (i < nfos.getListPerso().size()) 
        {
            Object obj2 = (com.digidust.elokence.akinator.db.)nfos.getListPerso().get(i);
            String s = ((com.digidust.elokence.akinator.db.) (obj2)).getPhotoBase64();
            boolean flag = ((com.digidust.elokence.akinator.db.) (obj2)).isFound();
            ImageView imageview = new ImageView(PostHomeActivity.this);
            if (flag)
            {
                try
                {
                    byte abyte0[] = Base64.decode(s);
                    imageview.setImageBitmap(BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length));
                }
                catch (Base64DecoderException base64decoderexception)
                {
                    base64decoderexception.printStackTrace();
                    imageview.setImageResource(0x7f02021e);
                }
            } else
            {
                imageview.setImageResource(0x7f02021e);
            }
            AkLog.d("defi", (new StringBuilder()).append(" persos rajouter ").append(((com.digidust.elokence.akinator.db.) (obj2)).getBaseId()).toString());
            obj2 = new android.widget.arams(k, k);
            ((android.widget.arams) (obj2)).setMargins(j, 0, j, 0);
            imageview.setLayoutParams(((android.view.ms) (obj2)));
            ((LinearLayout) (obj1)).addView(imageview);
            i++;
        }
        nfos = DefiSetAdapter.sharedInstance().getDefiInfos(false);
        obj1 = (TextView)findViewById(0x7f0d016e);
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f0d016d);
        if (nfos != null)
        {
            linearlayout.setVisibility(0);
            ((TextView) (obj1)).setTypeface(tf);
            ((TextView) (obj1)).setText(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_PRECEDENT"));
    /* block-local class not found */
    class _cls2 {}

            linearlayout.setOnClickListener(new _cls2());
            addTextView(((TextView) (obj1)));
        } else
        {
            linearlayout.setVisibility(4);
        }
        addTextView(((TextView) (obj)));
        updateTextViewsSize();
    }

    _cls2()
    {
        this$0 = PostHomeActivity.this;
        super();
    }
}
