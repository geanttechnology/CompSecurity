// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import android.text.Html;
import android.text.TextUtils;
import android.util.Base64;
import com.ebay.nautilus.kernel.io.DirectByteArrayInputStream;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmContentResult, RtmContent, RtmCampaignType

public class RtmHelper
{
    private class parseCampaign
    {

        final RtmHelper this$0;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        public parseCampaign(String s)
        {
            this$0 = RtmHelper.this;
            super();
            try
            {
                parse(new DirectByteArrayInputStream(s.getBytes()));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (RtmHelper rtmhelper)
            {
                printStackTrace();
            }
        }
    }

    private final class parseCampaign.AdDetailsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final RtmContent.Ad ad;
        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("plaAdCampaign".equals(s1))
            {
                return new parseCampaign.PlaDetailsElement(ad);
            }
            if ("textAdCampaign".equals(s1))
            {
                return new parseCampaign.TextDetailsElement(ad);
            }
            if ("googleDFPCampaign".equals(s1))
            {
                rcr.rc.campaign = RtmCampaignType.GOOGLE_DFP_CAMPAIGN;
                return new parseCampaign.GoogleDfpCampaignElement(ad);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public parseCampaign.AdDetailsElement(RtmContent.Ad ad1)
        {
            this$1 = parseCampaign.this;
            super();
            ad = ad1;
        }
    }

    private final class parseCampaign.AdElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final RtmContent.Ad ad;
        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("summary".equals(s1))
            {
                return new parseCampaign.AdSummaryElement(ad);
            }
            if ("details".equals(s1))
            {
                return new parseCampaign.AdDetailsElement(ad);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public parseCampaign.AdElement(RtmContent.Ad ad1)
        {
            this$1 = parseCampaign.this;
            super();
            ad = ad1;
            if (rcr.rc.ads == null)
            {
                rcr.rc.ads = new ArrayList();
            }
            rcr.rc.ads.add(ad1);
        }
    }

    private final class parseCampaign.AdSummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final RtmContent.Ad ad;
        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.AdSummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.title = Html.fromHtml(s.trim()).toString();
                    }

            
            {
                this$2 = parseCampaign.AdSummaryElement.this;
                super();
            }
                };
            }
            if ("subtitle".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.AdSummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.subTitle = Html.fromHtml(s.trim()).toString();
                    }

            
            {
                this$2 = parseCampaign.AdSummaryElement.this;
                super();
            }
                };
            }
            if ("thumbnailURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.AdSummaryElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        ad.thumbnailURL = url;
                    }

            
            {
                this$2 = parseCampaign.AdSummaryElement.this;
                super();
            }
                };
            }
            if ("rtmTrackingURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.AdSummaryElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        ad.trackingURL = url;
                    }

            
            {
                this$2 = parseCampaign.AdSummaryElement.this;
                super();
            }
                };
            }
            if ("ClickId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.AdSummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.trackingClickID = s.trim();
                    }

            
            {
                this$2 = parseCampaign.AdSummaryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public parseCampaign.AdSummaryElement(RtmContent.Ad ad1)
        {
            this$1 = parseCampaign.this;
            super();
            ad = ad1;
        }
    }

    private final class parseCampaign.AdsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Ad".equals(s1))
            {
                return new parseCampaign.AdElement(new RtmContent.Ad());
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.AdsElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("summary".equals(s1))
            {
                return new parseCampaign.SummaryElement();
            }
            if ("details".equals(s1))
            {
                return new parseCampaign.DetailsElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.BodyElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.CelebrityItemsCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.CelebrityItemsCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.detailsTitle = s.trim();
                    }

            
            {
                this$2 = parseCampaign.CelebrityItemsCampaignElement.this;
                super();
            }
                };
            }
            if ("bannerImageURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.CelebrityItemsCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        rcr.rc.bannerImageURL = url;
                    }

            
            {
                this$2 = parseCampaign.CelebrityItemsCampaignElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.CelebrityItemsCampaignElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.DetailsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("downloadAppCampaign".equals(s1))
            {
                rcr.rc.campaign = RtmCampaignType.DOWNLOADAPP_CAMPAIGN;
                return new parseCampaign.DownloadAppCampaignElement();
            }
            if ("htmlCampaign".equals(s1))
            {
                rcr.rc.campaign = RtmCampaignType.HTML_CAMPAIGN;
                return new parseCampaign.HtmlCampaignElement();
            }
            if ("themedSearchCampaign".equals(s1))
            {
                rcr.rc.campaign = RtmCampaignType.THEMED_SEARCH_CAMPAIGN;
                rcr.rc.searchDescriptions = new ArrayList();
                rcr.rc.itemSearchURLs = new ArrayList();
                return new parseCampaign.ThemedSearchCampaignElement();
            }
            if ("celebrityItemsCampaign".equals(s1))
            {
                rcr.rc.campaign = RtmCampaignType.CELEBRITY_ITEMS_CAMPAIGN;
                return new parseCampaign.CelebrityItemsCampaignElement();
            }
            if ("itemListCampaign".equals(s1))
            {
                rcr.rc.campaign = RtmCampaignType.ITEM_LIST_CAMPAIGN;
                rcr.rc.itemIds = new ArrayList();
                return new parseCampaign.ItemListCampaignElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.DetailsElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.DownloadAppCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.DownloadAppCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.detailsTitle = s.trim();
                    }

            
            {
                this$2 = parseCampaign.DownloadAppCampaignElement.this;
                super();
            }
                };
            }
            if ("infoURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.DownloadAppCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        rcr.rc.infoURL = url;
                    }

            
            {
                this$2 = parseCampaign.DownloadAppCampaignElement.this;
                super();
            }
                };
            }
            if ("appStoreURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.DownloadAppCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        rcr.rc.appStoreURL = url;
                    }

            
            {
                this$2 = parseCampaign.DownloadAppCampaignElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.DownloadAppCampaignElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.GoogleDfpCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final RtmContent.Ad ad;
        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("adUnitId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.GoogleDfpCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.adUnitId = s.trim();
                    }

            
            {
                this$2 = parseCampaign.GoogleDfpCampaignElement.this;
                super();
            }
                };
            }
            if ("ppid".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.GoogleDfpCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.ppid = s;
                    }

            
            {
                this$2 = parseCampaign.GoogleDfpCampaignElement.this;
                super();
            }
                };
            }
            if ("adSizeWidth".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final parseCampaign.GoogleDfpCampaignElement this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        ad.adSizeWidth = i;
                    }

            
            {
                this$2 = parseCampaign.GoogleDfpCampaignElement.this;
                super();
            }
                };
            }
            if ("adSizeHeight".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final parseCampaign.GoogleDfpCampaignElement this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        ad.adSizeHeight = i;
                    }

            
            {
                this$2 = parseCampaign.GoogleDfpCampaignElement.this;
                super();
            }
                };
            }
            if ("userTargetedFlag".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final parseCampaign.GoogleDfpCampaignElement this$2;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        ad.userTargeted = flag;
                    }

            
            {
                this$2 = parseCampaign.GoogleDfpCampaignElement.this;
                super();
            }
                };
            }
            if ("parameters".equals(s1))
            {
                return new parseCampaign.ParametersElement(ad);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public parseCampaign.GoogleDfpCampaignElement(RtmContent.Ad ad1)
        {
            this$1 = parseCampaign.this;
            super();
            ad = ad1;
        }
    }

    private final class parseCampaign.HtmlCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.HtmlCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.detailsTitle = s.trim();
                    }

            
            {
                this$2 = parseCampaign.HtmlCampaignElement.this;
                super();
            }
                };
            }
            if ("htmlPageURL".equals(s1))
            {
                if (attributes != null)
                {
                    rcr.rc.ssoScope = attributes.getValue("ssoScope");
                }
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.HtmlCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        rcr.rc.htmlPageURL = url;
                    }

            
            {
                this$2 = parseCampaign.HtmlCampaignElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.HtmlCampaignElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.ItemElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("itemid".equalsIgnoreCase(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.ItemElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.itemIds.add(s.trim());
                    }

            
            {
                this$2 = parseCampaign.ItemElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.ItemElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.ItemListCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equalsIgnoreCase(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.ItemListCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.detailsTitle = s.trim();
                    }

            
            {
                this$2 = parseCampaign.ItemListCampaignElement.this;
                super();
            }
                };
            }
            if ("bannerimageurl".equalsIgnoreCase(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.ItemListCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        rcr.rc.bannerImageURL = url;
                    }

            
            {
                this$2 = parseCampaign.ItemListCampaignElement.this;
                super();
            }
                };
            }
            if ("itemlist".equalsIgnoreCase(s1))
            {
                return new parseCampaign.ItemListElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.ItemListCampaignElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.ItemListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("item".equalsIgnoreCase(s1))
            {
                return new parseCampaign.ItemElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.ItemListElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.ParameterElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final RtmContent.Parameter parameter;
        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("key".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.ParameterElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        parameter.key = s;
                    }

            
            {
                this$2 = parseCampaign.ParameterElement.this;
                super();
            }
                };
            }
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.ParameterElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        parameter.value = s;
                    }

            
            {
                this$2 = parseCampaign.ParameterElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public parseCampaign.ParameterElement(RtmContent.Parameter parameter1)
        {
            this$1 = parseCampaign.this;
            super();
            parameter = parameter1;
        }
    }

    private final class parseCampaign.ParametersElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final RtmContent.Ad ad;
        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("parameter".equals(s1))
            {
                if (ad.parameters == null)
                {
                    ad.parameters = new ArrayList();
                }
                s = new RtmContent.Parameter();
                ad.parameters.add(s);
                return new parseCampaign.ParameterElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public parseCampaign.ParametersElement(RtmContent.Ad ad1)
        {
            this$1 = parseCampaign.this;
            super();
            ad = ad1;
        }
    }

    private final class parseCampaign.PlaDetailsElement extends parseCampaign.TextDetailsElement
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingInfo".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.PlaDetailsElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.shippingInfo = s.trim();
                    }

            
            {
                this$2 = parseCampaign.PlaDetailsElement.this;
                super();
            }
                };
            }
            if ("price".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.PlaDetailsElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.formattedPriceString = s.trim();
                    }

            
            {
                this$2 = parseCampaign.PlaDetailsElement.this;
                super();
            }
                };
            }
            if ("strikethroughPrice".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.PlaDetailsElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.formattedStrikethroughPrice = s.trim();
                    }

            
            {
                this$2 = parseCampaign.PlaDetailsElement.this;
                super();
            }
                };
            }
            if ("retailerName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.PlaDetailsElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.retailerName = Html.fromHtml(s.trim()).toString();
                    }

            
            {
                this$2 = parseCampaign.PlaDetailsElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public parseCampaign.PlaDetailsElement(RtmContent.Ad ad)
        {
            this$1 = parseCampaign.this;
            super(ad);
            ad.isPla = true;
        }
    }

    private final class parseCampaign.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("mobileRTM".equals(s1))
            {
                return new parseCampaign.BodyElement();
            }
            if ("Ads".equals(s1))
            {
                return new parseCampaign.AdsElement();
            }
            if ("summary".equals(s1))
            {
                return new parseCampaign.SummaryElement();
            }
            if ("details".equals(s1))
            {
                return new parseCampaign.DetailsElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.RootElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.SummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.SummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.summaryTitle = s.trim();
                    }

            
            {
                this$2 = parseCampaign.SummaryElement.this;
                super();
            }
                };
            }
            if ("subtitle".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.SummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.summarySubTitle = s.trim();
                    }

            
            {
                this$2 = parseCampaign.SummaryElement.this;
                super();
            }
                };
            }
            if ("thumbnailURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.SummaryElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        rcr.rc.thumbnailURL = url;
                    }

            
            {
                this$2 = parseCampaign.SummaryElement.this;
                super();
            }
                };
            }
            if ("rtmTrackingURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.SummaryElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        rcr.rc.trackingURL = url;
                    }

            
            {
                this$2 = parseCampaign.SummaryElement.this;
                super();
            }
                };
            }
            if ("ClickId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.SummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.trackingClickID = s.trim();
                    }

            
            {
                this$2 = parseCampaign.SummaryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.SummaryElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private class parseCampaign.TextDetailsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected RtmContent.Ad ad;
        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("externalLinkName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.TextDetailsElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.externalLinkName = Html.fromHtml(s.trim()).toString();
                    }

            
            {
                this$2 = parseCampaign.TextDetailsElement.this;
                super();
            }
                };
            }
            if ("externalLink".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.TextDetailsElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        ad.externalLink = url;
                    }

            
            {
                this$2 = parseCampaign.TextDetailsElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public parseCampaign.TextDetailsElement(RtmContent.Ad ad1)
        {
            this$1 = parseCampaign.this;
            super();
            ad = ad1;
        }
    }

    private final class parseCampaign.ThemedSearchCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("listItems".equals(s1))
            {
                return new parseCampaign.ThemedSearchListItemsElement();
            }
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.ThemedSearchCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.detailsTitle = s.trim();
                    }

            
            {
                this$2 = parseCampaign.ThemedSearchCampaignElement.this;
                super();
            }
                };
            }
            if ("bannerImageURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.ThemedSearchCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        rcr.rc.bannerImageURL = url;
                    }

            
            {
                this$2 = parseCampaign.ThemedSearchCampaignElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.ThemedSearchCampaignElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.ThemedSearchListItemElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("searchDescription".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseCampaign.ThemedSearchListItemElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.searchDescriptions.add(s.trim());
                    }

            
            {
                this$2 = parseCampaign.ThemedSearchListItemElement.this;
                super();
            }
                };
            }
            if ("itemSearchURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final parseCampaign.ThemedSearchListItemElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        rcr.rc.itemSearchURLs.add(url);
                    }

            
            {
                this$2 = parseCampaign.ThemedSearchListItemElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.ThemedSearchListItemElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private final class parseCampaign.ThemedSearchListItemsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("listItem".equals(s1))
            {
                return new parseCampaign.ThemedSearchListItemElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseCampaign.ThemedSearchListItemsElement()
        {
            this$1 = parseCampaign.this;
            super();
        }

    }

    private class parseDecodedBase64
    {

        final RtmHelper this$0;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        public parseDecodedBase64(String s)
        {
            this$0 = RtmHelper.this;
            super();
            try
            {
                parse(new DirectByteArrayInputStream(s.getBytes()));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (RtmHelper rtmhelper)
            {
                printStackTrace();
            }
        }
    }

    private final class parseDecodedBase64.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseDecodedBase64 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("MessageId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseDecodedBase64.BodyElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.messageId = s;
                    }

            
            {
                this$2 = parseDecodedBase64.BodyElement.this;
                super();
            }
                };
            }
            if ("CampaignId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseDecodedBase64.BodyElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.campaignId = s;
                    }

            
            {
                this$2 = parseDecodedBase64.BodyElement.this;
                super();
            }
                };
            }
            if ("Content".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final parseDecodedBase64.BodyElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.rc.rawContent = s;
                    }

            
            {
                this$2 = parseDecodedBase64.BodyElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseDecodedBase64.BodyElement()
        {
            this$1 = parseDecodedBase64.this;
            super();
        }

    }

    private final class parseDecodedBase64.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final parseDecodedBase64 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Placement".equals(s1))
            {
                int j = attributes.getLength();
                for (int i = 0; i < j; i++)
                {
                    if ("id".equals(attributes.getLocalName(i)))
                    {
                        rcr.rc.placement = attributes.getValue(i);
                    }
                }

                return new parseDecodedBase64.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private parseDecodedBase64.RootElement()
        {
            this$1 = parseDecodedBase64.this;
            super();
        }

    }


    public static final String RTM_DOWNLOAD_URL = "downloadUrl";
    public static final String RTM_ITEM_SEARCH_URLS = "itemSearchURLs";
    public static final String RTM_SEARCH_DESCRIPTIONS = "searchDescriptions";
    public static final String RTM_SSO_SCOPE = "ssoScope";
    public static final String RTM_URL = "url";
    private RtmContentResult rcr;
    private String rtmCampaignKillList;
    private boolean rtmWasDownloaded;

    public RtmHelper(RtmContentResult rtmcontentresult, String s)
    {
        rtmCampaignKillList = null;
        rcr = null;
        rtmWasDownloaded = false;
        rcr = rtmcontentresult;
        rtmCampaignKillList = s;
        if (rcr != null && !TextUtils.isEmpty(rcr.rtmContentBase64))
        {
            rcr.rc = new RtmContent();
            rtmcontentresult = new String(Base64.decode(rcr.rtmContentBase64, 0));
            if (!TextUtils.isEmpty(rtmcontentresult))
            {
                new parseDecodedBase64(rtmcontentresult);
                if (!TextUtils.isEmpty(rcr.rc.rawContent))
                {
                    new parseCampaign(rcr.rc.rawContent);
                    if (!TextUtils.isEmpty(rcr.rc.summaryTitle) && rcr.rc.thumbnailURL != null)
                    {
                        rtmWasDownloaded = true;
                    }
                }
            }
        } else
        if (rcr != null && TextUtils.isEmpty(rcr.rtmContentBase64))
        {
            return;
        }
    }

    public ArrayList getAds()
    {
        if (rcr != null && rcr.rc != null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = null;
_L4:
        return arraylist;
_L2:
        ArrayList arraylist1;
        arraylist1 = rcr.rc.ads;
        if (arraylist1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist = arraylist1;
        if (!arraylist1.isEmpty()) goto _L4; else goto _L3
_L3:
        return null;
    }

    public RtmCampaignType getCampaign()
    {
label0:
        {
            if (!rtmWasDownloaded || rcr == null || rcr.rc == null || TextUtils.isEmpty(rcr.rc.campaignId))
            {
                return RtmCampaignType.UNDEFINED_CAMPAIGN;
            }
            if (TextUtils.isEmpty(rtmCampaignKillList) || rtmCampaignKillList.length() <= 1)
            {
                break label0;
            }
            Iterator iterator = Arrays.asList((new String(rtmCampaignKillList)).split(",")).iterator();
            String s;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                s = ((String)iterator.next()).trim();
            } while (!rcr.rc.campaignId.equalsIgnoreCase(s));
            return RtmCampaignType.UNDEFINED_CAMPAIGN;
        }
        return rcr.rc.campaign;
    }

    public String getCampaignId()
    {
        if (rcr == null || rcr.rc == null)
        {
            return null;
        } else
        {
            return rcr.rc.campaignId;
        }
    }

    public ArrayList getItemIds()
    {
        Object obj = null;
        ArrayList arraylist = obj;
        if (rcr != null)
        {
            arraylist = obj;
            if (rcr.rc != null)
            {
                arraylist = rcr.rc.itemIds;
            }
        }
        return arraylist;
    }

}
