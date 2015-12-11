// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import android.text.Html;
import com.ebay.nautilus.domain.data.LdsError;
import com.ebay.nautilus.domain.data.ListingDraft;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.orNode
{
    private final class ErrorCategory extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final LdsResponse.RootElement.ErrorNode this$2;

        public void text(String s)
            throws SAXException
        {
            error.category = s;
            if (!s.equals("Application"))
            {
                ackCode = -1;
            }
        }

        private ErrorCategory()
        {
            this$2 = LdsResponse.RootElement.ErrorNode.this;
            super();
        }

        ErrorCategory(LdsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ErrorLongMessage extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final LdsResponse.RootElement.ErrorNode this$2;

        public void text(String s)
            throws SAXException
        {
            if (s != null)
            {
                error.longMessage = Html.fromHtml(s).toString();
            }
        }

        private ErrorLongMessage()
        {
            this$2 = LdsResponse.RootElement.ErrorNode.this;
            super();
        }

        ErrorLongMessage(LdsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ErrorParameter extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
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
        final LdsResponse.RootElement.ErrorNode this$2;

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
        //                       -1690732568: 199
        //                       -1677810677: 171
        //                       -1675388953: 157
        //                       -1440013438: 271
        //                       473562696: 227
        //                       654781025: 185
        //                       1066984890: 256
        //                       1818232490: 241
        //                       1970336755: 213;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L3:
            byte0;
            JVM INSTR tableswitch 0 8: default 156
        //                       0 286
        //                       1 298
        //                       2 310
        //                       3 322
        //                       4 334
        //                       5 346
        //                       6 358
        //                       7 370
        //                       8 382;
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
            error.parameterMessage = s;
            return;
_L14:
            error.parameterShortMessage = s;
            return;
_L15:
            error.parameterPaymentHoldUrl = s;
            return;
_L16:
            error.parameterMessageUrl = s;
            return;
_L17:
            error.parameterRedirectUrl = s;
            return;
_L18:
            error.parameterRuPlaceHolder = s;
            return;
_L19:
            error.parameterClientTypePlaceHolder = s;
            return;
_L20:
            error.parameterDecisionOutcomeReason = s;
            return;
_L21:
            error.parameterMessageId = s;
            return;
        }

        public ErrorParameter(String s)
        {
            this$2 = LdsResponse.RootElement.ErrorNode.this;
            super();
            name = s;
        }
    }

    private final class Severity extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final LdsResponse.RootElement.ErrorNode this$2;

        public void text(String s)
            throws SAXException
        {
            error.severity = s;
            if (s.equals("Warning"))
            {
                draft.warnings.add(error);
                return;
            } else
            {
                draft.errors.add(error);
                return;
            }
        }

        private Severity()
        {
            this$2 = LdsResponse.RootElement.ErrorNode.this;
            super();
        }

        Severity(LdsResponse._cls1 _pcls1)
        {
            this();
        }
    }


    private final LdsError error;
    final error this$1;

    public com.ebay.nautilus.kernel.util.orNode get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("errorId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.ErrorNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    if (LdsError.isOperationFailure(s3))
                    {
                        ackCode = -1;
                    }
                    error.id = s3;
                }

            
            {
                this$2 = LdsResponse.RootElement.ErrorNode.this;
                super();
            }
            };
        }
        if ("longMessage".equals(s1))
        {
            return new ErrorLongMessage(null);
        }
        if ("message".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.ErrorNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    error.message = s3;
                }

            
            {
                this$2 = LdsResponse.RootElement.ErrorNode.this;
                super();
            }
            };
        }
        if ("domain".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.ErrorNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    error.domain = s3;
                }

            
            {
                this$2 = LdsResponse.RootElement.ErrorNode.this;
                super();
            }
            };
        }
        if ("category".equals(s1))
        {
            return new ErrorCategory(null);
        }
        if ("severity".equals(s1))
        {
            return new Severity(null);
        }
        if ("parameter".equals(s1))
        {
            return new ErrorParameter(attributes.getValue("name"));
        }
        if ("inputRefIds".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.ErrorNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    if (error.inputRefId == null)
                    {
                        error.inputRefId = s3;
                    }
                }

            
            {
                this$2 = LdsResponse.RootElement.ErrorNode.this;
                super();
            }
            };
        } else
        {
            return super.orNode(s, s1, s2, attributes);
        }
    }


    private _cls4.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
        error = new LdsError();
    }

    error(error error2)
    {
        this();
    }
}
