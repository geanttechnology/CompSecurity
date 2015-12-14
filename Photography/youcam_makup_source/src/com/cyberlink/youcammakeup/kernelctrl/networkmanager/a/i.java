// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;

import com.cyberlink.youcammakeup.database.more.l.a;
import com.cyberlink.youcammakeup.database.more.l.b;
import com.cyberlink.youcammakeup.database.more.l.c;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.CollageType;
import com.cyberlink.youcammakeup.database.more.unzipped.UnzippedCollageClassicMetadata;
import com.cyberlink.youcammakeup.database.more.unzipped.UnzippedCollageModernMetadata;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a:
//            b, e

public class i
    implements com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.b
{

    public i()
    {
    }

    private com.cyberlink.youcammakeup.database.more.unzipped.c a(File file, CategoryType categorytype, CollageType collagetype)
    {
        String s;
        file.getAbsolutePath();
        categorytype = new File(file, "content");
        if (categorytype.isDirectory())
        {
            s = categorytype.getAbsolutePath();
            file = categorytype;
        } else
        {
            s = file.getAbsolutePath();
        }
        if (collagetype == CollageType.a || collagetype == CollageType.b) goto _L2; else goto _L1
_L1:
        file = null;
_L4:
        return file;
_L2:
        if (collagetype == CollageType.a)
        {
            categorytype = "collage_classic.json";
        } else
        {
            categorytype = "collage_modern.json";
        }
        categorytype = new BufferedReader(new FileReader(new File(file, categorytype)));
        file = categorytype.readLine();
        if (file == null)
        {
            int j;
            if (categorytype != null)
            {
                try
                {
                    categorytype.close();
                }
                // Misplaced declaration of an exception variable
                catch (File file) { }
            }
            return null;
        }
        j = ((JSONObject)(new JSONTokener(file)).nextValue()).getInt("source_amount");
        if (collagetype != CollageType.a)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        collagetype = new UnzippedCollageClassicMetadata(s, 0, j);
        file = collagetype;
        if (categorytype != null)
        {
            try
            {
                categorytype.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return collagetype;
            }
            return collagetype;
        }
        continue; /* Loop/switch isn't completed */
        collagetype = new UnzippedCollageModernMetadata(s, 0, j);
        file = collagetype;
        if (categorytype != null)
        {
            try
            {
                categorytype.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return collagetype;
            }
            return collagetype;
        }
        if (true) goto _L4; else goto _L3
_L3:
        file;
        file = null;
_L8:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        return null;
        file;
        categorytype = null;
_L6:
        if (categorytype != null)
        {
            try
            {
                categorytype.close();
            }
            // Misplaced declaration of an exception variable
            catch (CategoryType categorytype) { }
        }
        throw file;
        file;
        if (true) goto _L6; else goto _L5
_L5:
        file;
        file = categorytype;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void a(NetworkManager networkmanager, e e1)
    {
        long l = e1.l();
        e1 = new ArrayList(1);
        e1.add(Long.valueOf(l));
        (new bk(networkmanager, e1)).a();
    }

    public void a(File file, e e1)
    {
        c c1 = (c)e1;
        CategoryType categorytype = c1.b();
        CollageType collagetype = c1.e();
        long l = c1.a();
        String s = c1.m();
        long l1 = (new Date()).getTime();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(c1.c());
        Calendar calendar = (Calendar)calendar1.clone();
        calendar1.setTime(c1.d());
        calendar1 = (Calendar)calendar1.clone();
        if (e1.o().toString().equalsIgnoreCase("http://d2pfpk6p9jh6lc.cloudfront.net/store/collages/MSR/PFA150826-0005_5F/f9a1c06e-6bfd-4554-8c01-c94dc121522c.zip"))
        {
            e1.o();
        }
        file = new a(l, s, l1, a(file, categorytype, collagetype), categorytype, calendar, calendar1, c1.f());
        e1 = h.c();
        if (e1.b(file.a()) != null)
        {
            e1.c(file.a());
        }
        e1.a(file);
    }

    public void b(File file, e e1)
    {
    }
}
