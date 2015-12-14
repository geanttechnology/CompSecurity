// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import com.wantu.model.GifNetMaterial;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bns
{

    private Context a;
    private String b;
    private List c;
    private SharedPreferences d;

    public bns(Context context)
    {
        a = context;
        b();
    }

    public static String b(String s)
    {
        String s1 = s;
        if (!s.startsWith("NET_"))
        {
            s1 = (new StringBuilder()).append("NET_").append(s).toString();
        }
        return s1;
    }

    private void b()
    {
        b = a.getDir("MaterialLibrary", 0).getAbsolutePath();
        if (b.indexOf(b.length() - 1) != 47)
        {
            b = (new StringBuilder()).append(b).append("/").toString();
        }
    }

    private void c()
    {
        if (!c.contains("SYS_Heart03"))
        {
            c.add("SYS_Heart03");
        }
        if (!c.contains("SYS_Shine"))
        {
            c.add("SYS_Shine");
        }
        if (!c.contains("SYS_Thunder"))
        {
            c.add("SYS_Thunder");
        }
        if (!c.contains("SYS_Fire"))
        {
            c.add("SYS_Fire");
        }
        if (!c.contains("SYS_Heart01"))
        {
            c.add("SYS_Heart01");
        }
        if (!c.contains("SYS_Explode"))
        {
            c.add("SYS_Explode");
        }
        if (!c.contains("SYS_Fireworks"))
        {
            c.add("SYS_Fireworks");
        }
        if (!c.contains("SYS_Kamahema"))
        {
            c.add("SYS_Kamahema");
        }
        if (!c.contains("SYS_01"))
        {
            c.add("SYS_01");
        }
        if (!c.contains("SYS_Angry"))
        {
            c.add("SYS_Angry");
        }
        if (!c.contains("SYS_Cry"))
        {
            c.add("SYS_Cry");
        }
        if (!c.contains("SYS_Han"))
        {
            c.add("SYS_Han");
        }
        if (!c.contains("SYS_Arrow"))
        {
            c.add("SYS_Arrow");
        }
        if (!c.contains("SYS_Butterfly"))
        {
            c.add("SYS_Butterfly");
        }
        if (!c.contains("SYS_Bomb"))
        {
            c.add("SYS_Bomb");
        }
        if (!c.contains("SYS_Fireworks02"))
        {
            c.add("SYS_Fireworks02");
        }
        if (!c.contains("SYS_Heart02"))
        {
            c.add("SYS_Heart02");
        }
        if (!c.contains("SYS_Ball"))
        {
            c.add("SYS_Ball");
        }
        if (!c.contains("SYS_Laser"))
        {
            c.add("SYS_Laser");
        }
        if (!c.contains("SYS_Sword"))
        {
            c.add("SYS_Sword");
        }
    }

    public GifNetMaterial a(String s)
    {
        GifNetMaterial gifnetmaterial;
        Object obj;
        gifnetmaterial = null;
        obj = null;
        if (!s.startsWith("NET_")) goto _L2; else goto _L1
_L1:
        String s1 = (new StringBuilder()).append(b).append(s).append(".json").toString();
        if ((new File(s1)).exists()) goto _L4; else goto _L3
_L3:
        gifnetmaterial = obj;
_L6:
        return gifnetmaterial;
_L4:
        gifnetmaterial = new GifNetMaterial();
        gifnetmaterial.Load(s1);
_L2:
        if (s.startsWith("SYS_"))
        {
            s = (new StringBuilder()).append("material/").append(s).append(".json").toString();
            s = a.getAssets().open(s);
            GifNetMaterial gifnetmaterial1 = new GifNetMaterial();
            gifnetmaterial1.Load(s);
            return gifnetmaterial1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final List a()
    {
        int i = 0;
        c = null;
        c = new LinkedList();
        d = a.getSharedPreferences("com.wantu.android.WantuSetting", 0);
        Object obj = d.getString("com.wantu.gif.material.library", null);
        if (obj == null)
        {
            c();
            return c;
        }
        for (String as[] = ((String) (obj)).split(";"); i < as.length; i++)
        {
            c.add(as[i]);
        }

        c();
        as = c.iterator();
        do
        {
            if (!as.hasNext())
            {
                break;
            }
            String s = (String)as.next();
            if (s.startsWith("NET_") && !(new File((new StringBuilder()).append(b).append(s).append(".json").toString())).exists())
            {
                as.remove();
            }
        } while (true);
        return c;
    }

    public byte[] a(GifNetMaterial gifnetmaterial)
    {
        byte abyte0[] = null;
        if (gifnetmaterial.getId().startsWith("NET_"))
        {
            abyte0 = boz.a(gifnetmaterial.getLocalIconUrl());
        }
        if (gifnetmaterial.getId().startsWith("SYS_"))
        {
            gifnetmaterial = gifnetmaterial.getLocalIconUrl();
            abyte0 = boz.a(a.getAssets().open(gifnetmaterial));
        }
        return abyte0;
    }

    public boolean c(String s)
    {
        a();
        return c.contains(s);
    }
}
