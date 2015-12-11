// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;

public class VineRecipient
    implements Externalizable, Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineRecipient createFromParcel(Parcel parcel)
        {
            return new VineRecipient(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineRecipient[] newArray(int i)
        {
            return new VineRecipient[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String KEY_DISPLAY = "display";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONE = "phoneNumber";
    public static final String KEY_RECIPIENT_ID = "recipientId";
    public static final String KEY_USER_ID = "userId";
    public String avatarUrl;
    public int color;
    public long contactId;
    public String display;
    public long friendIndex;
    public String key;
    public long lastFriendRefresh;
    public long recipientId;
    public int sectionIndex;
    public String sectionTitle;
    public long userId;
    public String value;

    public VineRecipient(Parcel parcel)
    {
        lastFriendRefresh = -1L;
        key = parcel.readString();
        value = parcel.readString();
        userId = parcel.readLong();
        recipientId = parcel.readLong();
        display = parcel.readString();
    }

    private VineRecipient(String s, String s1, long l, String s2, int i, long l1)
    {
        lastFriendRefresh = -1L;
        key = s;
        value = s1;
        userId = l;
        display = s2;
        color = i;
        recipientId = l1;
    }

    public static VineRecipient fromEmail(String s, long l, String s1, long l1)
    {
        return new VineRecipient("email", s1, l, s, -1, l1);
    }

    public static VineRecipient fromJson(JsonParser jsonparser)
        throws IOException
    {
        Object obj;
        Object obj1;
        String s;
        String s1;
        String s2;
        long l;
        s2 = null;
        s1 = null;
        s = null;
        obj1 = null;
        l = 0L;
        obj = jsonparser.nextToken();
_L2:
        String s3;
        String s4;
        Object obj2;
        long l1;
        if (obj == null || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_292;
        }
        static class _cls2
        {

            static final int $SwitchMap$com$fasterxml$jackson$core$JsonToken[];

            static 
            {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken = new int[JsonToken.values().length];
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.fasterxml.jackson.core.JsonToken[((JsonToken) (obj)).ordinal()])
        {
        default:
            obj2 = obj1;
            s4 = s;
            l1 = l;
            s3 = s1;
            obj = s2;
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_237;
        }
_L3:
        JsonToken jsontoken = jsonparser.nextToken();
        s2 = ((String) (obj));
        s1 = s3;
        l = l1;
        s = s4;
        obj1 = obj2;
        obj = jsontoken;
        if (true) goto _L2; else goto _L1
_L1:
        String s5 = jsonparser.getCurrentName();
        if ("phoneNumber".equals(s5) || "email".equals(s5))
        {
            obj = s5;
            s3 = jsonparser.getText();
            l1 = l;
            s4 = s;
            obj2 = obj1;
        } else
        if ("recipientId".equals(s5))
        {
            obj2 = jsonparser.getText();
            obj = s2;
            s3 = s1;
            l1 = l;
            s4 = s;
        } else
        {
            obj = s2;
            s3 = s1;
            l1 = l;
            s4 = s;
            obj2 = obj1;
            if ("display".equals(s5))
            {
                s4 = jsonparser.getText();
                obj = s2;
                s3 = s1;
                l1 = l;
                obj2 = obj1;
            }
        }
          goto _L3
        String s6 = jsonparser.getCurrentName();
        obj = s2;
        s3 = s1;
        l1 = l;
        s4 = s;
        obj2 = obj1;
        if ("userId".equals(s6))
        {
            obj = s6;
            l1 = jsonparser.getLongValue();
            s3 = s1;
            s4 = s;
            obj2 = obj1;
        }
          goto _L3
        long l2 = -1L;
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            l2 = Long.valueOf(((String) (obj1))).longValue();
        }
        return new VineRecipient(s2, s1, l, s, 0, l2);
    }

    public static VineRecipient fromPhone(String s, long l, String s1, long l1)
    {
        return new VineRecipient("phoneNumber", s1, l, s, -1, l1);
    }

    public static VineRecipient fromRecipientId(String s, long l, String s1, long l1)
    {
        return new VineRecipient("phoneNumber", s1, l, s, -1, l1);
    }

    public static VineRecipient fromUser(long l)
    {
        return fromUser(null, l, 0, -1L);
    }

    public static VineRecipient fromUser(String s, long l, int i, long l1)
    {
        return new VineRecipient("userId", null, l, s, i, l1);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (VineRecipient)obj;
            if (display == null ? ((VineRecipient) (obj)).display != null : !display.equals(((VineRecipient) (obj)).display))
            {
                return false;
            }
            if (key == null ? ((VineRecipient) (obj)).key != null : !key.equals(((VineRecipient) (obj)).key))
            {
                return false;
            }
            if (value == null ? ((VineRecipient) (obj)).value != null : !value.equals(((VineRecipient) (obj)).value))
            {
                return false;
            }
            if (userId != ((VineRecipient) (obj)).userId)
            {
                return false;
            }
            if (recipientId != ((VineRecipient) (obj)).recipientId)
            {
                return false;
            }
        }
        return true;
    }

    public String getTextSortKey()
    {
        return display.substring(0, 1).toUpperCase();
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (key != null)
        {
            i = key.hashCode();
        } else
        {
            i = 0;
        }
        if (value != null)
        {
            j = value.hashCode();
        }
        return ((i * 31 + j) * 31 + (int)(userId ^ userId >>> 32)) * 31 + (int)(recipientId ^ recipientId >>> 32);
    }

    public boolean isFromEmail()
    {
        return "email".equals(key);
    }

    public boolean isFromPhone()
    {
        return "phoneNumber".equals(key);
    }

    public boolean isFromUser()
    {
        return "userId".equals(key);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        key = (String)objectinput.readObject();
        value = (String)objectinput.readObject();
        userId = objectinput.readLong();
        recipientId = objectinput.readLong();
        display = objectinput.readLine();
    }

    public HashMap toMap()
    {
        HashMap hashmap = new HashMap();
        if ("userId".equals(key))
        {
            hashmap.put(key, Long.valueOf(userId));
        } else
        {
            hashmap.put(key, value);
        }
        if (recipientId > 0L)
        {
            hashmap.put("recipientId", String.valueOf(recipientId));
        }
        if (display != null)
        {
            hashmap.put("display", display);
        }
        return hashmap;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(key);
        objectoutput.writeObject(value);
        objectoutput.writeLong(userId);
        objectoutput.writeLong(recipientId);
        objectoutput.writeChars(display);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(key);
        parcel.writeString(value);
        parcel.writeLong(userId);
        parcel.writeLong(recipientId);
        parcel.writeString(display);
    }

}
