// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import org.json.JSONObject;

public final class bb
{

    public bb()
    {
    }

    public static JSONObject a(InputStream inputstream)
    {
        Exception exception1;
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(bc.a(inputstream).toString());
        }
        catch (Exception exception)
        {
            bc.a(inputstream);
            return null;
        }
        finally
        {
            bc.a(inputstream);
        }
        bc.a(inputstream);
        return jsonobject;
        throw exception1;
    }
}
