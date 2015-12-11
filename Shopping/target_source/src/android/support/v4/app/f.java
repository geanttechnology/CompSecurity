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
import android.support.v4.f.j;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            i, o, Fragment, a, 
//            c, g, h

public class f extends Activity
    implements TraceFieldInterface
{
    static final class a
    {

        Object a;
        Object b;
        j c;
        ArrayList d;
        j e;

        a()
        {
        }
    }


    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    private static final String TAG = "FragmentActivity";
    j mAllLoaderManagers;
    boolean mCheckedForLoaderManager;
    final g mContainer = new g() {

        final f a;

        public View a(int k)
        {
            return a.findViewById(k);
        }

        public boolean a()
        {
            Window window = a.getWindow();
            return window != null && window.peekDecorView() != null;
        }

            
            {
                a = f.this;
                super();
            }
    };
    boolean mCreated;
    final i mFragments = new i();
    final Handler mHandler = new Handler() {

        final f a;

        public void handleMessage(Message message)
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
            a.a(false);
            return;
_L3:
            a.b_();
            a.mFragments.h();
            return;
        }

            
            {
                a = f.this;
                super();
            }
    };
    o mLoaderManager;
    boolean mLoadersStarted;
    boolean mOptionsMenuInvalidated;
    boolean mReallyStopped;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;

    public f()
    {
    }

    private static String a(View view)
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
        char c1;
        Object obj;
        String s;
        int k;
        if (view.isFocusable())
        {
            c1 = 'F';
        } else
        {
            c1 = '.';
        }
        stringbuilder.append(c1);
        if (view.isEnabled())
        {
            c1 = 'E';
        } else
        {
            c1 = '.';
        }
        stringbuilder.append(c1);
        if (view.willNotDraw())
        {
            c1 = '.';
        } else
        {
            c1 = 'D';
        }
        stringbuilder.append(c1);
        if (view.isHorizontalScrollBarEnabled())
        {
            c1 = 'H';
        } else
        {
            c1 = '.';
        }
        stringbuilder.append(c1);
        if (view.isVerticalScrollBarEnabled())
        {
            c1 = 'V';
        } else
        {
            c1 = '.';
        }
        stringbuilder.append(c1);
        if (view.isClickable())
        {
            c1 = 'C';
        } else
        {
            c1 = '.';
        }
        stringbuilder.append(c1);
        if (view.isLongClickable())
        {
            c1 = 'L';
        } else
        {
            c1 = '.';
        }
        stringbuilder.append(c1);
        stringbuilder.append(' ');
        if (view.isFocused())
        {
            c1 = byte1;
        } else
        {
            c1 = '.';
        }
        stringbuilder.append(c1);
        if (view.isSelected())
        {
            c1 = 'S';
        } else
        {
            c1 = '.';
        }
        stringbuilder.append(c1);
        c1 = byte0;
        if (view.isPressed())
        {
            c1 = 'P';
        }
        stringbuilder.append(c1);
        stringbuilder.append(' ');
        stringbuilder.append(view.getLeft());
        stringbuilder.append(',');
        stringbuilder.append(view.getTop());
        stringbuilder.append('-');
        stringbuilder.append(view.getRight());
        stringbuilder.append(',');
        stringbuilder.append(view.getBottom());
        k = view.getId();
        if (k == -1) goto _L6; else goto _L5
_L5:
        stringbuilder.append(" #");
        stringbuilder.append(Integer.toHexString(k));
        obj = view.getResources();
        if (k == 0 || obj == null) goto _L6; else goto _L7
_L7:
        0xff000000 & k;
        JVM INSTR lookupswitch 2: default 436
    //                   16777216: 616
    //                   2130706432: 610;
           goto _L8 _L9 _L10
_L8:
        view = ((Resources) (obj)).getResourcePackageName(k);
_L12:
        s = ((Resources) (obj)).getResourceTypeName(k);
        obj = ((Resources) (obj)).getResourceEntryName(k);
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

    private void a(String s, PrintWriter printwriter, View view)
    {
        printwriter.print(s);
        if (view != null) goto _L2; else goto _L1
_L1:
        printwriter.println("null");
_L4:
        return;
_L2:
        printwriter.println(a(view));
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int l = view.getChildCount();
            if (l > 0)
            {
                s = (new StringBuilder()).append(s).append("  ").toString();
                int k = 0;
                while (k < l) 
                {
                    a(s, printwriter, view.getChildAt(k));
                    k++;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    o a(String s, boolean flag, boolean flag1)
    {
        if (mAllLoaderManagers == null)
        {
            mAllLoaderManagers = new j();
        }
        o o1 = (o)mAllLoaderManagers.get(s);
        if (o1 == null)
        {
            if (flag1)
            {
                o1 = new o(s, this, flag);
                mAllLoaderManagers.put(s, o1);
            }
            return o1;
        } else
        {
            o1.a(this);
            return o1;
        }
    }

    public void a(Fragment fragment)
    {
    }

    public void a(Fragment fragment, Intent intent, int k)
    {
        if (k == -1)
        {
            super.startActivityForResult(intent, -1);
            return;
        }
        if ((0xffff0000 & k) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, (fragment.mIndex + 1 << 16) + (0xffff & k));
            return;
        }
    }

    void a(String s)
    {
        if (mAllLoaderManagers != null)
        {
            o o1 = (o)mAllLoaderManagers.get(s);
            if (o1 != null && !o1.g)
            {
                o1.h();
                mAllLoaderManagers.remove(s);
            }
        }
    }

    void a(boolean flag)
    {
        if (!mReallyStopped)
        {
            mReallyStopped = true;
            mRetaining = flag;
            mHandler.removeMessages(1);
            e();
        }
    }

    protected boolean a(View view, Menu menu)
    {
        return super.onPreparePanel(0, view, menu);
    }

    public void a_()
    {
        android.support.v4.app.a.b(this);
    }

    protected void b_()
    {
        mFragments.p();
    }

    public Object c()
    {
        return null;
    }

    public void d()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            android.support.v4.app.c.a(this);
            return;
        } else
        {
            mOptionsMenuInvalidated = true;
            return;
        }
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        if (android.os.Build.VERSION.SDK_INT < 11);
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
        a((new StringBuilder()).append(s).append("  ").toString(), printwriter, getWindow().getDecorView());
    }

    void e()
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
        mFragments.s();
    }

    public h f()
    {
        return mFragments;
    }

    protected void onActivityResult(int k, int l, Intent intent)
    {
        mFragments.l();
        int i1 = k >> 16;
        if (i1 != 0)
        {
            i1--;
            if (mFragments.f == null || i1 < 0 || i1 >= mFragments.f.size())
            {
                Log.w("FragmentActivity", (new StringBuilder()).append("Activity result fragment index out of range: 0x").append(Integer.toHexString(k)).toString());
                return;
            }
            Fragment fragment = (Fragment)mFragments.f.get(i1);
            if (fragment == null)
            {
                Log.w("FragmentActivity", (new StringBuilder()).append("Activity result no fragment exists for index: 0x").append(Integer.toHexString(k)).toString());
                return;
            } else
            {
                fragment.onActivityResult(0xffff & k, l, intent);
                return;
            }
        } else
        {
            super.onActivityResult(k, l, intent);
            return;
        }
    }

    public void onBackPressed()
    {
        if (!mFragments.d())
        {
            a_();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mFragments.a(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("f");
        TraceMachine.enterMethod(_nr_trace, "f#onCreate", null);
_L1:
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
            i k = mFragments;
            NoSuchFieldError nosuchfielderror;
            if (a1 != null)
            {
                bundle = a1.d;
            } else
            {
                bundle = null;
            }
            k.a(parcelable, bundle);
        }
        mFragments.m();
        TraceMachine.exitMethod();
        return;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "f#onCreate", null);
          goto _L1
    }

    public boolean onCreatePanelMenu(int k, Menu menu)
    {
        if (k == 0)
        {
            boolean flag = super.onCreatePanelMenu(k, menu);
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
            return super.onCreatePanelMenu(k, menu);
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

    protected void onDestroy()
    {
        super.onDestroy();
        a(false);
        mFragments.u();
        if (mLoaderManager != null)
        {
            mLoaderManager.h();
        }
    }

    public boolean onKeyDown(int k, KeyEvent keyevent)
    {
        if (android.os.Build.VERSION.SDK_INT < 5 && k == 4 && keyevent.getRepeatCount() == 0)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onKeyDown(k, keyevent);
        }
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        mFragments.v();
    }

    public boolean onMenuItemSelected(int k, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(k, menuitem))
        {
            return true;
        }
        switch (k)
        {
        default:
            return false;

        case 0: // '\0'
            return mFragments.a(menuitem);

        case 6: // '\006'
            return mFragments.b(menuitem);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mFragments.l();
    }

    public void onPanelClosed(int k, Menu menu)
    {
        k;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 27;
           goto _L1 _L2
_L1:
        super.onPanelClosed(k, menu);
        return;
_L2:
        mFragments.b(menu);
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
        mResumed = false;
        if (mHandler.hasMessages(2))
        {
            mHandler.removeMessages(2);
            b_();
        }
        mFragments.q();
    }

    protected void onPostResume()
    {
        super.onPostResume();
        mHandler.removeMessages(2);
        b_();
        mFragments.h();
    }

    public boolean onPreparePanel(int k, View view, Menu menu)
    {
        if (k == 0 && menu != null)
        {
            if (mOptionsMenuInvalidated)
            {
                mOptionsMenuInvalidated = false;
                menu.clear();
                onCreatePanelMenu(k, menu);
            }
            return a(view, menu) | mFragments.a(menu);
        } else
        {
            return super.onPreparePanel(k, view, menu);
        }
    }

    protected void onResume()
    {
        super.onResume();
        mHandler.sendEmptyMessage(2);
        mResumed = true;
        mFragments.h();
    }

    public final Object onRetainNonConfigurationInstance()
    {
        int l = 0;
        if (mStopped)
        {
            a(true);
        }
        Object obj = c();
        ArrayList arraylist = mFragments.j();
        boolean flag1;
        if (mAllLoaderManagers != null)
        {
            int i1 = mAllLoaderManagers.size();
            o ao[] = new o[i1];
            for (int k = i1 - 1; k >= 0; k--)
            {
                ao[k] = (o)mAllLoaderManagers.c(k);
            }

            boolean flag = false;
            do
            {
                flag1 = flag;
                if (l >= i1)
                {
                    break;
                }
                o o1 = ao[l];
                if (o1.g)
                {
                    flag = true;
                } else
                {
                    o1.h();
                    mAllLoaderManagers.remove(o1.d);
                }
                l++;
            } while (true);
        } else
        {
            flag1 = false;
        }
        if (arraylist == null && !flag1 && obj == null)
        {
            return null;
        } else
        {
            a a1 = new a();
            a1.a = null;
            a1.b = obj;
            a1.c = null;
            a1.d = arraylist;
            a1.e = mAllLoaderManagers;
            return a1;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        android.os.Parcelable parcelable = mFragments.k();
        if (parcelable != null)
        {
            bundle.putParcelable("android:support:fragments", parcelable);
        }
    }

    protected void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        mStopped = false;
        mReallyStopped = false;
        mHandler.removeMessages(1);
        if (!mCreated)
        {
            mCreated = true;
            mFragments.n();
        }
        mFragments.l();
        mFragments.h();
        if (!mLoadersStarted)
        {
            mLoadersStarted = true;
            int k;
            if (mLoaderManager != null)
            {
                mLoaderManager.b();
            } else
            if (!mCheckedForLoaderManager)
            {
                mLoaderManager = a("(root)", mLoadersStarted, false);
                if (mLoaderManager != null && !mLoaderManager.f)
                {
                    mLoaderManager.b();
                }
            }
            mCheckedForLoaderManager = true;
        }
        mFragments.o();
        if (mAllLoaderManagers != null)
        {
            int i1 = mAllLoaderManagers.size();
            o ao[] = new o[i1];
            for (k = i1 - 1; k >= 0; k--)
            {
                ao[k] = (o)mAllLoaderManagers.c(k);
            }

            for (int l = 0; l < i1; l++)
            {
                o o1 = ao[l];
                o1.e();
                o1.g();
            }

        }
    }

    protected void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        mStopped = true;
        mHandler.sendEmptyMessage(1);
        mFragments.r();
    }

    public void startActivityForResult(Intent intent, int k)
    {
        if (k != -1 && (0xffff0000 & k) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, k);
            return;
        }
    }
}
