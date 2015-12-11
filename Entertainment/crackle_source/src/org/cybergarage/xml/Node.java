// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.xml;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

// Referenced classes of package org.cybergarage.xml:
//            AttributeList, NodeList, Attribute, XML

public class Node
{

    private AttributeList attrList;
    private String name;
    private NodeList nodeList;
    private Node parentNode;
    private Object userData;
    private String value;

    public Node()
    {
        parentNode = null;
        name = new String();
        value = new String();
        attrList = new AttributeList();
        nodeList = new NodeList();
        userData = null;
        setUserData(null);
        setParentNode(null);
    }

    public Node(String s)
    {
        this();
        setName(s);
    }

    public Node(String s, String s1)
    {
        this();
        setName(s, s1);
    }

    public void addAttribute(String s, String s1)
    {
        addAttribute(new Attribute(s, s1));
    }

    public void addAttribute(Attribute attribute)
    {
        attrList.add(attribute);
    }

    public void addNode(Node node)
    {
        node.setParentNode(this);
        nodeList.add(node);
    }

    public void addValue(String s)
    {
        if (value == null)
        {
            value = s;
        } else
        if (s != null)
        {
            value = (new StringBuilder(String.valueOf(value))).append(s).toString();
            return;
        }
    }

    public Attribute getAttribute(int i)
    {
        return attrList.getAttribute(i);
    }

    public Attribute getAttribute(String s)
    {
        return attrList.getAttribute(s);
    }

    public int getAttributeIntegerValue(String s)
    {
        s = getAttributeValue(s);
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }

    public String getAttributeValue(String s)
    {
        s = getAttribute(s);
        if (s != null)
        {
            return s.getValue();
        } else
        {
            return "";
        }
    }

    public String getIndentLevelString(int i)
    {
        return getIndentLevelString(i, "   ");
    }

    public String getIndentLevelString(int i, String s)
    {
        StringBuffer stringbuffer = new StringBuffer(s.length() * i);
        int j = 0;
        do
        {
            if (j >= i)
            {
                return stringbuffer.toString();
            }
            stringbuffer.append(s);
            j++;
        } while (true);
    }

    public int getIndex(String s)
    {
        int i = -1;
        Iterator iterator = nodeList.iterator();
        int j;
        do
        {
            if (!iterator.hasNext())
            {
                return i;
            }
            j = i + 1;
            i = j;
        } while (!((Node)iterator.next()).getName().equals(s));
        return j;
    }

    public int getNAttributes()
    {
        return attrList.size();
    }

    public int getNNodes()
    {
        return nodeList.size();
    }

    public String getName()
    {
        return name;
    }

    public Node getNode(int i)
    {
        return nodeList.getNode(i);
    }

    public Node getNode(String s)
    {
        return nodeList.getNode(s);
    }

    public Node getNodeEndsWith(String s)
    {
        return nodeList.getEndsWith(s);
    }

    public String getNodeValue(String s)
    {
        s = getNode(s);
        if (s != null)
        {
            return s.getValue();
        } else
        {
            return "";
        }
    }

    public Node getParentNode()
    {
        return parentNode;
    }

    public Node getRootNode()
    {
        Node node1 = null;
        Node node = getParentNode();
        do
        {
            if (node == null)
            {
                return node1;
            }
            node1 = node;
            node = node1.getParentNode();
        } while (true);
    }

    public Object getUserData()
    {
        return userData;
    }

    public String getValue()
    {
        return value;
    }

    public boolean hasAttributes()
    {
        return getNAttributes() > 0;
    }

    public boolean hasNodes()
    {
        return getNNodes() > 0;
    }

    public void insertAttributeAt(Attribute attribute, int i)
    {
        attrList.insertElementAt(attribute, i);
    }

    public void insertNode(Node node, int i)
    {
        node.setParentNode(this);
        nodeList.insertElementAt(node, i);
    }

    public boolean isName(String s)
    {
        return name.equals(s);
    }

    public void output(PrintWriter printwriter, int i, boolean flag)
    {
        String s = getIndentLevelString(i);
        String s1 = getName();
        String s2 = getValue();
        if (!hasNodes() || !flag)
        {
            printwriter.print((new StringBuilder(String.valueOf(s))).append("<").append(s1).toString());
            outputAttributes(printwriter);
            if (s2 == null || s2.length() == 0)
            {
                printwriter.println((new StringBuilder("></")).append(s1).append(">").toString());
                return;
            } else
            {
                printwriter.println((new StringBuilder(">")).append(XML.escapeXMLChars(s2)).append("</").append(s1).append(">").toString());
                return;
            }
        }
        printwriter.print((new StringBuilder(String.valueOf(s))).append("<").append(s1).toString());
        outputAttributes(printwriter);
        printwriter.println(">");
        int k = getNNodes();
        int j = 0;
        do
        {
            if (j >= k)
            {
                printwriter.println((new StringBuilder(String.valueOf(s))).append("</").append(s1).append(">").toString());
                return;
            }
            getNode(j).output(printwriter, i + 1, true);
            j++;
        } while (true);
    }

    public void outputAttributes(PrintWriter printwriter)
    {
        int j = getNAttributes();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            Attribute attribute = getAttribute(i);
            printwriter.print((new StringBuilder(" ")).append(attribute.getName()).append("=\"").append(XML.escapeXMLChars(attribute.getValue())).append("\"").toString());
            i++;
        } while (true);
    }

    public void print()
    {
        print(true);
    }

    public void print(boolean flag)
    {
        PrintWriter printwriter = new PrintWriter(System.out);
        output(printwriter, 0, flag);
        printwriter.flush();
    }

    public void removeAllNodes()
    {
        nodeList.clear();
    }

    public boolean removeAttribute(String s)
    {
        return removeAttribute(getAttribute(s));
    }

    public boolean removeAttribute(Attribute attribute)
    {
        return attrList.remove(attribute);
    }

    public boolean removeNode(String s)
    {
        return nodeList.remove(getNode(s));
    }

    public boolean removeNode(Node node)
    {
        node.setParentNode(null);
        return nodeList.remove(node);
    }

    public void setAttribute(String s, int i)
    {
        setAttribute(s, Integer.toString(i));
    }

    public void setAttribute(String s, String s1)
    {
        Attribute attribute = getAttribute(s);
        if (attribute != null)
        {
            attribute.setValue(s1);
            return;
        } else
        {
            addAttribute(new Attribute(s, s1));
            return;
        }
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setName(String s, String s1)
    {
        name = (new StringBuilder(String.valueOf(s))).append(":").append(s1).toString();
    }

    public void setNameSpace(String s, String s1)
    {
        setAttribute((new StringBuilder("xmlns:")).append(s).toString(), s1);
    }

    public void setNode(String s, String s1)
    {
        Node node = getNode(s);
        if (node != null)
        {
            node.setValue(s1);
            return;
        } else
        {
            s = new Node(s);
            s.setValue(s1);
            addNode(s);
            return;
        }
    }

    public void setParentNode(Node node)
    {
        parentNode = node;
    }

    public void setUserData(Object obj)
    {
        userData = obj;
    }

    public void setValue(int i)
    {
        setValue(Integer.toString(i));
    }

    public void setValue(String s)
    {
        value = s;
    }

    public String toString()
    {
        return toString("utf-8", true);
    }

    public String toString(String s, boolean flag)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        PrintWriter printwriter = new PrintWriter(bytearrayoutputstream);
        output(printwriter, 0, flag);
        printwriter.flush();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (s.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        s = bytearrayoutputstream.toString(s);
        return s;
        s;
        return bytearrayoutputstream.toString();
    }

    public String toXMLString()
    {
        return toXMLString(true);
    }

    public String toXMLString(boolean flag)
    {
        return toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;");
    }
}
