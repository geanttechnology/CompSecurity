// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

// Referenced classes of package android.support.v4.app:
//            LoaderManagerImpl, FragmentHostCallback, FragmentManagerImpl

final class mCallbacks
    implements android.support.v4.content., android.support.v4.content.
{

    final Bundle mArgs;
     mCallbacks;
    Object mData;
    boolean mDeliveredData;
    boolean mDestroyed;
    boolean mHaveData;
    final int mId;
    boolean mListenerRegistered;
    Loader mLoader;
     mPendingLoader;
    boolean mReportNextStart;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final LoaderManagerImpl this$0;

    final void callOnLoadFinished(Loader loader, Object obj)
    {
        if (mCallbacks == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        String s;
        if (LoaderManagerImpl.access$000(LoaderManagerImpl.this) != null)
        {
            s = LoaderManagerImpl.access$000(LoaderManagerImpl.this).mFragmentManager.mNoTransactionsBecause;
            LoaderManagerImpl.access$000(LoaderManagerImpl.this).mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
        } else
        {
            s = null;
        }
        if (LoaderManagerImpl.DEBUG)
        {
            (new StringBuilder("  onLoadFinished in ")).append(loader).append(": ").append(loader.dataToString(obj));
        }
        mCallbacks.onLoadFinished(loader, obj);
        if (LoaderManagerImpl.access$000(LoaderManagerImpl.this) != null)
        {
            LoaderManagerImpl.access$000(LoaderManagerImpl.this).mFragmentManager.mNoTransactionsBecause = s;
        }
        mDeliveredData = true;
        return;
        loader;
        if (LoaderManagerImpl.access$000(LoaderManagerImpl.this) != null)
        {
            LoaderManagerImpl.access$000(LoaderManagerImpl.this).mFragmentManager.mNoTransactionsBecause = s;
        }
        throw loader;
    }

    final void cancel()
    {
        if (LoaderManagerImpl.DEBUG)
        {
            (new StringBuilder("  Canceling: ")).append(this);
        }
        if (mStarted && mLoader != null && mListenerRegistered && !mLoader.cancelLoad())
        {
            onLoadCanceled(mLoader);
        }
    }

    final void destroy()
    {
        ener ener = this;
_L2:
        if (LoaderManagerImpl.DEBUG)
        {
            (new StringBuilder("  Destroying: ")).append(ener);
        }
        ener.mDestroyed = true;
        boolean flag = ener.mDeliveredData;
        ener.mDeliveredData = false;
        if (ener.mCallbacks == null || ener.mLoader == null || !ener.mHaveData || !flag)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        if (LoaderManagerImpl.DEBUG)
        {
            (new StringBuilder("  Reseting: ")).append(ener);
        }
        String s;
        Exception exception;
        if (LoaderManagerImpl.access$000(ener.this$0) != null)
        {
            s = LoaderManagerImpl.access$000(ener.this$0).mFragmentManager.mNoTransactionsBecause;
            LoaderManagerImpl.access$000(ener.this$0).mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
        } else
        {
            s = null;
        }
        ener.mCallbacks.onLoaderReset(ener.mLoader);
        if (LoaderManagerImpl.access$000(ener.this$0) != null)
        {
            LoaderManagerImpl.access$000(ener.this$0).mFragmentManager.mNoTransactionsBecause = s;
        }
        ener.mCallbacks = null;
        ener.mData = null;
        ener.mHaveData = false;
        if (ener.mLoader != null)
        {
            if (ener.mListenerRegistered)
            {
                ener.mListenerRegistered = false;
                ener.mLoader.unregisterListener(ener);
                ener.mLoader.unregisterOnLoadCanceledListener(ener);
            }
            ener.mLoader.reset();
        }
        if (ener.mPendingLoader != null)
        {
            ener = ener.mPendingLoader;
        } else
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        if (LoaderManagerImpl.access$000(ener.this$0) != null)
        {
            LoaderManagerImpl.access$000(ener.this$0).mFragmentManager.mNoTransactionsBecause = s;
        }
        throw exception;
    }

    public final void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        String s1 = s;
        s = this;
        do
        {
            printwriter.print(s1);
            printwriter.print("mId=");
            printwriter.print(((ctionsBecause) (s)).mId);
            printwriter.print(" mArgs=");
            printwriter.println(((mId) (s)).mArgs);
            printwriter.print(s1);
            printwriter.print("mCallbacks=");
            printwriter.println(((mArgs) (s)).mCallbacks);
            printwriter.print(s1);
            printwriter.print("mLoader=");
            printwriter.println(((mCallbacks) (s)).mLoader);
            if (((mLoader) (s)).mLoader != null)
            {
                ((mLoader) (s)).mLoader.dump((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
            }
            if (((mLoader) (s)).mHaveData || ((mHaveData) (s)).mDeliveredData)
            {
                printwriter.print(s1);
                printwriter.print("mHaveData=");
                printwriter.print(((mDeliveredData) (s)).mHaveData);
                printwriter.print("  mDeliveredData=");
                printwriter.println(((mHaveData) (s)).mDeliveredData);
                printwriter.print(s1);
                printwriter.print("mData=");
                printwriter.println(((mDeliveredData) (s)).mData);
            }
            printwriter.print(s1);
            printwriter.print("mStarted=");
            printwriter.print(((mData) (s)).mStarted);
            printwriter.print(" mReportNextStart=");
            printwriter.print(((mStarted) (s)).mReportNextStart);
            printwriter.print(" mDestroyed=");
            printwriter.println(((mReportNextStart) (s)).mDestroyed);
            printwriter.print(s1);
            printwriter.print("mRetaining=");
            printwriter.print(((mDestroyed) (s)).mRetaining);
            printwriter.print(" mRetainingStarted=");
            printwriter.print(((mRetaining) (s)).mRetainingStarted);
            printwriter.print(" mListenerRegistered=");
            printwriter.println(((mRetainingStarted) (s)).mListenerRegistered);
            if (((mListenerRegistered) (s)).mPendingLoader != null)
            {
                printwriter.print(s1);
                printwriter.println("Pending Loader ");
                printwriter.print(((mPendingLoader) (s)).mPendingLoader);
                printwriter.println(":");
                s = ((mPendingLoader) (s)).mPendingLoader;
                s1 = (new StringBuilder()).append(s1).append("  ").toString();
            } else
            {
                return;
            }
        } while (true);
    }

    final void finishRetain()
    {
        if (mRetaining)
        {
            if (LoaderManagerImpl.DEBUG)
            {
                (new StringBuilder("  Finished Retaining: ")).append(this);
            }
            mRetaining = false;
            if (mStarted != mRetainingStarted && !mStarted)
            {
                stop();
            }
        }
        if (mStarted && mHaveData && !mReportNextStart)
        {
            callOnLoadFinished(mLoader, mData);
        }
    }

    public final void onLoadCanceled(Loader loader)
    {
        if (LoaderManagerImpl.DEBUG)
        {
            (new StringBuilder("onLoadCanceled: ")).append(this);
        }
        boolean flag;
        if (mDestroyed)
        {
            flag = LoaderManagerImpl.DEBUG;
        } else
        {
            if (mLoaders.get(mId) != this)
            {
                boolean flag1 = LoaderManagerImpl.DEBUG;
                return;
            }
            loader = mPendingLoader;
            if (loader != null)
            {
                if (LoaderManagerImpl.DEBUG)
                {
                    (new StringBuilder("  Switching to pending loader: ")).append(loader);
                }
                mPendingLoader = null;
                mLoaders.put(mId, null);
                destroy();
                installLoader(loader);
                return;
            }
        }
    }

    public final void onLoadComplete(Loader loader, Object obj)
    {
        if (LoaderManagerImpl.DEBUG)
        {
            (new StringBuilder("onLoadComplete: ")).append(this);
        }
        boolean flag;
        if (mDestroyed)
        {
            flag = LoaderManagerImpl.DEBUG;
        } else
        {
            if (mLoaders.get(mId) != this)
            {
                boolean flag1 = LoaderManagerImpl.DEBUG;
                return;
            }
            er er = mPendingLoader;
            if (er != null)
            {
                if (LoaderManagerImpl.DEBUG)
                {
                    (new StringBuilder("  Switching to pending loader: ")).append(er);
                }
                mPendingLoader = null;
                mLoaders.put(mId, null);
                destroy();
                installLoader(er);
                return;
            }
            if (mData != obj || !mHaveData)
            {
                mData = obj;
                mHaveData = true;
                if (mStarted)
                {
                    callOnLoadFinished(loader, obj);
                }
            }
            loader = (callOnLoadFinished)mInactiveLoaders.get(mId);
            if (loader != null && loader != this)
            {
                loader.mDeliveredData = false;
                loader.destroy();
                mInactiveLoaders.remove(mId);
            }
            if (LoaderManagerImpl.access$000(LoaderManagerImpl.this) != null && !hasRunningLoaders())
            {
                LoaderManagerImpl.access$000(LoaderManagerImpl.this).mFragmentManager.startPendingDeferredFragments();
                return;
            }
        }
    }

    final void reportStart()
    {
        if (mStarted && mReportNextStart)
        {
            mReportNextStart = false;
            if (mHaveData)
            {
                callOnLoadFinished(mLoader, mData);
            }
        }
    }

    final void retain()
    {
        if (LoaderManagerImpl.DEBUG)
        {
            (new StringBuilder("  Retaining: ")).append(this);
        }
        mRetaining = true;
        mRetainingStarted = mStarted;
        mStarted = false;
        mCallbacks = null;
    }

    final void start()
    {
        if (mRetaining && mRetainingStarted)
        {
            mStarted = true;
        } else
        if (!mStarted)
        {
            mStarted = true;
            if (LoaderManagerImpl.DEBUG)
            {
                (new StringBuilder("  Starting: ")).append(this);
            }
            if (mLoader == null && mCallbacks != null)
            {
                mLoader = mCallbacks.onCreateLoader(mId, mArgs);
            }
            if (mLoader != null)
            {
                if (mLoader.getClass().isMemberClass() && !Modifier.isStatic(mLoader.getClass().getModifiers()))
                {
                    throw new IllegalArgumentException((new StringBuilder("Object returned from onCreateLoader must not be a non-static inner member class: ")).append(mLoader).toString());
                }
                if (!mListenerRegistered)
                {
                    mLoader.registerListener(mId, this);
                    mLoader.registerOnLoadCanceledListener(this);
                    mListenerRegistered = true;
                }
                mLoader.startLoading();
                return;
            }
        }
    }

    final void stop()
    {
        if (LoaderManagerImpl.DEBUG)
        {
            (new StringBuilder("  Stopping: ")).append(this);
        }
        mStarted = false;
        if (!mRetaining && mLoader != null && mListenerRegistered)
        {
            mListenerRegistered = false;
            mLoader.unregisterListener(this);
            mLoader.unregisterOnLoadCanceledListener(this);
            mLoader.stopLoading();
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("LoaderInfo{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" #");
        stringbuilder.append(mId);
        stringbuilder.append(" : ");
        DebugUtils.buildShortClassTag(mLoader, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

    public (int i, Bundle bundle,  )
    {
        this$0 = LoaderManagerImpl.this;
        super();
        mId = i;
        mArgs = bundle;
        mCallbacks = ;
    }
}
