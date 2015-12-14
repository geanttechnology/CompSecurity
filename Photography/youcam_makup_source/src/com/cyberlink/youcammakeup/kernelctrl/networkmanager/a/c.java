// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;

import com.cyberlink.youcammakeup.database.more.l.a;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.unzipped.b;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bl;
import com.cyberlink.youcammakeup.utility.bo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a:
//            b, e

public class c
    implements com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.b
{

    private long a;

    public c(long l)
    {
        a = l;
    }

    public void a(NetworkManager networkmanager, e e1)
    {
        long l = e1.l();
        e1 = new ArrayList(1);
        e1.add(Long.valueOf(l));
        (new bl(networkmanager, e1)).a();
    }

    public void a(File file, e e1)
    {
        bo.a((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).toString(), "makeup_template.xml", com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b);
        e1 = (MakeupItemMetadata)e1;
        file = new b(file.getAbsoluteFile(), 0);
        CategoryType categorytype = CategoryType.a(a);
        long l = (new Date()).getTime();
        file = new a(e1.a(), e1.m(), l, file, categorytype, e1.h(), e1.i(), false);
        h.c().a(file);
    }

    public void b(File file, e e1)
    {
        if (e1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        JSONObject jsonobject;
        jsonobject = ((MakeupItemMetadata)e1).v();
        e1 = null;
        obj = null;
        BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter((new StringBuilder()).append(file).append(File.separator).append("makeup_metadata.json").toString()));
        bufferedwriter.write(jsonobject.toString(), 0, jsonobject.toString().length());
        bufferedwriter.close();
        file = new BufferedWriter(new FileWriter((new StringBuilder()).append(file).append(File.separator).append("makeup_category_id").toString()));
        obj = file;
        e1 = file;
        file.write(Long.toString(a), 0, Long.toString(a).length());
        if (file != null)
        {
            try
            {
                file.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                file.printStackTrace();
            }
            return;
        }
          goto _L1
        file;
_L6:
        e1 = ((e) (obj));
        file.printStackTrace();
        if (obj == null) goto _L1; else goto _L3
_L3:
        try
        {
            ((BufferedWriter) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file.printStackTrace();
        }
        return;
        file;
_L5:
        if (e1 != null)
        {
            try
            {
                e1.close();
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                e1.printStackTrace();
            }
        }
        throw file;
        file;
        e1 = bufferedwriter;
        if (true) goto _L5; else goto _L4
_L4:
        file;
        obj = bufferedwriter;
          goto _L6
    }
}
