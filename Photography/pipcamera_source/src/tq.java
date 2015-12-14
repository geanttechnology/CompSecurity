// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.model.res.EResType;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class tq extends tp
{

    public tq()
    {
    }

    protected EOnlineResType b()
    {
        return EOnlineResType.FILTER_FRAME;
    }

    protected ArrayList b(uy uy1)
    {
        Object obj;
        Object obj1;
        uy1 = uy1.a();
        obj = (TImageFilterInfo)b;
        obj1 = obj;
        if (uy1 == null) goto _L2; else goto _L1
_L1:
        NodeList nodelist;
        int i;
        nodelist = uy1.getChildNodes();
        uy1 = ((uy) (obj));
        if (obj == null)
        {
            uy1 = new TImageFilterInfo();
            uy1.setResType(EResType.NETWORK);
            b = uy1;
        }
        i = 0;
_L10:
        int k;
        obj1 = uy1;
        if (i >= nodelist.getLength())
        {
            break; /* Loop/switch isn't completed */
        }
        if ("filter".equals(nodelist.item(i).getNodeName()))
        {
            obj = nodelist.item(i);
            if (((Node) (obj)).hasAttributes())
            {
                obj = ((Node) (obj)).getAttributes();
                Log.v("childNodes Attributes getLength() ", String.format("%d", new Object[] {
                    Integer.valueOf(((NamedNodeMap) (obj)).getLength())
                }));
                int j = 0;
                while (j < ((NamedNodeMap) (obj)).getLength()) 
                {
                    Object obj2 = ((NamedNodeMap) (obj)).item(j);
                    obj1 = ((Node) (obj2)).getNodeName();
                    obj2 = ((Node) (obj2)).getNodeValue();
                    if ("name".equalsIgnoreCase(((String) (obj1))))
                    {
                        uy1.filterName = ((String) (obj2));
                        uy1.name = ((String) (obj2));
                    } else
                    if ("icon".equalsIgnoreCase(((String) (obj1))))
                    {
                        uy1.icon = ((String) (obj2));
                        uy1.filterIconName = ((String) (obj2));
                    }
                    j++;
                }
            }
            break MISSING_BLOCK_LABEL_499;
        }
        if (!"dependences".equals(nodelist.item(i).getNodeName()))
        {
            break MISSING_BLOCK_LABEL_499;
        }
        obj1 = nodelist.item(i);
        obj = new ArrayList();
        obj1 = ((Node) (obj1)).getChildNodes();
        k = 0;
_L9:
        if (k >= ((NodeList) (obj1)).getLength()) goto _L4; else goto _L3
_L3:
        Object obj3;
        int l;
        if (!"res".equals(((NodeList) (obj1)).item(k).getNodeName()))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = ((NodeList) (obj1)).item(k);
        if (!((Node) (obj3)).hasAttributes())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = ((Node) (obj3)).getAttributes();
        Log.v("resNode Attributes getLength() ", String.format("%d", new Object[] {
            Integer.valueOf(((NamedNodeMap) (obj3)).getLength())
        }));
        l = 0;
_L6:
        String s;
        Object obj4;
        if (l >= ((NamedNodeMap) (obj3)).getLength())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj4 = ((NamedNodeMap) (obj3)).item(l);
        s = ((Node) (obj4)).getNodeName();
        obj4 = ((Node) (obj4)).getNodeValue();
        if (!"url".equalsIgnoreCase(s))
        {
            break; /* Loop/switch isn't completed */
        }
        ((ArrayList) (obj)).add(obj4);
_L8:
        l++;
        if (true) goto _L6; else goto _L5
_L5:
        if (!"size".equalsIgnoreCase(s)) goto _L8; else goto _L7
_L7:
        g = Integer.parseInt(((String) (obj4))) + g;
          goto _L8
        k++;
          goto _L9
_L4:
        ((ArrayList) (obj)).add(((TImageFilterInfo) (uy1)).icon);
        uy1.dependentResources = ((ArrayList) (obj));
        i++;
        if (true) goto _L10; else goto _L2
_L2:
        return ((TImageFilterInfo) (obj1)).dependentResources;
    }

    protected Object c(uy uy1)
    {
        TImageFilterInfo timagefilterinfo = (TImageFilterInfo)b;
        if (timagefilterinfo != null) goto _L2; else goto _L1
_L1:
        uy1 = null;
_L4:
        return uy1;
_L2:
        Object obj = uy1.a();
        uy1 = timagefilterinfo;
        if (obj == null)
        {
            continue;
        }
        obj = ((Element) (obj)).getChildNodes();
        int i = 0;
        do
        {
            uy1 = timagefilterinfo;
            if (i >= ((NodeList) (obj)).getLength())
            {
                continue;
            }
            if ("Frames".equals(((NodeList) (obj)).item(i).getNodeName()))
            {
                uy1 = ((NodeList) (obj)).item(i);
                if (uy1.hasAttributes())
                {
                    uy1 = uy1.getAttributes();
                    Log.v("childNodes Attributes getLength() ", String.format("%d", new Object[] {
                        Integer.valueOf(uy1.getLength())
                    }));
                    int j = 0;
                    while (j < uy1.getLength()) 
                    {
                        Object obj1 = uy1.item(j);
                        String s = ((Node) (obj1)).getNodeName();
                        obj1 = ((Node) (obj1)).getNodeValue();
                        if ("url".equalsIgnoreCase(s))
                        {
                            timagefilterinfo.frameUrl = ((String) (obj1));
                        } else
                        if ("iconurl".equalsIgnoreCase(s))
                        {
                            timagefilterinfo.icon = ((String) (obj1));
                            timagefilterinfo.frameIconUrl = ((String) (obj1));
                        }
                        j++;
                    }
                }
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
