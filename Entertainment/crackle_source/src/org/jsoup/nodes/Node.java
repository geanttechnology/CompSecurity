// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Parser;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

// Referenced classes of package org.jsoup.nodes:
//            Attributes, Element, Document

public abstract class Node
    implements Cloneable
{
    private static class OuterHtmlVisitor
        implements NodeVisitor
    {

        private StringBuilder accum;
        private Document.OutputSettings out;

        public void head(Node node, int i)
        {
            node.outerHtmlHead(accum, i, out);
        }

        public void tail(Node node, int i)
        {
            if (!node.nodeName().equals("#text"))
            {
                node.outerHtmlTail(accum, i, out);
            }
        }

        OuterHtmlVisitor(StringBuilder stringbuilder, Document.OutputSettings outputsettings)
        {
            accum = stringbuilder;
            out = outputsettings;
        }
    }


    Attributes attributes;
    String baseUri;
    List childNodes;
    Node parentNode;
    int siblingIndex;

    protected Node()
    {
        childNodes = Collections.emptyList();
        attributes = null;
    }

    protected Node(String s)
    {
        this(s, new Attributes());
    }

    protected Node(String s, Attributes attributes1)
    {
        Validate.notNull(s);
        Validate.notNull(attributes1);
        childNodes = new ArrayList(4);
        baseUri = s.trim();
        attributes = attributes1;
    }

    private void addSiblingHtml(int i, String s)
    {
        Validate.notNull(s);
        Validate.notNull(parentNode);
        Element element;
        if (parent() instanceof Element)
        {
            element = (Element)parent();
        } else
        {
            element = null;
        }
        s = Parser.parseFragment(s, element, baseUri());
        parentNode.addChildren(i, (Node[])s.toArray(new Node[s.size()]));
    }

    private Element getDeepChild(Element element)
    {
        org.jsoup.select.Elements elements = element.children();
        if (elements.size() > 0)
        {
            element = getDeepChild((Element)elements.get(0));
        }
        return element;
    }

    private Document.OutputSettings getOutputSettings()
    {
        if (ownerDocument() != null)
        {
            return ownerDocument().outputSettings();
        } else
        {
            return (new Document("")).outputSettings();
        }
    }

    private void reindexChildren()
    {
        for (int i = 0; i < childNodes.size(); i++)
        {
            ((Node)childNodes.get(i)).setSiblingIndex(i);
        }

    }

    private void reparentChild(Node node)
    {
        if (node.parentNode != null)
        {
            node.parentNode.removeChild(node);
        }
        node.setParentNode(this);
    }

    public String absUrl(String s)
    {
        String s1;
        Validate.notEmpty(s);
        s1 = attr(s);
        if (!hasAttr(s))
        {
            return "";
        }
        URL url = new URL(baseUri);
        s = s1;
        try
        {
            if (s1.startsWith("?"))
            {
                s = (new StringBuilder()).append(url.getPath()).append(s1).toString();
            }
            return (new URL(url, s)).toExternalForm();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        s;
        s = (new URL(s1)).toExternalForm();
        return s;
    }

    protected transient void addChildren(int i, Node anode[])
    {
        Validate.noNullElements(anode);
        for (int j = anode.length - 1; j >= 0; j--)
        {
            Node node = anode[j];
            reparentChild(node);
            childNodes.add(i, node);
        }

        reindexChildren();
    }

    protected transient void addChildren(Node anode[])
    {
        int j = anode.length;
        for (int i = 0; i < j; i++)
        {
            Node node = anode[i];
            reparentChild(node);
            childNodes.add(node);
            node.setSiblingIndex(childNodes.size() - 1);
        }

    }

    public Node after(String s)
    {
        addSiblingHtml(siblingIndex() + 1, s);
        return this;
    }

    public Node after(Node node)
    {
        Validate.notNull(node);
        Validate.notNull(parentNode);
        parentNode.addChildren(siblingIndex() + 1, new Node[] {
            node
        });
        return this;
    }

    public String attr(String s)
    {
        Validate.notNull(s);
        if (attributes.hasKey(s))
        {
            return attributes.get(s);
        }
        if (s.toLowerCase().startsWith("abs:"))
        {
            return absUrl(s.substring("abs:".length()));
        } else
        {
            return "";
        }
    }

    public Node attr(String s, String s1)
    {
        attributes.put(s, s1);
        return this;
    }

    public Attributes attributes()
    {
        return attributes;
    }

    public String baseUri()
    {
        return baseUri;
    }

    public Node before(String s)
    {
        addSiblingHtml(siblingIndex(), s);
        return this;
    }

    public Node before(Node node)
    {
        Validate.notNull(node);
        Validate.notNull(parentNode);
        parentNode.addChildren(siblingIndex(), new Node[] {
            node
        });
        return this;
    }

    public Node childNode(int i)
    {
        return (Node)childNodes.get(i);
    }

    public List childNodes()
    {
        return Collections.unmodifiableList(childNodes);
    }

    protected Node[] childNodesAsArray()
    {
        return (Node[])childNodes.toArray(new Node[childNodes().size()]);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public Node clone()
    {
        return doClone(null);
    }

    protected Node doClone(Node node)
    {
        Node node1;
        int i;
        try
        {
            node1 = (Node)super.clone();
        }
        // Misplaced declaration of an exception variable
        catch (Node node)
        {
            throw new RuntimeException(node);
        }
        node1.parentNode = node;
        if (node == null)
        {
            i = 0;
        } else
        {
            i = siblingIndex;
        }
        node1.siblingIndex = i;
        if (attributes != null)
        {
            node = attributes.clone();
        } else
        {
            node = null;
        }
        node1.attributes = node;
        node1.baseUri = baseUri;
        node1.childNodes = new ArrayList(childNodes.size());
        Node node2;
        for (node = childNodes.iterator(); node.hasNext(); node1.childNodes.add(node2.doClone(node1)))
        {
            node2 = (Node)node.next();
        }

        return node1;
    }

    public boolean equals(Object obj)
    {
        return this == obj;
    }

    public boolean hasAttr(String s)
    {
        Validate.notNull(s);
        if (s.toLowerCase().startsWith("abs:"))
        {
            String s1 = s.substring("abs:".length());
            if (attributes.hasKey(s1) && !absUrl(s1).equals(""))
            {
                return true;
            }
        }
        return attributes.hasKey(s);
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (parentNode != null)
        {
            i = parentNode.hashCode();
        } else
        {
            i = 0;
        }
        if (attributes != null)
        {
            j = attributes.hashCode();
        }
        return i * 31 + j;
    }

    protected void indent(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings)
    {
        stringbuilder.append("\n").append(StringUtil.padding(outputsettings.indentAmount() * i));
    }

    public Node nextSibling()
    {
        if (parentNode != null)
        {
            List list = parentNode.childNodes;
            Integer integer = Integer.valueOf(siblingIndex());
            Validate.notNull(integer);
            if (list.size() > integer.intValue() + 1)
            {
                return (Node)list.get(integer.intValue() + 1);
            }
        }
        return null;
    }

    public abstract String nodeName();

    public String outerHtml()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        outerHtml(stringbuilder);
        return stringbuilder.toString();
    }

    protected void outerHtml(StringBuilder stringbuilder)
    {
        (new NodeTraversor(new OuterHtmlVisitor(stringbuilder, getOutputSettings()))).traverse(this);
    }

    abstract void outerHtmlHead(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings);

    abstract void outerHtmlTail(StringBuilder stringbuilder, int i, Document.OutputSettings outputsettings);

    public Document ownerDocument()
    {
        if (this instanceof Document)
        {
            return (Document)this;
        }
        if (parentNode == null)
        {
            return null;
        } else
        {
            return parentNode.ownerDocument();
        }
    }

    public Node parent()
    {
        return parentNode;
    }

    public Node previousSibling()
    {
        if (parentNode != null)
        {
            List list = parentNode.childNodes;
            Integer integer = Integer.valueOf(siblingIndex());
            Validate.notNull(integer);
            if (integer.intValue() > 0)
            {
                return (Node)list.get(integer.intValue() - 1);
            }
        }
        return null;
    }

    public void remove()
    {
        Validate.notNull(parentNode);
        parentNode.removeChild(this);
    }

    public Node removeAttr(String s)
    {
        Validate.notNull(s);
        attributes.remove(s);
        return this;
    }

    protected void removeChild(Node node)
    {
        int i;
        boolean flag;
        if (node.parentNode == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag);
        i = node.siblingIndex();
        childNodes.remove(i);
        reindexChildren();
        node.parentNode = null;
    }

    protected void replaceChild(Node node, Node node1)
    {
        Integer integer;
        boolean flag;
        if (node.parentNode == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag);
        Validate.notNull(node1);
        if (node1.parentNode != null)
        {
            node1.parentNode.removeChild(node1);
        }
        integer = Integer.valueOf(node.siblingIndex());
        childNodes.set(integer.intValue(), node1);
        node1.parentNode = this;
        node1.setSiblingIndex(integer.intValue());
        node.parentNode = null;
    }

    public void replaceWith(Node node)
    {
        Validate.notNull(node);
        Validate.notNull(parentNode);
        parentNode.replaceChild(this, node);
    }

    public void setBaseUri(final String baseUri)
    {
        Validate.notNull(baseUri);
        traverse(new NodeVisitor() {

            final Node this$0;
            final String val$baseUri;

            public void head(Node node, int i)
            {
                node.baseUri = baseUri;
            }

            public void tail(Node node, int i)
            {
            }

            
            {
                this$0 = Node.this;
                baseUri = s;
                super();
            }
        });
    }

    protected void setParentNode(Node node)
    {
        if (parentNode != null)
        {
            parentNode.removeChild(this);
        }
        parentNode = node;
    }

    protected void setSiblingIndex(int i)
    {
        siblingIndex = i;
    }

    public int siblingIndex()
    {
        return siblingIndex;
    }

    public List siblingNodes()
    {
        if (parentNode != null) goto _L2; else goto _L1
_L1:
        Object obj = Collections.emptyList();
_L4:
        return ((List) (obj));
_L2:
        obj = parentNode.childNodes;
        ArrayList arraylist = new ArrayList(((List) (obj)).size() - 1);
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            obj = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (Node)iterator.next();
            if (obj != this)
            {
                arraylist.add(obj);
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String toString()
    {
        return outerHtml();
    }

    public Node traverse(NodeVisitor nodevisitor)
    {
        Validate.notNull(nodevisitor);
        (new NodeTraversor(nodevisitor)).traverse(this);
        return this;
    }

    public Node unwrap()
    {
        Validate.notNull(parentNode);
        int i = siblingIndex;
        Node node;
        if (childNodes.size() > 0)
        {
            node = (Node)childNodes.get(0);
        } else
        {
            node = null;
        }
        parentNode.addChildren(i, childNodesAsArray());
        remove();
        return node;
    }

    public Node wrap(String s)
    {
        Object obj;
        Validate.notEmpty(s);
        if (parent() instanceof Element)
        {
            obj = (Element)parent();
        } else
        {
            obj = null;
        }
        obj = Parser.parseFragment(s, ((Element) (obj)), baseUri());
        s = (Node)((List) (obj)).get(0);
        if (s != null && (s instanceof Element)) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        Element element = (Element)s;
        s = getDeepChild(element);
        parentNode.replaceChild(this, element);
        s.addChildren(new Node[] {
            this
        });
        s = this;
        if (((List) (obj)).size() <= 0)
        {
            continue;
        }
        int i = 0;
        do
        {
            s = this;
            if (i >= ((List) (obj)).size())
            {
                continue;
            }
            s = (Node)((List) (obj)).get(i);
            ((Node) (s)).parentNode.removeChild(s);
            element.appendChild(s);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
