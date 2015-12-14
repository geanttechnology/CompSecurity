// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.brightroll.androidsdk:
//            WebViewRTB, Ad, AdDelegate

public class RTB
{

    public static final String IABCategory_3_D_Graphics = "3-D Graphics";
    public static final String IABCategory_7_12_Education = "7-12 Education";
    public static final String IABCategory_AIDS_HIV = "AIDS/HIV";
    public static final String IABCategory_A_D_D_ = "A.D.D.";
    public static final String IABCategory_Accessories = "Accessories";
    public static final String IABCategory_Adoption = "Adoption";
    public static final String IABCategory_Adult_Education = "Adult Education";
    public static final String IABCategory_Adventure_Travel = "Adventure Travel";
    public static final String IABCategory_Advertising = "Advertising";
    public static final String IABCategory_Africa = "Africa";
    public static final String IABCategory_Agriculture = "Agriculture";
    public static final String IABCategory_Air_Travel = "Air Travel";
    public static final String IABCategory_Allergies = "Allergies";
    public static final String IABCategory_Alternative_Medicine = "Alternative Medicine";
    public static final String IABCategory_Alternative_Religions = "Alternative Religions";
    public static final String IABCategory_American_Cuisine = "American Cuisine";
    public static final String IABCategory_Animation = "Animation";
    public static final String IABCategory_Antivirus_Software = "Antivirus Software";
    public static final String IABCategory_Apartments = "Apartments";
    public static final String IABCategory_Appliances = "Appliances";
    public static final String IABCategory_Aquariums = "Aquariums";
    public static final String IABCategory_Architects = "Architects";
    public static final String IABCategory_Art_History = "Art History";
    public static final String IABCategory_Art_Technology = "Art/Technology";
    public static final String IABCategory_Arthritis = "Arthritis";
    public static final String IABCategory_Arts_Crafts = "Arts & Crafts";
    public static final String IABCategory_Arts_Entertainment = "Arts & Entertainment";
    public static final String IABCategory_Asthma = "Asthma";
    public static final String IABCategory_Astrology = "Astrology";
    public static final String IABCategory_Atheism_Agnosticism = "Atheism/Agnosticism";
    public static final String IABCategory_Australia_New_Zealand = "Australia & New Zealand";
    public static final String IABCategory_Autism_PDD = "Autism/PDD";
    public static final String IABCategory_Auto_Parts = "Auto Parts";
    public static final String IABCategory_Auto_Racing = "Auto Racing";
    public static final String IABCategory_Auto_Repair = "Auto Repair";
    public static final String IABCategory_Automotive = "Automotive";
    public static final String IABCategory_Babies_Toddlers = "Babies & Toddlers";
    public static final String IABCategory_Barbecues_Grilling = "Barbecues & Grilling";
    public static final String IABCategory_Baseball = "Baseball";
    public static final String IABCategory_Beadwork = "Beadwork";
    public static final String IABCategory_Beauty = "Beauty";
    public static final String IABCategory_Bed_Breakfasts = "Bed & Breakfasts";
    public static final String IABCategory_Beginning_Investing = "Beginning Investing";
    public static final String IABCategory_Bicycling = "Bicycling";
    public static final String IABCategory_Biology = "Biology";
    public static final String IABCategory_Biotech_Biomedical = "Biotech/Biomedical";
    public static final String IABCategory_Bipolar_Disorder = "Bipolar Disorder";
    public static final String IABCategory_Birds = "Birds";
    public static final String IABCategory_Birdwatching = "Birdwatching";
    public static final String IABCategory_Board_Games_Puzzles = "Board Games/Puzzles";
    public static final String IABCategory_Body_Art = "Body Art";
    public static final String IABCategory_Bodybuilding = "Bodybuilding";
    public static final String IABCategory_Books_Literature = "Books & Literature";
    public static final String IABCategory_Botany = "Botany";
    public static final String IABCategory_Boxing = "Boxing";
    public static final String IABCategory_Brain_Tumor = "Brain Tumor";
    public static final String IABCategory_Buddhism = "Buddhism";
    public static final String IABCategory_Budget_Travel = "Budget Travel";
    public static final String IABCategory_Business = "Business";
    public static final String IABCategory_Business_Software = "Business Software";
    public static final String IABCategory_Business_Travel = "Business Travel";
    public static final String IABCategory_Buying_Selling_Cars = "Buying/Selling Cars";
    public static final String IABCategory_Buying_Selling_Homes = "Buying/Selling Homes";
    public static final String IABCategory_By_US_Locale = "By US Locale";
    public static final String IABCategory_C_C_ = "C/C++";
    public static final String IABCategory_Cajun_Creole = "Cajun/Creole";
    public static final String IABCategory_Cameras_Camcorders = "Cameras & Camcorders";
    public static final String IABCategory_Camping = "Camping";
    public static final String IABCategory_Canada = "Canada";
    public static final String IABCategory_Cancer = "Cancer";
    public static final String IABCategory_Candle_Soap_Making = "Candle & Soap Making";
    public static final String IABCategory_Canoeing_Kayaking = "Canoeing/Kayaking";
    public static final String IABCategory_Car_Culture = "Car Culture";
    public static final String IABCategory_Card_Games = "Card Games";
    public static final String IABCategory_Career_Advice = "Career Advice";
    public static final String IABCategory_Career_Planning = "Career Planning";
    public static final String IABCategory_Careers = "Careers";
    public static final String IABCategory_Caribbean = "Caribbean";
    public static final String IABCategory_Catholicism = "Catholicism";
    public static final String IABCategory_Cats = "Cats";
    public static final String IABCategory_Celebrity_Fan_Gossip = "Celebrity Fan/Gossip";
    public static final String IABCategory_Cell_Phones = "Cell Phones";
    public static final String IABCategory_Certified_Pre_Owned = "Certified Pre-Owned";
    public static final String IABCategory_Cheerleading = "Cheerleading";
    public static final String IABCategory_Chemistry = "Chemistry";
    public static final String IABCategory_Chess = "Chess";
    public static final String IABCategory_Chinese_Cuisine = "Chinese Cuisine";
    public static final String IABCategory_Cholesterol = "Cholesterol";
    public static final String IABCategory_Christianity = "Christianity";
    public static final String IABCategory_Chronic_Fatigue_Syndrome = "Chronic Fatigue Syndrome";
    public static final String IABCategory_Chronic_Pain = "Chronic Pain";
    public static final String IABCategory_Cigars = "Cigars";
    public static final String IABCategory_Climbing = "Climbing";
    public static final String IABCategory_Clothing = "Clothing";
    public static final String IABCategory_Cocktails_Beer = "Cocktails/Beer";
    public static final String IABCategory_Coffee_Tea = "Coffee/Tea";
    public static final String IABCategory_Cold_Flu = "Cold & Flu";
    public static final String IABCategory_Collecting = "Collecting";
    public static final String IABCategory_College = "College";
    public static final String IABCategory_College_Administration = "College Administration";
    public static final String IABCategory_College_Life = "College Life";
    public static final String IABCategory_Comic_Books = "Comic Books";
    public static final String IABCategory_Commentary = "Commentary";
    public static final String IABCategory_Comparison = "Comparison";
    public static final String IABCategory_Computer_Certification = "Computer Certification";
    public static final String IABCategory_Computer_Networking = "Computer Networking";
    public static final String IABCategory_Computer_Peripherals = "Computer Peripherals";
    public static final String IABCategory_Computer_Reviews = "Computer Reviews";
    public static final String IABCategory_Construction = "Construction";
    public static final String IABCategory_Contests_Freebies = "Contests & Freebies";
    public static final String IABCategory_Convertible = "Convertible";
    public static final String IABCategory_Coupe = "Coupe";
    public static final String IABCategory_Couponing = "Couponing";
    public static final String IABCategory_Credit_Debt_Loans = "Credit/Debt & Loans";
    public static final String IABCategory_Cricket = "Cricket";
    public static final String IABCategory_Crossover = "Crossover";
    public static final String IABCategory_Cruises = "Cruises";
    public static final String IABCategory_Cuisine_Specific = "Cuisine-Specific";
    public static final String IABCategory_Data_Centers = "Data Centers";
    public static final String IABCategory_Databases = "Databases";
    public static final String IABCategory_Dating = "Dating";
    public static final String IABCategory_Daycare_Pre_School = "Daycare/Pre School";
    public static final String IABCategory_Deafness = "Deafness";
    public static final String IABCategory_Dental_Care = "Dental Care";
    public static final String IABCategory_Depression = "Depression";
    public static final String IABCategory_Dermatology = "Dermatology";
    public static final String IABCategory_Desktop_Publishing = "Desktop Publishing";
    public static final String IABCategory_Desktop_Video = "Desktop Video";
    public static final String IABCategory_Desserts_Baking = "Desserts & Baking";
    public static final String IABCategory_Diabetes = "Diabetes";
    public static final String IABCategory_Diesel = "Diesel";
    public static final String IABCategory_Dining_Out = "Dining Out";
    public static final String IABCategory_Distance_Learning = "Distance Learning";
    public static final String IABCategory_Divorce_Support = "Divorce Support";
    public static final String IABCategory_Dogs = "Dogs";
    public static final String IABCategory_Drawing_Sketching = "Drawing/Sketching";
    public static final String IABCategory_Eastern_Europe = "Eastern Europe";
    public static final String IABCategory_Education = "Education";
    public static final String IABCategory_Eldercare = "Eldercare";
    public static final String IABCategory_Electric_Vehicle = "Electric Vehicle";
    public static final String IABCategory_Email = "Email";
    public static final String IABCategory_Engines = "Engines";
    public static final String IABCategory_English_as_a_2nd_Language = "English as a 2nd Language";
    public static final String IABCategory_Entertaining = "Entertaining";
    public static final String IABCategory_Environmental_Safety = "Environmental Safety";
    public static final String IABCategory_Epilepsy = "Epilepsy";
    public static final String IABCategory_Ethnic_Specific = "Ethnic Specific";
    public static final String IABCategory_Europe = "Europe";
    public static final String IABCategory_Exercise = "Exercise";
    public static final String IABCategory_Family_Internet = "Family Internet";
    public static final String IABCategory_Family_Parenting = "Family & Parenting";
    public static final String IABCategory_Fashion = "Fashion";
    public static final String IABCategory_Figure_Skating = "Figure Skating";
    public static final String IABCategory_Financial_Aid = "Financial Aid";
    public static final String IABCategory_Financial_News = "Financial News";
    public static final String IABCategory_Financial_Planning = "Financial Planning";
    public static final String IABCategory_Fine_Art = "Fine Art";
    public static final String IABCategory_Fly_Fishing = "Fly Fishing";
    public static final String IABCategory_Food_Allergies = "Food Allergies";
    public static final String IABCategory_Food_Drink = "Food & Drink";
    public static final String IABCategory_Football = "Football";
    public static final String IABCategory_Forestry = "Forestry";
    public static final String IABCategory_France = "France";
    public static final String IABCategory_Freelance_Writing = "Freelance Writing";
    public static final String IABCategory_French_Cuisine = "French Cuisine";
    public static final String IABCategory_Freshwater_Fishing = "Freshwater Fishing";
    public static final String IABCategory_GERD_Acid_Reflux = "GERD/Acid Reflux";
    public static final String IABCategory_Game_Fish = "Game & Fish";
    public static final String IABCategory_Gardening = "Gardening";
    public static final String IABCategory_Gay_Life = "Gay Life";
    public static final String IABCategory_Genealogy = "Genealogy";
    public static final String IABCategory_Geography = "Geography";
    public static final String IABCategory_Geology = "Geology";
    public static final String IABCategory_Getting_Published = "Getting Published";
    public static final String IABCategory_Golf = "Golf";
    public static final String IABCategory_Government = "Government";
    public static final String IABCategory_Graduate_School = "Graduate School";
    public static final String IABCategory_Graphics_Software = "Graphics Software";
    public static final String IABCategory_Greece = "Greece";
    public static final String IABCategory_Green_Solutions = "Green Solutions";
    public static final String IABCategory_Guitar = "Guitar";
    public static final String IABCategory_Hatchback = "Hatchback";
    public static final String IABCategory_Headaches_Migraines = "Headaches/Migraines";
    public static final String IABCategory_Health_Fitness = "Health & Fitness";
    public static final String IABCategory_Health_LowFat_Cooking = "Health/LowFat Cooking";
    public static final String IABCategory_Heart_Disease = "Heart Disease";
    public static final String IABCategory_Hedge_Fund = "Hedge Fund";
    public static final String IABCategory_Herbs_for_Health = "Herbs for Health";
    public static final String IABCategory_Hinduism = "Hinduism";
    public static final String IABCategory_Hobbies_Interests = "Hobbies & Interests";
    public static final String IABCategory_Holistic_Healing = "Holistic Healing";
    public static final String IABCategory_Home_Garden = "Home & Garden";
    public static final String IABCategory_Home_Recording = "Home Recording";
    public static final String IABCategory_Home_Repair = "Home Repair";
    public static final String IABCategory_Home_Theater = "Home Theater";
    public static final String IABCategory_Home_Video_DVD = "Home Video/DVD";
    public static final String IABCategory_Homeschooling = "Homeschooling";
    public static final String IABCategory_Homework_Study_Tips = "Homework/Study Tips";
    public static final String IABCategory_Honeymoons_Getaways = "Honeymoons/Getaways";
    public static final String IABCategory_Horse_Racing = "Horse Racing";
    public static final String IABCategory_Horses = "Horses";
    public static final String IABCategory_Hotels = "Hotels";
    public static final String IABCategory_Human_Resources = "Human Resources";
    public static final String IABCategory_Humor = "Humor";
    public static final String IABCategory_Hunting_Shooting = "Hunting/Shooting";
    public static final String IABCategory_Hybrid = "Hybrid";
    public static final String IABCategory_IBS_Crohn_s_Disease = "IBS/Crohn's Disease";
    public static final String IABCategory_Immigration = "Immigration";
    public static final String IABCategory_Incest_Abuse_Support = "Incest/Abuse Support";
    public static final String IABCategory_Incontinence = "Incontinence";
    public static final String IABCategory_Infertility = "Infertility";
    public static final String IABCategory_Inline_Skating = "Inline Skating";
    public static final String IABCategory_Insurance = "Insurance";
    public static final String IABCategory_Interior_Decorating = "Interior Decorating";
    public static final String IABCategory_International_News = "International News";
    public static final String IABCategory_Internet_Technology = "Internet Technology";
    public static final String IABCategory_Investing = "Investing";
    public static final String IABCategory_Investors_Patents = "Investors & Patents";
    public static final String IABCategory_Islam = "Islam";
    public static final String IABCategory_Italian_Cuisine = "Italian Cuisine";
    public static final String IABCategory_Italy = "Italy";
    public static final String IABCategory_Japan = "Japan";
    public static final String IABCategory_Japanese_Cuisine = "Japanese Cuisine";
    public static final String IABCategory_Java = "Java";
    public static final String IABCategory_JavaScript = "JavaScript";
    public static final String IABCategory_Jewelry = "Jewelry";
    public static final String IABCategory_Jewelry_Making = "Jewelry Making";
    public static final String IABCategory_Job_Fairs = "Job Fairs";
    public static final String IABCategory_Job_Search = "Job Search";
    public static final String IABCategory_Judaism = "Judaism";
    public static final String IABCategory_K_6_Educators = "K-6 Educators";
    public static final String IABCategory_Landscaping = "Landscaping";
    public static final String IABCategory_Language_Learning = "Language Learning";
    public static final String IABCategory_Large_Animals = "Large Animals";
    public static final String IABCategory_Latter_Day_Saints = "Latter-Day Saints";
    public static final String IABCategory_Law_Gov_t_Politics = "Law, Gov't & Politics";
    public static final String IABCategory_Legal_Issues = "Legal Issues";
    public static final String IABCategory_Linux = "Linux";
    public static final String IABCategory_Local_News = "Local News";
    public static final String IABCategory_Logistics = "Logistics";
    public static final String IABCategory_Luxury = "Luxury";
    public static final String IABCategory_MP3_MIDI = "MP3/MIDI";
    public static final String IABCategory_Mac_OS = "Mac OS";
    public static final String IABCategory_Mac_Support = "Mac Support";
    public static final String IABCategory_Magic_Illusion = "Magic & Illusion";
    public static final String IABCategory_Marketing = "Marketing";
    public static final String IABCategory_Marriage = "Marriage";
    public static final String IABCategory_Martial_Arts = "Martial Arts";
    public static final String IABCategory_Men_s_Health = "Men's Health";
    public static final String IABCategory_Metals = "Metals";
    public static final String IABCategory_Mexican_Cuisine = "Mexican Cuisine";
    public static final String IABCategory_Mexico_Central_America = "Mexico & Central America";
    public static final String IABCategory_MiniVan = "MiniVan";
    public static final String IABCategory_Motorcycles = "Motorcycles";
    public static final String IABCategory_Mountain_Biking = "Mountain Biking";
    public static final String IABCategory_Movies = "Movies";
    public static final String IABCategory_Music = "Music";
    public static final String IABCategory_Mutual_Funds = "Mutual Funds";
    public static final String IABCategory_NASCAR_Racing = "NASCAR Racing";
    public static final String IABCategory_National_News = "National News";
    public static final String IABCategory_National_Parks = "National Parks";
    public static final String IABCategory_Needlework = "Needlework";
    public static final String IABCategory_Net_Conferencing = "Net Conferencing";
    public static final String IABCategory_Net_for_Beginners = "Net for Beginners";
    public static final String IABCategory_Network_Security = "Network Security";
    public static final String IABCategory_News = "News";
    public static final String IABCategory_Nursing = "Nursing";
    public static final String IABCategory_Nutrition = "Nutrition";
    public static final String IABCategory_Off_Road_Vehicles = "Off-Road Vehicles";
    public static final String IABCategory_Olympics = "Olympics";
    public static final String IABCategory_Options = "Options";
    public static final String IABCategory_Orthopedics = "Orthopedics";
    public static final String IABCategory_PC_Support = "PC Support";
    public static final String IABCategory_Pagan_Wiccan = "Pagan/Wiccan";
    public static final String IABCategory_Paintball = "Paintball";
    public static final String IABCategory_Painting = "Painting";
    public static final String IABCategory_Palmtops_PDAs = "Palmtops/PDAs";
    public static final String IABCategory_Panic_Anxiety_Disorders = "Panic/Anxiety Disorders";
    public static final String IABCategory_Paranormal_Phenomena = "Paranormal Phenomena";
    public static final String IABCategory_Parenting_K_6_Kids = "Parenting - K-6 Kids";
    public static final String IABCategory_Parenting_Teens = "Parenting Teens";
    public static final String IABCategory_Pediatrics = "Pediatrics";
    public static final String IABCategory_Performance_Vehicles = "Performance Vehicles";
    public static final String IABCategory_Personal_Finance = "Personal Finance";
    public static final String IABCategory_Pets = "Pets";
    public static final String IABCategory_Photography = "Photography";
    public static final String IABCategory_Physical_Therapy = "Physical Therapy";
    public static final String IABCategory_Physics = "Physics";
    public static final String IABCategory_Pickup = "Pickup";
    public static final String IABCategory_Politics = "Politics";
    public static final String IABCategory_Portable_Entertainment = "Portable Entertainment";
    public static final String IABCategory_Power_Motorcycles = "Power & Motorcycles";
    public static final String IABCategory_Pregnancy = "Pregnancy";
    public static final String IABCategory_Private_School = "Private School";
    public static final String IABCategory_Pro_Basketball = "Pro Basketball";
    public static final String IABCategory_Pro_Ice_Hockey = "Pro Ice Hockey";
    public static final String IABCategory_Psychology_Psychiatry = "Psychology/Psychiatry";
    public static final String IABCategory_Radio = "Radio";
    public static final String IABCategory_Real_Estate = "Real Estate";
    public static final String IABCategory_Religion_and_Spirituality = "Religion and Spirituality";
    public static final String IABCategory_Remodeling_Construction = "Remodeling & Construction";
    public static final String IABCategory_Reptiles = "Reptiles";
    public static final String IABCategory_Resume_Writing_Advice = "Resume Writing/Advice";
    public static final String IABCategory_Retirement_Planning = "Retirement Planning";
    public static final String IABCategory_Road_Side_Assistance = "Road-Side Assistance";
    public static final String IABCategory_Rodeo = "Rodeo";
    public static final String IABCategory_Roleplaying_Games = "Roleplaying Games";
    public static final String IABCategory_Rugby = "Rugby";
    public static final String IABCategory_Running_Jogging = "Running/Jogging";
    public static final String IABCategory_Sailing = "Sailing";
    public static final String IABCategory_Saltwater_Fishing = "Saltwater Fishing";
    public static final String IABCategory_Scholarships = "Scholarships";
    public static final String IABCategory_Sci_Fi_Fantasy = "Sci-Fi & Fantasy";
    public static final String IABCategory_Science = "Science";
    public static final String IABCategory_Scrapbooking = "Scrapbooking";
    public static final String IABCategory_Screenwriting = "Screenwriting";
    public static final String IABCategory_Scuba_Diving = "Scuba Diving";
    public static final String IABCategory_Sedan = "Sedan";
    public static final String IABCategory_Senior_Health = "Senior Health";
    public static final String IABCategory_Senior_Living = "Senior Living";
    public static final String IABCategory_Sexuality = "Sexuality";
    public static final String IABCategory_Shareware_Freeware = "Shareware/Freeware";
    public static final String IABCategory_Shopping = "Shopping";
    public static final String IABCategory_Skateboarding = "Skateboarding";
    public static final String IABCategory_Skiing = "Skiing";
    public static final String IABCategory_Sleep_Disorders = "Sleep Disorders";
    public static final String IABCategory_Smoking_Cessation = "Smoking Cessation";
    public static final String IABCategory_Snowboarding = "Snowboarding";
    public static final String IABCategory_Society = "Society";
    public static final String IABCategory_South_America = "South America";
    public static final String IABCategory_Space_Astronomy = "Space/Astronomy";
    public static final String IABCategory_Spas = "Spas";
    public static final String IABCategory_Special_Education = "Special Education";
    public static final String IABCategory_Special_Needs_Kids = "Special Needs Kids";
    public static final String IABCategory_Sports = "Sports";
    public static final String IABCategory_Stamps_Coins = "Stamps & Coins";
    public static final String IABCategory_Stocks = "Stocks";
    public static final String IABCategory_Studying_Business = "Studying Business";
    public static final String IABCategory_Style_Fashion = "Style & Fashion";
    public static final String IABCategory_Substance_Abuse = "Substance Abuse";
    public static final String IABCategory_Surfing_Bodyboarding = "Surfing/Bodyboarding";
    public static final String IABCategory_Swimming = "Swimming";
    public static final String IABCategory_Table_Tennis_Ping_Pong = "Table Tennis/Ping-Pong";
    public static final String IABCategory_Tax_Planning = "Tax Planning";
    public static final String IABCategory_Technology_Computing = "Technology & Computing";
    public static final String IABCategory_Teens = "Teens";
    public static final String IABCategory_Telecommuting = "Telecommuting";
    public static final String IABCategory_Television = "Television";
    public static final String IABCategory_Tennis = "Tennis";
    public static final String IABCategory_Theme_Parks = "Theme Parks";
    public static final String IABCategory_Thyroid_Disease = "Thyroid Disease";
    public static final String IABCategory_Travel = "Travel";
    public static final String IABCategory_Traveling_with_Kids = "Traveling with Kids";
    public static final String IABCategory_Trucks_Accessories = "Trucks & Accessories";
    public static final String IABCategory_U_S_Government_Resources = "U.S. Government Resources";
    public static final String IABCategory_U_S_Military = "U.S. Military";
    public static final String IABCategory_United_Kingdom = "United Kingdom";
    public static final String IABCategory_Unix = "Unix";
    public static final String IABCategory_Vegan = "Vegan";
    public static final String IABCategory_Vegetarian = "Vegetarian";
    public static final String IABCategory_Veterinary_Medicine = "Veterinary Medicine";
    public static final String IABCategory_Video_Computer_Games = "Video & Computer Games";
    public static final String IABCategory_Vintage_Cars = "Vintage Cars";
    public static final String IABCategory_Visual_Basic = "Visual Basic";
    public static final String IABCategory_Volleyball = "Volleyball";
    public static final String IABCategory_Wagon = "Wagon";
    public static final String IABCategory_Walking = "Walking";
    public static final String IABCategory_Waterski_Wakeboard = "Waterski/Wakeboard";
    public static final String IABCategory_Weather = "Weather";
    public static final String IABCategory_Web_Clip_Art = "Web Clip Art";
    public static final String IABCategory_Web_Design_HTML = "Web Design/HTML";
    public static final String IABCategory_Web_Search = "Web Search";
    public static final String IABCategory_Weddings = "Weddings";
    public static final String IABCategory_Weight_Loss = "Weight Loss";
    public static final String IABCategory_Windows = "Windows";
    public static final String IABCategory_Wine = "Wine";
    public static final String IABCategory_Women_s_Health = "Women's Health";
    public static final String IABCategory_Woodworking = "Woodworking";
    public static final String IABCategory_World_Soccer = "World Soccer";
    public static final String USER_GENDER_FEMALE = "f";
    public static final String USER_GENDER_MALE = "m";
    static RTB proto;
    public Ad ad;
    String adDisplayTime;
    String adId;
    String androidId;
    String appCategories[];
    String appName;
    String appUrl;
    String contentDescription;
    String contentLanguage;
    String contentTitle;
    boolean dnt;
    boolean hasPrivacyPolicy;
    boolean isPaid;
    String pageCategories[];
    String pageTitle;
    String sectionCategories[];
    String userAge;
    String userAgent;
    String userCity;
    String userCountry;
    String userGender;
    String userMetro;
    String userRegion;
    String userZip;

    public RTB()
    {
        setAdDisplayTime("");
        setAppCategories(new String[0]);
        setAppName("");
        setAppUrl("");
        setContentDescription("");
        setContentLanguage("");
        setContentTitle("");
        setPageCategories(new String[0]);
        setPageTitle("");
        setSectionCategories(new String[0]);
        setUserAge("");
        setUserGender("");
        setUserCity("");
        setUserCountry("");
        setUserMetro("");
        setUserRegion("");
        setUserZip("");
        setAdId("");
        setAndroidId("");
        if (proto != null)
        {
            setUserAgent(proto.getUserAgent());
        }
    }

    private HashMap advertisingIdMap()
    {
        HashMap hashmap = new HashMap();
        if (adId.equals("")) goto _L2; else goto _L1
_L1:
        hashmap.put("br_dpidu", adId);
        hashmap.put("br_dpidutype", "gaid");
_L4:
        hashmap.put("br_dnt", String.valueOf(dnt));
        return hashmap;
_L2:
        if (androidId.equals("")) goto _L4; else goto _L3
_L3:
        Object obj = androidId;
        Object obj1;
        Object obj2;
        int j;
        obj1 = MessageDigest.getInstance("SHA-1");
        ((MessageDigest) (obj1)).reset();
        ((MessageDigest) (obj1)).update(((String) (obj)).getBytes());
        obj1 = ((MessageDigest) (obj1)).digest();
        j = obj1.length;
        obj2 = new StringBuilder(j << 1);
        int i = 0;
_L9:
        if (i < j) goto _L6; else goto _L5
_L5:
        obj1 = ((StringBuilder) (obj2)).toString();
        obj = obj1;
_L12:
        obj1 = androidId;
        StringBuilder stringbuilder;
        obj2 = MessageDigest.getInstance("MD5");
        ((MessageDigest) (obj2)).reset();
        ((MessageDigest) (obj2)).update(((String) (obj1)).getBytes());
        obj2 = ((MessageDigest) (obj2)).digest();
        j = obj2.length;
        stringbuilder = new StringBuilder(j << 1);
        i = 0;
_L10:
        if (i < j) goto _L8; else goto _L7
_L7:
        obj2 = stringbuilder.toString();
        obj1 = obj2;
_L11:
        if (obj != null)
        {
            hashmap.put("br_dpids", obj);
            hashmap.put("br_uid", obj);
            hashmap.put("br_dpidstype", "a");
        }
        if (obj1 != null)
        {
            hashmap.put("br_dpidm", obj1);
            hashmap.put("br_dpidmtype", "a");
        }
          goto _L4
_L6:
        ((StringBuilder) (obj2)).append(Character.forDigit((obj1[i] & 0xf0) >> 4, 16));
        ((StringBuilder) (obj2)).append(Character.forDigit(obj1[i] & 0xf, 16));
        i++;
          goto _L9
_L8:
        stringbuilder.append(Character.forDigit((obj2[i] & 0xf0) >> 4, 16));
        stringbuilder.append(Character.forDigit(obj2[i] & 0xf, 16));
        i++;
          goto _L10
        NoSuchAlgorithmException nosuchalgorithmexception1;
        nosuchalgorithmexception1;
          goto _L11
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
          goto _L12
    }

    public static void init(Context context)
    {
        if (proto == null)
        {
            proto = new RTB();
            context = new WebView(context);
            Object obj = context.getSettings();
            ((WebSettings) (obj)).setJavaScriptEnabled(true);
            ((WebSettings) (obj)).setPluginState(android.webkit.WebSettings.PluginState.ON);
            context.setWebChromeClient(new WebChromeClient() {

                public void onProgressChanged(WebView webview, int i)
                {
                    if (i == 100)
                    {
                        webview.loadUrl("javascript:rtb.setUserAgent(navigator.userAgent)");
                    }
                }

            });
            obj = new WebViewRTB();
            ((WebViewRTB) (obj)).setRtb(proto);
            context.addJavascriptInterface(obj, "rtb");
            context.loadData("", "text/html", "utf-8");
        }
    }

    public Ad getAd()
    {
        return ad;
    }

    public String getAdDisplayTime()
    {
        return adDisplayTime;
    }

    public String getAdId()
    {
        return adId;
    }

    public String[] getAppCategories()
    {
        return appCategories;
    }

    public String getAppName()
    {
        return appName;
    }

    public String getAppUrl()
    {
        return appUrl;
    }

    public String getContentDescription()
    {
        return contentDescription;
    }

    public String getContentLanguage()
    {
        return contentLanguage;
    }

    public String getContentTitle()
    {
        return contentTitle;
    }

    public boolean getDnt()
    {
        return dnt;
    }

    public String[] getPageCategories()
    {
        return pageCategories;
    }

    public String getPageTitle()
    {
        return pageTitle;
    }

    public String[] getSectionCategories()
    {
        return sectionCategories;
    }

    public String getUserAge()
    {
        return userAge;
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public String getUserCity()
    {
        return userCity;
    }

    public String getUserCountry()
    {
        return userCountry;
    }

    public String getUserGender()
    {
        return userGender;
    }

    public String getUserMetro()
    {
        return userMetro;
    }

    public String getUserRegion()
    {
        return userRegion;
    }

    public String getUserZip()
    {
        return userZip;
    }

    public boolean hasPrivacyPolicy()
    {
        return hasPrivacyPolicy;
    }

    public boolean isPaid()
    {
        return isPaid;
    }

    public String queryString()
    {
        Object obj;
        String s;
        Object obj1;
        Object obj3;
        obj3 = ad.getDelegate().getAdActivity();
        obj = "u";
        obj1 = ((ConnectivityManager)((Context) (obj3)).getSystemService("connectivity")).getActiveNetworkInfo();
        s = ((String) (obj));
        if (obj1 != null)
        {
            s = ((String) (obj));
            if (((NetworkInfo) (obj1)).getType() == 1)
            {
                s = "wifi";
            }
        }
        obj = "";
        obj1 = "";
        Object obj2 = ((Context) (obj3)).getPackageManager().getPackageInfo(((Context) (obj3)).getPackageName(), 0).versionName;
        obj = obj2;
        String s1 = ((Context) (obj3)).getPackageName();
        obj1 = s1;
        obj = obj2;
_L4:
        boolean flag;
        s1 = Uri.parse(appUrl).getHost();
        obj2 = (TelephonyManager)((Context) (obj3)).getSystemService("phone");
        obj3 = ((TelephonyManager) (obj2)).getNetworkOperatorName();
        String s2 = ((TelephonyManager) (obj2)).getNetworkCountryIso();
        obj2 = new HashMap();
        ((HashMap) (obj2)).putAll(advertisingIdMap());
        ((HashMap) (obj2)).put("br_bundle", obj1);
        ((HashMap) (obj2)).put("br_appname", appName);
        ((HashMap) (obj2)).put("br_propnm", appName);
        ((HashMap) (obj2)).put("br_appurl", appUrl);
        ((HashMap) (obj2)).put("br_appver", obj);
        ((HashMap) (obj2)).put("br_appversion", obj);
        if (s1 != null)
        {
            ((HashMap) (obj2)).put("br_domain", s1);
        }
        ((HashMap) (obj2)).put("br_network", s);
        if (obj3 != null)
        {
            ((HashMap) (obj2)).put("br_carrier", obj3);
        }
        ((HashMap) (obj2)).put("br_carrierctry", s2);
        ((HashMap) (obj2)).put("br_make", Build.MANUFACTURER);
        ((HashMap) (obj2)).put("br_model", Build.MODEL);
        ((HashMap) (obj2)).put("br_os", "Android");
        ((HashMap) (obj2)).put("br_osvers", android.os.Build.VERSION.RELEASE);
        ((HashMap) (obj2)).put("br_language", Locale.getDefault().getLanguage());
        if (hasPrivacyPolicy)
        {
            obj = "y";
        } else
        {
            obj = "n";
        }
        ((HashMap) (obj2)).put("br_privpol", obj);
        ((HashMap) (obj2)).put("br_appcat", TextUtils.join(",", appCategories));
        ((HashMap) (obj2)).put("br_appsect", TextUtils.join(",", sectionCategories));
        ((HashMap) (obj2)).put("br_apppage", TextUtils.join(",", pageCategories));
        if (isPaid)
        {
            obj = "y";
        } else
        {
            obj = "n";
        }
        ((HashMap) (obj2)).put("br_paid", obj);
        if (contentTitle != null)
        {
            ((HashMap) (obj2)).put("br_connm", contentTitle);
        }
        if (pageTitle != null)
        {
            ((HashMap) (obj2)).put("br_pagenm", pageTitle);
        }
        if (userGender != null)
        {
            ((HashMap) (obj2)).put("br_demgen", userGender);
        }
        if (userAge != null)
        {
            ((HashMap) (obj2)).put("br_demage", userAge);
        }
        if (adDisplayTime != null)
        {
            ((HashMap) (obj2)).put("br_stdelay", adDisplayTime);
        }
        if (contentDescription != null)
        {
            ((HashMap) (obj2)).put("br_condes", contentDescription);
        }
        if (contentLanguage != null)
        {
            ((HashMap) (obj2)).put("br_conlang", contentLanguage);
        }
        if (userCountry != null)
        {
            ((HashMap) (obj2)).put("br_demcountry", userCountry);
        }
        if (userRegion != null)
        {
            ((HashMap) (obj2)).put("br_demregion", userRegion);
        }
        if (userMetro != null)
        {
            ((HashMap) (obj2)).put("br_demmetro", userMetro);
        }
        if (userCity != null)
        {
            ((HashMap) (obj2)).put("br_demcity", userCity);
        }
        if (userZip != null)
        {
            ((HashMap) (obj2)).put("br_demzip", userZip);
        }
        if (userAgent != null)
        {
            ((HashMap) (obj2)).put("br_ua", userAgent);
        }
        obj = "";
        flag = true;
        obj1 = ((HashMap) (obj2)).keySet().iterator();
_L2:
        s = ((String) (obj));
        if (!((Iterator) (obj1)).hasNext())
        {
            return s;
        }
        s1 = (String)((Iterator) (obj1)).next();
        obj3 = new StringBuilder(String.valueOf(s));
        if (flag)
        {
            obj = "?";
        } else
        {
            obj = "&";
        }
        obj = ((StringBuilder) (obj3)).append(((String) (obj))).append(s1).append("=").append(URLEncoder.encode((String)((HashMap) (obj2)).get(s1), "UTF-8")).toString();
        flag = false;
        continue; /* Loop/switch isn't completed */
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception = s;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setAd(Ad ad1)
    {
        ad = ad1;
    }

    public void setAdDisplayTime(String s)
    {
        adDisplayTime = s;
    }

    public void setAdId(String s)
    {
        adId = s;
    }

    public void setAndroidId(String s)
    {
        androidId = s;
    }

    public void setAppCategories(String as[])
    {
        appCategories = as;
    }

    public void setAppName(String s)
    {
        appName = s;
    }

    public void setAppUrl(String s)
    {
        appUrl = s;
    }

    public void setContentDescription(String s)
    {
        contentDescription = s;
    }

    public void setContentLanguage(String s)
    {
        contentLanguage = s;
    }

    public void setContentTitle(String s)
    {
        contentTitle = s;
    }

    public void setDnt(boolean flag)
    {
        dnt = flag;
    }

    public void setHasPrivacyPolicy(boolean flag)
    {
        hasPrivacyPolicy = flag;
    }

    public void setPageCategories(String as[])
    {
        pageCategories = as;
    }

    public void setPageTitle(String s)
    {
        pageTitle = s;
    }

    public void setPaid(boolean flag)
    {
        isPaid = flag;
    }

    public void setSectionCategories(String as[])
    {
        sectionCategories = as;
    }

    public void setUserAge(String s)
    {
        userAge = s;
    }

    public void setUserAgent(String s)
    {
        userAgent = s;
    }

    public void setUserCity(String s)
    {
        userCity = s;
    }

    public void setUserCountry(String s)
    {
        userCountry = s;
    }

    public void setUserGender(String s)
    {
        userGender = s;
    }

    public void setUserMetro(String s)
    {
        userMetro = s;
    }

    public void setUserRegion(String s)
    {
        userRegion = s;
    }

    public void setUserZip(String s)
    {
        userZip = s;
    }
}
