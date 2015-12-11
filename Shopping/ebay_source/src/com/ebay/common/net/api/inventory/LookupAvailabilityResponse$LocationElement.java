// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.nautilus.domain.Duration;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            LookupAvailabilityResponse

private final class location extends com.ebay.nautilus.kernel.util.ent
{

    StoreAvailability location;
    final LookupAvailabilityResponse this$0;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Distance".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void setValue(double d)
                    throws SAXException
                {
                    location.distance = d;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Availability".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.availability = com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.valueOf(s3);
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("LocationID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.locationId = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.name = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Address1".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.address.address1 = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Address2".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.address.address2 = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("City".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.address.city = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Region".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.address.region = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("PostalCode".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.address.postalCode = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Country".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.address.country = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Latitude".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void setValue(double d)
                    throws SAXException
                {
                    location.address.latitude = d;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Longitude".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void setValue(double d)
                    throws SAXException
                {
                    location.address.longitude = d;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Phone".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.phone = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("PickupInstructions".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.pickupInstructions = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("FulfillmentTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    s3 = s3.replaceAll("\\.\\d*", "");
                    location.fulfillmentTime = Long.valueOf(Duration.parse(s3).timeInSeconds * 1000L);
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("URL".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.url = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Quantity".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    location.quantity = Integer.valueOf(i);
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("UTCOffset".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LookupAvailabilityResponse.LocationElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    location.utcOffset = s3;
                }

            
            {
                this$1 = LookupAvailabilityResponse.LocationElement.this;
                super();
            }
            };
        }
        if ("Hours".equals(s1))
        {
            location.hours = new com.ebay.common.model.inventory.t.location();
            return new it>(location.hours);
        }
        if ("UTCHours".equals(s1))
        {
            location.utcHours = new com.ebay.common.model.inventory.t.location();
            return new it>(location.utcHours);
        } else
        {
            return super.location(s, s1, s2, attributes);
        }
    }

    _cls9.this._cls1(StoreAvailability storeavailability)
    {
        this$0 = LookupAvailabilityResponse.this;
        super();
        location = storeavailability;
    }
}
