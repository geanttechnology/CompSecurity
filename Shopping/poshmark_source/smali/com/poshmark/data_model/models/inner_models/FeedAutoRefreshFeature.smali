.class public Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;
.super Ljava/lang/Object;
.source "FeedAutoRefreshFeature.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature$Feature;
    }
.end annotation


# instance fields
.field android:Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature$Feature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method


# virtual methods
.method public geAutoRefreshIntervalInSeconds()I
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;->android:Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature$Feature;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature$Feature;->auto_refresh_interval:I

    return v0
.end method

.method public isEnabled()Z
    .locals 1

    .prologue
    .line 10
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;->android:Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature$Feature;

    if-nez v0, :cond_0

    .line 11
    const/4 v0, 0x0

    .line 13
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;->android:Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature$Feature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature$Feature;->enabled:Z

    goto :goto_0
.end method
