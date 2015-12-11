// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.c.o;
import android.support.v4.c.p;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            ad, ai, ae, bb, 
//            af, Fragment, bc, l, 
//            n, q, ag, ah, 
//            az, db

public class ac extends Activity
{

    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    private static final String TAG = "FragmentActivity";
    o mAllLoaderManagers;
    boolean mCheckedForLoaderManager;
    final ag mContainer = new ae(this);
    boolean mCreated;
    final ai mFragments = new ai();
    final Handler mHandler = new ad(this);
    bb mLoaderManager;
    boolean mLoadersStarted;
    boolean mOptionsMenuInvalidated;
    boolean mReallyStopped;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;

    public ac()
    {
    }

    private void dumpViewHierarchy(String s, PrintWriter printwriter, View view)
    {
        printwriter.print(s);
        if (view != null) goto _L2; else goto _L1
_L1:
        printwriter.println("null");
_L4:
        return;
_L2:
        printwriter.println(viewToString(view));
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int j = view.getChildCount();
            if (j > 0)
            {
                s = (new StringBuilder()).append(s).append("  ").toString();
                int i = 0;
                while (i < j) 
                {
                    dumpViewHierarchy(s, printwriter, view.getChildAt(i));
                    i++;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static String viewToString(View view)
    {
        byte byte0;
        byte byte1;
        StringBuilder stringbuilder;
        byte1 = 70;
        byte0 = 46;
        stringbuilder = new StringBuilder(128);
        stringbuilder.append(view.getClass().getName());
        stringbuilder.append('{');
        stringbuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringbuilder.append(' ');
        view.getVisibility();
        JVM INSTR lookupswitch 3: default 100
    //                   0: 523
    //                   4: 534
    //                   8: 545;
           goto _L1 _L2 _L3 _L4
_L1:
        stringbuilder.append('.');
_L11:
        char c;
        Object obj;
        String s;
        int i;
        if (view.isFocusable())
        {
            c = 'F';
        } else
        {
            c = '.';
        }
        stringbuilder.append(c);
        if (view.isEnabled())
        {
            c = 'E';
        } else
        {
            c = '.';
        }
        stringbuilder.append(c);
        if (view.willNotDraw())
        {
            c = '.';
        } else
        {
            c = 'D';
        }
        stringbuilder.append(c);
        if (view.isHorizontalScrollBarEnabled())
        {
            c = 'H';
        } else
        {
            c = '.';
        }
        stringbuilder.append(c);
        if (view.isVerticalScrollBarEnabled())
        {
            c = 'V';
        } else
        {
            c = '.';
        }
        stringbuilder.append(c);
        if (view.isClickable())
        {
            c = 'C';
        } else
        {
            c = '.';
        }
        stringbuilder.append(c);
        if (view.isLongClickable())
        {
            c = 'L';
        } else
        {
            c = '.';
        }
        stringbuilder.append(c);
        stringbuilder.append(' ');
        if (view.isFocused())
        {
            c = byte1;
        } else
        {
            c = '.';
        }
        stringbuilder.append(c);
        if (view.isSelected())
        {
            c = 'S';
        } else
        {
            c = '.';
        }
        stringbuilder.append(c);
        c = byte0;
        if (view.isPressed())
        {
            c = 'P';
        }
        stringbuilder.append(c);
        stringbuilder.append(' ');
        stringbuilder.append(view.getLeft());
        stringbuilder.append(',');
        stringbuilder.append(view.getTop());
        stringbuilder.append('-');
        stringbuilder.append(view.getRight());
        stringbuilder.append(',');
        stringbuilder.append(view.getBottom());
        i = view.getId();
        if (i == -1) goto _L6; else goto _L5
_L5:
        stringbuilder.append(" #");
        stringbuilder.append(Integer.toHexString(i));
        obj = view.getResources();
        if (i == 0 || obj == null) goto _L6; else goto _L7
_L7:
        0xff000000 & i;
        JVM INSTR lookupswitch 2: default 436
    //                   16777216: 616
    //                   2130706432: 610;
           goto _L8 _L9 _L10
_L8:
        view = ((Resources) (obj)).getResourcePackageName(i);
_L12:
        s = ((Resources) (obj)).getResourceTypeName(i);
        obj = ((Resources) (obj)).getResourceEntryName(i);
        stringbuilder.append(" ");
        stringbuilder.append(view);
        stringbuilder.append(":");
        stringbuilder.append(s);
        stringbuilder.append("/");
        stringbuilder.append(((String) (obj)));
_L6:
        stringbuilder.append("}");
        return stringbuilder.toString();
_L2:
        stringbuilder.append('V');
          goto _L11
_L3:
        stringbuilder.append('I');
          goto _L11
_L4:
        stringbuilder.append('G');
          goto _L11
_L10:
        view = "app";
          goto _L12
_L9:
        view = "android";
          goto _L12
        view;
          goto _L6
    }

    void doReallyStop(boolean flag)
    {
        if (!mReallyStopped)
        {
            mReallyStopped = true;
            mRetaining = flag;
            mHandler.removeMessages(1);
            onReallyStop();
        }
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        int i = android.os.Build.VERSION.SDK_INT;
        printwriter.print(s);
        printwriter.print("Local FragmentActivity ");
        printwriter.print(Integer.toHexString(System.identityHashCode(this)));
        printwriter.println(" State:");
        String s1 = (new StringBuilder()).append(s).append("  ").toString();
        printwriter.print(s1);
        printwriter.print("mCreated=");
        printwriter.print(mCreated);
        printwriter.print("mResumed=");
        printwriter.print(mResumed);
        printwriter.print(" mStopped=");
        printwriter.print(mStopped);
        printwriter.print(" mReallyStopped=");
        printwriter.println(mReallyStopped);
        printwriter.print(s1);
        printwriter.print("mLoadersStarted=");
        printwriter.println(mLoadersStarted);
        if (mLoaderManager != null)
        {
            printwriter.print(s);
            printwriter.print("Loader Manager ");
            printwriter.print(Integer.toHexString(System.identityHashCode(mLoaderManager)));
            printwriter.println(":");
            mLoaderManager.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
        mFragments.a(s, filedescriptor, printwriter, as);
        printwriter.print(s);
        printwriter.println("View Hierarchy:");
        dumpViewHierarchy((new StringBuilder()).append(s).append("  ").toString(), printwriter, getWindow().getDecorView());
    }

    public Object getLastCustomNonConfigurationInstance()
    {
        af af1 = (af)getLastNonConfigurationInstance();
        if (af1 != null)
        {
            return af1.b;
        } else
        {
            return null;
        }
    }

    bb getLoaderManager(String s, boolean flag, boolean flag1)
    {
        if (mAllLoaderManagers == null)
        {
            mAllLoaderManagers = new o();
        }
        bb bb1 = (bb)mAllLoaderManagers.get(s);
        if (bb1 == null)
        {
            if (flag1)
            {
                bb1 = new bb(s, this, flag);
                mAllLoaderManagers.put(s, bb1);
            }
            return bb1;
        } else
        {
            bb1.e = this;
            return bb1;
        }
    }

    public ah getSupportFragmentManager()
    {
        return mFragments;
    }

    public az getSupportLoaderManager()
    {
        if (mLoaderManager != null)
        {
            return mLoaderManager;
        } else
        {
            mCheckedForLoaderManager = true;
            mLoaderManager = getLoaderManager("(root)", mLoadersStarted, true);
            return mLoaderManager;
        }
    }

    void invalidateSupportFragment(String s)
    {
        if (mAllLoaderManagers != null)
        {
            bb bb1 = (bb)mAllLoaderManagers.get(s);
            if (bb1 != null && !bb1.g)
            {
                bb1.g();
                mAllLoaderManagers.remove(s);
            }
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        mFragments.s = false;
        int k = i >> 16;
        if (k != 0)
        {
            k--;
            if (mFragments.f == null || k < 0 || k >= mFragments.f.size())
            {
                Log.w("FragmentActivity", (new StringBuilder("Activity result fragment index out of range: 0x")).append(Integer.toHexString(i)).toString());
                return;
            }
            Fragment fragment = (Fragment)mFragments.f.get(k);
            if (fragment == null)
            {
                Log.w("FragmentActivity", (new StringBuilder("Activity result no fragment exists for index: 0x")).append(Integer.toHexString(i)).toString());
                return;
            } else
            {
                fragment.onActivityResult(0xffff & i, j, intent);
                return;
            }
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    public void onAttachFragment(Fragment fragment)
    {
    }

    public void onBackPressed()
    {
        ai ai1 = mFragments;
        ai1.d();
        ai1.e();
        if (!ai1.a(-1, 0))
        {
            supportFinishAfterTransition();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mFragments.a(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        mFragments.a(this, mContainer, null);
        if (getLayoutInflater().getFactory() == null)
        {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        af af1 = (af)getLastNonConfigurationInstance();
        if (af1 != null)
        {
            mAllLoaderManagers = af1.e;
        }
        if (bundle != null)
        {
            android.os.Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            ai ai1 = mFragments;
            if (af1 != null)
            {
                bundle = af1.d;
            } else
            {
                bundle = null;
            }
            ai1.a(parcelable, bundle);
        }
        mFragments.h();
    }

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        if (i == 0)
        {
            boolean flag = super.onCreatePanelMenu(i, menu);
            boolean flag1 = mFragments.a(menu, getMenuInflater());
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                return flag | flag1;
            } else
            {
                return true;
            }
        } else
        {
            return super.onCreatePanelMenu(i, menu);
        }
    }

    public View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        View view;
        if (!"fragment".equals(s))
        {
            view = super.onCreateView(s, context, attributeset);
        } else
        {
            View view1 = mFragments.onCreateView(s, context, attributeset);
            view = view1;
            if (view1 == null)
            {
                return super.onCreateView(s, context, attributeset);
            }
        }
        return view;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        doReallyStop(false);
        mFragments.m();
        if (mLoaderManager != null)
        {
            mLoaderManager.g();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (android.os.Build.VERSION.SDK_INT < 5 && i == 4 && keyevent.getRepeatCount() == 0)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        mFragments.n();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(i, menuitem))
        {
            return true;
        }
        switch (i)
        {
        default:
            return false;

        case 0: // '\0'
            return mFragments.a(menuitem);

        case 6: // '\006'
            return mFragments.b(menuitem);
        }
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mFragments.s = false;
    }

    public void onPanelClosed(int i, Menu menu)
    {
        i;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 27;
           goto _L1 _L2
_L1:
        super.onPanelClosed(i, menu);
        return;
_L2:
        mFragments.b(menu);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onPause()
    {
        super.onPause();
        mResumed = false;
        if (mHandler.hasMessages(2))
        {
            mHandler.removeMessages(2);
            onResumeFragments();
        }
        mFragments.b(4);
    }

    protected void onPostResume()
    {
        super.onPostResume();
        mHandler.removeMessages(2);
        onResumeFragments();
        mFragments.e();
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu)
    {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        if (i == 0 && menu != null)
        {
            if (mOptionsMenuInvalidated)
            {
                mOptionsMenuInvalidated = false;
                menu.clear();
                onCreatePanelMenu(i, menu);
            }
            return onPrepareOptionsPanel(view, menu) | mFragments.a(menu);
        } else
        {
            return super.onPreparePanel(i, view, menu);
        }
    }

    void onReallyStop()
    {
        if (mLoadersStarted)
        {
            mLoadersStarted = false;
            if (mLoaderManager != null)
            {
                if (!mRetaining)
                {
                    mLoaderManager.c();
                } else
                {
                    mLoaderManager.d();
                }
            }
        }
        mFragments.b(2);
    }

    public void onResume()
    {
        super.onResume();
        mHandler.sendEmptyMessage(2);
        mResumed = true;
        mFragments.e();
    }

    protected void onResumeFragments()
    {
        mFragments.k();
    }

    public Object onRetainCustomNonConfigurationInstance()
    {
        return null;
    }

    public final Object onRetainNonConfigurationInstance()
    {
        boolean flag1 = false;
        if (mStopped)
        {
            doReallyStop(true);
        }
        Object obj = onRetainCustomNonConfigurationInstance();
        ai ai1 = mFragments;
        ArrayList arraylist1;
        if (ai1.f != null)
        {
            int i = 0;
            ArrayList arraylist = null;
            do
            {
                arraylist1 = arraylist;
                if (i >= ai1.f.size())
                {
                    break;
                }
                Fragment fragment = (Fragment)ai1.f.get(i);
                ArrayList arraylist2 = arraylist;
                if (fragment != null)
                {
                    arraylist2 = arraylist;
                    if (fragment.mRetainInstance)
                    {
                        arraylist1 = arraylist;
                        if (arraylist == null)
                        {
                            arraylist1 = new ArrayList();
                        }
                        arraylist1.add(fragment);
                        fragment.mRetaining = true;
                        int k;
                        if (fragment.mTarget != null)
                        {
                            k = fragment.mTarget.mIndex;
                        } else
                        {
                            k = -1;
                        }
                        fragment.mTargetIndex = k;
                        arraylist2 = arraylist1;
                        if (ai.a)
                        {
                            Log.v("FragmentManager", (new StringBuilder("retainNonConfig: keeping retained ")).append(fragment).toString());
                            arraylist2 = arraylist1;
                        }
                    }
                }
                i++;
                arraylist = arraylist2;
            } while (true);
        } else
        {
            arraylist1 = null;
        }
        if (mAllLoaderManagers != null)
        {
            int j1 = mAllLoaderManagers.size();
            bb abb[] = new bb[j1];
            for (int j = j1 - 1; j >= 0; j--)
            {
                abb[j] = (bb)mAllLoaderManagers.c(j);
            }

            boolean flag = false;
            int i1 = ((flag1) ? 1 : 0);
            do
            {
                flag1 = flag;
                if (i1 >= j1)
                {
                    break;
                }
                bb bb1 = abb[i1];
                if (bb1.g)
                {
                    flag = true;
                } else
                {
                    bb1.g();
                    mAllLoaderManagers.remove(bb1.d);
                }
                i1++;
            } while (true);
        } else
        {
            flag1 = false;
        }
        if (arraylist1 == null && !flag1 && obj == null)
        {
            return null;
        } else
        {
            af af1 = new af();
            af1.a = null;
            af1.b = obj;
            af1.c = null;
            af1.d = arraylist1;
            af1.e = mAllLoaderManagers;
            return af1;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        android.os.Parcelable parcelable = mFragments.g();
        if (parcelable != null)
        {
            bundle.putParcelable("android:support:fragments", parcelable);
        }
    }

    protected void onStart()
    {
        super.onStart();
        mStopped = false;
        mReallyStopped = false;
        mHandler.removeMessages(1);
        if (!mCreated)
        {
            mCreated = true;
            mFragments.i();
        }
        mFragments.s = false;
        mFragments.e();
        if (!mLoadersStarted)
        {
            mLoadersStarted = true;
            int i;
            if (mLoaderManager != null)
            {
                mLoaderManager.b();
            } else
            if (!mCheckedForLoaderManager)
            {
                mLoaderManager = getLoaderManager("(root)", mLoadersStarted, false);
                if (mLoaderManager != null && !mLoaderManager.f)
                {
                    mLoaderManager.b();
                }
            }
            mCheckedForLoaderManager = true;
        }
        mFragments.j();
        if (mAllLoaderManagers != null)
        {
            int i1 = mAllLoaderManagers.size();
            bb abb[] = new bb[i1];
            for (i = i1 - 1; i >= 0; i--)
            {
                abb[i] = (bb)mAllLoaderManagers.c(i);
            }

            for (int j = 0; j < i1; j++)
            {
                bb bb1 = abb[j];
                if (bb1.g)
                {
                    if (bb.a)
                    {
                        Log.v("LoaderManager", (new StringBuilder("Finished Retaining in ")).append(bb1).toString());
                    }
                    bb1.g = false;
                    for (int k = bb1.b.a() - 1; k >= 0; k--)
                    {
                        bc bc1 = (bc)bb1.b.c(k);
                        if (bc1.i)
                        {
                            if (bb.a)
                            {
                                Log.v("LoaderManager", (new StringBuilder("  Finished Retaining: ")).append(bc1).toString());
                            }
                            bc1.i = false;
                            if (bc1.h != bc1.j && !bc1.h)
                            {
                                bc1.b();
                            }
                        }
                        if (bc1.h && bc1.e && !bc1.k)
                        {
                            bc1.b(bc1.d, bc1.g);
                        }
                    }

                }
                bb1.f();
            }

        }
    }

    protected void onStop()
    {
        super.onStop();
        mStopped = true;
        mHandler.sendEmptyMessage(1);
        mFragments.l();
    }

    public void setEnterSharedElementCallback(db db)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            n.a(this, l.a(db));
        }
    }

    public void setExitSharedElementCallback(db db)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            n.b(this, l.a(db));
        }
    }

    public void startActivityForResult(Intent intent, int i)
    {
        if (i != -1 && (0xffff0000 & i) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, i);
            return;
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i)
    {
        if (i == -1)
        {
            super.startActivityForResult(intent, -1);
            return;
        }
        if ((0xffff0000 & i) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, (fragment.mIndex + 1 << 16) + (0xffff & i));
            return;
        }
    }

    public void supportFinishAfterTransition()
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            n.a(this);
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void supportInvalidateOptionsMenu()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            q.a(this);
            return;
        } else
        {
            mOptionsMenuInvalidated = true;
            return;
        }
    }

    public void supportPostponeEnterTransition()
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            n.b(this);
        }
    }

    public void supportStartPostponedEnterTransition()
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            n.c(this);
        }
    }
}
