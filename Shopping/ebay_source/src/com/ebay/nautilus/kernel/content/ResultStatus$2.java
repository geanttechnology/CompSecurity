// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import java.util.Collections;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            ResultStatus, EbayContext

static final class _cls1 extends ResultStatus
{

    _cls1.this._cls0()
    {
        _messages = Collections.unmodifiableList(Collections.singletonList(new ResultStatus.Message() {

            final ResultStatus._cls2 this$0;

            public boolean displayToUser()
            {
                return false;
            }

            public String getCategory()
            {
                return null;
            }

            public String getDomain()
            {
                return null;
            }

            public int getId()
            {
                return -1;
            }

            public String getLongMessage(EbayContext ebaycontext)
            {
                return null;
            }

            public String getRemediationUrl()
            {
                return null;
            }

            public ResultStatus.Severity getSeverity()
            {
                return ResultStatus.Severity.Error;
            }

            public String getShortMessage(EbayContext ebaycontext)
            {
                return "Unknown error!";
            }

            public boolean isLongMessageHtml(EbayContext ebaycontext)
            {
                return false;
            }

            public String toString()
            {
                return "Unknown error!";
            }

            
            {
                this$0 = ResultStatus._cls2.this;
                super();
            }
        }));
    }
}
