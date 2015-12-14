// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.kernelctrl.z;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            f

public class CameraFlashModeDialog extends a
{

    public static final FlashMode a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private android.view.View.OnClickListener g;
    private f h;
    private FlashMode i;

    public CameraFlashModeDialog()
    {
        i = null;
        b();
        c();
    }

    static View a(CameraFlashModeDialog cameraflashmodedialog)
    {
        return cameraflashmodedialog.d;
    }

    static View b(CameraFlashModeDialog cameraflashmodedialog)
    {
        return cameraflashmodedialog.e;
    }

    private void b()
    {
        i = FlashMode.valueOf(z.b("CAMERA_FLASH_MODE", a.toString(), Globals.d()));
    }

    static View c(CameraFlashModeDialog cameraflashmodedialog)
    {
        return cameraflashmodedialog.f;
    }

    private void c()
    {
        z.a("CAMERA_FLASH_MODE", i.toString(), Globals.d());
    }

    static void d(CameraFlashModeDialog cameraflashmodedialog)
    {
        cameraflashmodedialog.c();
    }

    static f e(CameraFlashModeDialog cameraflashmodedialog)
    {
        return cameraflashmodedialog.h;
    }

    public void a(FlashMode flashmode)
    {
        i = flashmode;
        class _cls5
        {

            static final int a[];

            static 
            {
                a = new int[FlashMode.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.camera.FlashMode.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[FlashMode.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[FlashMode.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.cyberlink.youcammakeup.camera._cls5.a[flashmode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            d.setSelected(true);
            e.setSelected(false);
            f.setSelected(false);
            return;

        case 2: // '\002'
            d.setSelected(false);
            e.setSelected(true);
            f.setSelected(false);
            return;

        case 3: // '\003'
            d.setSelected(false);
            break;
        }
        e.setSelected(false);
        f.setSelected(true);
    }

    public void a(f f1)
    {
        h = f1;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraFlashModeDialog a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = CameraFlashModeDialog.this;
                super();
            }
        });
        c = b.findViewById(0x7f0c052a);
        c.setOnTouchListener(new android.view.View.OnTouchListener() {

            final CameraFlashModeDialog a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = CameraFlashModeDialog.this;
                super();
            }
        });
        d = b.findViewById(0x7f0c052f);
        e = b.findViewById(0x7f0c052d);
        f = b.findViewById(0x7f0c052b);
        g = new android.view.View.OnClickListener() {

            final CameraFlashModeDialog a;

            public void onClick(View view)
            {
                FlashMode flashmode = null;
                if (view != com.cyberlink.youcammakeup.camera.CameraFlashModeDialog.a(a)) goto _L2; else goto _L1
_L1:
                flashmode = com.cyberlink.youcammakeup.camera.FlashMode.a;
_L4:
                a.a(flashmode);
                CameraFlashModeDialog.d(a);
                if (CameraFlashModeDialog.e(a) != null)
                {
                    CameraFlashModeDialog.e(a).a(flashmode);
                }
                a.dismiss();
                return;
_L2:
                if (view == CameraFlashModeDialog.b(a))
                {
                    flashmode = FlashMode.b;
                } else
                if (view == CameraFlashModeDialog.c(a))
                {
                    flashmode = FlashMode.c;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = CameraFlashModeDialog.this;
                super();
            }
        };
        d.setOnClickListener(g);
        e.setOnClickListener(g);
        f.setOnClickListener(g);
        getDialog().setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

            final CameraFlashModeDialog a;

            public boolean onKey(DialogInterface dialoginterface, int j, KeyEvent keyevent)
            {
                return j == 27 || j == 24 || j == 25;
            }

            
            {
                a = CameraFlashModeDialog.this;
                super();
            }
        });
        a(i);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0x7f0a0209);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        b = layoutinflater.inflate(0x7f0300e9, viewgroup);
        return b;
    }

    static 
    {
        a = com.cyberlink.youcammakeup.camera.FlashMode.a;
    }

    private class FlashMode extends Enum
    {

        public static final FlashMode a;
        public static final FlashMode b;
        public static final FlashMode c;
        private static final FlashMode d[];

        public static FlashMode valueOf(String s)
        {
            return (FlashMode)Enum.valueOf(com/cyberlink/youcammakeup/camera/CameraFlashModeDialog$FlashMode, s);
        }

        public static FlashMode[] values()
        {
            return (FlashMode[])d.clone();
        }

        static 
        {
            a = new FlashMode("AUTO", 0);
            b = new FlashMode("OFF", 1);
            c = new FlashMode("ON", 2);
            d = (new FlashMode[] {
                a, b, c
            });
        }

        private FlashMode(String s, int j)
        {
            super(s, j);
        }
    }

}
