// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.reviews;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.reviews:
//            TagDimension, AdditionalField, Badge, SecondaryRating

public class RatingAndReview
{

    private ArrayList additionalFields;
    private ArrayList additionalFieldsOrder;
    private String authorId;
    private ArrayList badges;
    private ArrayList badgesOrder;
    private String campaignId;
    private String cons;
    private String contentLocale;
    private double helpfulness;
    private String id;
    private boolean isFeatured;
    private boolean isRatingsOnly;
    private boolean isRecommended;
    private boolean isSyndicated;
    private String lastModeratedTime;
    private String lastModificationTime;
    private String moderationStatus;
    private String productId;
    private String pros;
    private float rating;
    private int ratingRange;
    private String reviewText;
    private ArrayList secondaryRatings;
    private ArrayList secondaryRatingsOrder;
    private String submissionId;
    private String submissionTime;
    private ArrayList tagDimensions;
    private ArrayList tagDimensionsOrder;
    private String title;
    private int totalCommentCount;
    private int totalFeedbackCount;
    private int totalNegativeFeedbackCount;
    private int totalPositiveFeedbackCount;
    private String userLocation;
    private String userNickname;

    public RatingAndReview()
    {
    }

    public static ArrayList loadRatingsAndReviewsData(JSONObject jsonobject)
    {
        ArrayList arraylist = new ArrayList();
        jsonobject = jsonobject.optJSONArray("Results");
        for (int i = 0; i < jsonobject.length(); i++)
        {
            JSONObject jsonobject1 = jsonobject.optJSONObject(i);
            if (jsonobject1 == null)
            {
                continue;
            }
            RatingAndReview ratingandreview = new RatingAndReview();
            if (jsonobject1.optJSONArray("TagDimensionsOrder") != null)
            {
                ratingandreview.tagDimensionsOrder = new ArrayList();
                JSONArray jsonarray = jsonobject1.optJSONArray("TagDimensionsOrder");
                for (int j = 0; j < jsonarray.length(); j++)
                {
                    String s = jsonarray.optString(j);
                    ratingandreview.tagDimensionsOrder.add(s);
                }

            }
            if (jsonobject1.optJSONObject("TagDimensions") != null)
            {
                ratingandreview.tagDimensions = TagDimension.loadTagDimensionData(jsonobject1.optJSONObject("TagDimensions"), ratingandreview.tagDimensionsOrder);
            }
            if (jsonobject1.optJSONArray("AdditionalFieldsOrder") != null)
            {
                ratingandreview.additionalFieldsOrder = new ArrayList();
                JSONArray jsonarray1 = jsonobject1.optJSONArray("AdditionalFieldsOrder");
                for (int k = 0; k < jsonarray1.length(); k++)
                {
                    String s1 = jsonarray1.optString(k);
                    ratingandreview.additionalFieldsOrder.add(s1);
                }

            }
            if (jsonobject1.optJSONObject("AdditionalFields") != null)
            {
                ratingandreview.additionalFields = AdditionalField.loadAdditionalFieldData(jsonobject1.optJSONObject("AdditionalFields"), ratingandreview.additionalFieldsOrder);
            }
            if (jsonobject1.optJSONArray("BadgesOrder") != null)
            {
                ratingandreview.badgesOrder = new ArrayList();
                JSONArray jsonarray2 = jsonobject1.optJSONArray("BadgesOrder");
                for (int l = 0; l < jsonarray2.length(); l++)
                {
                    String s2 = jsonarray2.optString(l);
                    ratingandreview.badgesOrder.add(s2);
                }

            }
            if (jsonobject1.optJSONObject("Badges") != null)
            {
                ratingandreview.badges = Badge.loadReviewBadgeData(jsonobject1.optJSONObject("Badges"), ratingandreview.badgesOrder);
            }
            if (jsonobject1.optJSONArray("SecondaryRatingsOrder") != null)
            {
                ratingandreview.secondaryRatingsOrder = new ArrayList();
                JSONArray jsonarray3 = jsonobject1.optJSONArray("SecondaryRatingsOrder");
                for (int i1 = 0; i1 < jsonarray3.length(); i1++)
                {
                    String s3 = jsonarray3.optString(i1);
                    ratingandreview.secondaryRatingsOrder.add(s3);
                }

            }
            if (jsonobject1.optJSONObject("SecondaryRatings") != null)
            {
                ratingandreview.secondaryRatings = SecondaryRating.loadSecondaryRatingData(jsonobject1.optJSONObject("SecondaryRatings"), ratingandreview.secondaryRatingsOrder);
            }
            ratingandreview.cons = jsonobject1.optString("Cons");
            ratingandreview.isRecommended = jsonobject1.optBoolean("IsRecommended");
            ratingandreview.isRatingsOnly = jsonobject1.optBoolean("IsRatingsOnly");
            ratingandreview.userNickname = jsonobject1.optString("UserNickname");
            ratingandreview.pros = jsonobject1.optString("Pros");
            ratingandreview.submissionId = jsonobject1.optString("SubmissionId");
            ratingandreview.lastModificationTime = jsonobject1.optString("LastModificationTime");
            ratingandreview.totalFeedbackCount = jsonobject1.optInt("TotalFeedbackCount");
            ratingandreview.totalPositiveFeedbackCount = jsonobject1.optInt("TotalPositiveFeedbackCount");
            ratingandreview.userLocation = jsonobject1.optString("UserLocation");
            ratingandreview.authorId = jsonobject1.optString("AuthorId");
            ratingandreview.isFeatured = jsonobject1.optBoolean("IsFeatured");
            ratingandreview.isSyndicated = jsonobject1.optBoolean("IsSyndicated");
            ratingandreview.productId = jsonobject1.optString("ProductId");
            ratingandreview.title = jsonobject1.optString("Title");
            ratingandreview.helpfulness = jsonobject1.optDouble("Helpfulness");
            ratingandreview.campaignId = jsonobject1.optString("CampaignId");
            ratingandreview.totalNegativeFeedbackCount = jsonobject1.optInt("TotalNegativeFeedbackCount");
            ratingandreview.submissionTime = jsonobject1.optString("SubmissionTime");
            ratingandreview.contentLocale = jsonobject1.optString("ContentLocale");
            ratingandreview.reviewText = jsonobject1.optString("ReviewText");
            ratingandreview.moderationStatus = jsonobject1.optString("ModerationStatus");
            ratingandreview.id = jsonobject1.optString("Id");
            ratingandreview.lastModeratedTime = jsonobject1.optString("LastModeratedTime");
            ratingandreview.rating = (float)jsonobject1.optDouble("Rating");
            ratingandreview.ratingRange = jsonobject1.optInt("RatingRange");
            ratingandreview.totalCommentCount = jsonobject1.optInt("TotalCommentCount");
            arraylist.add(ratingandreview);
        }

        return arraylist;
    }

    public ArrayList getAdditionalFields()
    {
        return additionalFields;
    }

    public ArrayList getAdditionalFieldsOrder()
    {
        return additionalFieldsOrder;
    }

    public String getAuthorId()
    {
        return authorId;
    }

    public ArrayList getBadges()
    {
        return badges;
    }

    public ArrayList getBadgesOrder()
    {
        return badgesOrder;
    }

    public String getCampaignId()
    {
        return campaignId;
    }

    public String getCons()
    {
        return cons;
    }

    public String getContentLocale()
    {
        return contentLocale;
    }

    public double getHelpfulness()
    {
        return helpfulness;
    }

    public String getId()
    {
        return id;
    }

    public String getLastModeratedTime()
    {
        return lastModeratedTime;
    }

    public String getLastModificationTime()
    {
        return lastModificationTime;
    }

    public String getModerationStatus()
    {
        return moderationStatus;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getPros()
    {
        return pros;
    }

    public float getRating()
    {
        return rating;
    }

    public int getRatingRange()
    {
        return ratingRange;
    }

    public String getReviewText()
    {
        return reviewText;
    }

    public ArrayList getSecondaryRatings()
    {
        return secondaryRatings;
    }

    public ArrayList getSecondaryRatingsOrder()
    {
        return secondaryRatingsOrder;
    }

    public String getSubmissionId()
    {
        return submissionId;
    }

    public String getSubmissionTime()
    {
        return submissionTime;
    }

    public ArrayList getTagDimensions()
    {
        return tagDimensions;
    }

    public ArrayList getTagDimensionsOrder()
    {
        return tagDimensionsOrder;
    }

    public String getTitle()
    {
        return title;
    }

    public int getTotalCommentCount()
    {
        return totalCommentCount;
    }

    public int getTotalFeedbackCount()
    {
        return totalFeedbackCount;
    }

    public int getTotalNegativeFeedbackCount()
    {
        return totalNegativeFeedbackCount;
    }

    public int getTotalPositiveFeedbackCount()
    {
        return totalPositiveFeedbackCount;
    }

    public String getUserLocation()
    {
        return userLocation;
    }

    public String getUserNickname()
    {
        return userNickname;
    }

    public boolean isFeatured()
    {
        return isFeatured;
    }

    public boolean isRatingsOnly()
    {
        return isRatingsOnly;
    }

    public boolean isRecommended()
    {
        return isRecommended;
    }

    public boolean isSyndicated()
    {
        return isSyndicated;
    }
}
