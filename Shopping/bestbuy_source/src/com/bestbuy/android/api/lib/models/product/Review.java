// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

public class Review
    implements Serializable
{

    private static ArrayList featureRatings;
    private static String manufacturer;
    private static double mfgAvgRatingPercent0To1 = 0D;
    private static double mfgAvgRatingPercent0To100 = 0D;
    private static int mfgAvgRatingRangeMax = 0;
    private static double mfgAvgRatingScore = 0D;
    private static int mfgAvgRatingTotalCount = 0;
    private static double percent0To1 = 0D;
    private static int percent0To100 = 0;
    private static int rangeMax = 0;
    private static double recommendPercent0To1 = 0D;
    private static double recommendPercent0To100 = 0D;
    private static int recommendTotalCount = 0;
    private static double score = 0D;
    private static final long serialVersionUID = 1L;
    private static ArrayList starRatingBreakdowns;
    private static int totalCount;

    public Review()
    {
    }

    public static Review loadReviewData(JSONObject jsonobject)
    {
        Review review = new Review();
        if (jsonobject.optJSONObject("averageRating") != null)
        {
            percent0To1 = jsonobject.optJSONObject("averageRating").optDouble("percent0To1");
            percent0To100 = jsonobject.optJSONObject("averageRating").optInt("percent0To100");
            rangeMax = jsonobject.optJSONObject("averageRating").optInt("rangeMax");
            score = jsonobject.optJSONObject("averageRating").optDouble("score");
        }
        if (jsonobject.optJSONObject("averageWouldRecommend") != null)
        {
            recommendPercent0To1 = jsonobject.optJSONObject("averageWouldRecommend").optDouble("percent0To1");
            recommendPercent0To100 = jsonobject.optJSONObject("averageWouldRecommend").optDouble("percent0To100");
            recommendTotalCount = jsonobject.optJSONObject("averageWouldRecommend").optInt("totalCount");
        }
        if (jsonobject.optJSONObject("mfgAverageRating") != null)
        {
            manufacturer = jsonobject.optJSONObject("mfgAverageRating").optString("manufacturer");
            mfgAvgRatingPercent0To1 = jsonobject.optJSONObject("mfgAverageRating").optDouble("percent0To1");
            mfgAvgRatingPercent0To100 = jsonobject.optJSONObject("mfgAverageRating").optDouble("percent0To100");
            mfgAvgRatingRangeMax = jsonobject.optJSONObject("mfgAverageRating").optInt("rangeMax");
            mfgAvgRatingScore = jsonobject.optJSONObject("mfgAverageRating").optDouble("score");
            mfgAvgRatingTotalCount = jsonobject.optJSONObject("mfgAverageRating").optInt("totalCount");
        }
        totalCount = jsonobject.optInt("totalCount");
        if (jsonobject.optJSONArray("averageFeatureRating") != null)
        {
            featureRatings = FeatureRating.loadFeatureRatingData(jsonobject.optJSONArray("averageFeatureRating"));
        }
        if (jsonobject.optJSONArray("starRatingBreakdown") != null)
        {
            starRatingBreakdowns = StarRatingBreakdown.loadStarRatingBreakdownData(jsonobject.optJSONArray("starRatingBreakdown"));
        }
        return review;
    }

    public ArrayList getFeatureRatings()
    {
        return featureRatings;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public double getMfgAvgRatingPercent0To1()
    {
        return mfgAvgRatingPercent0To1;
    }

    public double getMfgAvgRatingPercent0To100()
    {
        return mfgAvgRatingPercent0To100;
    }

    public int getMfgAvgRatingRangeMax()
    {
        return mfgAvgRatingRangeMax;
    }

    public double getMfgAvgRatingScore()
    {
        return mfgAvgRatingScore;
    }

    public int getMfgAvgRatingTotalCount()
    {
        return mfgAvgRatingTotalCount;
    }

    public double getPercent0To1()
    {
        return percent0To1;
    }

    public int getPercent0To100()
    {
        return percent0To100;
    }

    public int getRangeMax()
    {
        return rangeMax;
    }

    public double getRecommendPercent0To1()
    {
        return recommendPercent0To1;
    }

    public double getRecommendPercent0To100()
    {
        return recommendPercent0To100;
    }

    public int getRecommendTotalCount()
    {
        return recommendTotalCount;
    }

    public double getScore()
    {
        return score;
    }

    public int getTotalCount()
    {
        return totalCount;
    }

    private class FeatureRating
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String displayName;
        private double percent0To1;
        private double percent0To100;
        private int rangeMax;
        private double score;

        public static ArrayList loadFeatureRatingData(JSONArray jsonarray)
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < jsonarray.length(); i++)
            {
                FeatureRating featurerating = new FeatureRating();
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject != null)
                {
                    featurerating.displayName = jsonobject.optString("displayName", "");
                    featurerating.percent0To1 = jsonobject.optDouble("percent0To1");
                    featurerating.percent0To100 = jsonobject.optDouble("percent0To100");
                    featurerating.rangeMax = jsonobject.optInt("rangeMax");
                    featurerating.score = jsonobject.optDouble("score");
                    arraylist.add(featurerating);
                }
            }

            return arraylist;
        }

        public String getDisplayName()
        {
            return displayName;
        }

        public double getPercent0To1()
        {
            return percent0To1;
        }

        public double getPercent0To100()
        {
            return percent0To100;
        }

        public int getRangeMax()
        {
            return rangeMax;
        }

        public double getScore()
        {
            return score;
        }

        public FeatureRating()
        {
        }
    }


    private class StarRatingBreakdown
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private int count;
        private double percent0To100;
        private int score;

        public static ArrayList loadStarRatingBreakdownData(JSONArray jsonarray)
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < jsonarray.length(); i++)
            {
                StarRatingBreakdown starratingbreakdown = new StarRatingBreakdown();
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject != null)
                {
                    starratingbreakdown.count = jsonobject.optInt("count");
                    starratingbreakdown.percent0To100 = jsonobject.optDouble("percent0To100");
                    starratingbreakdown.score = jsonobject.optInt("score");
                    arraylist.add(starratingbreakdown);
                }
            }

            return arraylist;
        }

        public int getCount()
        {
            return count;
        }

        public double getPercent0To100()
        {
            return percent0To100;
        }

        public int getScore()
        {
            return score;
        }

        public StarRatingBreakdown()
        {
        }
    }

}
