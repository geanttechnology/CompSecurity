// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            GetDeviceNotificationSubscriptionsResponse, DeviceNotificationSubscriptions

private final class data extends com.ebay.nautilus.kernel.util.ata
{

    private final DeviceNotificationSubscriptions data;
    final data this$1;

    public com.ebay.nautilus.kernel.util.ata get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
        {
            if ("ack".equals(s1))
            {
                return new AckElement(this._cls1.this.data);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(_fld1);
            }
            if ("version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetDeviceNotificationSubscriptionsResponse.RootElement.OperationElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        setVersion(s3);
                    }

            
            {
                this$2 = GetDeviceNotificationSubscriptionsResponse.RootElement.OperationElement.this;
                super();
            }
                };
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(_fld1, "http://www.ebay.com/marketplace/mobile/v1/services");
            }
            if ("active".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetDeviceNotificationSubscriptionsResponse.RootElement.OperationElement this$2;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        data.isActive = flag;
                    }

            
            {
                this$2 = GetDeviceNotificationSubscriptionsResponse.RootElement.OperationElement.this;
                super();
            }
                };
            }
            if ("description".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetDeviceNotificationSubscriptionsResponse.RootElement.OperationElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.description = s3;
                    }

            
            {
                this$2 = GetDeviceNotificationSubscriptionsResponse.RootElement.OperationElement.this;
                super();
            }
                };
            }
            if ("language".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetDeviceNotificationSubscriptionsResponse.RootElement.OperationElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.language = s3;
                    }

            
            {
                this$2 = GetDeviceNotificationSubscriptionsResponse.RootElement.OperationElement.this;
                super();
            }
                };
            }
            if ("preferences".equals(s1))
            {
                return new t(this._cls1.this, data.activePreferences);
            }
            if ("inactivePreferences".equals(s1))
            {
                return new t(this._cls1.this, data.inactivePreferences);
            }
        }
        return super.ata(s, s1, s2, attributes);
    }


    public _cls4.this._cls2(DeviceNotificationSubscriptions devicenotificationsubscriptions)
    {
        this$1 = this._cls1.this;
        super();
        data = devicenotificationsubscriptions;
    }
}
