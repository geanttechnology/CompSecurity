// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.cast.CastDevice;
import org.json.JSONException;
import org.json.JSONObject;

final class ajz
    implements auo
{

    private aju a;

    ajz(aju aju1)
    {
        a = aju1;
        super();
    }

    public final void a(CastDevice castdevice, String s, String s1)
    {
        if (a.h != aki.d) goto _L2; else goto _L1
_L1:
        a.a("messageReceivedCallback: no longer connected");
_L4:
        return;
_L2:
        if (!a.b.b())
        {
            a.a("connectionCallback: no connected client");
            return;
        }
        aju aju1 = a;
        castdevice = String.valueOf(castdevice.b);
        aju1.a((new StringBuilder(String.valueOf(castdevice).length() + 38 + String.valueOf(s).length() + String.valueOf(s1).length())).append("Received message from ").append(castdevice).append(" in namespace ").append(s).append(": ").append(s1).toString());
        if (!s.equals("urn:x-cast:com.google.youtube.mdx")) goto _L4; else goto _L3
_L3:
        s = (new JSONObject(s1)).getJSONObject("data").getString("screenId");
        if (a.h != aki.b) goto _L4; else goto _L5
_L5:
        aju aju2;
        a.h = aki.c;
        aju2 = a;
        castdevice = String.valueOf(s);
        if (castdevice.length() == 0)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        castdevice = "connected to ".concat(castdevice);
_L6:
        aju2.a(castdevice);
        a.a.a(new cgr(s));
        castdevice = a;
        castdevice.a("setup remote media player");
        ((aju) (castdevice)).b.f();
        return;
        try
        {
            castdevice = new String("connected to ");
        }
        // Misplaced declaration of an exception variable
        catch (CastDevice castdevice)
        {
            s = a;
            castdevice = String.valueOf(s1);
            if (castdevice.length() != 0)
            {
                castdevice = "Cannot parse message ".concat(castdevice);
            } else
            {
                castdevice = new String("Cannot parse message ");
            }
            s.a(castdevice);
            return;
        }
          goto _L6
    }
}
