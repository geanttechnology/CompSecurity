// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.LdsError;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class name extends com.ebay.nautilus.kernel.util.ameter
{

    private static final String NAME_CT_PLACEHOLDER = "clientType.placeholder";
    private static final String NAME_DECISION_OUTCOME_REASON = "decisionOutcomeReason";
    private static final String NAME_MESSAGE = "Message";
    private static final String NAME_MESSAGE_ID = "messageId";
    private static final String NAME_MESSAGE_URL = "messageURL";
    private static final String NAME_PAYMENT_HOLD = "PayPalPaymentHold_Policy_Msg";
    private static final String NAME_REDIRECT_URL = "redirectURL";
    private static final String NAME_RU_PLACEHOLDER = "ru.placeholder";
    private static final String NAME_SHORT_MESSAGE = "ShortMessage";
    private final String name;
    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        if (name == null || s == null) goto _L2; else goto _L1
_L1:
        String s1;
        byte byte0;
        s1 = name;
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 9: default 104
    //                   -1690732568: 199
    //                   -1677810677: 171
    //                   -1675388953: 157
    //                   -1440013438: 271
    //                   473562696: 227
    //                   654781025: 185
    //                   1066984890: 256
    //                   1818232490: 241
    //                   1970336755: 213;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L3:
        byte0;
        JVM INSTR tableswitch 0 8: default 156
    //                   0 286
    //                   1 298
    //                   2 310
    //                   3 322
    //                   4 334
    //                   5 346
    //                   6 358
    //                   7 370
    //                   8 382;
           goto _L2 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L2:
        return;
_L6:
        if (s1.equals("Message"))
        {
            byte0 = 0;
        }
          goto _L3
_L5:
        if (s1.equals("ShortMessage"))
        {
            byte0 = 1;
        }
          goto _L3
_L9:
        if (s1.equals("PayPalPaymentHold_Policy_Msg"))
        {
            byte0 = 2;
        }
          goto _L3
_L4:
        if (s1.equals("messageURL"))
        {
            byte0 = 3;
        }
          goto _L3
_L12:
        if (s1.equals("redirectURL"))
        {
            byte0 = 4;
        }
          goto _L3
_L8:
        if (s1.equals("ru.placeholder"))
        {
            byte0 = 5;
        }
          goto _L3
_L11:
        if (s1.equals("clientType.placeholder"))
        {
            byte0 = 6;
        }
          goto _L3
_L10:
        if (s1.equals("decisionOutcomeReason"))
        {
            byte0 = 7;
        }
          goto _L3
_L7:
        if (s1.equals("messageId"))
        {
            byte0 = 8;
        }
          goto _L3
_L13:
        name(this._cls2.this).parameterMessage = s;
        return;
_L14:
        this._mth2(this._cls2.this).parameterShortMessage = s;
        return;
_L15:
        this._mth2(this._cls2.this).parameterPaymentHoldUrl = s;
        return;
_L16:
        this._mth2(this._cls2.this).parameterMessageUrl = s;
        return;
_L17:
        this._mth2(this._cls2.this).parameterRedirectUrl = s;
        return;
_L18:
        this._mth2(this._cls2.this).parameterRuPlaceHolder = s;
        return;
_L19:
        this._mth2(this._cls2.this).parameterClientTypePlaceHolder = s;
        return;
_L20:
        this._mth2(this._cls2.this).parameterDecisionOutcomeReason = s;
        return;
_L21:
        this._mth2(this._cls2.this).parameterMessageId = s;
        return;
    }

    public (String s)
    {
        this$2 = this._cls2.this;
        super();
        name = s;
    }
}
