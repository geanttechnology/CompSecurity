// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.a.k;

public class b extends InputConnectionWrapper
{

    public static String a;
    public static boolean b = false;
    public static boolean c = false;

    public b(InputConnection inputconnection, boolean flag)
    {
        super(inputconnection, flag);
    }

    public boolean commitText(CharSequence charsequence, int i)
    {
        c = true;
        a = charsequence.toString();
        k.b("CaptureInputConnection", (new StringBuilder()).append("-->commitText: ").append(charsequence.toString()).toString());
        return super.commitText(charsequence, i);
    }

    public boolean sendKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getAction() == 0)
        {
            k.c("CaptureInputConnection", "sendKeyEvent");
            a = String.valueOf((char)keyevent.getUnicodeChar());
            c = true;
            k.b("CaptureInputConnection", (new StringBuilder()).append("s: ").append(a).toString());
        }
        k.b("CaptureInputConnection", (new StringBuilder()).append("-->sendKeyEvent: ").append(a).toString());
        return super.sendKeyEvent(keyevent);
    }

    public boolean setComposingText(CharSequence charsequence, int i)
    {
        c = true;
        a = charsequence.toString();
        k.b("CaptureInputConnection", (new StringBuilder()).append("-->setComposingText: ").append(charsequence.toString()).toString());
        return super.setComposingText(charsequence, i);
    }

}
