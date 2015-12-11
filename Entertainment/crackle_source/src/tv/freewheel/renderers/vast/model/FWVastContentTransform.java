// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import tv.freewheel.utils.Logger;

public class FWVastContentTransform
{

    public static final String FW_VAST_AD_CREATIVE_HEIGHT_MACRO = "#{ad.creative.height}";
    public static final String FW_VAST_AD_CREATIVE_MARGIN_HEIGHT_MACRO = "#{ad.creative.marginHeight}";
    public static final String FW_VAST_AD_CREATIVE_MARGIN_WIDTH_MACRO = "#{ad.creative.marginWidth}";
    public static final String FW_VAST_AD_CREATIVE_WIDTH_MACRO = "#{ad.creative.width}";
    public static final String FW_VAST_ALT_TEXT = "#{altText_VAST}";
    public static final String FW_VAST_CONTENT_MACRO = "#{content}";
    public static final String FW_VAST_DEFAULT_CLICK_URL_MACRO = "#{click(\"defaultClick\")}";
    public static final String FW_VAST_JS_CLICK_ARRAY_MACRO = "#{jsClickArray}";
    public static final String FW_VAST_REQUEST_PAGE_URL_MACRO = "#j{request.pageUrl}";
    public static final String FW_VAST_SLOT_SAFE_ID_MACRO = "#{slot.safeId}";
    private static FWVastContentTransform instance;
    private static Logger logger = Logger.getLogger("FWVastContentTransform");
    private HashMap macros;

    private FWVastContentTransform()
    {
        macros = new HashMap();
    }

    public static void clearMacros()
    {
        instance.macros.clear();
        instance.setDefaultMacros();
    }

    public static String injectCallback(String s, String s1, ArrayList arraylist, String s2)
    {
        clearMacros();
        String s3 = s1;
        if (s1 == null)
        {
            s3 = "#";
        }
        instance.macros.put("#{click(\"defaultClick\")}", s3);
        s1 = s2;
        if (s2 == null)
        {
            s1 = (new StringBuilder()).append("").append((int)(Math.random() * 1000000D)).toString();
        }
        instance.macros.put("#{slot.safeId}", s1);
        s1 = "{}";
        if (arraylist.size() > 0)
        {
            s1 = null;
            arraylist = arraylist.iterator();
            while (arraylist.hasNext()) 
            {
                s2 = (String)arraylist.next();
                if (s1 == null)
                {
                    s1 = new StringBuffer("[");
                } else
                {
                    s1.append(",");
                }
                s1.append((new StringBuilder()).append("\"").append(s2).append("\"").toString());
            }
            s1.append("]");
            s1 = (new StringBuilder()).append("[{\"name\":\"defaultClick\",\"url\":\"").append(s3).append("\",\"trackingURLs\":").append(s1.toString()).append("}]").toString();
        }
        instance.macros.put("#{jsClickArray}", s1);
        instance.applyMacros(s);
        logger.debug((new StringBuilder()).append("The defaultClick:").append(s3).append(", trackingURLs:").append(s1).append(" are injected").toString());
        s = instance.retrieveContent();
        clearMacros();
        return s;
    }

    public static void setMarco(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            return;
        } else
        {
            instance.macros.put(s, s1);
            return;
        }
    }

    private static void setRequestPageURL(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        instance.macros.put("#j{request.pageUrl}", s1);
    }

    public static String text_html_TO_text_html_doc_lit_mobile(String s)
    {
        setRequestPageURL(null);
        return instance.injectContent(s).HTMLLit_to_HTMLLit_deco().HTMLLit_to_HTMLDocLit_mobile().retrieveContent();
    }

    public static String text_javascript_TO_text_html_doc_lit_mobile(String s)
    {
        setRequestPageURL(null);
        return instance.injectContent(s).JSLit_to_HTMLLit().HTMLLit_to_HTMLLit_deco().HTMLLit_to_HTMLDocLit_mobile().retrieveContent();
    }

    public static String text_js_ref_TO_text_html_doc_lit_mobile(String s)
    {
        setRequestPageURL(null);
        return instance.injectContent(s).JSRef_to_HTMLLit().HTMLLit_to_HTMLLit_deco().HTMLLit_to_HTMLDocLit_mobile().retrieveContent();
    }

    FWVastContentTransform HTMLLit_to_HTMLDocLit_mobile()
    {
        return applyMacros("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta name = \"viewport\" content = \"initial-scale = 1.0\" /><title>Advertisement</title><script type=\"text/javascript\">window._fw_page_url = \"#j{request.pageUrl}\";</script></head><body style=\"margin:0px;background-color:transparent;\">#{content}</body></html>");
    }

    FWVastContentTransform HTMLLit_to_HTMLLit_deco()
    {
        return applyMacros("<span style=\"display:inline-block; vertical-align:top; margin:#{ad.creative.marginHeight}px #{ad.creative.marginWidth}px #{ad.creative.marginHeight}px #{ad.creative.marginWidth}px;\">#{content}</span>");
    }

    FWVastContentTransform JSLit_to_HTMLLit()
    {
        return applyMacros("<script type=\"text/javascript\" language=\"javascript\">//<!--\n#{content}//--></script>");
    }

    FWVastContentTransform JSRef_to_HTMLLit()
    {
        return applyMacros("<script src=\"#{content}\" type=\"text/javascript\" language=\"javascript\"></script>");
    }

    FWVastContentTransform applyMacros(String s)
    {
        logger.debug("applyMacros");
        if (s == null || s.length() == 0)
        {
            return this;
        }
        s = new StringBuffer(s);
        for (Iterator iterator = macros.keySet().iterator(); iterator.hasNext();)
        {
            String s2 = (String)iterator.next();
            Object obj = (String)macros.get(s2);
            String s1 = ((String) (obj));
            if (s2.startsWith("#j{"))
            {
                s1 = jsescape(((String) (obj)));
            }
            int j = 0;
            int i = s.indexOf(s2);
            obj = new StringBuffer();
            for (; i > 0; i = s.indexOf(s2, j))
            {
                ((StringBuffer) (obj)).append(s.substring(j, i));
                ((StringBuffer) (obj)).append(s1);
                j = i + s2.length();
            }

            ((StringBuffer) (obj)).append(s.substring(j));
            s = ((String) (obj));
        }

        injectContent(s.toString());
        return this;
    }

    FWVastContentTransform injectContent(String s)
    {
        if (s != null && s.trim().length() != 0)
        {
            macros.put("#{content}", s);
        }
        return this;
    }

    String jsescape(String s)
    {
        StringBuffer stringbuffer;
        int i;
        if (s == null)
        {
            return null;
        }
        stringbuffer = new StringBuffer();
        i = 0;
_L12:
        char c;
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_230;
        }
        c = s.charAt(i);
        c;
        JVM INSTR lookupswitch 9: default 116
    //                   8: 208
    //                   9: 197
    //                   10: 186
    //                   12: 219
    //                   13: 175
    //                   34: 142
    //                   38: 153
    //                   39: 131
    //                   92: 164;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        break MISSING_BLOCK_LABEL_219;
_L9:
        break; /* Loop/switch isn't completed */
_L1:
        stringbuffer.append(c);
_L13:
        i++;
        if (true) goto _L12; else goto _L11
_L11:
        stringbuffer.append("\\'");
          goto _L13
_L7:
        stringbuffer.append("\\\"");
          goto _L13
_L8:
        stringbuffer.append("\\&");
          goto _L13
_L10:
        stringbuffer.append("\\\\");
          goto _L13
_L6:
        stringbuffer.append("\\r");
          goto _L13
_L4:
        stringbuffer.append("\\n");
          goto _L13
_L3:
        stringbuffer.append("\\t");
          goto _L13
_L2:
        stringbuffer.append("\\b");
          goto _L13
        stringbuffer.append("\\f");
          goto _L13
        return stringbuffer.toString();
    }

    String retrieveContent()
    {
        String s = (String)macros.get("#{content}");
        macros.remove("#{content}");
        return s;
    }

    void setDefaultMacros()
    {
        macros.put("#{ad.creative.marginWidth}", "0");
        macros.put("#{ad.creative.marginHeight}", "0");
    }

    static 
    {
        instance = null;
        instance = new FWVastContentTransform();
        instance.setDefaultMacros();
    }
}
