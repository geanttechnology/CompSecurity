// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

// Referenced classes of package org.jsoup.parser:
//            TreeBuilder, ParseErrorList, ParseError, CharacterReader, 
//            Token, Tag, Tokeniser, HtmlTreeBuilderState, 
//            TokeniserState

class HtmlTreeBuilder extends TreeBuilder
{

    static final boolean $assertionsDisabled;
    private boolean baseUriSetFromDoc;
    private Element contextElement;
    private Element formElement;
    private DescendableLinkedList formattingElements;
    private boolean fosterInserts;
    private boolean fragmentParsing;
    private boolean framesetOk;
    private Element headElement;
    private HtmlTreeBuilderState originalState;
    private List pendingTableCharacters;
    private HtmlTreeBuilderState state;

    HtmlTreeBuilder()
    {
        baseUriSetFromDoc = false;
        formattingElements = new DescendableLinkedList();
        pendingTableCharacters = new ArrayList();
        framesetOk = true;
        fosterInserts = false;
        fragmentParsing = false;
    }

    private transient void clearStackToContext(String as[])
    {
        Iterator iterator = stack.descendingIterator();
        do
        {
label0:
            {
                if (iterator.hasNext())
                {
                    Element element = (Element)iterator.next();
                    if (!StringUtil.in(element.nodeName(), as) && !element.nodeName().equals("html"))
                    {
                        break label0;
                    }
                }
                return;
            }
            iterator.remove();
        } while (true);
    }

    private boolean inSpecificScope(String s, String as[], String as1[])
    {
        return inSpecificScope(new String[] {
            s
        }, as, as1);
    }

    private boolean inSpecificScope(String as[], String as1[], String as2[])
    {
        Iterator iterator;
        boolean flag1;
        flag1 = false;
        iterator = stack.descendingIterator();
_L6:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((Element)iterator.next()).nodeName();
        if (!StringUtil.in(s, as)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (StringUtil.in(s, as1)) goto _L4; else goto _L3
_L3:
        if (as2 != null && StringUtil.in(s, as2))
        {
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
        Validate.fail("Should not be reachable");
        return false;
    }

    private void insertNode(Node node)
    {
        if (stack.size() == 0)
        {
            doc.appendChild(node);
            return;
        }
        if (isFosterInserts())
        {
            insertInFosterParent(node);
            return;
        } else
        {
            currentElement().appendChild(node);
            return;
        }
    }

    private boolean isElementInQueue(DescendableLinkedList descendablelinkedlist, Element element)
    {
        for (descendablelinkedlist = descendablelinkedlist.descendingIterator(); descendablelinkedlist.hasNext();)
        {
            if ((Element)descendablelinkedlist.next() == element)
            {
                return true;
            }
        }

        return false;
    }

    private boolean isSameFormattingElement(Element element, Element element1)
    {
        return element.nodeName().equals(element1.nodeName()) && element.attributes().equals(element1.attributes());
    }

    private void replaceInQueue(LinkedList linkedlist, Element element, Element element1)
    {
        int i = linkedlist.lastIndexOf(element);
        boolean flag;
        if (i != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag);
        linkedlist.remove(i);
        linkedlist.add(i, element1);
    }

    Element aboveOnStack(Element element)
    {
        if (!$assertionsDisabled && !onStack(element))
        {
            throw new AssertionError();
        }
        for (Iterator iterator = stack.descendingIterator(); iterator.hasNext();)
        {
            if ((Element)iterator.next() == element)
            {
                return (Element)iterator.next();
            }
        }

        return null;
    }

    void clearFormattingElementsToLastMarker()
    {
        Element element;
        do
        {
            if (formattingElements.isEmpty())
            {
                break;
            }
            element = (Element)formattingElements.peekLast();
            formattingElements.removeLast();
        } while (element != null);
    }

    void clearStackToTableBodyContext()
    {
        clearStackToContext(new String[] {
            "tbody", "tfoot", "thead"
        });
    }

    void clearStackToTableContext()
    {
        clearStackToContext(new String[] {
            "table"
        });
    }

    void clearStackToTableRowContext()
    {
        clearStackToContext(new String[] {
            "tr"
        });
    }

    void error(HtmlTreeBuilderState htmltreebuilderstate)
    {
        if (errors.canAddError())
        {
            errors.add(new ParseError(reader.pos(), "Unexpected token [%s] when in state [%s]", new Object[] {
                currentToken.tokenType(), htmltreebuilderstate
            }));
        }
    }

    void framesetOk(boolean flag)
    {
        framesetOk = flag;
    }

    boolean framesetOk()
    {
        return framesetOk;
    }

    void generateImpliedEndTags()
    {
        generateImpliedEndTags(null);
    }

    void generateImpliedEndTags(String s)
    {
        for (; s != null && !currentElement().nodeName().equals(s) && StringUtil.in(currentElement().nodeName(), new String[] {
    "dd", "dt", "li", "option", "optgroup", "p", "rp", "rt"
}); pop()) { }
    }

    Element getActiveFormattingElement(String s)
    {
        Iterator iterator = formattingElements.descendingIterator();
        Element element;
        do
        {
            if (iterator.hasNext())
            {
                element = (Element)iterator.next();
                if (element != null)
                {
                    continue;
                }
            }
            return null;
        } while (!element.nodeName().equals(s));
        return element;
    }

    String getBaseUri()
    {
        return baseUri;
    }

    Document getDocument()
    {
        return doc;
    }

    Element getFormElement()
    {
        return formElement;
    }

    Element getFromStack(String s)
    {
        for (Iterator iterator = stack.descendingIterator(); iterator.hasNext();)
        {
            Element element = (Element)iterator.next();
            if (element.nodeName().equals(s))
            {
                return element;
            }
        }

        return null;
    }

    Element getHeadElement()
    {
        return headElement;
    }

    List getPendingTableCharacters()
    {
        return pendingTableCharacters;
    }

    DescendableLinkedList getStack()
    {
        return stack;
    }

    boolean inButtonScope(String s)
    {
        return inScope(s, new String[] {
            "button"
        });
    }

    boolean inListItemScope(String s)
    {
        return inScope(s, new String[] {
            "ol", "ul"
        });
    }

    boolean inScope(String s)
    {
        return inScope(s, null);
    }

    boolean inScope(String s, String as[])
    {
        return inSpecificScope(s, new String[] {
            "applet", "caption", "html", "table", "td", "th", "marquee", "object"
        }, as);
    }

    boolean inScope(String as[])
    {
        return inSpecificScope(as, new String[] {
            "applet", "caption", "html", "table", "td", "th", "marquee", "object"
        }, null);
    }

    boolean inSelectScope(String s)
    {
        for (Iterator iterator = stack.descendingIterator(); iterator.hasNext();)
        {
            String s1 = ((Element)iterator.next()).nodeName();
            if (s1.equals(s))
            {
                return true;
            }
            if (!StringUtil.in(s1, new String[] {
    "optgroup", "option"
}))
            {
                return false;
            }
        }

        Validate.fail("Should not be reachable");
        return false;
    }

    boolean inTableScope(String s)
    {
        return inSpecificScope(s, new String[] {
            "html", "table"
        }, null);
    }

    Element insert(String s)
    {
        s = new Element(Tag.valueOf(s), baseUri);
        insert(((Element) (s)));
        return s;
    }

    Element insert(Token.StartTag starttag)
    {
        if (starttag.isSelfClosing() && !Tag.isKnownTag(starttag.name()))
        {
            starttag = insertEmpty(starttag);
            process(new Token.EndTag(starttag.tagName()));
            return starttag;
        } else
        {
            starttag = new Element(Tag.valueOf(starttag.name()), baseUri, starttag.attributes);
            insert(((Element) (starttag)));
            return starttag;
        }
    }

    void insert(Element element)
    {
        insertNode(element);
        stack.add(element);
    }

    void insert(Token.Character character)
    {
        if (StringUtil.in(currentElement().tagName(), new String[] {
    "script", "style"
}))
        {
            character = new DataNode(character.getData(), baseUri);
        } else
        {
            character = new TextNode(character.getData(), baseUri);
        }
        currentElement().appendChild(character);
    }

    void insert(Token.Comment comment)
    {
        insertNode(new Comment(comment.getData(), baseUri));
    }

    Element insertEmpty(Token.StartTag starttag)
    {
        Tag tag = Tag.valueOf(starttag.name());
        Element element = new Element(tag, baseUri, starttag.attributes);
        insertNode(element);
        if (starttag.isSelfClosing())
        {
            tokeniser.acknowledgeSelfClosingFlag();
            if (!tag.isKnownTag())
            {
                tag.setSelfClosing();
            }
        }
        return element;
    }

    void insertInFosterParent(Node node)
    {
        Element element1 = getFromStack("table");
        boolean flag = false;
        Element element;
        if (element1 != null)
        {
            if (element1.parent() != null)
            {
                element = element1.parent();
                flag = true;
            } else
            {
                element = aboveOnStack(element1);
            }
        } else
        {
            element = (Element)stack.get(0);
        }
        if (flag)
        {
            Validate.notNull(element1);
            element1.before(node);
            return;
        } else
        {
            element.appendChild(node);
            return;
        }
    }

    void insertMarkerToFormattingElements()
    {
        formattingElements.add(null);
    }

    void insertOnStackAfter(Element element, Element element1)
    {
        int i = stack.lastIndexOf(element);
        boolean flag;
        if (i != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag);
        stack.add(i + 1, element1);
    }

    boolean isFosterInserts()
    {
        return fosterInserts;
    }

    boolean isFragmentParsing()
    {
        return fragmentParsing;
    }

    boolean isInActiveFormattingElements(Element element)
    {
        return isElementInQueue(formattingElements, element);
    }

    boolean isSpecial(Element element)
    {
        return StringUtil.in(element.nodeName(), new String[] {
            "address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", 
            "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", 
            "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", 
            "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", 
            "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", 
            "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", 
            "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", 
            "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"
        });
    }

    void markInsertionMode()
    {
        originalState = state;
    }

    void maybeSetBaseUri(Element element)
    {
        if (!baseUriSetFromDoc)
        {
            if ((element = element.absUrl("href")).length() != 0)
            {
                baseUri = element;
                baseUriSetFromDoc = true;
                doc.setBaseUri(element);
                return;
            }
        }
    }

    void newPendingTableCharacters()
    {
        pendingTableCharacters = new ArrayList();
    }

    boolean onStack(Element element)
    {
        return isElementInQueue(stack, element);
    }

    HtmlTreeBuilderState originalState()
    {
        return originalState;
    }

    Document parse(String s, String s1, ParseErrorList parseerrorlist)
    {
        state = HtmlTreeBuilderState.Initial;
        return super.parse(s, s1, parseerrorlist);
    }

    List parseFragment(String s, Element element, String s1, ParseErrorList parseerrorlist)
    {
        state = HtmlTreeBuilderState.Initial;
        initialiseParse(s, s1, parseerrorlist);
        contextElement = element;
        fragmentParsing = true;
        s = null;
        if (element != null)
        {
            if (element.ownerDocument() != null)
            {
                doc.quirksMode(element.ownerDocument().quirksMode());
            }
            s = element.tagName();
            if (StringUtil.in(s, new String[] {
    "title", "textarea"
}))
            {
                tokeniser.transition(TokeniserState.Rcdata);
            } else
            if (StringUtil.in(s, new String[] {
    "iframe", "noembed", "noframes", "style", "xmp"
}))
            {
                tokeniser.transition(TokeniserState.Rawtext);
            } else
            if (s.equals("script"))
            {
                tokeniser.transition(TokeniserState.ScriptData);
            } else
            if (s.equals("noscript"))
            {
                tokeniser.transition(TokeniserState.Data);
            } else
            if (s.equals("plaintext"))
            {
                tokeniser.transition(TokeniserState.Data);
            } else
            {
                tokeniser.transition(TokeniserState.Data);
            }
            s = new Element(Tag.valueOf("html"), s1);
            doc.appendChild(s);
            stack.push(s);
            resetInsertionMode();
        }
        runParser();
        if (element != null)
        {
            return s.childNodes();
        } else
        {
            return doc.childNodes();
        }
    }

    Element pop()
    {
        if (((Element)stack.peekLast()).nodeName().equals("td") && !state.name().equals("InCell"))
        {
            Validate.isFalse(true, "pop td not in cell");
        }
        if (((Element)stack.peekLast()).nodeName().equals("html"))
        {
            Validate.isFalse(true, "popping html!");
        }
        return (Element)stack.pollLast();
    }

    void popStackToBefore(String s)
    {
        Iterator iterator = stack.descendingIterator();
        do
        {
            if (!iterator.hasNext() || ((Element)iterator.next()).nodeName().equals(s))
            {
                return;
            }
            iterator.remove();
        } while (true);
    }

    void popStackToClose(String s)
    {
        Iterator iterator = stack.descendingIterator();
        do
        {
label0:
            {
                if (iterator.hasNext())
                {
                    if (!((Element)iterator.next()).nodeName().equals(s))
                    {
                        break label0;
                    }
                    iterator.remove();
                }
                return;
            }
            iterator.remove();
        } while (true);
    }

    transient void popStackToClose(String as[])
    {
        Iterator iterator = stack.descendingIterator();
        do
        {
label0:
            {
                if (iterator.hasNext())
                {
                    if (!StringUtil.in(((Element)iterator.next()).nodeName(), as))
                    {
                        break label0;
                    }
                    iterator.remove();
                }
                return;
            }
            iterator.remove();
        } while (true);
    }

    protected boolean process(Token token)
    {
        currentToken = token;
        return state.process(token, this);
    }

    boolean process(Token token, HtmlTreeBuilderState htmltreebuilderstate)
    {
        currentToken = token;
        return htmltreebuilderstate.process(token, this);
    }

    void push(Element element)
    {
        stack.add(element);
    }

    void pushActiveFormattingElements(Element element)
    {
        Iterator iterator;
        int i;
        i = 0;
        iterator = formattingElements.descendingIterator();
_L2:
        if (iterator.hasNext())
        {
            Element element1 = (Element)iterator.next();
            if (element1 != null)
            {
                int j = i;
                if (isSameFormattingElement(element, element1))
                {
                    j = i + 1;
                }
                i = j;
                if (j != 3)
                {
                    continue; /* Loop/switch isn't completed */
                }
                iterator.remove();
            }
        }
        formattingElements.add(element);
        return;
        if (true) goto _L2; else goto _L1
_L1:
    }

    void reconstructFormattingElements()
    {
        Object obj;
        int i;
        boolean flag1;
        int l;
        l = formattingElements.size();
        if (l == 0 || formattingElements.getLast() == null || onStack((Element)formattingElements.getLast()))
        {
            return;
        }
        obj = (Element)formattingElements.getLast();
        i = l - 1;
        flag1 = false;
_L2:
        boolean flag;
        int j;
        if (i == 0)
        {
            flag = true;
        } else
        {
            obj = formattingElements;
            int k = i - 1;
            Element element1 = (Element)((DescendableLinkedList) (obj)).get(k);
            obj = element1;
            i = k;
            flag = flag1;
            if (element1 != null)
            {
                obj = element1;
                i = k;
                if (!onStack(element1))
                {
                    continue; /* Loop/switch isn't completed */
                }
                obj = element1;
                i = k;
                flag = flag1;
            }
        }
        do
        {
            j = i;
            if (!flag)
            {
                obj = formattingElements;
                j = i + 1;
                obj = (Element)((DescendableLinkedList) (obj)).get(j);
            }
            Validate.notNull(obj);
            flag = false;
            Element element = insert(((Element) (obj)).nodeName());
            element.attributes().addAll(((Element) (obj)).attributes());
            formattingElements.add(j, element);
            formattingElements.remove(j + 1);
            i = j;
        } while (j != l - 1);
        return;
        if (true) goto _L2; else goto _L1
_L1:
    }

    void removeFromActiveFormattingElements(Element element)
    {
        Iterator iterator = formattingElements.descendingIterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if ((Element)iterator.next() != element)
            {
                continue;
            }
            iterator.remove();
            break;
        } while (true);
    }

    boolean removeFromStack(Element element)
    {
        for (Iterator iterator = stack.descendingIterator(); iterator.hasNext();)
        {
            if ((Element)iterator.next() == element)
            {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    void replaceActiveFormattingElement(Element element, Element element1)
    {
        replaceInQueue(formattingElements, element, element1);
    }

    void replaceOnStack(Element element, Element element1)
    {
        replaceInQueue(stack, element, element1);
    }

    void resetInsertionMode()
    {
        boolean flag = false;
        Iterator iterator = stack.descendingIterator();
        do
        {
            Object obj;
            boolean flag1;
label0:
            {
                if (iterator.hasNext())
                {
                    obj = (Element)iterator.next();
                    flag1 = flag;
                    if (!iterator.hasNext())
                    {
                        flag1 = true;
                        obj = contextElement;
                    }
                    obj = ((Element) (obj)).nodeName();
                    if (!"select".equals(obj))
                    {
                        break label0;
                    }
                    transition(HtmlTreeBuilderState.InSelect);
                }
                return;
            }
            if ("td".equals(obj) || "td".equals(obj) && !flag1)
            {
                transition(HtmlTreeBuilderState.InCell);
                return;
            }
            if ("tr".equals(obj))
            {
                transition(HtmlTreeBuilderState.InRow);
                return;
            }
            if ("tbody".equals(obj) || "thead".equals(obj) || "tfoot".equals(obj))
            {
                transition(HtmlTreeBuilderState.InTableBody);
                return;
            }
            if ("caption".equals(obj))
            {
                transition(HtmlTreeBuilderState.InCaption);
                return;
            }
            if ("colgroup".equals(obj))
            {
                transition(HtmlTreeBuilderState.InColumnGroup);
                return;
            }
            if ("table".equals(obj))
            {
                transition(HtmlTreeBuilderState.InTable);
                return;
            }
            if ("head".equals(obj))
            {
                transition(HtmlTreeBuilderState.InBody);
                return;
            }
            if ("body".equals(obj))
            {
                transition(HtmlTreeBuilderState.InBody);
                return;
            }
            if ("frameset".equals(obj))
            {
                transition(HtmlTreeBuilderState.InFrameset);
                return;
            }
            if ("html".equals(obj))
            {
                transition(HtmlTreeBuilderState.BeforeHead);
                return;
            }
            flag = flag1;
            if (flag1)
            {
                transition(HtmlTreeBuilderState.InBody);
                return;
            }
        } while (true);
    }

    void setFormElement(Element element)
    {
        formElement = element;
    }

    void setFosterInserts(boolean flag)
    {
        fosterInserts = flag;
    }

    void setHeadElement(Element element)
    {
        headElement = element;
    }

    void setPendingTableCharacters(List list)
    {
        pendingTableCharacters = list;
    }

    HtmlTreeBuilderState state()
    {
        return state;
    }

    public String toString()
    {
        return (new StringBuilder()).append("TreeBuilder{currentToken=").append(currentToken).append(", state=").append(state).append(", currentElement=").append(currentElement()).append('}').toString();
    }

    void transition(HtmlTreeBuilderState htmltreebuilderstate)
    {
        state = htmltreebuilderstate;
    }

    static 
    {
        boolean flag;
        if (!org/jsoup/parser/HtmlTreeBuilder.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
