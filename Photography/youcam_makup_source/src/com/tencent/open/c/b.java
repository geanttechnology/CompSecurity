// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.a.k;
import com.tencent.open.web.security.a;

// Referenced classes of package com.tencent.open.c:
//            a

public class b extends com.tencent.open.c.a
{

    public static boolean a;
    private KeyEvent b;
    private com.tencent.open.web.security.b c;

    public b(Context context)
    {
        super(context);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        k.b("SecureWebView", (new StringBuilder()).append("-->dispatchKeyEvent, is device support: ").append(a).toString());
        if (!a)
        {
            return super.dispatchKeyEvent(keyevent);
        }
        if (keyevent.getAction() == 0)
        {
            switch (keyevent.getKeyCode())
            {
            default:
                if (keyevent.getUnicodeChar() == 0)
                {
                    return super.dispatchKeyEvent(keyevent);
                }
                break;

            case 67: // 'C'
                com.tencent.open.web.security.b.b = true;
                return super.dispatchKeyEvent(keyevent);

            case 4: // '\004'
                return super.dispatchKeyEvent(keyevent);

            case 66: // 'B'
                return super.dispatchKeyEvent(keyevent);
            }
            if (a.a)
            {
                int i = keyevent.getUnicodeChar();
                if (i >= 33 && i <= 95 || i >= 97 && i <= 125)
                {
                    b = new KeyEvent(0, 17);
                    return super.dispatchKeyEvent(b);
                }
            }
            return super.dispatchKeyEvent(keyevent);
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo)
    {
        k.c("SecureWebView", (new StringBuilder()).append("-->create input connection, is edit: ").append(a.a).toString());
        InputConnection inputconnection = super.onCreateInputConnection(editorinfo);
        k.b("SecureWebView", (new StringBuilder()).append("-->onCreateInputConnection, inputConn is ").append(inputconnection).toString());
        if (inputconnection != null)
        {
            a = true;
            c = new com.tencent.open.web.security.b(super.onCreateInputConnection(editorinfo), false);
            return c;
        } else
        {
            a = false;
            return inputconnection;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        k.b("SecureWebView", (new StringBuilder()).append("-->onKeyDown, is device support: ").append(a).toString());
        if (!a)
        {
            return super.onKeyDown(i, keyevent);
        }
        if (keyevent.getAction() == 0)
        {
            switch (keyevent.getKeyCode())
            {
            default:
                if (keyevent.getUnicodeChar() == 0)
                {
                    return super.onKeyDown(i, keyevent);
                }
                break;

            case 67: // 'C'
                com.tencent.open.web.security.b.b = true;
                return super.onKeyDown(i, keyevent);

            case 4: // '\004'
                return super.onKeyDown(i, keyevent);

            case 66: // 'B'
                return super.onKeyDown(i, keyevent);
            }
            if (a.a)
            {
                int j = keyevent.getUnicodeChar();
                if (j >= 33 && j <= 95 || j >= 97 && j <= 125)
                {
                    b = new KeyEvent(0, 17);
                    return super.onKeyDown(b.getKeyCode(), b);
                }
            }
            return super.onKeyDown(i, keyevent);
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }
}
