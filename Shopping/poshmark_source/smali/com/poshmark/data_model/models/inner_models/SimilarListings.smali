.class public Lcom/poshmark/data_model/models/inner_models/SimilarListings;
.super Lcom/poshmark/data_model/models/inner_models/Feature;
.source "SimilarListings.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/SimilarListings$DeviceType;
    }
.end annotation


# instance fields
.field public mobile:Lcom/poshmark/data_model/models/inner_models/SimilarListings$DeviceType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Lcom/poshmark/data_model/models/inner_models/Feature;-><init>()V

    .line 8
    return-void
.end method
