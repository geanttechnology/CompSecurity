// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.view.BusinessMapDetailedSlice;
import com.groupon.view.ObservableScrollView;
import com.groupon.view.SpinnerButton;
import com.groupon.view.UrlImageView;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage, GrouponActivity

public class _cls9 extends _cls9
{

    public void bind(butterknife.ewBinder ewbinder, BusinessDetailPage businessdetailpage, Object obj)
    {
        super.d(ewbinder, businessdetailpage, obj);
        businessdetailpage.businessImage = (UrlImageView)ewbinder.inessImage((View)ewbinder.View(obj, 0x7f100129, "field 'businessImage'"), 0x7f100129, "field 'businessImage'");
        businessdetailpage.scrollView = (ObservableScrollView)ewbinder.ollView((View)ewbinder.View(obj, 0x7f10012a, "field 'scrollView'"), 0x7f10012a, "field 'scrollView'");
        businessdetailpage.businessTitle = (TextView)ewbinder.inessTitle((View)ewbinder.View(obj, 0x7f10007a, "field 'businessTitle'"), 0x7f10007a, "field 'businessTitle'");
        businessdetailpage.offersContainer = (LinearLayout)ewbinder.ersContainer((View)ewbinder.View(obj, 0x7f10013e, "field 'offersContainer'"), 0x7f10013e, "field 'offersContainer'");
        businessdetailpage.offersHeader = (TextView)ewbinder.ersHeader((View)ewbinder.View(obj, 0x7f100133, "field 'offersHeader'"), 0x7f100133, "field 'offersHeader'");
        businessdetailpage.openCloseTextView = (TextView)ewbinder.nCloseTextView((View)ewbinder.View(obj, 0x7f100131, "field 'openCloseTextView'"), 0x7f100131, "field 'openCloseTextView'");
        businessdetailpage.tipsContainer = (LinearLayout)ewbinder.sContainer((View)ewbinder.View(obj, 0x7f100146, "field 'tipsContainer'"), 0x7f100146, "field 'tipsContainer'");
        businessdetailpage.hoursContainer = (LinearLayout)ewbinder.rsContainer((View)ewbinder.View(obj, 0x7f100140, "field 'hoursContainer'"), 0x7f100140, "field 'hoursContainer'");
        businessdetailpage.mapSlice = (BusinessMapDetailedSlice)ewbinder.Slice((View)ewbinder.View(obj, 0x7f10013f, "field 'mapSlice'"), 0x7f10013f, "field 'mapSlice'");
        businessdetailpage.businessContent = (RelativeLayout)ewbinder.inessContent((View)ewbinder.View(obj, 0x7f100128, "field 'businessContent'"), 0x7f100128, "field 'businessContent'");
        businessdetailpage.progressBar = (ProgressBar)ewbinder.gressBar((View)ewbinder.View(obj, 0x7f10010b, "field 'progressBar'"), 0x7f10010b, "field 'progressBar'");
        businessdetailpage.requestDealButton = (SpinnerButton)ewbinder.uestDealButton((View)ewbinder.View(obj, 0x7f100135, "field 'requestDealButton'"), 0x7f100135, "field 'requestDealButton'");
        businessdetailpage.requestDealContainer = (LinearLayout)ewbinder.uestDealContainer((View)ewbinder.View(obj, 0x7f100134, "field 'requestDealContainer'"), 0x7f100134, "field 'requestDealContainer'");
        businessdetailpage.requestDealCompletedContainer = (LinearLayout)ewbinder.uestDealCompletedContainer((View)ewbinder.View(obj, 0x7f100137, "field 'requestDealCompletedContainer'"), 0x7f100137, "field 'requestDealCompletedContainer'");
        businessdetailpage.requestDealCompletedFeedbackContainer = (LinearLayout)ewbinder.uestDealCompletedFeedbackContainer((View)ewbinder.View(obj, 0x7f100138, "field 'requestDealCompletedFeedbackContainer'"), 0x7f100138, "field 'requestDealCompletedFeedbackContainer'");
        businessdetailpage.requestDealRequestedContainer = (LinearLayout)ewbinder.uestDealRequestedContainer((View)ewbinder.View(obj, 0x7f10013c, "field 'requestDealRequestedContainer'"), 0x7f10013c, "field 'requestDealRequestedContainer'");
        businessdetailpage.editorsContainer = (LinearLayout)ewbinder.torsContainer((View)ewbinder.View(obj, 0x7f100147, "field 'editorsContainer'"), 0x7f100147, "field 'editorsContainer'");
        businessdetailpage.customerRecommend = (LinearLayout)ewbinder.tomerRecommend((View)ewbinder.View(obj, 0x7f10012d, "field 'customerRecommend'"), 0x7f10012d, "field 'customerRecommend'");
        businessdetailpage.totalPeopleRatedTextView = (TextView)ewbinder.alPeopleRatedTextView((View)ewbinder.View(obj, 0x7f10012f, "field 'totalPeopleRatedTextView'"), 0x7f10012f, "field 'totalPeopleRatedTextView'");
        businessdetailpage.percentPeopleRatedTextView = (TextView)ewbinder.centPeopleRatedTextView((View)ewbinder.View(obj, 0x7f10012e, "field 'percentPeopleRatedTextView'"), 0x7f10012e, "field 'percentPeopleRatedTextView'");
        businessdetailpage.xPeopleSignedUpTextView = (TextView)ewbinder.opleSignedUpTextView((View)ewbinder.View(obj, 0x7f100136, "field 'xPeopleSignedUpTextView'"), 0x7f100136, "field 'xPeopleSignedUpTextView'");
        businessdetailpage.xPeopleSignedUpCompletedTextView = (TextView)ewbinder.opleSignedUpCompletedTextView((View)ewbinder.View(obj, 0x7f10013b, "field 'xPeopleSignedUpCompletedTextView'"), 0x7f10013b, "field 'xPeopleSignedUpCompletedTextView'");
        businessdetailpage.xPeopleSignedUpRequestedTextView = (TextView)ewbinder.opleSignedUpRequestedTextView((View)ewbinder.View(obj, 0x7f10013d, "field 'xPeopleSignedUpRequestedTextView'"), 0x7f10013d, "field 'xPeopleSignedUpRequestedTextView'");
        businessdetailpage.editors = (WebView)ewbinder.tors((View)ewbinder.View(obj, 0x7f100148, "field 'editors'"), 0x7f100148, "field 'editors'");
        businessdetailpage.categorizations = (TextView)ewbinder.egorizations((View)ewbinder.View(obj, 0x7f100130, "field 'categorizations'"), 0x7f100130, "field 'categorizations'");
        businessdetailpage.ratingsContainer = (LinearLayout)ewbinder.ingsContainer((View)ewbinder.View(obj, 0x7f100141, "field 'ratingsContainer'"), 0x7f100141, "field 'ratingsContainer'");
        businessdetailpage.wouldYouRecommend = (TextView)ewbinder.ldYouRecommend((View)ewbinder.View(obj, 0x7f100142, "field 'wouldYouRecommend'"), 0x7f100142, "field 'wouldYouRecommend'");
        businessdetailpage.customerRatingRecommend = (TextView)ewbinder.tomerRatingRecommend((View)ewbinder.View(obj, 0x7f100143, "field 'customerRatingRecommend'"), 0x7f100143, "field 'customerRatingRecommend'");
        businessdetailpage.thumbUp = (FrameLayout)ewbinder.mbUp((View)ewbinder.View(obj, 0x7f100144, "field 'thumbUp'"), 0x7f100144, "field 'thumbUp'");
        businessdetailpage.thumbDown = (FrameLayout)ewbinder.mbDown((View)ewbinder.View(obj, 0x7f100145, "field 'thumbDown'"), 0x7f100145, "field 'thumbDown'");
        businessdetailpage.businessHeaderContainer = (LinearLayout)ewbinder.inessHeaderContainer((View)ewbinder.View(obj, 0x7f10012c, "field 'businessHeaderContainer'"), 0x7f10012c, "field 'businessHeaderContainer'");
        businessdetailpage.businessHeaderParentContainer = (RelativeLayout)ewbinder.inessHeaderParentContainer((View)ewbinder.View(obj, 0x7f10012b, "field 'businessHeaderParentContainer'"), 0x7f10012b, "field 'businessHeaderParentContainer'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (BusinessDetailPage)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (BusinessDetailPage)obj, obj1);
    }

    public void unbind(BusinessDetailPage businessdetailpage)
    {
        super.ind(businessdetailpage);
        businessdetailpage.businessImage = null;
        businessdetailpage.scrollView = null;
        businessdetailpage.businessTitle = null;
        businessdetailpage.offersContainer = null;
        businessdetailpage.offersHeader = null;
        businessdetailpage.openCloseTextView = null;
        businessdetailpage.tipsContainer = null;
        businessdetailpage.hoursContainer = null;
        businessdetailpage.mapSlice = null;
        businessdetailpage.businessContent = null;
        businessdetailpage.progressBar = null;
        businessdetailpage.requestDealButton = null;
        businessdetailpage.requestDealContainer = null;
        businessdetailpage.requestDealCompletedContainer = null;
        businessdetailpage.requestDealCompletedFeedbackContainer = null;
        businessdetailpage.requestDealRequestedContainer = null;
        businessdetailpage.editorsContainer = null;
        businessdetailpage.customerRecommend = null;
        businessdetailpage.totalPeopleRatedTextView = null;
        businessdetailpage.percentPeopleRatedTextView = null;
        businessdetailpage.xPeopleSignedUpTextView = null;
        businessdetailpage.xPeopleSignedUpCompletedTextView = null;
        businessdetailpage.xPeopleSignedUpRequestedTextView = null;
        businessdetailpage.editors = null;
        businessdetailpage.categorizations = null;
        businessdetailpage.ratingsContainer = null;
        businessdetailpage.wouldYouRecommend = null;
        businessdetailpage.customerRatingRecommend = null;
        businessdetailpage.thumbUp = null;
        businessdetailpage.thumbDown = null;
        businessdetailpage.businessHeaderContainer = null;
        businessdetailpage.businessHeaderParentContainer = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((BusinessDetailPage)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((BusinessDetailPage)obj);
    }

    public _cls9()
    {
    }
}
