// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.nearby.messages:
//            zza

public class Message
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    public static final int MAX_CONTENT_SIZE_BYTES = 0x19000;
    public static final int MAX_TYPE_LENGTH = 32;
    private final byte content[];
    private final String type;
    final int versionCode;
    private final String zzaeI;

    Message(int i, byte abyte0[], String s, String s1)
    {
        versionCode = i;
        content = (byte[])zzx.zzv(abyte0);
        type = (String)zzx.zzv(s1);
        String s2 = s;
        if (s == null)
        {
            s2 = "";
        }
        zzaeI = s2;
        boolean flag;
        if (abyte0.length <= 0x19000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", new Object[] {
            Integer.valueOf(abyte0.length), Integer.valueOf(0x19000)
        });
        if (s1.length() <= 32)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", new Object[] {
            Integer.valueOf(s1.length()), Integer.valueOf(32)
        });
    }

    public Message(byte abyte0[])
    {
        this(abyte0, "", "");
    }

    public Message(byte abyte0[], String s)
    {
        this(1, abyte0, "", s);
    }

    Message(byte abyte0[], String s, String s1)
    {
        this(1, abyte0, s, s1);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Message))
            {
                return false;
            }
            obj = (Message)obj;
            if (!TextUtils.equals(zzaeI, ((Message) (obj)).zzaeI) || !TextUtils.equals(type, ((Message) (obj)).type) || !Arrays.equals(content, ((Message) (obj)).content))
            {
                return false;
            }
        }
        return true;
    }

    public byte[] getContent()
    {
        return content;
    }

    public String getNamespace()
    {
        return zzaeI;
    }

    public String getType()
    {
        return type;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaeI, type, Integer.valueOf(Arrays.hashCode(content))
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("Message{namespace='").append(zzaeI).append("'").append(", type='").append(type).append("'").append(", content=[").append(content.length).append(" bytes]").append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
