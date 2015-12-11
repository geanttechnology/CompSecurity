.class public Lcom/poshmark/data_model/models/inner_models/SignupFlowFeature;
.super Ljava/lang/Object;
.source "SignupFlowFeature.java"


# instance fields
.field show_suggested_brands:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/SignupFlowFeature;->show_suggested_brands:Z

    return-void
.end method


# virtual methods
.method public isBrandFollowEnabled()Z
    .locals 1

    .prologue
    .line 9
    iget-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/SignupFlowFeature;->show_suggested_brands:Z

    return v0
.end method
