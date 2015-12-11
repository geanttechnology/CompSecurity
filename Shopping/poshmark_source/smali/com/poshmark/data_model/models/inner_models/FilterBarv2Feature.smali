.class public Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature;
.super Lcom/poshmark/data_model/models/inner_models/Feature;
.source "FilterBarv2Feature.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature$Feature;
    }
.end annotation


# instance fields
.field android:Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature$Feature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Lcom/poshmark/data_model/models/inner_models/Feature;-><init>()V

    .line 16
    return-void
.end method


# virtual methods
.method public isEnabled()Z
    .locals 1

    .prologue
    .line 10
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature;->android:Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature$Feature;

    if-nez v0, :cond_0

    .line 11
    const/4 v0, 0x0

    .line 13
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature;->android:Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature$Feature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature$Feature;->enabled:Z

    goto :goto_0
.end method
