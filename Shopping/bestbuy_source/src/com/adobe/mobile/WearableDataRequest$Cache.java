// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import atz;
import com.google.android.gms.wearable.Asset;
import java.io.File;

// Referenced classes of package com.adobe.mobile:
//            WearableDataRequest, RemoteDownload

class fileName extends WearableDataRequest
{

    protected String fileName;
    protected String url;

    protected atz getDataMap()
    {
        atz atz1 = new atz();
        atz1.a("Type", "File");
        atz1.a("ID", uuid);
        atz1.a("URL", url);
        atz1.a("FileName", fileName);
        return atz1;
    }

    protected atz handle(Context context)
    {
        context = new atz();
        context.a("ID", uuid);
        context.a("Type", "File");
        context.a("URL", url);
        File file = RemoteDownload.getFileForCachedURL(url);
        if (file == null)
        {
            context.a("FileFound", false);
        } else
        {
            context.a("FileFound", true);
            if (file.getName().equals(fileName))
            {
                context.a("Updated", false);
                return context;
            }
            context.a("Updated", true);
            context.a("FileName", file.getName());
            byte abyte0[] = WearableDataRequest.access$000(file);
            if (abyte0 != null && abyte0.length > 0)
            {
                context.a("FileContent", Asset.a(abyte0));
                return context;
            }
        }
        return context;
    }

    protected (atz atz1)
    {
        uuid = atz1.f("ID");
        fileName = atz1.f("FileName");
        url = atz1.f("URL");
    }

    protected url(String s, String s1, int i)
    {
        super(i);
        url = s;
        fileName = s1;
    }
}
