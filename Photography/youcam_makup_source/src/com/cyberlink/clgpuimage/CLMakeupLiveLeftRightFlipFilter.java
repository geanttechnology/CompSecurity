// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u

public class CLMakeupLiveLeftRightFlipFilter extends u
{

    protected int a;
    protected int b;
    protected FLIP_MODE c;

    public CLMakeupLiveLeftRightFlipFilter()
    {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nuniform float flip_x;\nuniform float flip_y;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    if (flip_x > 0.5)\n        textureCoordinate.x = 1.0 - inputTextureCoordinate.x;\n    if (flip_y > 0.5)\n        textureCoordinate.y = 1.0 - inputTextureCoordinate.y;\n}", "\n#ifdef GL_FRAGMENT_PRECISION_HIGH\nprecision highp float;\n#else\nprecision mediump float;\n#endif\nvarying vec2 textureCoordinate; \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        c = FLIP_MODE.a;
    }

    public void a()
    {
        super.a();
        a = GLES20.glGetUniformLocation(l(), "flip_x");
        b = GLES20.glGetUniformLocation(l(), "flip_y");
        a(c);
    }

    public void a(FLIP_MODE flip_mode)
    {
        c = flip_mode;
        if (FLIP_MODE.b == flip_mode)
        {
            a(a, 1.0F);
            a(b, 0.0F);
            return;
        }
        if (FLIP_MODE.c == flip_mode)
        {
            a(a, 0.0F);
            a(b, 1.0F);
            return;
        } else
        {
            a(a, 0.0F);
            a(b, 0.0F);
            return;
        }
    }

    private class FLIP_MODE extends Enum
    {

        public static final FLIP_MODE a;
        public static final FLIP_MODE b;
        public static final FLIP_MODE c;
        private static final FLIP_MODE d[];

        public static FLIP_MODE valueOf(String s)
        {
            return (FLIP_MODE)Enum.valueOf(com/cyberlink/clgpuimage/CLMakeupLiveLeftRightFlipFilter$FLIP_MODE, s);
        }

        public static FLIP_MODE[] values()
        {
            return (FLIP_MODE[])d.clone();
        }

        static 
        {
            a = new FLIP_MODE("NONE", 0);
            b = new FLIP_MODE("FOR_PORTRAIT_ORIENTATION", 1);
            c = new FLIP_MODE("FOR_LANDSCAPE_ORIENTATION", 2);
            d = (new FLIP_MODE[] {
                a, b, c
            });
        }

        private FLIP_MODE(String s, int i)
        {
            super(s, i);
        }
    }

}
