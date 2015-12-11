// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.g;

import c.a.a.a.a.b.l;
import c.a.a.a.a.f.b;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

public class g
{

    private final n a;

    public g(n n)
    {
        a = n;
    }

    public JSONObject a()
    {
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        e.d().a("Fabric", "Reading cached settings...");
        Object obj = new File((new b(a)).a(), "com.crashlytics.settings.json");
        if (!((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        obj = new FileInputStream(((File) (obj)));
        obj1 = obj;
        obj2 = new JSONObject(l.a(((java.io.InputStream) (obj))));
        obj1 = obj;
        obj = obj2;
_L4:
        l.a(((java.io.Closeable) (obj1)), "Error while closing settings cache file.");
        return ((JSONObject) (obj));
_L2:
        e.d().a("Fabric", "No cached settings found.");
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        obj2;
        obj = null;
_L8:
        obj1 = obj;
        e.d().c("Fabric", "Failed to fetch cached settings", ((Throwable) (obj2)));
        l.a(((java.io.Closeable) (obj)), "Error while closing settings cache file.");
        return null;
        Exception exception;
        exception;
        obj1 = obj2;
_L6:
        l.a(((java.io.Closeable) (obj1)), "Error while closing settings cache file.");
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        obj2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void a(long l1, JSONObject jsonobject)
    {
        Object obj;
        e.d().a("Fabric", "Writing settings to cache file...");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = null;
        FileWriter filewriter;
        jsonobject.put("expires_at", l1);
        filewriter = new FileWriter(new File((new b(a)).a(), "com.crashlytics.settings.json"));
        obj = filewriter;
        filewriter.write(jsonobject.toString());
        obj = filewriter;
        filewriter.flush();
        l.a(filewriter, "Failed to close settings writer.");
        return;
        Exception exception;
        exception;
        jsonobject = null;
_L4:
        obj = jsonobject;
        e.d().c("Fabric", "Failed to cache settings", exception);
        l.a(jsonobject, "Failed to close settings writer.");
        return;
        jsonobject;
_L2:
        l.a(((java.io.Closeable) (obj)), "Failed to close settings writer.");
        throw jsonobject;
        jsonobject;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        jsonobject = filewriter;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
