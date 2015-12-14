// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ar;

import android.graphics.PorterDuffXfermode;

public abstract class b extends Enum
{

    private static final b $VALUES[];
    public static final b ADD;
    public static final b DARKEN;
    public static final b LIGHTEN;
    public static final b MULTIPLY;
    public static final b NORMAL;
    public static final b OVERLAY;
    public static final b SCREEN;
    public static final b XOR;
    private android.graphics.PorterDuff.Mode mode;
    private PorterDuffXfermode xfermode;

    private b(String s, int i, PorterDuffXfermode porterduffxfermode, android.graphics.PorterDuff.Mode mode1)
    {
        super(s, i);
        xfermode = porterduffxfermode;
        mode = mode1;
    }


    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(myobfuscated/ar/b, s);
    }

    public static b[] values()
    {
        return (b[])$VALUES.clone();
    }

    public abstract String getDisplayName();

    public android.graphics.PorterDuff.Mode getMode()
    {
        return mode;
    }

    public PorterDuffXfermode getXfermode()
    {
        return xfermode;
    }

    public void setMode(android.graphics.PorterDuff.Mode mode1)
    {
        mode = mode1;
    }

    public void setXfermode(PorterDuffXfermode porterduffxfermode)
    {
        xfermode = porterduffxfermode;
    }

    static 
    {
        NORMAL = new b("NORMAL", 0, null, null) {

            public final String getDisplayName()
            {
                return "Normal";
            }

            public final String toString()
            {
                return "Normal";
            }

        };
        MULTIPLY = new b("MULTIPLY", 1, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.MULTIPLY), android.graphics.PorterDuff.Mode.MULTIPLY) {

            public final String getDisplayName()
            {
                return "Multiply";
            }

            public final String toString()
            {
                return "Multiply";
            }

        };
        LIGHTEN = new b("LIGHTEN", 2, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.LIGHTEN), android.graphics.PorterDuff.Mode.LIGHTEN) {

            public final String getDisplayName()
            {
                return "Lighten";
            }

            public final String toString()
            {
                return "Lighten";
            }

        };
        DARKEN = new b("DARKEN", 3, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DARKEN), android.graphics.PorterDuff.Mode.DARKEN) {

            public final String getDisplayName()
            {
                return "Darken";
            }

            public final String toString()
            {
                return "Darken";
            }

        };
        SCREEN = new b("SCREEN", 4, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SCREEN), android.graphics.PorterDuff.Mode.SCREEN) {

            public final String getDisplayName()
            {
                return "Screen";
            }

            public final String toString()
            {
                return "Screen";
            }

        };
        XOR = new b("XOR", 5, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.XOR), android.graphics.PorterDuff.Mode.XOR) {

            public final String getDisplayName()
            {
                return "Xor";
            }

            public final String toString()
            {
                return "Xor";
            }

        };
        ADD = new b("ADD", 6, null, null) {

            public final String getDisplayName()
            {
                return "Add";
            }

            public final String toString()
            {
                return "Add";
            }

        };
        OVERLAY = new b("OVERLAY", 7, null, null) {

            public final String getDisplayName()
            {
                return "Overlay";
            }

            public final String toString()
            {
                return "Overlay";
            }

        };
        $VALUES = (new b[] {
            NORMAL, MULTIPLY, LIGHTEN, DARKEN, SCREEN, XOR, ADD, OVERLAY
        });
    }
}
