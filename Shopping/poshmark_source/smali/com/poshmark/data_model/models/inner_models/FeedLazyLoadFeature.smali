.class public Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;
.super Lcom/poshmark/data_model/models/inner_models/Feature;
.source "FeedLazyLoadFeature.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;
    }
.end annotation


# instance fields
.field android:Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Lcom/poshmark/data_model/models/inner_models/Feature;-><init>()V

    .line 26
    return-void
.end method


# virtual methods
.method public geBubbleDisplayIntervalInSeconds()I
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;->android:Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;->bubble_display_interval:I

    return v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;->android:Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;->title:Ljava/lang/String;

    return-object v0
.end method

.method public isEnabled()Z
    .locals 1

    .prologue
    .line 11
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;->android:Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;

    if-nez v0, :cond_0

    .line 12
    const/4 v0, 0x0

    .line 14
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;->android:Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature$Feature;->enabled:Z

    goto :goto_0
.end method
