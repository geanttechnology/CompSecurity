// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import android.text.Html;
import com.ebay.nautilus.kernel.io.DirectByteArrayInputStream;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper, RtmContentResult, RtmCampaignType, RtmContent

private class intStackTrace
{
    private final class AdDetailsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final RtmContent.Ad ad;
        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("plaAdCampaign".equals(s1))
            {
                return new PlaDetailsElement(ad);
            }
            if ("textAdCampaign".equals(s1))
            {
                return new TextDetailsElement(ad);
            }
            if ("googleDFPCampaign".equals(s1))
            {
                RtmHelper.access$100(this$0).rc.campaign = RtmCampaignType.GOOGLE_DFP_CAMPAIGN;
                return new GoogleDfpCampaignElement(ad);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public AdDetailsElement(RtmContent.Ad ad1)
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
            ad = ad1;
        }
    }

    private final class AdElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final RtmContent.Ad ad;
        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("summary".equals(s1))
            {
                return new AdSummaryElement(ad);
            }
            if ("details".equals(s1))
            {
                return new AdDetailsElement(ad);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public AdElement(RtmContent.Ad ad1)
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
            ad = ad1;
            if (RtmHelper.access$100(this$0).rc.ads == null)
            {
                RtmHelper.access$100(this$0).rc.ads = new ArrayList();
            }
            RtmHelper.access$100(this$0).rc.ads.add(ad1);
        }
    }

    private final class AdSummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final RtmContent.Ad ad;
        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AdSummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.title = Html.fromHtml(s.trim()).toString();
                    }

            
            {
                this$2 = AdSummaryElement.this;
                super();
            }
                };
            }
            if ("subtitle".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AdSummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.subTitle = Html.fromHtml(s.trim()).toString();
                    }

            
            {
                this$2 = AdSummaryElement.this;
                super();
            }
                };
            }
            if ("thumbnailURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final AdSummaryElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        ad.thumbnailURL = url;
                    }

            
            {
                this$2 = AdSummaryElement.this;
                super();
            }
                };
            }
            if ("rtmTrackingURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final AdSummaryElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        ad.trackingURL = url;
                    }

            
            {
                this$2 = AdSummaryElement.this;
                super();
            }
                };
            }
            if ("ClickId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AdSummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.trackingClickID = s.trim();
                    }

            
            {
                this$2 = AdSummaryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public AdSummaryElement(RtmContent.Ad ad1)
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
            ad = ad1;
        }
    }

    private final class AdsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Ad".equals(s1))
            {
                return new AdElement(new RtmContent.Ad());
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private AdsElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        AdsElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("summary".equals(s1))
            {
                return new SummaryElement(null);
            }
            if ("details".equals(s1))
            {
                return new DetailsElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        BodyElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class CelebrityItemsCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final CelebrityItemsCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.detailsTitle = s.trim();
                    }

            
            {
                this$2 = CelebrityItemsCampaignElement.this;
                super();
            }
                };
            }
            if ("bannerImageURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final CelebrityItemsCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.bannerImageURL = url;
                    }

            
            {
                this$2 = CelebrityItemsCampaignElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private CelebrityItemsCampaignElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        CelebrityItemsCampaignElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class DetailsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("downloadAppCampaign".equals(s1))
            {
                RtmHelper.access$100(this$0).rc.campaign = RtmCampaignType.DOWNLOADAPP_CAMPAIGN;
                return new DownloadAppCampaignElement(null);
            }
            if ("htmlCampaign".equals(s1))
            {
                RtmHelper.access$100(this$0).rc.campaign = RtmCampaignType.HTML_CAMPAIGN;
                return new HtmlCampaignElement(null);
            }
            if ("themedSearchCampaign".equals(s1))
            {
                RtmHelper.access$100(this$0).rc.campaign = RtmCampaignType.THEMED_SEARCH_CAMPAIGN;
                RtmHelper.access$100(this$0).rc.searchDescriptions = new ArrayList();
                RtmHelper.access$100(this$0).rc.itemSearchURLs = new ArrayList();
                return new ThemedSearchCampaignElement(null);
            }
            if ("celebrityItemsCampaign".equals(s1))
            {
                RtmHelper.access$100(this$0).rc.campaign = RtmCampaignType.CELEBRITY_ITEMS_CAMPAIGN;
                return new CelebrityItemsCampaignElement(null);
            }
            if ("itemListCampaign".equals(s1))
            {
                RtmHelper.access$100(this$0).rc.campaign = RtmCampaignType.ITEM_LIST_CAMPAIGN;
                RtmHelper.access$100(this$0).rc.itemIds = new ArrayList();
                return new ItemListCampaignElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private DetailsElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        DetailsElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class DownloadAppCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final DownloadAppCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.detailsTitle = s.trim();
                    }

            
            {
                this$2 = DownloadAppCampaignElement.this;
                super();
            }
                };
            }
            if ("infoURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final DownloadAppCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.infoURL = url;
                    }

            
            {
                this$2 = DownloadAppCampaignElement.this;
                super();
            }
                };
            }
            if ("appStoreURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final DownloadAppCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.appStoreURL = url;
                    }

            
            {
                this$2 = DownloadAppCampaignElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private DownloadAppCampaignElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        DownloadAppCampaignElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class GoogleDfpCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final RtmContent.Ad ad;
        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("adUnitId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GoogleDfpCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.adUnitId = s.trim();
                    }

            
            {
                this$2 = GoogleDfpCampaignElement.this;
                super();
            }
                };
            }
            if ("ppid".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GoogleDfpCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.ppid = s;
                    }

            
            {
                this$2 = GoogleDfpCampaignElement.this;
                super();
            }
                };
            }
            if ("adSizeWidth".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GoogleDfpCampaignElement this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        ad.adSizeWidth = i;
                    }

            
            {
                this$2 = GoogleDfpCampaignElement.this;
                super();
            }
                };
            }
            if ("adSizeHeight".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GoogleDfpCampaignElement this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        ad.adSizeHeight = i;
                    }

            
            {
                this$2 = GoogleDfpCampaignElement.this;
                super();
            }
                };
            }
            if ("userTargetedFlag".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GoogleDfpCampaignElement this$2;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        ad.userTargeted = flag;
                    }

            
            {
                this$2 = GoogleDfpCampaignElement.this;
                super();
            }
                };
            }
            if ("parameters".equals(s1))
            {
                return new ParametersElement(ad);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public GoogleDfpCampaignElement(RtmContent.Ad ad1)
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
            ad = ad1;
        }
    }

    private final class HtmlCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final HtmlCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.detailsTitle = s.trim();
                    }

            
            {
                this$2 = HtmlCampaignElement.this;
                super();
            }
                };
            }
            if ("htmlPageURL".equals(s1))
            {
                if (attributes != null)
                {
                    RtmHelper.access$100(this$0).rc.ssoScope = attributes.getValue("ssoScope");
                }
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final HtmlCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.htmlPageURL = url;
                    }

            
            {
                this$2 = HtmlCampaignElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private HtmlCampaignElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        HtmlCampaignElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ItemElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("itemid".equalsIgnoreCase(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.itemIds.add(s.trim());
                    }

            
            {
                this$2 = ItemElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ItemElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        ItemElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ItemListCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equalsIgnoreCase(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemListCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.detailsTitle = s.trim();
                    }

            
            {
                this$2 = ItemListCampaignElement.this;
                super();
            }
                };
            }
            if ("bannerimageurl".equalsIgnoreCase(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final ItemListCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.bannerImageURL = url;
                    }

            
            {
                this$2 = ItemListCampaignElement.this;
                super();
            }
                };
            }
            if ("itemlist".equalsIgnoreCase(s1))
            {
                return new ItemListElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ItemListCampaignElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        ItemListCampaignElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ItemListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("item".equalsIgnoreCase(s1))
            {
                return new ItemElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ItemListElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        ItemListElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ParameterElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final RtmContent.Parameter parameter;
        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("key".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ParameterElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        parameter.key = s;
                    }

            
            {
                this$2 = ParameterElement.this;
                super();
            }
                };
            }
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ParameterElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        parameter.value = s;
                    }

            
            {
                this$2 = ParameterElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public ParameterElement(RtmContent.Parameter parameter1)
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
            parameter = parameter1;
        }
    }

    private final class ParametersElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final RtmContent.Ad ad;
        final RtmHelper.parseCampaign this$1;

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
                return new ParameterElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ParametersElement(RtmContent.Ad ad1)
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
            ad = ad1;
        }
    }

    private final class PlaDetailsElement extends TextDetailsElement
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingInfo".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PlaDetailsElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.shippingInfo = s.trim();
                    }

            
            {
                this$2 = PlaDetailsElement.this;
                super();
            }
                };
            }
            if ("price".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PlaDetailsElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.formattedPriceString = s.trim();
                    }

            
            {
                this$2 = PlaDetailsElement.this;
                super();
            }
                };
            }
            if ("strikethroughPrice".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PlaDetailsElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.formattedStrikethroughPrice = s.trim();
                    }

            
            {
                this$2 = PlaDetailsElement.this;
                super();
            }
                };
            }
            if ("retailerName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PlaDetailsElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.retailerName = Html.fromHtml(s.trim()).toString();
                    }

            
            {
                this$2 = PlaDetailsElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public PlaDetailsElement(RtmContent.Ad ad)
        {
            this$1 = RtmHelper.parseCampaign.this;
            super(ad);
            ad.isPla = true;
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("mobileRTM".equals(s1))
            {
                return new BodyElement(null);
            }
            if ("Ads".equals(s1))
            {
                return new AdsElement(null);
            }
            if ("summary".equals(s1))
            {
                return new SummaryElement(null);
            }
            if ("details".equals(s1))
            {
                return new DetailsElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        RootElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class SummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.summaryTitle = s.trim();
                    }

            
            {
                this$2 = SummaryElement.this;
                super();
            }
                };
            }
            if ("subtitle".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.summarySubTitle = s.trim();
                    }

            
            {
                this$2 = SummaryElement.this;
                super();
            }
                };
            }
            if ("thumbnailURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final SummaryElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.thumbnailURL = url;
                    }

            
            {
                this$2 = SummaryElement.this;
                super();
            }
                };
            }
            if ("rtmTrackingURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final SummaryElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.trackingURL = url;
                    }

            
            {
                this$2 = SummaryElement.this;
                super();
            }
                };
            }
            if ("ClickId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SummaryElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.trackingClickID = s.trim();
                    }

            
            {
                this$2 = SummaryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SummaryElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        SummaryElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private class TextDetailsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected RtmContent.Ad ad;
        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("externalLinkName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final TextDetailsElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        ad.externalLinkName = Html.fromHtml(s.trim()).toString();
                    }

            
            {
                this$2 = TextDetailsElement.this;
                super();
            }
                };
            }
            if ("externalLink".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final TextDetailsElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        ad.externalLink = url;
                    }

            
            {
                this$2 = TextDetailsElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public TextDetailsElement(RtmContent.Ad ad1)
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
            ad = ad1;
        }
    }

    private final class ThemedSearchCampaignElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("listItems".equals(s1))
            {
                return new ThemedSearchListItemsElement(null);
            }
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ThemedSearchCampaignElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.detailsTitle = s.trim();
                    }

            
            {
                this$2 = ThemedSearchCampaignElement.this;
                super();
            }
                };
            }
            if ("bannerImageURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final ThemedSearchCampaignElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.bannerImageURL = url;
                    }

            
            {
                this$2 = ThemedSearchCampaignElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ThemedSearchCampaignElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        ThemedSearchCampaignElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ThemedSearchListItemElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("searchDescription".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ThemedSearchListItemElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.searchDescriptions.add(s.trim());
                    }

            
            {
                this$2 = ThemedSearchListItemElement.this;
                super();
            }
                };
            }
            if ("itemSearchURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final ThemedSearchListItemElement this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.itemSearchURLs.add(url);
                    }

            
            {
                this$2 = ThemedSearchListItemElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ThemedSearchListItemElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        ThemedSearchListItemElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ThemedSearchListItemsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseCampaign this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("listItem".equals(s1))
            {
                return new ThemedSearchListItemElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ThemedSearchListItemsElement()
        {
            this$1 = RtmHelper.parseCampaign.this;
            super();
        }

        ThemedSearchListItemsElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }


    final RtmHelper this$0;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.ataException
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }

    public ThemedSearchListItemsElement(String s)
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
