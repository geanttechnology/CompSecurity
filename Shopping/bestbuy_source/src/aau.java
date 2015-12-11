// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;
import java.util.concurrent.Future;
import org.json.JSONObject;

public class aau
    implements aas
{

    public aau()
    {
    }

    public ut a(aar aar1, JSONObject jsonobject)
    {
        return b(aar1, jsonobject);
    }

    public ur b(aar aar1, JSONObject jsonobject)
    {
        Future future = aar1.a(jsonobject, "image", true);
        aar1 = aar1.a(jsonobject, "secondary_image", false);
        return new ur(jsonobject.getString("headline"), (Drawable)future.get(), jsonobject.getString("body"), (Drawable)aar1.get(), jsonobject.getString("call_to_action"), jsonobject.getString("attribution"));
    }
}
