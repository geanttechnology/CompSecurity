.class public Lcom/poshmark/data_model/models/inner_models/SimilarListings$DeviceType;
.super Ljava/lang/Object;
.source "SimilarListings.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/SimilarListings;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "DeviceType"
.end annotation


# instance fields
.field public count:I

.field public enabled:Z

.field final synthetic this$0:Lcom/poshmark/data_model/models/inner_models/SimilarListings;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/inner_models/SimilarListings;)V
    .locals 0

    .prologue
    .line 8
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/SimilarListings$DeviceType;->this$0:Lcom/poshmark/data_model/models/inner_models/SimilarListings;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
