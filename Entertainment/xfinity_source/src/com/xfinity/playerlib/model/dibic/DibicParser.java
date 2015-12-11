// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.xfinity.playerlib.model.etc.DibicProgramFactory;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.apache.commons.io.input.SwappedDataInputStream;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicProgram, DibicDictionary

public class DibicParser
{

    public DibicParser()
    {
    }

    protected SwappedDataInputStream createProgramStreamFromBuffer(byte abyte0[])
        throws IOException
    {
        return new SwappedDataInputStream(new ByteArrayInputStream(abyte0));
    }

    public List getPrograms(SwappedDataInputStream swappeddatainputstream, DibicProgramFactory dibicprogramfactory, TagsRoot tagsroot)
    {
        Object obj;
        Object obj1;
        String as[];
        Object obj2;
        byte abyte0[];
        Iterator iterator;
        DibicProgram dibicprogram;
        int i;
        int j;
        try
        {
            j = swappeddatainputstream.readInt();
            obj2 = new LinkedHashMap();
            abyte0 = new byte[swappeddatainputstream.readInt()];
        }
        // Misplaced declaration of an exception variable
        catch (SwappedDataInputStream swappeddatainputstream)
        {
            throw new CimIOException(swappeddatainputstream);
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        dibicprogram = dibicprogramfactory.create();
        swappeddatainputstream.read(abyte0);
        dibicprogram.parse(createProgramStreamFromBuffer(abyte0));
        obj1 = (Set)((LinkedHashMap) (obj2)).get(dibicprogram.getMerlinId());
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        obj = new HashSet();
        ((Set) (obj)).add(dibicprogram);
        ((LinkedHashMap) (obj2)).put(dibicprogram.getMerlinId(), obj);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_26;
_L1:
        j = swappeddatainputstream.readInt();
        dibicprogramfactory = new int[j];
        i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        dibicprogramfactory[i] = swappeddatainputstream.readInt();
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        j = swappeddatainputstream.readInt();
        as = new String[j];
        swappeddatainputstream.readInt();
        swappeddatainputstream = (new Scanner(swappeddatainputstream, "UTF-8")).useDelimiter("\0");
        i = 0;
_L6:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!swappeddatainputstream.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        as[i] = swappeddatainputstream.next();
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        obj = new ArrayList();
        as = new DibicDictionary(dibicprogramfactory, as);
        obj2 = ((LinkedHashMap) (obj2)).values().iterator();
_L11:
        if (!((Iterator) (obj2)).hasNext())
        {
            break MISSING_BLOCK_LABEL_382;
        }
        dibicprogramfactory = (Set)((Iterator) (obj2)).next();
        swappeddatainputstream = null;
        iterator = dibicprogramfactory.iterator();
_L9:
        if (!iterator.hasNext()) goto _L8; else goto _L7
_L7:
        dibicprogramfactory = (DibicProgram)iterator.next();
        dibicprogramfactory.setDictionary(as);
        dibicprogramfactory.setTagsRoot(tagsroot);
        if (isProgramValid(dibicprogramfactory))
        {
label0:
            {
                if (swappeddatainputstream != null)
                {
                    break label0;
                }
                swappeddatainputstream = dibicprogramfactory;
            }
        }
          goto _L9
        swappeddatainputstream.merge(dibicprogramfactory);
          goto _L9
_L8:
        if (swappeddatainputstream == null) goto _L11; else goto _L10
_L10:
        swappeddatainputstream.populateStrings();
        ((List) (obj)).add(swappeddatainputstream);
          goto _L11
        return ((List) (obj));
    }

    protected boolean isProgramValid(DibicProgram dibicprogram)
    {
        return true;
    }
}
