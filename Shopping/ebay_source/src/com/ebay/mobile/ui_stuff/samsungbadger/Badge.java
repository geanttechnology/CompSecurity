// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ui_stuff.samsungbadger;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.List;

// Referenced classes of package com.ebay.mobile.ui_stuff.samsungbadger:
//            BadgeColumns, Preferences

public final class Badge
    implements Parcelable, BadgeColumns
{

    private static final String BADGE_SELECTION = "package=?";
    private static final int CONTENT_BADGE_COUNT_COLUMN = 3;
    private static final int CONTENT_CLASS_COLUMN = 2;
    private static final int CONTENT_ICON_COLUMN = 4;
    private static final int CONTENT_ID_COLUMN = 0;
    private static final int CONTENT_PACKAGE_COLUMN = 1;
    private static final String CONTENT_PROJECTION[] = {
        "_id", "package", "class", "badgecount", "icon"
    };
    private static final Uri CONTENT_URI = Uri.parse("content://com.sec.badge/apps");
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Badge createFromParcel(Parcel parcel)
        {
            return new Badge(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Badge[] newArray(int i)
        {
            return new Badge[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public int mBadgeCount;
    public Uri mBaseUri;
    public String mClass;
    public byte mIcon[];
    public long mId;
    public String mPackage;

    public Badge()
    {
        mBaseUri = CONTENT_URI;
    }

    public Badge(Parcel parcel)
    {
        mBaseUri = CONTENT_URI;
        mId = parcel.readLong();
        mPackage = parcel.readString();
        mClass = parcel.readString();
        mBadgeCount = parcel.readInt();
        mIcon = parcel.createByteArray();
    }

    public static boolean deleteAllBadges(Context context)
    {
        if (!isBadgingSupported(context))
        {
            throw new UnsupportedOperationException();
        }
        return context.getContentResolver().delete(CONTENT_URI, "package=?", new String[] {
            context.getPackageName()
        }) > 0;
    }

    public static Badge[] getAllBadges(Context context)
    {
        if (!isBadgingSupported(context))
        {
            return null;
        }
        context = context.getContentResolver().query(CONTENT_URI, CONTENT_PROJECTION, null, null, null);
        boolean flag = context.moveToFirst();
        if (!flag)
        {
            context.close();
            return null;
        }
        Object obj;
        obj = new Badge[context.getCount()];
        context.moveToPosition(-1);
        while (context.moveToNext()) 
        {
            Badge badge = new Badge();
            badge.restore(context);
            obj[context.getPosition()] = badge;
        }
        break MISSING_BLOCK_LABEL_106;
        obj;
        context.close();
        throw obj;
        context.close();
        return ((Badge []) (obj));
    }

    public static Badge getBadge(Context context)
    {
        if (isBadgingSupported(context)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((context = context.getContentResolver().query(CONTENT_URI, CONTENT_PROJECTION, "package=?", new String[] {
            context.getPackageName()
        }, null)) == null) goto _L1; else goto _L3
_L3:
        boolean flag = context.moveToFirst();
        if (!flag)
        {
            context.close();
            return null;
        }
        Badge badge;
        badge = new Badge();
        badge.restore(context);
        context.close();
        return badge;
        Exception exception;
        exception;
        context.close();
        throw exception;
    }

    public static boolean isBadgingSupported(Context context)
    {
        Preferences preferences = Preferences.getPreferences(context);
        int i = preferences.getIsBadgingSupported();
        if (i == -1)
        {
            Object obj = null;
            boolean flag;
            try
            {
                context = context.getContentResolver().query(CONTENT_URI, null, null, null, null);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = obj;
            }
            if (context == null)
            {
                preferences.setIsBadgingSupported(false);
                return false;
            } else
            {
                context.close();
                preferences.setIsBadgingSupported(true);
                return true;
            }
        }
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    private boolean isSaved()
    {
        return mId > 0L;
    }

    private void restore(Cursor cursor)
    {
        mId = cursor.getLong(0);
        mPackage = cursor.getString(1);
        mClass = cursor.getString(2);
        mBadgeCount = cursor.getInt(3);
        mIcon = cursor.getBlob(4);
    }

    private ContentValues toContentValues()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("package", mPackage);
        contentvalues.put("class", mClass);
        contentvalues.put("badgecount", Integer.valueOf(mBadgeCount));
        contentvalues.put("icon", mIcon);
        return contentvalues;
    }

    public boolean delete(Context context)
    {
        if (!isBadgingSupported(context))
        {
            throw new UnsupportedOperationException();
        }
        Uri uri = ContentUris.withAppendedId(mBaseUri, mId);
        return context.getContentResolver().delete(uri, null, null) > 0;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof Badge))
            {
                return false;
            }
            obj = (Badge)obj;
            if (mId != ((Badge) (obj)).mId)
            {
                return false;
            }
            if (!TextUtils.equals(mPackage, ((Badge) (obj)).mPackage))
            {
                return false;
            }
            if (!TextUtils.equals(mClass, ((Badge) (obj)).mClass))
            {
                return false;
            }
            if (mBadgeCount != ((Badge) (obj)).mBadgeCount)
            {
                return false;
            }
            if (mIcon != ((Badge) (obj)).mIcon)
            {
                return false;
            }
        }
        return true;
    }

    public Bitmap getIcon()
    {
        if (mIcon == null || mIcon.length == 0)
        {
            return null;
        } else
        {
            return BitmapFactory.decodeByteArray(mIcon, 0, mIcon.length);
        }
    }

    public int hashCode()
    {
        int k = 0;
        int l = (int)(mId ^ mId >>> 32);
        int i;
        int j;
        int i1;
        if (mPackage == null)
        {
            i = 0;
        } else
        {
            i = mPackage.hashCode();
        }
        if (mClass == null)
        {
            j = 0;
        } else
        {
            j = mClass.hashCode();
        }
        i1 = mBadgeCount;
        if (mIcon != null)
        {
            k = mIcon.hashCode();
        }
        return ((((l + 527) * 31 + i) * 31 + j) * 31 + i1) * 31 + k;
    }

    public Uri save(Context context)
    {
        if (isSaved() || !isBadgingSupported(context))
        {
            throw new UnsupportedOperationException();
        } else
        {
            context = context.getContentResolver().insert(mBaseUri, toContentValues());
            mId = Long.parseLong((String)context.getPathSegments().get(1));
            return context;
        }
    }

    public void setIcon(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return;
        } else
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
            mIcon = bytearrayoutputstream.toByteArray();
            return;
        }
    }

    public void setIcon(Drawable drawable)
    {
        if (drawable == null)
        {
            return;
        } else
        {
            setIcon(((BitmapDrawable)drawable).getBitmap());
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("_id: ").append(String.valueOf(mId)).append(", ").append("package").append(": ").append(String.valueOf(mPackage)).append(", ").append("class").append(": ").append(String.valueOf(mClass)).append(", ").append("badgecount").append(": ").append(String.valueOf(mBadgeCount)).append(", ").append("hasIcon: ");
        String s;
        if (mIcon != null)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        return stringbuilder.append(s).toString();
    }

    public boolean update(Context context)
    {
        if (!isSaved() || !isBadgingSupported(context))
        {
            throw new UnsupportedOperationException();
        }
        Uri uri = ContentUris.withAppendedId(mBaseUri, mId);
        return context.getContentResolver().update(uri, toContentValues(), null, null) > 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(mId);
        parcel.writeString(mPackage);
        parcel.writeString(mClass);
        parcel.writeInt(mBadgeCount);
        parcel.writeByteArray(mIcon);
    }

}
