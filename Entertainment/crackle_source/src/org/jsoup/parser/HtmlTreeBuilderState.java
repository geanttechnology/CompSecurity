// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilder, TokeniserState, Tokeniser, Token, 
//            TreeBuilder, Tag

abstract class HtmlTreeBuilderState extends Enum
{

    private static final HtmlTreeBuilderState $VALUES[];
    public static final HtmlTreeBuilderState AfterAfterBody;
    public static final HtmlTreeBuilderState AfterAfterFrameset;
    public static final HtmlTreeBuilderState AfterBody;
    public static final HtmlTreeBuilderState AfterFrameset;
    public static final HtmlTreeBuilderState AfterHead;
    public static final HtmlTreeBuilderState BeforeHead;
    public static final HtmlTreeBuilderState BeforeHtml;
    public static final HtmlTreeBuilderState ForeignContent;
    public static final HtmlTreeBuilderState InBody;
    public static final HtmlTreeBuilderState InCaption;
    public static final HtmlTreeBuilderState InCell;
    public static final HtmlTreeBuilderState InColumnGroup;
    public static final HtmlTreeBuilderState InFrameset;
    public static final HtmlTreeBuilderState InHead;
    public static final HtmlTreeBuilderState InHeadNoscript;
    public static final HtmlTreeBuilderState InRow;
    public static final HtmlTreeBuilderState InSelect;
    public static final HtmlTreeBuilderState InSelectInTable;
    public static final HtmlTreeBuilderState InTable;
    public static final HtmlTreeBuilderState InTableBody;
    public static final HtmlTreeBuilderState InTableText;
    public static final HtmlTreeBuilderState Initial;
    public static final HtmlTreeBuilderState Text;
    private static String nullString = String.valueOf('\0');

    private HtmlTreeBuilderState(String s, int i)
    {
        super(s, i);
    }


    private static void handleRawtext(Token.StartTag starttag, HtmlTreeBuilder htmltreebuilder)
    {
        htmltreebuilder.insert(starttag);
        htmltreebuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmltreebuilder.markInsertionMode();
        htmltreebuilder.transition(Text);
    }

    private static void handleRcData(Token.StartTag starttag, HtmlTreeBuilder htmltreebuilder)
    {
        htmltreebuilder.insert(starttag);
        htmltreebuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmltreebuilder.markInsertionMode();
        htmltreebuilder.transition(Text);
    }

    private static boolean isWhitespace(Token token)
    {
        if (!token.isCharacter()) goto _L2; else goto _L1
_L1:
        int i;
        token = token.asCharacter().getData();
        i = 0;
_L5:
        if (i >= token.length())
        {
            break; /* Loop/switch isn't completed */
        }
        if (StringUtil.isWhitespace(token.charAt(i))) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        return true;
    }

    public static HtmlTreeBuilderState valueOf(String s)
    {
        return (HtmlTreeBuilderState)Enum.valueOf(org/jsoup/parser/HtmlTreeBuilderState, s);
    }

    public static HtmlTreeBuilderState[] values()
    {
        return (HtmlTreeBuilderState[])$VALUES.clone();
    }

    abstract boolean process(Token token, HtmlTreeBuilder htmltreebuilder);

    static 
    {
        Initial = new HtmlTreeBuilderState("Initial", 0) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (HtmlTreeBuilderState.isWhitespace(token))
                {
                    return true;
                }
                if (token.isComment())
                {
                    htmltreebuilder.insert(token.asComment());
                    return true;
                }
                if (token.isDoctype())
                {
                    token = token.asDoctype();
                    DocumentType documenttype = new DocumentType(token.getName(), token.getPublicIdentifier(), token.getSystemIdentifier(), htmltreebuilder.getBaseUri());
                    htmltreebuilder.getDocument().appendChild(documenttype);
                    if (token.isForceQuirks())
                    {
                        htmltreebuilder.getDocument().quirksMode(org.jsoup.nodes.Document.QuirksMode.quirks);
                    }
                    htmltreebuilder.transition(BeforeHtml);
                    return true;
                } else
                {
                    htmltreebuilder.transition(BeforeHtml);
                    return htmltreebuilder.process(token);
                }
            }

        };
        BeforeHtml = new HtmlTreeBuilderState("BeforeHtml", 1) {

            private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                htmltreebuilder.insert("html");
                htmltreebuilder.transition(BeforeHead);
                return htmltreebuilder.process(token);
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (token.isDoctype())
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                if (!token.isComment()) goto _L2; else goto _L1
_L1:
                htmltreebuilder.insert(token.asComment());
_L4:
                return true;
_L2:
                if (HtmlTreeBuilderState.isWhitespace(token))
                {
                    return true;
                }
                if (!token.isStartTag() || !token.asStartTag().name().equals("html"))
                {
                    break; /* Loop/switch isn't completed */
                }
                htmltreebuilder.insert(token.asStartTag());
                htmltreebuilder.transition(BeforeHead);
                if (true) goto _L4; else goto _L3
_L3:
                if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), new String[] {
            "head", "body", "html", "br"
        }))
                {
                    return anythingElse(token, htmltreebuilder);
                }
                if (token.isEndTag())
                {
                    htmltreebuilder.error(this);
                    return false;
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
            }

        };
        BeforeHead = new HtmlTreeBuilderState("BeforeHead", 2) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (HtmlTreeBuilderState.isWhitespace(token))
                {
                    return true;
                }
                if (token.isComment())
                {
                    htmltreebuilder.insert(token.asComment());
                    return true;
                }
                if (token.isDoctype())
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                if (token.isStartTag() && token.asStartTag().name().equals("html"))
                {
                    return InBody.process(token, htmltreebuilder);
                }
                if (token.isStartTag() && token.asStartTag().name().equals("head"))
                {
                    htmltreebuilder.setHeadElement(htmltreebuilder.insert(token.asStartTag()));
                    htmltreebuilder.transition(InHead);
                    return true;
                }
                if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), new String[] {
            "head", "body", "html", "br"
        }))
                {
                    htmltreebuilder.process(new Token.StartTag("head"));
                    return htmltreebuilder.process(token);
                }
                if (token.isEndTag())
                {
                    htmltreebuilder.error(this);
                    return false;
                } else
                {
                    htmltreebuilder.process(new Token.StartTag("head"));
                    return htmltreebuilder.process(token);
                }
            }

        };
        InHead = new HtmlTreeBuilderState("InHead", 3) {

            private boolean anythingElse(Token token, TreeBuilder treebuilder)
            {
                treebuilder.process(new Token.EndTag("head"));
                return treebuilder.process(token);
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (!HtmlTreeBuilderState.isWhitespace(token)) goto _L2; else goto _L1
_L1:
                htmltreebuilder.insert(token.asCharacter());
_L4:
                return true;
_L2:
                static class _cls24
                {

                    static final int $SwitchMap$org$jsoup$parser$Token$TokenType[];

                    static 
                    {
                        $SwitchMap$org$jsoup$parser$Token$TokenType = new int[Token.TokenType.values().length];
                        try
                        {
                            $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Comment.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.StartTag.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls24..SwitchMap.org.jsoup.parser.Token.TokenType[token.type.ordinal()])
                {
                default:
                    return anythingElse(token, htmltreebuilder);

                case 1: // '\001'
                    htmltreebuilder.insert(token.asComment());
                    return true;

                case 2: // '\002'
                    htmltreebuilder.error(this);
                    return false;

                case 3: // '\003'
                    Token.StartTag starttag = token.asStartTag();
                    String s = starttag.name();
                    if (s.equals("html"))
                    {
                        return InBody.process(token, htmltreebuilder);
                    }
                    if (StringUtil.in(s, new String[] {
            "base", "basefont", "bgsound", "command", "link"
        }))
                    {
                        token = htmltreebuilder.insertEmpty(starttag);
                        if (s.equals("base") && token.hasAttr("href"))
                        {
                            htmltreebuilder.maybeSetBaseUri(token);
                            return true;
                        }
                    } else
                    {
                        if (s.equals("meta"))
                        {
                            htmltreebuilder.insertEmpty(starttag);
                            return true;
                        }
                        if (s.equals("title"))
                        {
                            HtmlTreeBuilderState.handleRcData(starttag, htmltreebuilder);
                            return true;
                        }
                        if (StringUtil.in(s, new String[] {
            "noframes", "style"
        }))
                        {
                            HtmlTreeBuilderState.handleRawtext(starttag, htmltreebuilder);
                            return true;
                        }
                        if (s.equals("noscript"))
                        {
                            htmltreebuilder.insert(starttag);
                            htmltreebuilder.transition(InHeadNoscript);
                            return true;
                        }
                        if (s.equals("script"))
                        {
                            htmltreebuilder.insert(starttag);
                            htmltreebuilder.tokeniser.transition(TokeniserState.ScriptData);
                            htmltreebuilder.markInsertionMode();
                            htmltreebuilder.transition(Text);
                            return true;
                        }
                        if (s.equals("head"))
                        {
                            htmltreebuilder.error(this);
                            return false;
                        } else
                        {
                            return anythingElse(token, htmltreebuilder);
                        }
                    }
                    break;

                case 4: // '\004'
                    String s1 = token.asEndTag().name();
                    if (s1.equals("head"))
                    {
                        htmltreebuilder.pop();
                        htmltreebuilder.transition(AfterHead);
                        return true;
                    }
                    if (StringUtil.in(s1, new String[] {
            "body", "html", "br"
        }))
                    {
                        return anythingElse(token, htmltreebuilder);
                    } else
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

        };
        InHeadNoscript = new HtmlTreeBuilderState("InHeadNoscript", 4) {

            private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                htmltreebuilder.error(this);
                htmltreebuilder.process(new Token.EndTag("noscript"));
                return htmltreebuilder.process(token);
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (!token.isDoctype()) goto _L2; else goto _L1
_L1:
                htmltreebuilder.error(this);
_L4:
                return true;
_L2:
                if (token.isStartTag() && token.asStartTag().name().equals("html"))
                {
                    return htmltreebuilder.process(token, InBody);
                }
                if (!token.isEndTag() || !token.asEndTag().name().equals("noscript"))
                {
                    break; /* Loop/switch isn't completed */
                }
                htmltreebuilder.pop();
                htmltreebuilder.transition(InHead);
                if (true) goto _L4; else goto _L3
_L3:
                if (HtmlTreeBuilderState.isWhitespace(token) || token.isComment() || token.isStartTag() && StringUtil.in(token.asStartTag().name(), new String[] {
            "basefont", "bgsound", "link", "meta", "noframes", "style"
        }))
                {
                    return htmltreebuilder.process(token, InHead);
                }
                if (token.isEndTag() && token.asEndTag().name().equals("br"))
                {
                    return anythingElse(token, htmltreebuilder);
                }
                if (token.isStartTag() && StringUtil.in(token.asStartTag().name(), new String[] {
            "head", "noscript"
        }) || token.isEndTag())
                {
                    htmltreebuilder.error(this);
                    return false;
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
            }

        };
        AfterHead = new HtmlTreeBuilderState("AfterHead", 5) {

            private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                htmltreebuilder.process(new Token.StartTag("body"));
                htmltreebuilder.framesetOk(true);
                return htmltreebuilder.process(token);
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (HtmlTreeBuilderState.isWhitespace(token))
                {
                    htmltreebuilder.insert(token.asCharacter());
                } else
                if (token.isComment())
                {
                    htmltreebuilder.insert(token.asComment());
                } else
                if (token.isDoctype())
                {
                    htmltreebuilder.error(this);
                } else
                if (token.isStartTag())
                {
                    Token.StartTag starttag = token.asStartTag();
                    String s = starttag.name();
                    if (s.equals("html"))
                    {
                        return htmltreebuilder.process(token, InBody);
                    }
                    if (s.equals("body"))
                    {
                        htmltreebuilder.insert(starttag);
                        htmltreebuilder.framesetOk(false);
                        htmltreebuilder.transition(InBody);
                    } else
                    if (s.equals("frameset"))
                    {
                        htmltreebuilder.insert(starttag);
                        htmltreebuilder.transition(InFrameset);
                    } else
                    if (StringUtil.in(s, new String[] {
            "base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "title"
        }))
                    {
                        htmltreebuilder.error(this);
                        Element element = htmltreebuilder.getHeadElement();
                        htmltreebuilder.push(element);
                        htmltreebuilder.process(token, InHead);
                        htmltreebuilder.removeFromStack(element);
                    } else
                    {
                        if (s.equals("head"))
                        {
                            htmltreebuilder.error(this);
                            return false;
                        }
                        anythingElse(token, htmltreebuilder);
                    }
                } else
                if (token.isEndTag())
                {
                    if (StringUtil.in(token.asEndTag().name(), new String[] {
            "body", "html"
        }))
                    {
                        anythingElse(token, htmltreebuilder);
                    } else
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                } else
                {
                    anythingElse(token, htmltreebuilder);
                }
                return true;
            }

        };
        InBody = new HtmlTreeBuilderState("InBody", 6) {

            boolean anyOtherEndTag(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                token = token.asEndTag().name();
                Iterator iterator = htmltreebuilder.getStack().descendingIterator();
                Element element;
                do
                {
                    if (iterator.hasNext())
                    {
                        element = (Element)iterator.next();
                        if (!element.nodeName().equals(token))
                        {
                            continue;
                        }
                        htmltreebuilder.generateImpliedEndTags(token);
                        if (!token.equals(htmltreebuilder.currentElement().nodeName()))
                        {
                            htmltreebuilder.error(this);
                        }
                        htmltreebuilder.popStackToClose(token);
                    }
                    return true;
                } while (!htmltreebuilder.isSpecial(element));
                htmltreebuilder.error(this);
                return false;
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                _cls24..SwitchMap.org.jsoup.parser.Token.TokenType[token.type.ordinal()];
                JVM INSTR tableswitch 1 5: default 44
            //                           1 107
            //                           2 118
            //                           3 125
            //                           4 2891
            //                           5 46;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                return true;
_L6:
                token = token.asCharacter();
                if (token.getData().equals(HtmlTreeBuilderState.nullString))
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                if (HtmlTreeBuilderState.isWhitespace(token))
                {
                    htmltreebuilder.reconstructFormattingElements();
                    htmltreebuilder.insert(token);
                } else
                {
                    htmltreebuilder.reconstructFormattingElements();
                    htmltreebuilder.insert(token);
                    htmltreebuilder.framesetOk(false);
                }
                continue; /* Loop/switch isn't completed */
_L2:
                htmltreebuilder.insert(token.asComment());
                continue; /* Loop/switch isn't completed */
_L3:
                htmltreebuilder.error(this);
                return false;
_L4:
                Object obj;
                Object obj1;
                obj = token.asStartTag();
                obj1 = ((Token.StartTag) (obj)).name();
                if (((String) (obj1)).equals("html"))
                {
                    htmltreebuilder.error(this);
                    token = (Element)htmltreebuilder.getStack().getFirst();
                    htmltreebuilder = ((Token.StartTag) (obj)).getAttributes().iterator();
                    do
                    {
                        do
                        {
                            if (!htmltreebuilder.hasNext())
                            {
                                continue; /* Loop/switch isn't completed */
                            }
                            obj = (Attribute)htmltreebuilder.next();
                        } while (token.hasAttr(((Attribute) (obj)).getKey()));
                        token.attributes().put(((Attribute) (obj)));
                    } while (true);
                }
                if (StringUtil.in(((String) (obj1)), new String[] {
            "base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title"
        }))
                {
                    return htmltreebuilder.process(token, InHead);
                }
                if (((String) (obj1)).equals("body"))
                {
                    htmltreebuilder.error(this);
                    token = htmltreebuilder.getStack();
                    if (token.size() == 1 || token.size() > 2 && !((Element)token.get(1)).nodeName().equals("body"))
                    {
                        return false;
                    }
                    htmltreebuilder.framesetOk(false);
                    token = (Element)token.get(1);
                    htmltreebuilder = ((Token.StartTag) (obj)).getAttributes().iterator();
                    do
                    {
                        do
                        {
                            if (!htmltreebuilder.hasNext())
                            {
                                continue; /* Loop/switch isn't completed */
                            }
                            obj = (Attribute)htmltreebuilder.next();
                        } while (token.hasAttr(((Attribute) (obj)).getKey()));
                        token.attributes().put(((Attribute) (obj)));
                    } while (true);
                }
                if (((String) (obj1)).equals("frameset"))
                {
                    htmltreebuilder.error(this);
                    token = htmltreebuilder.getStack();
                    if (token.size() == 1 || token.size() > 2 && !((Element)token.get(1)).nodeName().equals("body"))
                    {
                        return false;
                    }
                    if (!htmltreebuilder.framesetOk())
                    {
                        return false;
                    }
                    obj1 = (Element)token.get(1);
                    if (((Element) (obj1)).parent() != null)
                    {
                        ((Element) (obj1)).remove();
                    }
                    for (; token.size() > 1; token.removeLast()) { }
                    htmltreebuilder.insert(((Token.StartTag) (obj)));
                    htmltreebuilder.transition(InFrameset);
                    continue; /* Loop/switch isn't completed */
                }
                if (StringUtil.in(((String) (obj1)), new String[] {
            "address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", 
            "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", 
            "summary", "ul"
        }))
                {
                    if (htmltreebuilder.inButtonScope("p"))
                    {
                        htmltreebuilder.process(new Token.EndTag("p"));
                    }
                    htmltreebuilder.insert(((Token.StartTag) (obj)));
                    continue; /* Loop/switch isn't completed */
                }
                if (StringUtil.in(((String) (obj1)), new String[] {
            "h1", "h2", "h3", "h4", "h5", "h6"
        }))
                {
                    if (htmltreebuilder.inButtonScope("p"))
                    {
                        htmltreebuilder.process(new Token.EndTag("p"));
                    }
                    if (StringUtil.in(htmltreebuilder.currentElement().nodeName(), new String[] {
            "h1", "h2", "h3", "h4", "h5", "h6"
        }))
                    {
                        htmltreebuilder.error(this);
                        htmltreebuilder.pop();
                    }
                    htmltreebuilder.insert(((Token.StartTag) (obj)));
                    continue; /* Loop/switch isn't completed */
                }
                if (StringUtil.in(((String) (obj1)), new String[] {
            "pre", "listing"
        }))
                {
                    if (htmltreebuilder.inButtonScope("p"))
                    {
                        htmltreebuilder.process(new Token.EndTag("p"));
                    }
                    htmltreebuilder.insert(((Token.StartTag) (obj)));
                    htmltreebuilder.framesetOk(false);
                    continue; /* Loop/switch isn't completed */
                }
                if (((String) (obj1)).equals("form"))
                {
                    if (htmltreebuilder.getFormElement() != null)
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    if (htmltreebuilder.inButtonScope("p"))
                    {
                        htmltreebuilder.process(new Token.EndTag("p"));
                    }
                    htmltreebuilder.setFormElement(htmltreebuilder.insert(((Token.StartTag) (obj))));
                    continue; /* Loop/switch isn't completed */
                }
                if (!((String) (obj1)).equals("li")) goto _L8; else goto _L7
_L7:
                int i;
                htmltreebuilder.framesetOk(false);
                token = htmltreebuilder.getStack();
                i = token.size() - 1;
_L14:
                if (i <= 0) goto _L10; else goto _L9
_L9:
                obj1 = (Element)token.get(i);
                if (!((Element) (obj1)).nodeName().equals("li")) goto _L12; else goto _L11
_L11:
                htmltreebuilder.process(new Token.EndTag("li"));
_L10:
                if (htmltreebuilder.inButtonScope("p"))
                {
                    htmltreebuilder.process(new Token.EndTag("p"));
                }
                htmltreebuilder.insert(((Token.StartTag) (obj)));
                continue; /* Loop/switch isn't completed */
_L12:
                if (htmltreebuilder.isSpecial(((Element) (obj1))) && !StringUtil.in(((Element) (obj1)).nodeName(), new String[] {
                    "address", "div", "p"
                })) goto _L10; else goto _L13
_L13:
                i--;
                if (true) goto _L14; else goto _L8
_L8:
                if (!StringUtil.in(((String) (obj1)), new String[] {
                    "dd", "dt"
                })) goto _L16; else goto _L15
_L15:
                htmltreebuilder.framesetOk(false);
                token = htmltreebuilder.getStack();
                i = token.size() - 1;
_L22:
                if (i <= 0) goto _L18; else goto _L17
_L17:
                obj1 = (Element)token.get(i);
                if (!StringUtil.in(((Element) (obj1)).nodeName(), new String[] {
                    "dd", "dt"
                })) goto _L20; else goto _L19
_L19:
                htmltreebuilder.process(new Token.EndTag(((Element) (obj1)).nodeName()));
_L18:
                if (htmltreebuilder.inButtonScope("p"))
                {
                    htmltreebuilder.process(new Token.EndTag("p"));
                }
                htmltreebuilder.insert(((Token.StartTag) (obj)));
                continue; /* Loop/switch isn't completed */
_L20:
                if (htmltreebuilder.isSpecial(((Element) (obj1))) && !StringUtil.in(((Element) (obj1)).nodeName(), new String[] {
                    "address", "div", "p"
                })) goto _L18; else goto _L21
_L21:
                i--;
                if (true) goto _L22; else goto _L16
_L16:
                if (((String) (obj1)).equals("plaintext"))
                {
                    if (htmltreebuilder.inButtonScope("p"))
                    {
                        htmltreebuilder.process(new Token.EndTag("p"));
                    }
                    htmltreebuilder.insert(((Token.StartTag) (obj)));
                    htmltreebuilder.tokeniser.transition(TokeniserState.PLAINTEXT);
                } else
                if (((String) (obj1)).equals("button"))
                {
                    if (htmltreebuilder.inButtonScope("button"))
                    {
                        htmltreebuilder.error(this);
                        htmltreebuilder.process(new Token.EndTag("button"));
                        htmltreebuilder.process(((Token) (obj)));
                    } else
                    {
                        htmltreebuilder.reconstructFormattingElements();
                        htmltreebuilder.insert(((Token.StartTag) (obj)));
                        htmltreebuilder.framesetOk(false);
                    }
                } else
                if (((String) (obj1)).equals("a"))
                {
                    if (htmltreebuilder.getActiveFormattingElement("a") != null)
                    {
                        htmltreebuilder.error(this);
                        htmltreebuilder.process(new Token.EndTag("a"));
                        token = htmltreebuilder.getFromStack("a");
                        if (token != null)
                        {
                            htmltreebuilder.removeFromActiveFormattingElements(token);
                            htmltreebuilder.removeFromStack(token);
                        }
                    }
                    htmltreebuilder.reconstructFormattingElements();
                    htmltreebuilder.pushActiveFormattingElements(htmltreebuilder.insert(((Token.StartTag) (obj))));
                } else
                if (StringUtil.in(((String) (obj1)), new String[] {
            "b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", 
            "tt", "u"
        }))
                {
                    htmltreebuilder.reconstructFormattingElements();
                    htmltreebuilder.pushActiveFormattingElements(htmltreebuilder.insert(((Token.StartTag) (obj))));
                } else
                if (((String) (obj1)).equals("nobr"))
                {
                    htmltreebuilder.reconstructFormattingElements();
                    if (htmltreebuilder.inScope("nobr"))
                    {
                        htmltreebuilder.error(this);
                        htmltreebuilder.process(new Token.EndTag("nobr"));
                        htmltreebuilder.reconstructFormattingElements();
                    }
                    htmltreebuilder.pushActiveFormattingElements(htmltreebuilder.insert(((Token.StartTag) (obj))));
                } else
                if (StringUtil.in(((String) (obj1)), new String[] {
            "applet", "marquee", "object"
        }))
                {
                    htmltreebuilder.reconstructFormattingElements();
                    htmltreebuilder.insert(((Token.StartTag) (obj)));
                    htmltreebuilder.insertMarkerToFormattingElements();
                    htmltreebuilder.framesetOk(false);
                } else
                if (((String) (obj1)).equals("table"))
                {
                    if (htmltreebuilder.getDocument().quirksMode() != org.jsoup.nodes.Document.QuirksMode.quirks && htmltreebuilder.inButtonScope("p"))
                    {
                        htmltreebuilder.process(new Token.EndTag("p"));
                    }
                    htmltreebuilder.insert(((Token.StartTag) (obj)));
                    htmltreebuilder.framesetOk(false);
                    htmltreebuilder.transition(InTable);
                } else
                if (StringUtil.in(((String) (obj1)), new String[] {
            "area", "br", "embed", "img", "keygen", "wbr"
        }))
                {
                    htmltreebuilder.reconstructFormattingElements();
                    htmltreebuilder.insertEmpty(((Token.StartTag) (obj)));
                    htmltreebuilder.framesetOk(false);
                } else
                if (((String) (obj1)).equals("input"))
                {
                    htmltreebuilder.reconstructFormattingElements();
                    if (!htmltreebuilder.insertEmpty(((Token.StartTag) (obj))).attr("type").equalsIgnoreCase("hidden"))
                    {
                        htmltreebuilder.framesetOk(false);
                    }
                } else
                if (StringUtil.in(((String) (obj1)), new String[] {
            "param", "source", "track"
        }))
                {
                    htmltreebuilder.insertEmpty(((Token.StartTag) (obj)));
                } else
                if (((String) (obj1)).equals("hr"))
                {
                    if (htmltreebuilder.inButtonScope("p"))
                    {
                        htmltreebuilder.process(new Token.EndTag("p"));
                    }
                    htmltreebuilder.insertEmpty(((Token.StartTag) (obj)));
                    htmltreebuilder.framesetOk(false);
                } else
                {
                    if (((String) (obj1)).equals("image"))
                    {
                        ((Token.StartTag) (obj)).name("img");
                        return htmltreebuilder.process(((Token) (obj)));
                    }
                    if (((String) (obj1)).equals("isindex"))
                    {
                        htmltreebuilder.error(this);
                        if (htmltreebuilder.getFormElement() != null)
                        {
                            return false;
                        }
                        htmltreebuilder.tokeniser.acknowledgeSelfClosingFlag();
                        htmltreebuilder.process(new Token.StartTag("form"));
                        if (((Token.StartTag) (obj)).attributes.hasKey("action"))
                        {
                            htmltreebuilder.getFormElement().attr("action", ((Token.StartTag) (obj)).attributes.get("action"));
                        }
                        htmltreebuilder.process(new Token.StartTag("hr"));
                        htmltreebuilder.process(new Token.StartTag("label"));
                        if (((Token.StartTag) (obj)).attributes.hasKey("prompt"))
                        {
                            token = ((Token.StartTag) (obj)).attributes.get("prompt");
                        } else
                        {
                            token = "This is a searchable index. Enter search keywords: ";
                        }
                        htmltreebuilder.process(new Token.Character(token));
                        token = new Attributes();
                        obj = ((Token.StartTag) (obj)).attributes.iterator();
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break;
                            }
                            obj1 = (Attribute)((Iterator) (obj)).next();
                            if (!StringUtil.in(((Attribute) (obj1)).getKey(), new String[] {
            "name", "action", "prompt"
        }))
                            {
                                token.put(((Attribute) (obj1)));
                            }
                        } while (true);
                        token.put("name", "isindex");
                        htmltreebuilder.process(new Token.StartTag("input", token));
                        htmltreebuilder.process(new Token.EndTag("label"));
                        htmltreebuilder.process(new Token.StartTag("hr"));
                        htmltreebuilder.process(new Token.EndTag("form"));
                    } else
                    if (((String) (obj1)).equals("textarea"))
                    {
                        htmltreebuilder.insert(((Token.StartTag) (obj)));
                        htmltreebuilder.tokeniser.transition(TokeniserState.Rcdata);
                        htmltreebuilder.markInsertionMode();
                        htmltreebuilder.framesetOk(false);
                        htmltreebuilder.transition(Text);
                    } else
                    if (((String) (obj1)).equals("xmp"))
                    {
                        if (htmltreebuilder.inButtonScope("p"))
                        {
                            htmltreebuilder.process(new Token.EndTag("p"));
                        }
                        htmltreebuilder.reconstructFormattingElements();
                        htmltreebuilder.framesetOk(false);
                        HtmlTreeBuilderState.handleRawtext(((Token.StartTag) (obj)), htmltreebuilder);
                    } else
                    if (((String) (obj1)).equals("iframe"))
                    {
                        htmltreebuilder.framesetOk(false);
                        HtmlTreeBuilderState.handleRawtext(((Token.StartTag) (obj)), htmltreebuilder);
                    } else
                    if (((String) (obj1)).equals("noembed"))
                    {
                        HtmlTreeBuilderState.handleRawtext(((Token.StartTag) (obj)), htmltreebuilder);
                    } else
                    if (((String) (obj1)).equals("select"))
                    {
                        htmltreebuilder.reconstructFormattingElements();
                        htmltreebuilder.insert(((Token.StartTag) (obj)));
                        htmltreebuilder.framesetOk(false);
                        token = htmltreebuilder.state();
                        if (token.equals(InTable) || token.equals(InCaption) || token.equals(InTableBody) || token.equals(InRow) || token.equals(InCell))
                        {
                            htmltreebuilder.transition(InSelectInTable);
                        } else
                        {
                            htmltreebuilder.transition(InSelect);
                        }
                    } else
                    if (StringUtil.in("optgroup", new String[] {
            "option"
        }))
                    {
                        if (htmltreebuilder.currentElement().nodeName().equals("option"))
                        {
                            htmltreebuilder.process(new Token.EndTag("option"));
                        }
                        htmltreebuilder.reconstructFormattingElements();
                        htmltreebuilder.insert(((Token.StartTag) (obj)));
                    } else
                    if (StringUtil.in("rp", new String[] {
            "rt"
        }))
                    {
                        if (htmltreebuilder.inScope("ruby"))
                        {
                            htmltreebuilder.generateImpliedEndTags();
                            if (!htmltreebuilder.currentElement().nodeName().equals("ruby"))
                            {
                                htmltreebuilder.error(this);
                                htmltreebuilder.popStackToBefore("ruby");
                            }
                            htmltreebuilder.insert(((Token.StartTag) (obj)));
                        }
                    } else
                    if (((String) (obj1)).equals("math"))
                    {
                        htmltreebuilder.reconstructFormattingElements();
                        htmltreebuilder.insert(((Token.StartTag) (obj)));
                        htmltreebuilder.tokeniser.acknowledgeSelfClosingFlag();
                    } else
                    if (((String) (obj1)).equals("svg"))
                    {
                        htmltreebuilder.reconstructFormattingElements();
                        htmltreebuilder.insert(((Token.StartTag) (obj)));
                        htmltreebuilder.tokeniser.acknowledgeSelfClosingFlag();
                    } else
                    {
                        if (StringUtil.in(((String) (obj1)), new String[] {
            "caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", 
            "tr"
        }))
                        {
                            htmltreebuilder.error(this);
                            return false;
                        }
                        htmltreebuilder.reconstructFormattingElements();
                        htmltreebuilder.insert(((Token.StartTag) (obj)));
                    }
                }
                continue; /* Loop/switch isn't completed */
_L5:
                String s;
                obj = token.asEndTag();
                s = ((Token.EndTag) (obj)).name();
                if (s.equals("body"))
                {
                    if (!htmltreebuilder.inScope("body"))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    htmltreebuilder.transition(AfterBody);
                    continue; /* Loop/switch isn't completed */
                }
                if (s.equals("html"))
                {
                    if (htmltreebuilder.process(new Token.EndTag("body")))
                    {
                        return htmltreebuilder.process(((Token) (obj)));
                    }
                    continue; /* Loop/switch isn't completed */
                }
                if (StringUtil.in(s, new String[] {
            "address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", 
            "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", 
            "pre", "section", "summary", "ul"
        }))
                {
                    if (!htmltreebuilder.inScope(s))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    htmltreebuilder.generateImpliedEndTags();
                    if (!htmltreebuilder.currentElement().nodeName().equals(s))
                    {
                        htmltreebuilder.error(this);
                    }
                    htmltreebuilder.popStackToClose(s);
                    continue; /* Loop/switch isn't completed */
                }
                if (s.equals("form"))
                {
                    token = htmltreebuilder.getFormElement();
                    htmltreebuilder.setFormElement(null);
                    if (token == null || !htmltreebuilder.inScope(s))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    htmltreebuilder.generateImpliedEndTags();
                    if (!htmltreebuilder.currentElement().nodeName().equals(s))
                    {
                        htmltreebuilder.error(this);
                    }
                    htmltreebuilder.removeFromStack(token);
                    continue; /* Loop/switch isn't completed */
                }
                if (s.equals("p"))
                {
                    if (!htmltreebuilder.inButtonScope(s))
                    {
                        htmltreebuilder.error(this);
                        htmltreebuilder.process(new Token.StartTag(s));
                        return htmltreebuilder.process(((Token) (obj)));
                    }
                    htmltreebuilder.generateImpliedEndTags(s);
                    if (!htmltreebuilder.currentElement().nodeName().equals(s))
                    {
                        htmltreebuilder.error(this);
                    }
                    htmltreebuilder.popStackToClose(s);
                    continue; /* Loop/switch isn't completed */
                }
                if (s.equals("li"))
                {
                    if (!htmltreebuilder.inListItemScope(s))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    htmltreebuilder.generateImpliedEndTags(s);
                    if (!htmltreebuilder.currentElement().nodeName().equals(s))
                    {
                        htmltreebuilder.error(this);
                    }
                    htmltreebuilder.popStackToClose(s);
                    continue; /* Loop/switch isn't completed */
                }
                if (StringUtil.in(s, new String[] {
            "dd", "dt"
        }))
                {
                    if (!htmltreebuilder.inScope(s))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    htmltreebuilder.generateImpliedEndTags(s);
                    if (!htmltreebuilder.currentElement().nodeName().equals(s))
                    {
                        htmltreebuilder.error(this);
                    }
                    htmltreebuilder.popStackToClose(s);
                    continue; /* Loop/switch isn't completed */
                }
                if (StringUtil.in(s, new String[] {
            "h1", "h2", "h3", "h4", "h5", "h6"
        }))
                {
                    if (!htmltreebuilder.inScope(new String[] {
            "h1", "h2", "h3", "h4", "h5", "h6"
        }))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    htmltreebuilder.generateImpliedEndTags(s);
                    if (!htmltreebuilder.currentElement().nodeName().equals(s))
                    {
                        htmltreebuilder.error(this);
                    }
                    htmltreebuilder.popStackToClose(new String[] {
                        "h1", "h2", "h3", "h4", "h5", "h6"
                    });
                    continue; /* Loop/switch isn't completed */
                }
                if (s.equals("sarcasm"))
                {
                    return anyOtherEndTag(token, htmltreebuilder);
                }
                if (!StringUtil.in(s, new String[] {
                    "a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", 
                    "strike", "strong", "tt", "u"
                })) goto _L24; else goto _L23
_L23:
                i = 0;
_L36:
                Element element;
                Object obj3;
                Element element1;
                int j;
                boolean flag;
                if (i >= 8)
                {
                    continue; /* Loop/switch isn't completed */
                }
                element1 = htmltreebuilder.getActiveFormattingElement(s);
                if (element1 == null)
                {
                    return anyOtherEndTag(token, htmltreebuilder);
                }
                if (!htmltreebuilder.onStack(element1))
                {
                    htmltreebuilder.error(this);
                    htmltreebuilder.removeFromActiveFormattingElements(element1);
                    return true;
                }
                if (!htmltreebuilder.inScope(element1.nodeName()))
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                if (htmltreebuilder.currentElement() != element1)
                {
                    htmltreebuilder.error(this);
                }
                obj1 = null;
                element = null;
                flag = false;
                obj3 = htmltreebuilder.getStack();
                j = 0;
_L26:
                Object obj2;
                boolean flag1;
                obj = obj1;
                if (j >= ((LinkedList) (obj3)).size())
                {
                    break MISSING_BLOCK_LABEL_3972;
                }
                obj2 = (Element)((LinkedList) (obj3)).get(j);
                if (obj2 != element1)
                {
                    break; /* Loop/switch isn't completed */
                }
                obj = (Element)((LinkedList) (obj3)).get(j - 1);
                flag1 = true;
_L28:
                j++;
                element = ((Element) (obj));
                flag = flag1;
                if (true) goto _L26; else goto _L25
_L25:
                obj = element;
                flag1 = flag;
                if (!flag) goto _L28; else goto _L27
_L27:
                obj = element;
                flag1 = flag;
                if (!htmltreebuilder.isSpecial(((Element) (obj2)))) goto _L28; else goto _L29
_L29:
                obj = obj2;
                if (obj == null)
                {
                    htmltreebuilder.popStackToClose(element1.nodeName());
                    htmltreebuilder.removeFromActiveFormattingElements(element1);
                    return true;
                }
                obj1 = obj;
                obj3 = obj;
                j = 0;
_L34:
                if (j >= 3) goto _L31; else goto _L30
_L30:
                obj2 = obj1;
                if (htmltreebuilder.onStack(((Element) (obj1))))
                {
                    obj2 = htmltreebuilder.aboveOnStack(((Element) (obj1)));
                }
                if (htmltreebuilder.isInActiveFormattingElements(((Element) (obj2)))) goto _L33; else goto _L32
_L32:
                htmltreebuilder.removeFromStack(((Element) (obj2)));
                obj1 = obj2;
_L35:
                j++;
                  goto _L34
_L33:
                if (obj2 != element1)
                {
                    break MISSING_BLOCK_LABEL_4208;
                }
_L31:
                int l;
                if (StringUtil.in(element.nodeName(), new String[] {
            "table", "tbody", "tfoot", "thead", "tr"
        }))
                {
                    if (((Element) (obj3)).parent() != null)
                    {
                        ((Element) (obj3)).remove();
                    }
                    htmltreebuilder.insertInFosterParent(((Node) (obj3)));
                } else
                {
                    if (((Element) (obj3)).parent() != null)
                    {
                        ((Element) (obj3)).remove();
                    }
                    element.appendChild(((Node) (obj3)));
                }
                obj1 = new Element(Tag.valueOf(s), htmltreebuilder.getBaseUri());
                obj2 = (Node[])((Element) (obj)).childNodes().toArray(new Node[((Element) (obj)).childNodes().size()]);
                l = obj2.length;
                for (int k = 0; k < l; k++)
                {
                    ((Element) (obj1)).appendChild(obj2[k]);
                }

                break MISSING_BLOCK_LABEL_4303;
                obj1 = new Element(Tag.valueOf(((Element) (obj2)).nodeName()), htmltreebuilder.getBaseUri());
                htmltreebuilder.replaceActiveFormattingElement(((Element) (obj2)), ((Element) (obj1)));
                htmltreebuilder.replaceOnStack(((Element) (obj2)), ((Element) (obj1)));
                if (obj3 != obj);
                if (((Element) (obj3)).parent() != null)
                {
                    ((Element) (obj3)).remove();
                }
                ((Element) (obj1)).appendChild(((Node) (obj3)));
                obj3 = obj1;
                  goto _L35
                ((Element) (obj)).appendChild(((Node) (obj1)));
                htmltreebuilder.removeFromActiveFormattingElements(element1);
                htmltreebuilder.removeFromStack(element1);
                htmltreebuilder.insertOnStackAfter(((Element) (obj)), ((Element) (obj1)));
                i++;
                if (true) goto _L36; else goto _L24
_L24:
                if (!StringUtil.in(s, new String[] {
            "applet", "marquee", "object"
        }))
                {
                    break; /* Loop/switch isn't completed */
                }
                if (!htmltreebuilder.inScope("name"))
                {
                    if (!htmltreebuilder.inScope(s))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    htmltreebuilder.generateImpliedEndTags();
                    if (!htmltreebuilder.currentElement().nodeName().equals(s))
                    {
                        htmltreebuilder.error(this);
                    }
                    htmltreebuilder.popStackToClose(s);
                    htmltreebuilder.clearFormattingElementsToLastMarker();
                }
                if (true) goto _L1; else goto _L37
_L37:
                if (s.equals("br"))
                {
                    htmltreebuilder.error(this);
                    htmltreebuilder.process(new Token.StartTag("br"));
                    return false;
                } else
                {
                    return anyOtherEndTag(token, htmltreebuilder);
                }
            }

        };
        Text = new HtmlTreeBuilderState("Text", 7) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (!token.isCharacter()) goto _L2; else goto _L1
_L1:
                htmltreebuilder.insert(token.asCharacter());
_L4:
                return true;
_L2:
                if (token.isEOF())
                {
                    htmltreebuilder.error(this);
                    htmltreebuilder.pop();
                    htmltreebuilder.transition(htmltreebuilder.originalState());
                    return htmltreebuilder.process(token);
                }
                if (token.isEndTag())
                {
                    htmltreebuilder.pop();
                    htmltreebuilder.transition(htmltreebuilder.originalState());
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

        };
        InTable = new HtmlTreeBuilderState("InTable", 8) {

            boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                htmltreebuilder.error(this);
                if (StringUtil.in(htmltreebuilder.currentElement().nodeName(), new String[] {
            "table", "tbody", "tfoot", "thead", "tr"
        }))
                {
                    htmltreebuilder.setFosterInserts(true);
                    boolean flag = htmltreebuilder.process(token, InBody);
                    htmltreebuilder.setFosterInserts(false);
                    return flag;
                } else
                {
                    return htmltreebuilder.process(token, InBody);
                }
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                boolean flag = true;
                if (!token.isCharacter()) goto _L2; else goto _L1
_L1:
                htmltreebuilder.newPendingTableCharacters();
                htmltreebuilder.markInsertionMode();
                htmltreebuilder.transition(InTableText);
                flag = htmltreebuilder.process(token);
_L11:
                return flag;
_L2:
                if (token.isComment())
                {
                    htmltreebuilder.insert(token.asComment());
                    return true;
                }
                if (token.isDoctype())
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                if (!token.isStartTag()) goto _L4; else goto _L3
_L3:
                Token.StartTag starttag;
                String s1;
                starttag = token.asStartTag();
                s1 = starttag.name();
                if (!s1.equals("caption")) goto _L6; else goto _L5
_L5:
                htmltreebuilder.clearStackToTableContext();
                htmltreebuilder.insertMarkerToFormattingElements();
                htmltreebuilder.insert(starttag);
                htmltreebuilder.transition(InCaption);
_L8:
                return anythingElse(token, htmltreebuilder);
_L6:
                if (s1.equals("colgroup"))
                {
                    htmltreebuilder.clearStackToTableContext();
                    htmltreebuilder.insert(starttag);
                    htmltreebuilder.transition(InColumnGroup);
                } else
                {
                    if (s1.equals("col"))
                    {
                        htmltreebuilder.process(new Token.StartTag("colgroup"));
                        return htmltreebuilder.process(token);
                    }
                    if (StringUtil.in(s1, new String[] {
            "tbody", "tfoot", "thead"
        }))
                    {
                        htmltreebuilder.clearStackToTableContext();
                        htmltreebuilder.insert(starttag);
                        htmltreebuilder.transition(InTableBody);
                    } else
                    {
                        if (StringUtil.in(s1, new String[] {
            "td", "th", "tr"
        }))
                        {
                            htmltreebuilder.process(new Token.StartTag("tbody"));
                            return htmltreebuilder.process(token);
                        }
                        if (s1.equals("table"))
                        {
                            htmltreebuilder.error(this);
                            if (htmltreebuilder.process(new Token.EndTag("table")))
                            {
                                return htmltreebuilder.process(token);
                            }
                        } else
                        {
                            if (StringUtil.in(s1, new String[] {
            "style", "script"
        }))
                            {
                                return htmltreebuilder.process(token, InHead);
                            }
                            if (s1.equals("input"))
                            {
                                if (!starttag.attributes.get("type").equalsIgnoreCase("hidden"))
                                {
                                    return anythingElse(token, htmltreebuilder);
                                }
                                htmltreebuilder.insertEmpty(starttag);
                            } else
                            if (s1.equals("form"))
                            {
                                htmltreebuilder.error(this);
                                if (htmltreebuilder.getFormElement() != null)
                                {
                                    return false;
                                }
                                htmltreebuilder.setFormElement(htmltreebuilder.insertEmpty(starttag));
                            } else
                            {
                                return anythingElse(token, htmltreebuilder);
                            }
                        }
                    }
                }
                continue; /* Loop/switch isn't completed */
_L4:
                if (!token.isEndTag())
                {
                    break; /* Loop/switch isn't completed */
                }
                String s = token.asEndTag().name();
                if (s.equals("table"))
                {
                    if (!htmltreebuilder.inTableScope(s))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    htmltreebuilder.popStackToClose("table");
                    htmltreebuilder.resetInsertionMode();
                } else
                if (StringUtil.in(s, new String[] {
            "body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", 
            "tr"
        }))
                {
                    htmltreebuilder.error(this);
                    return false;
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
                if (true) goto _L8; else goto _L7
_L7:
                if (!token.isEOF()) goto _L8; else goto _L9
_L9:
                if (htmltreebuilder.currentElement().nodeName().equals("html"))
                {
                    htmltreebuilder.error(this);
                    return true;
                }
                if (true) goto _L11; else goto _L10
_L10:
            }

        };
        InTableText = new HtmlTreeBuilderState("InTableText", 9) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                switch (_cls24..SwitchMap.org.jsoup.parser.Token.TokenType[token.type.ordinal()])
                {
                default:
                    if (htmltreebuilder.getPendingTableCharacters().size() > 0)
                    {
                        for (Iterator iterator = htmltreebuilder.getPendingTableCharacters().iterator(); iterator.hasNext();)
                        {
                            Token.Character character = (Token.Character)iterator.next();
                            if (!HtmlTreeBuilderState.isWhitespace(character))
                            {
                                htmltreebuilder.error(this);
                                if (StringUtil.in(htmltreebuilder.currentElement().nodeName(), new String[] {
            "table", "tbody", "tfoot", "thead", "tr"
        }))
                                {
                                    htmltreebuilder.setFosterInserts(true);
                                    htmltreebuilder.process(character, InBody);
                                    htmltreebuilder.setFosterInserts(false);
                                } else
                                {
                                    htmltreebuilder.process(character, InBody);
                                }
                            } else
                            {
                                htmltreebuilder.insert(character);
                            }
                        }

                        break;
                    }
                    break;

                case 5: // '\005'
                    token = token.asCharacter();
                    if (token.getData().equals(HtmlTreeBuilderState.nullString))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    } else
                    {
                        htmltreebuilder.getPendingTableCharacters().add(token);
                        return true;
                    }
                }
                break MISSING_BLOCK_LABEL_212;
                htmltreebuilder.newPendingTableCharacters();
                htmltreebuilder.transition(htmltreebuilder.originalState());
                return htmltreebuilder.process(token);
            }

        };
        InCaption = new HtmlTreeBuilderState("InCaption", 10) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (token.isEndTag() && token.asEndTag().name().equals("caption"))
                {
                    if (!htmltreebuilder.inTableScope(token.asEndTag().name()))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    htmltreebuilder.generateImpliedEndTags();
                    if (!htmltreebuilder.currentElement().nodeName().equals("caption"))
                    {
                        htmltreebuilder.error(this);
                    }
                    htmltreebuilder.popStackToClose("caption");
                    htmltreebuilder.clearFormattingElementsToLastMarker();
                    htmltreebuilder.transition(InTable);
                } else
                if (token.isStartTag() && StringUtil.in(token.asStartTag().name(), new String[] {
            "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"
        }) || token.isEndTag() && token.asEndTag().name().equals("table"))
                {
                    htmltreebuilder.error(this);
                    if (htmltreebuilder.process(new Token.EndTag("caption")))
                    {
                        return htmltreebuilder.process(token);
                    }
                } else
                if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), new String[] {
            "body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"
        }))
                {
                    htmltreebuilder.error(this);
                    return false;
                } else
                {
                    return htmltreebuilder.process(token, InBody);
                }
                return true;
            }

        };
        InColumnGroup = new HtmlTreeBuilderState("InColumnGroup", 11) {

            private boolean anythingElse(Token token, TreeBuilder treebuilder)
            {
                if (treebuilder.process(new Token.EndTag("colgroup")))
                {
                    return treebuilder.process(token);
                } else
                {
                    return true;
                }
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (HtmlTreeBuilderState.isWhitespace(token))
                {
                    htmltreebuilder.insert(token.asCharacter());
                } else
                {
                    switch (_cls24..SwitchMap.org.jsoup.parser.Token.TokenType[token.type.ordinal()])
                    {
                    case 5: // '\005'
                    default:
                        return anythingElse(token, htmltreebuilder);

                    case 1: // '\001'
                        htmltreebuilder.insert(token.asComment());
                        return true;

                    case 2: // '\002'
                        htmltreebuilder.error(this);
                        return true;

                    case 3: // '\003'
                        Token.StartTag starttag = token.asStartTag();
                        String s = starttag.name();
                        if (s.equals("html"))
                        {
                            return htmltreebuilder.process(token, InBody);
                        }
                        if (s.equals("col"))
                        {
                            htmltreebuilder.insertEmpty(starttag);
                            return true;
                        } else
                        {
                            return anythingElse(token, htmltreebuilder);
                        }

                    case 4: // '\004'
                        if (token.asEndTag().name().equals("colgroup"))
                        {
                            if (htmltreebuilder.currentElement().nodeName().equals("html"))
                            {
                                htmltreebuilder.error(this);
                                return false;
                            } else
                            {
                                htmltreebuilder.pop();
                                htmltreebuilder.transition(InTable);
                                return true;
                            }
                        } else
                        {
                            return anythingElse(token, htmltreebuilder);
                        }

                    case 6: // '\006'
                        break;
                    }
                    if (!htmltreebuilder.currentElement().nodeName().equals("html"))
                    {
                        return anythingElse(token, htmltreebuilder);
                    }
                }
                return true;
            }

        };
        InTableBody = new HtmlTreeBuilderState("InTableBody", 12) {

            private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                return htmltreebuilder.process(token, InTable);
            }

            private boolean exitTableBody(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (!htmltreebuilder.inTableScope("tbody") && !htmltreebuilder.inTableScope("thead") && !htmltreebuilder.inScope("tfoot"))
                {
                    htmltreebuilder.error(this);
                    return false;
                } else
                {
                    htmltreebuilder.clearStackToTableBodyContext();
                    htmltreebuilder.process(new Token.EndTag(htmltreebuilder.currentElement().nodeName()));
                    return htmltreebuilder.process(token);
                }
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                _cls24..SwitchMap.org.jsoup.parser.Token.TokenType[token.type.ordinal()];
                JVM INSTR tableswitch 3 4: default 32
            //                           3 39
            //                           4 183;
                   goto _L1 _L2 _L3
_L1:
                return anythingElse(token, htmltreebuilder);
_L2:
                Object obj;
                String s;
                obj = token.asStartTag();
                s = ((Token.StartTag) (obj)).name();
                if (!s.equals("tr")) goto _L5; else goto _L4
_L4:
                htmltreebuilder.clearStackToTableBodyContext();
                htmltreebuilder.insert(((Token.StartTag) (obj)));
                htmltreebuilder.transition(InRow);
_L7:
                return true;
_L5:
                if (StringUtil.in(s, new String[] {
            "th", "td"
        }))
                {
                    htmltreebuilder.error(this);
                    htmltreebuilder.process(new Token.StartTag("tr"));
                    return htmltreebuilder.process(((Token) (obj)));
                }
                if (StringUtil.in(s, new String[] {
            "caption", "col", "colgroup", "tbody", "tfoot", "thead"
        }))
                {
                    return exitTableBody(token, htmltreebuilder);
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
_L3:
                obj = token.asEndTag().name();
                if (!StringUtil.in(((String) (obj)), new String[] {
            "tbody", "tfoot", "thead"
        }))
                {
                    break; /* Loop/switch isn't completed */
                }
                if (!htmltreebuilder.inTableScope(((String) (obj))))
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                htmltreebuilder.clearStackToTableBodyContext();
                htmltreebuilder.pop();
                htmltreebuilder.transition(InTable);
                if (true) goto _L7; else goto _L6
_L6:
                if (((String) (obj)).equals("table"))
                {
                    return exitTableBody(token, htmltreebuilder);
                }
                if (StringUtil.in(((String) (obj)), new String[] {
            "body", "caption", "col", "colgroup", "html", "td", "th", "tr"
        }))
                {
                    htmltreebuilder.error(this);
                    return false;
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
            }

        };
        InRow = new HtmlTreeBuilderState("InRow", 13) {

            private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                return htmltreebuilder.process(token, InTable);
            }

            private boolean handleMissingTr(Token token, TreeBuilder treebuilder)
            {
                if (treebuilder.process(new Token.EndTag("tr")))
                {
                    return treebuilder.process(token);
                } else
                {
                    return false;
                }
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (!token.isStartTag()) goto _L2; else goto _L1
_L1:
                Token.StartTag starttag;
                String s1;
                starttag = token.asStartTag();
                s1 = starttag.name();
                if (!StringUtil.in(s1, new String[] {
                    "th", "td"
                })) goto _L4; else goto _L3
_L3:
                htmltreebuilder.clearStackToTableRowContext();
                htmltreebuilder.insert(starttag);
                htmltreebuilder.transition(InCell);
                htmltreebuilder.insertMarkerToFormattingElements();
_L6:
                return true;
_L4:
                if (StringUtil.in(s1, new String[] {
            "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"
        }))
                {
                    return handleMissingTr(token, htmltreebuilder);
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
_L2:
                if (token.isEndTag())
                {
                    String s = token.asEndTag().name();
                    if (s.equals("tr"))
                    {
                        if (!htmltreebuilder.inTableScope(s))
                        {
                            htmltreebuilder.error(this);
                            return false;
                        }
                        htmltreebuilder.clearStackToTableRowContext();
                        htmltreebuilder.pop();
                        htmltreebuilder.transition(InTableBody);
                    } else
                    {
                        if (s.equals("table"))
                        {
                            return handleMissingTr(token, htmltreebuilder);
                        }
                        if (StringUtil.in(s, new String[] {
            "tbody", "tfoot", "thead"
        }))
                        {
                            if (!htmltreebuilder.inTableScope(s))
                            {
                                htmltreebuilder.error(this);
                                return false;
                            } else
                            {
                                htmltreebuilder.process(new Token.EndTag("tr"));
                                return htmltreebuilder.process(token);
                            }
                        }
                        if (StringUtil.in(s, new String[] {
            "body", "caption", "col", "colgroup", "html", "td", "th"
        }))
                        {
                            htmltreebuilder.error(this);
                            return false;
                        } else
                        {
                            return anythingElse(token, htmltreebuilder);
                        }
                    }
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

        };
        InCell = new HtmlTreeBuilderState("InCell", 14) {

            private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                return htmltreebuilder.process(token, InBody);
            }

            private void closeCell(HtmlTreeBuilder htmltreebuilder)
            {
                if (htmltreebuilder.inTableScope("td"))
                {
                    htmltreebuilder.process(new Token.EndTag("td"));
                    return;
                } else
                {
                    htmltreebuilder.process(new Token.EndTag("th"));
                    return;
                }
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (token.isEndTag())
                {
                    String s = token.asEndTag().name();
                    if (StringUtil.in(s, new String[] {
            "td", "th"
        }))
                    {
                        if (!htmltreebuilder.inTableScope(s))
                        {
                            htmltreebuilder.error(this);
                            htmltreebuilder.transition(InRow);
                            return false;
                        }
                        htmltreebuilder.generateImpliedEndTags();
                        if (!htmltreebuilder.currentElement().nodeName().equals(s))
                        {
                            htmltreebuilder.error(this);
                        }
                        htmltreebuilder.popStackToClose(s);
                        htmltreebuilder.clearFormattingElementsToLastMarker();
                        htmltreebuilder.transition(InRow);
                        return true;
                    }
                    if (StringUtil.in(s, new String[] {
            "body", "caption", "col", "colgroup", "html"
        }))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    if (StringUtil.in(s, new String[] {
            "table", "tbody", "tfoot", "thead", "tr"
        }))
                    {
                        if (!htmltreebuilder.inTableScope(s))
                        {
                            htmltreebuilder.error(this);
                            return false;
                        } else
                        {
                            closeCell(htmltreebuilder);
                            return htmltreebuilder.process(token);
                        }
                    } else
                    {
                        return anythingElse(token, htmltreebuilder);
                    }
                }
                if (token.isStartTag() && StringUtil.in(token.asStartTag().name(), new String[] {
            "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"
        }))
                {
                    if (!htmltreebuilder.inTableScope("td") && !htmltreebuilder.inTableScope("th"))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    } else
                    {
                        closeCell(htmltreebuilder);
                        return htmltreebuilder.process(token);
                    }
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
            }

        };
        InSelect = new HtmlTreeBuilderState("InSelect", 15) {

            private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                htmltreebuilder.error(this);
                return false;
            }

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                boolean flag = false;
                _cls24..SwitchMap.org.jsoup.parser.Token.TokenType[token.type.ordinal()];
                JVM INSTR tableswitch 1 6: default 52
            //                           1 95
            //                           2 106
            //                           3 113
            //                           4 372
            //                           5 63
            //                           6 562;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
                break MISSING_BLOCK_LABEL_562;
_L1:
                flag = anythingElse(token, htmltreebuilder);
_L9:
                return flag;
_L6:
                token = token.asCharacter();
                if (token.getData().equals(HtmlTreeBuilderState.nullString))
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                htmltreebuilder.insert(token);
_L8:
                return true;
_L2:
                htmltreebuilder.insert(token.asComment());
                  goto _L8
_L3:
                htmltreebuilder.error(this);
                return false;
_L4:
                Token.StartTag starttag;
                String s1;
                starttag = token.asStartTag();
                s1 = starttag.name();
                if (s1.equals("html"))
                {
                    return htmltreebuilder.process(starttag, InBody);
                }
                if (s1.equals("option"))
                {
                    htmltreebuilder.process(new Token.EndTag("option"));
                    htmltreebuilder.insert(starttag);
                } else
                {
label0:
                    {
                        if (!s1.equals("optgroup"))
                        {
                            break label0;
                        }
                        if (htmltreebuilder.currentElement().nodeName().equals("option"))
                        {
                            htmltreebuilder.process(new Token.EndTag("option"));
                        } else
                        if (htmltreebuilder.currentElement().nodeName().equals("optgroup"))
                        {
                            htmltreebuilder.process(new Token.EndTag("optgroup"));
                        }
                        htmltreebuilder.insert(starttag);
                    }
                }
                  goto _L8
                if (s1.equals("select"))
                {
                    htmltreebuilder.error(this);
                    return htmltreebuilder.process(new Token.EndTag("select"));
                }
                if (StringUtil.in(s1, new String[] {
            "input", "keygen", "textarea"
        }))
                {
                    htmltreebuilder.error(this);
                    if (htmltreebuilder.inSelectScope("select"))
                    {
                        htmltreebuilder.process(new Token.EndTag("select"));
                        return htmltreebuilder.process(starttag);
                    }
                } else
                if (s1.equals("script"))
                {
                    return htmltreebuilder.process(token, InHead);
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
                  goto _L9
_L5:
                String s = token.asEndTag().name();
                if (s.equals("optgroup"))
                {
                    if (htmltreebuilder.currentElement().nodeName().equals("option") && htmltreebuilder.aboveOnStack(htmltreebuilder.currentElement()) != null && htmltreebuilder.aboveOnStack(htmltreebuilder.currentElement()).nodeName().equals("optgroup"))
                    {
                        htmltreebuilder.process(new Token.EndTag("option"));
                    }
                    if (htmltreebuilder.currentElement().nodeName().equals("optgroup"))
                    {
                        htmltreebuilder.pop();
                    } else
                    {
                        htmltreebuilder.error(this);
                    }
                } else
                if (s.equals("option"))
                {
                    if (htmltreebuilder.currentElement().nodeName().equals("option"))
                    {
                        htmltreebuilder.pop();
                    } else
                    {
                        htmltreebuilder.error(this);
                    }
                } else
                if (s.equals("select"))
                {
                    if (!htmltreebuilder.inSelectScope(s))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    htmltreebuilder.popStackToClose(s);
                    htmltreebuilder.resetInsertionMode();
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
                  goto _L8
                if (!htmltreebuilder.currentElement().nodeName().equals("html"))
                {
                    htmltreebuilder.error(this);
                }
                  goto _L8
            }

        };
        InSelectInTable = new HtmlTreeBuilderState("InSelectInTable", 16) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                boolean flag = false;
                if (token.isStartTag() && StringUtil.in(token.asStartTag().name(), new String[] {
            "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th"
        }))
                {
                    htmltreebuilder.error(this);
                    htmltreebuilder.process(new Token.EndTag("select"));
                    flag = htmltreebuilder.process(token);
                } else
                if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), new String[] {
            "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th"
        }))
                {
                    htmltreebuilder.error(this);
                    if (htmltreebuilder.inTableScope(token.asEndTag().name()))
                    {
                        htmltreebuilder.process(new Token.EndTag("select"));
                        return htmltreebuilder.process(token);
                    }
                } else
                {
                    return htmltreebuilder.process(token, InSelect);
                }
                return flag;
            }

        };
        AfterBody = new HtmlTreeBuilderState("AfterBody", 17) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (HtmlTreeBuilderState.isWhitespace(token))
                {
                    return htmltreebuilder.process(token, InBody);
                }
                if (!token.isComment()) goto _L2; else goto _L1
_L1:
                htmltreebuilder.insert(token.asComment());
_L4:
                return true;
_L2:
                if (token.isDoctype())
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                if (token.isStartTag() && token.asStartTag().name().equals("html"))
                {
                    return htmltreebuilder.process(token, InBody);
                }
                if (!token.isEndTag() || !token.asEndTag().name().equals("html"))
                {
                    break; /* Loop/switch isn't completed */
                }
                if (htmltreebuilder.isFragmentParsing())
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                htmltreebuilder.transition(AfterAfterBody);
                if (true) goto _L4; else goto _L3
_L3:
                if (token.isEOF()) goto _L4; else goto _L5
_L5:
                htmltreebuilder.error(this);
                htmltreebuilder.transition(InBody);
                return htmltreebuilder.process(token);
            }

        };
        InFrameset = new HtmlTreeBuilderState("InFrameset", 18) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (!HtmlTreeBuilderState.isWhitespace(token)) goto _L2; else goto _L1
_L1:
                htmltreebuilder.insert(token.asCharacter());
_L4:
                return true;
_L2:
                if (token.isComment())
                {
                    htmltreebuilder.insert(token.asComment());
                    continue; /* Loop/switch isn't completed */
                }
                if (token.isDoctype())
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                if (token.isStartTag())
                {
                    token = token.asStartTag();
                    String s = token.name();
                    if (s.equals("html"))
                    {
                        return htmltreebuilder.process(token, InBody);
                    }
                    if (s.equals("frameset"))
                    {
                        htmltreebuilder.insert(token);
                    } else
                    if (s.equals("frame"))
                    {
                        htmltreebuilder.insertEmpty(token);
                    } else
                    if (s.equals("noframes"))
                    {
                        return htmltreebuilder.process(token, InHead);
                    } else
                    {
                        htmltreebuilder.error(this);
                        return false;
                    }
                    continue; /* Loop/switch isn't completed */
                }
                if (!token.isEndTag() || !token.asEndTag().name().equals("frameset"))
                {
                    break; /* Loop/switch isn't completed */
                }
                if (htmltreebuilder.currentElement().nodeName().equals("html"))
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                htmltreebuilder.pop();
                if (!htmltreebuilder.isFragmentParsing() && !htmltreebuilder.currentElement().nodeName().equals("frameset"))
                {
                    htmltreebuilder.transition(AfterFrameset);
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (token.isEOF())
                {
                    if (!htmltreebuilder.currentElement().nodeName().equals("html"))
                    {
                        htmltreebuilder.error(this);
                        return true;
                    }
                } else
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                if (true) goto _L4; else goto _L5
_L5:
            }

        };
        AfterFrameset = new HtmlTreeBuilderState("AfterFrameset", 19) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (!HtmlTreeBuilderState.isWhitespace(token)) goto _L2; else goto _L1
_L1:
                htmltreebuilder.insert(token.asCharacter());
_L4:
                return true;
_L2:
                if (token.isComment())
                {
                    htmltreebuilder.insert(token.asComment());
                    continue; /* Loop/switch isn't completed */
                }
                if (token.isDoctype())
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                if (token.isStartTag() && token.asStartTag().name().equals("html"))
                {
                    return htmltreebuilder.process(token, InBody);
                }
                if (!token.isEndTag() || !token.asEndTag().name().equals("html"))
                {
                    break; /* Loop/switch isn't completed */
                }
                htmltreebuilder.transition(AfterAfterFrameset);
                if (true) goto _L4; else goto _L3
_L3:
                if (token.isStartTag() && token.asStartTag().name().equals("noframes"))
                {
                    return htmltreebuilder.process(token, InHead);
                }
                if (!token.isEOF())
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                if (true) goto _L4; else goto _L5
_L5:
            }

        };
        AfterAfterBody = new HtmlTreeBuilderState("AfterAfterBody", 20) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (token.isComment())
                {
                    htmltreebuilder.insert(token.asComment());
                } else
                {
                    if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || token.isStartTag() && token.asStartTag().name().equals("html"))
                    {
                        return htmltreebuilder.process(token, InBody);
                    }
                    if (!token.isEOF())
                    {
                        htmltreebuilder.error(this);
                        htmltreebuilder.transition(InBody);
                        return htmltreebuilder.process(token);
                    }
                }
                return true;
            }

        };
        AfterAfterFrameset = new HtmlTreeBuilderState("AfterAfterFrameset", 21) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                if (token.isComment())
                {
                    htmltreebuilder.insert(token.asComment());
                } else
                {
                    if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || token.isStartTag() && token.asStartTag().name().equals("html"))
                    {
                        return htmltreebuilder.process(token, InBody);
                    }
                    if (!token.isEOF())
                    {
                        if (token.isStartTag() && token.asStartTag().name().equals("noframes"))
                        {
                            return htmltreebuilder.process(token, InHead);
                        } else
                        {
                            htmltreebuilder.error(this);
                            return false;
                        }
                    }
                }
                return true;
            }

        };
        ForeignContent = new HtmlTreeBuilderState("ForeignContent", 22) {

            boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
            {
                return true;
            }

        };
        $VALUES = (new HtmlTreeBuilderState[] {
            Initial, BeforeHtml, BeforeHead, InHead, InHeadNoscript, AfterHead, InBody, Text, InTable, InTableText, 
            InCaption, InColumnGroup, InTableBody, InRow, InCell, InSelect, InSelectInTable, AfterBody, InFrameset, AfterFrameset, 
            AfterAfterBody, AfterAfterFrameset, ForeignContent
        });
    }




}
