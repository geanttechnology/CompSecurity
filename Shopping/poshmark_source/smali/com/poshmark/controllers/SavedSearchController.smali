.class public Lcom/poshmark/controllers/SavedSearchController;
.super Ljava/lang/Object;
.source "SavedSearchController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;
    }
.end annotation


# static fields
.field static globalSavedSearchController:Lcom/poshmark/controllers/SavedSearchController;


# instance fields
.field final VERSION:I

.field dirtyFlag:Z

.field inputStream:Ljava/io/FileInputStream;

.field outputStream:Ljava/io/FileOutputStream;

.field recentSavedQueue:Ljava/util/ArrayDeque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayDeque",
            "<",
            "Lcom/poshmark/data_model/models/SuggestedSearchItem;",
            ">;"
        }
    .end annotation
.end field

.field savedSearchHash:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/poshmark/data_model/models/SuggestedSearchItem;",
            ">;"
        }
    .end annotation
.end field

.field final suggestionsFileName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/controllers/SavedSearchController;->globalSavedSearchController:Lcom/poshmark/controllers/SavedSearchController;

    return-void
.end method

.method constructor <init>()V
    .locals 9

    .prologue
    const/4 v8, 0x1

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput v8, p0, Lcom/poshmark/controllers/SavedSearchController;->VERSION:I

    .line 39
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    iput-object v5, p0, Lcom/poshmark/controllers/SavedSearchController;->savedSearchHash:Ljava/util/Map;

    .line 40
    const/4 v5, 0x0

    iput-boolean v5, p0, Lcom/poshmark/controllers/SavedSearchController;->dirtyFlag:Z

    .line 41
    const-string v5, "savedSuggestions"

    iput-object v5, p0, Lcom/poshmark/controllers/SavedSearchController;->suggestionsFileName:Ljava/lang/String;

    .line 42
    new-instance v5, Ljava/util/ArrayDeque;

    invoke-direct {v5}, Ljava/util/ArrayDeque;-><init>()V

    iput-object v5, p0, Lcom/poshmark/controllers/SavedSearchController;->recentSavedQueue:Ljava/util/ArrayDeque;

    .line 60
    :try_start_0
    iget-object v5, p0, Lcom/poshmark/controllers/SavedSearchController;->inputStream:Ljava/io/FileInputStream;

    if-nez v5, :cond_0

    .line 61
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const-string v6, "savedSuggestions"

    invoke-virtual {v5, v6}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v5

    iput-object v5, p0, Lcom/poshmark/controllers/SavedSearchController;->inputStream:Ljava/io/FileInputStream;

    .line 65
    :cond_0
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 66
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v3

    .line 67
    .local v3, "gson":Lcom/google/gson/Gson;
    new-instance v1, Ljava/io/BufferedReader;

    new-instance v5, Ljava/io/InputStreamReader;

    iget-object v6, p0, Lcom/poshmark/controllers/SavedSearchController;->inputStream:Ljava/io/FileInputStream;

    const-string v7, "UTF-8"

    invoke-direct {v5, v6, v7}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v1, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 68
    .local v1, "br":Ljava/io/BufferedReader;
    const-class v5, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;

    instance-of v6, v3, Lcom/google/gson/Gson;

    if-nez v6, :cond_3

    invoke-virtual {v3, v1, v5}, Lcom/google/gson/Gson;->fromJson(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    .end local v3    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v4, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;

    .line 72
    .local v4, "savedSuggestions":Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;
    if-eqz v4, :cond_1

    iget-object v5, v4, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;->data:Ljava/util/List;

    if-eqz v5, :cond_1

    iget v5, v4, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;->versionCode:I

    const/4 v6, -0x1

    if-eq v5, v6, :cond_1

    iget v5, v4, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;->versionCode:I

    if-ge v5, v8, :cond_2

    .line 73
    :cond_1
    new-instance v4, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;

    .end local v4    # "savedSuggestions":Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;
    invoke-direct {v4, p0}, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;-><init>(Lcom/poshmark/controllers/SavedSearchController;)V

    .line 75
    .restart local v4    # "savedSuggestions":Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;
    :cond_2
    invoke-direct {p0, v4}, Lcom/poshmark/controllers/SavedSearchController;->populateQueue(Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;)V

    .line 83
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v1    # "br":Ljava/io/BufferedReader;
    .end local v4    # "savedSuggestions":Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;
    :goto_1
    return-void

    .line 68
    .restart local v0    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    .restart local v3    # "gson":Lcom/google/gson/Gson;
    :cond_3
    check-cast v3, Lcom/google/gson/Gson;

    .end local v3    # "gson":Lcom/google/gson/Gson;
    invoke-static {v3, v1, v5}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    goto :goto_0

    .line 79
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v1    # "br":Ljava/io/BufferedReader;
    :catch_0
    move-exception v2

    .line 80
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 78
    .end local v2    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v5

    goto :goto_1
.end method

.method public static getGlobalSavedSearchController()Lcom/poshmark/controllers/SavedSearchController;
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lcom/poshmark/controllers/SavedSearchController;->globalSavedSearchController:Lcom/poshmark/controllers/SavedSearchController;

    if-nez v0, :cond_0

    .line 51
    new-instance v0, Lcom/poshmark/controllers/SavedSearchController;

    invoke-direct {v0}, Lcom/poshmark/controllers/SavedSearchController;-><init>()V

    sput-object v0, Lcom/poshmark/controllers/SavedSearchController;->globalSavedSearchController:Lcom/poshmark/controllers/SavedSearchController;

    .line 53
    :cond_0
    sget-object v0, Lcom/poshmark/controllers/SavedSearchController;->globalSavedSearchController:Lcom/poshmark/controllers/SavedSearchController;

    return-object v0
.end method

.method private populateQueue(Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;)V
    .locals 2
    .param p1, "savedSuggestions"    # Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/poshmark/controllers/SavedSearchController;->recentSavedQueue:Ljava/util/ArrayDeque;

    iget-object v1, p1, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;->data:Ljava/util/List;

    invoke-virtual {v0, v1}, Ljava/util/ArrayDeque;->addAll(Ljava/util/Collection;)Z

    .line 87
    return-void
.end method


# virtual methods
.method public clearAll()V
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/poshmark/controllers/SavedSearchController;->savedSearchHash:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 93
    iget-object v0, p0, Lcom/poshmark/controllers/SavedSearchController;->recentSavedQueue:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->clear()V

    .line 94
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/controllers/SavedSearchController;->dirtyFlag:Z

    .line 95
    return-void
.end method

.method public commit()V
    .locals 9

    .prologue
    .line 99
    :try_start_0
    iget-boolean v6, p0, Lcom/poshmark/controllers/SavedSearchController;->dirtyFlag:Z

    if-eqz v6, :cond_1

    .line 100
    iget-object v6, p0, Lcom/poshmark/controllers/SavedSearchController;->outputStream:Ljava/io/FileOutputStream;

    if-nez v6, :cond_0

    .line 101
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    const-string v7, "savedSuggestions"

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v6

    iput-object v6, p0, Lcom/poshmark/controllers/SavedSearchController;->outputStream:Ljava/io/FileOutputStream;

    .line 103
    :cond_0
    new-instance v4, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;

    invoke-direct {v4, p0}, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;-><init>(Lcom/poshmark/controllers/SavedSearchController;)V

    .line 104
    .local v4, "savedSuggestions":Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;
    iget-object v6, v4, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;->data:Ljava/util/List;

    iget-object v7, p0, Lcom/poshmark/controllers/SavedSearchController;->recentSavedQueue:Ljava/util/ArrayDeque;

    invoke-interface {v6, v7}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 105
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 106
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v3

    .line 107
    .local v3, "gson":Lcom/google/gson/Gson;
    new-instance v1, Ljava/io/BufferedWriter;

    new-instance v6, Ljava/io/OutputStreamWriter;

    iget-object v7, p0, Lcom/poshmark/controllers/SavedSearchController;->outputStream:Ljava/io/FileOutputStream;

    const-string v8, "UTF-8"

    invoke-static {v8}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v8

    invoke-virtual {v8}, Ljava/nio/charset/Charset;->newEncoder()Ljava/nio/charset/CharsetEncoder;

    move-result-object v8

    invoke-direct {v6, v7, v8}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/nio/charset/CharsetEncoder;)V

    invoke-direct {v1, v6}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    .line 108
    .local v1, "bw":Ljava/io/BufferedWriter;
    const-class v6, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;

    instance-of v7, v3, Lcom/google/gson/Gson;

    if-nez v7, :cond_2

    invoke-virtual {v3, v4, v6}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v5

    .line 109
    .end local v3    # "gson":Lcom/google/gson/Gson;
    .local v5, "str":Ljava/lang/String;
    :goto_0
    const/4 v6, 0x0

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v7

    invoke-virtual {v1, v5, v6, v7}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;II)V

    .line 110
    invoke-virtual {v1}, Ljava/io/BufferedWriter;->flush()V

    .line 111
    iget-object v6, p0, Lcom/poshmark/controllers/SavedSearchController;->outputStream:Ljava/io/FileOutputStream;

    invoke-virtual {v6}, Ljava/io/FileOutputStream;->close()V

    .line 112
    const/4 v6, 0x0

    iput-object v6, p0, Lcom/poshmark/controllers/SavedSearchController;->outputStream:Ljava/io/FileOutputStream;

    .line 113
    const/4 v6, 0x0

    iput-boolean v6, p0, Lcom/poshmark/controllers/SavedSearchController;->dirtyFlag:Z

    .line 120
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v1    # "bw":Ljava/io/BufferedWriter;
    .end local v4    # "savedSuggestions":Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;
    .end local v5    # "str":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 108
    .restart local v0    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v1    # "bw":Ljava/io/BufferedWriter;
    .restart local v3    # "gson":Lcom/google/gson/Gson;
    .restart local v4    # "savedSuggestions":Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;
    :cond_2
    check-cast v3, Lcom/google/gson/Gson;

    .end local v3    # "gson":Lcom/google/gson/Gson;
    invoke-static {v3, v4, v6}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v5

    goto :goto_0

    .line 115
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v1    # "bw":Ljava/io/BufferedWriter;
    .end local v4    # "savedSuggestions":Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;
    :catch_0
    move-exception v2

    .line 116
    .local v2, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v2}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 117
    .end local v2    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v2

    .line 118
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method

.method public getAllSavedSearches()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/SuggestedSearchItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 123
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 124
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/SuggestedSearchItem;>;"
    iget-object v3, p0, Lcom/poshmark/controllers/SavedSearchController;->recentSavedQueue:Ljava/util/ArrayDeque;

    invoke-virtual {v3}, Ljava/util/ArrayDeque;->size()I

    move-result v3

    if-eqz v3, :cond_0

    .line 125
    iget-object v3, p0, Lcom/poshmark/controllers/SavedSearchController;->recentSavedQueue:Ljava/util/ArrayDeque;

    invoke-virtual {v3}, Ljava/util/ArrayDeque;->descendingIterator()Ljava/util/Iterator;

    move-result-object v0

    .line 126
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/SuggestedSearchItem;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 127
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    .line 128
    .local v2, "suggestion":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 131
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/SuggestedSearchItem;>;"
    .end local v2    # "suggestion":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    :cond_0
    return-object v1
.end method
