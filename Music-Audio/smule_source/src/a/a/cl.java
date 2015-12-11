// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            aw

public final class cl extends aw
{

    private cl(File file)
    {
        super(file);
    }

    cl(File file, byte byte0)
    {
        this(file);
    }

    public final Object a()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject((String)super.a());
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return jsonobject;
    }
}
