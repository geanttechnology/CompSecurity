.class abstract Lio/branch/referral/BranchUrlBuilder;
.super Ljava/lang/Object;
.source "BranchUrlBuilder.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lio/branch/referral/BranchUrlBuilder;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected alias_:Ljava/lang/String;

.field protected branchReferral_:Lio/branch/referral/Branch;

.field protected channel_:Ljava/lang/String;

.field private final context_:Landroid/content/Context;

.field protected duration_:I

.field protected feature_:Ljava/lang/String;

.field protected params_:Lorg/json/JSONObject;

.field protected stage_:Ljava/lang/String;

.field protected tags_:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected type_:I


# direct methods
.method protected constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .local p0, "this":Lio/branch/referral/BranchUrlBuilder;, "Lio/branch/referral/BranchUrlBuilder<TT;>;"
    const/4 v0, 0x0

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput v0, p0, Lio/branch/referral/BranchUrlBuilder;->type_:I

    .line 35
    iput v0, p0, Lio/branch/referral/BranchUrlBuilder;->duration_:I

    .line 52
    invoke-static {}, Lio/branch/referral/Branch;->getInstance()Lio/branch/referral/Branch;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->branchReferral_:Lio/branch/referral/Branch;

    .line 53
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->context_:Landroid/content/Context;

    .line 54
    return-void
.end method


# virtual methods
.method public addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 96
    .local p0, "this":Lio/branch/referral/BranchUrlBuilder;, "Lio/branch/referral/BranchUrlBuilder<TT;>;"
    :try_start_0
    iget-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->params_:Lorg/json/JSONObject;

    if-nez v0, :cond_0

    .line 97
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    iput-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->params_:Lorg/json/JSONObject;

    .line 99
    :cond_0
    iget-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->params_:Lorg/json/JSONObject;

    invoke-virtual {v0, p1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 103
    :goto_0
    return-object p0

    .line 100
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public addParameters(Ljava/lang/String;Lorg/json/JSONArray;)Lio/branch/referral/BranchUrlBuilder;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lorg/json/JSONArray;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 108
    .local p0, "this":Lio/branch/referral/BranchUrlBuilder;, "Lio/branch/referral/BranchUrlBuilder<TT;>;"
    :try_start_0
    iget-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->params_:Lorg/json/JSONObject;

    if-nez v0, :cond_0

    .line 109
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    iput-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->params_:Lorg/json/JSONObject;

    .line 111
    :cond_0
    iget-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->params_:Lorg/json/JSONObject;

    invoke-virtual {v0, p1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 115
    :goto_0
    return-object p0

    .line 112
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public addTag(Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 64
    .local p0, "this":Lio/branch/referral/BranchUrlBuilder;, "Lio/branch/referral/BranchUrlBuilder<TT;>;"
    iget-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->tags_:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->tags_:Ljava/util/ArrayList;

    .line 67
    :cond_0
    iget-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->tags_:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 68
    return-object p0
.end method

.method public addTags(Ljava/util/List;)Lio/branch/referral/BranchUrlBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)TT;"
        }
    .end annotation

    .prologue
    .line 79
    .local p0, "this":Lio/branch/referral/BranchUrlBuilder;, "Lio/branch/referral/BranchUrlBuilder<TT;>;"
    .local p1, "tags":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->tags_:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 80
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->tags_:Ljava/util/ArrayList;

    .line 82
    :cond_0
    iget-object v0, p0, Lio/branch/referral/BranchUrlBuilder;->tags_:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 83
    return-object p0
.end method

.method protected generateUrl(Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 12
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;

    .prologue
    .line 132
    .local p0, "this":Lio/branch/referral/BranchUrlBuilder;, "Lio/branch/referral/BranchUrlBuilder<TT;>;"
    iget-object v1, p0, Lio/branch/referral/BranchUrlBuilder;->branchReferral_:Lio/branch/referral/Branch;

    if-eqz v1, :cond_0

    .line 133
    new-instance v0, Lio/branch/referral/ServerRequestCreateUrl;

    iget-object v1, p0, Lio/branch/referral/BranchUrlBuilder;->context_:Landroid/content/Context;

    iget-object v2, p0, Lio/branch/referral/BranchUrlBuilder;->alias_:Ljava/lang/String;

    iget v3, p0, Lio/branch/referral/BranchUrlBuilder;->type_:I

    iget v4, p0, Lio/branch/referral/BranchUrlBuilder;->duration_:I

    iget-object v5, p0, Lio/branch/referral/BranchUrlBuilder;->tags_:Ljava/util/ArrayList;

    iget-object v6, p0, Lio/branch/referral/BranchUrlBuilder;->channel_:Ljava/lang/String;

    iget-object v7, p0, Lio/branch/referral/BranchUrlBuilder;->feature_:Ljava/lang/String;

    iget-object v8, p0, Lio/branch/referral/BranchUrlBuilder;->stage_:Ljava/lang/String;

    iget-object v9, p0, Lio/branch/referral/BranchUrlBuilder;->params_:Lorg/json/JSONObject;

    invoke-static {v9}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v9

    const/4 v11, 0x1

    move-object v10, p1

    invoke-direct/range {v0 .. v11}, Lio/branch/referral/ServerRequestCreateUrl;-><init>(Landroid/content/Context;Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)V

    .line 136
    .local v0, "req":Lio/branch/referral/ServerRequestCreateUrl;
    iget-object v1, p0, Lio/branch/referral/BranchUrlBuilder;->branchReferral_:Lio/branch/referral/Branch;

    invoke-virtual {v1, v0}, Lio/branch/referral/Branch;->generateShortLinkInternal(Lio/branch/referral/ServerRequestCreateUrl;)Ljava/lang/String;

    .line 143
    .end local v0    # "req":Lio/branch/referral/ServerRequestCreateUrl;
    :goto_0
    return-void

    .line 138
    :cond_0
    if-eqz p1, :cond_1

    .line 139
    const/4 v1, 0x0

    new-instance v2, Lio/branch/referral/BranchError;

    const-string v3, "session has not been initialized"

    const/16 v4, -0x65

    invoke-direct {v2, v3, v4}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {p1, v1, v2}, Lio/branch/referral/Branch$BranchLinkCreateListener;->onLinkCreate(Ljava/lang/String;Lio/branch/referral/BranchError;)V

    .line 141
    :cond_1
    const-string v1, "BranchSDK"

    const-string v2, "Branch Warning: User session has not been initialized"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected getUrl()Ljava/lang/String;
    .locals 13

    .prologue
    .line 121
    .local p0, "this":Lio/branch/referral/BranchUrlBuilder;, "Lio/branch/referral/BranchUrlBuilder<TT;>;"
    const/4 v12, 0x0

    .line 122
    .local v12, "shortUrl":Ljava/lang/String;
    iget-object v1, p0, Lio/branch/referral/BranchUrlBuilder;->branchReferral_:Lio/branch/referral/Branch;

    if-eqz v1, :cond_0

    .line 123
    new-instance v0, Lio/branch/referral/ServerRequestCreateUrl;

    iget-object v1, p0, Lio/branch/referral/BranchUrlBuilder;->context_:Landroid/content/Context;

    iget-object v2, p0, Lio/branch/referral/BranchUrlBuilder;->alias_:Ljava/lang/String;

    iget v3, p0, Lio/branch/referral/BranchUrlBuilder;->type_:I

    iget v4, p0, Lio/branch/referral/BranchUrlBuilder;->duration_:I

    iget-object v5, p0, Lio/branch/referral/BranchUrlBuilder;->tags_:Ljava/util/ArrayList;

    iget-object v6, p0, Lio/branch/referral/BranchUrlBuilder;->channel_:Ljava/lang/String;

    iget-object v7, p0, Lio/branch/referral/BranchUrlBuilder;->feature_:Ljava/lang/String;

    iget-object v8, p0, Lio/branch/referral/BranchUrlBuilder;->stage_:Ljava/lang/String;

    iget-object v9, p0, Lio/branch/referral/BranchUrlBuilder;->params_:Lorg/json/JSONObject;

    invoke-static {v9}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-direct/range {v0 .. v11}, Lio/branch/referral/ServerRequestCreateUrl;-><init>(Landroid/content/Context;Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)V

    .line 126
    .local v0, "req":Lio/branch/referral/ServerRequestCreateUrl;
    iget-object v1, p0, Lio/branch/referral/BranchUrlBuilder;->branchReferral_:Lio/branch/referral/Branch;

    invoke-virtual {v1, v0}, Lio/branch/referral/Branch;->generateShortLinkInternal(Lio/branch/referral/ServerRequestCreateUrl;)Ljava/lang/String;

    move-result-object v12

    .line 128
    .end local v0    # "req":Lio/branch/referral/ServerRequestCreateUrl;
    :cond_0
    return-object v12
.end method
