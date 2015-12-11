.class public Lcom/amazon/mShop/contentprovider/WidgetContentProvider;
.super Landroid/content/ContentProvider;
.source "WidgetContentProvider.java"


# static fields
.field private static final MATRIX:[Ljava/lang/String;

.field private static final sFeaturedMatcher:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final sUriMatcher:Landroid/content/UriMatcher;


# instance fields
.field private mAIVGroverRecommendationsProvider:Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x1

    .line 51
    new-array v0, v4, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "locale"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->MATRIX:[Ljava/lang/String;

    .line 58
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sUriMatcher:Landroid/content/UriMatcher;

    .line 59
    sget-object v0, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sUriMatcher:Landroid/content/UriMatcher;

    const-string/jumbo v1, "com.amazon.mShop.android.WidgetContentProvider"

    const-string/jumbo v2, "featured"

    invoke-virtual {v0, v1, v2, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 60
    sget-object v0, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sUriMatcher:Landroid/content/UriMatcher;

    const-string/jumbo v1, "com.amazon.mShop.android.WidgetContentProvider"

    const-string/jumbo v2, "locale"

    const/4 v3, 0x2

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 61
    sget-object v0, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sUriMatcher:Landroid/content/UriMatcher;

    const-string/jumbo v1, "com.amazon.mShop.android.WidgetContentProvider"

    const-string/jumbo v2, "aiv_featured"

    invoke-virtual {v0, v1, v2, v5}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 63
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sFeaturedMatcher:Ljava/util/Map;

    .line 64
    sget-object v0, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sFeaturedMatcher:Ljava/util/Map;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mshop_shoveler_item"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    sget-object v0, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sFeaturedMatcher:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "aiv_shoveler_item"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    return-void
.end method

.method private getAppendedSelection(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "featuredCategory"    # Ljava/lang/String;
    .param p2, "selection"    # Ljava/lang/String;

    .prologue
    .line 153
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "featuredCategory=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, " AND ("

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v2, 0x29

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 155
    return-object p2

    .line 153
    :cond_0
    const-string/jumbo v0, ""

    goto :goto_0
.end method

.method public static getContentUpdatedIntent()Landroid/content/Intent;
    .locals 3

    .prologue
    .line 166
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 167
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "com.amazon.provider.CONTENT_UPDATE"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 168
    const-string/jumbo v1, "content://com.amazon.mShop.android.WidgetContentProvider"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const-string/jumbo v2, "text/update"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 169
    return-object v0
.end method

.method public static sendContentUpdatedIntent(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 173
    invoke-static {}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->getContentUpdatedIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 174
    return-void
.end method


# virtual methods
.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 70
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 75
    const/4 v0, 0x0

    return-object v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 86
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public onCreate()Z
    .locals 2

    .prologue
    .line 91
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    if-nez v0, :cond_0

    .line 92
    invoke-virtual {p0}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/AmazonApplication;->setUp(Landroid/content/Context;)V

    .line 94
    :cond_0
    new-instance v0, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;

    invoke-virtual {p0}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->mAIVGroverRecommendationsProvider:Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;

    .line 95
    const/4 v0, 0x1

    return v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 21
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 102
    const/16 v20, 0x0

    .line 103
    .local v20, "result":Landroid/database/Cursor;
    sget-object v4, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v18

    .line 104
    .local v18, "match":I
    packed-switch v18, :pswitch_data_0

    .line 126
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "Unknown URI:"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 107
    :pswitch_0
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 108
    .local v3, "database":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    .line 109
    .local v19, "matchedIdx":Ljava/lang/Integer;
    sget-object v4, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sFeaturedMatcher:Ljava/util/Map;

    move-object/from16 v0, v19

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/String;

    .line 110
    .local v17, "featuredCategory":Ljava/lang/String;
    invoke-static/range {v17 .. v17}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    move-object/from16 v6, p3

    .line 112
    .local v6, "appendedSelection":Ljava/lang/String;
    :goto_0
    const-string/jumbo v4, "mShop"

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object/from16 v5, p2

    move-object/from16 v7, p4

    move-object/from16 v10, p5

    invoke-virtual/range {v3 .. v10}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v20

    .line 129
    .end local v3    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .end local v6    # "appendedSelection":Ljava/lang/String;
    .end local v17    # "featuredCategory":Ljava/lang/String;
    .end local v19    # "matchedIdx":Ljava/lang/Integer;
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v14

    .line 134
    .local v14, "applicationContext":Landroid/content/Context;
    const/4 v4, 0x1

    move/from16 v0, v18

    if-ne v0, v4, :cond_1

    if-eqz v20, :cond_0

    invoke-interface/range {v20 .. v20}, Landroid/database/Cursor;->getCount()I

    move-result v4

    if-nez v4, :cond_1

    .line 135
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v4

    sget-object v5, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    if-ne v4, v5, :cond_1

    .line 138
    invoke-static {v14}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v11

    .line 140
    .local v11, "account":Ljava/lang/String;
    invoke-static {v11}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 142
    const/4 v4, 0x0

    const/4 v5, 0x1

    const/4 v7, 0x0

    invoke-static {v14, v4, v5, v11, v7}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;Z)V

    .line 143
    invoke-static {v14}, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->startHomeCall(Landroid/content/Context;)V

    .line 148
    .end local v11    # "account":Ljava/lang/String;
    :cond_1
    return-object v20

    .line 110
    .end local v14    # "applicationContext":Landroid/content/Context;
    .restart local v3    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v17    # "featuredCategory":Ljava/lang/String;
    .restart local v19    # "matchedIdx":Ljava/lang/Integer;
    :cond_2
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p3

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->getAppendedSelection(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 115
    .end local v3    # "database":Landroid/database/sqlite/SQLiteDatabase;
    .end local v17    # "featuredCategory":Ljava/lang/String;
    .end local v19    # "matchedIdx":Ljava/lang/Integer;
    :pswitch_1
    sget-object v4, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sFeaturedMatcher:Ljava/util/Map;

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 116
    .local v13, "aivFeaturedCategory":Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v0, v13, v1}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->getAppendedSelection(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 117
    .local v12, "aivAppendedSelection":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->mAIVGroverRecommendationsProvider:Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    move-object/from16 v2, p5

    invoke-virtual {v4, v0, v12, v1, v2}, Lcom/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider;->getAIVItems([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v20

    .line 118
    goto :goto_1

    .line 120
    .end local v12    # "aivAppendedSelection":Ljava/lang/String;
    .end local v13    # "aivFeaturedCategory":Ljava/lang/String;
    :pswitch_2
    new-instance v15, Landroid/database/MatrixCursor;

    sget-object v4, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->MATRIX:[Ljava/lang/String;

    invoke-direct {v15, v4}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    .line 121
    .local v15, "c":Landroid/database/MatrixCursor;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v16

    .line 122
    .local v16, "currentLocale":Ljava/util/Locale;
    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-virtual/range {v16 .. v16}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    invoke-virtual {v15, v4}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 123
    move-object/from16 v20, v15

    .line 124
    goto :goto_1

    .line 104
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 81
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method
