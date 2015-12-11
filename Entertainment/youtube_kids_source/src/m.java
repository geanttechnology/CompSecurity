// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
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

public class m extends Activity
{

    final Handler a = new n(this);
    public final t b = new t();
    boolean c;
    boolean d;
    boolean e;
    private q f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private dk l;
    private al m;

    public m()
    {
        f = new o(this);
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
        int i1;
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
        i1 = view.getId();
        if (i1 == -1) goto _L6; else goto _L5
_L5:
        stringbuilder.append(" #");
        stringbuilder.append(Integer.toHexString(i1));
        obj = view.getResources();
        if (i1 == 0 || obj == null) goto _L6; else goto _L7
_L7:
        0xff000000 & i1;
        JVM INSTR lookupswitch 2: default 436
    //                   16777216: 616
    //                   2130706432: 610;
           goto _L8 _L9 _L10
_L8:
        view = ((Resources) (obj)).getResourcePackageName(i1);
_L12:
        s = ((Resources) (obj)).getResourceTypeName(i1);
        obj = ((Resources) (obj)).getResourceEntryName(i1);
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
            int j1 = view.getChildCount();
            if (j1 > 0)
            {
                s = (new StringBuilder()).append(s).append("  ").toString();
                int i1 = 0;
                while (i1 < j1) 
                {
                    a(s, printwriter, view.getChildAt(i1));
                    i1++;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final al a(String s, boolean flag, boolean flag1)
    {
        if (l == null)
        {
            l = new dk();
        }
        al al1 = (al)l.get(s);
        if (al1 == null)
        {
            if (flag1)
            {
                al1 = new al(s, this, flag);
                l.put(s, al1);
            }
            return al1;
        } else
        {
            al1.e = this;
            return al1;
        }
    }

    public final void a(j j1, Intent intent, int i1)
    {
        if (i1 == -1)
        {
            super.startActivityForResult(intent, -1);
            return;
        }
        if ((0xffff0000 & i1) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, (j1.i + 1 << 16) + (0xffff & i1));
            return;
        }
    }

    final void a(String s)
    {
        if (l != null)
        {
            al al1 = (al)l.get(s);
            if (al1 != null && !al1.g)
            {
                al1.g();
                l.remove(s);
            }
        }
    }

    final void a(boolean flag)
    {
        if (!i)
        {
            i = true;
            d = flag;
            a.removeMessages(1);
            if (k)
            {
                k = false;
                if (m != null)
                {
                    if (!d)
                    {
                        m.c();
                    } else
                    {
                        m.d();
                    }
                }
            }
            b.a(2, false);
        }
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        printwriter.print(s);
        printwriter.print("Local FragmentActivity ");
        printwriter.print(Integer.toHexString(System.identityHashCode(this)));
        printwriter.println(" State:");
        String s1 = (new StringBuilder()).append(s).append("  ").toString();
        printwriter.print(s1);
        printwriter.print("mCreated=");
        printwriter.print(g);
        printwriter.print("mResumed=");
        printwriter.print(h);
        printwriter.print(" mStopped=");
        printwriter.print(c);
        printwriter.print(" mReallyStopped=");
        printwriter.println(i);
        printwriter.print(s1);
        printwriter.print("mLoadersStarted=");
        printwriter.println(k);
        if (m != null)
        {
            printwriter.print(s);
            printwriter.print("Loader Manager ");
            printwriter.print(Integer.toHexString(System.identityHashCode(m)));
            printwriter.println(":");
            m.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
        b.a(s, filedescriptor, printwriter, as);
        printwriter.print(s);
        printwriter.println("View Hierarchy:");
        a((new StringBuilder()).append(s).append("  ").toString(), printwriter, getWindow().getDecorView());
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        b.j = false;
        int k1 = i1 >> 16;
        if (k1 != 0)
        {
            k1--;
            if (b.b == null || k1 < 0 || k1 >= b.b.size())
            {
                Log.w("FragmentActivity", (new StringBuilder("Activity result fragment index out of range: 0x")).append(Integer.toHexString(i1)).toString());
                return;
            }
            intent = (j)b.b.get(k1);
            if (intent == null)
            {
                Log.w("FragmentActivity", (new StringBuilder("Activity result no fragment exists for index: 0x")).append(Integer.toHexString(i1)).toString());
                return;
            } else
            {
                intent.a(0xffff & i1, j1);
                return;
            }
        } else
        {
            super.onActivityResult(i1, j1, intent);
            return;
        }
    }

    public void onBackPressed()
    {
label0:
        {
            t t1 = b;
            t1.e();
            t1.f();
            Handler handler = t1.h.a;
            if (!t1.a(null, -1, 0))
            {
                if (android.os.Build.VERSION.SDK_INT < 21)
                {
                    break label0;
                }
                finishAfterTransition();
            }
            return;
        }
        finish();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        b.a(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        b.a(this, f, null);
        if (getLayoutInflater().getFactory() == null)
        {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        p p1 = (p)getLastNonConfigurationInstance();
        if (p1 != null)
        {
            l = p1.b;
        }
        if (bundle != null)
        {
            android.os.Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            t t1 = b;
            if (p1 != null)
            {
                bundle = p1.a;
            } else
            {
                bundle = null;
            }
            t1.a(parcelable, bundle);
        }
        b.h();
    }

    public boolean onCreatePanelMenu(int i1, Menu menu)
    {
        if (i1 == 0)
        {
            boolean flag = super.onCreatePanelMenu(i1, menu);
            boolean flag1 = b.a(menu, getMenuInflater());
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                return flag | flag1;
            } else
            {
                return true;
            }
        } else
        {
            return super.onCreatePanelMenu(i1, menu);
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
            View view1 = b.onCreateView(s, context, attributeset);
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
        a(false);
        b.n();
        if (m != null)
        {
            m.g();
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (android.os.Build.VERSION.SDK_INT < 5 && i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        b.o();
    }

    public boolean onMenuItemSelected(int i1, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(i1, menuitem))
        {
            return true;
        }
        switch (i1)
        {
        default:
            return false;

        case 0: // '\0'
            return b.a(menuitem);

        case 6: // '\006'
            return b.b(menuitem);
        }
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        b.j = false;
    }

    public void onPanelClosed(int i1, Menu menu)
    {
        i1;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 27;
           goto _L1 _L2
_L1:
        super.onPanelClosed(i1, menu);
        return;
_L2:
        b.b(menu);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onPause()
    {
        super.onPause();
        h = false;
        if (a.hasMessages(2))
        {
            a.removeMessages(2);
            b.k();
        }
        b.a(4, false);
    }

    protected void onPostResume()
    {
        super.onPostResume();
        a.removeMessages(2);
        b.k();
        b.f();
    }

    public boolean onPreparePanel(int i1, View view, Menu menu)
    {
        if (i1 == 0 && menu != null)
        {
            if (e)
            {
                e = false;
                menu.clear();
                onCreatePanelMenu(i1, menu);
            }
            return super.onPreparePanel(0, view, menu) | b.a(menu);
        } else
        {
            return super.onPreparePanel(i1, view, menu);
        }
    }

    public void onResume()
    {
        super.onResume();
        a.sendEmptyMessage(2);
        h = true;
        b.f();
    }

    public final Object onRetainNonConfigurationInstance()
    {
        boolean flag1 = false;
        if (c)
        {
            a(true);
        }
        t t1 = b;
        ArrayList arraylist1;
        if (t1.b != null)
        {
            int i1 = 0;
            ArrayList arraylist = null;
            do
            {
                arraylist1 = arraylist;
                if (i1 >= t1.b.size())
                {
                    break;
                }
                j j1 = (j)t1.b.get(i1);
                arraylist1 = arraylist;
                if (j1 != null)
                {
                    arraylist1 = arraylist;
                    if (j1.E)
                    {
                        arraylist1 = arraylist;
                        if (arraylist == null)
                        {
                            arraylist1 = new ArrayList();
                        }
                        arraylist1.add(j1);
                        j1.F = true;
                        int l1;
                        if (j1.l != null)
                        {
                            l1 = j1.l.i;
                        } else
                        {
                            l1 = -1;
                        }
                        j1.m = l1;
                    }
                }
                i1++;
                arraylist = arraylist1;
            } while (true);
        } else
        {
            arraylist1 = null;
        }
        if (l != null)
        {
            int j2 = l.size();
            al aal[] = new al[j2];
            for (int k1 = j2 - 1; k1 >= 0; k1--)
            {
                aal[k1] = (al)l.c(k1);
            }

            boolean flag = false;
            int i2 = ((flag1) ? 1 : 0);
            do
            {
                flag1 = flag;
                if (i2 >= j2)
                {
                    break;
                }
                al al1 = aal[i2];
                if (al1.g)
                {
                    flag = true;
                } else
                {
                    al1.g();
                    l.remove(al1.d);
                }
                i2++;
            } while (true);
        } else
        {
            flag1 = false;
        }
        if (arraylist1 == null && !flag1)
        {
            return null;
        } else
        {
            p p1 = new p();
            p1.a = arraylist1;
            p1.b = l;
            return p1;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        android.os.Parcelable parcelable = b.g();
        if (parcelable != null)
        {
            bundle.putParcelable("android:support:fragments", parcelable);
        }
    }

    public void onStart()
    {
        super.onStart();
        c = false;
        i = false;
        a.removeMessages(1);
        if (!g)
        {
            g = true;
            b.i();
        }
        b.j = false;
        b.f();
        if (!k)
        {
            k = true;
            int i1;
            if (m != null)
            {
                m.b();
            } else
            if (!j)
            {
                m = a("(root)", k, false);
                if (m != null && !m.f)
                {
                    m.b();
                }
            }
            j = true;
        }
        b.j();
        if (l != null)
        {
            int l1 = l.size();
            al aal[] = new al[l1];
            for (i1 = l1 - 1; i1 >= 0; i1--)
            {
                aal[i1] = (al)l.c(i1);
            }

            for (int j1 = 0; j1 < l1; j1++)
            {
                al al1 = aal[j1];
                if (al1.g)
                {
                    al1.g = false;
                    for (int k1 = al1.b.a() - 1; k1 >= 0; k1--)
                    {
                        am am1 = (am)al1.b.d(k1);
                        if (am1.h)
                        {
                            am1.h = false;
                            if (am1.g != am1.i && !am1.g)
                            {
                                am1.b();
                            }
                        }
                        if (am1.g && am1.d && !am1.j)
                        {
                            am1.b(am1.c, am1.f);
                        }
                    }

                }
                al1.f();
            }

        }
    }

    public void onStop()
    {
        super.onStop();
        c = true;
        a.sendEmptyMessage(1);
        b.m();
    }

    public void startActivityForResult(Intent intent, int i1)
    {
        if (i1 != -1 && (0xffff0000 & i1) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, i1);
            return;
        }
    }
}
