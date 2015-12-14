// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import com.socialin.android.d;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class e
{

    int a;
    private int b;
    private int c;
    private String d;
    private String e;

    public e()
    {
    }

    public e(int i, int j, Context context)
    {
        StringBuilder stringbuilder;
        StringBuilder stringbuilder1;
        stringbuilder1 = new StringBuilder();
        stringbuilder = new StringBuilder();
        Object obj;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i)));
        obj = bufferedreader.readLine();
_L1:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        stringbuilder1.append(((String) (obj))).append("\n");
        obj = bufferedreader.readLine();
          goto _L1
        stringbuilder1.deleteCharAt(stringbuilder1.length() - 1);
        obj = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(j)));
        context = ((BufferedReader) (obj)).readLine();
_L3:
        if (context == null)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(context).append("\n");
        context = ((BufferedReader) (obj)).readLine();
        if (true) goto _L3; else goto _L2
_L2:
        String s;
        try
        {
            stringbuilder.deleteCharAt(stringbuilder.length() - 1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            (new StringBuilder("Could not read shader: ")).append(context.getLocalizedMessage());
        }
        context = stringbuilder1.toString();
        s = stringbuilder.toString();
        d = context;
        e = s;
        b = a(35633, d);
        if (b != 0)
        {
            c = a(35632, e);
            if (c != 0)
            {
                a = GLES20.glCreateProgram();
                if (a != 0)
                {
                    GLES20.glAttachShader(a, b);
                    GLES20.glAttachShader(a, c);
                    GLES20.glLinkProgram(a);
                    context = new int[1];
                    GLES20.glGetProgramiv(a, 35714, context, 0);
                    if (context[0] != 1)
                    {
                        com.socialin.android.d.b("Shader", new Object[] {
                            "Could not link _program: "
                        });
                        com.socialin.android.d.b("Shader", new Object[] {
                            GLES20.glGetProgramInfoLog(a)
                        });
                        GLES20.glDeleteProgram(a);
                        a = 0;
                    }
                }
            }
        }
        return;
    }

    private static int a(int i, String s)
    {
        int j = GLES20.glCreateShader(i);
        if (j != 0)
        {
            GLES20.glShaderSource(j, s);
            GLES20.glCompileShader(j);
            s = new int[1];
            GLES20.glGetShaderiv(j, 35713, s, 0);
            if (s[0] == 0)
            {
                com.socialin.android.d.b("Shader", new Object[] {
                    (new StringBuilder("Could not compile shader ")).append(i).append(":").toString()
                });
                com.socialin.android.d.b("Shader", new Object[] {
                    GLES20.glGetShaderInfoLog(j)
                });
                GLES20.glDeleteShader(j);
                return 0;
            }
        }
        return j;
    }
}
