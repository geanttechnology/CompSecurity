// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class uw
    implements ku
{

    String a;
    String b;
    private Context c;
    private ux d;
    private kt e;

    public uw(Context context)
    {
        a = "OnlineShow";
        b = "data";
        c = context;
    }

    public List a()
    {
        Object obj;
label0:
        {
            obj = la.a(c, a, b);
            if (obj != null)
            {
                try
                {
                    obj = new JSONObject(((String) (obj)));
                    if (!((JSONObject) (obj)).isNull("data"))
                    {
                        Object obj1 = uv.a(((JSONObject) (obj)).getJSONArray("data"));
                        obj = new ArrayList();
                        obj1 = ((List) (obj1)).iterator();
                        do
                        {
                            if (!((Iterator) (obj1)).hasNext())
                            {
                                break;
                            }
                            uv uv1 = (uv)((Iterator) (obj1)).next();
                            if (uv1.b() == EOnlineResType.PIP_SCENE)
                            {
                                ((List) (obj)).add(uv1);
                            }
                        } while (true);
                        break label0;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((Exception) (obj)).printStackTrace();
                    Crashlytics.logException(((Throwable) (obj)));
                }
            }
            return new ArrayList();
        }
        return ((List) (obj));
    }

    public void a(Exception exception)
    {
    }

    public void a(String s)
    {
        la.a(c, a, b, s);
    }

    public void a(ux ux)
    {
        d = ux;
        try
        {
            e = new kt(b());
            e.a(this);
            e.execute(new String[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ux ux)
        {
            ux.printStackTrace();
        }
        Crashlytics.logException(ux);
    }

    public String b()
    {
        String s = (new StringBuilder()).append("http://fotorus.fotoable.com/fotorus/index.php?m=Material&a=getRecommendationList").append("&appid=pipcam").toString();
        return (new StringBuilder()).append(s).append(pb.a(pb.g(c))).toString();
    }
}
