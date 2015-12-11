// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.opengl.GLES20;

public final class cmv
    implements cmr
{

    private static final float a[] = {
        0.456F, -0.04F, -0.015F, 0.0F, 0.5F, -0.038F, -0.021F, 0.0F, 0.176F, -0.016F, 
        -0.005F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F
    };
    private static final float b[] = {
        -0.043F, 0.378F, -0.072F, 0.0F, -0.088F, 0.734F, -0.113F, 0.0F, 0.0F, -0.018F, 
        1.226F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F
    };
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private final cmw h;
    private final float i[] = new float[16];

    public cmv(Context context)
    {
        d = -1;
        e = -1;
        f = -1;
        g = 1;
        h = new cmw(context);
        h.a();
        context = h;
        ((cmw) (context)).m[0] = 1.0F;
        ((cmw) (context)).m[1] = -1F;
    }

    private static void a(String s, int j)
    {
        int k = GLES20.glGetError();
        if (k != 0 || j == -1)
        {
            bmo.b((new StringBuilder(String.valueOf(s).length() + 21)).append(s).append(": glError ").append(k).toString());
            throw new RuntimeException((new StringBuilder(String.valueOf(s).length() + 21)).append(s).append(": glError ").append(k).toString());
        } else
        {
            return;
        }
    }

    public final String a()
    {
        return "attribute vec4 aVertPos;varying vec2 vTexCrd;void main() {gl_Position = aVertPos;vTexCrd = vec2(aVertPos.x + 1.0, 1.0 - aVertPos.y) * 0.5;}";
    }

    public final void a(int j)
    {
        d = GLES20.glGetUniformLocation(j, "mLt");
        a("glGetUniformLocation mLt", d);
        e = GLES20.glGetUniformLocation(j, "mRt");
        a("glGetUniformLocation mRt", e);
        f = GLES20.glGetUniformLocation(j, "mode");
        a("glGetUniformLocation mode", f);
        c = GLES20.glGetUniformLocation(j, "uRotation");
        a("glGetUniformLocation uRotation", c);
        GLES20.glUniformMatrix4fv(d, 1, false, a, 0);
        GLES20.glUniformMatrix4fv(e, 1, false, b, 0);
        GLES20.glUniform1i(f, g);
    }

    public final void a(int j, int k)
    {
    }

    public final void a(boolean flag)
    {
        h.a(flag);
    }

    public final String b()
    {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 vTexCrd;uniform int mode;uniform samplerExternalOES sTexture;uniform mat4 mLt;uniform mat4 mRt;uniform mat4 uRotation;const vec4 black = vec4(0.0, 0.0, 0.0, 0.0);const float cbusage = 0.7;const float cbdelta = (1.0 - cbusage) / 4.0;void cardboard(vec2 originalTexCrd) {  vec2 texCrd = (uRotation * vec4(originalTexCrd, 1.0, 1.0)).xy;  texCrd.y = (texCrd.y - cbdelta - cbdelta) / cbusage;  vec4 col;  if (texCrd.y < cbdelta + cbdelta || texCrd.y + cbdelta + cbdelta > 1.0) {    col = black;  } else if (texCrd.x < 0.5) {    texCrd.x = (texCrd.x - cbdelta) / cbusage;    col = min(originalTexCrd.x, texCrd.x) > 0.0 && max(originalTexCrd.x, texCrd.x) < 0.5 ?        texture2D(sTexture, vec2(texCrd.x, texCrd.y)) : black;  } else {    texCrd.x = 0.5 + (texCrd.x - 0.5 - cbdelta) / cbusage;    col = min(originalTexCrd.x, texCrd.x) > 0.5 && max(originalTexCrd.x, texCrd.x) < 1.0 ?        texture2D(sTexture, vec2(texCrd.x, texCrd.y)) : black;  }  gl_FragColor = col;}void anaglyph(float x, float y) {  x *= 0.5;  vec4 cLt = texture2D(sTexture, vec2(x, y));  vec4 cRt = texture2D(sTexture, vec2(0.5 + x, y));  gl_FragColor = mLt * cLt + mRt * cRt;}void main(void) {  if (mode == 0)    anaglyph(vTexCrd.x, vTexCrd.y);  else if (mode == 1)    cardboard(vTexCrd);}";
    }

    public final void b(int j, int k)
    {
    }

    public final void c()
    {
        h.a(i);
        GLES20.glUniformMatrix4fv(c, 1, false, i, 0);
    }

    public final void d()
    {
    }

    public final boolean e()
    {
        return true;
    }

}
