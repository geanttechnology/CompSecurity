.class public Lcom/poshmark/data_model/models/inner_models/AutoCompleteFeature;
.super Lcom/poshmark/data_model/models/inner_models/Feature;
.source "AutoCompleteFeature.java"


# instance fields
.field enabled:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 6
    invoke-direct {p0}, Lcom/poshmark/data_model/models/inner_models/Feature;-><init>()V

    .line 7
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/AutoCompleteFeature;->enabled:Z

    return-void
.end method


# virtual methods
.method public isEnabled()Z
    .locals 1

    .prologue
    .line 10
    iget-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/AutoCompleteFeature;->enabled:Z

    return v0
.end method
