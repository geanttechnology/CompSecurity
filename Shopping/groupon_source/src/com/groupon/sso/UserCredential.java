// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.sso;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;

// Referenced classes of package com.groupon.sso:
//            SymmetricEncryption

public class UserCredential
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UserCredential createFromParcel(Parcel parcel)
        {
            return new UserCredential(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UserCredential[] newArray(int i)
        {
            return new UserCredential[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int PARCEL_VERSION = 1;
    private static final String PASSWORD_VERSION = "AES128";
    private String countryCode;
    private String encryptedPassword;
    private String packageName;
    private String passwordVersion;
    private String userFullName;
    private String username;

    public UserCredential()
    {
    }

    public UserCredential(Parcel parcel)
    {
        int i = parcel.readInt();
        if (1 != i)
        {
            Log.e("UserCredential", (new StringBuilder()).append("parcel version: ").append(i).append(" is not equal to only supported version: ").append(1).toString());
            return;
        } else
        {
            username = parcel.readString();
            encryptedPassword = parcel.readString();
            passwordVersion = parcel.readString();
            countryCode = parcel.readString();
            userFullName = parcel.readString();
            return;
        }
    }

    public UserCredential(String s, String s1, String s2)
    {
        username = s;
        encryptedPassword = SymmetricEncryption.encrypt(s1);
        passwordVersion = "AES128";
        countryCode = s2;
    }

    public UserCredential(String s, String s1, String s2, String s3)
    {
        username = s;
        encryptedPassword = SymmetricEncryption.encrypt(s1);
        passwordVersion = "AES128";
        countryCode = s2;
        userFullName = s3;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    String getEncryptedPassword()
    {
        return encryptedPassword;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public String getPassword()
    {
        if (!TextUtils.equals("AES128", passwordVersion))
        {
            Log.e("UserCredential", (new StringBuilder()).append("password version: ").append(passwordVersion).append(" is not equal to only supported version: ").append("AES128").toString());
            return null;
        } else
        {
            return SymmetricEncryption.decrypt(encryptedPassword);
        }
    }

    public String getPasswordVersion()
    {
        return passwordVersion;
    }

    public String getUserFullName()
    {
        return userFullName;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean isValid()
    {
        return !TextUtils.isEmpty(getUsername()) && !TextUtils.isEmpty(getEncryptedPassword()) && !TextUtils.isEmpty(getCountryCode());
    }

    public void setCountryCode(String s)
    {
        countryCode = s;
    }

    public void setEncryptedPassword(String s)
    {
        encryptedPassword = s;
    }

    public void setPackageName(String s)
    {
        packageName = s;
    }

    public void setPasswordVersion(String s)
    {
        if (!TextUtils.equals("AES128", s))
        {
            Log.e("UserCredential", "password version can't be handled");
        }
        passwordVersion = s;
    }

    public void setPlainTextPassword(String s)
    {
        encryptedPassword = SymmetricEncryption.encrypt(s);
    }

    public void setUserFullName(String s)
    {
        userFullName = s;
    }

    public void setUsername(String s)
    {
        username = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Username: ").append(username).append(", Password: ").append(encryptedPassword).append(", Country Code: ").append(countryCode).append(" app: ").append(packageName).append(" Full name: ").append(userFullName).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(1);
        parcel.writeString(username);
        parcel.writeString(encryptedPassword);
        parcel.writeString(passwordVersion);
        parcel.writeString(countryCode);
        parcel.writeString(userFullName);
    }

}
