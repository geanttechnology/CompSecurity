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
import android.os.Message;
import android.support.v4.f.h;
import android.util.AttributeSet;
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
//            l, p, Fragment, a, 
//            b, j, k, o, 
//            ag

public class i extends Activity
{
    static final class a
    {

        Object a;
        Object b;
        h c;
        ArrayList d;
        h e;

        a()
        {
        }
    }


    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    private static final String TAG = "FragmentActivity";
    h mAllLoaderManagers;
    boolean mCheckedForLoaderManager;
    final j mContainer = new j() {

        final i a;

        public final View a(int k)
        {
            return a.findViewById(k);
        }

        public final boolean a()
        {
            Window window = a.getWindow();
            return window != null && window.peekDecorView() != null;
        }

            
            {
                a = i.this;
                super();
            }
    };
    boolean mCreated;
    final l mFragments = new l();
    final Handler mHandler = new Handler() {

        final i a;

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 2: default 28
        //                       1 34
        //                       2 53;
               goto _L1 _L2 _L3
_L1:
            super.handleMessage(message);
_L5:
            return;
_L2:
            if (!a.mStopped) goto _L5; else goto _L4
_L4:
            a.doReallyStop(false);
            return;
_L3:
            a.onResumeFragments();
            a.mFragments.i();
            return;
        }

            
            {
                a = i.this;
                super();
            }
    };
    p mLoaderManager;
    boolean mLoadersStarted;
    boolean mOptionsMenuInvalidated;
    boolean mReallyStopped;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;

    public i()
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
            int k = view.getChildCount();
            if (k > 0)
            {
                s = (new StringBuilder()).append(s).append("  ").toString();
                int j = 0;
                while (j < k) 
                {
                    dumpViewHierarchy(s, printwriter, view.getChildAt(j));
                    j++;
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
        int j;
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
        j = view.getId();
        if (j == -1) goto _L6; else goto _L5
_L5:
        stringbuilder.append(" #");
        stringbuilder.append(Integer.toHexString(j));
        obj = view.getResources();
        if (j == 0 || obj == null) goto _L6; else goto _L7
_L7:
        0xff000000 & j;
        JVM INSTR lookupswitch 2: default 436
    //                   16777216: 616
    //                   2130706432: 610;
           goto _L8 _L9 _L10
_L8:
        view = ((Resources) (obj)).getResourcePackageName(j);
_L12:
        s = ((Resources) (obj)).getResourceTypeName(j);
        obj = ((Resources) (obj)).getResourceEntryName(j);
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
        int j = android.os.Build.VERSION.SDK_INT;
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
        a a1 = (a)getLastNonConfigurationInstance();
        if (a1 != null)
        {
            return a1.b;
        } else
        {
            return null;
        }
    }

    p getLoaderManager(String s, boolean flag, boolean flag1)
    {
        if (mAllLoaderManagers == null)
        {
            mAllLoaderManagers = new h();
        }
        p p1 = (p)mAllLoaderManagers.get(s);
        if (p1 == null)
        {
            if (flag1)
            {
                p1 = new p(s, this, flag);
                mAllLoaderManagers.put(s, p1);
            }
            return p1;
        } else
        {
            p1.e = this;
            return p1;
        }
    }

    public k getSupportFragmentManager()
    {
        return mFragments;
    }

    public o getSupportLoaderManager()
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
            p p1 = (p)mAllLoaderManagers.get(s);
            if (p1 != null && !p1.g)
            {
                p1.g();
                mAllLoaderManagers.remove(s);
            }
        }
    }

    public void onActivityResult(int j, int k, Intent intent)
    {
        mFragments.s = false;
        int i1 = j >> 16;
        if (i1 != 0)
        {
            i1--;
            if (mFragments.f == null || i1 < 0 || i1 >= mFragments.f.size())
            {
                (new StringBuilder("Activity result fragment index out of range: 0x")).append(Integer.toHexString(j));
                return;
            }
            Fragment fragment = (Fragment)mFragments.f.get(i1);
            if (fragment == null)
            {
                (new StringBuilder("Activity result no fragment exists for index: 0x")).append(Integer.toHexString(j));
                return;
            } else
            {
                fragment.onActivityResult(0xffff & j, k, intent);
                return;
            }
        } else
        {
            super.onActivityResult(j, k, intent);
            return;
        }
    }

    public void onAttachFragment(Fragment fragment)
    {
    }

    public void onBackPressed()
    {
        if (!mFragments.d())
        {
            supportFinishAfterTransition();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mFragments.a(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        mFragments.a(this, mContainer, null);
        if (getLayoutInflater().getFactory() == null)
        {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        a a1 = (a)getLastNonConfigurationInstance();
        if (a1 != null)
        {
            mAllLoaderManagers = a1.e;
        }
        if (bundle != null)
        {
            android.os.Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            l l1 = mFragments;
            if (a1 != null)
            {
                bundle = a1.d;
            } else
            {
                bundle = null;
            }
            l1.a(parcelable, bundle);
        }
        mFragments.l();
    }

    public boolean onCreatePanelMenu(int j, Menu menu)
    {
        if (j == 0)
        {
            boolean flag = super.onCreatePanelMenu(j, menu);
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
            return super.onCreatePanelMenu(j, menu);
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
            View view1 = mFragments.a(null, s, context, attributeset);
            view = view1;
            if (view1 == null)
            {
                return super.onCreateView(s, context, attributeset);
            }
        }
        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        doReallyStop(false);
        mFragments.q();
        if (mLoaderManager != null)
        {
            mLoaderManager.g();
        }
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        if (android.os.Build.VERSION.SDK_INT < 5 && j == 4 && keyevent.getRepeatCount() == 0)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onKeyDown(j, keyevent);
        }
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        mFragments.r();
    }

    public boolean onMenuItemSelected(int j, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(j, menuitem))
        {
            return true;
        }
        switch (j)
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

    public void onPanelClosed(int j, Menu menu)
    {
        j;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 27;
           goto _L1 _L2
_L1:
        super.onPanelClosed(j, menu);
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
        mFragments.c(4);
    }

    public void onPostResume()
    {
        super.onPostResume();
        mHandler.removeMessages(2);
        onResumeFragments();
        mFragments.i();
    }

    public boolean onPrepareOptionsPanel(View view, Menu menu)
    {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int j, View view, Menu menu)
    {
        if (j == 0 && menu != null)
        {
            if (mOptionsMenuInvalidated)
            {
                mOptionsMenuInvalidated = false;
                menu.clear();
                onCreatePanelMenu(j, menu);
            }
            return onPrepareOptionsPanel(view, menu) | mFragments.a(menu);
        } else
        {
            return super.onPreparePanel(j, view, menu);
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
        mFragments.c(2);
    }

    public void onResume()
    {
        super.onResume();
        mHandler.sendEmptyMessage(2);
        mResumed = true;
        mFragments.i();
    }

    public void onResumeFragments()
    {
        mFragments.o();
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
        l l1 = mFragments;
        ArrayList arraylist1;
        if (l1.f != null)
        {
            int j = 0;
            ArrayList arraylist = null;
            do
            {
                arraylist1 = arraylist;
                if (j >= l1.f.size())
                {
                    break;
                }
                Fragment fragment = (Fragment)l1.f.get(j);
                ArrayList arraylist2 = arraylist;
                if (fragment != null)
                {
                    arraylist2 = arraylist;
                    if (fragment.L)
                    {
                        arraylist1 = arraylist;
                        if (arraylist == null)
                        {
                            arraylist1 = new ArrayList();
                        }
                        arraylist1.add(fragment);
                        fragment.M = true;
                        int i1;
                        if (fragment.s != null)
                        {
                            i1 = fragment.s.p;
                        } else
                        {
                            i1 = -1;
                        }
                        fragment.t = i1;
                        arraylist2 = arraylist1;
                        if (l.a)
                        {
                            (new StringBuilder("retainNonConfig: keeping retained ")).append(fragment);
                            arraylist2 = arraylist1;
                        }
                    }
                }
                j++;
                arraylist = arraylist2;
            } while (true);
        } else
        {
            arraylist1 = null;
        }
        if (mAllLoaderManagers != null)
        {
            int k1 = mAllLoaderManagers.size();
            p ap[] = new p[k1];
            for (int k = k1 - 1; k >= 0; k--)
            {
                ap[k] = (p)mAllLoaderManagers.c(k);
            }

            boolean flag = false;
            int j1 = ((flag1) ? 1 : 0);
            do
            {
                flag1 = flag;
                if (j1 >= k1)
                {
                    break;
                }
                p p1 = ap[j1];
                if (p1.g)
                {
                    flag = true;
                } else
                {
                    p1.g();
                    mAllLoaderManagers.remove(p1.d);
                }
                j1++;
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
            a a1 = new a();
            a1.a = null;
            a1.b = obj;
            a1.c = null;
            a1.d = arraylist1;
            a1.e = mAllLoaderManagers;
            return a1;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        android.os.Parcelable parcelable = mFragments.k();
        if (parcelable != null)
        {
            bundle.putParcelable("android:support:fragments", parcelable);
        }
    }

    public void onStart()
    {
        super.onStart();
        mStopped = false;
        mReallyStopped = false;
        mHandler.removeMessages(1);
        if (!mCreated)
        {
            mCreated = true;
            mFragments.m();
        }
        mFragments.s = false;
        mFragments.i();
        if (!mLoadersStarted)
        {
            mLoadersStarted = true;
            int j;
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
        mFragments.n();
        if (mAllLoaderManagers != null)
        {
            int j1 = mAllLoaderManagers.size();
            p ap[] = new p[j1];
            for (j = j1 - 1; j >= 0; j--)
            {
                ap[j] = (p)mAllLoaderManagers.c(j);
            }

            for (int k = 0; k < j1; k++)
            {
                p p1 = ap[k];
                if (p1.g)
                {
                    if (p.a)
                    {
                        (new StringBuilder("Finished Retaining in ")).append(p1);
                    }
                    p1.g = false;
                    for (int i1 = p1.b.a() - 1; i1 >= 0; i1--)
                    {
                        p.a a1 = (p.a)p1.b.d(i1);
                        if (a1.i)
                        {
                            if (p.a)
                            {
                                (new StringBuilder("  Finished Retaining: ")).append(a1);
                            }
                            a1.i = false;
                            if (a1.h != a1.j && !a1.h)
                            {
                                a1.b();
                            }
                        }
                        if (a1.h && a1.e && !a1.k)
                        {
                            a1.b(a1.d, a1.g);
                        }
                    }

                }
                p1.f();
            }

        }
    }

    public void onStop()
    {
        super.onStop();
        mStopped = true;
        mHandler.sendEmptyMessage(1);
        mFragments.p();
    }

    public void setEnterSharedElementCallback(ag ag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            setEnterSharedElementCallback(b.a(android.support.v4.app.a.a(ag)));
        }
    }

    public void setExitSharedElementCallback(ag ag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            setExitSharedElementCallback(b.a(android.support.v4.app.a.a(ag)));
        }
    }

    public void startActivityForResult(Intent intent, int j)
    {
        if (j != -1 && (0xffff0000 & j) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, j);
            return;
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int j)
    {
        if (j == -1)
        {
            super.startActivityForResult(intent, -1);
            return;
        }
        if ((0xffff0000 & j) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, (fragment.p + 1 << 16) + (0xffff & j));
            return;
        }
    }

    public void supportFinishAfterTransition()
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            finishAfterTransition();
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
            invalidateOptionsMenu();
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
            postponeEnterTransition();
        }
    }

    public void supportStartPostponedEnterTransition()
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            startPostponedEnterTransition();
        }
    }
}
