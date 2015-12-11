// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.util.SparseIntArray;
import co.vine.android.util.FlexibleStringHashMap;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VineVenue
    implements Externalizable
{

    static final Pattern FOURSQUARE_CATEGORY = Pattern.compile("/([^/]+?)/([^/]+?)_\\d*?.png");
    public static final int TYPE_ARTS_ENTERTAINMENT = 11;
    public static final int TYPE_BIG_HUMAN = 2;
    public static final int TYPE_EBAY = 3;
    public static final int TYPE_EDUCATION = 18;
    public static final int TYPE_FACEBOOK = 5;
    public static final int TYPE_GILT = 4;
    public static final int TYPE_GOOGLE = 6;
    public static final int TYPE_JETSETTER = 19;
    public static final int TYPE_NATURE = 14;
    public static final int TYPE_NIGHTLIFE = 13;
    public static final int TYPE_OFFICE = 15;
    public static final int TYPE_OTHER = 20;
    public static final int TYPE_RESIDENTIAL = 10;
    public static final int TYPE_RESTAURANT = 12;
    public static final int TYPE_SHOPS = 16;
    public static final int TYPE_SQUARE = 8;
    public static final int TYPE_SQUARESPACE = 7;
    public static final int TYPE_TRAVEL = 17;
    public static final int TYPE_TWITTER = 9;
    public static final int TYPE_VINE = 1;
    public static final SparseIntArray iconMap;
    private static final long serialVersionUID = 0x50674330882cfd0L;
    private static final HashMap venueMap;
    public String address;
    public String categoryIconUrl;
    public String categoryId;
    public String categoryName;
    public String city;
    public String countryCode;
    public int displayType;
    public String state;
    public String venueName;

    public VineVenue()
    {
    }

    public VineVenue(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
label0:
        {
            String s9 = null;
            super();
            String s8;
            if (s5 != null)
            {
                s8 = s5.toLowerCase();
            } else
            {
                s8 = null;
            }
            if (s1 != null)
            {
                s9 = s1.toLowerCase();
            }
            categoryIconUrl = s;
            categoryName = s1;
            categoryId = s2;
            city = s3;
            countryCode = s4;
            venueName = s5;
            state = s6;
            address = s7;
            s2 = (Integer)venueMap.get(s8);
            if (s2 != null)
            {
                s1 = s2;
                if (s2.intValue() > 0)
                {
                    break label0;
                }
            }
            s2 = (Integer)venueMap.get(s9);
            if (s2 != null)
            {
                s1 = s2;
                if (s2.intValue() > 0)
                {
                    break label0;
                }
            }
            s1 = s2;
            if (s == null)
            {
                break label0;
            }
            s3 = FOURSQUARE_CATEGORY.matcher(s);
            s1 = s2;
            if (!s3.find())
            {
                break label0;
            }
            s = s3.group(2).toLowerCase();
            s = (Integer)venueMap.get(s);
            if (s != null)
            {
                s1 = s;
                if (s.intValue() > 0)
                {
                    break label0;
                }
            }
            s = s3.group(1).toLowerCase();
            s1 = (Integer)venueMap.get(s);
        }
label1:
        {
            if (s1 != null)
            {
                s = s1;
                if (s1.intValue() > 0)
                {
                    break label1;
                }
            }
            s = Integer.valueOf(20);
        }
        displayType = s.intValue();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (VineVenue)obj;
            if (displayType != ((VineVenue) (obj)).displayType)
            {
                return false;
            }
            if (address == null ? ((VineVenue) (obj)).address != null : !address.equals(((VineVenue) (obj)).address))
            {
                return false;
            }
            if (categoryIconUrl == null ? ((VineVenue) (obj)).categoryIconUrl != null : !categoryIconUrl.equals(((VineVenue) (obj)).categoryIconUrl))
            {
                return false;
            }
            if (categoryId == null ? ((VineVenue) (obj)).categoryId != null : !categoryId.equals(((VineVenue) (obj)).categoryId))
            {
                return false;
            }
            if (categoryName == null ? ((VineVenue) (obj)).categoryName != null : !categoryName.equals(((VineVenue) (obj)).categoryName))
            {
                return false;
            }
            if (city == null ? ((VineVenue) (obj)).city != null : !city.equals(((VineVenue) (obj)).city))
            {
                return false;
            }
            if (countryCode == null ? ((VineVenue) (obj)).countryCode != null : !countryCode.equals(((VineVenue) (obj)).countryCode))
            {
                return false;
            }
            if (state == null ? ((VineVenue) (obj)).state != null : !state.equals(((VineVenue) (obj)).state))
            {
                return false;
            }
            if (venueName == null ? ((VineVenue) (obj)).venueName != null : !venueName.equals(((VineVenue) (obj)).venueName))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if (categoryIconUrl != null)
        {
            i = categoryIconUrl.hashCode();
        } else
        {
            i = 0;
        }
        if (categoryName != null)
        {
            j = categoryName.hashCode();
        } else
        {
            j = 0;
        }
        if (categoryId != null)
        {
            k = categoryId.hashCode();
        } else
        {
            k = 0;
        }
        if (city != null)
        {
            l = city.hashCode();
        } else
        {
            l = 0;
        }
        if (countryCode != null)
        {
            i1 = countryCode.hashCode();
        } else
        {
            i1 = 0;
        }
        if (venueName != null)
        {
            j1 = venueName.hashCode();
        } else
        {
            j1 = 0;
        }
        if (state != null)
        {
            k1 = state.hashCode();
        } else
        {
            k1 = 0;
        }
        if (address != null)
        {
            l1 = address.hashCode();
        }
        return (((((((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + displayType;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        categoryIconUrl = (String)objectinput.readObject();
        categoryName = (String)objectinput.readObject();
        categoryId = (String)objectinput.readObject();
        city = (String)objectinput.readObject();
        countryCode = (String)objectinput.readObject();
        venueName = (String)objectinput.readObject();
        state = (String)objectinput.readObject();
        address = (String)objectinput.readObject();
        displayType = objectinput.readInt();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(categoryIconUrl);
        objectoutput.writeObject(categoryName);
        objectoutput.writeObject(categoryId);
        objectoutput.writeObject(city);
        objectoutput.writeObject(countryCode);
        objectoutput.writeObject(venueName);
        objectoutput.writeObject(state);
        objectoutput.writeObject(address);
        objectoutput.writeInt(displayType);
    }

    static 
    {
        iconMap = new SparseIntArray();
        venueMap = new FlexibleStringHashMap();
        iconMap.put(1, 0x7f020180);
        iconMap.put(2, 0x7f02016e);
        iconMap.put(3, 0x7f02016f);
        iconMap.put(4, 0x7f020172);
        iconMap.put(5, 0x7f020171);
        iconMap.put(6, 0x7f020173);
        iconMap.put(7, 0x7f02017c);
        iconMap.put(8, 0x7f02017b);
        iconMap.put(9, 0x7f02017e);
        iconMap.put(10, 0x7f020178);
        iconMap.put(11, 0x7f020170);
        iconMap.put(12, 0x7f020179);
        iconMap.put(13, 0x7f020176);
        iconMap.put(14, 0x7f020175);
        iconMap.put(15, 0x7f020177);
        iconMap.put(16, 0x7f02017a);
        iconMap.put(17, 0x7f02017d);
        iconMap.put(18, 0x7f02017f);
        iconMap.put(19, 0x7f020174);
        iconMap.put(20, 0x7f02019b);
        venueMap.put("vine hq", Integer.valueOf(1));
        venueMap.put("verse hq", Integer.valueOf(1));
        venueMap.put("twitter nyc", Integer.valueOf(9));
        venueMap.put("twitter, inc", Integer.valueOf(9));
        venueMap.put("square, inc", Integer.valueOf(8));
        venueMap.put("squarespace hq", Integer.valueOf(7));
        venueMap.put("jetsetter", Integer.valueOf(19));
        venueMap.put("gilt city", Integer.valueOf(4));
        venueMap.put("gilt groupe", Integer.valueOf(4));
        venueMap.put("facebook", Integer.valueOf(5));
        venueMap.put("ebay", Integer.valueOf(3));
        venueMap.put("big human", Integer.valueOf(2));
        venueMap.put("arts_entertainment", Integer.valueOf(11));
        venueMap.put("education", Integer.valueOf(18));
        venueMap.put("event", Integer.valueOf(11));
        venueMap.put("food", Integer.valueOf(12));
        venueMap.put("home", Integer.valueOf(10));
        venueMap.put("nightlife", Integer.valueOf(13));
        venueMap.put("parks_outdoors", Integer.valueOf(14));
        venueMap.put("travel", Integer.valueOf(17));
        venueMap.put("shops", Integer.valueOf(16));
        venueMap.put("nightlife", Integer.valueOf(13));
        venueMap.put("tech startup", Integer.valueOf(15));
    }
}
