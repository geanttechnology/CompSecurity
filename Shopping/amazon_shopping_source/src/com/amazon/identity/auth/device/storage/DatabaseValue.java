// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import com.amazon.identity.auth.device.utils.GenericUtils;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.PublicCloneable;
import java.util.Date;
import java.util.Locale;

public class DatabaseValue
    implements PublicCloneable
{

    private final Date mDateTime;
    private boolean mIsDeleted;
    private boolean mIsDirty;
    private final Object mValue;

    DatabaseValue(Object obj, Date date, boolean flag, boolean flag1)
    {
        MAPArgContracts.throwIfNull(date, "dateTime");
        mValue = obj;
        mDateTime = (Date)date.clone();
        mIsDirty = flag;
        mIsDeleted = flag1;
    }

    public DatabaseValue cloneObject()
    {
        DatabaseValue databasevalue;
        try
        {
            databasevalue = new DatabaseValue(GenericUtils.typeSafeClone(mValue), (Date)mDateTime.clone(), mIsDirty, mIsDeleted);
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new RuntimeException(clonenotsupportedexception);
        }
        return databasevalue;
    }

    public volatile PublicCloneable cloneObject()
    {
        return cloneObject();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (DatabaseValue)obj;
            if (mIsDeleted != ((DatabaseValue) (obj)).mIsDeleted || mIsDirty != ((DatabaseValue) (obj)).mIsDirty || !getDateTime().equals(getDateTime()) || !GenericUtils.equals(getValue(), ((DatabaseValue) (obj)).getValue()))
            {
                return false;
            }
        }
        return true;
    }

    Date getDateTime()
    {
        return (Date)mDateTime.clone();
    }

    Object getValue()
    {
        return mValue;
    }

    public int hashCode()
    {
        char c1 = '\u04CF';
        int j = 0;
        int i;
        char c;
        if (mDateTime == null)
        {
            i = 0;
        } else
        {
            i = mDateTime.hashCode();
        }
        if (mIsDeleted)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        if (!mIsDirty)
        {
            c1 = '\u04D5';
        }
        if (mValue != null)
        {
            j = mValue.hashCode();
        }
        return (((i + 31) * 31 + c) * 31 + c1) * 31 + j;
    }

    boolean isAfter(Date date)
    {
        if (date == null)
        {
            return true;
        } else
        {
            return mDateTime.after(date);
        }
    }

    boolean isDeleted()
    {
        return mIsDeleted;
    }

    boolean isDirty()
    {
        return mIsDirty;
    }

    boolean isLaterThan(DatabaseValue databasevalue)
    {
        if (databasevalue == null)
        {
            return true;
        } else
        {
            return mDateTime.after(databasevalue.mDateTime);
        }
    }

    void setNotDirtyIfHasCurrentTimeStamp(Date date)
    {
        if (!mDateTime.equals(date))
        {
            return;
        } else
        {
            mIsDirty = false;
            return;
        }
    }

    void setNotDirtyIfIsBeforeOrEqualToTimestamp(Date date)
    {
        if (mDateTime.after(date))
        {
            return;
        } else
        {
            mIsDirty = false;
            return;
        }
    }

    public String toString()
    {
        Locale locale = Locale.US;
        String s;
        if (mValue != null)
        {
            s = mValue.toString();
        } else
        {
            s = "None";
        }
        return String.format(locale, "Value: %s, TimeStamp: %d, Deleted: %s, Dirty: %s", new Object[] {
            s, Long.valueOf(mDateTime.getTime()), Boolean.toString(mIsDeleted), Boolean.toString(mIsDirty)
        });
    }
}
