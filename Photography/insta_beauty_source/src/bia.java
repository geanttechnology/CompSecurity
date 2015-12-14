// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.wantu.model.res.TFrameItemInfo;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class bia extends bgf
{

    public bia()
    {
    }

    protected bgj a()
    {
        return new bhz();
    }

    protected String a(Object obj)
    {
        obj = (TFrameItemInfo)obj;
        String s = bgx.a();
        return String.format("%s&type=%s&name=%s&%s", new Object[] {
            bgx.m, bgv.getStringByResType(d.b), ((TFrameItemInfo) (obj)).name, s
        });
    }

    protected String a(ArrayList arraylist)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s = bgx.a();
        int i = 0;
        while (i < arraylist.size()) 
        {
            String s1 = ((TFrameItemInfo)arraylist.get(i)).name;
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append(",");
            } else
            {
                stringbuilder.append("&existNames=");
            }
            stringbuilder.append(s1);
            i++;
        }
        return String.format("%s&type=%s&materialtype=%s&%s%s", new Object[] {
            bgx.l, bgv.getStringByResType(d.b), d.a, s, stringbuilder.toString()
        });
    }

    protected ArrayList a(InputStream inputstream)
    {
        ArrayList arraylist = new ArrayList();
        bib bib1 = new bib();
        int i;
        try
        {
            bib1.a(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        inputstream = bib1.a();
        Log.v("xml parse success", "xml parse success");
        inputstream = inputstream.getElementsByTagName("images");
        Log.v("filterNodes length", String.format("%d", new Object[] {
            Integer.valueOf(inputstream.getLength())
        }));
        i = 0;
        do
        {
            if (i >= inputstream.getLength())
            {
                break;
            }
            NodeList nodelist = ((Element)inputstream.item(i)).getChildNodes();
            Log.v("childNodes", String.format("%d", new Object[] {
                Integer.valueOf(nodelist.getLength())
            }));
            for (int j = 0; j < nodelist.getLength(); j++)
            {
                if (nodelist.item(j).getNodeType() != 1 || !"image".equalsIgnoreCase(nodelist.item(j).getNodeName()))
                {
                    continue;
                }
                TFrameItemInfo tframeiteminfo = new TFrameItemInfo();
                Object obj = nodelist.item(j);
                if (((Node) (obj)).hasAttributes())
                {
                    obj = ((Node) (obj)).getAttributes();
                    Log.v("childNodes Attributes getLength() ", String.format("%d", new Object[] {
                        Integer.valueOf(((NamedNodeMap) (obj)).getLength())
                    }));
                    int k = 0;
                    while (k < ((NamedNodeMap) (obj)).getLength()) 
                    {
                        Object obj1 = ((NamedNodeMap) (obj)).item(k);
                        String s = ((Node) (obj1)).getNodeName();
                        obj1 = ((Node) (obj1)).getNodeValue();
                        if ("name".equalsIgnoreCase(s))
                        {
                            tframeiteminfo.name = ((String) (obj1));
                        } else
                        if ("icon".equalsIgnoreCase(s))
                        {
                            tframeiteminfo.icon = ((String) (obj1));
                        } else
                        if ("vip".equalsIgnoreCase(s))
                        {
                            tframeiteminfo.isVip = Boolean.valueOf(Boolean.parseBoolean(((String) (obj1))));
                        } else
                        if ("ID".equalsIgnoreCase(s))
                        {
                            tframeiteminfo.resId = Integer.valueOf(((String) (obj1))).intValue();
                        } else
                        if ("price".equalsIgnoreCase(s))
                        {
                            tframeiteminfo.price = Integer.valueOf(((String) (obj1))).intValue();
                        } else
                        if ("previewUrl".equalsIgnoreCase(s))
                        {
                            tframeiteminfo.previewUrl = ((String) (obj1));
                        }
                        k++;
                    }
                }
                arraylist.add(tframeiteminfo);
                Log.v("info.name:", tframeiteminfo.name);
            }

            i++;
        } while (true);
        return arraylist;
    }

    protected int b(InputStream inputstream)
    {
        bib bib1 = new bib();
        int i;
        int j;
        try
        {
            bib1.a(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        inputstream = bib1.a().getElementsByTagName("images");
        i = 0;
        j = 0;
        for (; i < inputstream.getLength(); i++)
        {
            NodeList nodelist = ((Element)inputstream.item(i)).getChildNodes();
            for (int k = 0; k < nodelist.getLength();)
            {
                int l = j;
                if (nodelist.item(k).getNodeType() == 1)
                {
                    l = j;
                    if ("image".equalsIgnoreCase(nodelist.item(k).getNodeName()))
                    {
                        l = j + 1;
                    }
                }
                k++;
                j = l;
            }

        }

        return j;
    }
}
