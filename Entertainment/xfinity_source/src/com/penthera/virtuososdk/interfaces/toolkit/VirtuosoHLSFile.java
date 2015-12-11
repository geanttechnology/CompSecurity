// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.penthera.virtuososdk.internal.interfaces.IEngFileFragment;
import com.penthera.virtuososdk.internal.interfaces.IEngVHLSFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.penthera.virtuososdk.interfaces.toolkit:
//            VirtuosoIdentifier, VirtuosoContentBox

class VirtuosoHLSFile extends VirtuosoIdentifier
    implements IEngVHLSFile
{
    private class VirtuosoFileFragment
        implements IEngFileFragment
    {

        long mCompleteTime;
        double mCurrentSize;
        com.penthera.virtuososdk.Common.EFileDownloadStatus mDownloadStatus;
        double mExpectedSize;
        int mId;
        String mPath;
        boolean mPending;
        String mRemotePath;
        final VirtuosoHLSFile this$0;

        public double currentSize()
        {
            return mCurrentSize;
        }

        public com.penthera.virtuososdk.Common.EFileDownloadStatus downloadStatus()
        {
            return mDownloadStatus;
        }

        public double expectedSize()
        {
            return mExpectedSize;
        }

        public String filePath()
        {
            return mPath;
        }

        public void generateFilePath()
        {
            setFilePath(generateFragmentPath(mRemotePath, mId));
        }

        public int id()
        {
            return mId;
        }

        public void markComplete()
        {
            mCompleteTime = System.currentTimeMillis() / 1000L;
            mDownloadStatus = com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete;
            mPending = false;
            if (mExpectedSize > -1D)
            {
                mCurrentSize = mExpectedSize;
            }
        }

        public String remotePath()
        {
            return mRemotePath;
        }

        public void setCurrentSize(double d)
        {
            double d1 = mCurrentSize;
            VirtuosoHLSFile virtuosohlsfile = VirtuosoHLSFile.this;
            virtuosohlsfile.iCurrentSize = virtuosohlsfile.iCurrentSize + (d - d1);
            mCurrentSize = d;
        }

        public void setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus)
        {
            mDownloadStatus = efiledownloadstatus;
        }

        public void setExpectedSize(double d)
        {
            mExpectedSize = d;
        }

        public void setFilePath(String s)
        {
            mPath = s;
        }

        public void setPending(boolean flag)
        {
            mPending = flag;
        }

        public boolean update(Context context)
        {
            int i;
            if (context == null)
            {
                throw new IllegalArgumentException("Invalid Context");
            }
            context = context.getContentResolver();
            i = 0;
            int j = context.update(ContentUris.withAppendedId(com.penthera.virtuososdk.database.impl.provider.FileFragment.FragmentColumns.CONTENT_URI(clientProviderAuth()), mId), updatevalues(), null, null);
            i = j;
_L1:
            return i > 0;
            context;
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(VirtuosoHLSFile.LOG_TAG, "failed updating fragment", context);
              goto _L1
        }

        public ContentValues updatevalues()
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("currentSize", Double.valueOf(mCurrentSize));
            contentvalues.put("expectedSize", Double.valueOf(mExpectedSize));
            contentvalues.put("errorType", Integer.valueOf(mDownloadStatus.ordinal()));
            contentvalues.put("filePath", mPath);
            int i;
            if (mPending)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            contentvalues.put("pending", Integer.valueOf(i));
            if (mCompleteTime > 1L)
            {
                contentvalues.put("completeTime", Long.valueOf(mCompleteTime));
            }
            return contentvalues;
        }

        VirtuosoFileFragment(Cursor cursor)
        {
            boolean flag = true;
            this$0 = VirtuosoHLSFile.this;
            super();
            mPath = null;
            mRemotePath = null;
            mId = -1;
            mExpectedSize = -1D;
            mCurrentSize = 0.0D;
            mPending = false;
            mCompleteTime = -1L;
            mDownloadStatus = com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Not_Pending;
            mRemotePath = cursor.getString(cursor.getColumnIndex("assetUrl"));
            mPath = cursor.getString(cursor.getColumnIndex("filePath"));
            mId = cursor.getInt(cursor.getColumnIndex("_id"));
            mExpectedSize = cursor.getLong(cursor.getColumnIndex("expectedSize"));
            mCurrentSize = cursor.getLong(cursor.getColumnIndex("currentSize"));
            mDownloadStatus = com.penthera.virtuososdk.Common.EFileDownloadStatus.values()[(int)cursor.getLong(cursor.getColumnIndex("errorType"))];
            if (cursor.getShort(cursor.getColumnIndex("pending")) != 1)
            {
                flag = false;
            }
            mPending = flag;
        }
    }


    static final String LOG_TAG = com/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile.getName();
    String iAssetId;
    int iCompletedCount;
    double iCurrentSize;
    double iExpectedSize;
    String iFilePath;
    int iFragmentCount;
    boolean iIsPending;
    String iMetaData;

    VirtuosoHLSFile()
    {
        super(4, 4);
        iExpectedSize = 0.0D;
        iCurrentSize = 0.0D;
        iFragmentCount = 0;
        iCompletedCount = 0;
        iIsPending = true;
    }

    VirtuosoHLSFile(Cursor cursor)
    {
        this();
        refresh(cursor);
    }

    public VirtuosoHLSFile(Parcel parcel)
    {
        iExpectedSize = 0.0D;
        iCurrentSize = 0.0D;
        iFragmentCount = 0;
        iCompletedCount = 0;
        iIsPending = true;
        readFromParcel(parcel);
    }

    public VirtuosoHLSFile(String s, String s1)
    {
        this();
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("aAssetId must be provided");
        } else
        {
            iAssetId = s;
            iMetaData = s1;
            return;
        }
    }

    private ContentValues generateContentValues(String s, Context context, ContentResolver contentresolver)
    {
        context = new ContentValues();
        context.put("assetUrl", s);
        context.put("completeTime", Integer.valueOf(-1));
        context.put("currentSize", Integer.valueOf(0));
        context.put("expectedSize", Integer.valueOf(-1));
        context.put("errorType", Integer.valueOf(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending.ordinal()));
        context.put("pending", Integer.valueOf(1));
        context.put("parentUuid", iUuid);
        return context;
    }

    private String generateFragmentPath(String s, int i)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        String s1;
        StringBuffer stringbuffer;
        StringBuilder stringbuilder;
        stringbuffer = new StringBuffer();
        stringbuffer.append(localBaseDir());
        s1 = (new URL(s)).getPath();
        stringbuilder = new StringBuilder("Path [");
        int j;
        if (TextUtils.isEmpty(s1))
        {
            s = "";
        } else
        {
            s = s1;
        }
        try
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d("TestRunner", stringbuilder.append(s).append("]").toString());
            j = s1.lastIndexOf("/") + 1;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        s = s1.substring(j);
_L1:
        if (!TextUtils.isEmpty(s))
        {
            stringbuffer.append(s);
        } else
        {
            stringbuffer.append(i);
            stringbuffer.append(".ts");
        }
        return stringbuffer.toString();
        s = null;
          goto _L1
    }

    private boolean verifyCanAdd(ContentResolver contentresolver)
    {
        ContentResolver contentresolver1;
        ContentResolver contentresolver2;
        contentresolver2 = null;
        contentresolver1 = null;
        contentresolver = contentresolver.query(Uri.parse((new StringBuilder()).append(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(clientProviderAuth())).append("/cid/").append(iUuid).toString()), new String[] {
            "_id", "errorType"
        }, null, null, null);
        if (contentresolver == null) goto _L2; else goto _L1
_L1:
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        if (!contentresolver.moveToFirst()) goto _L2; else goto _L3
_L3:
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus = com.penthera.virtuososdk.Common.EFileDownloadStatus.values()[(int)contentresolver.getLong(contentresolver.getColumnIndex("errorType"))];
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus1 = com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Not_Pending;
        boolean flag;
        if (efiledownloadstatus == efiledownloadstatus1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (contentresolver != null && !contentresolver.isClosed())
        {
            contentresolver.close();
        }
        return flag;
        contentresolver;
        contentresolver2 = contentresolver1;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "error verifying HLS file instance", contentresolver);
        if (contentresolver1 != null && !contentresolver1.isClosed())
        {
            contentresolver1.close();
        }
_L5:
        return false;
        contentresolver;
        if (contentresolver2 != null && !contentresolver2.isClosed())
        {
            contentresolver2.close();
        }
        throw contentresolver;
_L2:
        if (contentresolver != null && !contentresolver.isClosed())
        {
            contentresolver.close();
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public int addFragments(Context context, List list)
    {
        ContentResolver contentresolver;
        int i;
        int j;
        if (list == null)
        {
            throw new IllegalArgumentException("aFragmentUrls cannot be null");
        }
        if (context == null)
        {
            throw new IllegalArgumentException("Invalid Context");
        }
        contentresolver = context.getContentResolver();
        i = 0;
        j = 0;
        if (!verifyCanAdd(contentresolver)) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        j1 = list.size();
        i1 = Math.min(1000, j1);
        boolean flag = false;
        i = j;
        j = ((flag) ? 1 : 0);
_L9:
        if (j < j1) goto _L3; else goto _L2
_L2:
        iFragmentCount = iFragmentCount + i;
        return i;
_L3:
        Object obj;
        ContentValues acontentvalues[];
        int k;
        obj = list.subList(j, i1);
        acontentvalues = new ContentValues[((List) (obj)).size()];
        k = 0;
_L6:
        if (k < ((List) (obj)).size()) goto _L5; else goto _L4
_L4:
        Object obj1;
        obj1 = null;
        obj = null;
        ContentProviderClient contentproviderclient = contentresolver.acquireContentProviderClient(clientProviderAuth());
        obj = contentproviderclient;
        obj1 = contentproviderclient;
        k = contentproviderclient.bulkInsert(com.penthera.virtuososdk.database.impl.provider.FileFragment.FragmentColumns.CONTENT_URI(clientProviderAuth()), acontentvalues);
        int l;
        j += k;
        i += k;
        k = j;
        l = i;
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
            l = i;
            k = j;
        }
_L7:
        i1 = Math.min(k + 1000, j1);
        j = k;
        i = l;
        continue; /* Loop/switch isn't completed */
_L5:
        acontentvalues[k] = generateContentValues((String)((List) (obj)).get(k), context, contentresolver);
        k++;
          goto _L6
        Exception exception;
        exception;
        obj1 = obj;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "failure bulk insert on fragment list", exception);
        k = j;
        l = i;
        if (obj != null)
        {
            ((ContentProviderClient) (obj)).release();
            k = j;
            l = i;
        }
          goto _L7
        context;
        if (obj1 != null)
        {
            ((ContentProviderClient) (obj1)).release();
        }
        throw context;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public int addFragments(List list)
    {
        return addFragments(VirtuosoContentBox.iApplicationContext, list);
    }

    public String assetId()
    {
        return iAssetId;
    }

    public String assetURL()
    {
        return null;
    }

    public double currentSize()
    {
        return iCurrentSize;
    }

    public double expectedSize()
    {
        if (iCompletedCount == 0)
        {
            return 0.0D;
        } else
        {
            double d = iCurrentSize / (double)iCompletedCount;
            return (double)iFragmentCount * d;
        }
    }

    public double fractionComplete()
    {
        if (iFragmentCount <= 0)
        {
            return 0.0D;
        } else
        {
            return (double)iCompletedCount / (double)iFragmentCount;
        }
    }

    public List fragments()
    {
        return fragments(VirtuosoContentBox.iApplicationContext);
    }

    public List fragments(Context context)
    {
        Object obj;
        Cursor cursor;
        Object obj1;
        ArrayList arraylist;
        ContentResolver contentresolver;
        int i;
        if (context == null)
        {
            throw new IllegalArgumentException("Invalid Context");
        }
        arraylist = new ArrayList();
        obj1 = null;
        cursor = null;
        contentresolver = context.getContentResolver();
        i = 0;
        context = cursor;
        obj = obj1;
        String s = (new StringBuilder()).append(0).append(", ").append(1000).toString();
        context = cursor;
        obj = obj1;
        cursor = contentresolver.query(Uri.parse((new StringBuilder()).append(com.penthera.virtuososdk.database.impl.provider.FileFragment.FragmentColumns.CONTENT_URI(clientProviderAuth())).append("/parent/").append(iUuid).toString()), null, null, null, (new StringBuilder("_id ASC LIMIT ")).append(s).toString());
_L9:
        if (cursor == null) goto _L2; else goto _L1
_L1:
        context = cursor;
        obj = cursor;
        int j = cursor.getCount();
        if (j > 0) goto _L3; else goto _L2
_L2:
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
_L7:
        return arraylist;
_L3:
        context = cursor;
        obj = cursor;
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("retrieving paged fragment results: [")).append(cursor.getCount()).append(", ").append(s).append("]").toString());
        context = cursor;
        obj = cursor;
        if (!cursor.moveToFirst()) goto _L5; else goto _L4
_L4:
        context = cursor;
        obj = cursor;
        arraylist.add(new VirtuosoFileFragment(cursor));
        context = cursor;
        obj = cursor;
        if (cursor.moveToNext()) goto _L4; else goto _L5
_L5:
        i += 1000;
        context = cursor;
        obj = cursor;
        s = (new StringBuilder()).append(i).append(", ").append(1000).toString();
        context = cursor;
        obj = cursor;
        cursor.close();
        obj = null;
        context = null;
        cursor = contentresolver.query(Uri.parse((new StringBuilder()).append(com.penthera.virtuososdk.database.impl.provider.FileFragment.FragmentColumns.CONTENT_URI(clientProviderAuth())).append("/parent/").append(iUuid).toString()), null, null, null, (new StringBuilder("_id ASC LIMIT ")).append(s).toString());
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj = context;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("problem retrieving fragments for [")).append(iUuid).append("]").toString(), exception);
        if (context == null || context.isClosed()) goto _L7; else goto _L6
_L6:
        context.close();
        return arraylist;
        context;
        if (obj != null && !((Cursor) (obj)).isClosed())
        {
            ((Cursor) (obj)).close();
        }
        throw context;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public boolean isPending()
    {
        return iIsPending;
    }

    public String localBaseDir()
    {
        if (TextUtils.isEmpty(iFilePath) && !iFilePath.endsWith("/"))
        {
            iFilePath = (new StringBuilder(String.valueOf(iFilePath))).append("/").toString();
        }
        return iFilePath;
    }

    public String metadata()
    {
        return iMetaData;
    }

    public List pendingFragments(Context context)
    {
        Object obj;
        Cursor cursor;
        Object obj1;
        ArrayList arraylist;
        ContentResolver contentresolver;
        int i;
        if (context == null)
        {
            throw new IllegalArgumentException("Invalid Context");
        }
        arraylist = new ArrayList();
        obj1 = null;
        cursor = null;
        contentresolver = context.getContentResolver();
        i = 0;
        context = cursor;
        obj = obj1;
        String s = (new StringBuilder()).append(0).append(", ").append(1000).toString();
        context = cursor;
        obj = obj1;
        cursor = contentresolver.query(Uri.parse((new StringBuilder()).append(com.penthera.virtuososdk.database.impl.provider.FileFragment.FragmentColumns.CONTENT_URI(clientProviderAuth())).append("/parent/").append(iUuid).toString()), null, "pending=1", null, (new StringBuilder("_id ASC LIMIT ")).append(s).toString());
_L9:
        if (cursor == null) goto _L2; else goto _L1
_L1:
        context = cursor;
        obj = cursor;
        int j = cursor.getCount();
        if (j > 0) goto _L3; else goto _L2
_L2:
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
_L7:
        return arraylist;
_L3:
        context = cursor;
        obj = cursor;
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("retrieving paged fragment results: [")).append(cursor.getCount()).append(", ").append(s).append("]").toString());
        context = cursor;
        obj = cursor;
        if (!cursor.moveToFirst()) goto _L5; else goto _L4
_L4:
        context = cursor;
        obj = cursor;
        arraylist.add(new VirtuosoFileFragment(cursor));
        context = cursor;
        obj = cursor;
        if (cursor.moveToNext()) goto _L4; else goto _L5
_L5:
        i += 1000;
        context = cursor;
        obj = cursor;
        s = (new StringBuilder()).append(i).append(", ").append(1000).toString();
        context = cursor;
        obj = cursor;
        cursor.close();
        obj = null;
        context = null;
        cursor = contentresolver.query(Uri.parse((new StringBuilder()).append(com.penthera.virtuososdk.database.impl.provider.FileFragment.FragmentColumns.CONTENT_URI(clientProviderAuth())).append("/parent/").append(iUuid).toString()), null, "pending=1", null, (new StringBuilder("_id ASC LIMIT ")).append(s).toString());
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj = context;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("problem retrieving fragments for [")).append(iUuid).append("]").toString(), exception);
        if (context == null || context.isClosed()) goto _L7; else goto _L6
_L6:
        context.close();
        return arraylist;
        context;
        if (obj != null && !((Cursor) (obj)).isClosed())
        {
            ((Cursor) (obj)).close();
        }
        throw context;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void readFromParcel(Parcel parcel)
    {
        boolean flag = true;
        super.readFromParcel(parcel);
        iAssetId = readStringProperty(parcel);
        iMetaData = readStringProperty(parcel);
        iExpectedSize = parcel.readDouble();
        iCurrentSize = parcel.readDouble();
        iFilePath = readStringProperty(parcel);
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        iIsPending = flag;
        iFragmentCount = parcel.readInt();
        iCompletedCount = parcel.readInt();
    }

    void refresh(Cursor cursor)
    {
        boolean flag = true;
        setAssetId(cursor.getString(cursor.getColumnIndex("assetId")));
        setCurrentSize(cursor.getLong(cursor.getColumnIndex("currentSize")));
        setExpectedSize(cursor.getLong(cursor.getColumnIndex("expectedSize")));
        iMetaData = cursor.getString(cursor.getColumnIndex("description"));
        setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.values()[(int)cursor.getLong(cursor.getColumnIndex("errorType"))]);
        setLocalBaseDir(cursor.getString(cursor.getColumnIndex("filePath")));
        setUuid(cursor.getString(cursor.getColumnIndex("uuid")));
        if (cursor.getShort(cursor.getColumnIndex("pending")) != 1)
        {
            flag = false;
        }
        setPending(flag);
        setParentUuid(cursor.getString(cursor.getColumnIndex("parentUuid")));
        setId(cursor.getInt(cursor.getColumnIndex("_id")));
        setCompletionTime(cursor.getLong(cursor.getColumnIndex("completeTime")));
        setClientProviderAuth(cursor.getString(cursor.getColumnIndex("clientAuthority")));
        iFragmentCount = cursor.getInt(cursor.getColumnIndex("hlsFragmentCount"));
        iCompletedCount = cursor.getInt(cursor.getColumnIndex("hlsFragmentCompletedCount"));
        setContentState(cursor.getInt(cursor.getColumnIndex("contentState")));
    }

    public void regenerateFilePath(ContentResolver contentresolver, String s, Context context)
    {
        setLocalBaseDir(VirtuosoContentBox.generateFilePath(this, contentresolver, s, context));
    }

    public void setAssetId(String s)
    {
        iAssetId = s;
    }

    public void setCompletedCount(int i)
    {
        iCompletedCount = i;
    }

    public void setCurrentSize(double d)
    {
        iCurrentSize = d;
    }

    public void setExpectedSize(double d)
    {
        iExpectedSize = d;
    }

    public void setLocalBaseDir(String s)
    {
        iFilePath = s;
    }

    public void setMetadata(String s)
    {
        iMetaData = s;
    }

    public void setPending(boolean flag)
    {
        iIsPending = flag;
    }

    public int totalFragments()
    {
        return iFragmentCount;
    }

    public int totalFragmentsComplete()
    {
        return iCompletedCount;
    }

    public boolean updateFragment(Context context, IEngFileFragment iengfilefragment)
    {
        return iengfilefragment.update(context);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        writeStringProperty(parcel, iAssetId);
        writeStringProperty(parcel, iMetaData);
        parcel.writeDouble(expectedSize());
        parcel.writeDouble(iCurrentSize);
        writeStringProperty(parcel, iFilePath);
        if (iIsPending)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(iFragmentCount);
        parcel.writeInt(iCompletedCount);
    }


}
