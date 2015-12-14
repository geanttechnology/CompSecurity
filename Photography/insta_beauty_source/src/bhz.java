// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TFrameItemInfo;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class bhz extends bgj
{

    public bhz()
    {
    }

    protected EOnlineResType b()
    {
        return EOnlineResType.FILTER_FRAME;
    }

    protected List b(bib bib1)
    {
        ArrayList arraylist;
        NodeList nodelist;
        int i;
        bib1 = bib1.a();
        TFrameItemInfo tframeiteminfo = (TFrameItemInfo)b;
        arraylist = new ArrayList();
        if (bib1 == null)
        {
            break MISSING_BLOCK_LABEL_580;
        }
        nodelist = bib1.getChildNodes();
        bib1 = tframeiteminfo;
        if (tframeiteminfo == null)
        {
            bib1 = new TFrameItemInfo();
            bib1.setResType(EResType.NETWORK);
            b = bib1;
        }
        i = 0;
_L15:
        if (i >= nodelist.getLength()) goto _L2; else goto _L1
_L1:
        if (!"image".equals(nodelist.item(i).getNodeName())) goto _L4; else goto _L3
_L3:
        Object obj;
        int j;
        obj = nodelist.item(i);
        if (!((Node) (obj)).hasAttributes())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((Node) (obj)).getAttributes();
        Log.v("childNodes Attributes getLength() ", String.format("%d", new Object[] {
            Integer.valueOf(((NamedNodeMap) (obj)).getLength())
        }));
        j = 0;
_L6:
        Object obj1;
        Object obj2;
        if (j >= ((NamedNodeMap) (obj)).getLength())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = ((NamedNodeMap) (obj)).item(j);
        obj1 = ((Node) (obj2)).getNodeName();
        obj2 = ((Node) (obj2)).getNodeValue();
        if (!"name".equalsIgnoreCase(((String) (obj1))))
        {
            break; /* Loop/switch isn't completed */
        }
        bib1.name = ((String) (obj2));
_L7:
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        if ("icon".equalsIgnoreCase(((String) (obj1))))
        {
            bib1.icon = ((String) (obj2)).trim();
        } else
        if ("ID".equalsIgnoreCase(((String) (obj1))))
        {
            bib1.resId = Integer.valueOf(((String) (obj2))).intValue();
        } else
        if ("price".equalsIgnoreCase(((String) (obj1))))
        {
            bib1.price = Integer.valueOf(((String) (obj2))).intValue();
        } else
        if ("previewUrl".equalsIgnoreCase(((String) (obj1))))
        {
            bib1.previewUrl = ((String) (obj2));
        }
          goto _L7
        if (true) goto _L6; else goto _L4
_L4:
        if (!"dependences".equals(nodelist.item(i).getNodeName()))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = nodelist.item(i).getChildNodes();
        j = 0;
_L14:
        if (j >= ((NodeList) (obj)).getLength()) goto _L9; else goto _L8
_L8:
        int k;
        if (!"res".equals(((NodeList) (obj)).item(j).getNodeName()))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = ((NodeList) (obj)).item(j);
        if (!((Node) (obj1)).hasAttributes())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = ((Node) (obj1)).getAttributes();
        Log.v("resNode Attributes getLength() ", String.format("%d", new Object[] {
            Integer.valueOf(((NamedNodeMap) (obj1)).getLength())
        }));
        k = 0;
_L11:
        Object obj3;
        if (k >= ((NamedNodeMap) (obj1)).getLength())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = ((NamedNodeMap) (obj1)).item(k);
        obj2 = ((Node) (obj3)).getNodeName();
        obj3 = ((Node) (obj3)).getNodeValue();
        if (!"url".equalsIgnoreCase(((String) (obj2))))
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = ((String) (obj3)).trim();
        bib1.imageURL = ((String) (obj2));
        arraylist.add(obj2);
_L13:
        k++;
        if (true) goto _L11; else goto _L10
_L10:
        if (!"size".equalsIgnoreCase(((String) (obj2)))) goto _L13; else goto _L12
_L12:
        g = Integer.parseInt(((String) (obj3)).trim()) + g;
          goto _L13
        j++;
          goto _L14
_L9:
        arraylist.add(((TFrameItemInfo) (bib1)).icon);
        i++;
          goto _L15
_L2:
        return arraylist;
    }

    protected Object c(bib bib1)
    {
        return b;
    }
}
