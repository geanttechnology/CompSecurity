// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ErrorMessageDetails

public class ShippingLabelPdfContainer extends BaseApiResponse
{
    public static class Label
    {

        public byte byteStream[];

        public Label()
        {
        }
    }

    public static class LabelDetails
    {

        public Label label;
        public String labelId;

        public LabelDetails()
        {
        }
    }


    public LabelDetails labelDetails[];
    public String status;

    public ShippingLabelPdfContainer()
    {
    }

    public ErrorMessageDetails getFirstError()
    {
        List list = getErrors();
        if (list != null && list.size() > 0)
        {
            return (ErrorMessageDetails)list.get(0);
        } else
        {
            return null;
        }
    }
}
