// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.LocationDetails;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetLocationDetailsResponse extends EbayResponse
{
    public static final class DayElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.inventory.LocationDetails.Day day;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Date".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final DayElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        day.date = EbayDateFormat.parseInventoryDate(s);
                    }

            
            {
                this$0 = DayElement.this;
                super();
            }
                };
            }
            if ("DayOfWeek".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final DayElement this$0;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        day.dayOfWeek = i + 1;
                        if (day.dayOfWeek == 8)
                        {
                            day.dayOfWeek = 1;
                        }
                    }

            
            {
                this$0 = DayElement.this;
                super();
            }
                };
            }
            if ("Interval".equals(s1))
            {
                s = new com.ebay.common.model.inventory.LocationDetails.Interval();
                day.intervals.add(s);
                return new IntervalElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public DayElement(com.ebay.common.model.inventory.LocationDetails.Day day1)
        {
            day = day1;
        }
    }

    public static final class HoursElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.inventory.LocationDetails.Hours hours;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Day".equals(s1))
            {
                if (hours.days == null)
                {
                    hours.days = new ArrayList();
                }
                s = new com.ebay.common.model.inventory.LocationDetails.Day();
                hours.days.add(s);
                return new DayElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public HoursElement(com.ebay.common.model.inventory.LocationDetails.Hours hours1)
        {
            hours = hours1;
        }
    }

    public static final class IntervalElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.inventory.LocationDetails.Interval interval;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Open".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final IntervalElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        interval.open = s;
                    }

            
            {
                this$0 = IntervalElement.this;
                super();
            }
                };
            }
            if ("Close".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final IntervalElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        interval.close = s;
                    }

            
            {
                this$0 = IntervalElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public IntervalElement(com.ebay.common.model.inventory.LocationDetails.Interval interval1)
        {
            interval = interval1;
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayResponse response;
        final GetLocationDetailsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
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
                locationFound = false;
            }
            if ("LocationID".equals(s1))
            {
                locationFound = true;
                locationDetails.address = new LocationAddress();
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.id = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.name = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("Address1".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.address.address1 = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("Address2".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.address.address2 = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("City".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.address.city = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("Region".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.address.region = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("PostalCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.address.postalCode = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("Country".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.address.country = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("PickupInstructions".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.pickupInstructions = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("Hours".equals(s1))
            {
                locationDetails.hours = new com.ebay.common.model.inventory.LocationDetails.Hours();
                return new HoursElement(locationDetails.hours);
            }
            if ("UTCHours".equals(s1))
            {
                locationDetails.utcHours = new com.ebay.common.model.inventory.LocationDetails.Hours();
                return new HoursElement(locationDetails.utcHours);
            }
            if ("Latitude".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final RootElement this$1;

                    public void setValue(double d)
                        throws SAXException
                    {
                        locationDetails.address.latitude = d;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("Longitude".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final RootElement this$1;

                    public void setValue(double d)
                        throws SAXException
                    {
                        locationDetails.address.longitude = d;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("Phone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.phone = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("URL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.url = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("UTCOffset".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        locationDetails.utcOffset = s;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement(EbayResponse ebayresponse)
        {
            this$0 = GetLocationDetailsResponse.this;
            super();
            response = ebayresponse;
        }
    }


    public LocationDetails locationDetails;
    private boolean locationFound;

    public GetLocationDetailsResponse()
    {
        locationDetails = new LocationDetails();
    }

    public boolean isLocationFound()
    {
        return locationFound;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement(this));
    }


/*
    static boolean access$002(GetLocationDetailsResponse getlocationdetailsresponse, boolean flag)
    {
        getlocationdetailsresponse.locationFound = flag;
        return flag;
    }

*/
}
