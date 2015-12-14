// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.apiv3.model.card.Card;
import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (Card card)
    {
        super("card_view");
        addParam(EventParam.ID, card.id);
        addParam(EventParam.CARD_TYPE, card.type);
        addParam(EventParam.RENDER_TYPE, card.renderType);
        addParam(EventParam.CARD_POSITION, Integer.valueOf(card.cardPosition));
        addParam(EventParam.CARD_TITLE, card.title);
        addParam(EventParam.CARD_SUBTITLE, card.subtitle);
        addParam(EventParam.CARD_FOOTER_TEXT, card.footerTitle);
        addParam(EventParam.VIEW_MILLIS, Long.valueOf(card.viewedMilliseconds));
    }
}
