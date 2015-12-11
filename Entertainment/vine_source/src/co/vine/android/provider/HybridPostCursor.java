// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import co.vine.android.api.VineComment;
import co.vine.android.api.VineComparatorFactory;
import co.vine.android.api.VineLike;
import co.vine.android.api.VinePagedData;
import co.vine.android.api.VinePost;
import co.vine.android.client.AppController;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package co.vine.android.provider:
//            GroupCursor

public class HybridPostCursor extends GroupCursor
{

    public static final String EXTRA_INCLUDE_LIST = "include_list";
    public static final String EXTRA_IS_LAST = "is_last";
    public static final String EXTRA_POST = "post";
    public static final String EXTRA_POSTS = "extra_posts";
    private Context mContext;
    private boolean mIncludeList;

    public HybridPostCursor(Cursor cursor)
    {
        this(cursor, 20);
    }

    public HybridPostCursor(Cursor cursor, int i)
    {
        super(cursor, i);
        mIncludeList = false;
        if (BuildUtil.isLogsOn() && BuildUtil.isExplore() && getClass() == co/vine/android/provider/HybridPostCursor)
        {
            throw new IllegalStateException("Constructed HybridPostCursor with explore app. Use HybridPostCursorExplore.");
        } else
        {
            return;
        }
    }

    public HybridPostCursor(ArrayList arraylist, int i)
    {
        super(null);
        mIncludeList = false;
        if (BuildUtil.isLogsOn() && BuildUtil.isExplore() && getClass() == co/vine/android/provider/HybridPostCursor)
        {
            throw new IllegalStateException("Constructed HybridPostCursor with explore app. Use HybridPostCursorExplore.");
        } else
        {
            mList = arraylist;
            mLimit = i;
            return;
        }
    }

    public static ArrayList mergePosts(ArrayList arraylist, ArrayList arraylist1, co.vine.android.api.VineComparatorFactory.VineComparator vinecomparator, boolean flag)
    {
        co/vine/android/provider/HybridPostCursor;
        JVM INSTR monitorenter ;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        if (!arraylist.isEmpty()) goto _L3; else goto _L2
_L2:
        if (arraylist1 == null) goto _L5; else goto _L4
_L4:
        if (arraylist1.isEmpty()) goto _L5; else goto _L6
_L6:
        sort(arraylist1, vinecomparator);
        arraylist = arraylist1;
_L7:
        co/vine/android/provider/HybridPostCursor;
        JVM INSTR monitorexit ;
        return arraylist;
_L5:
        arraylist = null;
          goto _L7
_L3:
        LongSparseArray longsparsearray = new LongSparseArray(arraylist.size());
        int i = 0;
        Object obj = arraylist.iterator();
_L8:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_106;
        }
        longsparsearray.put(((VinePost)((Iterator) (obj)).next()).postId, Integer.valueOf(i));
        i++;
          goto _L8
        i = 0;
        arraylist1 = arraylist1.iterator();
_L9:
        Integer integer;
        if (!arraylist1.hasNext())
        {
            break MISSING_BLOCK_LABEL_191;
        }
        obj = (VinePost)arraylist1.next();
        integer = (Integer)longsparsearray.get(((VinePost) (obj)).postId);
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        arraylist.set(integer.intValue(), obj);
          goto _L9
        arraylist;
        throw arraylist;
        arraylist.add(obj);
        i++;
          goto _L9
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        FlurryUtils.trackGraphTimelineRefreshNewCount(i);
        sort(arraylist, vinecomparator);
          goto _L7
    }

    private static void sort(ArrayList arraylist, co.vine.android.api.VineComparatorFactory.VineComparator vinecomparator)
    {
        if (vinecomparator == null)
        {
            Collections.sort(arraylist, VineComparatorFactory.get(-1));
            return;
        } else
        {
            Collections.sort(arraylist, vinecomparator);
            return;
        }
    }

    public int getColumnIndexOrThrow(String s)
        throws IllegalArgumentException
    {
        int i = ((Integer)VineDatabaseSQL.PostCommentsLikesQuery.LOOKUP.get(s)).intValue();
        if (i >= 0)
        {
            return i;
        } else
        {
            return super.getColumnIndexOrThrow(s);
        }
    }

    public Bundle getExtras()
    {
        Object obj;
        try
        {
            obj = super.getExtras();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
        if (obj != null)
        {
            obj = new Bundle(((Bundle) (obj)));
        } else
        {
            obj = new Bundle();
        }
        if (mIncludeList)
        {
            ((Bundle) (obj)).putParcelableArrayList("extra_posts", (ArrayList)mList);
        } else
        {
            VinePost vinepost = (VinePost)getItem(mCursorPosition);
            if (vinepost != null)
            {
                ((Bundle) (obj)).putParcelable("post", vinepost);
                ((Bundle) (obj)).putBoolean("is_last", vinepost.isLast);
                return ((Bundle) (obj));
            }
        }
        return ((Bundle) (obj));
    }

    public void markLast()
    {
        if (mList != null)
        {
            ((VinePost)mList.get(mList.size() - 1)).isLast = true;
        }
    }

    public void onPrepare()
    {
        Object obj;
        Cursor cursor;
        int i;
        long l1;
        cursor = mCursor;
        i = 0;
        if (cursor == null || !cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_348;
        }
        l1 = 0L;
        obj = null;
        mList = new ArrayList();
_L2:
        int j;
        long l2;
        boolean flag;
        l2 = cursor.getLong(1);
        j = i;
        long l = l1;
        VinePost vinepost = ((VinePost) (obj));
        if (l2 != l1)
        {
            j = i;
            if (obj != null)
            {
                mList.add(obj);
                j = i + 1;
            }
            l = l2;
            vinepost = VinePost.from(cursor);
        }
        if (vinepost != null)
        {
            l1 = cursor.getLong(34);
            long l3 = cursor.getLong(27);
            if (l1 > 0L)
            {
                obj = VineComment.from(cursor);
                if (vinepost.comments.items == null)
                {
                    vinepost.comments.items = new ArrayList();
                }
                vinepost.comments.items.add(obj);
            } else
            if (l3 > 0L)
            {
                VineLike vinelike = VineLike.from(cursor);
                if (vinepost.likes.items == null)
                {
                    vinepost.likes.items = new ArrayList();
                }
                vinepost.likes.items.add(vinelike);
            }
        }
_L3:
        try
        {
            flag = cursor.moveToNext();
        }
        catch (IllegalStateException illegalstateexception)
        {
            CrashUtil.log("Failed to get cursor's row id. total: {}, current: {}, limit: {}, postId: {}.", new Object[] {
                Integer.valueOf(cursor.getCount()), Integer.valueOf(j), Integer.valueOf(mLimit), Long.valueOf(l2)
            });
            if (mContext != null)
            {
                AppController.getInstance(mContext).clearImageCacheFromMemory();
            }
            System.gc();
            flag = cursor.moveToNext();
        }
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        l1 = l;
        obj = vinepost;
        if (j < mLimit) goto _L2; else goto _L1
_L1:
        if (vinepost != null)
        {
            mList.add(vinepost);
        }
        return;
        mList = null;
        return;
          goto _L3
    }

    public void prepare(Context context)
    {
        setContext(context);
        super.prepare();
        setContext(null);
    }

    public Bundle respond(Bundle bundle)
    {
        mIncludeList = bundle.getBoolean("include_list", false);
        return bundle;
    }

    public void setContext(Context context)
    {
        if (context != null)
        {
            mContext = context.getApplicationContext();
            return;
        } else
        {
            mContext = null;
            return;
        }
    }
}
