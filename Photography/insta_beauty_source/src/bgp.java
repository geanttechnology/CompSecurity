// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.wantu.ResourceOnlineLibrary.CGBlendMode;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.model.res.EResType;
import com.wantu.piprender.renderengine.filters.BlendMode;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class bgp extends bgl
{

    public bgp()
    {
    }

    protected EOnlineResType b()
    {
        return EOnlineResType.LIGHT_FILTER;
    }

    protected List b(bib bib1)
    {
        Object obj;
        Object obj1;
        bib1 = bib1.a();
        obj = (TImageFilterInfo)b;
        obj1 = obj;
        if (bib1 == null) goto _L2; else goto _L1
_L1:
        NodeList nodelist;
        int i;
        nodelist = bib1.getChildNodes();
        bib1 = ((bib) (obj));
        if (obj == null)
        {
            bib1 = new TImageFilterInfo();
            bib1.setResType(EResType.NETWORK);
            b = bib1;
        }
        i = 0;
_L10:
        int k;
        obj1 = bib1;
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
                        bib1.filterName = ((String) (obj2)).trim();
                        bib1.name = ((String) (obj2));
                    } else
                    if ("icon".equalsIgnoreCase(((String) (obj1))))
                    {
                        bib1.icon = ((String) (obj2)).trim();
                        bib1.filterIconName = ((String) (obj2));
                        bib1.frameIconUrl = ((String) (obj2));
                    }
                    j++;
                }
            }
            break MISSING_BLOCK_LABEL_531;
        }
        if (!"dependences".equals(nodelist.item(i).getNodeName()))
        {
            break MISSING_BLOCK_LABEL_531;
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
        s = ((String) (obj4)).trim();
        bib1.frameUrl = s;
        ((List) (obj)).add(s);
_L8:
        l++;
        if (true) goto _L6; else goto _L5
_L5:
        if (!"size".equalsIgnoreCase(s)) goto _L8; else goto _L7
_L7:
        g = Integer.parseInt(((String) (obj4)).trim()) + g;
          goto _L8
        k++;
          goto _L9
_L4:
        ((List) (obj)).add(((TImageFilterInfo) (bib1)).icon);
        bib1.dependentResources = ((List) (obj));
        i++;
        if (true) goto _L10; else goto _L2
_L2:
        return ((TImageFilterInfo) (obj1)).dependentResources;
    }

    protected Object c(bib bib1)
    {
        TImageFilterInfo timagefilterinfo = (TImageFilterInfo)b;
        if (timagefilterinfo != null) goto _L2; else goto _L1
_L1:
        bib1 = null;
_L4:
        return bib1;
_L2:
        Object obj;
        obj = bib1.a();
        bib1 = timagefilterinfo;
        if (obj == null) goto _L4; else goto _L3
_L3:
        int i;
        obj = ((Element) (obj)).getChildNodes();
        i = 0;
_L13:
        bib1 = timagefilterinfo;
        if (i >= ((NodeList) (obj)).getLength()) goto _L4; else goto _L5
_L5:
        int j;
        if (!"processes".equals(((NodeList) (obj)).item(i).getNodeName()))
        {
            break MISSING_BLOCK_LABEL_362;
        }
        bib1 = ((NodeList) (obj)).item(i).getChildNodes();
        j = 0;
_L12:
        if (j >= bib1.getLength()) goto _L7; else goto _L6
_L6:
        NamedNodeMap namednodemap;
        int k;
        namednodemap = bib1.item(j).getAttributes();
        if (namednodemap.getNamedItem("blendMode") == null && namednodemap.getNamedItem("alpha") == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        k = 0;
_L9:
        String s;
        Object obj1;
        if (k >= namednodemap.getLength())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = namednodemap.item(k);
        s = ((Node) (obj1)).getNodeName();
        obj1 = ((Node) (obj1)).getNodeValue();
        Log.v(this.i, (new StringBuilder()).append("TLightDownloadAssient  nodeName: ").append(s).toString());
        Log.v(this.i, (new StringBuilder()).append("TLightDownloadAssient  nodeValue: ").append(((String) (obj1))).toString());
        if (!"blendMode".equalsIgnoreCase(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((String) (obj1)).trim();
        Log.v("blendMode", s);
        if (Integer.parseInt(s) < CGBlendMode.values().length)
        {
            timagefilterinfo.BlendMode = bgn.a(CGBlendMode.values()[Integer.parseInt(s)]).ordinal();
        }
_L11:
        k++;
        if (true) goto _L9; else goto _L8
_L8:
        if (!"alpha".equalsIgnoreCase(s)) goto _L11; else goto _L10
_L10:
        Log.v(this.i, (new StringBuilder()).append("TLightDownloadAssient ").append(((String) (obj1))).toString());
        timagefilterinfo.opacity = Float.parseFloat(((String) (obj1)));
          goto _L11
        j++;
          goto _L12
_L7:
        i++;
          goto _L13
    }
}
