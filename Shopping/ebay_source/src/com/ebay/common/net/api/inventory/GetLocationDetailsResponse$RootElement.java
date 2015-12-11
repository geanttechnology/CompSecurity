// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.LocationDetails;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            GetLocationDetailsResponse

private final class response extends com.ebay.nautilus.kernel.util.ent
{

    private final EbayResponse response;
    final GetLocationDetailsResponse this$0;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Ack".equals(s1))
        {
            return new AckElement(response);
        }
        if ("Errors".equals(s1))
        {
            return new ErrorElement(response, "");
        }
        if ("NoLocationFound".equals(s1))
        {
            GetLocationDetailsResponse.access$002(GetLocationDetailsResponse.this, false);
        }
        if ("LocationID".equals(s1))
        {
            GetLocationDetailsResponse.access$002(GetLocationDetailsResponse.this, true);
            locationDetails.address = new LocationAddress();
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.id = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("Name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.name = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("Address1".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.address.address1 = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("Address2".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.address.address2 = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("City".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.address.city = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("Region".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.address.region = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("PostalCode".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.address.postalCode = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("Country".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.address.country = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("PickupInstructions".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.pickupInstructions = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("Hours".equals(s1))
        {
            locationDetails.hours = new com.ebay.common.model.inventory.tails();
            return new (locationDetails.hours);
        }
        if ("UTCHours".equals(s1))
        {
            locationDetails.utcHours = new com.ebay.common.model.inventory.tails();
            return new (locationDetails.utcHours);
        }
        if ("Latitude".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void setValue(double d)
                    throws SAXException
                {
                    locationDetails.address.latitude = d;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("Longitude".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void setValue(double d)
                    throws SAXException
                {
                    locationDetails.address.longitude = d;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("Phone".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.phone = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("URL".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.url = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        }
        if ("UTCOffset".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetLocationDetailsResponse.RootElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    locationDetails.utcOffset = s3;
                }

            
            {
                this$1 = GetLocationDetailsResponse.RootElement.this;
                super();
            }
            };
        } else
        {
            return super.ent(s, s1, s2, attributes);
        }
    }

    public _cls9.this._cls1(EbayResponse ebayresponse)
    {
        this$0 = GetLocationDetailsResponse.this;
        super();
        response = ebayresponse;
    }
}
