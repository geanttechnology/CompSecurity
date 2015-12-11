// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

// Referenced classes of package com.pointinside.maps:
//            MapView

private class mSampleSize
    implements android.opengl.ooser
{

    private static final String kTag = "GDC11";
    private int mSampleSize;
    private boolean mUsesCoverageAa;
    private int mValue[];
    final MapView this$0;

    private int findConfigAttrib(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, int i, int j)
    {
        if (egl10.eglGetConfigAttrib(egldisplay, eglconfig, i, mValue))
        {
            j = mValue[0];
        }
        return j;
    }

    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay)
    {
        EGLConfig aeglconfig[];
        int i;
        mValue = new int[1];
        int ai[] = new int[15];
        ai[0] = 12324;
        ai[1] = 5;
        ai[2] = 12323;
        ai[3] = 6;
        ai[4] = 12322;
        ai[5] = 5;
        ai[6] = 12325;
        ai[7] = 16;
        ai[8] = 12352;
        ai[9] = 4;
        ai[10] = 12338;
        ai[11] = 1;
        ai[12] = 12337;
        ai[13] = mSampleSize;
        ai[14] = 12344;
        if (!egl10.eglChooseConfig(egldisplay, ai, null, 0, mValue))
        {
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
        int j = mValue[0];
        i = j;
        if (j <= 0)
        {
            ai = new int[15];
            ai;
            ai[0] = 12324;
            ai[1] = 5;
            ai[2] = 12323;
            ai[3] = 6;
            ai[4] = 12322;
            ai[5] = 5;
            ai[6] = 12325;
            ai[7] = 16;
            ai[8] = 12352;
            ai[9] = 4;
            ai[10] = 12512;
            ai[11] = 1;
            ai[12] = 12513;
            ai[13] = 2;
            ai[14] = 12344;
            if (!egl10.eglChooseConfig(egldisplay, ai, null, 0, mValue))
            {
                throw new IllegalArgumentException("2nd eglChooseConfig failed");
            }
            i = mValue[0];
            if (i <= 0)
            {
                ai = new int[11];
                ai;
                ai[0] = 12324;
                ai[1] = 5;
                ai[2] = 12323;
                ai[3] = 6;
                ai[4] = 12322;
                ai[5] = 5;
                ai[6] = 12325;
                ai[7] = 16;
                ai[8] = 12352;
                ai[9] = 4;
                ai[10] = 12344;
                if (!egl10.eglChooseConfig(egldisplay, ai, null, 0, mValue))
                {
                    throw new IllegalArgumentException("3rd eglChooseConfig failed");
                }
                int k = mValue[0];
                i = k;
                if (k <= 0)
                {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
            } else
            {
                mUsesCoverageAa = true;
            }
        }
        aeglconfig = new EGLConfig[i];
        if (!egl10.eglChooseConfig(egldisplay, ai, aeglconfig, i, mValue))
        {
            throw new IllegalArgumentException("data eglChooseConfig failed");
        }
        i = 0;
_L3:
        if (i >= aeglconfig.length)
        {
            break MISSING_BLOCK_LABEL_531;
        }
        if (findConfigAttrib(egl10, egldisplay, aeglconfig[i], 12324, 0) != 5) goto _L2; else goto _L1
_L1:
        if (i == -1)
        {
            Log.w("GDC11", "Did not find sane config, using first");
        }
        if (aeglconfig.length > 0)
        {
            egl10 = aeglconfig[i];
        } else
        {
            egl10 = null;
        }
        if (egl10 == null)
        {
            throw new IllegalArgumentException("No config chosen");
        } else
        {
            return egl10;
        }
_L2:
        i++;
          goto _L3
        i = -1;
          goto _L1
    }

    public boolean usesCoverageAa()
    {
        return mUsesCoverageAa;
    }

    public (int i)
    {
        this$0 = MapView.this;
        super();
        mSampleSize = i;
    }
}
