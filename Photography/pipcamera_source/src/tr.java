// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.imagelib.filter.TImageFilterInfo;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class tr extends to
{

    public tr()
    {
    }

    protected String a(Object obj)
    {
        Object obj1 = (TImageFilterInfo)obj;
        obj = uc.a;
        try
        {
            obj1 = String.format("%s?name=%s&ver=%s", new Object[] {
                uc.a, ((TImageFilterInfo) (obj1)).filterName, PIPCameraApplication.a.getPackageManager().getPackageInfo("com.wantu.activity", 0).versionName
            });
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            Crashlytics.logException(namenotfoundexception);
            return ((String) (obj));
        }
        return ((String) (obj1));
    }

    protected String a(ArrayList arraylist)
    {
        Object obj = new StringBuilder();
        int i = 0;
        while (i < arraylist.size()) 
        {
            String s = ((TImageFilterInfo)arraylist.get(i)).filterName;
            if (s.compareToIgnoreCase(PIPCameraApplication.a.getString(0x7f060181)) != 0)
            {
                if (((StringBuilder) (obj)).length() != 0)
                {
                    ((StringBuilder) (obj)).append(",");
                } else
                {
                    ((StringBuilder) (obj)).append("?filters=");
                }
                ((StringBuilder) (obj)).append(s);
            }
            i++;
        }
        arraylist = uc.a;
        try
        {
            obj = String.format("%s%s&vert=%s", new Object[] {
                uc.a, ((StringBuilder) (obj)).toString(), PIPCameraApplication.a.getPackageManager().getPackageInfo("com.wantu.activity", 0).versionName
            });
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            Crashlytics.logException(namenotfoundexception);
            return arraylist;
        }
        return ((String) (obj));
    }

    protected ArrayList a(InputStream inputstream)
    {
        ArrayList arraylist = new ArrayList();
        uy uy1 = new uy();
        try
        {
            uy1.a(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        inputstream = uy1.a();
        if (inputstream == null)
        {
            return arraylist;
        }
        Log.v("xml parse success", "xml parse success");
        inputstream = inputstream.getElementsByTagName("filters");
        Log.v("filterNodes length", String.format("%d", new Object[] {
            Integer.valueOf(inputstream.getLength())
        }));
        int i = 0;
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
                if (nodelist.item(j).getNodeType() != 1 || !"filter".equalsIgnoreCase(nodelist.item(j).getNodeName()))
                {
                    continue;
                }
                TImageFilterInfo timagefilterinfo = new TImageFilterInfo();
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
                            timagefilterinfo.filterName = ((String) (obj1));
                            timagefilterinfo.name = ((String) (obj1));
                        } else
                        if ("icon".equalsIgnoreCase(s))
                        {
                            timagefilterinfo.icon = ((String) (obj1));
                            timagefilterinfo.filterIconName = ((String) (obj1));
                        } else
                        if ("vip".equalsIgnoreCase(s))
                        {
                            timagefilterinfo.isVip = Boolean.valueOf(Boolean.parseBoolean(((String) (obj1))));
                        }
                        k++;
                    }
                }
                arraylist.add(timagefilterinfo);
                Log.v("info.name:", timagefilterinfo.filterName);
            }

            i++;
        } while (true);
        return arraylist;
    }

    protected tp a()
    {
        return new tq();
    }

    protected int b(InputStream inputstream)
    {
        uy uy1 = new uy();
        int i;
        int j;
        try
        {
            uy1.a(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        inputstream = uy1.a().getElementsByTagName("filters");
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
                    if ("filter".equalsIgnoreCase(nodelist.item(k).getNodeName()))
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
