.class public Lcom/bestbuy/android/providers/SuggestionProvider;
.super Landroid/content/SearchRecentSuggestionsProvider;
.source "SourceFile"


# static fields
.field private static a:Landroid/net/Uri;

.field private static b:Landroid/net/Uri;

.field private static c:Landroid/net/Uri;

.field private static d:Landroid/net/Uri;

.field private static final f:[Ljava/lang/String;


# instance fields
.field private e:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 38
    const-string v0, "content://com.bestbuy.android.SuggestionProvider/suggestions"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/providers/SuggestionProvider;->a:Landroid/net/Uri;

    .line 40
    const-string v0, "content://com.bestbuy.android.SuggestionProvider/storesearchsuggestions"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/providers/SuggestionProvider;->b:Landroid/net/Uri;

    .line 42
    const-string v0, "content://com.bestbuy.android.SuggestionProvider/listidsearchsuggestions"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/providers/SuggestionProvider;->c:Landroid/net/Uri;

    .line 44
    const-string v0, "content://com.bestbuy.android.SuggestionProvider/dnmsearchsuggestions"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/providers/SuggestionProvider;->d:Landroid/net/Uri;

    .line 56
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "suggest_text_1"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "suggest_intent_data"

    aput-object v2, v0, v1

    sput-object v0, Lcom/bestbuy/android/providers/SuggestionProvider;->f:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 60
    invoke-direct {p0}, Landroid/content/SearchRecentSuggestionsProvider;-><init>()V

    .line 61
    const-string v0, "com.bestbuy.android.SuggestionProvider"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/providers/SuggestionProvider;->setupSuggestions(Ljava/lang/String;I)V

    .line 62
    return-void
.end method

.method public static synthetic a(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 0

    .prologue
    .line 35
    invoke-static {p0}, Lcom/bestbuy/android/providers/SuggestionProvider;->b(Landroid/database/sqlite/SQLiteDatabase;)V

    return-void
.end method

.method private static b(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 3

    .prologue
    .line 199
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 200
    const-string v0, "display1"

    const-string v2, "Product Scan"

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    const-string v0, "query"

    const-string v2, "ProductScan"

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    const-string v0, "icon"

    const-string v2, "android.resource://com.bestbuy.android/2130837857"

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    const-string v0, "date"

    const-string v2, "9999999999999"

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    sget-object v0, Lcom/bestbuy/android/providers/SuggestionProvider;->a:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 209
    const-string v2, "suggestions"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 210
    const-string v0, "suggestions"

    const-string v2, "query"

    invoke-virtual {p0, v0, v2, v1}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 212
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 75
    const-string v0, "ProductScan"

    invoke-virtual {p2, v0}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_0

    .line 76
    new-instance v0, Lmz;

    const/16 v1, 0x201

    invoke-direct {v0, p1, v1}, Lmz;-><init>(Landroid/content/Context;I)V

    .line 78
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteOpenHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 80
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 81
    const-string v0, "display1"

    invoke-virtual {v2, v0, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    const-string v0, "query"

    invoke-virtual {v2, v0, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    const-string v0, "icon"

    const-string v3, "android.resource://com.bestbuy.android/2130837884"

    invoke-virtual {v2, v0, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    const-string v0, "date"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 89
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    .line 91
    sget-boolean v3, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-eqz v3, :cond_1

    .line 92
    sget-object v0, Lcom/bestbuy/android/providers/SuggestionProvider;->b:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 94
    const-string v3, "storesearchsuggestions"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 95
    const-string v0, "storesearchsuggestions"

    const-string v3, "query"

    invoke-virtual {v1, v0, v3, v2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 114
    :cond_0
    :goto_0
    return-void

    .line 97
    :cond_1
    invoke-virtual {v0}, Lnb;->Q()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 98
    sget-object v0, Lcom/bestbuy/android/providers/SuggestionProvider;->d:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 99
    const-string v3, "dnmsearchsuggestions"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 100
    const-string v0, "dnmsearchsuggestions"

    const-string v3, "query"

    invoke-virtual {v1, v0, v3, v2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_0

    .line 102
    :cond_2
    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inListIdSearchFragment:Z

    if-eqz v0, :cond_3

    .line 103
    sget-object v0, Lcom/bestbuy/android/providers/SuggestionProvider;->d:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 104
    const-string v3, "listidsearchsuggestions"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 105
    const-string v0, "listidsearchsuggestions"

    const-string v3, "query"

    invoke-virtual {v1, v0, v3, v2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_0

    .line 108
    :cond_3
    sget-object v0, Lcom/bestbuy/android/providers/SuggestionProvider;->a:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 109
    const-string v3, "suggestions"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    const-string v0, "suggestions"

    const-string v3, "query"

    invoke-virtual {v1, v0, v3, v2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 6

    .prologue
    const/4 v1, 0x0

    const/4 v5, 0x1

    const/4 v0, 0x0

    .line 130
    new-instance v2, Lmz;

    invoke-virtual {p0}, Lcom/bestbuy/android/providers/SuggestionProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    const/16 v4, 0x201

    invoke-direct {v2, v3, v4}, Lmz;-><init>(Landroid/content/Context;I)V

    .line 132
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteOpenHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 133
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v3

    .line 136
    aget-object v4, p4, v0

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 138
    const-string v0, ""

    .line 140
    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-eqz v0, :cond_0

    .line 141
    const-string v0, "storesearchsuggestions"

    .line 148
    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "SELECT _id, display1 AS suggest_text_1, query AS suggest_intent_query,  icon AS suggest_icon_1 FROM "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " ORDER BY date DESC"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 152
    invoke-virtual {v2, v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 153
    invoke-virtual {p0}, Lcom/bestbuy/android/providers/SuggestionProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 195
    :goto_1
    return-object v0

    .line 142
    :cond_0
    invoke-virtual {v3}, Lnb;->Q()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 143
    const-string v0, "dnmsearchsuggestions"

    goto :goto_0

    .line 144
    :cond_1
    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inListIdSearchFragment:Z

    if-eqz v0, :cond_2

    .line 145
    const-string v0, "listidsearchsuggestions"

    goto :goto_0

    .line 147
    :cond_2
    const-string v0, "suggestions"

    goto :goto_0

    .line 155
    :cond_3
    sget-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-nez v2, :cond_6

    invoke-virtual {v3}, Lnb;->Q()Z

    move-result v2

    if-nez v2, :cond_6

    .line 156
    aget-object v2, p4, v0

    if-eqz v2, :cond_4

    .line 158
    aget-object v2, p4, v0

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    aput-object v2, p4, v0

    .line 161
    aget-object v2, p4, v0

    const-string v3, "\\s+"

    const-string v4, " "

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, p4, v0

    .line 164
    :cond_4
    aget-object v2, p4, v0

    if-eqz v2, :cond_6

    aget-object v2, p4, v0

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_6

    aget-object v2, p4, v0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-le v2, v5, :cond_6

    .line 166
    new-instance v2, Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "%"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    aget-object v4, p4, v0

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "%"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 168
    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_6

    const-string v3, "% %"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_6

    .line 169
    new-array v1, v5, [Ljava/lang/String;

    aput-object v2, v1, v0

    .line 170
    new-instance v1, Landroid/database/MatrixCursor;

    sget-object v2, Lcom/bestbuy/android/providers/SuggestionProvider;->f:[Ljava/lang/String;

    invoke-direct {v1, v2}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    .line 172
    :try_start_0
    sget-object v2, Lft;->a:Lft;

    const/4 v3, 0x0

    aget-object v3, p4, v3

    invoke-static {v2, v3}, Lfs;->a(Lft;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/providers/SuggestionProvider;->e:Ljava/util/ArrayList;

    .line 175
    iget-object v2, p0, Lcom/bestbuy/android/providers/SuggestionProvider;->e:Ljava/util/ArrayList;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/bestbuy/android/providers/SuggestionProvider;->e:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_5

    move v2, v0

    .line 177
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/providers/SuggestionProvider;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v2, v0, :cond_5

    .line 178
    const/4 v0, 0x3

    new-array v3, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v4, 0x1

    iget-object v0, p0, Lcom/bestbuy/android/providers/SuggestionProvider;->e:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v3, v4

    const/4 v4, 0x2

    iget-object v0, p0, Lcom/bestbuy/android/providers/SuggestionProvider;->e:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v3, v4

    .line 181
    invoke-virtual {v1, v3}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 177
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_2

    .line 185
    :catch_0
    move-exception v0

    .line 186
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 188
    :cond_5
    invoke-virtual {p0}, Lcom/bestbuy/android/providers/SuggestionProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-virtual {v1, v0, p1}, Landroid/database/MatrixCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    move-object v0, v1

    .line 190
    goto/16 :goto_1

    :cond_6
    move-object v0, v1

    goto/16 :goto_1
.end method
