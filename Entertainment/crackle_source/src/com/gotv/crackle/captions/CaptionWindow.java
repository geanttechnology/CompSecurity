// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions;

import android.content.Context;
import android.graphics.Color;
import android.text.Spanned;
import android.text.SpannedString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gotv.crackle.captions.model.CaptionColor;
import com.gotv.crackle.captions.model.CaptionFont;
import com.gotv.crackle.captions.model.CaptionSettings;

public class CaptionWindow extends RelativeLayout
{

    public CaptionWindow(Context context)
    {
        super(context);
        setupViews(context);
    }

    public CaptionWindow(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setupViews(context);
    }

    public CaptionWindow(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setupViews(context);
    }

    private int colorFromColorWithAlpha(int i, int j)
    {
        return Color.argb(j, Color.red(i), Color.green(i), Color.blue(i));
    }

    private void setupViews(Context context)
    {
        LayoutInflater.from(context).inflate(0x7f03002a, this);
    }

    public void setCaptionSettings(CaptionSettings captionsettings)
    {
        TextView textview;
        View view = findViewById(0x7f0a008e);
        textview = (TextView)findViewById(0x7f0a008f);
        view.setBackgroundColor(colorFromColorWithAlpha(captionsettings.getWindowColor().getColor(), captionsettings.getWindowTransparency()));
        textview.setBackgroundColor(colorFromColorWithAlpha(captionsettings.getCharacterBackgroundColor().getColor(), captionsettings.getCharacterBackgroundTransparency()));
        textview.setTypeface(captionsettings.getCaptionFont().getTypeface());
        static class _cls1
        {

            static final int $SwitchMap$com$gotv$crackle$captions$model$CaptionSettings$CaptionEffects[];

            static 
            {
                $SwitchMap$com$gotv$crackle$captions$model$CaptionSettings$CaptionEffects = new int[com.gotv.crackle.captions.model.CaptionSettings.CaptionEffects.values().length];
                try
                {
                    $SwitchMap$com$gotv$crackle$captions$model$CaptionSettings$CaptionEffects[com.gotv.crackle.captions.model.CaptionSettings.CaptionEffects.Depressed.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$gotv$crackle$captions$model$CaptionSettings$CaptionEffects[com.gotv.crackle.captions.model.CaptionSettings.CaptionEffects.Raised.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$gotv$crackle$captions$model$CaptionSettings$CaptionEffects[com.gotv.crackle.captions.model.CaptionSettings.CaptionEffects.Uniform.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$gotv$crackle$captions$model$CaptionSettings$CaptionEffects[com.gotv.crackle.captions.model.CaptionSettings.CaptionEffects.DropShadow.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.gotv.crackle.captions.model.CaptionSettings.CaptionEffects[captionsettings.getCaptionEffects().ordinal()];
        JVM INSTR tableswitch 1 4: default 108
    //                   1 144
    //                   2 164
    //                   3 186
    //                   4 206;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        textview.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
_L7:
        textview.setTextSize(captionsettings.getFontSize());
        textview.setTextColor(colorFromColorWithAlpha(captionsettings.getTextColor().getColor(), captionsettings.getTextTransparency()));
        return;
_L2:
        textview.setShadowLayer(1.5F, 1.0F, 1.0F, colorFromColorWithAlpha(-1, captionsettings.getTextTransparency()));
        continue; /* Loop/switch isn't completed */
_L3:
        textview.setShadowLayer(1.5F, -1F, -1F, colorFromColorWithAlpha(-1, captionsettings.getTextTransparency()));
        continue; /* Loop/switch isn't completed */
_L4:
        textview.setShadowLayer(3F, 0.0F, 0.0F, colorFromColorWithAlpha(-1, captionsettings.getTextTransparency()));
        continue; /* Loop/switch isn't completed */
_L5:
        textview.setShadowLayer(2.5F, 2.0F, 2.0F, colorFromColorWithAlpha(0xff000000, captionsettings.getTextTransparency()));
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void setText(Spanned spanned)
    {
        byte byte0;
        if (spanned.length() == 0)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        setVisibility(byte0);
        ((TextView)findViewById(0x7f0a008f)).setText(spanned);
    }

    public void setText(String s)
    {
        setText(((Spanned) (new SpannedString(s))));
    }
}
