// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilder, ParseErrorList, TreeBuilder, XmlTreeBuilder

public class Parser
{

    private static final int DEFAULT_MAX_ERRORS = 0;
    private ParseErrorList errors;
    private int maxErrors;
    private TreeBuilder treeBuilder;

    public Parser(TreeBuilder treebuilder)
    {
        maxErrors = 0;
        treeBuilder = treebuilder;
    }

    public static Parser htmlParser()
    {
        return new Parser(new HtmlTreeBuilder());
    }

    public static Document parse(String s, String s1)
    {
        return (new HtmlTreeBuilder()).parse(s, s1, ParseErrorList.noTracking());
    }

    public static Document parseBodyFragment(String s, String s1)
    {
        Document document = Document.createShell(s1);
        Element element = document.body();
        s = parseFragment(s, element, s1);
        s = (Node[])s.toArray(new Node[s.size()]);
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            element.appendChild(s[i]);
        }

        return document;
    }

    public static Document parseBodyFragmentRelaxed(String s, String s1)
    {
        return parse(s, s1);
    }

    public static List parseFragment(String s, Element element, String s1)
    {
        return (new HtmlTreeBuilder()).parseFragment(s, element, s1, ParseErrorList.noTracking());
    }

    public static Parser xmlParser()
    {
        return new Parser(new XmlTreeBuilder());
    }

    public List getErrors()
    {
        return errors;
    }

    public TreeBuilder getTreeBuilder()
    {
        return treeBuilder;
    }

    public boolean isTrackErrors()
    {
        return maxErrors > 0;
    }

    public Document parseInput(String s, String s1)
    {
        ParseErrorList parseerrorlist;
        if (isTrackErrors())
        {
            parseerrorlist = ParseErrorList.tracking(maxErrors);
        } else
        {
            parseerrorlist = ParseErrorList.noTracking();
        }
        errors = parseerrorlist;
        return treeBuilder.parse(s, s1, errors);
    }

    public Parser setTrackErrors(int i)
    {
        maxErrors = i;
        return this;
    }

    public Parser setTreeBuilder(TreeBuilder treebuilder)
    {
        treeBuilder = treebuilder;
        return this;
    }
}
