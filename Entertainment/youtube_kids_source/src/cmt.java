// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cmt
    implements cmr
{

    public cmt()
    {
    }

    public final String a()
    {
        return "attribute vec4 aVertPos;varying vec2 vTexCrd;void main() {gl_Position = aVertPos;vTexCrd = vec2(aVertPos.x + 1.0, 1.0 - aVertPos.y) * 0.5;}";
    }

    public final void a(int i)
    {
    }

    public final void a(int i, int j)
    {
    }

    public final void a(boolean flag)
    {
    }

    public final String b()
    {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 vTexCrd;uniform samplerExternalOES sTexture;void main(void) {  gl_FragColor = texture2D(sTexture, vTexCrd);}";
    }

    public final void b(int i, int j)
    {
    }

    public final void c()
    {
    }

    public final void d()
    {
    }

    public final boolean e()
    {
        return true;
    }
}
