// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.MakeupMode;

// Referenced classes of package w.a:
//            a

public class b extends a
{

    private View a;
    private long b;
    private int c;
    private int d;
    private Runnable e;

    public b(Context context, boolean flag)
    {
        super(context, flag);
        d = 0x7f0703b9;
        e = new Runnable() {

            final b a;

            public void run()
            {
                b.a(a).setVisibility(0);
            }

            
            {
                a = b.this;
                super();
            }
        };
        setCancelable(false);
        b(MakeupMode.g);
    }

    static View a(b b1)
    {
        return b1.a;
    }

    private void b(MakeupMode makeupmode)
    {
        class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[MakeupMode.values().length];
                try
                {
                    a[MakeupMode.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[MakeupMode.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[MakeupMode.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[MakeupMode.e.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[MakeupMode.b.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[MakeupMode.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[MakeupMode.g.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2.a[makeupmode.ordinal()])
        {
        default:
            c = 0x7f03020d;
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            d = 0x7f0706fd;
            c = 0x7f03020f;
            return;

        case 5: // '\005'
        case 6: // '\006'
            d = 0x7f0706fc;
            break;
        }
        c = 0x7f03020f;
    }

    protected int a()
    {
        return c;
    }

    public void a(long l)
    {
        b = l;
    }

    protected void a(View view)
    {
        a = view.findViewById(0x7f0c08eb);
        view = view.findViewById(0x7f0c08ec);
        if (view != null)
        {
            ((TextView)(TextView)view).setText(d);
        }
    }

    public void a(MakeupMode makeupmode)
    {
        b(makeupmode);
    }

    protected void onStart()
    {
        super.onStart();
        a.setVisibility(4);
        Globals.e(e);
        Globals.a(e, b);
    }

    protected void onStop()
    {
        Globals.e(e);
        super.onStop();
    }
}
