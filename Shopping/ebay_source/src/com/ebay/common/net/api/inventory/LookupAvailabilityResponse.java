// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class LookupAvailabilityResponse extends EbayResponse
{
    static final class Coordinate
    {

        double lat;
        double lon;

        public boolean equals(Object obj)
        {
label0:
            {
                boolean flag = false;
                if (obj instanceof Coordinate)
                {
                    obj = (Coordinate)obj;
                    if (lat != ((Coordinate) (obj)).lat || lon != ((Coordinate) (obj)).lon)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            return false;
        }

        Coordinate(double d, double d1)
        {
            lat = d;
            lon = d1;
        }
    }

    private final class LocationElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        StoreAvailability location;
        final LookupAvailabilityResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Distance".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final LocationElement this$1;

                    public void setValue(double d)
                        throws SAXException
                    {
                        location.distance = d;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Availability".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.availability = com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.valueOf(s);
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("LocationID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.locationId = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.name = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Address1".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.address.address1 = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Address2".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.address.address2 = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("City".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.address.city = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Region".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.address.region = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("PostalCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.address.postalCode = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Country".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.address.country = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Latitude".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final LocationElement this$1;

                    public void setValue(double d)
                        throws SAXException
                    {
                        location.address.latitude = d;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Longitude".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final LocationElement this$1;

                    public void setValue(double d)
                        throws SAXException
                    {
                        location.address.longitude = d;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Phone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.phone = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("PickupInstructions".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.pickupInstructions = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("FulfillmentTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        s = s.replaceAll("\\.\\d*", "");
                        location.fulfillmentTime = Long.valueOf(Duration.parse(s).timeInSeconds * 1000L);
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("URL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.url = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Quantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final LocationElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        location.quantity = Integer.valueOf(i);
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("UTCOffset".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LocationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        location.utcOffset = s;
                    }

            
            {
                this$1 = LocationElement.this;
                super();
            }
                };
            }
            if ("Hours".equals(s1))
            {
                location.hours = new com.ebay.common.model.inventory.LocationDetails.Hours();
                return new GetLocationDetailsResponse.HoursElement(location.hours);
            }
            if ("UTCHours".equals(s1))
            {
                location.utcHours = new com.ebay.common.model.inventory.LocationDetails.Hours();
                return new GetLocationDetailsResponse.HoursElement(location.utcHours);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        LocationElement(StoreAvailability storeavailability)
        {
            this$0 = LookupAvailabilityResponse.this;
            super();
            location = storeavailability;
        }
    }

    static final class LookupAvailabilityComparator
        implements Comparator
    {

        final int availabilityTypeToValue(com.ebay.common.model.inventory.StoreAvailability.AvailabilityType availabilitytype)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[];

                static 
                {
                    $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType = new int[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.IN_STOCK.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.SHIP_TO_STORE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.OUT_OF_STOCK.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.ebay.common.model.inventory.StoreAvailability.AvailabilityType[availabilitytype.ordinal()])
            {
            default:
                return 2;

            case 1: // '\001'
                return 0;

            case 2: // '\002'
                return 1;

            case 3: // '\003'
                return 3;
            }
        }

        public int compare(StoreAvailability storeavailability, StoreAvailability storeavailability1)
        {
            if (storeavailability.availability.equals(storeavailability1.availability))
            {
                double d1 = storeavailability.distance - storeavailability1.distance;
                double d = d1;
                if (Math.abs(d1) < 1.0D)
                {
                    d = d1 * 100D;
                }
                return (int)d;
            } else
            {
                return availabilityTypeToValue(storeavailability.availability) - availabilityTypeToValue(storeavailability1.availability);
            }
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((StoreAvailability)obj, (StoreAvailability)obj1);
        }

        LookupAvailabilityComparator()
        {
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final LookupAvailabilityResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Location".equals(s1))
            {
                if (availabilities == null)
                {
                    availabilities = new ArrayList();
                }
                s = new StoreAvailability();
                s.address = new LocationAddress();
                availabilities.add(s);
                ackCode = 1;
                return new LocationElement(s);
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(LookupAvailabilityResponse.this, "");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = LookupAvailabilityResponse.this;
            super();
        }

    }


    List availabilities;

    public LookupAvailabilityResponse()
    {
    }

    public List getAvailabilities()
    {
        return availabilities;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
        Object obj = availabilities;
        if (obj != null)
        {
            Collections.sort(((List) (obj)), new LookupAvailabilityComparator());
            availabilities = new ArrayList();
            inputstream = new ArrayList();
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                StoreAvailability storeavailability = (StoreAvailability)((Iterator) (obj)).next();
                Coordinate coordinate = new Coordinate(storeavailability.address.latitude, storeavailability.address.longitude);
                if (!inputstream.contains(coordinate))
                {
                    inputstream.add(coordinate);
                    availabilities.add(storeavailability);
                }
            } while (true);
        }
    }
}
