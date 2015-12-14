// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;

import android.content.ContentProviderOperation;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.mixtape.upload:
//            UploadErrorCode

public class UploadRequest
    implements Parcelable
{
    public static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State BLOCKED;
        public static final State DONE;
        public static final State QUEUED;
        public static final State SIDELINED;
        public static final State STARTED;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/amazon/mixtape/upload/UploadRequest$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            DONE = new State("DONE", 0);
            STARTED = new State("STARTED", 1);
            QUEUED = new State("QUEUED", 2);
            BLOCKED = new State("BLOCKED", 3);
            SIDELINED = new State("SIDELINED", 4);
            $VALUES = (new State[] {
                DONE, STARTED, QUEUED, BLOCKED, SIDELINED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UploadRequest createFromParcel(Parcel parcel)
        {
            String s1 = parcel.readString();
            String s2 = parcel.readString();
            Uri uri = Uri.parse(parcel.readString());
            long l = parcel.readLong();
            int i = parcel.readInt();
            String s;
            boolean flag;
            boolean flag1;
            if (parcel.readByte() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (parcel.readByte() > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (parcel.readByte() > 0)
            {
                s = parcel.readString();
            } else
            {
                s = null;
            }
            if (parcel.readByte() > 0)
            {
                parcel = parcel.readString();
            } else
            {
                parcel = null;
            }
            return new UploadRequest(-1, s1, s2, parcel, uri, l, s, null, flag, flag1, i, 0, 0, UploadRequest.NO_BLOCKERS, null, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UploadRequest[] newArray(int i)
        {
            return new UploadRequest[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final Set NO_BLOCKERS = Collections.emptySet();
    private String mAccountId;
    private int mAttempts;
    private Set mBlockers;
    private long mFileSize;
    private Uri mFileUri;
    private int mId;
    private UploadErrorCode mLastError;
    private String mMd5;
    private String mName;
    private String mParentId;
    private int mPriority;
    private String mQueue;
    private boolean mRenameOnNameConflict;
    private int mRetryExceptions;
    private State mState;
    private boolean mSuppressDeduplication;

    UploadRequest(int i, String s, String s1, String s2, Uri uri, long l, 
            String s3, State state, boolean flag, boolean flag1, int j, int k, int i1, 
            Set set, String s4, UploadErrorCode uploaderrorcode)
    {
        mId = i;
        mQueue = s1;
        mParentId = s2;
        mAccountId = s;
        mFileUri = uri;
        mFileSize = l;
        mName = s3;
        mPriority = j;
        mState = state;
        mSuppressDeduplication = flag;
        mRenameOnNameConflict = flag1;
        mAttempts = k;
        mRetryExceptions = i1;
        mBlockers = Collections.unmodifiableSet(set);
        mMd5 = s4;
        mLastError = uploaderrorcode;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof UploadRequest) || (((UploadRequest) (obj = (UploadRequest)obj)).mId != mId || !((UploadRequest) (obj)).mAccountId.equals(mAccountId)))
            {
                return false;
            }
        }
        return true;
    }

    public String getAccountId()
    {
        return mAccountId;
    }

    int getAttempts()
    {
        return mAttempts;
    }

    public Set getBlockers()
    {
        return mBlockers;
    }

    public long getFileSize()
    {
        return mFileSize;
    }

    public Uri getFileUri()
    {
        return mFileUri;
    }

    public int getId()
    {
        return mId;
    }

    public UploadErrorCode getLastError()
    {
        return mLastError;
    }

    public String getName()
    {
        return mName;
    }

    public String getParentId()
    {
        return mParentId;
    }

    public int getPriority()
    {
        return mPriority;
    }

    public boolean getRenameOnNameConflict()
    {
        return mRenameOnNameConflict;
    }

    int getRetryExceptions()
    {
        return mRetryExceptions;
    }

    State getState()
    {
        return mState;
    }

    public boolean getSuppressDeduplication()
    {
        return mSuppressDeduplication;
    }

    ArrayList getWriteOperations(String s)
    {
        ArrayList arraylist = new ArrayList(2);
        Object obj = com.amazon.mixtape.provider.UploadContract.Request.getContentUri(s, mAccountId);
        Uri uri = com.amazon.mixtape.provider.UploadContract.RequestBlocker.getContentUri(s, mAccountId);
        if (mId == -1)
        {
            s = ContentProviderOperation.newInsert(((Uri) (obj)));
        } else
        {
            s = ContentProviderOperation.newUpdate(((Uri) (obj)));
            s.withSelection((new StringBuilder()).append("_id == ").append(mId).toString(), null);
        }
        if (mFileSize == -1L && "file".equals(mFileUri.getScheme()))
        {
            mFileSize = (new File(mFileUri.getPath())).length();
        }
        s.withValue("queue", mQueue);
        s.withValue("file_uri", mFileUri.toString());
        s.withValue("file_size", Long.valueOf(mFileSize));
        s.withValue("name", mName);
        s.withValue("parent_id", mParentId);
        s.withValue("priority", Integer.valueOf(mPriority));
        if (mState == null)
        {
            obj = State.QUEUED.name();
        } else
        {
            obj = mState.name();
        }
        s.withValue("state", obj);
        s.withValue("md5", mMd5);
        s.withValue("suppress_deduplication", Boolean.valueOf(mSuppressDeduplication));
        s.withValue("rename_on_name_conflict", Boolean.valueOf(mRenameOnNameConflict));
        s.withValue("attempts", Integer.valueOf(mAttempts));
        s.withValue("retry_exceptions", Integer.valueOf(mRetryExceptions));
        if (getLastError() != null)
        {
            s.withValue("last_error", Integer.valueOf(getLastError().toInt()));
        } else
        {
            s.withValue("last_error", null);
        }
        arraylist.add(s.build());
        if (mId != -1)
        {
            s = ContentProviderOperation.newDelete(uri);
            s.withSelection((new StringBuilder()).append("request_id == ").append(mId).toString(), null);
            arraylist.add(s.build());
            s = ContentProviderOperation.newInsert(uri);
            for (obj = mBlockers.iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(s.build()))
            {
                String s1 = (String)((Iterator) (obj)).next();
                s.withValue("request_id", Integer.valueOf(mId));
                s.withValue("blocker_name", s1);
            }

        }
        return arraylist;
    }

    public int hashCode()
    {
        return mId ^ mAccountId.hashCode();
    }

    int incrementRetryExceptions()
    {
        int i = mRetryExceptions + 1;
        mRetryExceptions = i;
        return i;
    }

    void setAttempts(int i)
    {
        mAttempts = i;
    }

    void setBlockers(Set set)
    {
        mBlockers = set;
    }

    public void setLastError(UploadErrorCode uploaderrorcode)
    {
        mLastError = uploaderrorcode;
    }

    void setPriority(int i)
    {
        mPriority = i;
    }

    void setState(State state)
    {
        mState = state;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mId != -1)
        {
            throw new IllegalStateException("Cannot create an intent for an UploadRequest which has already been enqueued.");
        }
        parcel.writeString(mAccountId);
        parcel.writeString(mQueue);
        parcel.writeString(mFileUri.toString());
        parcel.writeLong(mFileSize);
        parcel.writeInt(mPriority);
        byte byte0;
        if (mSuppressDeduplication)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mRenameOnNameConflict)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mName != null)
        {
            parcel.writeByte((byte)1);
            parcel.writeString(mName);
        } else
        {
            parcel.writeByte((byte)0);
        }
        if (mParentId != null)
        {
            parcel.writeByte((byte)1);
            parcel.writeString(mParentId);
            return;
        } else
        {
            parcel.writeByte((byte)0);
            return;
        }
    }

}
