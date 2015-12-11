// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class TextSearch extends MobileFunnelEvent
{

    public String extraInfo;
    public String searchString;
    public int sequence;
    public String suggestions;

    public TextSearch()
    {
        searchString = "";
        suggestions = "";
        extraInfo = "";
        eventType = "GRP34";
    }

    public TextSearch(String s, String s1, String s2, int i, EncodedNSTField encodednstfield)
    {
        super("GRP34", s);
        searchString = "";
        suggestions = "";
        extraInfo = "";
        searchString = s1;
        suggestions = s2;
        sequence = i;
        if (encodednstfield != null)
        {
            extraInfo = encodednstfield.toEncodedString();
        }
    }

    public void pack(int i, Packer packer)
        throws IOException
    {
        int j = i;
        if (i == -1)
        {
            j = 10;
        }
        super.pack(j, packer);
        packer.pack(searchString);
        packer.pack(suggestions);
        packer.pack(sequence);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        searchString = "";
        suggestions = "";
        sequence = 0;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("TextSearch")).append("[").append(searchString).append(",").append(suggestions).append(",").append(sequence).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
