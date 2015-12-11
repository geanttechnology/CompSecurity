// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

public class AppLink
{

    private Uri sourceUrl;
    private List targets;
    private Uri webUrl;

    public AppLink(Uri uri, List list, Uri uri1)
    {
        sourceUrl = uri;
        uri = list;
        if (list == null)
        {
            uri = Collections.emptyList();
        }
        targets = uri;
        webUrl = uri1;
    }

    public Uri getSourceUrl()
    {
        return sourceUrl;
    }

    public List getTargets()
    {
        return Collections.unmodifiableList(targets);
    }

    public Uri getWebUrl()
    {
        return webUrl;
    }
}
