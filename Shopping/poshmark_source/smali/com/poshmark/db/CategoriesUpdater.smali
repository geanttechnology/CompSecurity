.class public Lcom/poshmark/db/CategoriesUpdater;
.super Landroid/os/AsyncTask;
.source "CategoriesUpdater.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field clearAllRows:Z

.field data:Lcom/poshmark/data_model/models/Catalog;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/Catalog;Z)V
    .locals 1
    .param p1, "allCategories"    # Lcom/poshmark/data_model/models/Catalog;
    .param p2, "clearAllRows"    # Z

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/db/CategoriesUpdater;->clearAllRows:Z

    .line 30
    iput-boolean p2, p0, Lcom/poshmark/db/CategoriesUpdater;->clearAllRows:Z

    .line 31
    iput-object p1, p0, Lcom/poshmark/db/CategoriesUpdater;->data:Lcom/poshmark/data_model/models/Catalog;

    .line 32
    return-void
.end method

.method private bulkInsertAllCategoryInfo(Lcom/poshmark/data_model/models/Catalog;)V
    .locals 8
    .param p1, "categoryData"    # Lcom/poshmark/data_model/models/Catalog;

    .prologue
    .line 79
    if-eqz p1, :cond_2

    .line 80
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/Catalog;->getCategoryList()Ljava/util/List;

    move-result-object v0

    .line 81
    .local v0, "categories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Catalog$Entry;>;"
    if-eqz v0, :cond_2

    .line 82
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    .line 83
    .local v3, "size":I
    new-array v5, v3, [Landroid/content/ContentValues;

    .line 84
    .local v5, "valuesArray":[Landroid/content/ContentValues;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v3, :cond_0

    .line 85
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/Catalog$Entry;

    .line 86
    .local v1, "category":Lcom/poshmark/data_model/models/Catalog$Entry;
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 87
    .local v4, "values":Landroid/content/ContentValues;
    const-string v6, "_id"

    iget-object v7, v1, Lcom/poshmark/data_model/models/Catalog$Entry;->id:Ljava/lang/String;

    invoke-virtual {v4, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    const-string v6, "canonical_name"

    iget-object v7, v1, Lcom/poshmark/data_model/models/Catalog$Entry;->display:Ljava/lang/String;

    invoke-virtual {v4, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    aput-object v4, v5, v2

    .line 84
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 91
    .end local v1    # "category":Lcom/poshmark/data_model/models/Catalog$Entry;
    .end local v4    # "values":Landroid/content/ContentValues;
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    sget-object v7, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    invoke-virtual {v6, v7, v5}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    .line 96
    const/4 v2, 0x0

    :goto_1
    if-ge v2, v3, :cond_1

    .line 97
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/Catalog$Entry;

    .line 98
    .restart local v1    # "category":Lcom/poshmark/data_model/models/Catalog$Entry;
    iget-object v6, v1, Lcom/poshmark/data_model/models/Catalog$Entry;->sizes:Ljava/util/List;

    iget-object v7, v1, Lcom/poshmark/data_model/models/Catalog$Entry;->id:Ljava/lang/String;

    invoke-direct {p0, v6, v7}, Lcom/poshmark/db/CategoriesUpdater;->insertSizesForCategory(Ljava/util/List;Ljava/lang/String;)V

    .line 99
    iget-object v6, v1, Lcom/poshmark/data_model/models/Catalog$Entry;->category_features:Ljava/util/List;

    iget-object v7, v1, Lcom/poshmark/data_model/models/Catalog$Entry;->id:Ljava/lang/String;

    invoke-direct {p0, v6, v7}, Lcom/poshmark/db/CategoriesUpdater;->insertStyleTagsForCategory(Ljava/util/List;Ljava/lang/String;)V

    .line 96
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 102
    .end local v1    # "category":Lcom/poshmark/data_model/models/Catalog$Entry;
    :cond_1
    iget-object v6, p1, Lcom/poshmark/data_model/models/Catalog;->colors:Ljava/util/List;

    invoke-direct {p0, v6}, Lcom/poshmark/db/CategoriesUpdater;->insertColors(Ljava/util/List;)V

    .line 104
    const-string v6, "category"

    iget-object v7, p1, Lcom/poshmark/data_model/models/Catalog;->updated_at:Ljava/lang/String;

    invoke-virtual {p0, v6, v7}, Lcom/poshmark/db/CategoriesUpdater;->updateTimeStamp(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    .end local v0    # "categories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Catalog$Entry;>;"
    .end local v2    # "i":I
    .end local v3    # "size":I
    .end local v5    # "valuesArray":[Landroid/content/ContentValues;
    :cond_2
    return-void
.end method

.method private insertColors(Ljava/util/List;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 110
    .local p1, "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    if-eqz p1, :cond_1

    .line 111
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    .line 112
    .local v2, "size":I
    new-array v4, v2, [Landroid/content/ContentValues;

    .line 113
    .local v4, "valuesArray":[Landroid/content/ContentValues;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 114
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PMColor;

    .line 115
    .local v0, "color":Lcom/poshmark/data_model/models/PMColor;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 116
    .local v3, "values":Landroid/content/ContentValues;
    const-string v5, "_id"

    iget-object v6, v0, Lcom/poshmark/data_model/models/PMColor;->name:Ljava/lang/String;

    invoke-virtual {v3, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    const-string v5, "rgb"

    iget-object v6, v0, Lcom/poshmark/data_model/models/PMColor;->rgb:Ljava/lang/String;

    invoke-virtual {v3, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    aput-object v3, v4, v1

    .line 113
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 120
    .end local v0    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v3    # "values":Landroid/content/ContentValues;
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    sget-object v6, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_COLORS:Landroid/net/Uri;

    invoke-virtual {v5, v6, v4}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    .line 122
    .end local v1    # "i":I
    .end local v2    # "size":I
    .end local v4    # "valuesArray":[Landroid/content/ContentValues;
    :cond_1
    return-void
.end method

.method private insertSizesForCategory(Ljava/util/List;Ljava/lang/String;)V
    .locals 7
    .param p2, "categoryId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Catalog$Size;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 141
    .local p1, "sizesForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Catalog$Size;>;"
    if-eqz p1, :cond_1

    .line 142
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    .line 143
    .local v1, "size":I
    new-array v4, v1, [Landroid/content/ContentValues;

    .line 144
    .local v4, "valuesArray":[Landroid/content/ContentValues;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 145
    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/Catalog$Size;

    .line 146
    .local v2, "sizeEntry":Lcom/poshmark/data_model/models/Catalog$Size;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 147
    .local v3, "values":Landroid/content/ContentValues;
    const-string v5, "_id"

    invoke-virtual {v3, v5, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    const-string v5, "short_name"

    iget-object v6, v2, Lcom/poshmark/data_model/models/Catalog$Size;->shortName:Ljava/lang/String;

    invoke-virtual {v3, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    const-string v5, "long_name"

    iget-object v6, v2, Lcom/poshmark/data_model/models/Catalog$Size;->longName:Ljava/lang/String;

    invoke-virtual {v3, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    aput-object v3, v4, v0

    .line 144
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 152
    .end local v2    # "sizeEntry":Lcom/poshmark/data_model/models/Catalog$Size;
    .end local v3    # "values":Landroid/content/ContentValues;
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    sget-object v6, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_SIZES:Landroid/net/Uri;

    invoke-virtual {v5, v6, v4}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    .line 154
    .end local v0    # "i":I
    .end local v1    # "size":I
    .end local v4    # "valuesArray":[Landroid/content/ContentValues;
    :cond_1
    return-void
.end method

.method private insertStyleTagsForCategory(Ljava/util/List;Ljava/lang/String;)V
    .locals 7
    .param p2, "categoryId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Catalog$Entry;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 125
    .local p1, "child_entries":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Catalog$Entry;>;"
    if-eqz p1, :cond_1

    .line 126
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    .line 127
    .local v2, "size":I
    new-array v4, v2, [Landroid/content/ContentValues;

    .line 128
    .local v4, "valuesArray":[Landroid/content/ContentValues;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 129
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Catalog$Entry;

    .line 130
    .local v0, "entry":Lcom/poshmark/data_model/models/Catalog$Entry;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 131
    .local v3, "values":Landroid/content/ContentValues;
    const-string v5, "_id"

    iget-object v6, v0, Lcom/poshmark/data_model/models/Catalog$Entry;->id:Ljava/lang/String;

    invoke-virtual {v3, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    const-string v5, "name"

    iget-object v6, v0, Lcom/poshmark/data_model/models/Catalog$Entry;->display:Ljava/lang/String;

    invoke-virtual {v3, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    const-string v5, "category_id"

    invoke-virtual {v3, v5, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    aput-object v3, v4, v1

    .line 128
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 136
    .end local v0    # "entry":Lcom/poshmark/data_model/models/Catalog$Entry;
    .end local v3    # "values":Landroid/content/ContentValues;
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    sget-object v6, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_STYLE_TAGS:Landroid/net/Uri;

    invoke-virtual {v5, v6, v4}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    .line 138
    .end local v1    # "i":I
    .end local v2    # "size":I
    .end local v4    # "valuesArray":[Landroid/content/ContentValues;
    :cond_1
    return-void
.end method

.method private populateDb(Lcom/poshmark/data_model/models/Catalog;)V
    .locals 14
    .param p1, "categoryData"    # Lcom/poshmark/data_model/models/Catalog;

    .prologue
    const/4 v3, 0x0

    .line 56
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    const-string v4, " SELECT * from category"

    move-object v5, v3

    move-object v6, v3

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 57
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_1

    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_1

    .line 58
    if-nez p1, :cond_0

    .line 60
    new-instance v7, Lcom/google/gson/GsonBuilder;

    invoke-direct {v7}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 61
    .local v7, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v7}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v12

    .line 63
    .local v12, "gson":Lcom/google/gson/Gson;
    :try_start_0
    const-string v11, "listing_meta/categories.json"

    .line 64
    .local v11, "fileName":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v1

    invoke-virtual {v1, v11}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v13

    .line 65
    .local v13, "ip":Ljava/io/InputStream;
    new-instance v8, Ljava/io/BufferedReader;

    new-instance v1, Ljava/io/InputStreamReader;

    const-string v2, "UTF-8"

    invoke-direct {v1, v13, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v8, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 66
    .local v8, "buffered":Ljava/io/BufferedReader;
    const-class v1, Lcom/poshmark/data_model/models/Catalog;

    instance-of v2, v12, Lcom/google/gson/Gson;

    if-nez v2, :cond_2

    invoke-virtual {v12, v8, v1}, Lcom/google/gson/Gson;->fromJson(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    .end local v12    # "gson":Lcom/google/gson/Gson;
    :goto_0
    move-object v0, v1

    check-cast v0, Lcom/poshmark/data_model/models/Catalog;

    move-object p1, v0
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 74
    .end local v7    # "b":Lcom/google/gson/GsonBuilder;
    .end local v8    # "buffered":Ljava/io/BufferedReader;
    .end local v11    # "fileName":Ljava/lang/String;
    .end local v13    # "ip":Ljava/io/InputStream;
    :cond_0
    :goto_1
    invoke-direct {p0, p1}, Lcom/poshmark/db/CategoriesUpdater;->bulkInsertAllCategoryInfo(Lcom/poshmark/data_model/models/Catalog;)V

    .line 76
    :cond_1
    return-void

    .line 66
    .restart local v7    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v8    # "buffered":Ljava/io/BufferedReader;
    .restart local v11    # "fileName":Ljava/lang/String;
    .restart local v12    # "gson":Lcom/google/gson/Gson;
    .restart local v13    # "ip":Ljava/io/InputStream;
    :cond_2
    :try_start_1
    check-cast v12, Lcom/google/gson/Gson;

    .end local v12    # "gson":Lcom/google/gson/Gson;
    invoke-static {v12, v8, v1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v1

    goto :goto_0

    .line 67
    .end local v8    # "buffered":Ljava/io/BufferedReader;
    .end local v11    # "fileName":Ljava/lang/String;
    .end local v13    # "ip":Ljava/io/InputStream;
    :catch_0
    move-exception v10

    .line 68
    .local v10, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v10}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 69
    .end local v10    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v10

    .line 70
    .local v10, "e":Ljava/io/IOException;
    invoke-virtual {v10}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/db/CategoriesUpdater;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/db/CategoriesUpdater;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "CategoriesUpdater#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 24
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/db/CategoriesUpdater;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "CategoriesUpdater#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 6
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v5, 0x0

    .line 40
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalDbController;->getMutex()Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 41
    :try_start_0
    iget-boolean v0, p0, Lcom/poshmark/db/CategoriesUpdater;->clearAllRows:Z

    if-eqz v0, :cond_0

    .line 44
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 45
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_SIZES:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 46
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_STYLE_TAGS:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 47
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_STYLE_TAGS:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 48
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_COLORS:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 50
    :cond_0
    iget-object v0, p0, Lcom/poshmark/db/CategoriesUpdater;->data:Lcom/poshmark/data_model/models/Catalog;

    invoke-direct {p0, v0}, Lcom/poshmark/db/CategoriesUpdater;->populateDb(Lcom/poshmark/data_model/models/Catalog;)V

    .line 51
    monitor-exit v1

    .line 52
    return-object v5

    .line 51
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 36
    return-void
.end method

.method public updateTimeStamp(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "timestamp"    # Ljava/lang/String;

    .prologue
    .line 158
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    const-string v3, "tag=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 160
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 161
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "last_update_dtm"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    const-string v1, "tag"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 164
    return-void
.end method
