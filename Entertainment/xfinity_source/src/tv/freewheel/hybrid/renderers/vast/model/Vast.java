// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.ad.interfaces.IAdInstance;
import tv.freewheel.hybrid.ad.interfaces.ISlot;
import tv.freewheel.hybrid.renderers.interfaces.IRendererContext;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.XMLHandler;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            Companion, InLine, Wrapper

public class Vast
{

    private static Logger logger = Logger.getLogger("Vast");
    private IRendererContext context;
    public int errorCode;
    public String errorMessage;
    public InLine inLine;
    public Wrapper wrapper;

    public Vast(IRendererContext irenderercontext)
    {
        context = irenderercontext;
    }

    public static Companion match(ArrayList arraylist, ISlot islot)
    {
        if (arraylist == null || arraylist.size() == 0 || islot == null)
        {
            return null;
        }
        Companion companion = null;
        int j = 0x7fffffff;
        int l = 0x7fffffff;
        int i = 0;
        do
        {
            Companion companion1;
label0:
            {
                companion1 = companion;
                if (i < arraylist.size())
                {
                    companion1 = (Companion)arraylist.get(i);
                    if (islot.getWidth() != companion1.width.intValue() || islot.getHeight() != companion1.height.intValue())
                    {
                        break label0;
                    }
                }
                logger.debug(String.format("Match result:slot(customId=%s:width=%d,height=%d) with companion rendition (ID=%s:width=%d,height=%d)", new Object[] {
                    islot.getCustomId(), Integer.valueOf(islot.getWidth()), Integer.valueOf(islot.getHeight()), companion1.id, companion1.width, companion1.height
                }));
                return companion1;
            }
            int k1 = islot.getWidth() - companion1.width.intValue();
            int j1 = islot.getHeight() - companion1.height.intValue();
            int i1 = l;
            int k = j;
            Companion companion2 = companion;
            if (j > k1)
            {
                i1 = l;
                k = j;
                companion2 = companion;
                if (l > j1)
                {
                    k = k1;
                    i1 = j1;
                    companion2 = companion1;
                }
            }
            i++;
            l = i1;
            j = k;
            companion = companion2;
        } while (true);
    }

    private boolean parseAdNode(Element element)
    {
        element = element.getChildNodes();
        boolean flag1 = true;
        int i = 0;
        while (i < element.getLength()) 
        {
            Node node = element.item(i);
            boolean flag = flag1;
            if (node.getNodeType() == 1)
            {
                if (node.getNodeName().equals("InLine"))
                {
                    inLine = new InLine();
                    inLine.parse((Element)node);
                    if (inLine.isValid(context.getAdInstance().getSlot(), context.getConstants()))
                    {
                        flag = false;
                    } else
                    {
                        inLine = null;
                        flag = flag1;
                    }
                } else
                {
                    flag = flag1;
                    if (node.getNodeName().equals("Wrapper"))
                    {
                        wrapper = new Wrapper();
                        wrapper.parse((Element)node);
                        if (wrapper.isValid(context.getAdInstance().getSlot(), context.getConstants()))
                        {
                            flag = false;
                        } else
                        {
                            wrapper = null;
                            flag = flag1;
                        }
                    }
                }
            }
            i++;
            flag1 = flag;
        }
        if (flag1)
        {
            logger.debug("Found an invalid Ad without valid InLine and Wrapper element, try next ad...");
        }
        return !flag1;
    }

    public ArrayList getCompanionRenditions(ISlot islot)
    {
        if (wrapper != null)
        {
            return wrapper.searchInCompanionSlot(islot, context.getConstants());
        }
        if (inLine != null)
        {
            return inLine.searchInCompanionSlot(islot, context.getConstants());
        } else
        {
            return new ArrayList();
        }
    }

    public ArrayList getRenditionsInDrivingSlot()
    {
        if (wrapper != null)
        {
            return wrapper.searchInDrivingSlot(context.getAdInstance().getSlot(), context.getConstants());
        }
        if (inLine != null)
        {
            return inLine.searchInDrivingSlot(context.getAdInstance().getSlot(), context.getConstants());
        } else
        {
            return new ArrayList();
        }
    }

    public boolean parse(String s)
    {
        boolean flag = false;
        s = XMLHandler.getXMLElementFromString(s, "VAST");
        if (!s.getAttribute("version").equals("2.0")) goto _L2; else goto _L1
_L1:
        s = s.getChildNodes();
        int i = 0;
_L12:
        boolean flag1 = flag;
        if (i >= s.getLength()) goto _L4; else goto _L3
_L3:
        Node node = s.item(i);
        flag1 = flag;
        if (node.getNodeType() != 1) goto _L6; else goto _L5
_L5:
        flag1 = flag;
        if (!node.getNodeName().equals("Ad")) goto _L6; else goto _L7
_L7:
        flag = parseAdNode((Element)node);
        flag1 = flag;
        if (!flag) goto _L6; else goto _L8
_L8:
        errorCode = -1;
        errorMessage = "";
        flag1 = flag;
_L4:
        flag = flag1;
        if (flag1) goto _L10; else goto _L9
_L9:
        errorCode = 2;
        errorMessage = "Error validating VAST document: no Ad node found!";
        logger.error(errorMessage);
        return flag1;
_L2:
        errorCode = 1;
        errorMessage = "Only VAST 2.0 is supported.";
        logger.error(errorMessage);
        return false;
        s;
        errorCode = 0;
        errorMessage = (new StringBuilder()).append("Error parsing VAST document: ").append(s.toString()).toString();
        logger.error(errorMessage);
        s.printStackTrace();
        flag = false;
_L10:
        return flag;
_L6:
        i++;
        flag = flag1;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public String toString()
    {
        return String.format("[Ad\n\tInLine=%s\n\tWrapper=%s\n]", new Object[] {
            inLine, wrapper
        });
    }

}
